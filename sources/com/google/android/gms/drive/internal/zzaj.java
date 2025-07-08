package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzaj implements Parcelable.Creator<GetMetadataRequest> {
    static void zza(GetMetadataRequest getMetadataRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getMetadataRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) getMetadataRequest.zzaqj, i, false);
        zzb.zza(parcel, 3, getMetadataRequest.zzarN);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbt */
    public GetMetadataRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        boolean z = false;
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
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetMetadataRequest(i, driveId, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdo */
    public GetMetadataRequest[] newArray(int i) {
        return new GetMetadataRequest[i];
    }
}
