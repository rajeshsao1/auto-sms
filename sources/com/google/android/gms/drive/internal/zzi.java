package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzi implements Parcelable.Creator<CloseContentsRequest> {
    static void zza(CloseContentsRequest closeContentsRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, closeContentsRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) closeContentsRequest.zzaql, i, false);
        zzb.zza(parcel, 3, closeContentsRequest.zzaqp, false);
        zzb.zzc(parcel, 4, closeContentsRequest.zzaqn);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbg */
    public CloseContentsRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        Contents contents = null;
        Boolean bool = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                contents = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
            } else if (zzca == 3) {
                bool = zza.zzd(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                i2 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CloseContentsRequest(i, contents, bool, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcW */
    public CloseContentsRequest[] newArray(int i) {
        return new CloseContentsRequest[i];
    }
}
