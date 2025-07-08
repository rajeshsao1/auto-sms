package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new Parcelable.Creator<BinderWrapper>() {
        /* renamed from: zzan */
        public BinderWrapper createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        /* renamed from: zzbQ */
        public BinderWrapper[] newArray(int i) {
            return new BinderWrapper[i];
        }
    };
    private IBinder zzakD;

    public BinderWrapper() {
        this.zzakD = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.zzakD = null;
        this.zzakD = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzakD = null;
        this.zzakD = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.zzakD);
    }
}
