package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesRemovedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesRemovedDetails> CREATOR = new zzj();
    final int mIndex;
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;
    final String zzavq;
    final int zzavr;

    ValuesRemovedDetails(int i, int i2, int i3, int i4, String str, int i5) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzauP = i3;
        this.zzauQ = i4;
        this.zzavq = str;
        this.zzavr = i5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
