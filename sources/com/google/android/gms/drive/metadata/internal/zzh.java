package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<MetadataBundle> {
    static void zza(MetadataBundle metadataBundle, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, metadataBundle.mVersionCode);
        zzb.zza(parcel, 2, metadataBundle.zzasQ, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcg */
    public MetadataBundle createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                bundle = zza.zzr(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MetadataBundle(i, bundle);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeb */
    public MetadataBundle[] newArray(int i) {
        return new MetadataBundle[i];
    }
}
