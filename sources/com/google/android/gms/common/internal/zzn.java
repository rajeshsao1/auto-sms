package com.google.android.gms.common.internal;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.autosms.myapplicationcallevent.DBHelper;

public class zzn {
    private static final Uri zzamj;
    private static final Uri zzamk;

    static {
        Uri parse = Uri.parse("http://plus.google.com/");
        zzamj = parse;
        zzamk = parse.buildUpon().appendPath("circles").appendPath("find").build();
    }

    public static Intent zzcJ(String str) {
        Uri fromParts = Uri.fromParts("package", str, (String) null);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(fromParts);
        return intent;
    }

    public static Intent zzqU() {
        Intent intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
        intent.setPackage("com.google.android.wearable.app");
        return intent;
    }

    private static Uri zzw(String str, String str2) {
        Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter(DBHelper.CONTACTS_COLUMN_ID, str);
        if (!TextUtils.isEmpty(str2)) {
            appendQueryParameter.appendQueryParameter("pcampaignid", str2);
        }
        return appendQueryParameter.build();
    }

    public static Intent zzx(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(zzw(str, str2));
        intent.setPackage("com.android.vending");
        intent.addFlags(524288);
        return intent;
    }
}
