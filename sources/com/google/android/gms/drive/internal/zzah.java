package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.ArrayList;

public class zzah implements Parcelable.Creator<GetChangesRequest> {
    static void zza(GetChangesRequest getChangesRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getChangesRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) getChangesRequest.zzarJ, i, false);
        zzb.zzc(parcel, 3, getChangesRequest.zzarK);
        zzb.zzc(parcel, 4, getChangesRequest.zzapB, false);
        zzb.zza(parcel, 5, getChangesRequest.zzarL);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbr */
    public GetChangesRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ChangeSequenceNumber changeSequenceNumber = null;
        ArrayList<DriveSpace> arrayList = null;
        int i = 0;
        int i2 = 0;
        boolean z = false;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                changeSequenceNumber = (ChangeSequenceNumber) zza.zza(parcel, zzat, ChangeSequenceNumber.CREATOR);
            } else if (zzca == 3) {
                i2 = zza.zzg(parcel, zzat);
            } else if (zzca == 4) {
                arrayList = zza.zzc(parcel, zzat, DriveSpace.CREATOR);
            } else if (zzca != 5) {
                zza.zzb(parcel, zzat);
            } else {
                z = zza.zzc(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetChangesRequest(i, changeSequenceNumber, i2, arrayList, z);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdm */
    public GetChangesRequest[] newArray(int i) {
        return new GetChangesRequest[i];
    }
}
