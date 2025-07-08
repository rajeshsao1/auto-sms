package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.ConverterWrapper;
import com.google.android.gms.common.server.response.FastJsonResponse;

public class zza implements Parcelable.Creator<FastJsonResponse.Field> {
    static void zza(FastJsonResponse.Field field, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, field.getVersionCode());
        zzb.zzc(parcel, 2, field.zzrj());
        zzb.zza(parcel, 3, field.zzrp());
        zzb.zzc(parcel, 4, field.zzrk());
        zzb.zza(parcel, 5, field.zzrq());
        zzb.zza(parcel, 6, field.zzrr(), false);
        zzb.zzc(parcel, 7, field.zzrs());
        zzb.zza(parcel, 8, field.zzru(), false);
        zzb.zza(parcel, 9, (Parcelable) field.zzrw(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaA */
    public FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        String str = null;
        String str2 = null;
        ConverterWrapper converterWrapper = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        int i4 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 4:
                    i3 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 5:
                    z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 7:
                    i4 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
                    break;
                case 8:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                    break;
                case 9:
                    converterWrapper = (ConverterWrapper) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, ConverterWrapper.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FastJsonResponse.Field(i, i2, z, i3, z2, str, i4, str2, converterWrapper);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcg */
    public FastJsonResponse.Field[] newArray(int i) {
        return new FastJsonResponse.Field[i];
    }
}
