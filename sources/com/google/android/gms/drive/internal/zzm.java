package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzm implements Parcelable.Creator<CreateFileIntentSenderRequest> {
    static void zza(CreateFileIntentSenderRequest createFileIntentSenderRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, createFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) createFileIntentSenderRequest.zzaqw, i, false);
        zzb.zzc(parcel, 3, createFileIntentSenderRequest.zzaox);
        zzb.zza(parcel, 4, createFileIntentSenderRequest.zzapg, false);
        zzb.zza(parcel, 5, (Parcelable) createFileIntentSenderRequest.zzapj, i, false);
        zzb.zza(parcel, 6, createFileIntentSenderRequest.zzaqx, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbj */
    public CreateFileIntentSenderRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        MetadataBundle metadataBundle = null;
        String str = null;
        DriveId driveId = null;
        Integer num = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 6:
                    num = zza.zzh(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CreateFileIntentSenderRequest(i, metadataBundle, i2, str, driveId, num);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzda */
    public CreateFileIntentSenderRequest[] newArray(int i) {
        return new CreateFileIntentSenderRequest[i];
    }
}
