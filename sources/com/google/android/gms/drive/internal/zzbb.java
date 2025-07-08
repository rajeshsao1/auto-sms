package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbb implements Parcelable.Creator<OnFetchThumbnailResponse> {
    static void zza(OnFetchThumbnailResponse onFetchThumbnailResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onFetchThumbnailResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onFetchThumbnailResponse.zzasr, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbE */
    public OnFetchThumbnailResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnFetchThumbnailResponse(i, parcelFileDescriptor);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdz */
    public OnFetchThumbnailResponse[] newArray(int i) {
        return new OnFetchThumbnailResponse[i];
    }
}
