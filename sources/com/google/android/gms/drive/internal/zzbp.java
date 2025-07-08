package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.TransferProgressOptions;

public class zzbp implements Parcelable.Creator<RemoveEventListenerRequest> {
    static void zza(RemoveEventListenerRequest removeEventListenerRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removeEventListenerRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) removeEventListenerRequest.zzaoz, i, false);
        zzb.zzc(parcel, 3, removeEventListenerRequest.zzanf);
        zzb.zza(parcel, 4, (Parcelable) removeEventListenerRequest.zzapZ, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbR */
    public RemoveEventListenerRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        TransferProgressOptions transferProgressOptions = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca == 3) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                transferProgressOptions = (TransferProgressOptions) zza.zza(parcel, zzat, TransferProgressOptions.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RemoveEventListenerRequest(i, driveId, i2, transferProgressOptions);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdM */
    public RemoveEventListenerRequest[] newArray(int i) {
        return new RemoveEventListenerRequest[i];
    }
}
