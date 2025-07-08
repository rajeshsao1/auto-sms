package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<SignInAccount> {
    static void zza(SignInAccount signInAccount, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, signInAccount.versionCode);
        zzb.zza(parcel, 2, signInAccount.zzmT(), false);
        zzb.zza(parcel, 3, signInAccount.getIdToken(), false);
        zzb.zza(parcel, 4, signInAccount.getEmail(), false);
        zzb.zza(parcel, 5, signInAccount.getDisplayName(), false);
        zzb.zza(parcel, 6, (Parcelable) signInAccount.getPhotoUrl(), i, false);
        zzb.zza(parcel, 7, (Parcelable) signInAccount.zzmV(), i, false);
        zzb.zza(parcel, 8, signInAccount.getUserId(), false);
        zzb.zza(parcel, 9, signInAccount.zzmW(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzT */
    public SignInAccount createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        GoogleSignInAccount googleSignInAccount = null;
        String str5 = null;
        String str6 = "";
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
                    break;
                case 7:
                    googleSignInAccount = (GoogleSignInAccount) zza.zza(parcel, zzat, GoogleSignInAccount.CREATOR);
                    break;
                case 8:
                    str6 = zza.zzp(parcel, zzat);
                    break;
                case 9:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SignInAccount(i, str, str2, str3, str4, uri, googleSignInAccount, str6, str5);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaO */
    public SignInAccount[] newArray(int i) {
        return new SignInAccount[i];
    }
}
