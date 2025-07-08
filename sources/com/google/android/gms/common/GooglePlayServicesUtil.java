package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationCompatExtras;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.R;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmu;
import com.google.android.gms.internal.zzne;

public final class GooglePlayServicesUtil extends zze {
    public static final String GMS_ERROR_DIALOG = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    @Deprecated
    public static final int GOOGLE_PLAY_SERVICES_VERSION_CODE = zze.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    public static final String GOOGLE_PLAY_STORE_PACKAGE = "com.android.vending";

    private static class zza extends Handler {
        private final Context zzsa;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        zza(Context context) {
            super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
            this.zzsa = context.getApplicationContext();
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                Log.w("GooglePlayServicesUtil", "Don't know how to handle this message: " + message.what);
                return;
            }
            int isGooglePlayServicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.zzsa);
            if (GooglePlayServicesUtil.isUserRecoverableError(isGooglePlayServicesAvailable)) {
                GooglePlayServicesUtil.zza(isGooglePlayServicesAvailable, this.zzsa);
            }
        }
    }

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2) {
        return getErrorDialog(i, activity, i2, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static Dialog getErrorDialog(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return zza(i, activity, (Fragment) null, i2, onCancelListener);
    }

    @Deprecated
    public static PendingIntent getErrorPendingIntent(int i, Context context, int i2) {
        return zze.getErrorPendingIntent(i, context, i2);
    }

    @Deprecated
    public static String getErrorString(int i) {
        return zze.getErrorString(i);
    }

    @Deprecated
    public static String getOpenSourceSoftwareLicenseInfo(Context context) {
        return zze.getOpenSourceSoftwareLicenseInfo(context);
    }

    public static Context getRemoteContext(Context context) {
        return zze.getRemoteContext(context);
    }

    public static Resources getRemoteResource(Context context) {
        return zze.getRemoteResource(context);
    }

    @Deprecated
    public static int isGooglePlayServicesAvailable(Context context) {
        return zze.isGooglePlayServicesAvailable(context);
    }

    @Deprecated
    public static boolean isUserRecoverableError(int i) {
        return zze.isUserRecoverableError(i);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2) {
        return showErrorDialogFragment(i, activity, i2, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static boolean showErrorDialogFragment(int i, Activity activity, int i2, DialogInterface.OnCancelListener onCancelListener) {
        return showErrorDialogFragment(i, activity, (Fragment) null, i2, onCancelListener);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        Dialog zza2 = zza(i, activity, fragment, i2, onCancelListener);
        if (zza2 == null) {
            return false;
        }
        zza(activity, onCancelListener, GMS_ERROR_DIALOG, zza2);
        return true;
    }

    @Deprecated
    public static void showErrorNotification(int i, Context context) {
        if (zzmu.zzaw(context) && i == 2) {
            i = 42;
        }
        if (zzd(context, i) || zze(context, i)) {
            zzam(context);
        } else {
            zza(i, context);
        }
    }

    private static Dialog zza(int i, Activity activity, Fragment fragment, int i2, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i == 0) {
            return null;
        }
        if (zzmu.zzaw(activity) && i == 2) {
            i = 42;
        }
        if (zzd(activity, i)) {
            i = 18;
        }
        if (zzne.zzsg()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(16843529, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zzg.zzc(activity, i, zzao(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent zza2 = GoogleApiAvailability.getInstance().zza(activity, i, "d");
        zzh zzh = fragment == null ? new zzh(activity, zza2, i2) : new zzh(fragment, zza2, i2);
        String zzh2 = zzg.zzh(activity, i);
        if (zzh2 != null) {
            builder.setPositiveButton(zzh2, zzh);
        }
        String zzg = zzg.zzg(activity, i);
        if (zzg != null) {
            builder.setTitle(zzg);
        }
        return builder.create();
    }

    /* access modifiers changed from: private */
    public static void zza(int i, Context context) {
        zza(i, context, (String) null);
    }

    private static void zza(int i, Context context, String str) {
        Notification notification;
        int i2;
        Resources resources = context.getResources();
        String zzao = zzao(context);
        String zzg = zzg.zzg(context, i);
        if (zzg == null) {
            zzg = resources.getString(R.string.common_google_play_services_notification_ticker);
        }
        String zzc = zzg.zzc(context, i, zzao);
        PendingIntent zza2 = GoogleApiAvailability.getInstance().zza(context, i, 0, "n");
        if (zzmu.zzaw(context)) {
            zzx.zzab(zzne.zzsh());
            Notification.Builder autoCancel = new Notification.Builder(context).setSmallIcon(R.drawable.common_ic_googleplayservices).setPriority(2).setAutoCancel(true);
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle();
            notification = autoCancel.setStyle(bigTextStyle.bigText(zzg + " " + zzc)).addAction(R.drawable.common_full_open_on_phone, resources.getString(R.string.common_open_on_phone), zza2).build();
        } else {
            String string = resources.getString(R.string.common_google_play_services_notification_ticker);
            if (zzne.zzsd()) {
                Notification.Builder autoCancel2 = new Notification.Builder(context).setSmallIcon(17301642).setContentTitle(zzg).setContentText(zzc).setContentIntent(zza2).setTicker(string).setAutoCancel(true);
                if (zzne.zzsl()) {
                    autoCancel2.setLocalOnly(true);
                }
                if (zzne.zzsh()) {
                    autoCancel2.setStyle(new Notification.BigTextStyle().bigText(zzc));
                    notification = autoCancel2.build();
                } else {
                    notification = autoCancel2.getNotification();
                }
                if (Build.VERSION.SDK_INT == 19) {
                    notification.extras.putBoolean(NotificationCompatExtras.EXTRA_LOCAL_ONLY, true);
                }
            } else {
                notification = new NotificationCompat.Builder(context).setSmallIcon(17301642).setTicker(string).setWhen(System.currentTimeMillis()).setAutoCancel(true).setContentIntent(zza2).setContentTitle(zzg).setContentText(zzc).build();
            }
        }
        if (zzbw(i)) {
            i2 = 10436;
            zzafQ.set(false);
        } else {
            i2 = 39789;
        }
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        if (str != null) {
            notificationManager.notify(str, i2, notification);
        } else {
            notificationManager.notify(i2, notification);
        }
    }

    public static void zza(Activity activity, DialogInterface.OnCancelListener onCancelListener, String str, Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof FragmentActivity;
        } catch (NoClassDefFoundError e) {
            z = false;
        }
        if (z) {
            SupportErrorDialogFragment.newInstance(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
        } else if (zzne.zzsd()) {
            ErrorDialogFragment.newInstance(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        } else {
            throw new RuntimeException("This Activity does not support Fragments.");
        }
    }

    private static void zzam(Context context) {
        zza zza2 = new zza(context);
        zza2.sendMessageDelayed(zza2.obtainMessage(1), 120000);
    }

    @Deprecated
    public static Intent zzbv(int i) {
        return zze.zzbv(i);
    }

    @Deprecated
    public static boolean zzd(Context context, int i) {
        return zze.zzd(context, i);
    }

    @Deprecated
    public static boolean zze(Context context, int i) {
        return zze.zze(context, i);
    }
}
