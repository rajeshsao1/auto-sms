package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<ValuesSetDetails> {
    static void zza(ValuesSetDetails valuesSetDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, valuesSetDetails.mVersionCode);
        zzb.zzc(parcel, 2, valuesSetDetails.mIndex);
        zzb.zzc(parcel, 3, valuesSetDetails.zzauP);
        zzb.zzc(parcel, 4, valuesSetDetails.zzauQ);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcM */
    public ValuesSetDetails createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 3) {
                i3 = zza.zzg(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                i4 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ValuesSetDetails(i, i2, i3, i4);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeI */
    public ValuesSetDetails[] newArray(int i) {
        return new ValuesSetDetails[i];
    }
}
