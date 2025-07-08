package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;
import java.util.List;

public class zza implements Parcelable.Creator<Query> {
    static void zza(Query query, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1000, query.mVersionCode);
        zzb.zza(parcel, 1, (Parcelable) query.zzatV, i, false);
        zzb.zza(parcel, 3, query.zzatW, false);
        zzb.zza(parcel, 4, (Parcelable) query.zzatX, i, false);
        zzb.zzb(parcel, 5, query.zzatY, false);
        zzb.zza(parcel, 6, query.zzatZ);
        zzb.zzc(parcel, 7, query.zzapB, false);
        zzb.zza(parcel, 8, query.zzarL);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcj */
    public Query createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        LogicalFilter logicalFilter = null;
        String str = null;
        SortOrder sortOrder = null;
        ArrayList<String> arrayList = null;
        ArrayList<DriveSpace> arrayList2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                logicalFilter = (LogicalFilter) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, LogicalFilter.CREATOR);
            } else if (zzca != 1000) {
                switch (zzca) {
                    case 3:
                        str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
                        break;
                    case 4:
                        sortOrder = (SortOrder) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, SortOrder.CREATOR);
                        break;
                    case 5:
                        arrayList = com.google.android.gms.common.internal.safeparcel.zza.zzD(parcel, zzat);
                        break;
                    case 6:
                        z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                        break;
                    case 7:
                        arrayList2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat, DriveSpace.CREATOR);
                        break;
                    case 8:
                        z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
                        break;
                    default:
                        com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
                        break;
                }
            } else {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Query(i, logicalFilter, str, sortOrder, (List<String>) arrayList, z, (List<DriveSpace>) arrayList2, z2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzee */
    public Query[] newArray(int i) {
        return new Query[i];
    }
}
