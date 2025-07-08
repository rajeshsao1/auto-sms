package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zzb implements Parcelable.Creator<FieldOnlyFilter> {
    static void zza(FieldOnlyFilter fieldOnlyFilter, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, fieldOnlyFilter.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 1, (Parcelable) fieldOnlyFilter.zzauh, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcm */
    public FieldOnlyFilter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        MetadataBundle metadataBundle = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                metadataBundle = (MetadataBundle) zza.zza(parcel, zzat, MetadataBundle.CREATOR);
            } else if (zzca != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FieldOnlyFilter(i, metadataBundle);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeh */
    public FieldOnlyFilter[] newArray(int i) {
        return new FieldOnlyFilter[i];
    }
}
