package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.Collection;

public class zza implements Parcelable.Creator<AppVisibleCustomProperties> {
    static void zza(AppVisibleCustomProperties appVisibleCustomProperties, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, appVisibleCustomProperties.mVersionCode);
        zzb.zzc(parcel, 2, appVisibleCustomProperties.zzasL, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzce */
    public AppVisibleCustomProperties createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        ArrayList<CustomProperty> arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, CustomProperty.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AppVisibleCustomProperties(i, (Collection<CustomProperty>) arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdZ */
    public AppVisibleCustomProperties[] newArray(int i) {
        return new AppVisibleCustomProperties[i];
    }
}
