package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.autosms.myapplicationcallevent.DBHelper;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmq;
import com.google.android.gms.internal.zzmt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleSignInAccount implements SafeParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new zzb();
    public static zzmq zzWO = zzmt.zzsc();
    private static Comparator<Scope> zzWV = new Comparator<Scope>() {
        /* renamed from: zza */
        public int compare(Scope scope, Scope scope2) {
            return scope.zzpb().compareTo(scope2.zzpb());
        }
    };
    final int versionCode;
    List<Scope> zzVs;
    private String zzWP;
    private String zzWQ;
    private Uri zzWR;
    private String zzWS;
    private long zzWT;
    private String zzWU;
    private String zzWk;
    private String zzyv;

    GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list) {
        this.versionCode = i;
        this.zzyv = str;
        this.zzWk = str2;
        this.zzWP = str3;
        this.zzWQ = str4;
        this.zzWR = uri;
        this.zzWS = str5;
        this.zzWT = j;
        this.zzWU = str6;
        this.zzVs = list;
    }

    public static GoogleSignInAccount zza(String str, String str2, String str3, String str4, Uri uri, Long l, String str5, Set<Scope> set) {
        return new GoogleSignInAccount(2, str, str2, str3, str4, uri, (String) null, (l == null ? Long.valueOf(zzWO.currentTimeMillis() / 1000) : l).longValue(), zzx.zzcM(str5), new ArrayList((Collection) zzx.zzz(set)));
    }

    public static GoogleSignInAccount zzbH(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", (String) null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        return zza(jSONObject.optString(DBHelper.CONTACTS_COLUMN_ID), jSONObject.optString("tokenId", (String) null), jSONObject.optString("email", (String) null), jSONObject.optString("displayName", (String) null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet).zzbI(jSONObject.optString("serverAuthCode", (String) null));
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (getId() != null) {
                jSONObject.put(DBHelper.CONTACTS_COLUMN_ID, getId());
            }
            if (getIdToken() != null) {
                jSONObject.put("tokenId", getIdToken());
            }
            if (getEmail() != null) {
                jSONObject.put("email", getEmail());
            }
            if (getDisplayName() != null) {
                jSONObject.put("displayName", getDisplayName());
            }
            if (getPhotoUrl() != null) {
                jSONObject.put("photoUrl", getPhotoUrl().toString());
            }
            if (getServerAuthCode() != null) {
                jSONObject.put("serverAuthCode", getServerAuthCode());
            }
            jSONObject.put("expirationTime", this.zzWT);
            jSONObject.put("obfuscatedIdentifier", zzmL());
            JSONArray jSONArray = new JSONArray();
            Collections.sort(this.zzVs, zzWV);
            for (Scope zzpb : this.zzVs) {
                jSONArray.put(zzpb.zzpb());
            }
            jSONObject.put("grantedScopes", jSONArray);
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        return ((GoogleSignInAccount) obj).zzmI().equals(zzmI());
    }

    public String getDisplayName() {
        return this.zzWQ;
    }

    public String getEmail() {
        return this.zzWP;
    }

    public Set<Scope> getGrantedScopes() {
        return new HashSet(this.zzVs);
    }

    public String getId() {
        return this.zzyv;
    }

    public String getIdToken() {
        return this.zzWk;
    }

    public Uri getPhotoUrl() {
        return this.zzWR;
    }

    public String getServerAuthCode() {
        return this.zzWS;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    public boolean zzb() {
        return zzWO.currentTimeMillis() / 1000 >= this.zzWT - 300;
    }

    public GoogleSignInAccount zzbI(String str) {
        this.zzWS = str;
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public long zzmK() {
        return this.zzWT;
    }

    public String zzmL() {
        return this.zzWU;
    }

    public String zzmM() {
        JSONObject zzmJ = zzmJ();
        zzmJ.remove("serverAuthCode");
        return zzmJ.toString();
    }
}
