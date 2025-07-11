package com.google.android.gms.auth;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zze;
import com.google.android.gms.internal.zzas;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    private static final ComponentName zzVe = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
    private static final ComponentName zzVf = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");

    private interface zza<T> {
        T zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException;
    }

    static {
        int i = Build.VERSION.SDK_INT;
        int i2 = Build.VERSION.SDK_INT;
    }

    zzd() {
    }

    public static void clearToken(Context context, final String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        final Bundle bundle = new Bundle();
        String str2 = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", str2);
        String str3 = KEY_ANDROID_PACKAGE_NAME;
        if (!bundle.containsKey(str3)) {
            bundle.putString(str3, str2);
        }
        zza(context, zzVe, new zza<Void>() {
            /* renamed from: zzao */
            public Void zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                Bundle bundle = (Bundle) zzd.zzm(zzas.zza.zza(iBinder).zza(str, bundle));
                String string = bundle.getString("Error");
                if (bundle.getBoolean("booleanResult")) {
                    return null;
                }
                throw new GoogleAuthException(string);
            }
        });
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, final int i, final String str) throws GoogleAuthException, IOException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        return (List) zza(context, zzVe, new zza<List<AccountChangeEvent>>() {
            /* renamed from: zzap */
            public List<AccountChangeEvent> zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                return ((AccountChangeEventsResponse) zzd.zzm(zzas.zza.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(str).setEventIndex(i)))).getEvents();
            }
        });
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        zzx.zzh(str, "accountName must be provided");
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        return getToken(context, str, "^^_account_id_^^", new Bundle());
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, account, str, new Bundle());
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzc(context, account, str, bundle).getToken();
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return getToken(context, new Account(str, "com.google"), str2, bundle);
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        AccountManager.get(context).invalidateAuthToken("com.google", str);
    }

    private static <T> T zza(Context context, ComponentName componentName, zza<T> zza2) throws IOException, GoogleAuthException {
        com.google.android.gms.common.zza zza3 = new com.google.android.gms.common.zza();
        zzl zzau = zzl.zzau(context);
        if (zzau.zza(componentName, (ServiceConnection) zza3, "GoogleAuthUtil")) {
            try {
                T zzan = zza2.zzan(zza3.zzoJ());
                zzau.zzb(componentName, (ServiceConnection) zza3, "GoogleAuthUtil");
                return zzan;
            } catch (RemoteException | InterruptedException e) {
                Log.i("GoogleAuthUtil", "Error on service connection.", e);
                throw new IOException("Error on service connection.", e);
            } catch (Throwable th) {
                zzau.zzb(componentName, (ServiceConnection) zza3, "GoogleAuthUtil");
                throw th;
            }
        } else {
            throw new IOException("Could not bind to service.");
        }
    }

    private static void zzad(Context context) throws GoogleAuthException {
        try {
            zze.zzad(context.getApplicationContext());
        } catch (GooglePlayServicesRepairableException e) {
            throw new GooglePlayServicesAvailabilityException(e.getConnectionStatusCode(), e.getMessage(), e.getIntent());
        } catch (GooglePlayServicesNotAvailableException e2) {
            throw new GoogleAuthException(e2.getMessage());
        }
    }

    public static TokenData zzc(Context context, final Account account, final String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        zzx.zzcE("Calling this from your main thread can lead to deadlock");
        zzad(context);
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        String str2 = context.getApplicationInfo().packageName;
        bundle2.putString("clientPackageName", str2);
        String str3 = KEY_ANDROID_PACKAGE_NAME;
        if (TextUtils.isEmpty(bundle2.getString(str3))) {
            bundle2.putString(str3, str2);
        }
        bundle2.putLong("service_connection_start_time_millis", SystemClock.elapsedRealtime());
        return (TokenData) zza(context, zzVe, new zza<TokenData>() {
            /* renamed from: zzam */
            public TokenData zzan(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
                Bundle bundle = (Bundle) zzd.zzm(zzas.zza.zza(iBinder).zza(account, str, bundle2));
                TokenData zzc = TokenData.zzc(bundle, "tokenDetails");
                if (zzc != null) {
                    return zzc;
                }
                String string = bundle.getString("Error");
                Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
                com.google.android.gms.auth.firstparty.shared.zzd zzbY = com.google.android.gms.auth.firstparty.shared.zzd.zzbY(string);
                if (com.google.android.gms.auth.firstparty.shared.zzd.zza(zzbY)) {
                    throw new UserRecoverableAuthException(string, intent);
                } else if (com.google.android.gms.auth.firstparty.shared.zzd.zzc(zzbY)) {
                    throw new IOException(string);
                } else {
                    throw new GoogleAuthException(string);
                }
            }
        });
    }

    static void zzi(Intent intent) {
        if (intent != null) {
            try {
                Intent.parseUri(intent.toUri(1), 1);
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
            }
        } else {
            throw new IllegalArgumentException("Callback cannot be null.");
        }
    }

    /* access modifiers changed from: private */
    public static <T> T zzm(T t) throws IOException {
        if (t != null) {
            return t;
        }
        Log.w("GoogleAuthUtil", "Binder call returned null.");
        throw new IOException("Service unavailable.");
    }
}
