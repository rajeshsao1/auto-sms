package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.query.Query;

public class zzbo implements Parcelable.Creator<QueryRequest> {
    static void zza(QueryRequest queryRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, queryRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) queryRequest.zzasB, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbQ */
    public QueryRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Query query = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                query = (Query) zza.zza(parcel, zzat, Query.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new QueryRequest(i, query);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdL */
    public QueryRequest[] newArray(int i) {
        return new QueryRequest[i];
    }
}
