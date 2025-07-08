package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import java.util.Locale;

public final class ChangesAvailableEvent implements SafeParcelable, DriveEvent {
    public static final Parcelable.Creator<ChangesAvailableEvent> CREATOR = new zzb();
    final int mVersionCode;
    final String zzVa;
    final ChangesAvailableOptions zzapy;

    ChangesAvailableEvent(int i, String str, ChangesAvailableOptions changesAvailableOptions) {
        this.mVersionCode = i;
        this.zzVa = str;
        this.zzapy = changesAvailableOptions;
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
        ChangesAvailableEvent changesAvailableEvent = (ChangesAvailableEvent) obj;
        return zzw.equal(this.zzapy, changesAvailableEvent.zzapy) && zzw.equal(this.zzVa, changesAvailableEvent.zzVa);
    }

    public int getType() {
        return 4;
    }

    public int hashCode() {
        return zzw.hashCode(this.zzapy, this.zzVa);
    }

    public String toString() {
        return String.format(Locale.US, "ChangesAvailableEvent [changesAvailableOptions=%s]", new Object[]{this.zzapy});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
