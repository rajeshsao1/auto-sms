package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<GoogleSignInOptions> {
    static void zza(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, googleSignInOptions.versionCode);
        zzb.zzc(parcel, 2, googleSignInOptions.zzmN(), false);
        zzb.zza(parcel, 3, (Parcelable) googleSignInOptions.getAccount(), i, false);
        zzb.zza(parcel, 4, googleSignInOptions.zzmO());
        zzb.zza(parcel, 5, googleSignInOptions.zzmP());
        zzb.zza(parcel, 6, googleSignInOptions.zzmQ());
        zzb.zza(parcel, 7, googleSignInOptions.zzmR(), false);
        zzb.zza(parcel, 8, googleSignInOptions.zzmS(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzS */
    public GoogleSignInOptions createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ArrayList<Scope> arrayList = null;
        Account account = null;
        String str = null;
        String str2 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzat, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zza.zza(parcel, zzat, Account.CREATOR);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    z3 = zza.zzc(parcel, zzat);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GoogleSignInOptions(i, arrayList, account, z, z2, z3, str, str2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaN */
    public GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
