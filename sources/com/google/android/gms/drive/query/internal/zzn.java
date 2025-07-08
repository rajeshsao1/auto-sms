package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Parcelable.Creator<Operator> {
    static void zza(Operator operator, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, operator.mVersionCode);
        zzb.zza(parcel, 1, operator.mTag, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcv */
    public Operator createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Operator(i, str);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeq */
    public Operator[] newArray(int i) {
        return new Operator[i];
    }
}
