package com.google.android.gms.signin.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;

public interface zzd extends IInterface {

    public static abstract class zza extends Binder implements zzd {

        /* renamed from: com.google.android.gms.signin.internal.zzd$zza$zza  reason: collision with other inner class name */
        private static class C0043zza implements zzd {
            private IBinder zzoz;

            C0043zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(ConnectionResult connectionResult, AuthAccountResult authAccountResult) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (connectionResult != null) {
                        obtain.writeInt(1);
                        connectionResult.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (authAccountResult != null) {
                        obtain.writeInt(1);
                        authAccountResult.writeToParcel(obtain, 0);
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

            public void zza(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (googleSignInAccount != null) {
                        obtain.writeInt(1);
                        googleSignInAccount.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(SignInResponse signInResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (signInResponse != null) {
                        obtain.writeInt(1);
                        signInResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzbl(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzbm(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.signin.internal.ISignInCallbacks");
                    if (status != null) {
                        obtain.writeInt(1);
                        status.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.signin.internal.ISignInCallbacks");
        }

        public static zzd zzea(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzd)) ? new C0043zza(iBinder) : (zzd) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: com.google.android.gms.signin.internal.AuthAccountResult} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: com.google.android.gms.auth.api.signin.GoogleSignInAccount} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v13, resolved type: com.google.android.gms.signin.internal.SignInResponse} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v16 */
        /* JADX WARNING: type inference failed for: r3v17 */
        /* JADX WARNING: type inference failed for: r3v18 */
        /* JADX WARNING: type inference failed for: r3v19 */
        /* JADX WARNING: type inference failed for: r3v20 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r5, android.os.Parcel r6, android.os.Parcel r7, int r8) throws android.os.RemoteException {
            /*
                r4 = this;
                r0 = 3
                r1 = 1
                java.lang.String r2 = "com.google.android.gms.signin.internal.ISignInCallbacks"
                r3 = 0
                if (r5 == r0) goto L_0x008d
                r0 = 4
                if (r5 == r0) goto L_0x0077
                r0 = 6
                if (r5 == r0) goto L_0x0061
                r0 = 7
                if (r5 == r0) goto L_0x003b
                r0 = 8
                if (r5 == r0) goto L_0x0022
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r5 == r0) goto L_0x001e
                boolean r0 = super.onTransact(r5, r6, r7, r8)
                return r0
            L_0x001e:
                r7.writeString(r2)
                return r1
            L_0x0022:
                r6.enforceInterface(r2)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x0034
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.SignInResponse> r0 = com.google.android.gms.signin.internal.SignInResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                r3 = r0
                com.google.android.gms.signin.internal.SignInResponse r3 = (com.google.android.gms.signin.internal.SignInResponse) r3
            L_0x0034:
                r4.zzb(r3)
            L_0x0037:
                r7.writeNoException()
                return r1
            L_0x003b:
                r6.enforceInterface(r2)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x004d
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
                goto L_0x004e
            L_0x004d:
                r0 = r3
            L_0x004e:
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x005d
                android.os.Parcelable$Creator<com.google.android.gms.auth.api.signin.GoogleSignInAccount> r2 = com.google.android.gms.auth.api.signin.GoogleSignInAccount.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r6)
                r3 = r2
                com.google.android.gms.auth.api.signin.GoogleSignInAccount r3 = (com.google.android.gms.auth.api.signin.GoogleSignInAccount) r3
            L_0x005d:
                r4.zza((com.google.android.gms.common.api.Status) r0, (com.google.android.gms.auth.api.signin.GoogleSignInAccount) r3)
                goto L_0x0037
            L_0x0061:
                r6.enforceInterface(r2)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x0073
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                r3 = r0
                com.google.android.gms.common.api.Status r3 = (com.google.android.gms.common.api.Status) r3
            L_0x0073:
                r4.zzbm(r3)
                goto L_0x0037
            L_0x0077:
                r6.enforceInterface(r2)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x0089
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                r3 = r0
                com.google.android.gms.common.api.Status r3 = (com.google.android.gms.common.api.Status) r3
            L_0x0089:
                r4.zzbl(r3)
                goto L_0x0037
            L_0x008d:
                r6.enforceInterface(r2)
                int r0 = r6.readInt()
                if (r0 == 0) goto L_0x009f
                android.os.Parcelable$Creator<com.google.android.gms.common.ConnectionResult> r0 = com.google.android.gms.common.ConnectionResult.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r6)
                com.google.android.gms.common.ConnectionResult r0 = (com.google.android.gms.common.ConnectionResult) r0
                goto L_0x00a0
            L_0x009f:
                r0 = r3
            L_0x00a0:
                int r2 = r6.readInt()
                if (r2 == 0) goto L_0x00af
                android.os.Parcelable$Creator<com.google.android.gms.signin.internal.AuthAccountResult> r2 = com.google.android.gms.signin.internal.AuthAccountResult.CREATOR
                java.lang.Object r2 = r2.createFromParcel(r6)
                r3 = r2
                com.google.android.gms.signin.internal.AuthAccountResult r3 = (com.google.android.gms.signin.internal.AuthAccountResult) r3
            L_0x00af:
                r4.zza((com.google.android.gms.common.ConnectionResult) r0, (com.google.android.gms.signin.internal.AuthAccountResult) r3)
                goto L_0x0037
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.signin.internal.zzd.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(ConnectionResult connectionResult, AuthAccountResult authAccountResult) throws RemoteException;

    void zza(Status status, GoogleSignInAccount googleSignInAccount) throws RemoteException;

    void zzb(SignInResponse signInResponse) throws RemoteException;

    void zzbl(Status status) throws RemoteException;

    void zzbm(Status status) throws RemoteException;
}
