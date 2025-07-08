package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveFileRange;
import java.util.Collections;
import java.util.List;

public class OnDownloadProgressResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnDownloadProgressResponse> CREATOR = new zzay();
    private static final List<DriveFileRange> zzash = Collections.emptyList();
    final int mVersionCode;
    final int zzBc;
    final long zzasi;
    final long zzasj;
    final List<DriveFileRange> zzask;

    OnDownloadProgressResponse(int i, long j, long j2, int i2, List<DriveFileRange> list) {
        this.mVersionCode = i;
        this.zzasi = j;
        this.zzasj = j2;
        this.zzBc = i2;
        this.zzask = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzay.zza(this, parcel, i);
    }

    public long zztq() {
        return this.zzasi;
    }

    public long zztr() {
        return this.zzasj;
    }
}
