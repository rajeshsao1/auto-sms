package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.drive.events.internal.TransferProgressData;
import java.util.List;

public final class TransferStateEvent implements DriveEvent {
    public static final Parcelable.Creator<TransferStateEvent> CREATOR = new zzp();
    final int mVersionCode;
    final String zzVa;
    final List<TransferProgressData> zzapU;

    TransferStateEvent(int i, String str, List<TransferProgressData> list) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzapU = list;
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
        TransferStateEvent transferStateEvent = (TransferStateEvent) obj;
        return zzw.equal(this.zzVa, transferStateEvent.zzVa) && zzw.equal(this.zzapU, transferStateEvent.zzapU);
    }

    public int getType() {
        return 7;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzVa, this.zzapU);
    }

    public String toString() {
        return String.format("TransferStateEvent[%s]", new Object[]{TextUtils.join("','", this.zzapU)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzp.zza(this, parcel, i);
    }
}
