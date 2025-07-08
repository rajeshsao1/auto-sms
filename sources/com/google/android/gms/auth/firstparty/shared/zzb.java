package com.google.android.gms.auth.firstparty.shared;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<FACLData> {
    static void zza(FACLData fACLData, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, fACLData.version);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) fACLData.zzYs, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, fACLData.zzYt, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, fACLData.zzYu);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, fACLData.zzYv, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzX */
    public FACLData createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        FACLConfig fACLConfig = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                fACLConfig = (FACLConfig) zza.zza(parcel, zzat, FACLConfig.CREATOR);
            } else if (zzca == 3) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca == 4) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                str2 = zza.zzp(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FACLData(i, fACLConfig, str, z, str2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaU */
    public FACLData[] newArray(int i) {
        return new FACLData[i];
    }
}
