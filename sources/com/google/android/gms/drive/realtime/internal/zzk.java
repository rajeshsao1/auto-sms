package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zzk extends IInterface {

    public static abstract class zza extends Binder implements zzk {

        /* renamed from: com.google.android.gms.drive.realtime.internal.zzk$zza$zza  reason: collision with other inner class name */
        private static class C0024zza implements zzk {
            private IBinder zzoz;

            C0024zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
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

            public void zza(ParcelableIndexReference parcelableIndexReference) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzk zzbm(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzk)) ? new C0024zza(iBinder) : (zzk) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.gms.drive.realtime.internal.ParcelableIndexReference} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX WARNING: type inference failed for: r0v0 */
        /* JADX WARNING: type inference failed for: r0v11 */
        /* JADX WARNING: type inference failed for: r0v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 0
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IIndexReferenceCallback"
                r2 = 1
                if (r5 == r2) goto L_0x002f
                r3 = 2
                if (r5 == r3) goto L_0x0017
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r5 == r0) goto L_0x0013
                boolean r0 = super.onTransact(r5, r6, r7, r8)
                return r0
            L_0x0013:
                r7.writeString(r1)
                return r2
            L_0x0017:
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0028
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            L_0x0028:
                r4.onError(r0)
            L_0x002b:
                r7.writeNoException()
                return r2
            L_0x002f:
                r6.enforceInterface(r1)
                int r1 = r6.readInt()
                if (r1 == 0) goto L_0x0040
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.ParcelableIndexReference> r0 = com.google.android.gms.drive.realtime.internal.ParcelableIndexReference.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.drive.realtime.internal.ParcelableIndexReference r0 = (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r0
            L_0x0040:
                r4.zza(r0)
                goto L_0x002b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.realtime.internal.zzk.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onError(Status status) throws RemoteException;

    void zza(ParcelableIndexReference parcelableIndexReference) throws RemoteException;
}
