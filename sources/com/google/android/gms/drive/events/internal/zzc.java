package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc implements Parcelable.Creator<TransferProgressData> {
    static void zza(TransferProgressData transferProgressData, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferProgressData.mVersionCode);
        zzb.zzc(parcel, 2, transferProgressData.zzapT);
        zzb.zza(parcel, 3, (Parcelable) transferProgressData.zzaoz, i, false);
        zzb.zzc(parcel, 4, transferProgressData.zzBc);
        zzb.zza(parcel, 5, transferProgressData.zzapW);
        zzb.zza(parcel, 6, transferProgressData.zzapX);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaY */
    public TransferProgressData createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        long j = 0;
        long j2 = 0;
        DriveId driveId = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 3:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzat);
                    break;
                case 6:
                    j2 = zza.zzi(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferProgressData(i, i2, driveId, i3, j, j2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcO */
    public TransferProgressData[] newArray(int i) {
        return new TransferProgressData[i];
    }
}
