package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesSetDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesSetDetails> CREATOR = new zzk();
    final int mIndex;
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;

    ValuesSetDetails(int i, int i2, int i3, int i4) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzauP = i3;
        this.zzauQ = i4;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
