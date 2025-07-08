package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.R;
import com.google.android.gms.internal.zzmu;

public final class zzg {
    public static String zzc(Context context, int i, String str) {
        Resources resources = context.getResources();
        if (i != 1) {
            if (i == 2) {
                return resources.getString(R.string.common_google_play_services_update_text, new Object[]{str});
            } else if (i == 3) {
                return resources.getString(R.string.common_google_play_services_enable_text, new Object[]{str});
            } else if (i == 5) {
                return resources.getString(R.string.common_google_play_services_invalid_account_text);
            } else {
                if (i == 7) {
                    return resources.getString(R.string.common_google_play_services_network_error_text);
                }
                if (i == 9) {
                    return resources.getString(R.string.common_google_play_services_unsupported_text, new Object[]{str});
                } else if (i == 20) {
                    return resources.getString(R.string.common_google_play_services_restricted_profile_text);
                } else {
                    if (i == 42) {
                        return resources.getString(R.string.common_google_play_services_wear_update_text);
                    }
                    switch (i) {
                        case 16:
                            return resources.getString(R.string.common_google_play_services_api_unavailable_text, new Object[]{str});
                        case 17:
                            return resources.getString(R.string.common_google_play_services_sign_in_failed_text);
                        case 18:
                            return resources.getString(R.string.common_google_play_services_updating_text, new Object[]{str});
                        default:
                            return resources.getString(R.string.common_google_play_services_unknown_issue, new Object[]{str});
                    }
                }
            }
        } else if (zzmu.zzb(resources)) {
            return resources.getString(R.string.common_google_play_services_install_text_tablet, new Object[]{str});
        } else {
            return resources.getString(R.string.common_google_play_services_install_text_phone, new Object[]{str});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        android.util.Log.e("GoogleApiAvailability", r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String zzg(android.content.Context r3, int r4) {
        /*
            android.content.res.Resources r3 = r3.getResources()
            r0 = 20
            java.lang.String r1 = "GoogleApiAvailability"
            if (r4 == r0) goto L_0x0067
            r0 = 42
            if (r4 == r0) goto L_0x0064
            r0 = 0
            switch(r4) {
                case 1: goto L_0x0061;
                case 2: goto L_0x0064;
                case 3: goto L_0x005e;
                case 4: goto L_0x005d;
                case 5: goto L_0x0055;
                case 6: goto L_0x005d;
                case 7: goto L_0x004d;
                case 8: goto L_0x004a;
                case 9: goto L_0x0042;
                case 10: goto L_0x003f;
                case 11: goto L_0x003c;
                default: goto L_0x0012;
            }
        L_0x0012:
            switch(r4) {
                case 16: goto L_0x0039;
                case 17: goto L_0x0031;
                case 18: goto L_0x002a;
                default: goto L_0x0015;
            }
        L_0x0015:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = "Unexpected error code "
            r3.append(r2)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
        L_0x0026:
            android.util.Log.e(r1, r3)
            return r0
        L_0x002a:
            int r4 = com.google.android.gms.R.string.common_google_play_services_updating_title
        L_0x002c:
            java.lang.String r3 = r3.getString(r4)
            return r3
        L_0x0031:
            java.lang.String r4 = "The specified account could not be signed in."
            android.util.Log.e(r1, r4)
            int r4 = com.google.android.gms.R.string.common_google_play_services_sign_in_failed_title
            goto L_0x002c
        L_0x0039:
            java.lang.String r3 = "One of the API components you attempted to connect to is not available."
            goto L_0x0026
        L_0x003c:
            java.lang.String r3 = "The application is not licensed to the user."
            goto L_0x0026
        L_0x003f:
            java.lang.String r3 = "Developer error occurred. Please see logs for detailed information"
            goto L_0x0026
        L_0x0042:
            java.lang.String r4 = "Google Play services is invalid. Cannot recover."
            android.util.Log.e(r1, r4)
            int r4 = com.google.android.gms.R.string.common_google_play_services_unsupported_title
            goto L_0x002c
        L_0x004a:
            java.lang.String r3 = "Internal error occurred. Please see logs for detailed information"
            goto L_0x0026
        L_0x004d:
            java.lang.String r4 = "Network error occurred. Please retry request later."
            android.util.Log.e(r1, r4)
            int r4 = com.google.android.gms.R.string.common_google_play_services_network_error_title
            goto L_0x002c
        L_0x0055:
            java.lang.String r4 = "An invalid account was specified when connecting. Please provide a valid account."
            android.util.Log.e(r1, r4)
            int r4 = com.google.android.gms.R.string.common_google_play_services_invalid_account_title
            goto L_0x002c
        L_0x005d:
            return r0
        L_0x005e:
            int r4 = com.google.android.gms.R.string.common_google_play_services_enable_title
            goto L_0x002c
        L_0x0061:
            int r4 = com.google.android.gms.R.string.common_google_play_services_install_title
            goto L_0x002c
        L_0x0064:
            int r4 = com.google.android.gms.R.string.common_google_play_services_update_title
            goto L_0x002c
        L_0x0067:
            java.lang.String r4 = "The current user profile is restricted and could not use authenticated features."
            android.util.Log.e(r1, r4)
            int r4 = com.google.android.gms.R.string.common_google_play_services_restricted_profile_title
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzg.zzg(android.content.Context, int):java.lang.String");
    }

    public static String zzh(Context context, int i) {
        return context.getResources().getString(i != 1 ? i != 2 ? i != 3 ? 17039370 : R.string.common_google_play_services_enable_button : R.string.common_google_play_services_update_button : R.string.common_google_play_services_install_button);
    }
}
