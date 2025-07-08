package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class ChangeResourceParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<ChangeResourceParentsRequest> CREATOR = new zzf();
    final int mVersionCode;
    final DriveId zzaqf;
    final List<DriveId> zzaqg;
    final List<DriveId> zzaqh;

    ChangeResourceParentsRequest(int i, DriveId driveId, List<DriveId> list, List<DriveId> list2) {
        this.mVersionCode = i;
        this.zzaqf = driveId;
        this.zzaqg = list;
        this.zzaqh = list2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }
}
