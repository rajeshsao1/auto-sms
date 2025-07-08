package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<AuthAccountRequest> {
    static void zza(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, authAccountRequest.zzakA, false);
        zzb.zza(parcel, 3, (T[]) authAccountRequest.zzafT, i, false);
        zzb.zza(parcel, 4, authAccountRequest.zzakB, false);
        zzb.zza(parcel, 5, authAccountRequest.zzakC, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzam */
    public AuthAccountRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Integer num = null;
        Integer num2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                iBinder = zza.zzq(parcel, zzat);
            } else if (zzca == 3) {
                scopeArr = (Scope[]) zza.zzb(parcel, zzat, Scope.CREATOR);
            } else if (zzca == 4) {
                num = zza.zzh(parcel, zzat);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                num2 = zza.zzh(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num, num2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbP */
    public AuthAccountRequest[] newArray(int i) {
        return new AuthAccountRequest[i];
    }
}
