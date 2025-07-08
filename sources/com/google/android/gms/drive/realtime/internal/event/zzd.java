package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<ParcelableEventList> {
    static void zza(ParcelableEventList parcelableEventList, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableEventList.mVersionCode);
        zzb.zzc(parcel, 2, parcelableEventList.zzpH, false);
        zzb.zza(parcel, 3, (Parcelable) parcelableEventList.zzavf, i, false);
        zzb.zza(parcel, 4, parcelableEventList.zzavg);
        zzb.zzb(parcel, 5, parcelableEventList.zzavh, false);
        zzb.zza(parcel, 6, (Parcelable) parcelableEventList.zzavi, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcF */
    public ParcelableEventList createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ArrayList<ParcelableEvent> arrayList = null;
        DataHolder dataHolder = null;
        ArrayList<String> arrayList2 = null;
        ParcelableChangeInfo parcelableChangeInfo = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzat, ParcelableEvent.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    arrayList2 = zza.zzD(parcel, zzat);
                    break;
                case 6:
                    parcelableChangeInfo = (ParcelableChangeInfo) zza.zza(parcel, zzat, ParcelableChangeInfo.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableEventList(i, arrayList, dataHolder, z, arrayList2, parcelableChangeInfo);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeB */
    public ParcelableEventList[] newArray(int i) {
        return new ParcelableEventList[i];
    }
}
