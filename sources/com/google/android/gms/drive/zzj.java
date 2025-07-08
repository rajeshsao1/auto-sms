package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Parcelable.Creator<Permission> {
    static void zza(Permission permission, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, permission.mVersionCode);
        zzb.zza(parcel, 2, permission.zzsO(), false);
        zzb.zzc(parcel, 3, permission.zzsP());
        zzb.zza(parcel, 4, permission.zzsQ(), false);
        zzb.zza(parcel, 5, permission.zzsR(), false);
        zzb.zzc(parcel, 6, permission.getRole());
        zzb.zza(parcel, 7, permission.zzsS());
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaM */
    public Permission createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
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
                    i2 = zza.zzg(parcel, zzat);
                    break;
                case 4:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    i3 = zza.zzg(parcel, zzat);
                    break;
                case 7:
                    z = zza.zzc(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new Permission(i, str, i2, str2, str3, i3, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcB */
    public Permission[] newArray(int i) {
        return new Permission[i];
    }
}
