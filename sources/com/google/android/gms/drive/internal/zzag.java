package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzag implements Parcelable.Creator<FileUploadPreferencesImpl> {
    static void zza(FileUploadPreferencesImpl fileUploadPreferencesImpl, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, fileUploadPreferencesImpl.mVersionCode);
        zzb.zzc(parcel, 2, fileUploadPreferencesImpl.zzarG);
        zzb.zzc(parcel, 3, fileUploadPreferencesImpl.zzarH);
        zzb.zza(parcel, 4, fileUploadPreferencesImpl.zzarI);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbq */
    public FileUploadPreferencesImpl createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 3) {
                i3 = zza.zzg(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new FileUploadPreferencesImpl(i, i2, i3, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdl */
    public FileUploadPreferencesImpl[] newArray(int i) {
        return new FileUploadPreferencesImpl[i];
    }
}
