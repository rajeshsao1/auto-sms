package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Contents;

public class zzaw implements Parcelable.Creator<OnContentsResponse> {
    static void zza(OnContentsResponse onContentsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onContentsResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onContentsResponse.zzara, i, false);
        zzb.zza(parcel, 3, onContentsResponse.zzasf);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbz */
    public OnContentsResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Contents contents = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                contents = (Contents) zza.zza(parcel, zzat, Contents.CREATOR);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnContentsResponse(i, contents, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdu */
    public OnContentsResponse[] newArray(int i) {
        return new OnContentsResponse[i];
    }
}
