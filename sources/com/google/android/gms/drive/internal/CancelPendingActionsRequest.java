package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class CancelPendingActionsRequest implements SafeParcelable {
    public static final Parcelable.Creator<CancelPendingActionsRequest> CREATOR = new zze();
    final int mVersionCode;
    final List<String> zzapG;

    CancelPendingActionsRequest(int i, List<String> list) {
        this.mVersionCode = i;
        this.zzapG = list;
    }

    public CancelPendingActionsRequest(List<String> list) {
        this(1, list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze.zza(this, parcel, i);
    }
}
