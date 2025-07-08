package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveSpace;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class TransferStateOptions implements SafeParcelable {
    public static final Parcelable.Creator<TransferStateOptions> CREATOR = new zzr();
    final int mVersionCode;
    final List<DriveSpace> zzapB;
    private final Set<DriveSpace> zzapC;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    TransferStateOptions(int i, List<DriveSpace> list) {
        this(i, list, list == null ? null : new HashSet(list));
    }

    private TransferStateOptions(int i, List<DriveSpace> list, Set<DriveSpace> set) {
        this.mVersionCode = i;
        this.zzapB = list;
        this.zzapC = set;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return zzw.equal(this.zzapC, ((TransferStateOptions) obj).zzapC);
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapC);
    }

    public String toString() {
        return String.format(Locale.US, "TransferStateOptions[Spaces=%s]", new Object[]{this.zzapB});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzr.zza(this, parcel, i);
    }
}
