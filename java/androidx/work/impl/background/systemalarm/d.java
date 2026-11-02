package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import androidx.work.impl.background.systemalarm.e;
import d0.p;
import e0.n;
import e0.r;
import java.util.Collections;
import java.util.List;
import v.j;

/* loaded from: classes.dex */
public class d implements z.c, w.b, r.b {

    /* renamed from: j, reason: collision with root package name */
    private static final String f1555j = j.f("DelayMetCommandHandler");

    /* renamed from: a, reason: collision with root package name */
    private final Context f1556a;

    /* renamed from: b, reason: collision with root package name */
    private final int f1557b;

    /* renamed from: c, reason: collision with root package name */
    private final String f1558c;

    /* renamed from: d, reason: collision with root package name */
    private final e f1559d;

    /* renamed from: e, reason: collision with root package name */
    private final z.d f1560e;

    /* renamed from: h, reason: collision with root package name */
    private PowerManager.WakeLock f1563h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f1564i = false;

    /* renamed from: g, reason: collision with root package name */
    private int f1562g = 0;

    /* renamed from: f, reason: collision with root package name */
    private final Object f1561f = new Object();

    d(Context context, int i6, String str, e eVar) {
        this.f1556a = context;
        this.f1557b = i6;
        this.f1559d = eVar;
        this.f1558c = str;
        this.f1560e = new z.d(context, eVar.f(), this);
    }

    private void d() {
        synchronized (this.f1561f) {
            this.f1560e.e();
            this.f1559d.h().c(this.f1558c);
            PowerManager.WakeLock wakeLock = this.f1563h;
            if (wakeLock != null && wakeLock.isHeld()) {
                j.c().a(f1555j, String.format("Releasing wakelock %s for WorkSpec %s", this.f1563h, this.f1558c), new Throwable[0]);
                this.f1563h.release();
            }
        }
    }

    private void g() {
        synchronized (this.f1561f) {
            if (this.f1562g < 2) {
                this.f1562g = 2;
                j c6 = j.c();
                String str = f1555j;
                c6.a(str, String.format("Stopping work for WorkSpec %s", this.f1558c), new Throwable[0]);
                Intent g6 = b.g(this.f1556a, this.f1558c);
                e eVar = this.f1559d;
                eVar.k(new e.b(eVar, g6, this.f1557b));
                if (this.f1559d.e().g(this.f1558c)) {
                    j.c().a(str, String.format("WorkSpec %s needs to be rescheduled", this.f1558c), new Throwable[0]);
                    Intent f6 = b.f(this.f1556a, this.f1558c);
                    e eVar2 = this.f1559d;
                    eVar2.k(new e.b(eVar2, f6, this.f1557b));
                } else {
                    j.c().a(str, String.format("Processor does not have WorkSpec %s. No need to reschedule ", this.f1558c), new Throwable[0]);
                }
            } else {
                j.c().a(f1555j, String.format("Already stopped work for %s", this.f1558c), new Throwable[0]);
            }
        }
    }

    @Override // w.b
    public void a(String str, boolean z5) {
        j.c().a(f1555j, String.format("onExecuted %s, %s", str, Boolean.valueOf(z5)), new Throwable[0]);
        d();
        if (z5) {
            Intent f6 = b.f(this.f1556a, this.f1558c);
            e eVar = this.f1559d;
            eVar.k(new e.b(eVar, f6, this.f1557b));
        }
        if (this.f1564i) {
            Intent b6 = b.b(this.f1556a);
            e eVar2 = this.f1559d;
            eVar2.k(new e.b(eVar2, b6, this.f1557b));
        }
    }

    @Override // e0.r.b
    public void b(String str) {
        j.c().a(f1555j, String.format("Exceeded time limits on execution for %s", str), new Throwable[0]);
        g();
    }

    @Override // z.c
    public void c(List<String> list) {
        g();
    }

    @Override // z.c
    public void e(List<String> list) {
        if (list.contains(this.f1558c)) {
            synchronized (this.f1561f) {
                if (this.f1562g == 0) {
                    this.f1562g = 1;
                    j.c().a(f1555j, String.format("onAllConstraintsMet for %s", this.f1558c), new Throwable[0]);
                    if (this.f1559d.e().j(this.f1558c)) {
                        this.f1559d.h().b(this.f1558c, 600000L, this);
                    } else {
                        d();
                    }
                } else {
                    j.c().a(f1555j, String.format("Already started work for %s", this.f1558c), new Throwable[0]);
                }
            }
        }
    }

    void f() {
        this.f1563h = n.b(this.f1556a, String.format("%s (%s)", this.f1558c, Integer.valueOf(this.f1557b)));
        j c6 = j.c();
        String str = f1555j;
        c6.a(str, String.format("Acquiring wakelock %s for WorkSpec %s", this.f1563h, this.f1558c), new Throwable[0]);
        this.f1563h.acquire();
        p l6 = this.f1559d.g().p().D().l(this.f1558c);
        if (l6 == null) {
            g();
            return;
        }
        boolean b6 = l6.b();
        this.f1564i = b6;
        if (b6) {
            this.f1560e.d(Collections.singletonList(l6));
        } else {
            j.c().a(str, String.format("No constraints for %s", this.f1558c), new Throwable[0]);
            e(Collections.singletonList(this.f1558c));
        }
    }
}
