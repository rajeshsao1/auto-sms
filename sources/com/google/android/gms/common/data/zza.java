package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<BitmapTeleporter> {
    static void zza(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, bitmapTeleporter.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) bitmapTeleporter.zzIq, i, false);
        zzb.zzc(parcel, 3, bitmapTeleporter.zzabB);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaj */
    public BitmapTeleporter createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ParcelFileDescriptor.CREATOR);
            } else if (zzca != 3) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new BitmapTeleporter(i, parcelFileDescriptor, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbE */
    public BitmapTeleporter[] newArray(int i) {
        return new BitmapTeleporter[i];
    }
}
