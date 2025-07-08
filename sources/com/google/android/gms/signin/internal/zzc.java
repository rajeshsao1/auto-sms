package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<CheckServerAuthResult> {
    static void zza(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, checkServerAuthResult.mVersionCode);
        zzb.zza(parcel, 2, checkServerAuthResult.zzbhf);
        zzb.zzc(parcel, 3, checkServerAuthResult.zzbhg, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgS */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<Scope> arrayList = null;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                z = zza.zzc(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList = zza.zzc(parcel, zzat, Scope.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new CheckServerAuthResult(i, z, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzjZ */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }
}
