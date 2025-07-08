package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    /* access modifiers changed from: private */
    public static final zzc zzbgP = zzc.zzoK();
    private static Method zzbgQ = null;
    private static final Object zzqy = new Object();

    public interface ProviderInstallListener {
        void onProviderInstallFailed(int i, Intent intent);

        void onProviderInstalled();
    }

    public static void installIfNeeded(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        zzx.zzb(context, (Object) "Context must not be null");
        zzbgP.zzak(context);
        Context remoteContext = zze.getRemoteContext(context);
        if (remoteContext != null) {
            synchronized (zzqy) {
                try {
                    if (zzbgQ == null) {
                        zzaV(remoteContext);
                    }
                    zzbgQ.invoke((Object) null, new Object[]{remoteContext});
                } catch (Exception e) {
                    Log.e("ProviderInstaller", "Failed to install provider: " + e.getMessage());
                    throw new GooglePlayServicesNotAvailableException(8);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        Log.e("ProviderInstaller", "Failed to get remote context");
        throw new GooglePlayServicesNotAvailableException(8);
    }

    public static void installIfNeededAsync(final Context context, final ProviderInstallListener providerInstallListener) {
        zzx.zzb(context, (Object) "Context must not be null");
        zzx.zzb(providerInstallListener, (Object) "Listener must not be null");
        zzx.zzcD("Must be called on the UI thread");
        new AsyncTask<Void, Void, Integer>() {
            /* access modifiers changed from: protected */
            /* renamed from: zzc */
            public Integer doInBackground(Void... voidArr) {
                int connectionStatusCode;
                try {
                    ProviderInstaller.installIfNeeded(context);
                    connectionStatusCode = 0;
                } catch (GooglePlayServicesRepairableException e) {
                    connectionStatusCode = e.getConnectionStatusCode();
                } catch (GooglePlayServicesNotAvailableException e2) {
                    connectionStatusCode = e2.errorCode;
                }
                return Integer.valueOf(connectionStatusCode);
            }

            /* access modifiers changed from: protected */
            /* renamed from: zze */
            public void onPostExecute(Integer num) {
                if (num.intValue() == 0) {
                    providerInstallListener.onProviderInstalled();
                    return;
                }
                providerInstallListener.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzbgP.zza(context, num.intValue(), "pi"));
            }
        }.execute(new Void[0]);
    }

    private static void zzaV(Context context) throws ClassNotFoundException, NoSuchMethodException {
        zzbgQ = context.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", new Class[]{Context.class});
    }
}
