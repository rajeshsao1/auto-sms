package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.zzas;
import com.google.android.gms.internal.zzsu;

public class ChangeSequenceNumber implements SafeParcelable {
    public static final Parcelable.Creator<ChangeSequenceNumber> CREATOR = new zza();
    final int mVersionCode;
    final long zzaot;
    final long zzaou;
    final long zzaov;
    private volatile String zzaow = null;

    ChangeSequenceNumber(int i, long j, long j2, long j3) {
        boolean z = true;
        zzx.zzac(j != -1);
        zzx.zzac(j2 != -1);
        zzx.zzac(j3 == -1 ? false : z);
        this.mVersionCode = i;
        this.zzaot = j;
        this.zzaou = j2;
        this.zzaov = j3;
    }

    public int describeContents() {
        return 0;
    }

    public final String encodeToString() {
        if (this.zzaow == null) {
            String encodeToString = Base64.encodeToString(zzsu(), 10);
            this.zzaow = "ChangeSequenceNumber:" + encodeToString;
        }
        return this.zzaow;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ChangeSequenceNumber)) {
            return false;
        }
        ChangeSequenceNumber changeSequenceNumber = (ChangeSequenceNumber) obj;
        return changeSequenceNumber.zzaou == this.zzaou && changeSequenceNumber.zzaov == this.zzaov && changeSequenceNumber.zzaot == this.zzaot;
    }

    public int hashCode() {
        return (String.valueOf(this.zzaot) + String.valueOf(this.zzaou) + String.valueOf(this.zzaov)).hashCode();
    }

    public String toString() {
        return encodeToString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzsu() {
        zzas zzas = new zzas();
        zzas.versionCode = this.mVersionCode;
        zzas.zzarV = this.zzaot;
        zzas.zzarW = this.zzaou;
        zzas.zzarX = this.zzaov;
        return zzsu.toByteArray(zzas);
    }
}
