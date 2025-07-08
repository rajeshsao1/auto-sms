package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator<RecordConsentRequest> {
    static void zza(RecordConsentRequest recordConsentRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, recordConsentRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) recordConsentRequest.getAccount(), i, false);
        zzb.zza(parcel, 3, (T[]) recordConsentRequest.zzFM(), i, false);
        zzb.zza(parcel, 4, recordConsentRequest.zzmR(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzgT */
    public RecordConsentRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        Account account = null;
        Scope[] scopeArr = null;
        String str = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
            } else if (zzca == 3) {
                scopeArr = (Scope[]) zza.zzb(parcel, zzat, Scope.CREATOR);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                str = zza.zzp(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RecordConsentRequest(i, account, scopeArr, str);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzkb */
    public RecordConsentRequest[] newArray(int i) {
        return new RecordConsentRequest[i];
    }
}
