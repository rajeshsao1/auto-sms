package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<ChangeSequenceNumber> {
    static void zza(ChangeSequenceNumber changeSequenceNumber, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changeSequenceNumber.mVersionCode);
        zzb.zza(parcel, 2, changeSequenceNumber.zzaot);
        zzb.zza(parcel, 3, changeSequenceNumber.zzaou);
        zzb.zza(parcel, 4, changeSequenceNumber.zzaov);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaH */
    public ChangeSequenceNumber createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
            } else if (zzca == 3) {
                j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
            } else if (zzca != 4) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangeSequenceNumber(i, j, j2, j3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcq */
    public ChangeSequenceNumber[] newArray(int i) {
        return new ChangeSequenceNumber[i];
    }
}
