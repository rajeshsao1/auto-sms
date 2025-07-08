package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

public final class Status implements Result, SafeParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new zzc();
    public static final Status zzagC = new Status(0);
    public static final Status zzagD = new Status(14);
    public static final Status zzagE = new Status(8);
    public static final Status zzagF = new Status(15);
    public static final Status zzagG = new Status(16);
    private final PendingIntent mPendingIntent;
    private final int mVersionCode;
    private final int zzade;
    private final String zzafC;

    public Status(int i) {
        this(i, (String) null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.zzade = i2;
        this.zzafC = str;
        this.mPendingIntent = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, (PendingIntent) null);
    }

    public Status(int i, String str, PendingIntent pendingIntent) {
        this(1, i, str, pendingIntent);
    }

    private String zzpd() {
        String str = this.zzafC;
        return str != null ? str : CommonStatusCodes.getStatusCodeString(this.zzade);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.zzade == status.zzade && zzw.equal(this.zzafC, status.zzafC) && zzw.equal(this.mPendingIntent, status.mPendingIntent);
    }

    public PendingIntent getResolution() {
        return this.mPendingIntent;
    }

    public Status getStatus() {
        return this;
    }

    public int getStatusCode() {
        return this.zzade;
    }

    public String getStatusMessage() {
        return this.zzafC;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public boolean hasResolution() {
        return this.mPendingIntent != null;
    }

    public int hashCode() {
        return zzw.hashCode(Integer.valueOf(this.mVersionCode), Integer.valueOf(this.zzade), this.zzafC, this.mPendingIntent);
    }

    public boolean isCanceled() {
        return this.zzade == 16;
    }

    public boolean isInterrupted() {
        return this.zzade == 14;
    }

    public boolean isSuccess() {
        return this.zzade <= 0;
    }

    public void startResolutionForResult(Activity activity, int i) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), i, (Intent) null, 0, 0, 0);
        }
    }

    public String toString() {
        return zzw.zzy(this).zzg("statusCode", zzpd()).zzg("resolution", this.mPendingIntent).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public PendingIntent zzpc() {
        return this.mPendingIntent;
    }
}
