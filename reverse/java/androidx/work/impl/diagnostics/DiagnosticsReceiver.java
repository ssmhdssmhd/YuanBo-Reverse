package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.workers.DiagnosticsWorker;
import v.j;
import v.l;
import v.t;

/* loaded from: classes.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f1586a = j.f("DiagnosticsRcvr");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        j.c().a(f1586a, "Requesting diagnostics", new Throwable[0]);
        try {
            t.d(context).c(l.e(DiagnosticsWorker.class));
        } catch (IllegalStateException e6) {
            j.c().b(f1586a, "WorkManager is not initialized", e6);
        }
    }
}
