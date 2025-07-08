package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.zzmk;

public interface zzml extends IInterface {

    public static abstract class zza extends Binder implements zzml {

        /* renamed from: com.google.android.gms.internal.zzml$zza$zza  reason: collision with other inner class name */
        private static class C0039zza implements zzml {
            private IBinder zzoz;

            C0039zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(zzmk zzmk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    obtain.writeStrongBinder(zzmk != null ? zzmk.asBinder() : null);
                    this.zzoz.transact(1, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzml zzaY(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzml)) ? new C0039zza(iBinder) : (zzml) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                zza(zzmk.zza.zzaX(parcel.readStrongBinder()));
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
                return true;
            }
        }
    }

    void zza(zzmk zzmk) throws RemoteException;
}
