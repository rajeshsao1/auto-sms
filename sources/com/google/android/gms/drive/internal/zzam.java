package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.drive.RealtimeDocumentSyncRequest;

public interface zzam extends IInterface {

    public static abstract class zza extends Binder implements zzam {

        /* renamed from: com.google.android.gms.drive.internal.zzam$zza$zza  reason: collision with other inner class name */
        private static class C0012zza implements zzam {
            private IBinder zzoz;

            C0012zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        obtain.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? (IntentSender) IntentSender.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        obtain.writeInt(1);
                        openContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    DriveServiceResponse driveServiceResponse = null;
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        driveServiceResponse = DriveServiceResponse.CREATOR.createFromParcel(obtain2);
                    }
                    return driveServiceResponse;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public DriveServiceResponse zza(StreamContentsRequest streamContentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (streamContentsRequest != null) {
                        obtain.writeInt(1);
                        streamContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    DriveServiceResponse driveServiceResponse = null;
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(56, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        driveServiceResponse = DriveServiceResponse.CREATOR.createFromParcel(obtain2);
                    }
                    return driveServiceResponse;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (realtimeDocumentSyncRequest != null) {
                        obtain.writeInt(1);
                        realtimeDocumentSyncRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddEventListenerRequest addEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addEventListenerRequest != null) {
                        obtain.writeInt(1);
                        addEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    obtain.writeString(str);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AddPermissionRequest addPermissionRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (addPermissionRequest != null) {
                        obtain.writeInt(1);
                        addPermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(AuthorizeAccessRequest authorizeAccessRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (authorizeAccessRequest != null) {
                        obtain.writeInt(1);
                        authorizeAccessRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (cancelPendingActionsRequest != null) {
                        obtain.writeInt(1);
                        cancelPendingActionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (changeResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        changeResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(55, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (checkResourceIdsExistRequest != null) {
                        obtain.writeInt(1);
                        checkResourceIdsExistRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsAndUpdateMetadataRequest != null) {
                        obtain.writeInt(1);
                        closeContentsAndUpdateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CloseContentsRequest closeContentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        obtain.writeInt(1);
                        closeContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ControlProgressRequest controlProgressRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (controlProgressRequest != null) {
                        obtain.writeInt(1);
                        controlProgressRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(53, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateContentsRequest createContentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        obtain.writeInt(1);
                        createContentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFileRequest createFileRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        obtain.writeInt(1);
                        createFileRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(CreateFolderRequest createFolderRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        obtain.writeInt(1);
                        createFolderRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DeleteResourceRequest deleteResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (deleteResourceRequest != null) {
                        obtain.writeInt(1);
                        deleteResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DisconnectRequest disconnectRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (disconnectRequest != null) {
                        obtain.writeInt(1);
                        disconnectRequest.writeToParcel(obtain, 0);
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

            public void zza(FetchThumbnailRequest fetchThumbnailRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (fetchThumbnailRequest != null) {
                        obtain.writeInt(1);
                        fetchThumbnailRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetChangesRequest getChangesRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getChangesRequest != null) {
                        obtain.writeInt(1);
                        getChangesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getDriveIdFromUniqueIdentifierRequest != null) {
                        obtain.writeInt(1);
                        getDriveIdFromUniqueIdentifierRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetMetadataRequest getMetadataRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        obtain.writeInt(1);
                        getMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(GetPermissionsRequest getPermissionsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getPermissionsRequest != null) {
                        obtain.writeInt(1);
                        getPermissionsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ListParentsRequest listParentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (listParentsRequest != null) {
                        obtain.writeInt(1);
                        listParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(LoadRealtimeRequest loadRealtimeRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (loadRealtimeRequest != null) {
                        obtain.writeInt(1);
                        loadRealtimeRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(QueryRequest queryRequest, zzao zzao, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemoveEventListenerRequest removeEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removeEventListenerRequest != null) {
                        obtain.writeInt(1);
                        removeEventListenerRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    obtain.writeString(str);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(RemovePermissionRequest removePermissionRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (removePermissionRequest != null) {
                        obtain.writeInt(1);
                        removePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setFileUploadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setFileUploadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setPinnedDownloadPreferencesRequest != null) {
                        obtain.writeInt(1);
                        setPinnedDownloadPreferencesRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(SetResourceParentsRequest setResourceParentsRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (setResourceParentsRequest != null) {
                        obtain.writeInt(1);
                        setResourceParentsRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(TrashResourceRequest trashResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (trashResourceRequest != null) {
                        obtain.writeInt(1);
                        trashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (unsubscribeResourceRequest != null) {
                        obtain.writeInt(1);
                        unsubscribeResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UntrashResourceRequest untrashResourceRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (untrashResourceRequest != null) {
                        obtain.writeInt(1);
                        untrashResourceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdateMetadataRequest updateMetadataRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        obtain.writeInt(1);
                        updateMetadataRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(UpdatePermissionRequest updatePermissionRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updatePermissionRequest != null) {
                        obtain.writeInt(1);
                        updatePermissionRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzao zzao, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    IBinder iBinder = null;
                    obtain.writeStrongBinder(zzao != null ? zzao.asBinder() : null);
                    if (zzan != null) {
                        iBinder = zzan.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.zzoz.transact(52, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(QueryRequest queryRequest, zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        obtain.writeInt(1);
                        queryRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzf(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzg(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(54, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzh(zzan zzan) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    obtain.writeStrongBinder(zzan != null ? zzan.asBinder() : null);
                    this.zzoz.transact(57, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzam zzba(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzam)) ? new C0012zza(iBinder) : (zzam) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.gms.drive.internal.DeleteResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.google.android.gms.drive.internal.GetMetadataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.google.android.gms.drive.internal.UpdateMetadataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.google.android.gms.drive.internal.CreateContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.google.android.gms.drive.internal.CreateFileRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v19, resolved type: com.google.android.gms.drive.internal.CreateFolderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: com.google.android.gms.drive.internal.OpenContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: com.google.android.gms.drive.internal.CloseContentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: com.google.android.gms.drive.internal.OpenFileIntentSenderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v35, resolved type: com.google.android.gms.drive.internal.CreateFileIntentSenderRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v40, resolved type: com.google.android.gms.drive.internal.AuthorizeAccessRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v43, resolved type: com.google.android.gms.drive.internal.ListParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v46, resolved type: com.google.android.gms.drive.internal.AddEventListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v49, resolved type: com.google.android.gms.drive.internal.RemoveEventListenerRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: com.google.android.gms.drive.internal.DisconnectRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v55, resolved type: com.google.android.gms.drive.internal.TrashResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v58, resolved type: com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v61, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v64, resolved type: com.google.android.gms.drive.internal.LoadRealtimeRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v67, resolved type: com.google.android.gms.drive.internal.SetResourceParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v70, resolved type: com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v73, resolved type: com.google.android.gms.drive.internal.CheckResourceIdsExistRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v76, resolved type: com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v79, resolved type: com.google.android.gms.drive.RealtimeDocumentSyncRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v82, resolved type: com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v85, resolved type: com.google.android.gms.drive.internal.CancelPendingActionsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: com.google.android.gms.drive.internal.UntrashResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v91, resolved type: com.google.android.gms.drive.internal.FetchThumbnailRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: com.google.android.gms.drive.internal.GetChangesRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v97, resolved type: com.google.android.gms.drive.internal.UnsubscribeResourceRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v100, resolved type: com.google.android.gms.drive.internal.GetPermissionsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v103, resolved type: com.google.android.gms.drive.internal.AddPermissionRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v106, resolved type: com.google.android.gms.drive.internal.UpdatePermissionRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v109, resolved type: com.google.android.gms.drive.internal.RemovePermissionRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v112, resolved type: com.google.android.gms.drive.internal.QueryRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v117, resolved type: com.google.android.gms.drive.internal.ControlProgressRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v120, resolved type: com.google.android.gms.drive.internal.ChangeResourceParentsRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v123, resolved type: com.google.android.gms.drive.internal.StreamContentsRequest} */
        /* JADX WARNING: type inference failed for: r1v0 */
        /* JADX WARNING: type inference failed for: r1v128 */
        /* JADX WARNING: type inference failed for: r1v129 */
        /* JADX WARNING: type inference failed for: r1v130 */
        /* JADX WARNING: type inference failed for: r1v131 */
        /* JADX WARNING: type inference failed for: r1v132 */
        /* JADX WARNING: type inference failed for: r1v133 */
        /* JADX WARNING: type inference failed for: r1v134 */
        /* JADX WARNING: type inference failed for: r1v135 */
        /* JADX WARNING: type inference failed for: r1v136 */
        /* JADX WARNING: type inference failed for: r1v137 */
        /* JADX WARNING: type inference failed for: r1v138 */
        /* JADX WARNING: type inference failed for: r1v139 */
        /* JADX WARNING: type inference failed for: r1v140 */
        /* JADX WARNING: type inference failed for: r1v141 */
        /* JADX WARNING: type inference failed for: r1v142 */
        /* JADX WARNING: type inference failed for: r1v143 */
        /* JADX WARNING: type inference failed for: r1v144 */
        /* JADX WARNING: type inference failed for: r1v145 */
        /* JADX WARNING: type inference failed for: r1v146 */
        /* JADX WARNING: type inference failed for: r1v147 */
        /* JADX WARNING: type inference failed for: r1v148 */
        /* JADX WARNING: type inference failed for: r1v149 */
        /* JADX WARNING: type inference failed for: r1v150 */
        /* JADX WARNING: type inference failed for: r1v151 */
        /* JADX WARNING: type inference failed for: r1v152 */
        /* JADX WARNING: type inference failed for: r1v153 */
        /* JADX WARNING: type inference failed for: r1v154 */
        /* JADX WARNING: type inference failed for: r1v155 */
        /* JADX WARNING: type inference failed for: r1v156 */
        /* JADX WARNING: type inference failed for: r1v157 */
        /* JADX WARNING: type inference failed for: r1v158 */
        /* JADX WARNING: type inference failed for: r1v159 */
        /* JADX WARNING: type inference failed for: r1v160 */
        /* JADX WARNING: type inference failed for: r1v161 */
        /* JADX WARNING: type inference failed for: r1v162 */
        /* JADX WARNING: type inference failed for: r1v163 */
        /* JADX WARNING: type inference failed for: r1v164 */
        /* JADX WARNING: type inference failed for: r1v165 */
        /* JADX WARNING: type inference failed for: r1v166 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r6, android.os.Parcel r7, android.os.Parcel r8, int r9) throws android.os.RemoteException {
            /*
                r5 = this;
                r0 = 24
                r1 = 0
                java.lang.String r2 = "com.google.android.gms.drive.internal.IDriveService"
                r3 = 1
                if (r6 == r0) goto L_0x0594
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                if (r6 == r0) goto L_0x0590
                r0 = 0
                switch(r6) {
                    case 1: goto L_0x0571;
                    case 2: goto L_0x0552;
                    case 3: goto L_0x0533;
                    case 4: goto L_0x0514;
                    case 5: goto L_0x04f5;
                    case 6: goto L_0x04d6;
                    case 7: goto L_0x04a9;
                    case 8: goto L_0x048a;
                    case 9: goto L_0x047a;
                    case 10: goto L_0x0455;
                    case 11: goto L_0x0430;
                    case 12: goto L_0x0411;
                    case 13: goto L_0x03f2;
                    case 14: goto L_0x03c7;
                    case 15: goto L_0x039c;
                    case 16: goto L_0x0385;
                    case 17: goto L_0x0366;
                    case 18: goto L_0x0347;
                    case 19: goto L_0x0328;
                    default: goto L_0x0011;
                }
            L_0x0011:
                switch(r6) {
                    case 27: goto L_0x0309;
                    case 28: goto L_0x02ea;
                    case 29: goto L_0x02cb;
                    case 30: goto L_0x02ac;
                    case 31: goto L_0x029c;
                    case 32: goto L_0x028c;
                    case 33: goto L_0x026d;
                    case 34: goto L_0x024e;
                    case 35: goto L_0x023e;
                    case 36: goto L_0x021f;
                    case 37: goto L_0x0200;
                    case 38: goto L_0x01e1;
                    default: goto L_0x0014;
                }
            L_0x0014:
                switch(r6) {
                    case 41: goto L_0x01d1;
                    case 42: goto L_0x01b2;
                    case 43: goto L_0x01a2;
                    case 44: goto L_0x0183;
                    default: goto L_0x0017;
                }
            L_0x0017:
                switch(r6) {
                    case 46: goto L_0x0164;
                    case 47: goto L_0x0145;
                    case 48: goto L_0x0126;
                    case 49: goto L_0x0107;
                    case 50: goto L_0x00e8;
                    case 51: goto L_0x00c1;
                    case 52: goto L_0x00a9;
                    case 53: goto L_0x008b;
                    case 54: goto L_0x007c;
                    case 55: goto L_0x005e;
                    case 56: goto L_0x0031;
                    case 57: goto L_0x001f;
                    default: goto L_0x001a;
                }
            L_0x001a:
                boolean r0 = super.onTransact(r6, r7, r8, r9)
                return r0
            L_0x001f:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzh(r0)
            L_0x002d:
                r8.writeNoException()
                return r3
            L_0x0031:
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0042
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.StreamContentsRequest> r1 = com.google.android.gms.drive.internal.StreamContentsRequest.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r7)
                com.google.android.gms.drive.internal.StreamContentsRequest r1 = (com.google.android.gms.drive.internal.StreamContentsRequest) r1
            L_0x0042:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                com.google.android.gms.drive.internal.DriveServiceResponse r1 = r5.zza((com.google.android.gms.drive.internal.StreamContentsRequest) r1, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                if (r1 == 0) goto L_0x005a
                r8.writeInt(r3)
                r1.writeToParcel(r8, r3)
                goto L_0x005d
            L_0x005a:
                r8.writeInt(r0)
            L_0x005d:
                return r3
            L_0x005e:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0070
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ChangeResourceParentsRequest> r0 = com.google.android.gms.drive.internal.ChangeResourceParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.ChangeResourceParentsRequest r1 = (com.google.android.gms.drive.internal.ChangeResourceParentsRequest) r1
            L_0x0070:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.ChangeResourceParentsRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x007c:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzg(r0)
                goto L_0x002d
            L_0x008b:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x009d
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ControlProgressRequest> r0 = com.google.android.gms.drive.internal.ControlProgressRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.ControlProgressRequest r1 = (com.google.android.gms.drive.internal.ControlProgressRequest) r1
            L_0x009d:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.ControlProgressRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x00a9:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r0 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r0)
                android.os.IBinder r1 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r1 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r1)
                r5.zza((com.google.android.gms.drive.internal.zzao) r0, (com.google.android.gms.drive.internal.zzan) r1)
                goto L_0x002d
            L_0x00c1:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x00d3
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.QueryRequest r1 = (com.google.android.gms.drive.internal.QueryRequest) r1
            L_0x00d3:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r0 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r0)
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                r5.zza(r1, r0, r2)
                goto L_0x002d
            L_0x00e8:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x00fa
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemovePermissionRequest> r0 = com.google.android.gms.drive.internal.RemovePermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.RemovePermissionRequest r1 = (com.google.android.gms.drive.internal.RemovePermissionRequest) r1
            L_0x00fa:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.RemovePermissionRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0107:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0119
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdatePermissionRequest> r0 = com.google.android.gms.drive.internal.UpdatePermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.UpdatePermissionRequest r1 = (com.google.android.gms.drive.internal.UpdatePermissionRequest) r1
            L_0x0119:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.UpdatePermissionRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0126:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0138
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddPermissionRequest> r0 = com.google.android.gms.drive.internal.AddPermissionRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.AddPermissionRequest r1 = (com.google.android.gms.drive.internal.AddPermissionRequest) r1
            L_0x0138:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.AddPermissionRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0145:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0157
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetPermissionsRequest> r0 = com.google.android.gms.drive.internal.GetPermissionsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.GetPermissionsRequest r1 = (com.google.android.gms.drive.internal.GetPermissionsRequest) r1
            L_0x0157:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.GetPermissionsRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0164:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0176
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UnsubscribeResourceRequest> r0 = com.google.android.gms.drive.internal.UnsubscribeResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.UnsubscribeResourceRequest r1 = (com.google.android.gms.drive.internal.UnsubscribeResourceRequest) r1
            L_0x0176:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.UnsubscribeResourceRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0183:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0195
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetChangesRequest> r0 = com.google.android.gms.drive.internal.GetChangesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.GetChangesRequest r1 = (com.google.android.gms.drive.internal.GetChangesRequest) r1
            L_0x0195:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.GetChangesRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x01a2:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzf(r0)
                goto L_0x002d
            L_0x01b2:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x01c4
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.FetchThumbnailRequest> r0 = com.google.android.gms.drive.internal.FetchThumbnailRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.FetchThumbnailRequest r1 = (com.google.android.gms.drive.internal.FetchThumbnailRequest) r1
            L_0x01c4:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.FetchThumbnailRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x01d1:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zze(r0)
                goto L_0x002d
            L_0x01e1:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x01f3
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UntrashResourceRequest> r0 = com.google.android.gms.drive.internal.UntrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.UntrashResourceRequest r1 = (com.google.android.gms.drive.internal.UntrashResourceRequest) r1
            L_0x01f3:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.UntrashResourceRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0200:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0212
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CancelPendingActionsRequest> r0 = com.google.android.gms.drive.internal.CancelPendingActionsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.CancelPendingActionsRequest r1 = (com.google.android.gms.drive.internal.CancelPendingActionsRequest) r1
            L_0x0212:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.CancelPendingActionsRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x021f:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0231
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest> r0 = com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest r1 = (com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest) r1
            L_0x0231:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.SetFileUploadPreferencesRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x023e:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzd(r0)
                goto L_0x002d
            L_0x024e:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0260
                android.os.Parcelable$Creator<com.google.android.gms.drive.RealtimeDocumentSyncRequest> r0 = com.google.android.gms.drive.RealtimeDocumentSyncRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.RealtimeDocumentSyncRequest r1 = (com.google.android.gms.drive.RealtimeDocumentSyncRequest) r1
            L_0x0260:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.RealtimeDocumentSyncRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x026d:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x027f
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest> r0 = com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest r1 = (com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest) r1
            L_0x027f:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.SetPinnedDownloadPreferencesRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x028c:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzc(r0)
                goto L_0x002d
            L_0x029c:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzb(r0)
                goto L_0x002d
            L_0x02ac:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x02be
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CheckResourceIdsExistRequest> r0 = com.google.android.gms.drive.internal.CheckResourceIdsExistRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.CheckResourceIdsExistRequest r1 = (com.google.android.gms.drive.internal.CheckResourceIdsExistRequest) r1
            L_0x02be:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.CheckResourceIdsExistRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x02cb:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x02dd
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest> r0 = com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest r1 = (com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest) r1
            L_0x02dd:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.GetDriveIdFromUniqueIdentifierRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x02ea:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x02fc
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.SetResourceParentsRequest> r0 = com.google.android.gms.drive.internal.SetResourceParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.SetResourceParentsRequest r1 = (com.google.android.gms.drive.internal.SetResourceParentsRequest) r1
            L_0x02fc:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.SetResourceParentsRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0309:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x031b
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.LoadRealtimeRequest> r0 = com.google.android.gms.drive.internal.LoadRealtimeRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.LoadRealtimeRequest r1 = (com.google.android.gms.drive.internal.LoadRealtimeRequest) r1
            L_0x031b:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.LoadRealtimeRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0328:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x033a
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.QueryRequest r1 = (com.google.android.gms.drive.internal.QueryRequest) r1
            L_0x033a:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zzb(r1, r0)
                goto L_0x002d
            L_0x0347:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0359
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest r1 = (com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r1
            L_0x0359:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.CloseContentsAndUpdateMetadataRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0366:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0378
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.TrashResourceRequest> r0 = com.google.android.gms.drive.internal.TrashResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.TrashResourceRequest r1 = (com.google.android.gms.drive.internal.TrashResourceRequest) r1
            L_0x0378:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.TrashResourceRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0385:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0397
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DisconnectRequest> r0 = com.google.android.gms.drive.internal.DisconnectRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.DisconnectRequest r1 = (com.google.android.gms.drive.internal.DisconnectRequest) r1
            L_0x0397:
                r5.zza((com.google.android.gms.drive.internal.DisconnectRequest) r1)
                goto L_0x002d
            L_0x039c:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x03ae
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.RemoveEventListenerRequest> r0 = com.google.android.gms.drive.internal.RemoveEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.RemoveEventListenerRequest r1 = (com.google.android.gms.drive.internal.RemoveEventListenerRequest) r1
            L_0x03ae:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r0 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r0)
                java.lang.String r2 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r4 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r4)
                r5.zza((com.google.android.gms.drive.internal.RemoveEventListenerRequest) r1, (com.google.android.gms.drive.internal.zzao) r0, (java.lang.String) r2, (com.google.android.gms.drive.internal.zzan) r4)
                goto L_0x002d
            L_0x03c7:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x03d9
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AddEventListenerRequest> r0 = com.google.android.gms.drive.internal.AddEventListenerRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.AddEventListenerRequest r1 = (com.google.android.gms.drive.internal.AddEventListenerRequest) r1
            L_0x03d9:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzao r0 = com.google.android.gms.drive.internal.zzao.zza.zzbc(r0)
                java.lang.String r2 = r7.readString()
                android.os.IBinder r4 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r4 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r4)
                r5.zza((com.google.android.gms.drive.internal.AddEventListenerRequest) r1, (com.google.android.gms.drive.internal.zzao) r0, (java.lang.String) r2, (com.google.android.gms.drive.internal.zzan) r4)
                goto L_0x002d
            L_0x03f2:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0404
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.ListParentsRequest> r0 = com.google.android.gms.drive.internal.ListParentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.ListParentsRequest r1 = (com.google.android.gms.drive.internal.ListParentsRequest) r1
            L_0x0404:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.ListParentsRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0411:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0423
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.AuthorizeAccessRequest> r0 = com.google.android.gms.drive.internal.AuthorizeAccessRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.AuthorizeAccessRequest r1 = (com.google.android.gms.drive.internal.AuthorizeAccessRequest) r1
            L_0x0423:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.AuthorizeAccessRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0430:
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0441
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileIntentSenderRequest> r1 = com.google.android.gms.drive.internal.CreateFileIntentSenderRequest.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r7)
                com.google.android.gms.drive.internal.CreateFileIntentSenderRequest r1 = (com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r1
            L_0x0441:
                android.content.IntentSender r1 = r5.zza((com.google.android.gms.drive.internal.CreateFileIntentSenderRequest) r1)
                r8.writeNoException()
                if (r1 == 0) goto L_0x0451
                r8.writeInt(r3)
                r1.writeToParcel(r8, r3)
                goto L_0x0454
            L_0x0451:
                r8.writeInt(r0)
            L_0x0454:
                return r3
            L_0x0455:
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x0466
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenFileIntentSenderRequest> r1 = com.google.android.gms.drive.internal.OpenFileIntentSenderRequest.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenFileIntentSenderRequest r1 = (com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r1
            L_0x0466:
                android.content.IntentSender r1 = r5.zza((com.google.android.gms.drive.internal.OpenFileIntentSenderRequest) r1)
                r8.writeNoException()
                if (r1 == 0) goto L_0x0476
                r8.writeInt(r3)
                r1.writeToParcel(r8, r3)
                goto L_0x0479
            L_0x0476:
                r8.writeInt(r0)
            L_0x0479:
                return r3
            L_0x047a:
                r7.enforceInterface(r2)
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x048a:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x049c
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CloseContentsRequest> r0 = com.google.android.gms.drive.internal.CloseContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.CloseContentsRequest r1 = (com.google.android.gms.drive.internal.CloseContentsRequest) r1
            L_0x049c:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.CloseContentsRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x04a9:
                r7.enforceInterface(r2)
                int r2 = r7.readInt()
                if (r2 == 0) goto L_0x04ba
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.OpenContentsRequest> r1 = com.google.android.gms.drive.internal.OpenContentsRequest.CREATOR
                java.lang.Object r1 = r1.createFromParcel(r7)
                com.google.android.gms.drive.internal.OpenContentsRequest r1 = (com.google.android.gms.drive.internal.OpenContentsRequest) r1
            L_0x04ba:
                android.os.IBinder r2 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r2 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r2)
                com.google.android.gms.drive.internal.DriveServiceResponse r1 = r5.zza((com.google.android.gms.drive.internal.OpenContentsRequest) r1, (com.google.android.gms.drive.internal.zzan) r2)
                r8.writeNoException()
                if (r1 == 0) goto L_0x04d2
                r8.writeInt(r3)
                r1.writeToParcel(r8, r3)
                goto L_0x04d5
            L_0x04d2:
                r8.writeInt(r0)
            L_0x04d5:
                return r3
            L_0x04d6:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x04e8
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFolderRequest> r0 = com.google.android.gms.drive.internal.CreateFolderRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.CreateFolderRequest r1 = (com.google.android.gms.drive.internal.CreateFolderRequest) r1
            L_0x04e8:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.CreateFolderRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x04f5:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0507
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateFileRequest> r0 = com.google.android.gms.drive.internal.CreateFileRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.CreateFileRequest r1 = (com.google.android.gms.drive.internal.CreateFileRequest) r1
            L_0x0507:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.CreateFileRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0514:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0526
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.CreateContentsRequest> r0 = com.google.android.gms.drive.internal.CreateContentsRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.CreateContentsRequest r1 = (com.google.android.gms.drive.internal.CreateContentsRequest) r1
            L_0x0526:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.CreateContentsRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0533:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0545
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.UpdateMetadataRequest> r0 = com.google.android.gms.drive.internal.UpdateMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.UpdateMetadataRequest r1 = (com.google.android.gms.drive.internal.UpdateMetadataRequest) r1
            L_0x0545:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.UpdateMetadataRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0552:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0564
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.QueryRequest> r0 = com.google.android.gms.drive.internal.QueryRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.QueryRequest r1 = (com.google.android.gms.drive.internal.QueryRequest) r1
            L_0x0564:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.QueryRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0571:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x0583
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.GetMetadataRequest> r0 = com.google.android.gms.drive.internal.GetMetadataRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.GetMetadataRequest r1 = (com.google.android.gms.drive.internal.GetMetadataRequest) r1
            L_0x0583:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.GetMetadataRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            L_0x0590:
                r8.writeString(r2)
                return r3
            L_0x0594:
                r7.enforceInterface(r2)
                int r0 = r7.readInt()
                if (r0 == 0) goto L_0x05a6
                android.os.Parcelable$Creator<com.google.android.gms.drive.internal.DeleteResourceRequest> r0 = com.google.android.gms.drive.internal.DeleteResourceRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r7)
                r1 = r0
                com.google.android.gms.drive.internal.DeleteResourceRequest r1 = (com.google.android.gms.drive.internal.DeleteResourceRequest) r1
            L_0x05a6:
                android.os.IBinder r0 = r7.readStrongBinder()
                com.google.android.gms.drive.internal.zzan r0 = com.google.android.gms.drive.internal.zzan.zza.zzbb(r0)
                r5.zza((com.google.android.gms.drive.internal.DeleteResourceRequest) r1, (com.google.android.gms.drive.internal.zzan) r0)
                goto L_0x002d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.internal.zzam.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    IntentSender zza(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException;

    IntentSender zza(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException;

    DriveServiceResponse zza(OpenContentsRequest openContentsRequest, zzan zzan) throws RemoteException;

    DriveServiceResponse zza(StreamContentsRequest streamContentsRequest, zzan zzan) throws RemoteException;

    void zza(RealtimeDocumentSyncRequest realtimeDocumentSyncRequest, zzan zzan) throws RemoteException;

    void zza(AddEventListenerRequest addEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException;

    void zza(AddPermissionRequest addPermissionRequest, zzan zzan) throws RemoteException;

    void zza(AuthorizeAccessRequest authorizeAccessRequest, zzan zzan) throws RemoteException;

    void zza(CancelPendingActionsRequest cancelPendingActionsRequest, zzan zzan) throws RemoteException;

    void zza(ChangeResourceParentsRequest changeResourceParentsRequest, zzan zzan) throws RemoteException;

    void zza(CheckResourceIdsExistRequest checkResourceIdsExistRequest, zzan zzan) throws RemoteException;

    void zza(CloseContentsAndUpdateMetadataRequest closeContentsAndUpdateMetadataRequest, zzan zzan) throws RemoteException;

    void zza(CloseContentsRequest closeContentsRequest, zzan zzan) throws RemoteException;

    void zza(ControlProgressRequest controlProgressRequest, zzan zzan) throws RemoteException;

    void zza(CreateContentsRequest createContentsRequest, zzan zzan) throws RemoteException;

    void zza(CreateFileRequest createFileRequest, zzan zzan) throws RemoteException;

    void zza(CreateFolderRequest createFolderRequest, zzan zzan) throws RemoteException;

    void zza(DeleteResourceRequest deleteResourceRequest, zzan zzan) throws RemoteException;

    void zza(DisconnectRequest disconnectRequest) throws RemoteException;

    void zza(FetchThumbnailRequest fetchThumbnailRequest, zzan zzan) throws RemoteException;

    void zza(GetChangesRequest getChangesRequest, zzan zzan) throws RemoteException;

    void zza(GetDriveIdFromUniqueIdentifierRequest getDriveIdFromUniqueIdentifierRequest, zzan zzan) throws RemoteException;

    void zza(GetMetadataRequest getMetadataRequest, zzan zzan) throws RemoteException;

    void zza(GetPermissionsRequest getPermissionsRequest, zzan zzan) throws RemoteException;

    void zza(ListParentsRequest listParentsRequest, zzan zzan) throws RemoteException;

    void zza(LoadRealtimeRequest loadRealtimeRequest, zzan zzan) throws RemoteException;

    void zza(QueryRequest queryRequest, zzan zzan) throws RemoteException;

    void zza(QueryRequest queryRequest, zzao zzao, zzan zzan) throws RemoteException;

    void zza(RemoveEventListenerRequest removeEventListenerRequest, zzao zzao, String str, zzan zzan) throws RemoteException;

    void zza(RemovePermissionRequest removePermissionRequest, zzan zzan) throws RemoteException;

    void zza(SetFileUploadPreferencesRequest setFileUploadPreferencesRequest, zzan zzan) throws RemoteException;

    void zza(SetPinnedDownloadPreferencesRequest setPinnedDownloadPreferencesRequest, zzan zzan) throws RemoteException;

    void zza(SetResourceParentsRequest setResourceParentsRequest, zzan zzan) throws RemoteException;

    void zza(TrashResourceRequest trashResourceRequest, zzan zzan) throws RemoteException;

    void zza(UnsubscribeResourceRequest unsubscribeResourceRequest, zzan zzan) throws RemoteException;

    void zza(UntrashResourceRequest untrashResourceRequest, zzan zzan) throws RemoteException;

    void zza(UpdateMetadataRequest updateMetadataRequest, zzan zzan) throws RemoteException;

    void zza(UpdatePermissionRequest updatePermissionRequest, zzan zzan) throws RemoteException;

    void zza(zzan zzan) throws RemoteException;

    void zza(zzao zzao, zzan zzan) throws RemoteException;

    void zzb(QueryRequest queryRequest, zzan zzan) throws RemoteException;

    void zzb(zzan zzan) throws RemoteException;

    void zzc(zzan zzan) throws RemoteException;

    void zzd(zzan zzan) throws RemoteException;

    void zze(zzan zzan) throws RemoteException;

    void zzf(zzan zzan) throws RemoteException;

    void zzg(zzan zzan) throws RemoteException;

    void zzh(zzan zzan) throws RemoteException;
}
