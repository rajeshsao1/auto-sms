package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<ReferenceShiftedDetails> {
    static void zza(ReferenceShiftedDetails referenceShiftedDetails, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, referenceShiftedDetails.mVersionCode);
        zzb.zza(parcel, 2, referenceShiftedDetails.zzavj, false);
        zzb.zza(parcel, 3, referenceShiftedDetails.zzavk, false);
        zzb.zzc(parcel, 4, referenceShiftedDetails.zzavl);
        zzb.zzc(parcel, 5, referenceShiftedDetails.zzavm);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzcG */
    public ReferenceShiftedDetails createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
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
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                i3 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new ReferenceShiftedDetails(i, str, str2, i2, i3);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzeC */
    public ReferenceShiftedDetails[] newArray(int i) {
        return new ReferenceShiftedDetails[i];
    }
}
