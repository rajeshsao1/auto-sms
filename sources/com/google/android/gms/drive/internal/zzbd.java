package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbd implements Parcelable.Creator<OnListParentsResponse> {
    static void zza(OnListParentsResponse onListParentsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onListParentsResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onListParentsResponse.zzast, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbG */
    public OnListParentsResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnListParentsResponse(i, dataHolder);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdB */
    public OnListParentsResponse[] newArray(int i) {
        return new OnListParentsResponse[i];
    }
}
