package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<EmailSignInOptions> {
    static void zza(EmailSignInOptions emailSignInOptions, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, emailSignInOptions.versionCode);
        zzb.zza(parcel, 2, (Parcelable) emailSignInOptions.zzmF(), i, false);
        zzb.zza(parcel, 3, emailSignInOptions.zzmH(), false);
        zzb.zza(parcel, 4, (Parcelable) emailSignInOptions.zzmG(), i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzQ */
    public EmailSignInOptions createFromParcel(Parcel parcel) {
        int zzau = com.google.android.gms.common.internal.safeparcel.zza.zzau(parcel);
        Uri uri = null;
        String str = null;
        Uri uri2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = com.google.android.gms.common.internal.safeparcel.zza.zzat(parcel);
            int zzca = com.google.android.gms.common.internal.safeparcel.zza.zzca(zzat);
            if (zzca == 1) {
                i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
            } else if (zzca == 3) {
                str = com.google.android.gms.common.internal.safeparcel.zza.zzp(parcel, zzat);
            } else if (zzca != 4) {
                com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzat);
            } else {
                uri2 = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzat, Uri.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new EmailSignInOptions(i, uri, str, uri2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzaL */
    public EmailSignInOptions[] newArray(int i) {
        return new EmailSignInOptions[i];
    }
}
