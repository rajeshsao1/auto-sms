package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<ChangesAvailableEvent> {
    static void zza(ChangesAvailableEvent changesAvailableEvent, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, changesAvailableEvent.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, changesAvailableEvent.zzVa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) changesAvailableEvent.zzapy, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaQ */
    public ChangesAvailableEvent createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        ChangesAvailableOptions changesAvailableOptions = null;
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
                changesAvailableOptions = (ChangesAvailableOptions) zza.zza(parcel, zzat, ChangesAvailableOptions.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangesAvailableEvent(i, str, changesAvailableOptions);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcF */
    public ChangesAvailableEvent[] newArray(int i) {
        return new ChangesAvailableEvent[i];
    }
}
