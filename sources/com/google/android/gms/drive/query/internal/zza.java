package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class zza implements Parcelable.Creator<ComparisonFilter> {
    static void zza(ComparisonFilter comparisonFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, comparisonFilter.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) comparisonFilter.zzaug, i, false);
        zzb.zza(parcel, 2, (Parcelable) comparisonFilter.zzauh, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcl */
    public ComparisonFilter createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Operator operator = null;
        MetadataBundle metadataBundle = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                operator = (Operator) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Operator.CREATOR);
            } else if (zzca == 2) {
                metadataBundle = (MetadataBundle) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, MetadataBundle.CREATOR);
            } else if (zzca != 1000) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ComparisonFilter(i, operator, metadataBundle);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeg */
    public ComparisonFilter[] newArray(int i) {
        return new ComparisonFilter[i];
    }
}
