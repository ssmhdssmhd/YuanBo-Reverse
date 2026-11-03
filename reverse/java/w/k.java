package w;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import d0.p;
import d0.q;
import d0.t;
import e0.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import v.s;

/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: x, reason: collision with root package name */
    static final String f9950x = v.j.f("WorkerWrapper");

    /* renamed from: a, reason: collision with root package name */
    Context f9951a;

    /* renamed from: b, reason: collision with root package name */
    private String f9952b;

    /* renamed from: c, reason: collision with root package name */
    private List<e> f9953c;

    /* renamed from: d, reason: collision with root package name */
    private WorkerParameters.a f9954d;

    /* renamed from: e, reason: collision with root package name */
    p f9955e;

    /* renamed from: j, reason: collision with root package name */
    ListenableWorker f9956j;

    /* renamed from: k, reason: collision with root package name */
    f0.a f9957k;

    /* renamed from: m, reason: collision with root package name */
    private androidx.work.a f9959m;

    /* renamed from: n, reason: collision with root package name */
    private c0.a f9960n;

    /* renamed from: o, reason: collision with root package name */
    private WorkDatabase f9961o;

    /* renamed from: p, reason: collision with root package name */
    private q f9962p;

    /* renamed from: q, reason: collision with root package name */
    private d0.b f9963q;

    /* renamed from: r, reason: collision with root package name */
    private t f9964r;

    /* renamed from: s, reason: collision with root package name */
    private List<String> f9965s;

    /* renamed from: t, reason: collision with root package name */
    private String f9966t;

    /* renamed from: w, reason: collision with root package name */
    private volatile boolean f9969w;

    /* renamed from: l, reason: collision with root package name */
    ListenableWorker.a f9958l = ListenableWorker.a.a();

    /* renamed from: u, reason: collision with root package name */
    androidx.work.impl.utils.futures.d<Boolean> f9967u = androidx.work.impl.utils.futures.d.t();

    /* renamed from: v, reason: collision with root package name */
    p2.a<ListenableWorker.a> f9968v = null;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ p2.a f9970a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.d f9971b;

        a(p2.a aVar, androidx.work.impl.utils.futures.d dVar) {
            this.f9970a = aVar;
            this.f9971b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f9970a.get();
                v.j.c().a(k.f9950x, String.format("Starting work for %s", k.this.f9955e.f2860c), new Throwable[0]);
                k kVar = k.this;
                kVar.f9968v = kVar.f9956j.o();
                this.f9971b.r(k.this.f9968v);
            } catch (Throwable th) {
                this.f9971b.q(th);
            }
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ androidx.work.impl.utils.futures.d f9973a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9974b;

        b(androidx.work.impl.utils.futures.d dVar, String str) {
            this.f9973a = dVar;
            this.f9974b = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.f9973a.get();
                    if (aVar == null) {
                        v.j.c().b(k.f9950x, String.format("%s returned a null result. Treating it as a failure.", k.this.f9955e.f2860c), new Throwable[0]);
                    } else {
                        v.j.c().a(k.f9950x, String.format("%s returned a %s result.", k.this.f9955e.f2860c, aVar), new Throwable[0]);
                        k.this.f9958l = aVar;
                    }
                } catch (InterruptedException e6) {
                    e = e6;
                    v.j.c().b(k.f9950x, String.format("%s failed because it threw an exception/error", this.f9974b), e);
                } catch (CancellationException e7) {
                    v.j.c().d(k.f9950x, String.format("%s was cancelled", this.f9974b), e7);
                } catch (ExecutionException e8) {
                    e = e8;
                    v.j.c().b(k.f9950x, String.format("%s failed because it threw an exception/error", this.f9974b), e);
                }
            } finally {
                k.this.f();
            }
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        Context f9976a;

        /* renamed from: b, reason: collision with root package name */
        ListenableWorker f9977b;

        /* renamed from: c, reason: collision with root package name */
        c0.a f9978c;

        /* renamed from: d, reason: collision with root package name */
        f0.a f9979d;

        /* renamed from: e, reason: collision with root package name */
        androidx.work.a f9980e;

        /* renamed from: f, reason: collision with root package name */
        WorkDatabase f9981f;

        /* renamed from: g, reason: collision with root package name */
        String f9982g;

        /* renamed from: h, reason: collision with root package name */
        List<e> f9983h;

        /* renamed from: i, reason: collision with root package name */
        WorkerParameters.a f9984i = new WorkerParameters.a();

        public c(Context context, androidx.work.a aVar, f0.a aVar2, c0.a aVar3, WorkDatabase workDatabase, String str) {
            this.f9976a = context.getApplicationContext();
            this.f9979d = aVar2;
            this.f9978c = aVar3;
            this.f9980e = aVar;
            this.f9981f = workDatabase;
            this.f9982g = str;
        }

        public k a() {
            return new k(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.f9984i = aVar;
            }
            return this;
        }

        public c c(List<e> list) {
            this.f9983h = list;
            return this;
        }
    }

    k(c cVar) {
        this.f9951a = cVar.f9976a;
        this.f9957k = cVar.f9979d;
        this.f9960n = cVar.f9978c;
        this.f9952b = cVar.f9982g;
        this.f9953c = cVar.f9983h;
        this.f9954d = cVar.f9984i;
        this.f9956j = cVar.f9977b;
        this.f9959m = cVar.f9980e;
        WorkDatabase workDatabase = cVar.f9981f;
        this.f9961o = workDatabase;
        this.f9962p = workDatabase.D();
        this.f9963q = this.f9961o.v();
        this.f9964r = this.f9961o.E();
    }

    private String a(List<String> list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.f9952b);
        sb.append(", tags={ ");
        boolean z5 = true;
        for (String str : list) {
            if (z5) {
                z5 = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    private void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            v.j.c().d(f9950x, String.format("Worker result SUCCESS for %s", this.f9966t), new Throwable[0]);
            if (!this.f9955e.d()) {
                m();
                return;
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            v.j.c().d(f9950x, String.format("Worker result RETRY for %s", this.f9966t), new Throwable[0]);
            g();
            return;
        } else {
            v.j.c().d(f9950x, String.format("Worker result FAILURE for %s", this.f9966t), new Throwable[0]);
            if (!this.f9955e.d()) {
                l();
                return;
            }
        }
        h();
    }

    private void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.f9962p.j(str2) != s.a.CANCELLED) {
                this.f9962p.c(s.a.FAILED, str2);
            }
            linkedList.addAll(this.f9963q.d(str2));
        }
    }

    private void g() {
        this.f9961o.c();
        try {
            this.f9962p.c(s.a.ENQUEUED, this.f9952b);
            this.f9962p.r(this.f9952b, System.currentTimeMillis());
            this.f9962p.e(this.f9952b, -1L);
            this.f9961o.t();
        } finally {
            this.f9961o.g();
            i(true);
        }
    }

    private void h() {
        this.f9961o.c();
        try {
            this.f9962p.r(this.f9952b, System.currentTimeMillis());
            this.f9962p.c(s.a.ENQUEUED, this.f9952b);
            this.f9962p.m(this.f9952b);
            this.f9962p.e(this.f9952b, -1L);
            this.f9961o.t();
        } finally {
            this.f9961o.g();
            i(false);
        }
    }

    private void i(boolean z5) {
        ListenableWorker listenableWorker;
        this.f9961o.c();
        try {
            if (!this.f9961o.D().d()) {
                e0.g.a(this.f9951a, RescheduleReceiver.class, false);
            }
            if (z5) {
                this.f9962p.c(s.a.ENQUEUED, this.f9952b);
                this.f9962p.e(this.f9952b, -1L);
            }
            if (this.f9955e != null && (listenableWorker = this.f9956j) != null && listenableWorker.i()) {
                this.f9960n.b(this.f9952b);
            }
            this.f9961o.t();
            this.f9961o.g();
            this.f9967u.p(Boolean.valueOf(z5));
        } catch (Throwable th) {
            this.f9961o.g();
            throw th;
        }
    }

    private void j() {
        s.a j6 = this.f9962p.j(this.f9952b);
        if (j6 == s.a.RUNNING) {
            v.j.c().a(f9950x, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", this.f9952b), new Throwable[0]);
            i(true);
        } else {
            v.j.c().a(f9950x, String.format("Status for %s is %s; not doing any work", this.f9952b, j6), new Throwable[0]);
            i(false);
        }
    }

    private void k() {
        androidx.work.b b6;
        if (n()) {
            return;
        }
        this.f9961o.c();
        try {
            p l6 = this.f9962p.l(this.f9952b);
            this.f9955e = l6;
            if (l6 == null) {
                v.j.c().b(f9950x, String.format("Didn't find WorkSpec for id %s", this.f9952b), new Throwable[0]);
                i(false);
                this.f9961o.t();
                return;
            }
            if (l6.f2859b != s.a.ENQUEUED) {
                j();
                this.f9961o.t();
                v.j.c().a(f9950x, String.format("%s is not in ENQUEUED state. Nothing more to do.", this.f9955e.f2860c), new Throwable[0]);
                return;
            }
            if (l6.d() || this.f9955e.c()) {
                long currentTimeMillis = System.currentTimeMillis();
                p pVar = this.f9955e;
                if (!(pVar.f2871n == 0) && currentTimeMillis < pVar.a()) {
                    v.j.c().a(f9950x, String.format("Delaying execution for %s because it is being executed before schedule.", this.f9955e.f2860c), new Throwable[0]);
                    i(true);
                    this.f9961o.t();
                    return;
                }
            }
            this.f9961o.t();
            this.f9961o.g();
            if (this.f9955e.d()) {
                b6 = this.f9955e.f2862e;
            } else {
                v.h b7 = this.f9959m.f().b(this.f9955e.f2861d);
                if (b7 == null) {
                    v.j.c().b(f9950x, String.format("Could not create Input Merger %s", this.f9955e.f2861d), new Throwable[0]);
                    l();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f9955e.f2862e);
                    arrayList.addAll(this.f9962p.p(this.f9952b));
                    b6 = b7.b(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.f9952b), b6, this.f9965s, this.f9954d, this.f9955e.f2868k, this.f9959m.e(), this.f9957k, this.f9959m.m(), new e0.q(this.f9961o, this.f9957k), new e0.p(this.f9961o, this.f9960n, this.f9957k));
            if (this.f9956j == null) {
                this.f9956j = this.f9959m.m().b(this.f9951a, this.f9955e.f2860c, workerParameters);
            }
            ListenableWorker listenableWorker = this.f9956j;
            if (listenableWorker == null) {
                v.j.c().b(f9950x, String.format("Could not create Worker %s", this.f9955e.f2860c), new Throwable[0]);
                l();
                return;
            }
            if (listenableWorker.k()) {
                v.j.c().b(f9950x, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", this.f9955e.f2860c), new Throwable[0]);
                l();
                return;
            }
            this.f9956j.n();
            if (!o()) {
                j();
                return;
            }
            if (n()) {
                return;
            }
            androidx.work.impl.utils.futures.d t5 = androidx.work.impl.utils.futures.d.t();
            o oVar = new o(this.f9951a, this.f9955e, this.f9956j, workerParameters.b(), this.f9957k);
            this.f9957k.a().execute(oVar);
            p2.a<Void> a6 = oVar.a();
            a6.a(new a(a6, t5), this.f9957k.a());
            t5.a(new b(t5, this.f9966t), this.f9957k.c());
        } finally {
            this.f9961o.g();
        }
    }

    private void m() {
        this.f9961o.c();
        try {
            this.f9962p.c(s.a.SUCCEEDED, this.f9952b);
            this.f9962p.u(this.f9952b, ((ListenableWorker.a.c) this.f9958l).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.f9963q.d(this.f9952b)) {
                if (this.f9962p.j(str) == s.a.BLOCKED && this.f9963q.b(str)) {
                    v.j.c().d(f9950x, String.format("Setting status to enqueued for %s", str), new Throwable[0]);
                    this.f9962p.c(s.a.ENQUEUED, str);
                    this.f9962p.r(str, currentTimeMillis);
                }
            }
            this.f9961o.t();
        } finally {
            this.f9961o.g();
            i(false);
        }
    }

    private boolean n() {
        if (!this.f9969w) {
            return false;
        }
        v.j.c().a(f9950x, String.format("Work interrupted for %s", this.f9966t), new Throwable[0]);
        if (this.f9962p.j(this.f9952b) == null) {
            i(false);
        } else {
            i(!r0.a());
        }
        return true;
    }

    private boolean o() {
        this.f9961o.c();
        try {
            boolean z5 = false;
            if (this.f9962p.j(this.f9952b) == s.a.ENQUEUED) {
                this.f9962p.c(s.a.RUNNING, this.f9952b);
                this.f9962p.q(this.f9952b);
                z5 = true;
            }
            this.f9961o.t();
            return z5;
        } finally {
            this.f9961o.g();
        }
    }

    public p2.a<Boolean> b() {
        return this.f9967u;
    }

    public void d() {
        boolean z5;
        this.f9969w = true;
        n();
        p2.a<ListenableWorker.a> aVar = this.f9968v;
        if (aVar != null) {
            z5 = aVar.isDone();
            this.f9968v.cancel(true);
        } else {
            z5 = false;
        }
        ListenableWorker listenableWorker = this.f9956j;
        if (listenableWorker == null || z5) {
            v.j.c().a(f9950x, String.format("WorkSpec %s is already done. Not interrupting.", this.f9955e), new Throwable[0]);
        } else {
            listenableWorker.p();
        }
    }

    void f() {
        if (!n()) {
            this.f9961o.c();
            try {
                s.a j6 = this.f9962p.j(this.f9952b);
                this.f9961o.C().a(this.f9952b);
                if (j6 == null) {
                    i(false);
                } else if (j6 == s.a.RUNNING) {
                    c(this.f9958l);
                } else if (!j6.a()) {
                    g();
                }
                this.f9961o.t();
            } finally {
                this.f9961o.g();
            }
        }
        List<e> list = this.f9953c;
        if (list != null) {
            Iterator<e> it = list.iterator();
            while (it.hasNext()) {
                it.next().b(this.f9952b);
            }
            f.b(this.f9959m, this.f9961o, this.f9953c);
        }
    }

    void l() {
        this.f9961o.c();
        try {
            e(this.f9952b);
            this.f9962p.u(this.f9952b, ((ListenableWorker.a.C0028a) this.f9958l).e());
            this.f9961o.t();
        } finally {
            this.f9961o.g();
            i(false);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        List<String> b6 = this.f9964r.b(this.f9952b);
        this.f9965s = b6;
        this.f9966t = a(b6);
        k();
    }
}
