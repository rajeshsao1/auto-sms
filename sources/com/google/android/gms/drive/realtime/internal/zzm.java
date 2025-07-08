package com.google.android.gms.drive.realtime.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.realtime.internal.event.ParcelableEventList;

public interface zzm extends IInterface {

    public static abstract class zza extends Binder implements zzm {

        /* renamed from: com.google.android.gms.drive.realtime.internal.zzm$zza$zza  reason: collision with other inner class name */
        private static class C0026zza implements zzm {
            private IBinder zzoz;

            C0026zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public void zza(int i, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(int i, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(50, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(DriveId driveId, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (driveId != null) {
                        obtain.writeInt(1);
                        driveId.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(48, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (beginCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        beginCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(41, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (endCompoundOperationRequest != null) {
                        obtain.writeInt(1);
                        endCompoundOperationRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(ParcelableIndexReference parcelableIndexReference, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    if (parcelableIndexReference != null) {
                        obtain.writeInt(1);
                        parcelableIndexReference.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(26, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzd zzd) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzd != null ? zzd.asBinder() : null);
                    this.zzoz.transact(32, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zze zze) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zze != null ? zze.asBinder() : null);
                    this.zzoz.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzh zzh) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzh != null ? zzh.asBinder() : null);
                    this.zzoz.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzi zzi) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzi != null ? zzi.asBinder() : null);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(40, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, int i2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(46, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(28, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, int i2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeInt(i2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, int i, String str2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzk zzk) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzk != null ? zzk.asBinder() : null);
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(38, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, DataHolder dataHolder, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    if (dataHolder != null) {
                        obtain.writeInt(1);
                        dataHolder.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(43, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzg zzg) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzg != null ? zzg.asBinder() : null);
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(String str, String str2, zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zza(boolean z, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(47, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(33, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzj zzj) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzj != null ? zzj.asBinder() : null);
                    this.zzoz.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzn zzn) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzn != null ? zzn.asBinder() : null);
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(39, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzb(String str, String str2, zzf zzf) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(zzf != null ? zzf.asBinder() : null);
                    this.zzoz.transact(42, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(45, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(zzo zzo) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzo != null ? zzo.asBinder() : null);
                    this.zzoz.transact(49, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzc(String str, zzl zzl) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeStrongBinder(zzl != null ? zzl.asBinder() : null);
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zzd(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zze(zzc zzc) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeStrongBinder(zzc != null ? zzc.asBinder() : null);
                    this.zzoz.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ParcelableEventList zzf(String str, String str2, String str3) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    this.zzoz.transact(51, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0 ? ParcelableEventList.CREATOR.createFromParcel(obtain2) : null;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void zztT() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.drive.realtime.internal.IRealtimeService");
                    this.zzoz.transact(44, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzm zzbo(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.realtime.internal.IRealtimeService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzm)) ? new C0026zza(iBinder) : (zzm) queryLocalInterface;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v24, resolved type: com.google.android.gms.drive.realtime.internal.ParcelableIndexReference} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v30, resolved type: com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v35, resolved type: com.google.android.gms.common.data.DataHolder} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v40, resolved type: com.google.android.gms.drive.DriveId} */
        /* JADX WARNING: type inference failed for: r3v0 */
        /* JADX WARNING: type inference failed for: r3v44 */
        /* JADX WARNING: type inference failed for: r3v45 */
        /* JADX WARNING: type inference failed for: r3v46 */
        /* JADX WARNING: type inference failed for: r3v47 */
        /* JADX WARNING: type inference failed for: r3v48 */
        /* JADX WARNING: type inference failed for: r3v49 */
        /* JADX WARNING: type inference failed for: r3v50 */
        /* JADX WARNING: type inference failed for: r3v51 */
        /* JADX WARNING: type inference failed for: r3v52 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTransact(int r10, android.os.Parcel r11, android.os.Parcel r12, int r13) throws android.os.RemoteException {
            /*
                r9 = this;
                r0 = 1598968902(0x5f4e5446, float:1.4867585E19)
                java.lang.String r1 = "com.google.android.gms.drive.realtime.internal.IRealtimeService"
                r2 = 1
                if (r10 == r0) goto L_0x0480
                r0 = 0
                r3 = 0
                switch(r10) {
                    case 1: goto L_0x046c;
                    case 2: goto L_0x045c;
                    case 3: goto L_0x044c;
                    case 4: goto L_0x0434;
                    case 5: goto L_0x0420;
                    case 6: goto L_0x0400;
                    case 7: goto L_0x03ec;
                    case 8: goto L_0x03d8;
                    case 9: goto L_0x03c4;
                    case 10: goto L_0x03a8;
                    case 11: goto L_0x038c;
                    case 12: goto L_0x0374;
                    case 13: goto L_0x0360;
                    case 14: goto L_0x034c;
                    case 15: goto L_0x0328;
                    case 16: goto L_0x0304;
                    case 17: goto L_0x02e8;
                    case 18: goto L_0x02c9;
                    case 19: goto L_0x02aa;
                    case 20: goto L_0x0296;
                    case 21: goto L_0x027e;
                    case 22: goto L_0x026e;
                    case 23: goto L_0x025e;
                    case 24: goto L_0x024e;
                    case 25: goto L_0x023e;
                    case 26: goto L_0x021f;
                    case 27: goto L_0x020b;
                    case 28: goto L_0x01f3;
                    case 29: goto L_0x01e3;
                    case 30: goto L_0x01cf;
                    case 31: goto L_0x01bf;
                    case 32: goto L_0x01af;
                    case 33: goto L_0x019f;
                    case 34: goto L_0x018f;
                    case 35: goto L_0x017f;
                    case 36: goto L_0x016f;
                    case 37: goto L_0x014e;
                    case 38: goto L_0x013a;
                    case 39: goto L_0x0126;
                    case 40: goto L_0x0116;
                    case 41: goto L_0x00f7;
                    case 42: goto L_0x00df;
                    case 43: goto L_0x00bb;
                    case 44: goto L_0x00b4;
                    case 45: goto L_0x00a5;
                    case 46: goto L_0x008e;
                    case 47: goto L_0x0078;
                    case 48: goto L_0x005a;
                    case 49: goto L_0x004b;
                    case 50: goto L_0x0035;
                    case 51: goto L_0x0012;
                    default: goto L_0x000d;
                }
            L_0x000d:
                boolean r0 = super.onTransact(r10, r11, r12, r13)
                return r0
            L_0x0012:
                r11.enforceInterface(r1)
                java.lang.String r1 = r11.readString()
                java.lang.String r3 = r11.readString()
                java.lang.String r4 = r11.readString()
                com.google.android.gms.drive.realtime.internal.event.ParcelableEventList r1 = r9.zzf(r1, r3, r4)
                r12.writeNoException()
                if (r1 == 0) goto L_0x0031
                r12.writeInt(r2)
                r1.writeToParcel(r12, r2)
                goto L_0x0034
            L_0x0031:
                r12.writeInt(r0)
            L_0x0034:
                return r2
            L_0x0035:
                r11.enforceInterface(r1)
                int r0 = r11.readInt()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r9.zza((int) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
            L_0x0047:
                r12.writeNoException()
                return r2
            L_0x004b:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r9.zzc((com.google.android.gms.drive.realtime.internal.zzo) r0)
                goto L_0x0047
            L_0x005a:
                r11.enforceInterface(r1)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x006c
                android.os.Parcelable$Creator<com.google.android.gms.drive.DriveId> r0 = com.google.android.gms.drive.DriveId.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                r3 = r0
                com.google.android.gms.drive.DriveId r3 = (com.google.android.gms.drive.DriveId) r3
            L_0x006c:
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r9.zza((com.google.android.gms.drive.DriveId) r3, (com.google.android.gms.drive.realtime.internal.zzo) r0)
                goto L_0x0047
            L_0x0078:
                r11.enforceInterface(r1)
                int r1 = r11.readInt()
                if (r1 == 0) goto L_0x0082
                r0 = 1
            L_0x0082:
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r9.zza((boolean) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                goto L_0x0047
            L_0x008e:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r3 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r3)
                r9.zza((java.lang.String) r0, (int) r1, (com.google.android.gms.drive.realtime.internal.zzn) r3)
                goto L_0x0047
            L_0x00a5:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r9.zzc((com.google.android.gms.drive.realtime.internal.zzc) r0)
                goto L_0x0047
            L_0x00b4:
                r11.enforceInterface(r1)
                r9.zztT()
                goto L_0x0047
            L_0x00bb:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                java.lang.String r1 = r11.readString()
                int r4 = r11.readInt()
                if (r4 == 0) goto L_0x00d2
                com.google.android.gms.common.data.zze r3 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r3 = r3.createFromParcel(r11)
            L_0x00d2:
                android.os.IBinder r4 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r4 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r4)
                r9.zza((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.common.data.DataHolder) r3, (com.google.android.gms.drive.realtime.internal.zzj) r4)
                goto L_0x0047
            L_0x00df:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                java.lang.String r1 = r11.readString()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r3 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r3)
                r9.zzb(r0, r1, r3)
                goto L_0x0047
            L_0x00f7:
                r11.enforceInterface(r1)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0109
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                r3 = r0
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r3 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r3
            L_0x0109:
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r0 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r3, (com.google.android.gms.drive.realtime.internal.zzj) r0)
                goto L_0x0047
            L_0x0116:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r0 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zzl) r0)
                goto L_0x0047
            L_0x0126:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r9.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                goto L_0x0047
            L_0x013a:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r1 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r1)
                r9.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzo) r1)
                goto L_0x0047
            L_0x014e:
                r11.enforceInterface(r1)
                java.lang.String r4 = r11.readString()
                int r5 = r11.readInt()
                java.lang.String r6 = r11.readString()
                int r7 = r11.readInt()
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r8 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r0)
                r3 = r9
                r3.zza(r4, r5, r6, r7, r8)
                goto L_0x0047
            L_0x016f:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzh r0 = com.google.android.gms.drive.realtime.internal.zzh.zza.zzbj(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zzh) r0)
                goto L_0x0047
            L_0x017f:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r9.zzb((com.google.android.gms.drive.realtime.internal.zzo) r0)
                goto L_0x0047
            L_0x018f:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzi r0 = com.google.android.gms.drive.realtime.internal.zzi.zza.zzbk(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zzi) r0)
                goto L_0x0047
            L_0x019f:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r9.zzb((com.google.android.gms.drive.realtime.internal.zzc) r0)
                goto L_0x0047
            L_0x01af:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzd r0 = com.google.android.gms.drive.realtime.internal.zzd.zza.zzbf(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zzd) r0)
                goto L_0x0047
            L_0x01bf:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zze r0 = com.google.android.gms.drive.realtime.internal.zze.zza.zzbg(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zze) r0)
                goto L_0x0047
            L_0x01cf:
                r11.enforceInterface(r1)
                int r0 = r11.readInt()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r1)
                r9.zza((int) r0, (com.google.android.gms.drive.realtime.internal.zzj) r1)
                goto L_0x0047
            L_0x01e3:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r0 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r0)
                r9.zzb((com.google.android.gms.drive.realtime.internal.zzl) r0)
                goto L_0x0047
            L_0x01f3:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r3 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r3)
                r9.zza((java.lang.String) r0, (int) r1, (com.google.android.gms.drive.realtime.internal.zzo) r3)
                goto L_0x0047
            L_0x020b:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzk r1 = com.google.android.gms.drive.realtime.internal.zzk.zza.zzbm(r1)
                r9.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzk) r1)
                goto L_0x0047
            L_0x021f:
                r11.enforceInterface(r1)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x0231
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.ParcelableIndexReference> r0 = com.google.android.gms.drive.realtime.internal.ParcelableIndexReference.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                r3 = r0
                com.google.android.gms.drive.realtime.internal.ParcelableIndexReference r3 = (com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r3
            L_0x0231:
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r0 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.ParcelableIndexReference) r3, (com.google.android.gms.drive.realtime.internal.zzn) r0)
                goto L_0x0047
            L_0x023e:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r9.zze(r0)
                goto L_0x0047
            L_0x024e:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r9.zzd(r0)
                goto L_0x0047
            L_0x025e:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r0 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r0)
                r9.zzb((com.google.android.gms.drive.realtime.internal.zzj) r0)
                goto L_0x0047
            L_0x026e:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r0 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zzj) r0)
                goto L_0x0047
            L_0x027e:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                java.lang.String r1 = r11.readString()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r3 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzbi(r3)
                r9.zza((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.zzg) r3)
                goto L_0x0047
            L_0x0296:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r1 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r1)
                r9.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzf) r1)
                goto L_0x0047
            L_0x02aa:
                r11.enforceInterface(r1)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x02bc
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                r3 = r0
                com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest r3 = (com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r3
            L_0x02bc:
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.EndCompoundOperationRequest) r3, (com.google.android.gms.drive.realtime.internal.zzo) r0)
                goto L_0x0047
            L_0x02c9:
                r11.enforceInterface(r1)
                int r0 = r11.readInt()
                if (r0 == 0) goto L_0x02db
                android.os.Parcelable$Creator<com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest> r0 = com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest.CREATOR
                java.lang.Object r0 = r0.createFromParcel(r11)
                r3 = r0
                com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest r3 = (com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest) r3
            L_0x02db:
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.BeginCompoundOperationRequest) r3, (com.google.android.gms.drive.realtime.internal.zzo) r0)
                goto L_0x0047
            L_0x02e8:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                int r3 = r11.readInt()
                android.os.IBinder r4 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r4 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzbi(r4)
                r9.zza((java.lang.String) r0, (int) r1, (int) r3, (com.google.android.gms.drive.realtime.internal.zzg) r4)
                goto L_0x0047
            L_0x0304:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                int r4 = r11.readInt()
                if (r4 == 0) goto L_0x031b
                com.google.android.gms.common.data.zze r3 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r3 = r3.createFromParcel(r11)
            L_0x031b:
                android.os.IBinder r4 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzg r4 = com.google.android.gms.drive.realtime.internal.zzg.zza.zzbi(r4)
                r9.zza((java.lang.String) r0, (int) r1, (com.google.android.gms.common.data.DataHolder) r3, (com.google.android.gms.drive.realtime.internal.zzg) r4)
                goto L_0x0047
            L_0x0328:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                int r4 = r11.readInt()
                if (r4 == 0) goto L_0x033f
                com.google.android.gms.common.data.zze r3 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r3 = r3.createFromParcel(r11)
            L_0x033f:
                android.os.IBinder r4 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r4 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r4)
                r9.zza((java.lang.String) r0, (int) r1, (com.google.android.gms.common.data.DataHolder) r3, (com.google.android.gms.drive.realtime.internal.zzj) r4)
                goto L_0x0047
            L_0x034c:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r1)
                r9.zzc(r0, r1)
                goto L_0x0047
            L_0x0360:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r1 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r1)
                r9.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzf) r1)
                goto L_0x0047
            L_0x0374:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                java.lang.String r1 = r11.readString()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r3 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r3)
                r9.zza((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.zzj) r3)
                goto L_0x0047
            L_0x038c:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                int r3 = r11.readInt()
                android.os.IBinder r4 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r4 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r4)
                r9.zza((java.lang.String) r0, (int) r1, (int) r3, (com.google.android.gms.drive.realtime.internal.zzj) r4)
                goto L_0x0047
            L_0x03a8:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                java.lang.String r3 = r11.readString()
                android.os.IBinder r4 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r4 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r4)
                r9.zza((java.lang.String) r0, (int) r1, (java.lang.String) r3, (com.google.android.gms.drive.realtime.internal.zzj) r4)
                goto L_0x0047
            L_0x03c4:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r1)
                r9.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzn) r1)
                goto L_0x0047
            L_0x03d8:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r1)
                r9.zzb((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzl) r1)
                goto L_0x0047
            L_0x03ec:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r1)
                r9.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzj) r1)
                goto L_0x0047
            L_0x0400:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                int r1 = r11.readInt()
                if (r1 == 0) goto L_0x0413
                com.google.android.gms.common.data.zze r1 = com.google.android.gms.common.data.DataHolder.CREATOR
                com.google.android.gms.common.data.DataHolder r3 = r1.createFromParcel(r11)
            L_0x0413:
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzj r1 = com.google.android.gms.drive.realtime.internal.zzj.zza.zzbl(r1)
                r9.zza((java.lang.String) r0, (com.google.android.gms.common.data.DataHolder) r3, (com.google.android.gms.drive.realtime.internal.zzj) r1)
                goto L_0x0047
            L_0x0420:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzl r1 = com.google.android.gms.drive.realtime.internal.zzl.zza.zzbn(r1)
                r9.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzl) r1)
                goto L_0x0047
            L_0x0434:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                java.lang.String r1 = r11.readString()
                android.os.IBinder r3 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzf r3 = com.google.android.gms.drive.realtime.internal.zzf.zza.zzbh(r3)
                r9.zza((java.lang.String) r0, (java.lang.String) r1, (com.google.android.gms.drive.realtime.internal.zzf) r3)
                goto L_0x0047
            L_0x044c:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzo r0 = com.google.android.gms.drive.realtime.internal.zzo.zza.zzbq(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zzo) r0)
                goto L_0x0047
            L_0x045c:
                r11.enforceInterface(r1)
                android.os.IBinder r0 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzc r0 = com.google.android.gms.drive.realtime.internal.zzc.zza.zzbe(r0)
                r9.zza((com.google.android.gms.drive.realtime.internal.zzc) r0)
                goto L_0x0047
            L_0x046c:
                r11.enforceInterface(r1)
                java.lang.String r0 = r11.readString()
                android.os.IBinder r1 = r11.readStrongBinder()
                com.google.android.gms.drive.realtime.internal.zzn r1 = com.google.android.gms.drive.realtime.internal.zzn.zza.zzbp(r1)
                r9.zza((java.lang.String) r0, (com.google.android.gms.drive.realtime.internal.zzn) r1)
                goto L_0x0047
            L_0x0480:
                r12.writeString(r1)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.drive.realtime.internal.zzm.zza.onTransact(int, android.os.Parcel, android.os.Parcel, int):boolean");
        }
    }

    void zza(int i, zzj zzj) throws RemoteException;

    void zza(int i, zzo zzo) throws RemoteException;

    void zza(DriveId driveId, zzo zzo) throws RemoteException;

    void zza(BeginCompoundOperationRequest beginCompoundOperationRequest, zzo zzo) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzj zzj) throws RemoteException;

    void zza(EndCompoundOperationRequest endCompoundOperationRequest, zzo zzo) throws RemoteException;

    void zza(ParcelableIndexReference parcelableIndexReference, zzn zzn) throws RemoteException;

    void zza(zzc zzc) throws RemoteException;

    void zza(zzd zzd) throws RemoteException;

    void zza(zze zze) throws RemoteException;

    void zza(zzh zzh) throws RemoteException;

    void zza(zzi zzi) throws RemoteException;

    void zza(zzj zzj) throws RemoteException;

    void zza(zzl zzl) throws RemoteException;

    void zza(zzo zzo) throws RemoteException;

    void zza(String str, int i, int i2, zzg zzg) throws RemoteException;

    void zza(String str, int i, int i2, zzj zzj) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzg zzg) throws RemoteException;

    void zza(String str, int i, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, int i, zzn zzn) throws RemoteException;

    void zza(String str, int i, zzo zzo) throws RemoteException;

    void zza(String str, int i, String str2, int i2, zzj zzj) throws RemoteException;

    void zza(String str, int i, String str2, zzj zzj) throws RemoteException;

    void zza(String str, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, zzf zzf) throws RemoteException;

    void zza(String str, zzj zzj) throws RemoteException;

    void zza(String str, zzk zzk) throws RemoteException;

    void zza(String str, zzl zzl) throws RemoteException;

    void zza(String str, zzn zzn) throws RemoteException;

    void zza(String str, zzo zzo) throws RemoteException;

    void zza(String str, String str2, DataHolder dataHolder, zzj zzj) throws RemoteException;

    void zza(String str, String str2, zzf zzf) throws RemoteException;

    void zza(String str, String str2, zzg zzg) throws RemoteException;

    void zza(String str, String str2, zzj zzj) throws RemoteException;

    void zza(boolean z, zzo zzo) throws RemoteException;

    void zzb(zzc zzc) throws RemoteException;

    void zzb(zzj zzj) throws RemoteException;

    void zzb(zzl zzl) throws RemoteException;

    void zzb(zzo zzo) throws RemoteException;

    void zzb(String str, zzf zzf) throws RemoteException;

    void zzb(String str, zzl zzl) throws RemoteException;

    void zzb(String str, zzn zzn) throws RemoteException;

    void zzb(String str, zzo zzo) throws RemoteException;

    void zzb(String str, String str2, zzf zzf) throws RemoteException;

    void zzc(zzc zzc) throws RemoteException;

    void zzc(zzo zzo) throws RemoteException;

    void zzc(String str, zzl zzl) throws RemoteException;

    void zzd(zzc zzc) throws RemoteException;

    void zze(zzc zzc) throws RemoteException;

    ParcelableEventList zzf(String str, String str2, String str3) throws RemoteException;

    void zztT() throws RemoteException;
}
