package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ObjectChangedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ObjectChangedDetails> CREATOR = new zzb();
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;

    ObjectChangedDetails(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.zzauP = i2;
        this.zzauQ = i3;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
