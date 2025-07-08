package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<ValueChangedDetails> {
    static void zza(ValueChangedDetails valueChangedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, valueChangedDetails.mVersionCode);
        zzb.zzc(parcel, 2, valueChangedDetails.zzauO);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcJ */
    public ValueChangedDetails createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                i2 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ValueChangedDetails(i, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeF */
    public ValueChangedDetails[] newArray(int i) {
        return new ValueChangedDetails[i];
    }
}
