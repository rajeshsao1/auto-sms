package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator<NotFilter> {
    static void zza(NotFilter notFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, notFilter.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) notFilter.zzauw, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcu */
    public NotFilter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        FilterHolder filterHolder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                filterHolder = (FilterHolder) zza.zza(parcel, zzat, FilterHolder.CREATOR);
            } else if (zzca != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new NotFilter(i, filterHolder);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzep */
    public NotFilter[] newArray(int i) {
        return new NotFilter[i];
    }
}
