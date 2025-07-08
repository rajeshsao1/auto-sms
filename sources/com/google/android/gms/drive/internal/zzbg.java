package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbg implements Parcelable.Creator<OnLoadRealtimeResponse> {
    static void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onLoadRealtimeResponse.mVersionCode);
        zzb.zza(parcel, 2, onLoadRealtimeResponse.zzqA);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbJ */
    public OnLoadRealtimeResponse createFromParcel(Parcel parcel) {
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
            return new OnLoadRealtimeResponse(i, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdE */
    public OnLoadRealtimeResponse[] newArray(int i) {
        return new OnLoadRealtimeResponse[i];
    }
}
