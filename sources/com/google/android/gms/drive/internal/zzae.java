package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.ChangesAvailableEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.QueryResultEventParcelable;
import com.google.android.gms.drive.events.TransferProgressEvent;
import com.google.android.gms.drive.events.zzc;
import com.google.android.gms.drive.events.zzf;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzm;
import com.google.android.gms.drive.internal.zzao;
import java.util.ArrayList;
import java.util.List;

public class zzae extends zzao.zza {
    private final int zzanf;
    private final zzf zzarC;
    private final zza zzarD;
    private final List<Integer> zzarE = new ArrayList();

    private static class zza extends Handler {
        private final Context mContext;

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzm zzm, QueryResultEventParcelable queryResultEventParcelable) {
            DataHolder zzsX = queryResultEventParcelable.zzsX();
            if (zzsX != null) {
                final MetadataBuffer metadataBuffer = new MetadataBuffer(zzsX);
                zzm.zza(new zzk() {
                });
            }
            if (queryResultEventParcelable.zzsY()) {
                zzm.zzcJ(queryResultEventParcelable.zzsZ());
            }
        }

        public void handleMessage(Message message) {
            if (message.what != 1) {
                zzz.zze(this.mContext, "EventCallback", "Don't know how to handle this event");
                return;
            }
            Pair pair = (Pair) message.obj;
            zzf zzf = (zzf) pair.first;
            DriveEvent driveEvent = (DriveEvent) pair.second;
            int type = driveEvent.getType();
            if (type == 1) {
                ((ChangeListener) zzf).onChange((ChangeEvent) driveEvent);
            } else if (type == 2) {
                ((CompletionListener) zzf).onCompletion((CompletionEvent) driveEvent);
            } else if (type == 3) {
                zza((zzm) zzf, (QueryResultEventParcelable) driveEvent);
            } else if (type == 4) {
                ((zzc) zzf).zza((ChangesAvailableEvent) driveEvent);
            } else if (type != 8) {
                zzz.zzz("EventCallback", "Unexpected event: " + driveEvent);
            } else {
                ((zzi) zzf).zza(new com.google.android.gms.drive.events.internal.zza(((TransferProgressEvent) driveEvent).zzta()));
            }
        }

        public void zza(zzf zzf, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(zzf, driveEvent)));
        }
    }

    public zzae(Looper looper, Context context, int i, zzf zzf) {
        this.zzanf = i;
        this.zzarC = zzf;
        this.zzarD = new zza(looper, context);
    }

    public void zzc(OnEventResponse onEventResponse) throws RemoteException {
        DriveEvent zzts = onEventResponse.zzts();
        zzx.zzab(this.zzanf == zzts.getType());
        zzx.zzab(this.zzarE.contains(Integer.valueOf(zzts.getType())));
        this.zzarD.zza(this.zzarC, zzts);
    }

    public void zzdg(int i) {
        this.zzarE.add(Integer.valueOf(i));
    }

    public boolean zzdh(int i) {
        return this.zzarE.contains(Integer.valueOf(i));
    }
}
