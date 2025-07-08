package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzo implements Parcelable.Creator<CreateFolderRequest> {
    static void zza(CreateFolderRequest createFolderRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createFolderRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) createFolderRequest.zzaqy, i, false);
        zzb.zza(parcel, 3, (Parcelable) createFolderRequest.zzaqw, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbl */
    public CreateFolderRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        MetadataBundle metadataBundle = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateFolderRequest(i, driveId, metadataBundle);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdc */
    public CreateFolderRequest[] newArray(int i) {
        return new CreateFolderRequest[i];
    }
}
