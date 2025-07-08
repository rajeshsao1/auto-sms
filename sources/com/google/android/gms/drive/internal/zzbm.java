package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.query.internal.FilterHolder;

public class zzbm implements Parcelable.Creator<OpenFileIntentSenderRequest> {
    static void zza(OpenFileIntentSenderRequest openFileIntentSenderRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, openFileIntentSenderRequest.mVersionCode);
        zzb.zza(parcel, 2, openFileIntentSenderRequest.zzapg, false);
        zzb.zza(parcel, 3, openFileIntentSenderRequest.zzaph, false);
        zzb.zza(parcel, 4, (Parcelable) openFileIntentSenderRequest.zzapj, i, false);
        zzb.zza(parcel, 5, (Parcelable) openFileIntentSenderRequest.zzasz, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbO */
    public OpenFileIntentSenderRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        String str = null;
        String[] strArr = null;
        DriveId driveId = null;
        FilterHolder filterHolder = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                str = zza.zzp(parcel, zzat);
            } else if (zzca == 3) {
                strArr = zza.zzB(parcel, zzat);
            } else if (zzca == 4) {
                driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                filterHolder = (FilterHolder) zza.zza(parcel, zzat, FilterHolder.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OpenFileIntentSenderRequest(i, str, strArr, driveId, filterHolder);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdJ */
    public OpenFileIntentSenderRequest[] newArray(int i) {
        return new OpenFileIntentSenderRequest[i];
    }
}
