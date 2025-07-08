package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class TextDeletedDetails implements SafeParcelable {
    public static final Parcelable.Creator<TextDeletedDetails> CREATOR = new zzf();
    final int mIndex;
    final int mVersionCode;
    final int zzavn;

    TextDeletedDetails(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzavn = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
