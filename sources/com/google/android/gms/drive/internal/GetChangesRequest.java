package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetChangesRequest implements SafeParcelable {
    public static final Parcelable.Creator<GetChangesRequest> CREATOR = new zzah();
    final int mVersionCode;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;
    final ChangeSequenceNumber zzarJ;
    final int zzarK;
    final boolean zzarL;

    private GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list, Set<DriveSpace> set, boolean z) {
        this.mVersionCode = i;
        this.zzarJ = changeSequenceNumber;
        this.zzarK = i2;
        this.zzapB = list;
        this.zzapC = set;
        this.zzarL = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    GetChangesRequest(int i, ChangeSequenceNumber changeSequenceNumber, int i2, List<DriveSpace> list, boolean z) {
        this(i, changeSequenceNumber, i2, list, list == null ? null : new HashSet(list), z);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzah.zza(this, parcel, i);
    }
}
