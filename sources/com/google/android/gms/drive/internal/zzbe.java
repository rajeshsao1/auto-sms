package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzbe implements Parcelable.Creator<OnMetadataResponse> {
    static void zza(OnMetadataResponse onMetadataResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onMetadataResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onMetadataResponse.zzaqw, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbH */
    public OnMetadataResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnMetadataResponse(i, metadataBundle);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdC */
    public OnMetadataResponse[] newArray(int i) {
        return new OnMetadataResponse[i];
    }
}
