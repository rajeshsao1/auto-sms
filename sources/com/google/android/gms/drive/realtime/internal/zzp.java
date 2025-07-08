package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.ArrayList;

public class zzp implements Parcelable.Creator<ParcelableChangeInfo> {
    static void zza(ParcelableChangeInfo parcelableChangeInfo, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableChangeInfo.mVersionCode);
        zzb.zza(parcel, 2, parcelableChangeInfo.zzaez);
        zzb.zzc(parcel, 3, parcelableChangeInfo.zzpH, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcz */
    public ParcelableChangeInfo createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        ArrayList<ParcelableEvent> arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                j = zza.zzi(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, ParcelableEvent.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableChangeInfo(i, j, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzev */
    public ParcelableChangeInfo[] newArray(int i) {
        return new ParcelableChangeInfo[i];
    }
}
