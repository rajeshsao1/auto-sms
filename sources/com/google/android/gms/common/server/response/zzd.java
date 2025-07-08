package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<FieldMappingDictionary.Entry> {
    static void zza(FieldMappingDictionary.Entry entry, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, entry.versionCode);
        zzb.zza(parcel, 2, entry.className, false);
        zzb.zzc(parcel, 3, entry.zzamY, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaD */
    public FieldMappingDictionary.Entry createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        ArrayList arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, FieldMappingDictionary.FieldMapPair.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FieldMappingDictionary.Entry(i, str, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcj */
    public FieldMappingDictionary.Entry[] newArray(int i) {
        return new FieldMappingDictionary.Entry[i];
    }
}
