package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzr implements Parcelable.Creator<ParcelableIndexReference> {
    static void zza(ParcelableIndexReference parcelableIndexReference, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableIndexReference.mVersionCode);
        zzb.zza(parcel, 2, parcelableIndexReference.zzauL, false);
        zzb.zzc(parcel, 3, parcelableIndexReference.mIndex);
        zzb.zza(parcel, 4, parcelableIndexReference.zzauM);
        zzb.zzc(parcel, 5, parcelableIndexReference.zzauN);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcB */
    public ParcelableIndexReference createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = -1;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca == 3) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 4) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                i3 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableIndexReference(i, str, i2, z, i3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzex */
    public ParcelableIndexReference[] newArray(int i) {
        return new ParcelableIndexReference[i];
    }
}
