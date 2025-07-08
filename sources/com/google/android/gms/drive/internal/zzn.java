package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzn implements Parcelable.Creator<CreateFileRequest> {
    static void zza(CreateFileRequest createFileRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createFileRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) createFileRequest.zzaqy, i, false);
        zzb.zza(parcel, 3, (Parcelable) createFileRequest.zzaqw, i, false);
        zzb.zza(parcel, 4, (Parcelable) createFileRequest.zzaql, i, false);
        zzb.zza(parcel, 5, createFileRequest.zzaqx, false);
        zzb.zza(parcel, 6, createFileRequest.zzaqd);
        zzb.zza(parcel, 7, createFileRequest.zzaoV, false);
        zzb.zzc(parcel, 8, createFileRequest.zzaqz);
        zzb.zzc(parcel, 9, createFileRequest.zzaqA);
        zzb.zza(parcel, 10, createFileRequest.zzaoY, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbk */
    public CreateFileRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        MetadataBundle metadataBundle = null;
        Contents contents = null;
        Integer num = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
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
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzat);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 9:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 10:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateFileRequest(i, driveId, metadataBundle, contents, num, z, str, i2, i3, str2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdb */
    public CreateFileRequest[] newArray(int i) {
        return new CreateFileRequest[i];
    }
}
