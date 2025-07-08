package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzat extends IInterface {

    public static abstract class zza extends Binder implements zzat {

        /* renamed from: com.google.android.gms.internal.zzat$zza$zza  reason: collision with other inner class name */
        private static class C0034zza implements zzat {
            private IBinder zzoz;

            C0034zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public String getId() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeString(str);
                    obtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean zzc(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean z2 = true;
                    obtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String zzo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    obtain.writeString(str);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzat zzb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzat)) ? new C0034zza(iBinder) : (zzat) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i != 1) {
                boolean z = false;
                if (i == 2) {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    boolean zzc = zzc(z);
                    parcel2.writeNoException();
                    parcel2.writeInt(zzc ? 1 : 0);
                    return true;
                } else if (i == 3) {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String zzo = zzo(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(zzo);
                    return true;
                } else if (i == 4) {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String readString = parcel.readString();
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    zzb(readString, z);
                    parcel2.writeNoException();
                    return true;
                } else if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel2.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    return true;
                }
            } else {
                parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                String id = getId();
                parcel2.writeNoException();
                parcel2.writeString(id);
                return true;
            }
        }
    }

    String getId() throws RemoteException;

    void zzb(String str, boolean z) throws RemoteException;

    boolean zzc(boolean z) throws RemoteException;

    String zzo(String str) throws RemoteException;
}
