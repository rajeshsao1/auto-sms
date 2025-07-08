package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<BeginCompoundOperationRequest> {
    static void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, beginCompoundOperationRequest.mVersionCode);
        zzb.zza(parcel, 2, beginCompoundOperationRequest.zzauG);
        zzb.zza(parcel, 3, beginCompoundOperationRequest.mName, false);
        zzb.zza(parcel, 4, beginCompoundOperationRequest.zzauH);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcx */
    public BeginCompoundOperationRequest createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        int i = 0;
        String str = null;
        boolean z = false;
        boolean z2 = true;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                z = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
            } else if (zzca == 3) {
                str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
            } else if (zzca != 4) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                z2 = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new BeginCompoundOperationRequest(i, z, str, z2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzes */
    public BeginCompoundOperationRequest[] newArray(int i) {
        return new BeginCompoundOperationRequest[i];
    }
}
