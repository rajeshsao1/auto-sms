package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzp;
import com.google.android.gms.common.internal.zzt;

public interface zze extends IInterface {

    public static abstract class zza extends Binder implements zze {

        /* renamed from: com.google.android.gms.signin.internal.zze$zza$zza  reason: collision with other inner class name */
        private static class C0044zza implements zze {
            private IBinder zzoz;

            C0044zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(int i, Account account, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (authAccountRequest != null) {
                        obtain.writeInt(1);
                        authAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ResolveAccountRequest resolveAccountRequest, zzt zzt) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (resolveAccountRequest != null) {
                        obtain.writeInt(1);
                        resolveAccountRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzt != null ? zzt.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzp zzp, int i, boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzp != null ? zzp.asBinder() : null);
                    obtain.writeInt(i);
                    obtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (checkServerAuthResult != null) {
                        obtain.writeInt(1);
                        checkServerAuthResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (recordConsentRequest != null) {
                        obtain.writeInt(1);
                        recordConsentRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    if (signInRequest != null) {
                        obtain.writeInt(1);
                        signInRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzav(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzka(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInService");
                    obtain.writeInt(i);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zze zzeb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zze)) ? new C0044zza(iBinder) : (zze) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.common.internal.AuthAccountRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.signin.internal.CheckServerAuthResult} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.common.internal.ResolveAccountRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: android.accounts.Account} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.signin.internal.RecordConsentRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v18, resolved type: com.google.android.gms.signin.internal.SignInRequest} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v21 */
        /* JADX WARNING: type inference failed for: r1v22 */
        /* JADX WARNING: type inference failed for: r1v23 */
        /* JADX WARNING: type inference failed for: r1v24 */
        /* JADX WARNING: type inference failed for: r1v25 */
        /* JADX WARNING: type inference failed for: r1v26 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 2
                r1 = 0
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInService"
                r3 = 1
                if (r6 == r0) goto L_0x00fb
                r0 = 3
                if (r6 == r0) goto L_0x00e4
                r0 = 4
                r4 = 0
                if (r6 == r0) goto L_0x00d5
                r0 = 5
                if (r6 == r0) goto L_0x00b6
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r6 == r0) goto L_0x00b2
                switch(r6) {
                    case 7: goto L_0x00a7;
                    case 8: goto L_0x0086;
                    case 9: goto L_0x006c;
                    case 10: goto L_0x004e;
                    case 11: goto L_0x003f;
                    case 12: goto L_0x001e;
                    default: goto L_0x0019;
                }
            L_0x0019:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
                return r0
            L_0x001e:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0030
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.SignInRequest> r0 = com.google.android.gms.signin.internal.SignInRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.signin.internal.SignInRequest r1 = (com.google.android.gms.signin.internal.SignInRequest) r1
            L_0x0030:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r0 = com.google.android.gms.signin.internal.zzd.zza.zzea(r0)
                r5.zza((com.google.android.gms.signin.internal.SignInRequest) r1, (com.google.android.gms.signin.internal.zzd) r0)
            L_0x003b:
                r8.writeNoException()
                return r3
            L_0x003f:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r0 = com.google.android.gms.signin.internal.zzd.zza.zzea(r0)
                r5.zzb(r0)
                goto L_0x003b
            L_0x004e:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0060
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.RecordConsentRequest> r0 = com.google.android.gms.signin.internal.RecordConsentRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.signin.internal.RecordConsentRequest r1 = (com.google.android.gms.signin.internal.RecordConsentRequest) r1
            L_0x0060:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r0 = com.google.android.gms.signin.internal.zzd.zza.zzea(r0)
                r5.zza((com.google.android.gms.signin.internal.RecordConsentRequest) r1, (com.google.android.gms.signin.internal.zzd) r0)
                goto L_0x003b
            L_0x006c:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzp r0 = com.google.android.gms.common.internal.zzp.zza.zzaP(r0)
                int r1 = r7.readInt()
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0082
                r4 = 1
            L_0x0082:
                r5.zza((com.google.android.gms.common.internal.zzp) r0, (int) r1, (boolean) r4)
                goto L_0x003b
            L_0x0086:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x009b
                android.os.Parcelable$Creator r1 = android.accounts.Account.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r7)
                android.accounts.Account r1 = (android.accounts.Account) r1
            L_0x009b:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r2 = com.google.android.gms.signin.internal.zzd.zza.zzea(r2)
                r5.zza((int) r0, (android.accounts.Account) r1, (com.google.android.gms.signin.internal.zzd) r2)
                goto L_0x003b
            L_0x00a7:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                r5.zzka(r0)
                goto L_0x003b
            L_0x00b2:
                r8.writeString(r2)
                return r3
            L_0x00b6:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x00c8
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.ResolveAccountRequest> r0 = com.google.android.gms.common.internal.ResolveAccountRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.common.internal.ResolveAccountRequest r1 = (com.google.android.gms.common.internal.ResolveAccountRequest) r1
            L_0x00c8:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.common.internal.zzt r0 = com.google.android.gms.common.internal.zzt.zza.zzaT(r0)
                r5.zza((com.google.android.gms.common.internal.ResolveAccountRequest) r1, (com.google.android.gms.common.internal.zzt) r0)
                goto L_0x003b
            L_0x00d5:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x00df
                r4 = 1
            L_0x00df:
                r5.zzav(r4)
                goto L_0x003b
            L_0x00e4:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x00f6
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.CheckServerAuthResult> r0 = com.google.android.gms.signin.internal.CheckServerAuthResult.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.signin.internal.CheckServerAuthResult r1 = (com.google.android.gms.signin.internal.CheckServerAuthResult) r1
            L_0x00f6:
                r5.zza(r1)
                goto L_0x003b
            L_0x00fb:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x010d
                android.os.Parcelable$Creator<com.google.android.gms.common.internal.AuthAccountRequest> r0 = com.google.android.gms.common.internal.AuthAccountRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.common.internal.AuthAccountRequest r1 = (com.google.android.gms.common.internal.AuthAccountRequest) r1
            L_0x010d:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.signin.internal.zzd r0 = com.google.android.gms.signin.internal.zzd.zza.zzea(r0)
                r5.zza((com.google.android.gms.common.internal.AuthAccountRequest) r1, (com.google.android.gms.signin.internal.zzd) r0)
                goto L_0x003b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.zze.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(int i, Account account, zzd zzd) throws RemoteException;

    void zza(AuthAccountRequest authAccountRequest, zzd zzd) throws RemoteException;

    void zza(ResolveAccountRequest resolveAccountRequest, zzt zzt) throws RemoteException;

    void zza(zzp zzp, int i, boolean z) throws RemoteException;

    void zza(CheckServerAuthResult checkServerAuthResult) throws RemoteException;

    void zza(RecordConsentRequest recordConsentRequest, zzd zzd) throws RemoteException;

    void zza(SignInRequest signInRequest, zzd zzd) throws RemoteException;

    void zzav(boolean z) throws RemoteException;

    void zzb(zzd zzd) throws RemoteException;

    void zzka(int i) throws RemoteException;
}
