package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.internal.zzx;
import java.io.IOException;
import java.util.List;

public final class GoogleAuthUtil extends zzd {
    public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
    public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
    public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = zzd.KEY_ANDROID_PACKAGE_NAME;
    public static final String KEY_CALLER_UID = zzd.KEY_CALLER_UID;
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    @Deprecated
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";

    private GoogleAuthUtil() {
    }

    public static void clearToken(Context context, String str) throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException {
        zzd.clearToken(context, str);
    }

    public static List<AccountChangeEvent> getAccountChangeEvents(Context context, int i, String str) throws GoogleAuthException, IOException {
        return zzd.getAccountChangeEvents(context, i, str);
    }

    public static String getAccountId(Context context, String str) throws GoogleAuthException, IOException {
        return zzd.getAccountId(context, str);
    }

    public static String getToken(Context context, Account account, String str) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzd.getToken(context, account, str);
    }

    public static String getToken(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzd.getToken(context, account, str, bundle);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzd.getToken(context, str, str2);
    }

    @Deprecated
    public static String getToken(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableAuthException, GoogleAuthException {
        return zzd.getToken(context, str, str2, bundle);
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return zza(context, account, str, bundle).getToken();
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        zzi(intent);
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        bundle2.putParcelable("callback_intent", intent);
        bundle2.putBoolean("handle_notification", true);
        return zzb(context, account, str, bundle2).getToken();
    }

    public static String getTokenWithNotification(Context context, Account account, String str, Bundle bundle, String str2, Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        zzx.zzh(str2, "Authority cannot be empty or null.");
        Bundle bundle3 = bundle == null ? new Bundle() : bundle;
        Bundle bundle4 = bundle2 == null ? new Bundle() : bundle2;
        ContentResolver.validateSyncExtrasBundle(bundle4);
        bundle3.putString("authority", str2);
        bundle3.putBundle("sync_extras", bundle4);
        bundle3.putBoolean("handle_notification", true);
        return zzb(context, account, str, bundle3).getToken();
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, Intent intent) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, intent);
    }

    @Deprecated
    public static String getTokenWithNotification(Context context, String str, String str2, Bundle bundle, String str3, Bundle bundle2) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        return getTokenWithNotification(context, new Account(str, "com.google"), str2, bundle, str3, bundle2);
    }

    @Deprecated
    public static void invalidateToken(Context context, String str) {
        zzd.invalidateToken(context, str);
    }

    public static TokenData zza(Context context, Account account, String str, Bundle bundle) throws IOException, UserRecoverableNotifiedException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putBoolean("handle_notification", true);
        return zzb(context, account, str, bundle);
    }

    private static TokenData zzb(Context context, Account account, String str, Bundle bundle) throws IOException, GoogleAuthException {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            TokenData zzc = zzc(context, account, str, bundle);
            GooglePlayServicesUtil.zzal(context);
            return zzc;
        } catch (GooglePlayServicesAvailabilityException e) {
            GooglePlayServicesUtil.showErrorNotification(e.getConnectionStatusCode(), context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        } catch (UserRecoverableAuthException e2) {
            GooglePlayServicesUtil.zzal(context);
            throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
        }
    }
}
