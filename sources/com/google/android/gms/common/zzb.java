package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<ConnectionResult> {
    static void zza(ConnectionResult connectionResult, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, connectionResult.mVersionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, connectionResult.getErrorCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) connectionResult.getResolution(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, connectionResult.getErrorMessage(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzag */
    public ConnectionResult createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 3) {
                pendingIntent = (PendingIntent) zza.zza(parcel, zzat, PendingIntent.CREATOR);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                str = zza.zzp(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ConnectionResult(i, i2, pendingIntent, str);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbt */
    public ConnectionResult[] newArray(int i) {
        return new ConnectionResult[i];
    }
}
