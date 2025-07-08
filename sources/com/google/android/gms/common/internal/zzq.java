package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzq extends IInterface {

    public static abstract class zza extends Binder implements zzq {

        /* renamed from: com.google.android.gms.common.internal.zzq$zza$zza  reason: collision with other inner class name */
        private static class C0006zza implements zzq {
            private IBinder zzoz;

            C0006zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void cancel() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ICancelToken");
                    this.zzoz.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzq zzaQ(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICancelToken");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzq)) ? new C0006zza(iBinder) : (zzq) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 2) {
                parcel.enforceInterface("com.google.android.gms.common.internal.ICancelToken");
                cancel();
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.common.internal.ICancelToken");
                return true;
            }
        }
    }

    void cancel() throws RemoteException;
}
