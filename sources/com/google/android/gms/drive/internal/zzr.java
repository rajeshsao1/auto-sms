package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Parcelable.Creator<DisconnectRequest> {
    static void zza(DisconnectRequest disconnectRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, disconnectRequest.mVersionCode);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbn */
    public DisconnectRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            if (zza.zzca(zzat) != 1) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DisconnectRequest(i);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzde */
    public DisconnectRequest[] newArray(int i) {
        return new DisconnectRequest[i];
    }
}
