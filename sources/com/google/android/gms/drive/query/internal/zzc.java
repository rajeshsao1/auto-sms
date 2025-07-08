package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<FieldWithSortOrder> {
    static void zza(FieldWithSortOrder fieldWithSortOrder, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, fieldWithSortOrder.mVersionCode);
        zzb.zza(parcel, 1, fieldWithSortOrder.zzasF, false);
        zzb.zza(parcel, 2, fieldWithSortOrder.zzauj);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcn */
    public FieldWithSortOrder createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca == 2) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FieldWithSortOrder(i, str, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzei */
    public FieldWithSortOrder[] newArray(int i) {
        return new FieldWithSortOrder[i];
    }
}
