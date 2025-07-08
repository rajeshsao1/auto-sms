package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<QueryResultEventParcelable> {
    static void zza(QueryResultEventParcelable queryResultEventParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, queryResultEventParcelable.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) queryResultEventParcelable.zzahi, i, false);
        zzb.zza(parcel, 3, queryResultEventParcelable.zzapQ);
        zzb.zzc(parcel, 4, queryResultEventParcelable.zzapR);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaT */
    public QueryResultEventParcelable createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        boolean z = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
            } else if (zzca == 3) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                i2 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new QueryResultEventParcelable(i, dataHolder, z, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcI */
    public QueryResultEventParcelable[] newArray(int i) {
        return new QueryResultEventParcelable[i];
    }
}
