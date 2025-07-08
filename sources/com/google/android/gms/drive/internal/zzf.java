package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzf implements Parcelable.Creator<ChangeResourceParentsRequest> {
    static void zza(ChangeResourceParentsRequest changeResourceParentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changeResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) changeResourceParentsRequest.zzaqf, i, false);
        zzb.zzc(parcel, 3, changeResourceParentsRequest.zzaqg, false);
        zzb.zzc(parcel, 4, changeResourceParentsRequest.zzaqh, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbd */
    public ChangeResourceParentsRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        ArrayList<DriveId> arrayList = null;
        ArrayList<DriveId> arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca == 3) {
                arrayList = zza.zzc(parcel, zzat, DriveId.CREATOR);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList2 = zza.zzc(parcel, zzat, DriveId.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangeResourceParentsRequest(i, driveId, arrayList, arrayList2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcT */
    public ChangeResourceParentsRequest[] newArray(int i) {
        return new ChangeResourceParentsRequest[i];
    }
}
