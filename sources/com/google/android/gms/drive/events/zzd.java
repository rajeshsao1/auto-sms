package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzd implements Parcelable.Creator<ChangesAvailableOptions> {
    static void zza(ChangesAvailableOptions changesAvailableOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, changesAvailableOptions.mVersionCode);
        zzb.zzc(parcel, 2, changesAvailableOptions.zzapz);
        zzb.zza(parcel, 3, changesAvailableOptions.zzapA);
        zzb.zzc(parcel, 4, changesAvailableOptions.zzapB, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaR */
    public ChangesAvailableOptions createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<DriveSpace> arrayList = null;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 3) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, DriveSpace.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ChangesAvailableOptions(i, i2, z, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcG */
    public ChangesAvailableOptions[] newArray(int i) {
        return new ChangesAvailableOptions[i];
    }
}
