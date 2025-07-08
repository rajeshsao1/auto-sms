package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEvent;
import java.util.List;

public class ParcelableChangeInfo implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableChangeInfo> CREATOR = new zzp();
    final int mVersionCode;
    final long zzaez;
    final List<ParcelableEvent> zzpH;

    ParcelableChangeInfo(int i, long j, List<ParcelableEvent> list) {
        this.mVersionCode = i;
        this.zzaez = j;
        this.zzpH = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
