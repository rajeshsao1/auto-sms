package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zze;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzw extends Fragment implements DialogInterface.OnCancelListener {
    /* access modifiers changed from: private */
    public boolean mStarted;
    /* access modifiers changed from: private */
    public int zzaiA = -1;
    /* access modifiers changed from: private */
    public ConnectionResult zzaiB;
    /* access modifiers changed from: private */
    public final Handler zzaiC = new Handler(Looper.getMainLooper());
    protected zzn zzaiD;
    private final SparseArray<zza> zzaiE = new SparseArray<>();
    /* access modifiers changed from: private */
    public boolean zzaiz;

    private class zza implements GoogleApiClient.OnConnectionFailedListener {
        public final int zzaiF;
        public final GoogleApiClient zzaiG;
        public final GoogleApiClient.OnConnectionFailedListener zzaiH;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.zzaiF = i;
            this.zzaiG = googleApiClient;
            this.zzaiH = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.zzaiF);
            printWriter.println(":");
            GoogleApiClient googleApiClient = this.zzaiG;
            googleApiClient.dump(str + "  ", fileDescriptor, printWriter, strArr);
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            zzw.this.zzaiC.post(new zzb(this.zzaiF, connectionResult));
        }

        public void zzpR() {
            this.zzaiG.unregisterConnectionFailedListener(this);
            this.zzaiG.disconnect();
        }
    }

    private class zzb implements Runnable {
        private final int zzaiJ;
        private final ConnectionResult zzaiK;

        public zzb(int i, ConnectionResult connectionResult) {
            this.zzaiJ = i;
            this.zzaiK = connectionResult;
        }

        public void run() {
            if (zzw.this.mStarted && !zzw.this.zzaiz) {
                boolean unused = zzw.this.zzaiz = true;
                int unused2 = zzw.this.zzaiA = this.zzaiJ;
                ConnectionResult unused3 = zzw.this.zzaiB = this.zzaiK;
                if (this.zzaiK.hasResolution()) {
                    try {
                        this.zzaiK.startResolutionForResult(zzw.this.getActivity(), ((zzw.this.getActivity().getSupportFragmentManager().getFragments().indexOf(zzw.this) + 1) << 16) + 1);
                    } catch (IntentSender.SendIntentException e) {
                        zzw.this.zzpP();
                    }
                } else if (zzw.this.zzpQ().isUserResolvableError(this.zzaiK.getErrorCode())) {
                    zzw.this.zzb(this.zzaiJ, this.zzaiK);
                } else if (this.zzaiK.getErrorCode() == 18) {
                    zzw.this.zzc(this.zzaiJ, this.zzaiK);
                } else {
                    zzw.this.zza(this.zzaiJ, this.zzaiK);
                }
            }
        }
    }

    public static zzw zza(FragmentActivity fragmentActivity) {
        zzx.zzcD("Must be called from main thread of process");
        try {
            zzw zzw = (zzw) fragmentActivity.getSupportFragmentManager().findFragmentByTag("GmsSupportLifecycleFrag");
            if (zzw == null || zzw.isRemoving()) {
                return null;
            }
            return zzw;
        } catch (ClassCastException e) {
            throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFrag is not a SupportLifecycleFragment", e);
        }
    }

    /* access modifiers changed from: private */
    public void zza(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unresolved error while connecting client. Stopping auto-manage.");
        zza zza2 = this.zzaiE.get(i);
        if (zza2 != null) {
            zzbD(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zza2.zzaiH;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
        zzpP();
    }

    public static zzw zzb(FragmentActivity fragmentActivity) {
        zzw zza2 = zza(fragmentActivity);
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        if (zza2 == null) {
            zza2 = zzpO();
            if (zza2 == null) {
                Log.w("GmsSupportLifecycleFrag", "Unable to find connection error message resources (Did you include play-services-base and the proper proguard rules?); error dialogs may be unavailable.");
                zza2 = new zzw();
            }
            supportFragmentManager.beginTransaction().add((Fragment) zza2, "GmsSupportLifecycleFrag").commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
        return zza2;
    }

    private static String zzi(ConnectionResult connectionResult) {
        return connectionResult.getErrorMessage() + " (" + connectionResult.getErrorCode() + ": " + zze.getErrorString(connectionResult.getErrorCode()) + ')';
    }

    private static zzw zzpO() {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.android.gms.common.api.internal.SupportLifecycleFragmentImpl");
        } catch (ClassNotFoundException | LinkageError | SecurityException e) {
            if (Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                Log.d("GmsSupportLifecycleFrag", "Unable to find SupportLifecycleFragmentImpl class", e);
            }
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (zzw) cls.newInstance();
        } catch (ExceptionInInitializerError | IllegalAccessException | InstantiationException | RuntimeException e2) {
            if (!Log.isLoggable("GmsSupportLifecycleFrag", 3)) {
                return null;
            }
            Log.d("GmsSupportLifecycleFrag", "Unable to instantiate SupportLifecycleFragmentImpl class", e2);
            return null;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (int i = 0; i < this.zzaiE.size(); i++) {
            this.zzaiE.valueAt(i).dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        if (zzpQ().isGooglePlayServicesAvailable(getActivity()) != 0) goto L_0x0026;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r4, int r5, android.content.Intent r6) {
        /*
            r3 = this;
            r0 = 1
            if (r4 == r0) goto L_0x0016
            r1 = 2
            if (r4 == r1) goto L_0x0007
            goto L_0x0026
        L_0x0007:
            com.google.android.gms.common.zzc r1 = r3.zzpQ()
            androidx.fragment.app.FragmentActivity r2 = r3.getActivity()
            int r1 = r1.isGooglePlayServicesAvailable(r2)
            if (r1 != 0) goto L_0x0026
            goto L_0x0027
        L_0x0016:
            r1 = -1
            if (r5 != r1) goto L_0x001a
            goto L_0x0027
        L_0x001a:
            if (r5 != 0) goto L_0x0026
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult
            r1 = 13
            r2 = 0
            r0.<init>(r1, r2)
            r3.zzaiB = r0
        L_0x0026:
            r0 = 0
        L_0x0027:
            if (r0 == 0) goto L_0x002d
            r3.zzpP()
            goto L_0x0034
        L_0x002d:
            int r0 = r3.zzaiA
            com.google.android.gms.common.ConnectionResult r1 = r3.zzaiB
            r3.zza((int) r0, (com.google.android.gms.common.ConnectionResult) r1)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zzw.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(this.zzaiA, new ConnectionResult(13, (PendingIntent) null));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zzaiz = bundle.getBoolean("resolving_error", false);
            int i = bundle.getInt("failed_client_id", -1);
            this.zzaiA = i;
            if (i >= 0) {
                this.zzaiB = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.zzaiz);
        int i = this.zzaiA;
        if (i >= 0) {
            bundle.putInt("failed_client_id", i);
            bundle.putInt("failed_status", this.zzaiB.getErrorCode());
            bundle.putParcelable("failed_resolution", this.zzaiB.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
        if (!this.zzaiz) {
            for (int i = 0; i < this.zzaiE.size(); i++) {
                this.zzaiE.valueAt(i).zzaiG.connect();
            }
        }
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
        for (int i = 0; i < this.zzaiE.size(); i++) {
            this.zzaiE.valueAt(i).zzaiG.disconnect();
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzx.zzb(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        boolean z = this.zzaiE.indexOfKey(i) < 0;
        zzx.zza(z, (Object) "Already managing a GoogleApiClient with id " + i);
        this.zzaiE.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && !this.zzaiz) {
            googleApiClient.connect();
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Failed to connect due to user resolvable error " + zzi(connectionResult));
        zza(i, connectionResult);
    }

    public void zzbD(int i) {
        zza zza2 = this.zzaiE.get(i);
        this.zzaiE.remove(i);
        if (zza2 != null) {
            zza2.zzpR();
        }
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, ConnectionResult connectionResult) {
        Log.w("GmsSupportLifecycleFrag", "Unable to connect, GooglePlayServices is updating.");
        zza(i, connectionResult);
    }

    /* access modifiers changed from: protected */
    public void zzpP() {
        this.zzaiz = false;
        this.zzaiA = -1;
        this.zzaiB = null;
        zzn zzn = this.zzaiD;
        if (zzn != null) {
            zzn.unregister();
            this.zzaiD = null;
        }
        for (int i = 0; i < this.zzaiE.size(); i++) {
            this.zzaiE.valueAt(i).zzaiG.connect();
        }
    }

    /* access modifiers changed from: protected */
    public zzc zzpQ() {
        return zzc.zzoK();
    }
}
