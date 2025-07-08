package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Parcelable.Creator<LogEventParcelable> {
    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        zzb.zza(parcel, 2, (Parcelable) logEventParcelable.zzafh, i, false);
        zzb.zza(parcel, 3, logEventParcelable.zzafi, false);
        zzb.zza(parcel, 4, logEventParcelable.zzafj, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaf */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        PlayLoggerContext playLoggerContext = null;
        byte[] bArr = null;
        int[] iArr = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                playLoggerContext = (PlayLoggerContext) zza.zza(parcel, zzat, PlayLoggerContext.CREATOR);
            } else if (zzca == 3) {
                bArr = zza.zzs(parcel, zzat);
            } else if (zzca != 4) {
                zza.zzb(parcel, zzat);
            } else {
                iArr = zza.zzv(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LogEventParcelable(i, playLoggerContext, bArr, iArr);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzbs */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
