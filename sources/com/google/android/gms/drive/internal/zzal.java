package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.drive.Permission;
import java.util.ArrayList;

public class zzal implements Parcelable.Creator<GetPermissionsResponse> {
    static void zza(GetPermissionsResponse getPermissionsResponse, Parcel parcel, int i) {
        int zzav = zzb.zzav(parcel);
        zzb.zzc(parcel, 1, getPermissionsResponse.mVersionCode);
        zzb.zzc(parcel, 2, getPermissionsResponse.zzarO, false);
        zzb.zzc(parcel, 3, getPermissionsResponse.zzzw);
        zzb.zzI(parcel, zzav);
    }

    /* renamed from: zzbv */
    public GetPermissionsResponse createFromParcel(Parcel parcel) {
        int zzau = zza.zzau(parcel);
        int i = 0;
        ArrayList<Permission> arrayList = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzau) {
            int zzat = zza.zzat(parcel);
            int zzca = zza.zzca(zzat);
            if (zzca == 1) {
                i = zza.zzg(parcel, zzat);
            } else if (zzca == 2) {
                arrayList = zza.zzc(parcel, zzat, Permission.CREATOR);
            } else if (zzca != 3) {
                zza.zzb(parcel, zzat);
            } else {
                i2 = zza.zzg(parcel, zzat);
            }
        }
        if (parcel.dataPosition() == zzau) {
            return new GetPermissionsResponse(i, arrayList, i2);
        }
        throw new zza.C0004zza("Overread allowed size end=" + zzau, parcel);
    }

    /* renamed from: zzdq */
    public GetPermissionsResponse[] newArray(int i) {
        return new GetPermissionsResponse[i];
    }
}
