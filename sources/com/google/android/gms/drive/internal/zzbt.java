package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzbt implements Parcelable.Creator<SetResourceParentsRequest> {
    static void zza(SetResourceParentsRequest setResourceParentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, setResourceParentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) setResourceParentsRequest.zzaqf, i, false);
        zzb.zzc(parcel, 3, setResourceParentsRequest.zzasC, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbV */
    public SetResourceParentsRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        ArrayList<DriveId> arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, DriveId.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SetResourceParentsRequest(i, driveId, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdQ */
    public SetResourceParentsRequest[] newArray(int i) {
        return new SetResourceParentsRequest[i];
    }
}
