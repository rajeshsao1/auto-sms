package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Parcelable.Creator<UserMetadata> {
    static void zza(UserMetadata userMetadata, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, userMetadata.mVersionCode);
        zzb.zza(parcel, 2, userMetadata.zzaps, false);
        zzb.zza(parcel, 3, userMetadata.zzWQ, false);
        zzb.zza(parcel, 4, userMetadata.zzapt, false);
        zzb.zza(parcel, 5, userMetadata.zzapu);
        zzb.zza(parcel, 6, userMetadata.zzapv, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaO */
    public UserMetadata createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        boolean z = false;
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
                    z = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new UserMetadata(i, str, str2, str3, z, str4);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcD */
    public UserMetadata[] newArray(int i) {
        return new UserMetadata[i];
    }
}
