package com.google.android.gms.drive.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzad implements Parcelable.Creator<DriveServiceResponse> {
    static void zza(DriveServiceResponse driveServiceResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, driveServiceResponse.mVersionCode);
        zzb.zza(parcel, 2, driveServiceResponse.zzarB, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbo */
    public DriveServiceResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                iBinder = zza.zzq(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new DriveServiceResponse(i, iBinder);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdf */
    public DriveServiceResponse[] newArray(int i) {
        return new DriveServiceResponse[i];
    }
}
