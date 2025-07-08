package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzh implements Parcelable.Creator<CloseContentsAndUpdateMetadataRequest> {
    static void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, closeContentsAndUpdateMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaqj, i, false);
        zzb.zza(parcel, 3, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaqk, i, false);
        zzb.zza(parcel, 4, (Parcelable) closeContentsAndUpdateMetadataRequest.zzaql, i, false);
        zzb.zza(parcel, 5, closeContentsAndUpdateMetadataRequest.zzaoW);
        zzb.zza(parcel, 6, closeContentsAndUpdateMetadataRequest.zzaoV, false);
        zzb.zzc(parcel, 7, closeContentsAndUpdateMetadataRequest.zzaqm);
        zzb.zzc(parcel, 8, closeContentsAndUpdateMetadataRequest.zzaqn);
        zzb.zza(parcel, 9, closeContentsAndUpdateMetadataRequest.zzaqo);
        zzb.zza(parcel, 10, closeContentsAndUpdateMetadataRequest.zzapa);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbf */
    public CloseContentsAndUpdateMetadataRequest createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        MetadataBundle metadataBundle = null;
        Contents contents = null;
        String str = null;
        int i = 0;
        boolean z = false;
        int i2 = 0;
        int i3 = 0;
        boolean z2 = false;
        boolean z3 = true;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    driveId = (DriveId) zza.zza(parcel2, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    metadataBundle = (MetadataBundle) zza.zza(parcel2, zzat, MetadataBundle.CREATOR);
                    break;
                case 4:
                    contents = (Contents) zza.zza(parcel2, zzat, Contents.CREATOR);
                    break;
                case 5:
                    z = zza.zzc(parcel2, zzat);
                    break;
                case 6:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 8:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 9:
                    z2 = zza.zzc(parcel2, zzat);
                    break;
                case 10:
                    z3 = zza.zzc(parcel2, zzat);
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CloseContentsAndUpdateMetadataRequest(i, driveId, metadataBundle, contents, z, str, i2, i3, z2, z3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel2);
    }

    /* renamed from: zzcV */
    public CloseContentsAndUpdateMetadataRequest[] newArray(int i) {
        return new CloseContentsAndUpdateMetadataRequest[i];
    }
}
