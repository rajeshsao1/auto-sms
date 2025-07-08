package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<FullTextSearchFilter> {
    static void zza(FullTextSearchFilter fullTextSearchFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, fullTextSearchFilter.mVersionCode);
        zzb.zza(parcel, 1, fullTextSearchFilter.mValue, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcp */
    public FullTextSearchFilter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FullTextSearchFilter(i, str);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzek */
    public FullTextSearchFilter[] newArray(int i) {
        return new FullTextSearchFilter[i];
    }
}
