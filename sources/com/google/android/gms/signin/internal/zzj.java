package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<SignInResponse> {
    static void zza(SignInResponse signInResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, signInResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) signInResponse.zzqY(), i, false);
        zzb.zza(parcel, 3, (Parcelable) signInResponse.zzFP(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgV */
    public SignInResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                connectionResult = (ConnectionResult) zza.zza(parcel, zzat, ConnectionResult.CREATOR);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) zza.zza(parcel, zzat, ResolveAccountResponse.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SignInResponse(i, connectionResult, resolveAccountResponse);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkd */
    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }
}
