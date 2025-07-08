package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Parcelable.Creator<DriveSpace> {
    static void zza(DriveSpace driveSpace, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveSpace.mVersionCode);
        zzb.zza(parcel, 2, driveSpace.getName(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaL */
    public DriveSpace createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                str = zza.zzp(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveSpace(i, str);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcu */
    public DriveSpace[] newArray(int i) {
        return new DriveSpace[i];
    }
}
