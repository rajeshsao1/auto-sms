package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;

public class zzar implements Parcelable.Creator<LoadRealtimeRequest> {
    static void zza(LoadRealtimeRequest loadRealtimeRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, loadRealtimeRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) loadRealtimeRequest.zzaoz, i, false);
        zzb.zza(parcel, 3, loadRealtimeRequest.zzarQ);
        zzb.zzb(parcel, 4, loadRealtimeRequest.zzarR, false);
        zzb.zza(parcel, 5, loadRealtimeRequest.zzarS);
        zzb.zza(parcel, 6, (Parcelable) loadRealtimeRequest.zzarT, i, false);
        zzb.zza(parcel, 7, loadRealtimeRequest.zzarU, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbx */
    public LoadRealtimeRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        DriveId driveId = null;
        ArrayList<String> arrayList = null;
        DataHolder dataHolder = null;
        String str = null;
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
                    driveId = (DriveId) zza.zza(parcel, zzat, DriveId.CREATOR);
                    break;
                case 3:
                    z = zza.zzc(parcel, zzat);
                    break;
                case 4:
                    arrayList = zza.zzD(parcel, zzat);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzat);
                    break;
                case 6:
                    dataHolder = (DataHolder) zza.zza(parcel, zzat, DataHolder.CREATOR);
                    break;
                case 7:
                    str = zza.zzp(parcel, zzat);
                    break;
                default:
                    zza.zzb(parcel, zzat);
                    break;
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new LoadRealtimeRequest(i, driveId, z, arrayList, z2, dataHolder, str);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzds */
    public LoadRealtimeRequest[] newArray(int i) {
        return new LoadRealtimeRequest[i];
    }
}
