package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;

public class zzb implements Parcelable.Creator<SortOrder> {
    static void zza(SortOrder sortOrder, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1000, sortOrder.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, sortOrder.zzaud, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, sortOrder.zzaue);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzck */
    public SortOrder createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList arrayList = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                arrayList = zza.zzc(parcel, zzat, FieldWithSortOrder.CREATOR);
            } else if (zzca == 2) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 1000) {
                zza.zzb(parcel, zzat);
            } else {
                i = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SortOrder(i, (List<FieldWithSortOrder>) arrayList, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzef */
    public SortOrder[] newArray(int i) {
        return new SortOrder[i];
    }
}
