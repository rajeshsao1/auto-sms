package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzy implements Parcelable.Creator<ResolveAccountRequest> {
    static void zza(ResolveAccountRequest resolveAccountRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, resolveAccountRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) resolveAccountRequest.getAccount(), i, false);
        zzb.zzc(parcel, 3, resolveAccountRequest.getSessionId());
        zzb.zza(parcel, 4, (Parcelable) resolveAccountRequest.zzqW(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzap */
    public ResolveAccountRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i = 0;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
            } else if (zzca == 3) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                googleSignInAccount = (GoogleSignInAccount) zza.zza(parcel, zzat, GoogleSignInAccount.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ResolveAccountRequest(i, account, i2, googleSignInAccount);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbW */
    public ResolveAccountRequest[] newArray(int i) {
        return new ResolveAccountRequest[i];
    }
}
