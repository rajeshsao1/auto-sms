package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;

public interface zzas extends IInterface {

    public static abstract class zza extends Binder implements zzas {

        /* renamed from: com.google.android.gms.internal.zzas$zza$zza  reason: collision with other inner class name */
        private static class C0033zza implements zzas {
            private IBinder zzoz;

            C0033zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public Bundle zza(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zza(Account account, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zza(Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zza(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle zza(String str, String str2, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AccountChangeEventsResponse zza(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.auth.IAuthManagerService");
                    if (accountChangeEventsRequest != null) {
                        obtain.writeInt(1);
                        accountChangeEventsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? AccountChangeEventsResponse.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzas zza(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.auth.IAuthManagerService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzas)) ? new C0033zza(iBinder) : (zzas) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.gms.auth.AccountChangeEventsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: android.os.Bundle} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: android.accounts.Account} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v31 */
        /* JADX WARNING: type inference failed for: r1v32 */
        /* JADX WARNING: type inference failed for: r1v33 */
        /* JADX WARNING: type inference failed for: r1v34 */
        /* JADX WARNING: type inference failed for: r1v35 */
        /* JADX WARNING: type inference failed for: r1v36 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r7, android.os.Parcel r8, android.os.Parcel r9, int r10) throws android.os.RemoteException {
            /*
                r6 = this;
                r0 = 0
                r1 = 0
                java.lang.String r2 = "com.google.android.auth.IAuthManagerService"
                r3 = 1
                if (r7 == r3) goto L_0x00f5
                r4 = 2
                if (r7 == r4) goto L_0x00cc
                r4 = 3
                if (r7 == r4) goto L_0x00a7
                r4 = 5
                if (r7 == r4) goto L_0x006e
                r4 = 6
                if (r7 == r4) goto L_0x0049
                r4 = 7
                if (r7 == r4) goto L_0x0024
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r7 == r0) goto L_0x0020
                boolean r0 = super.onTransact(r7, r8, r9, r10)
                return r0
            L_0x0020:
                r9.writeString(r2)
                return r3
            L_0x0024:
                r8.enforceInterface(r2)
                int r2 = r8.readInt()
                if (r2 == 0) goto L_0x0035
                android.os.Parcelable$Creator r1 = android.accounts.Account.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r8)
                android.accounts.Account r1 = (android.accounts.Account) r1
            L_0x0035:
                android.os.Bundle r1 = r6.zza((android.accounts.Account) r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x0045
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x0048
            L_0x0045:
                r9.writeInt(r0)
            L_0x0048:
                return r3
            L_0x0049:
                r8.enforceInterface(r2)
                int r2 = r8.readInt()
                if (r2 == 0) goto L_0x005a
                android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r8)
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x005a:
                android.os.Bundle r1 = r6.zza((android.os.Bundle) r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x006a
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x006d
            L_0x006a:
                r9.writeInt(r0)
            L_0x006d:
                return r3
            L_0x006e:
                r8.enforceInterface(r2)
                int r2 = r8.readInt()
                if (r2 == 0) goto L_0x0080
                android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r8)
                android.accounts.Account r2 = (android.accounts.Account) r2
                goto L_0x0081
            L_0x0080:
                r2 = r1
            L_0x0081:
                java.lang.String r4 = r8.readString()
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x0093
                android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r8)
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x0093:
                android.os.Bundle r1 = r6.zza((android.accounts.Account) r2, (java.lang.String) r4, (android.os.Bundle) r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x00a3
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x00a6
            L_0x00a3:
                r9.writeInt(r0)
            L_0x00a6:
                return r3
            L_0x00a7:
                r8.enforceInterface(r2)
                int r2 = r8.readInt()
                if (r2 == 0) goto L_0x00b8
                android.os.Parcelable$Creator<com.google.android.gms.auth.AccountChangeEventsRequest> r1 = com.google.android.gms.auth.AccountChangeEventsRequest.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r8)
                com.google.android.gms.auth.AccountChangeEventsRequest r1 = (com.google.android.gms.auth.AccountChangeEventsRequest) r1
            L_0x00b8:
                com.google.android.gms.auth.AccountChangeEventsResponse r1 = r6.zza((com.google.android.gms.auth.AccountChangeEventsRequest) r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x00c8
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x00cb
            L_0x00c8:
                r9.writeInt(r0)
            L_0x00cb:
                return r3
            L_0x00cc:
                r8.enforceInterface(r2)
                java.lang.String r2 = r8.readString()
                int r4 = r8.readInt()
                if (r4 == 0) goto L_0x00e1
                android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r8)
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x00e1:
                android.os.Bundle r1 = r6.zza(r2, r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x00f1
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x00f4
            L_0x00f1:
                r9.writeInt(r0)
            L_0x00f4:
                return r3
            L_0x00f5:
                r8.enforceInterface(r2)
                java.lang.String r2 = r8.readString()
                java.lang.String r4 = r8.readString()
                int r5 = r8.readInt()
                if (r5 == 0) goto L_0x010e
                android.os.Parcelable$Creator r1 = android.os.Bundle.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r8)
                android.os.Bundle r1 = (android.os.Bundle) r1
            L_0x010e:
                android.os.Bundle r1 = r6.zza((java.lang.String) r2, (java.lang.String) r4, (android.os.Bundle) r1)
                r9.writeNoException()
                if (r1 == 0) goto L_0x011e
                r9.writeInt(r3)
                r1.writeToParcel(r9, r3)
                goto L_0x0121
            L_0x011e:
                r9.writeInt(r0)
            L_0x0121:
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzas.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    Bundle zza(Account account) throws RemoteException;

    Bundle zza(Account account, String str, Bundle bundle) throws RemoteException;

    Bundle zza(Bundle bundle) throws RemoteException;

    Bundle zza(String str, Bundle bundle) throws RemoteException;

    Bundle zza(String str, String str2, Bundle bundle) throws RemoteException;

    AccountChangeEventsResponse zza(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException;
}
