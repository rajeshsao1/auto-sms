package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzr implements Parcelable.Creator<TransferStateOptions> {
    static void zza(TransferStateOptions transferStateOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, transferStateOptions.mVersionCode);
        zzb.zzc(parcel, 2, transferStateOptions.zzapB, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaX */
    public TransferStateOptions createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<DriveSpace> arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, DriveSpace.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new TransferStateOptions(i, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcN */
    public TransferStateOptions[] newArray(int i) {
        return new TransferStateOptions[i];
    }
}
