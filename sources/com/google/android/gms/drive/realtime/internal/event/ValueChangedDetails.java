package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValueChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValueChangedDetails> CREATOR = new zzh();
    final int mVersionCode;
    final int zzauO;

    ValueChangedDetails(int i, int i2) {
        this.mVersionCode = i;
        this.zzauO = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
