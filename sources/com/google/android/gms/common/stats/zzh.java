package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh implements Parcelable.Creator<WakeLockEvent> {
    static void zza(WakeLockEvent wakeLockEvent, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, wakeLockEvent.mVersionCode);
        zzb.zza(parcel, 2, wakeLockEvent.getTimeMillis());
        zzb.zza(parcel, 4, wakeLockEvent.zzrR(), false);
        zzb.zzc(parcel, 5, wakeLockEvent.zzrT());
        zzb.zzb(parcel, 6, wakeLockEvent.zzrU(), false);
        zzb.zza(parcel, 8, wakeLockEvent.zzrN());
        zzb.zza(parcel, 10, wakeLockEvent.zzrS(), false);
        zzb.zzc(parcel, 11, wakeLockEvent.getEventType());
        zzb.zza(parcel, 12, wakeLockEvent.zzrK(), false);
        zzb.zza(parcel, 13, wakeLockEvent.zzrW(), false);
        zzb.zzc(parcel, 14, wakeLockEvent.zzrV());
        zzb.zza(parcel, 15, wakeLockEvent.zzrX());
        zzb.zza(parcel, 16, wakeLockEvent.zzrY());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaG */
    public WakeLockEvent createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel);
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f = 0.0f;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    j = zza.zzi(parcel2, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    i3 = zza.zzg(parcel2, zzat);
                    break;
                case 6:
                    arrayList = zza.zzD(parcel2, zzat);
                    break;
                case 8:
                    j2 = zza.zzi(parcel2, zzat);
                    break;
                case 10:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 11:
                    i2 = zza.zzg(parcel2, zzat);
                    break;
                case 12:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 13:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 14:
                    i4 = zza.zzg(parcel2, zzat);
                    break;
                case 15:
                    f = zza.zzl(parcel2, zzat);
                    break;
                case 16:
                    j3 = zza.zzi(parcel2, zzat);
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new WakeLockEvent(i, j, i2, str, i3, arrayList, str2, j2, i4, str3, str4, f, j3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel2);
    }

    /* renamed from: zzcm */
    public WakeLockEvent[] newArray(int i) {
        return new WakeLockEvent[i];
    }
}
