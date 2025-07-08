package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzbk implements Parcelable.Creator<OpenContentsRequest> {
    static void zza(OpenContentsRequest openContentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, openContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) openContentsRequest.zzaqj, i, false);
        zzb.zzc(parcel, 3, openContentsRequest.zzaoy);
        zzb.zzc(parcel, 4, openContentsRequest.zzasx);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbN */
    public OpenContentsRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        DriveId driveId = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca == 3) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                i3 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OpenContentsRequest(i, driveId, i2, i3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdI */
    public OpenContentsRequest[] newArray(int i) {
        return new OpenContentsRequest[i];
    }
}
