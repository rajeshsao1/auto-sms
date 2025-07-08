package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class BeginCompoundOperationRequest implements SafeParcelable {
    public static final Parcelable.Creator<BeginCompoundOperationRequest> CREATOR = new zza();
    final String mName;
    final int mVersionCode;
    final boolean zzauG;
    final boolean zzauH;

    BeginCompoundOperationRequest(int i, boolean z, String str, boolean z2) {
        this.mVersionCode = i;
        this.zzauG = z;
        this.mName = str;
        this.zzauH = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
