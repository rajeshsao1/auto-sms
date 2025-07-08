package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.internal.TransferProgressData;

public final class TransferProgressEvent implements DriveEvent {
    public static final Parcelable.Creator<TransferProgressEvent> CREATOR = new zzn();
    final int mVersionCode;
    final TransferProgressData zzapS;

    TransferProgressEvent(int i, TransferProgressData transferProgressData) {
        this.mVersionCode = i;
        this.zzapS = transferProgressData;
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
        return zzw.equal(this.zzapS, ((TransferProgressEvent) obj).zzapS);
    }

    public int getType() {
        return 8;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapS);
    }

    public String toString() {
        return String.format("TransferProgressEvent[%s]", new Object[]{this.zzapS.toString()});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public TransferProgressData zzta() {
        return this.zzapS;
    }
}
