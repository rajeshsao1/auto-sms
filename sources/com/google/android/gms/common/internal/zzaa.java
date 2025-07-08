package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaa implements Parcelable.Creator<SignInButtonConfig> {
    static void zza(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, signInButtonConfig.mVersionCode);
        zzb.zzc(parcel, 2, signInButtonConfig.zzrb());
        zzb.zzc(parcel, 3, signInButtonConfig.zzrc());
        zzb.zza(parcel, 4, (T[]) signInButtonConfig.zzrd(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzar */
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 3) {
                i3 = zza.zzg(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                scopeArr = (Scope[]) zza.zzb(parcel, zzat, Scope.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SignInButtonConfig(i, i2, i3, scopeArr);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbY */
    public SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
