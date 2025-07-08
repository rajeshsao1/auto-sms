package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzaq implements Parcelable.Creator<ListParentsRequest> {
    static void zza(ListParentsRequest listParentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, listParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) listParentsRequest.zzarP, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbw */
    public ListParentsRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ListParentsRequest(i, driveId);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdr */
    public ListParentsRequest[] newArray(int i) {
        return new ListParentsRequest[i];
    }
}
