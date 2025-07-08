package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzbr implements Parcelable.Creator<SetFileUploadPreferencesRequest> {
    static void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, setFileUploadPreferencesRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) setFileUploadPreferencesRequest.zzasg, i, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbT */
    public SetFileUploadPreferencesRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        FileUploadPreferencesImpl fileUploadPreferencesImpl = null;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca != 2) {
                zza.zzb(parcel, zzat);
            } else {
                fileUploadPreferencesImpl = (FileUploadPreferencesImpl) zza.zza(parcel, zzat, FileUploadPreferencesImpl.CREATOR);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new SetFileUploadPreferencesRequest(i, fileUploadPreferencesImpl);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdO */
    public SetFileUploadPreferencesRequest[] newArray(int i) {
        return new SetFileUploadPreferencesRequest[i];
    }
}
