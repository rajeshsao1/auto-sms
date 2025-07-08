package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<DriveId> {
    static void zza(DriveId driveId, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveId.mVersionCode);
        zzb.zza(parcel, 2, driveId.zzaoL, false);
        zzb.zza(parcel, 3, driveId.zzaoM);
        zzb.zza(parcel, 4, driveId.zzaou);
        zzb.zzc(parcel, 5, driveId.zzaoN);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaK */
    public DriveId createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        long j = 0;
        long j2 = 0;
        String str = null;
        int i = 0;
        int i2 = -1;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca == 3) {
                j = zza.zzi(parcel, zzat);
            } else if (zzca == 4) {
                j2 = zza.zzi(parcel, zzat);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                i2 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveId(i, str, j, j2, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzct */
    public DriveId[] newArray(int i) {
        return new DriveId[i];
    }
}
