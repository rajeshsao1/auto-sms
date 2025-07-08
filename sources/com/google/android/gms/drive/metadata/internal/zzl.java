package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzl implements Parcelable.Creator<ParentDriveIdSet> {
    static void zza(ParentDriveIdSet parentDriveIdSet, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parentDriveIdSet.mVersionCode);
        zzb.zzc(parcel, 2, parentDriveIdSet.zzasS, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzch */
    public ParentDriveIdSet createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<PartialDriveId> arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, PartialDriveId.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParentDriveIdSet(i, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzec */
    public ParentDriveIdSet[] newArray(int i) {
        return new ParentDriveIdSet[i];
    }
}
