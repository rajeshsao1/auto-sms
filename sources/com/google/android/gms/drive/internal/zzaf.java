package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzaf implements Parcelable.Creator<FetchThumbnailRequest> {
    static void zza(FetchThumbnailRequest fetchThumbnailRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fetchThumbnailRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) fetchThumbnailRequest.zzaqj, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbp */
    public FetchThumbnailRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FetchThumbnailRequest(i, driveId);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdi */
    public FetchThumbnailRequest[] newArray(int i) {
        return new FetchThumbnailRequest[i];
    }
}
