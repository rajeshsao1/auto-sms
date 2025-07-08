package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<WebImage> {
    static void zza(WebImage webImage, Parcel parcel, int i) {
        int zzav = com.google.android.gms.common.internal.safeparcel.zzb.zzav(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, webImage.getVersionCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) webImage.getUrl(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 3, webImage.getWidth());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 4, webImage.getHeight());
        com.google.android.gms.common.internal.safeparcel.zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzal */
    public WebImage createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        Uri uri = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                uri = (Uri) zza.zza(parcel, zzat, Uri.CREATOR);
            } else if (zzca == 3) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                i3 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new WebImage(i, uri, i2, i3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbN */
    public WebImage[] newArray(int i) {
        return new WebImage[i];
    }
}
