package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class LoadRealtimeRequest implements SafeParcelable {
    public static final Parcelable.Creator<LoadRealtimeRequest> CREATOR = new zzar();
    final int mVersionCode;
    final DriveId zzaoz;
    final boolean zzarQ;
    final List<String> zzarR;
    final boolean zzarS;
    final DataHolder zzarT;
    final String zzarU;

    LoadRealtimeRequest(int i, DriveId driveId, boolean z, List<String> list, boolean z2, DataHolder dataHolder, String str) {
        this.mVersionCode = i;
        this.zzaoz = driveId;
        this.zzarQ = z;
        this.zzarR = list;
        this.zzarS = z2;
        this.zzarT = dataHolder;
        this.zzarU = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzar.zza(this, parcel, i);
    }
}
