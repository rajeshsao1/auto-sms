package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class TokenData implements SafeParcelable {
    public static final zze CREATOR = new zze();
    final int mVersionCode;
    private final String zzVo;
    private final Long zzVp;
    private final boolean zzVq;
    private final boolean zzVr;
    private final List<String> zzVs;

    TokenData(int i, String str, Long l, boolean z, boolean z2, List<String> list) {
        this.mVersionCode = i;
        this.zzVo = zzx.zzcM(str);
        this.zzVp = l;
        this.zzVq = z;
        this.zzVr = z2;
        this.zzVs = list;
    }

    public static TokenData zzc(Bundle bundle, String str) {
        Class<TokenData> cls = TokenData.class;
        bundle.setClassLoader(cls.getClassLoader());
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 == null) {
            return null;
        }
        bundle2.setClassLoader(cls.getClassLoader());
        return (TokenData) bundle2.getParcelable("TokenData");
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TokenData)) {
            return false;
        }
        TokenData tokenData = (TokenData) obj;
        return TextUtils.equals(this.zzVo, tokenData.zzVo) && zzw.equal(this.zzVp, tokenData.zzVp) && this.zzVq == tokenData.zzVq && this.zzVr == tokenData.zzVr && zzw.equal(this.zzVs, tokenData.zzVs);
    }

    public String getToken() {
        return this.zzVo;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzVo, this.zzVp, Boolean.valueOf(this.zzVq), Boolean.valueOf(this.zzVr), this.zzVs);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }

    public Long zzmn() {
        return this.zzVp;
    }

    public boolean zzmo() {
        return this.zzVq;
    }

    public boolean zzmp() {
        return this.zzVr;
    }

    public List<String> zzmq() {
        return this.zzVs;
    }
}
