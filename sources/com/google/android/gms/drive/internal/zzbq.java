package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbq implements Parcelable.Creator<RemovePermissionRequest> {
    static void zza(RemovePermissionRequest removePermissionRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, removePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) removePermissionRequest.zzaoz, i, false);
        zzb.zza(parcel, 3, removePermissionRequest.zzapk, false);
        zzb.zza(parcel, 4, removePermissionRequest.zzaqd);
        zzb.zza(parcel, 5, removePermissionRequest.zzaoV, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbS */
    public RemovePermissionRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
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
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
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
            return new RemovePermissionRequest(i, driveId, str, z, str2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdN */
    public RemovePermissionRequest[] newArray(int i) {
        return new RemovePermissionRequest[i];
    }
}
