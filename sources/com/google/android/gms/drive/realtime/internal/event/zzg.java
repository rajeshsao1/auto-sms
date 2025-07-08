package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Parcelable.Creator<TextInsertedDetails> {
    static void zza(TextInsertedDetails textInsertedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, textInsertedDetails.mVersionCode);
        zzb.zzc(parcel, 2, textInsertedDetails.mIndex);
        zzb.zzc(parcel, 3, textInsertedDetails.zzavn);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcI */
    public TextInsertedDetails createFromParcel(Parcel parcel) {
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
            return new TextInsertedDetails(i, i2, i3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeE */
    public TextInsertedDetails[] newArray(int i) {
        return new TextInsertedDetails[i];
    }
}
