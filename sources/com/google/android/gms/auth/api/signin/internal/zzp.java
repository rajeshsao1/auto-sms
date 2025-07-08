package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.EmailSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Parcelable.Creator<SignInConfiguration> {
    static void zza(SignInConfiguration signInConfiguration, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, signInConfiguration.versionCode);
        zzb.zza(parcel, 2, signInConfiguration.zznk(), false);
        zzb.zza(parcel, 3, signInConfiguration.zzmR(), false);
        zzb.zza(parcel, 4, (Parcelable) signInConfiguration.zznl(), i, false);
        zzb.zza(parcel, 5, (Parcelable) signInConfiguration.zznm(), i, false);
        zzb.zza(parcel, 7, signInConfiguration.zznn(), false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzV */
    public SignInConfiguration createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        EmailSignInOptions emailSignInOptions = null;
        GoogleSignInOptions googleSignInOptions = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca == 3) {
                str2 = zza.zzp(parcel, zzat);
            } else if (zzca == 4) {
                emailSignInOptions = (EmailSignInOptions) zza.zza(parcel, zzat, EmailSignInOptions.CREATOR);
            } else if (zzca == 5) {
                googleSignInOptions = (GoogleSignInOptions) zza.zza(parcel, zzat, GoogleSignInOptions.CREATOR);
            } else if (zzca != 7) {
                zza.zzb(parcel, zzat);
            } else {
                str3 = zza.zzp(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SignInConfiguration(i, str, str2, emailSignInOptions, googleSignInOptions, str3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaQ */
    public SignInConfiguration[] newArray(int i) {
        return new SignInConfiguration[i];
    }
}
