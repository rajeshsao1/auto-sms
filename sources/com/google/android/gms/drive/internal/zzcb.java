package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzcb implements Parcelable.Creator<UpdatePermissionRequest> {
    static void zza(UpdatePermissionRequest updatePermissionRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, updatePermissionRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) updatePermissionRequest.zzaoz, i, false);
        zzb.zza(parcel, 3, updatePermissionRequest.zzapk, false);
        zzb.zzc(parcel, 4, updatePermissionRequest.zzasE);
        zzb.zza(parcel, 5, updatePermissionRequest.zzaqd);
        zzb.zza(parcel, 6, updatePermissionRequest.zzaoV, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcc */
    public UpdatePermissionRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        String str = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UpdatePermissionRequest(i, driveId, str, i2, z, str2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdX */
    public UpdatePermissionRequest[] newArray(int i) {
        return new UpdatePermissionRequest[i];
    }
}
