package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.events.internal.TransferProgressData;
import java.util.ArrayList;

public class zzp implements Parcelable.Creator<TransferStateEvent> {
    static void zza(TransferStateEvent transferStateEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferStateEvent.mVersionCode);
        zzb.zza(parcel, 2, transferStateEvent.zzVa, false);
        zzb.zzc(parcel, 3, transferStateEvent.zzapU, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaW */
    public TransferStateEvent createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        ArrayList<TransferProgressData> arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, TransferProgressData.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferStateEvent(i, str, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcM */
    public TransferStateEvent[] newArray(int i) {
        return new TransferStateEvent[i];
    }
}
