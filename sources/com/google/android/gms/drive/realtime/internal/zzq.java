package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzq implements Parcelable.Creator<ParcelableCollaborator> {
    static void zza(ParcelableCollaborator parcelableCollaborator, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, parcelableCollaborator.mVersionCode);
        zzb.zza(parcel, 2, parcelableCollaborator.zzauI);
        zzb.zza(parcel, 3, parcelableCollaborator.zzaeW);
        zzb.zza(parcel, 4, parcelableCollaborator.zzLq, false);
        zzb.zza(parcel, 5, parcelableCollaborator.zzrG, false);
        zzb.zza(parcel, 6, parcelableCollaborator.zzWQ, false);
        zzb.zza(parcel, 7, parcelableCollaborator.zzauJ, false);
        zzb.zza(parcel, 8, parcelableCollaborator.zzauK, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcA */
    public ParcelableCollaborator createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            switch (zza.zzca(zzat)) {
                case 1:
                    i = zza.zzg(parcel, zzat);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    str = zza.zzp(parcel, zzat);
                    break;
                case 5:
                    str2 = zza.zzp(parcel, zzat);
                    break;
                case 6:
                    str3 = zza.zzp(parcel, zzat);
                    break;
                case 7:
                    str4 = zza.zzp(parcel, zzat);
                    break;
                case 8:
                    str5 = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ParcelableCollaborator(i, z, z2, str, str2, str3, str4, str5);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzew */
    public ParcelableCollaborator[] newArray(int i) {
        return new ParcelableCollaborator[i];
    }
}
