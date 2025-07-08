package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zza implements Parcelable.Creator<ChangeEvent> {
    static void zza(ChangeEvent changeEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changeEvent.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) changeEvent.zzaoz, i, false);
        zzb.zzc(parcel, 3, changeEvent.zzapx);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaP */
    public ChangeEvent createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                driveId = (DriveId) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca != 3) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangeEvent(i, driveId, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcE */
    public ChangeEvent[] newArray(int i) {
        return new ChangeEvent[i];
    }
}
