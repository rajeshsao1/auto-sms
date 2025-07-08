package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class OnLoadRealtimeResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnLoadRealtimeResponse> CREATOR = new zzbg();
    final int mVersionCode;
    final boolean zzqA;

    OnLoadRealtimeResponse(int i, boolean z) {
        this.mVersionCode = i;
        this.zzqA = z;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbg.zza(this, parcel, i);
    }
}
