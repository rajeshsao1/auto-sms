package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbi implements Parcelable.Creator<OnStartStreamSession> {
    static void zza(OnStartStreamSession onStartStreamSession, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onStartStreamSession.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onStartStreamSession.zzasv, i, false);
        zzb.zza(parcel, 3, onStartStreamSession.zzasw, false);
        zzb.zza(parcel, 4, onStartStreamSession.zzsU, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbL */
    public OnStartStreamSession createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        IBinder iBinder = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
            } else if (zzca == 3) {
                iBinder = zza.zzq(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                str = zza.zzp(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnStartStreamSession(i, parcelFileDescriptor, iBinder, str);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdG */
    public OnStartStreamSession[] newArray(int i) {
        return new OnStartStreamSession[i];
    }
}
