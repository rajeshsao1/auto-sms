package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* renamed from: com.google.android.gms.drive.realtime.internal.zze$zza$zza  reason: collision with other inner class name */
        private static class C0018zza implements zze {
            private IBinder zzoz;

            C0018zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
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

            public void zza(ParcelableCollaborator[] parcelableCollaboratorArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                    obtain.writeTypedArray(parcelableCollaboratorArr, 0);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzbg(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C0018zza(iBinder) : (zze) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                zza((ParcelableCollaborator[]) parcel.createTypedArray(ParcelableCollaborator.CREATOR));
            } else if (i == 2) {
                parcel.enforceInterface("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                onError(parcel.readInt() != 0 ? Status.CREATOR.createFromParcel(parcel) : null);
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString("com.google.android.gms.drive.realtime.internal.ICollaboratorsCallback");
                return true;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onError(Status status) throws RemoteException;

    void zza(ParcelableCollaborator[] parcelableCollaboratorArr) throws RemoteException;
}
