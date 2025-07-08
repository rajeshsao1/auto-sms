package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzj implements Parcelable.Creator<ControlProgressRequest> {
    static void zza(ControlProgressRequest controlProgressRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, controlProgressRequest.mVersionCode);
        zzb.zzc(parcel, 2, controlProgressRequest.zzaqq);
        zzb.zzc(parcel, 3, controlProgressRequest.zzaqr);
        zzb.zza(parcel, 4, (Parcelable) controlProgressRequest.zzaoz, i, false);
        zzb.zza(parcel, 5, (Parcelable) controlProgressRequest.zzaqs, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbh */
    public ControlProgressRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        ParcelableTransferPreferences parcelableTransferPreferences = null;
        int i = 0;
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
            } else if (zzca == 4) {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                parcelableTransferPreferences = (ParcelableTransferPreferences) zza.zza(parcel, zzat, ParcelableTransferPreferences.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ControlProgressRequest(i, i2, i3, driveId, parcelableTransferPreferences);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcX */
    public ControlProgressRequest[] newArray(int i) {
        return new ControlProgressRequest[i];
    }
}
