package com.google.android.gms.common.api;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.internal.zzb;
import java.util.ArrayList;
import java.util.List;

public final class Batch extends zzb<BatchResult> {
    /* access modifiers changed from: private */
    public int zzafZ;
    /* access modifiers changed from: private */
    public boolean zzaga;
    /* access modifiers changed from: private */
    public boolean zzagb;
    /* access modifiers changed from: private */
    public final PendingResult<?>[] zzagc;
    /* access modifiers changed from: private */
    public final Object zzpV;

    public static final class Builder {
        private GoogleApiClient zzaaj;
        private List<PendingResult<?>> zzage = new ArrayList();

        public Builder(GoogleApiClient googleApiClient) {
            this.zzaaj = googleApiClient;
        }

        public <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zzage.size());
            this.zzage.add(pendingResult);
            return batchResultToken;
        }

        public Batch build() {
            return new Batch(this.zzage, this.zzaaj);
        }
    }

    private Batch(List<PendingResult<?>> list, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzpV = new Object();
        int size = list.size();
        this.zzafZ = size;
        PendingResult<?>[] pendingResultArr = new PendingResult[size];
        this.zzagc = pendingResultArr;
        if (list.isEmpty()) {
            zza(new BatchResult(Status.zzagC, pendingResultArr));
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            PendingResult<?> pendingResult = list.get(i);
            this.zzagc[i] = pendingResult;
            pendingResult.zza(new PendingResult.zza() {
                /* JADX WARNING: Code restructure failed: missing block: B:24:0x0065, code lost:
                    return;
                 */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void zzu(com.google.android.gms.common.api.Status r5) {
                    /*
                        r4 = this;
                        com.google.android.gms.common.api.Batch r0 = com.google.android.gms.common.api.Batch.this
                        java.lang.Object r0 = r0.zzpV
                        monitor-enter(r0)
                        com.google.android.gms.common.api.Batch r1 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        boolean r1 = r1.isCanceled()     // Catch:{ all -> 0x0066 }
                        if (r1 == 0) goto L_0x0011
                        monitor-exit(r0)     // Catch:{ all -> 0x0066 }
                        return
                    L_0x0011:
                        boolean r1 = r5.isCanceled()     // Catch:{ all -> 0x0066 }
                        r2 = 1
                        if (r1 == 0) goto L_0x001e
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        boolean unused = r5.zzagb = r2     // Catch:{ all -> 0x0066 }
                        goto L_0x0029
                    L_0x001e:
                        boolean r5 = r5.isSuccess()     // Catch:{ all -> 0x0066 }
                        if (r5 != 0) goto L_0x0029
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        boolean unused = r5.zzaga = r2     // Catch:{ all -> 0x0066 }
                    L_0x0029:
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        com.google.android.gms.common.api.Batch.zzb(r5)     // Catch:{ all -> 0x0066 }
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        int r5 = r5.zzafZ     // Catch:{ all -> 0x0066 }
                        if (r5 != 0) goto L_0x0064
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        boolean r5 = r5.zzagb     // Catch:{ all -> 0x0066 }
                        if (r5 == 0) goto L_0x0044
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        com.google.android.gms.common.api.Batch.super.cancel()     // Catch:{ all -> 0x0066 }
                        goto L_0x0064
                    L_0x0044:
                        com.google.android.gms.common.api.Batch r5 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        boolean r5 = r5.zzaga     // Catch:{ all -> 0x0066 }
                        if (r5 == 0) goto L_0x0054
                        com.google.android.gms.common.api.Status r5 = new com.google.android.gms.common.api.Status     // Catch:{ all -> 0x0066 }
                        r1 = 13
                        r5.<init>(r1)     // Catch:{ all -> 0x0066 }
                        goto L_0x0056
                    L_0x0054:
                        com.google.android.gms.common.api.Status r5 = com.google.android.gms.common.api.Status.zzagC     // Catch:{ all -> 0x0066 }
                    L_0x0056:
                        com.google.android.gms.common.api.Batch r1 = com.google.android.gms.common.api.Batch.this     // Catch:{ all -> 0x0066 }
                        com.google.android.gms.common.api.BatchResult r2 = new com.google.android.gms.common.api.BatchResult     // Catch:{ all -> 0x0066 }
                        com.google.android.gms.common.api.PendingResult[] r3 = r1.zzagc     // Catch:{ all -> 0x0066 }
                        r2.<init>(r5, r3)     // Catch:{ all -> 0x0066 }
                        r1.zza(r2)     // Catch:{ all -> 0x0066 }
                    L_0x0064:
                        monitor-exit(r0)     // Catch:{ all -> 0x0066 }
                        return
                    L_0x0066:
                        r5 = move-exception
                        monitor-exit(r0)     // Catch:{ all -> 0x0066 }
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.Batch.AnonymousClass1.zzu(com.google.android.gms.common.api.Status):void");
                }
            });
        }
    }

    static /* synthetic */ int zzb(Batch batch) {
        int i = batch.zzafZ;
        batch.zzafZ = i - 1;
        return i;
    }

    public void cancel() {
        super.cancel();
        for (PendingResult<?> cancel : this.zzagc) {
            cancel.cancel();
        }
    }

    /* renamed from: createFailedResult */
    public BatchResult zzc(Status status) {
        return new BatchResult(status, this.zzagc);
    }
}
