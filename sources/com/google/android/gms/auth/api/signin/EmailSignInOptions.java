package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Patterns;
import com.google.android.gms.auth.api.signin.internal.zze;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public class EmailSignInOptions implements SafeParcelable {
    public static final Parcelable.Creator<EmailSignInOptions> CREATOR = new zza();
    final int versionCode;
    private final Uri zzWL;
    private String zzWM;
    private Uri zzWN;

    EmailSignInOptions(int i, Uri uri, String str, Uri uri2) {
        zzx.zzb(uri, (Object) "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzh(uri.toString(), "Server widget url cannot be null in order to use email/password sign in.");
        zzx.zzb(Patterns.WEB_URL.matcher(uri.toString()).matches(), (Object) "Invalid server widget url");
        this.versionCode = i;
        this.zzWL = uri;
        this.zzWM = str;
        this.zzWN = uri2;
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("serverWidgetUrl", this.zzWL.toString());
            if (!TextUtils.isEmpty(this.zzWM)) {
                jSONObject.put("modeQueryName", this.zzWM);
            }
            Uri uri = this.zzWN;
            if (uri != null) {
                jSONObject.put("tosUrl", uri.toString());
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            EmailSignInOptions emailSignInOptions = (EmailSignInOptions) obj;
            if (!this.zzWL.equals(emailSignInOptions.zzmF())) {
                return false;
            }
            Uri uri = this.zzWN;
            if (uri == null) {
                if (emailSignInOptions.zzmG() != null) {
                    return false;
                }
            } else if (!uri.equals(emailSignInOptions.zzmG())) {
                return false;
            }
            if (!TextUtils.isEmpty(this.zzWM)) {
                return this.zzWM.equals(emailSignInOptions.zzmH());
            }
            if (!TextUtils.isEmpty(emailSignInOptions.zzmH())) {
                return false;
            }
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().zzp(this.zzWL).zzp(this.zzWN).zzp(this.zzWM).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public Uri zzmF() {
        return this.zzWL;
    }

    public Uri zzmG() {
        return this.zzWN;
    }

    public String zzmH() {
        return this.zzWM;
    }

    public String zzmI() {
        return zzmJ().toString();
    }
}
