package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.internal.zzlx;

public interface zzly extends IInterface {

    public static abstract class zza extends Binder implements zzly {

        /* renamed from: com.google.android.gms.internal.zzly$zza$zza  reason: collision with other inner class name */
        private static class C0036zza implements zzly {
            private IBinder zzoz;

            C0036zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzlx zzlx, LogEventParcelable logEventParcelable) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                    obtain.writeStrongBinder(zzlx != null ? zzlx.asBinder() : null);
                    if (logEventParcelable != null) {
                        obtain.writeInt(1);
                        logEventParcelable.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzly zzaM(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzly)) ? new C0036zza(iBinder) : (zzly) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                zza(zzlx.zza.zzaL(parcel.readStrongBinder()), parcel.readInt() != 0 ? LogEventParcelable.CREATOR.createFromParcel(parcel) : null);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.clearcut.internal.IClearcutLoggerService");
                return true;
            }
        }
    }

    void zza(zzlx zzlx, LogEventParcelable logEventParcelable) throws RemoteException;
}
