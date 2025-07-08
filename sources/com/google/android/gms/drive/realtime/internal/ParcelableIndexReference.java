package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableIndexReference implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableIndexReference> CREATOR = new zzr();
    final int mIndex;
    final int mVersionCode;
    final String zzauL;
    final boolean zzauM;
    final int zzauN;

    ParcelableIndexReference(int i, String str, int i2, boolean z, int i3) {
        this.mVersionCode = i;
        this.zzauL = str;
        this.mIndex = i2;
        this.zzauM = z;
        this.zzauN = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
