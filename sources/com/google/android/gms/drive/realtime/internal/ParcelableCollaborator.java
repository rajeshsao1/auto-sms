package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator implements SafeParcelable {
    public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new zzq();
    final int mVersionCode;
    final String zzLq;
    final String zzWQ;
    final boolean zzaeW;
    final boolean zzauI;
    final String zzauJ;
    final String zzauK;
    final String zzrG;

    ParcelableCollaborator(int i, boolean z, boolean z2, String str, String str2, String str3, String str4, String str5) {
        this.mVersionCode = i;
        this.zzauI = z;
        this.zzaeW = z2;
        this.zzLq = str;
        this.zzrG = str2;
        this.zzWQ = str3;
        this.zzauJ = str4;
        this.zzauK = str5;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ParcelableCollaborator)) {
            return false;
        }
        return this.zzLq.equals(((ParcelableCollaborator) obj).zzLq);
    }

    public int hashCode() {
        return this.zzLq.hashCode();
    }

    public String toString() {
        return "Collaborator [isMe=" + this.zzauI + ", isAnonymous=" + this.zzaeW + ", sessionId=" + this.zzLq + ", userId=" + this.zzrG + ", displayName=" + this.zzWQ + ", color=" + this.zzauJ + ", photoUrl=" + this.zzauK + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzq.zza(this, parcel, i);
    }
}
