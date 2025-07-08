package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class zznj {
    private static final Method zzaol = zzsp();
    private static final Method zzaom = zzsq();
    private static final Method zzaon = zzsr();
    private static final Method zzaoo = zzss();
    private static final Method zzaop = zzst();

    public static int zza(WorkSource workSource) {
        Method method = zzaon;
        if (method != null) {
            try {
                return ((Integer) method.invoke(workSource, new Object[0])).intValue();
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        }
        return 0;
    }

    public static String zza(WorkSource workSource, int i) {
        Method method = zzaop;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i)});
        } catch (Exception e) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            return null;
        }
    }

    public static void zza(WorkSource workSource, int i, String str) {
        Method method = zzaom;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i), str});
            } catch (Exception e) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e);
            }
        } else {
            Method method2 = zzaol;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i)});
                } catch (Exception e2) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0004, code lost:
        r1 = r3.getPackageManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzaA(android.content.Context r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.content.pm.PackageManager r1 = r3.getPackageManager()
            if (r1 != 0) goto L_0x000b
            return r0
        L_0x000b:
            java.lang.String r3 = r3.getPackageName()
            java.lang.String r2 = "android.permission.UPDATE_DEVICE_STATS"
            int r3 = r1.checkPermission(r2, r3)
            if (r3 != 0) goto L_0x0018
            r0 = 1
        L_0x0018:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zznj.zzaA(android.content.Context):boolean");
    }

    public static List<String> zzb(WorkSource workSource) {
        int zza = workSource == null ? 0 : zza(workSource);
        if (zza == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < zza; i++) {
            String zza2 = zza(workSource, i);
            if (!zzni.zzcV(zza2)) {
                arrayList.add(zza2);
            }
        }
        return arrayList;
    }

    public static WorkSource zzf(int i, String str) {
        WorkSource workSource = new WorkSource();
        zza(workSource, i, str);
        return workSource;
    }

    public static WorkSource zzl(Context context, String str) {
        StringBuilder sb;
        String str2;
        if (context == null || context.getPackageManager() == null) {
            return null;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                return zzf(applicationInfo.uid, str);
            }
            sb = new StringBuilder();
            str2 = "Could not get applicationInfo from package: ";
            sb.append(str2);
            sb.append(str);
            Log.e("WorkSourceUtil", sb.toString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            sb = new StringBuilder();
            str2 = "Could not find package: ";
        }
    }

    private static Method zzsp() {
        try {
            return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzsq() {
        if (zzne.zzsj()) {
            try {
                return WorkSource.class.getMethod("add", new Class[]{Integer.TYPE, String.class});
            } catch (Exception e) {
            }
        }
        return null;
    }

    private static Method zzsr() {
        try {
            return WorkSource.class.getMethod("size", new Class[0]);
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzss() {
        try {
            return WorkSource.class.getMethod("get", new Class[]{Integer.TYPE});
        } catch (Exception e) {
            return null;
        }
    }

    private static Method zzst() {
        if (zzne.zzsj()) {
            try {
                return WorkSource.class.getMethod("getName", new Class[]{Integer.TYPE});
            } catch (Exception e) {
            }
        }
        return null;
    }
}
