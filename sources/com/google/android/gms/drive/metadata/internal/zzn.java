package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Parcelable.Creator<PartialDriveId> {
    static void zza(PartialDriveId partialDriveId, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, partialDriveId.mVersionCode);
        zzb.zza(parcel, 2, partialDriveId.zzaoL, false);
        zzb.zza(parcel, 3, partialDriveId.zzaoM);
        zzb.zzc(parcel, 4, partialDriveId.zzaoN);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzci */
    public PartialDriveId createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        long j = 0;
        int i = 0;
        int i2 = -1;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca == 3) {
                j = zza.zzi(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                i2 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new PartialDriveId(i, str, j, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzed */
    public PartialDriveId[] newArray(int i) {
        return new PartialDriveId[i];
    }
}
