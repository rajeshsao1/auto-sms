package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

public interface zzu extends IInterface {

    public static abstract class zza extends Binder implements zzu {

        /* renamed from: com.google.android.gms.common.internal.zzu$zza$zza  reason: collision with other inner class name */
        private static class C0010zza implements zzu {
            private IBinder zzoz;

            C0010zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public zzd zza(zzd zzd, int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbs(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zza(zzd zzd, SignInButtonConfig signInButtonConfig) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.ISignInButtonCreator");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    if (signInButtonConfig != null) {
                        obtain.writeInt(1);
                        signInButtonConfig.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return zzd.zza.zzbs(obtain2.readStrongBinder());
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzu zzaU(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzu)) ? new C0010zza(iBinder) : (zzu) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            IBinder iBinder = null;
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                zzd zza = zza(zzd.zza.zzbs(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                parcel2.writeNoException();
                if (zza != null) {
                    iBinder = zza.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i == 2) {
                parcel.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
                zzd zza2 = zza(zzd.zza.zzbs(parcel.readStrongBinder()), parcel.readInt() != 0 ? SignInButtonConfig.CREATOR.createFromParcel(parcel) : null);
                parcel2.writeNoException();
                if (zza2 != null) {
                    iBinder = zza2.asBinder();
                }
                parcel2.writeStrongBinder(iBinder);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
                return true;
            }
        }
    }

    zzd zza(zzd zzd, int i, int i2) throws RemoteException;

    zzd zza(zzd zzd, SignInButtonConfig signInButtonConfig) throws RemoteException;
}
