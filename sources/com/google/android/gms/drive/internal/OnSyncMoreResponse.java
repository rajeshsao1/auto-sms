package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnSyncMoreResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnSyncMoreResponse> CREATOR = new zzbj();
    final int mVersionCode;
    final boolean zzaqJ;

    OnSyncMoreResponse(int i, boolean z) {
        this.mVersionCode = i;
        this.zzaqJ = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbj.zza(this, parcel, i);
    }
}
