package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<DataHolder> {
    static void zza(DataHolder dataHolder, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zza(parcel, 1, dataHolder.zzqe(), false);
        zzb.zzc(parcel, 1000, dataHolder.getVersionCode());
        zzb.zza(parcel, 2, (T[]) dataHolder.zzqf(), i, false);
        zzb.zzc(parcel, 3, dataHolder.getStatusCode());
        zzb.zza(parcel, 4, dataHolder.zzpZ(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzak */
    public DataHolder createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                strArr = zza.zzB(parcel, zzat);
            } else if (zzca == 2) {
                cursorWindowArr = (CursorWindow[]) zza.zzb(parcel, zzat, CursorWindow.CREATOR);
            } else if (zzca == 3) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 4) {
                bundle = zza.zzr(parcel, zzat);
            } else if (zzca != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            DataHolder dataHolder = new DataHolder(i, strArr, cursorWindowArr, i2, bundle);
            dataHolder.zzqd();
            return dataHolder;
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbJ */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
