package com.google.android.gms.playlog.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public interface zza extends IInterface {

    /* renamed from: com.google.android.gms.playlog.internal.zza$zza  reason: collision with other inner class name */
    public static abstract class C0041zza extends Binder implements zza {

        /* renamed from: com.google.android.gms.playlog.internal.zza$zza$zza  reason: collision with other inner class name */
        private static class C0042zza implements zza {
            private IBinder zzoz;

            C0042zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (logEvent != null) {
                        obtain.writeInt(1);
                        logEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeTypedList(list);
                    this.zzoz.transact(3, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.playlog.internal.IPlayLogService");
                    obtain.writeString(str);
                    if (playLoggerContext != null) {
                        obtain.writeInt(1);
                        playLoggerContext.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeByteArray(bArr);
                    this.zzoz.transact(4, obtain, (Parcel) null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zza zzdN(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.playlog.internal.IPlayLogService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new C0042zza(iBinder) : (zza) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.playlog.internal.LogEvent} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.playlog.internal.PlayLoggerContext} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.playlog.internal.PlayLoggerContext} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v10 */
        /* JADX WARNING: type inference failed for: r1v11 */
        /* JADX WARNING: type inference failed for: r1v12 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 2
                r1 = 0
                r2 = 1
                java.lang.String r3 = "com.google.android.gms.playlog.internal.IPlayLogService"
                if (r6 == r0) goto L_0x0053
                r0 = 3
                if (r6 == r0) goto L_0x0036
                r0 = 4
                if (r6 == r0) goto L_0x001b
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r6 == r0) goto L_0x0017
                boolean r0 = super.onTransact(r6, r7, r8, r9)
                return r0
            L_0x0017:
                r8.writeString(r3)
                return r2
            L_0x001b:
                r7.enforceInterface(r3)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x002e
                com.google.android.gms.playlog.internal.zze r1 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = r1.createFromParcel(r7)
            L_0x002e:
                byte[] r3 = r7.createByteArray()
                r5.zza((java.lang.String) r0, (com.google.android.gms.playlog.internal.PlayLoggerContext) r1, (byte[]) r3)
                return r2
            L_0x0036:
                r7.enforceInterface(r3)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x0049
                com.google.android.gms.playlog.internal.zze r1 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r1 = r1.createFromParcel(r7)
            L_0x0049:
                com.google.android.gms.playlog.internal.zzc r3 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                java.util.ArrayList r3 = r7.createTypedArrayList(r3)
                r5.zza((java.lang.String) r0, (com.google.android.gms.playlog.internal.PlayLoggerContext) r1, (java.util.List<com.google.android.gms.playlog.internal.LogEvent>) r3)
                return r2
            L_0x0053:
                r7.enforceInterface(r3)
                java.lang.String r0 = r7.readString()
                int r3 = r7.readInt()
                if (r3 == 0) goto L_0x0067
                com.google.android.gms.playlog.internal.zze r3 = com.google.android.gms.playlog.internal.PlayLoggerContext.CREATOR
                com.google.android.gms.playlog.internal.PlayLoggerContext r3 = r3.createFromParcel(r7)
                goto L_0x0068
            L_0x0067:
                r3 = r1
            L_0x0068:
                int r4 = r7.readInt()
                if (r4 == 0) goto L_0x0074
                com.google.android.gms.playlog.internal.zzc r1 = com.google.android.gms.playlog.internal.LogEvent.CREATOR
                com.google.android.gms.playlog.internal.LogEvent r1 = r1.createFromParcel(r7)
            L_0x0074:
                r5.zza((java.lang.String) r0, (com.google.android.gms.playlog.internal.PlayLoggerContext) r3, (com.google.android.gms.playlog.internal.LogEvent) r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.playlog.internal.zza.C0041zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(String str, PlayLoggerContext playLoggerContext, LogEvent logEvent) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, List<LogEvent> list) throws RemoteException;

    void zza(String str, PlayLoggerContext playLoggerContext, byte[] bArr) throws RemoteException;
}
