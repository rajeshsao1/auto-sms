package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.List;

public class RealtimeDocumentSyncRequest implements SafeParcelable {
    public static final Parcelable.Creator<RealtimeDocumentSyncRequest> CREATOR = new zzk();
    final int mVersionCode;
    final List<String> zzapq;
    final List<String> zzapr;

    RealtimeDocumentSyncRequest(int i, List<String> list, List<String> list2) {
        this.mVersionCode = i;
        this.zzapq = (List) zzx.zzz(list);
        this.zzapr = (List) zzx.zzz(list2);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
