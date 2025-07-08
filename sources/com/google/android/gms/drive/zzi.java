package com.google.android.gms.drive;

import com.google.android.gms.drive.ExecutionOptions;

public class zzi extends ExecutionOptions {
    private boolean zzapa;

    public static class zza extends ExecutionOptions.Builder {
        private boolean zzapa = true;

        /* renamed from: zzae */
        public zza setNotifyOnCompletion(boolean z) {
            super.setNotifyOnCompletion(z);
            return this;
        }

        /* renamed from: zzcZ */
        public zza setTrackingTag(String str) {
            super.setTrackingTag(str);
            return this;
        }

        /* renamed from: zzcy */
        public zza setConflictStrategy(int i) {
            super.setConflictStrategy(i);
            return this;
        }

        /* renamed from: zzsJ */
        public zzi build() {
            zzsE();
            return new zzi(this.zzaoV, this.zzaoW, this.zzaoX, this.zzapa);
        }
    }

    private zzi(String str, boolean z, int i, boolean z2) {
        super(str, z, i);
        this.zzapa = z2;
    }

    public static zzi zzb(ExecutionOptions executionOptions) {
        zza zza2 = new zza();
        if (executionOptions != null) {
            zza2.setConflictStrategy(executionOptions.zzsD());
            zza2.setNotifyOnCompletion(executionOptions.zzsC());
            String zzsB = executionOptions.zzsB();
            if (zzsB != null) {
                zza2.setTrackingTag(zzsB);
            }
        }
        return zza2.build();
    }

    public boolean zzsI() {
        return this.zzapa;
    }
}
