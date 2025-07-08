package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<ObjectChangedDetails> {
    static void zza(ObjectChangedDetails objectChangedDetails, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, objectChangedDetails.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, objectChangedDetails.zzauP);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, objectChangedDetails.zzauQ);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcD */
    public ObjectChangedDetails createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                i3 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ObjectChangedDetails(i, i2, i3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzez */
    public ObjectChangedDetails[] newArray(int i) {
        return new ObjectChangedDetails[i];
    }
}
