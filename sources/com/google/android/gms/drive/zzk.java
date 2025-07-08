package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzk implements Parcelable.Creator<RealtimeDocumentSyncRequest> {
    static void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, realtimeDocumentSyncRequest.mVersionCode);
        zzb.zzb(parcel, 2, realtimeDocumentSyncRequest.zzapq, false);
        zzb.zzb(parcel, 3, realtimeDocumentSyncRequest.zzapr, false);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzaN */
    public RealtimeDocumentSyncRequest createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        ArrayList<String> arrayList = null;
        ArrayList<String> arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                arrayList = zza.zzD(parcel, zzat);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                arrayList2 = zza.zzD(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new RealtimeDocumentSyncRequest(i, arrayList, arrayList2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzcC */
    public RealtimeDocumentSyncRequest[] newArray(int i) {
        return new RealtimeDocumentSyncRequest[i];
    }
}
