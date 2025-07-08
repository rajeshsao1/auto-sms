package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzav implements Parcelable.Creator<OnChangesResponse> {
    static void zza(OnChangesResponse onChangesResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, onChangesResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) onChangesResponse.zzasb, i, false);
        zzb.zzc(parcel, 3, onChangesResponse.zzasc, false);
        zzb.zza(parcel, 4, (Parcelable) onChangesResponse.zzasd, i, false);
        zzb.zza(parcel, 5, onChangesResponse.zzase);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzby */
    public OnChangesResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DataHolder dataHolder = null;
        ArrayList<DriveId> arrayList = null;
        ChangeSequenceNumber changeSequenceNumber = null;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
            } else if (zzca == 3) {
                arrayList = zza.zzc(parcel, zzat, DriveId.CREATOR);
            } else if (zzca == 4) {
                changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzat, ChangeSequenceNumber.CREATOR);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new OnChangesResponse(i, dataHolder, arrayList, changeSequenceNumber, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdt */
    public OnChangesResponse[] newArray(int i) {
        return new OnChangesResponse[i];
    }
}
