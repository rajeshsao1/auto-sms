package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbj implements Parcelable.Creator<OnSyncMoreResponse> {
    static void zza(OnSyncMoreResponse onSyncMoreResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onSyncMoreResponse.mVersionCode);
        zzb.zza(parcel, 2, onSyncMoreResponse.zzaqJ);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbM */
    public OnSyncMoreResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnSyncMoreResponse(i, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdH */
    public OnSyncMoreResponse[] newArray(int i) {
        return new OnSyncMoreResponse[i];
    }
}
