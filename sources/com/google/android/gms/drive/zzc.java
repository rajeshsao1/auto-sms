package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<DriveFileRange> {
    static void zza(DriveFileRange driveFileRange, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveFileRange.mVersionCode);
        zzb.zza(parcel, 2, driveFileRange.zzaoJ);
        zzb.zza(parcel, 3, driveFileRange.zzaoK);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaJ */
    public DriveFileRange createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        long j = 0;
        long j2 = 0;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                j = zza.zzi(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                j2 = zza.zzi(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveFileRange(i, j, j2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcs */
    public DriveFileRange[] newArray(int i) {
        return new DriveFileRange[i];
    }
}
