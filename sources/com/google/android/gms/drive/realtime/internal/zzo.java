package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zzo extends IInterface {

    public static abstract class zza extends Binder implements zzo {

        /* renamed from: com.google.android.gms.drive.realtime.internal.zzo$zza$zza  reason: collision with other inner class name */
        private static class C0028zza implements zzo {
            private IBinder zzoz;

            C0028zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzo zzbq(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzo)) ? new C0028zza(iBinder) : (zzo) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                onSuccess();
            } else if (i == 2) {
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                onError(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.drive.realtime.internal.ISuccessCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onError(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;
}
