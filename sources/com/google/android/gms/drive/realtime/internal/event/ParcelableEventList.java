package com.google.android.gms.drive.realtime.internal.event;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.realtime.internal.ParcelableChangeInfo;
import java.util.List;

public class ParcelableEventList implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableEventList> CREATOR = new zzd();
    final int mVersionCode;
    final DataHolder zzavf;
    final boolean zzavg;
    final List<String> zzavh;
    final ParcelableChangeInfo zzavi;
    final List<ParcelableEvent> zzpH;

    ParcelableEventList(int i, List<ParcelableEvent> list, DataHolder dataHolder, boolean z, List<String> list2, ParcelableChangeInfo parcelableChangeInfo) {
        this.mVersionCode = i;
        this.zzpH = list;
        this.zzavf = dataHolder;
        this.zzavg = z;
        this.zzavh = list2;
        this.zzavi = parcelableChangeInfo;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
