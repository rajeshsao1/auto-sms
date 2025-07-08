package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.TransferStateEvent;

public class OnEventResponse implements SafeParcelable {
    public static final Parcelable.Creator<OnEventResponse> CREATOR = new zzba();
    final int mVersionCode;
    final int zzanf;
    final ChangeEvent zzasl;
    final CompletionEvent zzasm;
    final QueryResultEventParcelable zzasn;
    final ChangesAvailableEvent zzaso;
    final TransferStateEvent zzasp;
    final TransferProgressEvent zzasq;

    OnEventResponse(int i, int i2, ChangeEvent changeEvent, CompletionEvent completionEvent, QueryResultEventParcelable queryResultEventParcelable, ChangesAvailableEvent changesAvailableEvent, TransferStateEvent transferStateEvent, TransferProgressEvent transferProgressEvent) {
        this.mVersionCode = i;
        this.zzanf = i2;
        this.zzasl = changeEvent;
        this.zzasm = completionEvent;
        this.zzasn = queryResultEventParcelable;
        this.zzaso = changesAvailableEvent;
        this.zzasp = transferStateEvent;
        this.zzasq = transferProgressEvent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzba.zza(this, parcel, i);
    }

    public DriveEvent zzts() {
        int i = this.zzanf;
        if (i == 1) {
            return this.zzasl;
        }
        if (i == 2) {
            return this.zzasm;
        }
        if (i == 3) {
            return this.zzasn;
        }
        if (i == 4) {
            return this.zzaso;
        }
        if (i == 7) {
            return this.zzasp;
        }
        if (i == 8) {
            return this.zzasq;
        }
        throw new IllegalStateException("Unexpected event type " + this.zzanf);
    }
}
