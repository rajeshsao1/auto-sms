package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

public class zzb implements Parcelable.Creator<GoogleSignInAccount> {
    static void zza(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, googleSignInAccount.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, googleSignInAccount.getId(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, googleSignInAccount.getIdToken(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, googleSignInAccount.getEmail(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, googleSignInAccount.getDisplayName(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, (Parcelable) googleSignInAccount.getPhotoUrl(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, googleSignInAccount.getServerAuthCode(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, googleSignInAccount.zzmK());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, googleSignInAccount.zzmL(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 10, googleSignInAccount.zzVs, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzR */
    public GoogleSignInAccount createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList<Scope> arrayList = null;
        long j = 0;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel2, zzat);
                    break;
                case 2:
                    str = zza.zzp(parcel2, zzat);
                    break;
                case 3:
                    str2 = zza.zzp(parcel2, zzat);
                    break;
                case 4:
                    str3 = zza.zzp(parcel2, zzat);
                    break;
                case 5:
                    str4 = zza.zzp(parcel2, zzat);
                    break;
                case 6:
                    uri = (Uri) zza.zza(parcel2, zzat, Uri.CREATOR);
                    break;
                case 7:
                    str5 = zza.zzp(parcel2, zzat);
                    break;
                case 8:
                    j = zza.zzi(parcel2, zzat);
                    break;
                case 9:
                    str6 = zza.zzp(parcel2, zzat);
                    break;
                case 10:
                    arrayList = zza.zzc(parcel2, zzat, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel2, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel2);
    }

    /* renamed from: zzaM */
    public GoogleSignInAccount[] newArray(int i) {
        return new GoogleSignInAccount[i];
    }
}
