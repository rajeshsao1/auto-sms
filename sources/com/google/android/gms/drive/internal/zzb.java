package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.Permission;

public class zzb implements Parcelable.Creator<AddPermissionRequest> {
    static void zza(AddPermissionRequest addPermissionRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, addPermissionRequest.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) addPermissionRequest.zzaoz, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) addPermissionRequest.zzaqa, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, addPermissionRequest.zzaqb);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, addPermissionRequest.zzaqc, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, addPermissionRequest.zzaqd);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, addPermissionRequest.zzaoV, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzba */
    public AddPermissionRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        Permission permission = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
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
                    permission = (Permission) zza.zza(parcel, zzat, Permission.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AddPermissionRequest(i, driveId, permission, z, str, z2, str2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcQ */
    public AddPermissionRequest[] newArray(int i) {
        return new AddPermissionRequest[i];
    }
}
