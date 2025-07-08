package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParentDriveIdSet implements SafeParcelable {
    public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzl();
    final int mVersionCode;
    final List<PartialDriveId> zzasS;

    public ParentDriveIdSet() {
        this(1, new ArrayList());
    }

    ParentDriveIdSet(int i, List<PartialDriveId> list) {
        this.mVersionCode = i;
        this.zzasS = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzl.zza(this, parcel, i);
    }

    public Set<DriveId> zzD(long j) {
        HashSet hashSet = new HashSet();
        for (PartialDriveId zzE : this.zzasS) {
            hashSet.add(zzE.zzE(j));
        }
        return hashSet;
    }

    public void zza(PartialDriveId partialDriveId) {
        this.zzasS.add(partialDriveId);
    }
}
