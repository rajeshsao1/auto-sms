package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzg implements Parcelable.Creator<CheckResourceIdsExistRequest> {
    static void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, checkResourceIdsExistRequest.getVersionCode());
        zzb.zzb(parcel, 2, checkResourceIdsExistRequest.zztc(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbe */
    public CheckResourceIdsExistRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<String> arrayList = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzD(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CheckResourceIdsExistRequest(i, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcU */
    public CheckResourceIdsExistRequest[] newArray(int i) {
        return new CheckResourceIdsExistRequest[i];
    }
}
