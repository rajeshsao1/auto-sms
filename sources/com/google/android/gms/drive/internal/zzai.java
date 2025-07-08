package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzai implements Parcelable.Creator<GetDriveIdFromUniqueIdentifierRequest> {
    static void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getDriveIdFromUniqueIdentifierRequest.mVersionCode);
        zzb.zza(parcel, 2, getDriveIdFromUniqueIdentifierRequest.zzaoZ, false);
        zzb.zza(parcel, 3, getDriveIdFromUniqueIdentifierRequest.zzarM);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbs */
    public GetDriveIdFromUniqueIdentifierRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetDriveIdFromUniqueIdentifierRequest(i, str, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdn */
    public GetDriveIdFromUniqueIdentifierRequest[] newArray(int i) {
        return new GetDriveIdFromUniqueIdentifierRequest[i];
    }
}
