package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbc implements Parcelable.Creator<OnListEntriesResponse> {
    static void zza(OnListEntriesResponse onListEntriesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onListEntriesResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onListEntriesResponse.zzass, i, false);
        zzb.zza(parcel, 3, onListEntriesResponse.zzaqJ);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbF */
    public OnListEntriesResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DataHolder dataHolder = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnListEntriesResponse(i, dataHolder, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdA */
    public OnListEntriesResponse[] newArray(int i) {
        return new OnListEntriesResponse[i];
    }
}
