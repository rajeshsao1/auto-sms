package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<AuthAccountResult> {
    static void zza(AuthAccountResult authAccountResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, authAccountResult.mVersionCode);
        zzb.zzc(parcel, 2, authAccountResult.zzFK());
        zzb.zza(parcel, 3, (Parcelable) authAccountResult.zzFL(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgR */
    public AuthAccountResult createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        Intent intent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca != 3) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                intent = (Intent) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Intent.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AuthAccountResult(i, i2, intent);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjY */
    public AuthAccountResult[] newArray(int i) {
        return new AuthAccountResult[i];
    }
}
