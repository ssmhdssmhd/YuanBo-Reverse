package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import e0.k;
import e0.n;
import e0.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import v.j;

/* loaded from: classes.dex */
public class e implements w.b {

    /* renamed from: k, reason: collision with root package name */
    static final String f1565k = j.f("SystemAlarmDispatcher");

    /* renamed from: a, reason: collision with root package name */
    final Context f1566a;

    /* renamed from: b, reason: collision with root package name */
    private final f0.a f1567b;

    /* renamed from: c, reason: collision with root package name */
    private final r f1568c;

    /* renamed from: d, reason: collision with root package name */
    private final w.d f1569d;

    /* renamed from: e, reason: collision with root package name */
    private final w.j f1570e;

    /* renamed from: f, reason: collision with root package name */
    final androidx.work.impl.background.systemalarm.b f1571f;

    /* renamed from: g, reason: collision with root package name */
    private final Handler f1572g;

    /* renamed from: h, reason: collision with root package name */
    final List<Intent> f1573h;

    /* renamed from: i, reason: collision with root package name */
    Intent f1574i;

    /* renamed from: j, reason: collision with root package name */
    private c f1575j;

    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            d dVar;
            synchronized (e.this.f1573h) {
                e eVar2 = e.this;
                eVar2.f1574i = eVar2.f1573h.get(0);
            }
            Intent intent = e.this.f1574i;
            if (intent != null) {
                String action = intent.getAction();
                int intExtra = e.this.f1574i.getIntExtra("KEY_START_ID", 0);
                j c6 = j.c();
                String str = e.f1565k;
                c6.a(str, String.format("Processing command %s, %s", e.this.f1574i, Integer.valueOf(intExtra)), new Throwable[0]);
                PowerManager.WakeLock b6 = n.b(e.this.f1566a, String.format("%s (%s)", action, Integer.valueOf(intExtra)));
                try {
                    j.c().a(str, String.format("Acquiring operation wake lock (%s) %s", action, b6), new Throwable[0]);
                    b6.acquire();
                    e eVar3 = e.this;
                    eVar3.f1571f.p(eVar3.f1574i, intExtra, eVar3);
                    j.c().a(str, String.format("Releasing operation wake lock (%s) %s", action, b6), new Throwable[0]);
                    b6.release();
                    eVar = e.this;
                    dVar = new d(eVar);
                } catch (Throwable th) {
                    try {
                        j c7 = j.c();
                        String str2 = e.f1565k;
                        c7.b(str2, "Unexpected error in onHandleIntent", th);
                        j.c().a(str2, String.format("Releasing operation wake lock (%s) %s", action, b6), new Throwable[0]);
                        b6.release();
                        eVar = e.this;
                        dVar = new d(eVar);
                    } catch (Throwable th2) {
                        j.c().a(e.f1565k, String.format("Releasing operation wake lock (%s) %s", action, b6), new Throwable[0]);
                        b6.release();
                        e eVar4 = e.this;
                        eVar4.k(new d(eVar4));
                        throw th2;
                    }
                }
                eVar.k(dVar);
            }
        }
    }

    static class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final e f1577a;

        /* renamed from: b, reason: collision with root package name */
        private final Intent f1578b;

        /* renamed from: c, reason: collision with root package name */
        private final int f1579c;

        b(e eVar, Intent intent, int i6) {
            this.f1577a = eVar;
            this.f1578b = intent;
            this.f1579c = i6;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1577a.b(this.f1578b, this.f1579c);
        }
    }

    interface c {
        void c();
    }

    static class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private final e f1580a;

        d(e eVar) {
            this.f1580a = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f1580a.d();
        }
    }

    e(Context context) {
        this(context, null, null);
    }

    e(Context context, w.d dVar, w.j jVar) {
        Context applicationContext = context.getApplicationContext();
        this.f1566a = applicationContext;
        this.f1571f = new androidx.work.impl.background.systemalarm.b(applicationContext);
        this.f1568c = new r();
        jVar = jVar == null ? w.j.l(context) : jVar;
        this.f1570e = jVar;
        dVar = dVar == null ? jVar.n() : dVar;
        this.f1569d = dVar;
        this.f1567b = jVar.q();
        dVar.d(this);
        this.f1573h = new ArrayList();
        this.f1574i = null;
        this.f1572g = new Handler(Looper.getMainLooper());
    }

    private void c() {
        if (this.f1572g.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    private boolean i(String str) {
        c();
        synchronized (this.f1573h) {
            Iterator<Intent> it = this.f1573h.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void l() {
        c();
        PowerManager.WakeLock b6 = n.b(this.f1566a, "ProcessCommand");
        try {
            b6.acquire();
            this.f1570e.q().b(new a());
        } finally {
            b6.release();
        }
    }

    @Override // w.b
    public void a(String str, boolean z5) {
        k(new b(this, androidx.work.impl.background.systemalarm.b.d(this.f1566a, str, z5), 0));
    }

    public boolean b(Intent intent, int i6) {
        j c6 = j.c();
        String str = f1565k;
        c6.a(str, String.format("Adding command %s (%s)", intent, Integer.valueOf(i6)), new Throwable[0]);
        c();
        String action = intent.getAction();
        if (TextUtils.isEmpty(action)) {
            j.c().h(str, "Unknown command. Ignoring", new Throwable[0]);
            return false;
        }
        if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && i("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        }
        intent.putExtra("KEY_START_ID", i6);
        synchronized (this.f1573h) {
            boolean z5 = this.f1573h.isEmpty() ? false : true;
            this.f1573h.add(intent);
            if (!z5) {
                l();
            }
        }
        return true;
    }

    void d() {
        j c6 = j.c();
        String str = f1565k;
        c6.a(str, "Checking if commands are complete.", new Throwable[0]);
        c();
        synchronized (this.f1573h) {
            if (this.f1574i != null) {
                j.c().a(str, String.format("Removing command %s", this.f1574i), new Throwable[0]);
                if (!this.f1573h.remove(0).equals(this.f1574i)) {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
                this.f1574i = null;
            }
            k c7 = this.f1567b.c();
            if (!this.f1571f.o() && this.f1573h.isEmpty() && !c7.a()) {
                j.c().a(str, "No more commands & intents.", new Throwable[0]);
                c cVar = this.f1575j;
                if (cVar != null) {
                    cVar.c();
                }
            } else if (!this.f1573h.isEmpty()) {
                l();
            }
        }
    }

    w.d e() {
        return this.f1569d;
    }

    f0.a f() {
        return this.f1567b;
    }

    w.j g() {
        return this.f1570e;
    }

    r h() {
        return this.f1568c;
    }

    void j() {
        j.c().a(f1565k, "Destroying SystemAlarmDispatcher", new Throwable[0]);
        this.f1569d.i(this);
        this.f1568c.a();
        this.f1575j = null;
    }

    void k(Runnable runnable) {
        this.f1572g.post(runnable);
    }

    void m(c cVar) {
        if (this.f1575j != null) {
            j.c().b(f1565k, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
        } else {
            this.f1575j = cVar;
        }
    }
}
