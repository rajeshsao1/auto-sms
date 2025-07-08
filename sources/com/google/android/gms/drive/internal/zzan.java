package com.google.android.gms.drive.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.ChangeSequenceNumber;
import com.google.android.gms.drive.realtime.internal.zzm;

public interface zzan extends IInterface {

    public static abstract class zza extends Binder implements zzan {

        /* renamed from: com.google.android.gms.drive.internal.zzan$zza$zza  reason: collision with other inner class name */
        private static class C0013zza implements zzan {
            private IBinder zzoz;

            C0013zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void onError(Status status) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
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

            public void onSuccess() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (changeSequenceNumber != null) {
                        obtain.writeInt(1);
                        changeSequenceNumber.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (getPermissionsResponse != null) {
                        obtain.writeInt(1);
                        getPermissionsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnChangesResponse onChangesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onChangesResponse != null) {
                        obtain.writeInt(1);
                        onChangesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnContentsResponse onContentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onContentsResponse != null) {
                        obtain.writeInt(1);
                        onContentsResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDeviceUsagePreferenceResponse != null) {
                        obtain.writeInt(1);
                        onDeviceUsagePreferenceResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDownloadProgressResponse != null) {
                        obtain.writeInt(1);
                        onDownloadProgressResponse.writeToParcel(obtain, 0);
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

            public void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onDriveIdResponse != null) {
                        obtain.writeInt(1);
                        onDriveIdResponse.writeToParcel(obtain, 0);
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

            public void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onFetchThumbnailResponse != null) {
                        obtain.writeInt(1);
                        onFetchThumbnailResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListEntriesResponse != null) {
                        obtain.writeInt(1);
                        onListEntriesResponse.writeToParcel(obtain, 0);
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

            public void zza(OnListParentsResponse onListParentsResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onListParentsResponse != null) {
                        obtain.writeInt(1);
                        onListParentsResponse.writeToParcel(obtain, 0);
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

            public void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm zzm) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onLoadRealtimeResponse != null) {
                        obtain.writeInt(1);
                        onLoadRealtimeResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzm != null ? zzm.asBinder() : null);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnMetadataResponse onMetadataResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onMetadataResponse != null) {
                        obtain.writeInt(1);
                        onMetadataResponse.writeToParcel(obtain, 0);
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

            public void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onPinnedDownloadPreferencesResponse != null) {
                        obtain.writeInt(1);
                        onPinnedDownloadPreferencesResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onResourceIdSetResponse != null) {
                        obtain.writeInt(1);
                        onResourceIdSetResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnStartStreamSession onStartStreamSession) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onStartStreamSession != null) {
                        obtain.writeInt(1);
                        onStartStreamSession.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (onSyncMoreResponse != null) {
                        obtain.writeInt(1);
                        onSyncMoreResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(StringListResponse stringListResponse) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    if (stringListResponse != null) {
                        obtain.writeInt(1);
                        stringListResponse.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzaf(boolean z) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
                    obtain.writeInt(z ? 1 : 0);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.drive.internal.IDriveServiceCallbacks");
        }

        public static zzan zzbb(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveServiceCallbacks");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzan)) ? new C0013zza(iBinder) : (zzan) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.google.android.gms.drive.internal.OnDownloadProgressResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.gms.drive.internal.OnListEntriesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: com.google.android.gms.drive.internal.OnDriveIdResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v14, resolved type: com.google.android.gms.drive.internal.OnMetadataResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: com.google.android.gms.drive.internal.OnContentsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v22, resolved type: com.google.android.gms.common.api.Status} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v26, resolved type: com.google.android.gms.drive.internal.OnListParentsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v30, resolved type: com.google.android.gms.drive.internal.OnSyncMoreResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: com.google.android.gms.drive.internal.OnLoadRealtimeResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v38, resolved type: com.google.android.gms.drive.internal.OnResourceIdSetResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v42, resolved type: com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v46, resolved type: com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v54, resolved type: com.google.android.gms.drive.internal.OnFetchThumbnailResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: com.google.android.gms.drive.ChangeSequenceNumber} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: com.google.android.gms.drive.internal.OnChangesResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v66, resolved type: com.google.android.gms.drive.internal.GetPermissionsResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: com.google.android.gms.drive.internal.StringListResponse} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v74, resolved type: com.google.android.gms.drive.internal.OnStartStreamSession} */
        /* JADX WARNING: type inference failed for: r0v1 */
        /* JADX WARNING: type inference failed for: r0v79 */
        /* JADX WARNING: type inference failed for: r0v80 */
        /* JADX WARNING: type inference failed for: r0v81 */
        /* JADX WARNING: type inference failed for: r0v82 */
        /* JADX WARNING: type inference failed for: r0v83 */
        /* JADX WARNING: type inference failed for: r0v84 */
        /* JADX WARNING: type inference failed for: r0v85 */
        /* JADX WARNING: type inference failed for: r0v86 */
        /* JADX WARNING: type inference failed for: r0v87 */
        /* JADX WARNING: type inference failed for: r0v88 */
        /* JADX WARNING: type inference failed for: r0v89 */
        /* JADX WARNING: type inference failed for: r0v90 */
        /* JADX WARNING: type inference failed for: r0v91 */
        /* JADX WARNING: type inference failed for: r0v92 */
        /* JADX WARNING: type inference failed for: r0v93 */
        /* JADX WARNING: type inference failed for: r0v94 */
        /* JADX WARNING: type inference failed for: r0v95 */
        /* JADX WARNING: type inference failed for: r0v96 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
            /*
                r3 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                java.lang.String r1 = "com.google.android.gms.drive.internal.IDriveServiceCallbacks"
                r2 = 1
                if (r4 == r0) goto L_0x01c0
                r0 = 0
                switch(r4) {
                    case 1: goto L_0x01aa;
                    case 2: goto L_0x0194;
                    case 3: goto L_0x017e;
                    case 4: goto L_0x0168;
                    case 5: goto L_0x0152;
                    case 6: goto L_0x013c;
                    case 7: goto L_0x0134;
                    case 8: goto L_0x011e;
                    case 9: goto L_0x0108;
                    default: goto L_0x000c;
                }
            L_0x000c:
                switch(r4) {
                    case 11: goto L_0x00ea;
                    case 12: goto L_0x00d4;
                    case 13: goto L_0x00be;
                    case 14: goto L_0x00a8;
                    case 15: goto L_0x0098;
                    case 16: goto L_0x0083;
                    case 17: goto L_0x006e;
                    case 18: goto L_0x0059;
                    default: goto L_0x000f;
                }
            L_0x000f:
                switch(r4) {
                    case 20: goto L_0x0044;
                    case 21: goto L_0x002f;
                    case 22: goto L_0x0017;
                    default: goto L_0x0012;
                }
            L_0x0012:
                boolean r0 = super.onTransact(r4, r5, r6, r7)
                return r0
            L_0x0017:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x0028
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnStartStreamSession> r0 = com.google.android.gms.drive.internal.OnStartStreamSession.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnStartStreamSession r0 = (com.google.android.gms.drive.internal.OnStartStreamSession) r0
            L_0x0028:
                r3.zza((com.google.android.gms.drive.internal.OnStartStreamSession) r0)
            L_0x002b:
                r6.writeNoException()
                return r2
            L_0x002f:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x0040
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.StringListResponse> r0 = com.google.android.gms.drive.internal.StringListResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.StringListResponse r0 = (com.google.android.gms.drive.internal.StringListResponse) r0
            L_0x0040:
                r3.zza((com.google.android.gms.drive.internal.StringListResponse) r0)
                goto L_0x002b
            L_0x0044:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x0055
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetPermissionsResponse> r0 = com.google.android.gms.drive.internal.GetPermissionsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.GetPermissionsResponse r0 = (com.google.android.gms.drive.internal.GetPermissionsResponse) r0
            L_0x0055:
                r3.zza((com.google.android.gms.drive.internal.GetPermissionsResponse) r0)
                goto L_0x002b
            L_0x0059:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x006a
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnChangesResponse> r0 = com.google.android.gms.drive.internal.OnChangesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnChangesResponse r0 = (com.google.android.gms.drive.internal.OnChangesResponse) r0
            L_0x006a:
                r3.zza((com.google.android.gms.drive.internal.OnChangesResponse) r0)
                goto L_0x002b
            L_0x006e:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x007f
                android.os.Parcelable$Creator<com.google.android.gms.drive.ChangeSequenceNumber> r0 = com.google.android.gms.drive.ChangeSequenceNumber.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.ChangeSequenceNumber r0 = (com.google.android.gms.drive.ChangeSequenceNumber) r0
            L_0x007f:
                r3.zza((com.google.android.gms.drive.ChangeSequenceNumber) r0)
                goto L_0x002b
            L_0x0083:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x0094
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnFetchThumbnailResponse> r0 = com.google.android.gms.drive.internal.OnFetchThumbnailResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnFetchThumbnailResponse r0 = (com.google.android.gms.drive.internal.OnFetchThumbnailResponse) r0
            L_0x0094:
                r3.zza((com.google.android.gms.drive.internal.OnFetchThumbnailResponse) r0)
                goto L_0x002b
            L_0x0098:
                r5.enforceInterface(r1)
                int r0 = r5.readInt()
                if (r0 == 0) goto L_0x00a3
                r0 = 1
                goto L_0x00a4
            L_0x00a3:
                r0 = 0
            L_0x00a4:
                r3.zzaf(r0)
                goto L_0x002b
            L_0x00a8:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x00b9
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse> r0 = com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse r0 = (com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) r0
            L_0x00b9:
                r3.zza((com.google.android.gms.drive.internal.OnDeviceUsagePreferenceResponse) r0)
                goto L_0x002b
            L_0x00be:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x00cf
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse> r0 = com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse r0 = (com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse) r0
            L_0x00cf:
                r3.zza((com.google.android.gms.drive.internal.OnPinnedDownloadPreferencesResponse) r0)
                goto L_0x002b
            L_0x00d4:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x00e5
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnResourceIdSetResponse> r0 = com.google.android.gms.drive.internal.OnResourceIdSetResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnResourceIdSetResponse r0 = (com.google.android.gms.drive.internal.OnResourceIdSetResponse) r0
            L_0x00e5:
                r3.zza((com.google.android.gms.drive.internal.OnResourceIdSetResponse) r0)
                goto L_0x002b
            L_0x00ea:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x00fb
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnLoadRealtimeResponse> r0 = com.google.android.gms.drive.internal.OnLoadRealtimeResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnLoadRealtimeResponse r0 = (com.google.android.gms.drive.internal.OnLoadRealtimeResponse) r0
            L_0x00fb:
                android.os.IBinder r1 = r5.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzm r1 = com.google.android.gms.drive.realtime.internal.zzm.zza.zzbo(r1)
                r3.zza(r0, r1)
                goto L_0x002b
            L_0x0108:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x0119
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnSyncMoreResponse> r0 = com.google.android.gms.drive.internal.OnSyncMoreResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnSyncMoreResponse r0 = (com.google.android.gms.drive.internal.OnSyncMoreResponse) r0
            L_0x0119:
                r3.zza((com.google.android.gms.drive.internal.OnSyncMoreResponse) r0)
                goto L_0x002b
            L_0x011e:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x012f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListParentsResponse> r0 = com.google.android.gms.drive.internal.OnListParentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListParentsResponse r0 = (com.google.android.gms.drive.internal.OnListParentsResponse) r0
            L_0x012f:
                r3.zza((com.google.android.gms.drive.internal.OnListParentsResponse) r0)
                goto L_0x002b
            L_0x0134:
                r5.enforceInterface(r1)
                r3.onSuccess()
                goto L_0x002b
            L_0x013c:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x014d
                android.os.Parcelable$Creator<com.google.android.gms.common.api.Status> r0 = com.google.android.gms.common.api.Status.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.common.api.Status r0 = (com.google.android.gms.common.api.Status) r0
            L_0x014d:
                r3.onError(r0)
                goto L_0x002b
            L_0x0152:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x0163
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnContentsResponse> r0 = com.google.android.gms.drive.internal.OnContentsResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnContentsResponse r0 = (com.google.android.gms.drive.internal.OnContentsResponse) r0
            L_0x0163:
                r3.zza((com.google.android.gms.drive.internal.OnContentsResponse) r0)
                goto L_0x002b
            L_0x0168:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x0179
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnMetadataResponse> r0 = com.google.android.gms.drive.internal.OnMetadataResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnMetadataResponse r0 = (com.google.android.gms.drive.internal.OnMetadataResponse) r0
            L_0x0179:
                r3.zza((com.google.android.gms.drive.internal.OnMetadataResponse) r0)
                goto L_0x002b
            L_0x017e:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x018f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDriveIdResponse> r0 = com.google.android.gms.drive.internal.OnDriveIdResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDriveIdResponse r0 = (com.google.android.gms.drive.internal.OnDriveIdResponse) r0
            L_0x018f:
                r3.zza((com.google.android.gms.drive.internal.OnDriveIdResponse) r0)
                goto L_0x002b
            L_0x0194:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x01a5
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnListEntriesResponse> r0 = com.google.android.gms.drive.internal.OnListEntriesResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnListEntriesResponse r0 = (com.google.android.gms.drive.internal.OnListEntriesResponse) r0
            L_0x01a5:
                r3.zza((com.google.android.gms.drive.internal.OnListEntriesResponse) r0)
                goto L_0x002b
            L_0x01aa:
                r5.enforceInterface(r1)
                int r1 = r5.readInt()
                if (r1 == 0) goto L_0x01bb
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OnDownloadProgressResponse> r0 = com.google.android.gms.drive.internal.OnDownloadProgressResponse.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r5)
                com.google.android.gms.drive.internal.OnDownloadProgressResponse r0 = (com.google.android.gms.drive.internal.OnDownloadProgressResponse) r0
            L_0x01bb:
                r3.zza((com.google.android.gms.drive.internal.OnDownloadProgressResponse) r0)
                goto L_0x002b
            L_0x01c0:
                r6.writeString(r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.zzan.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void onError(Status status) throws RemoteException;

    void onSuccess() throws RemoteException;

    void zza(ChangeSequenceNumber changeSequenceNumber) throws RemoteException;

    void zza(GetPermissionsResponse getPermissionsResponse) throws RemoteException;

    void zza(OnChangesResponse onChangesResponse) throws RemoteException;

    void zza(OnContentsResponse onContentsResponse) throws RemoteException;

    void zza(OnDeviceUsagePreferenceResponse onDeviceUsagePreferenceResponse) throws RemoteException;

    void zza(OnDownloadProgressResponse onDownloadProgressResponse) throws RemoteException;

    void zza(OnDriveIdResponse onDriveIdResponse) throws RemoteException;

    void zza(OnFetchThumbnailResponse onFetchThumbnailResponse) throws RemoteException;

    void zza(OnListEntriesResponse onListEntriesResponse) throws RemoteException;

    void zza(OnListParentsResponse onListParentsResponse) throws RemoteException;

    void zza(OnLoadRealtimeResponse onLoadRealtimeResponse, zzm zzm) throws RemoteException;

    void zza(OnMetadataResponse onMetadataResponse) throws RemoteException;

    void zza(OnPinnedDownloadPreferencesResponse onPinnedDownloadPreferencesResponse) throws RemoteException;

    void zza(OnResourceIdSetResponse onResourceIdSetResponse) throws RemoteException;

    void zza(OnStartStreamSession onStartStreamSession) throws RemoteException;

    void zza(OnSyncMoreResponse onSyncMoreResponse) throws RemoteException;

    void zza(StringListResponse stringListResponse) throws RemoteException;

    void zzaf(boolean z) throws RemoteException;
}
