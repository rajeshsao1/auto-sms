package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FieldChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<FieldChangedDetails> CREATOR = new zza();
    final int mVersionCode;
    final int zzauO;

    FieldChangedDetails(int i, int i2) {
        this.mVersionCode = i;
        this.zzauO = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
