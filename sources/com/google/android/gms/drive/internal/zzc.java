package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;

public class zzc implements Parcelable.Creator<AuthorizeAccessRequest> {
    static void zza(AuthorizeAccessRequest authorizeAccessRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, authorizeAccessRequest.mVersionCode);
        zzb.zza(parcel, 2, authorizeAccessRequest.zzaqe);
        zzb.zza(parcel, 3, (Parcelable) authorizeAccessRequest.zzaoz, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbb */
    public AuthorizeAccessRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        long j = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                j = zza.zzi(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AuthorizeAccessRequest(i, j, driveId);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcR */
    public AuthorizeAccessRequest[] newArray(int i) {
        return new AuthorizeAccessRequest[i];
    }
}
