package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class zzw {

    public static final class zza {
        private final Object zzML;
        private final List<String> zzamp;

        private zza(Object obj) {
            this.zzML = zzx.zzz(obj);
            this.zzamp = new ArrayList();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(100);
            sb.append(this.zzML.getClass().getSimpleName());
            sb.append('{');
            int size = this.zzamp.size();
            for (int i = 0; i < size; i++) {
                sb.append(this.zzamp.get(i));
                if (i < size - 1) {
                    sb.append(", ");
                }
            }
            sb.append('}');
            return sb.toString();
        }

        public zza zzg(String str, Object obj) {
            List<String> list = this.zzamp;
            list.add(((String) zzx.zzz(str)) + "=" + String.valueOf(obj));
            return this;
        }
    }

    public static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int hashCode(Object... objArr) {
        return Arrays.hashCode(objArr);
    }

    public static zza zzy(Object obj) {
        return new zza(obj);
    }
}
