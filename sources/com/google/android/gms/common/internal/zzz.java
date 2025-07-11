package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzz implements Parcelable.Creator<ResolveAccountResponse> {
    static void zza(ResolveAccountResponse resolveAccountResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, resolveAccountResponse.mVersionCode);
        zzb.zza(parcel, 2, resolveAccountResponse.zzakA, false);
        zzb.zza(parcel, 3, (Parcelable) resolveAccountResponse.zzqY(), i, false);
        zzb.zza(parcel, 4, resolveAccountResponse.zzqZ());
        zzb.zza(parcel, 5, resolveAccountResponse.zzra());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaq */
    public ResolveAccountResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                iBinder = zza.zzq(parcel, zzat);
            } else if (zzca == 3) {
                connectionResult = (ConnectionResult) zza.zza(parcel, zzat, ConnectionResult.CREATOR);
            } else if (zzca == 4) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                z2 = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ResolveAccountResponse(i, iBinder, connectionResult, z, z2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbX */
    public ResolveAccountResponse[] newArray(int i) {
        return new ResolveAccountResponse[i];
    }
}
