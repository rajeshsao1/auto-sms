package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<MatchAllFilter> {
    static void zza(MatchAllFilter matchAllFilter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, matchAllFilter.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzct */
    public MatchAllFilter createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            if (zza.zzca(zzat) != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new MatchAllFilter(i);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeo */
    public MatchAllFilter[] newArray(int i) {
        return new MatchAllFilter[i];
    }
}
