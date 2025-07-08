package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.List;

public class SetResourceParentsRequest implements SafeParcelable {
    public static final Parcelable.Creator<SetResourceParentsRequest> CREATOR = new zzbt();
    final int mVersionCode;
    final DriveId zzaqf;
    final List<DriveId> zzasC;

    SetResourceParentsRequest(int i, DriveId driveId, List<DriveId> list) {
        this.mVersionCode = i;
        this.zzaqf = driveId;
        this.zzasC = list;
    }

    public SetResourceParentsRequest(DriveId driveId, List<DriveId> list) {
        this(1, driveId, list);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzbt.zza(this, parcel, i);
    }
}
