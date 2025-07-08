package com.google.android.gms.drive.events.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.DriveId;

public class TransferProgressData implements SafeParcelable {
    public static final Parcelable.Creator<TransferProgressData> CREATOR = new zzc();
    final int mVersionCode;
    final int zzBc;
    final DriveId zzaoz;
    final int zzapT;
    final long zzapW;
    final long zzapX;

    TransferProgressData(int i, int i2, DriveId driveId, int i3, long j, long j2) {
        this.mVersionCode = i;
        this.zzapT = i2;
        this.zzaoz = driveId;
        this.zzBc = i3;
        this.zzapW = j;
        this.zzapX = j2;
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
        TransferProgressData transferProgressData = (TransferProgressData) obj;
        return this.zzapT == transferProgressData.zzapT && zzw.equal(this.zzaoz, transferProgressData.zzaoz) && this.zzBc == transferProgressData.zzBc && this.zzapW == transferProgressData.zzapW && this.zzapX == transferProgressData.zzapX;
    }

    public long getBytesTransferred() {
        return this.zzapW;
    }

    public DriveId getDriveId() {
        return this.zzaoz;
    }

    public int getStatus() {
        return this.zzBc;
    }

    public long getTotalBytes() {
        return this.zzapX;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX));
    }

    public String toString() {
        return String.format("TransferProgressData[TransferType: %d, DriveId: %s, status: %d, bytes transferred: %d, total bytes: %d]", new Object[]{Integer.valueOf(this.zzapT), this.zzaoz, Integer.valueOf(this.zzBc), Long.valueOf(this.zzapW), Long.valueOf(this.zzapX)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public int zztb() {
        return this.zzapT;
    }
}
