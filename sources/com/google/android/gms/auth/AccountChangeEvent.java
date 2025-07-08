package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

public class AccountChangeEvent implements SafeParcelable {
    public static final Parcelable.Creator<AccountChangeEvent> CREATOR = new zza();
    final int mVersion;
    final long zzUZ;
    final String zzVa;
    final int zzVb;
    final int zzVc;
    final String zzVd;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.mVersion = i;
        this.zzUZ = j;
        this.zzVa = (String) zzx.zzz(str);
        this.zzVb = i2;
        this.zzVc = i3;
        this.zzVd = str2;
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        this.mVersion = 1;
        this.zzUZ = j;
        this.zzVa = (String) zzx.zzz(str);
        this.zzVb = i;
        this.zzVc = i2;
        this.zzVd = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.mVersion == accountChangeEvent.mVersion && this.zzUZ == accountChangeEvent.zzUZ && zzw.equal(this.zzVa, accountChangeEvent.zzVa) && this.zzVb == accountChangeEvent.zzVb && this.zzVc == accountChangeEvent.zzVc && zzw.equal(this.zzVd, accountChangeEvent.zzVd);
    }

    public String getAccountName() {
        return this.zzVa;
    }

    public String getChangeData() {
        return this.zzVd;
    }

    public int getChangeType() {
        return this.zzVb;
    }

    public int getEventIndex() {
        return this.zzVc;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersion), Long.valueOf(this.zzUZ), this.zzVa, Integer.valueOf(this.zzVb), Integer.valueOf(this.zzVc), this.zzVd);
    }

    public String toString() {
        int i = this.zzVb;
        String str = i != 1 ? i != 2 ? i != 3 ? i != 4 ? "UNKNOWN" : "RENAMED_TO" : "RENAMED_FROM" : "REMOVED" : "ADDED";
        return "AccountChangeEvent {accountName = " + this.zzVa + ", changeType = " + str + ", changeData = " + this.zzVd + ", eventIndex = " + this.zzVc + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
