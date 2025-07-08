package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValuesAddedDetails implements SafeParcelable {
    public static final Parcelable.Creator<ValuesAddedDetails> CREATOR = new zzi();
    final int mIndex;
    final int mVersionCode;
    final int zzauP;
    final int zzauQ;
    final String zzavo;
    final int zzavp;

    ValuesAddedDetails(int i, int i2, int i3, int i4, String str, int i5) {
        this.mVersionCode = i;
        this.mIndex = i2;
        this.zzauP = i3;
        this.zzauQ = i4;
        this.zzavo = str;
        this.zzavp = i5;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
