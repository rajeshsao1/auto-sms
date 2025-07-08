package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<AccountChangeEventsRequest> {
    static void zza(AccountChangeEventsRequest accountChangeEventsRequest, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, accountChangeEventsRequest.mVersion);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, accountChangeEventsRequest.zzVc);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, accountChangeEventsRequest.zzVa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, (Parcelable) accountChangeEventsRequest.zzTI, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzA */
    public AccountChangeEventsRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        Account account = null;
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
                str = zza.zzp(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new AccountChangeEventsRequest(i, i2, str, account);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzav */
    public AccountChangeEventsRequest[] newArray(int i) {
        return new AccountChangeEventsRequest[i];
    }
}
