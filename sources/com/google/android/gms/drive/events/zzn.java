package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.internal.TransferProgressData;

public class zzn implements Parcelable.Creator<TransferProgressEvent> {
    static void zza(TransferProgressEvent transferProgressEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferProgressEvent.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) transferProgressEvent.zzapS, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaU */
    public TransferProgressEvent createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        TransferProgressData transferProgressData = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                transferProgressData = (TransferProgressData) zza.zza(parcel, zzat, TransferProgressData.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferProgressEvent(i, transferProgressData);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcK */
    public TransferProgressEvent[] newArray(int i) {
        return new TransferProgressEvent[i];
    }
}
