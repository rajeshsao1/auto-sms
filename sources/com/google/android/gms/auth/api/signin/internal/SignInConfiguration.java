package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import org.json.JSONException;
import org.json.JSONObject;

public final class SignInConfiguration implements SafeParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new zzp();
    final int versionCode;
    private final String zzXL;
    private EmailSignInOptions zzXM;
    private GoogleSignInOptions zzXN;
    private String zzXO;
    private String zzXd;

    SignInConfiguration(int i, String str, String str2, EmailSignInOptions emailSignInOptions, GoogleSignInOptions googleSignInOptions, String str3) {
        this.versionCode = i;
        this.zzXL = zzx.zzcM(str);
        this.zzXd = str2;
        this.zzXM = emailSignInOptions;
        this.zzXN = googleSignInOptions;
        this.zzXO = str3;
    }

    public SignInConfiguration(String str) {
        this(2, str, (String) null, (EmailSignInOptions) null, (GoogleSignInOptions) null, (String) null);
    }

    private JSONObject zzmJ() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("consumerPackageName", this.zzXL);
            if (!TextUtils.isEmpty(this.zzXd)) {
                jSONObject.put("serverClientId", this.zzXd);
            }
            EmailSignInOptions emailSignInOptions = this.zzXM;
            if (emailSignInOptions != null) {
                jSONObject.put("emailSignInOptions", emailSignInOptions.zzmI());
            }
            GoogleSignInOptions googleSignInOptions = this.zzXN;
            if (googleSignInOptions != null) {
                jSONObject.put("googleSignInOptions", googleSignInOptions.zzmI());
            }
            if (!TextUtils.isEmpty(this.zzXO)) {
                jSONObject.put("apiKey", this.zzXO);
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
            SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
            if (!this.zzXL.equals(signInConfiguration.zznk())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzXd)) {
                if (!TextUtils.isEmpty(signInConfiguration.zzmR())) {
                    return false;
                }
            } else if (!this.zzXd.equals(signInConfiguration.zzmR())) {
                return false;
            }
            if (TextUtils.isEmpty(this.zzXO)) {
                if (!TextUtils.isEmpty(signInConfiguration.zznn())) {
                    return false;
                }
            } else if (!this.zzXO.equals(signInConfiguration.zznn())) {
                return false;
            }
            EmailSignInOptions emailSignInOptions = this.zzXM;
            if (emailSignInOptions == null) {
                if (signInConfiguration.zznl() != null) {
                    return false;
                }
            } else if (!emailSignInOptions.equals(signInConfiguration.zznl())) {
                return false;
            }
            GoogleSignInOptions googleSignInOptions = this.zzXN;
            if (googleSignInOptions != null) {
                return googleSignInOptions.equals(signInConfiguration.zznm());
            }
            if (signInConfiguration.zznm() != null) {
                return false;
            }
        } catch (ClassCastException e) {
            return false;
        }
    }

    public int hashCode() {
        return new zze().zzp(this.zzXL).zzp(this.zzXd).zzp(this.zzXO).zzp(this.zzXM).zzp(this.zzXN).zzne();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }

    public SignInConfiguration zzj(GoogleSignInOptions googleSignInOptions) {
        this.zzXN = (GoogleSignInOptions) zzx.zzb(googleSignInOptions, (Object) "GoogleSignInOptions cannot be null.");
        return this;
    }

    public String zzmI() {
        return zzmJ().toString();
    }

    public String zzmR() {
        return this.zzXd;
    }

    public String zznk() {
        return this.zzXL;
    }

    public EmailSignInOptions zznl() {
        return this.zzXM;
    }

    public GoogleSignInOptions zznm() {
        return this.zzXN;
    }

    public String zznn() {
        return this.zzXO;
    }
}
