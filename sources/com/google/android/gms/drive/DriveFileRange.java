package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DriveFileRange implements SafeParcelable {
    public static final Parcelable.Creator<DriveFileRange> CREATOR = new zzc();
    final int mVersionCode;
    final long zzaoJ;
    final long zzaoK;

    DriveFileRange(int i, long j, long j2) {
        this.mVersionCode = i;
        this.zzaoJ = j;
        this.zzaoK = j2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
