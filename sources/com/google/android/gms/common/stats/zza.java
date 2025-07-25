package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<ConnectionEvent> {
    static void zza(ConnectionEvent connectionEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, connectionEvent.mVersionCode);
        zzb.zza(parcel, 2, connectionEvent.getTimeMillis());
        zzb.zza(parcel, 4, connectionEvent.zzrF(), false);
        zzb.zza(parcel, 5, connectionEvent.zzrG(), false);
        zzb.zza(parcel, 6, connectionEvent.zzrH(), false);
        zzb.zza(parcel, 7, connectionEvent.zzrI(), false);
        zzb.zza(parcel, 8, connectionEvent.zzrJ(), false);
        zzb.zza(parcel, 10, connectionEvent.zzrN());
        zzb.zza(parcel, 11, connectionEvent.zzrM());
        zzb.zzc(parcel, 12, connectionEvent.getEventType());
        zzb.zza(parcel, 13, connectionEvent.zzrK(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaF */
    public ConnectionEvent createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel2, zzat);
                    break;
                case 4:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 7:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                case 10:
                    j2 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel2, zzat);
                    break;
                case 11:
                    j3 = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel2, zzat);
                    break;
                case 12:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel2, zzat);
                    break;
                case 13:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel2, zzat);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ConnectionEvent(i, j, i2, str, str2, str3, str4, str5, str6, j2, j3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel2);
    }

    /* renamed from: zzcl */
    public ConnectionEvent[] newArray(int i) {
        return new ConnectionEvent[i];
    }
}
