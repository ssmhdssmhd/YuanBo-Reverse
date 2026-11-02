package w;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import androidx.lifecycle.LiveData;
import androidx.work.WorkerParameters;
import androidx.work.a;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.utils.ForceStopRunnable;
import d0.p;
import e0.l;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import v.j;
import v.m;
import v.s;
import v.t;
import v.u;

/* loaded from: classes.dex */
public class j extends t {

    /* renamed from: j, reason: collision with root package name */
    private static final String f9936j = v.j.f("WorkManagerImpl");

    /* renamed from: k, reason: collision with root package name */
    private static j f9937k = null;

    /* renamed from: l, reason: collision with root package name */
    private static j f9938l = null;

    /* renamed from: m, reason: collision with root package name */
    private static final Object f9939m = new Object();

    /* renamed from: a, reason: collision with root package name */
    private Context f9940a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.work.a f9941b;

    /* renamed from: c, reason: collision with root package name */
    private WorkDatabase f9942c;

    /* renamed from: d, reason: collision with root package name */
    private f0.a f9943d;

    /* renamed from: e, reason: collision with root package name */
    private List<e> f9944e;

    /* renamed from: f, reason: collision with root package name */
    private d f9945f;

    /* renamed from: g, reason: collision with root package name */
    private e0.h f9946g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9947h;

    /* renamed from: i, reason: collision with root package name */
    private BroadcastReceiver.PendingResult f9948i;

    class a implements e.a<List<p.c>, s> {
        a() {
        }

        @Override // e.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s apply(List<p.c> list) {
            if (list == null || list.size() <= 0) {
                return null;
            }
            return list.get(0).a();
        }
    }

    public j(Context context, androidx.work.a aVar, f0.a aVar2) {
        this(context, aVar, aVar2, context.getResources().getBoolean(v.p.f9727a));
    }

    public j(Context context, androidx.work.a aVar, f0.a aVar2, WorkDatabase workDatabase) {
        Context applicationContext = context.getApplicationContext();
        v.j.e(new j.a(aVar.j()));
        List<e> h6 = h(applicationContext, aVar, aVar2);
        r(context, aVar, aVar2, workDatabase, h6, new d(context, aVar, aVar2, workDatabase, h6));
    }

    public j(Context context, androidx.work.a aVar, f0.a aVar2, boolean z5) {
        this(context, aVar, aVar2, WorkDatabase.u(context.getApplicationContext(), aVar2.c(), z5));
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
    
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001c, code lost:
    
        if (w.j.f9938l != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        w.j.f9938l = new w.j(r4, r5, new f0.b(r5.l()));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        w.j.f9937k = w.j.f9938l;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void f(android.content.Context r4, androidx.work.a r5) {
        /*
            java.lang.Object r0 = w.j.f9939m
            monitor-enter(r0)
            w.j r1 = w.j.f9937k     // Catch: java.lang.Throwable -> L34
            if (r1 == 0) goto L14
            w.j r2 = w.j.f9938l     // Catch: java.lang.Throwable -> L34
            if (r2 != 0) goto Lc
            goto L14
        Lc:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L34
            java.lang.String r5 = "WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information."
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L34
            throw r4     // Catch: java.lang.Throwable -> L34
        L14:
            if (r1 != 0) goto L32
            android.content.Context r4 = r4.getApplicationContext()     // Catch: java.lang.Throwable -> L34
            w.j r1 = w.j.f9938l     // Catch: java.lang.Throwable -> L34
            if (r1 != 0) goto L2e
            w.j r1 = new w.j     // Catch: java.lang.Throwable -> L34
            f0.b r2 = new f0.b     // Catch: java.lang.Throwable -> L34
            java.util.concurrent.Executor r3 = r5.l()     // Catch: java.lang.Throwable -> L34
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L34
            r1.<init>(r4, r5, r2)     // Catch: java.lang.Throwable -> L34
            w.j.f9938l = r1     // Catch: java.lang.Throwable -> L34
        L2e:
            w.j r4 = w.j.f9938l     // Catch: java.lang.Throwable -> L34
            w.j.f9937k = r4     // Catch: java.lang.Throwable -> L34
        L32:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            return
        L34:
            r4 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w.j.f(android.content.Context, androidx.work.a):void");
    }

    @Deprecated
    public static j k() {
        synchronized (f9939m) {
            j jVar = f9937k;
            if (jVar != null) {
                return jVar;
            }
            return f9938l;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static j l(Context context) {
        j k6;
        synchronized (f9939m) {
            k6 = k();
            if (k6 == null) {
                Context applicationContext = context.getApplicationContext();
                if (!(applicationContext instanceof a.c)) {
                    throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
                }
                f(applicationContext, ((a.c) applicationContext).a());
                k6 = l(applicationContext);
            }
        }
        return k6;
    }

    private void r(Context context, androidx.work.a aVar, f0.a aVar2, WorkDatabase workDatabase, List<e> list, d dVar) {
        boolean isDeviceProtectedStorage;
        Context applicationContext = context.getApplicationContext();
        this.f9940a = applicationContext;
        this.f9941b = aVar;
        this.f9943d = aVar2;
        this.f9942c = workDatabase;
        this.f9944e = list;
        this.f9945f = dVar;
        this.f9946g = new e0.h(workDatabase);
        this.f9947h = false;
        if (Build.VERSION.SDK_INT >= 24) {
            isDeviceProtectedStorage = applicationContext.isDeviceProtectedStorage();
            if (isDeviceProtectedStorage) {
                throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
            }
        }
        this.f9943d.b(new ForceStopRunnable(applicationContext, this));
    }

    @Override // v.t
    public m a(String str) {
        e0.a d6 = e0.a.d(str, this);
        this.f9943d.b(d6);
        return d6.e();
    }

    @Override // v.t
    public m b(List<? extends u> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
        }
        return new g(this, list).a();
    }

    @Override // v.t
    public LiveData<s> e(UUID uuid) {
        return e0.f.a(this.f9942c.D().n(Collections.singletonList(uuid.toString())), new a(), this.f9943d);
    }

    public m g(UUID uuid) {
        e0.a b6 = e0.a.b(uuid, this);
        this.f9943d.b(b6);
        return b6.e();
    }

    public List<e> h(Context context, androidx.work.a aVar, f0.a aVar2) {
        return Arrays.asList(f.a(context, this), new x.b(context, aVar, aVar2, this));
    }

    public Context i() {
        return this.f9940a;
    }

    public androidx.work.a j() {
        return this.f9941b;
    }

    public e0.h m() {
        return this.f9946g;
    }

    public d n() {
        return this.f9945f;
    }

    public List<e> o() {
        return this.f9944e;
    }

    public WorkDatabase p() {
        return this.f9942c;
    }

    public f0.a q() {
        return this.f9943d;
    }

    public void s() {
        synchronized (f9939m) {
            this.f9947h = true;
            BroadcastReceiver.PendingResult pendingResult = this.f9948i;
            if (pendingResult != null) {
                pendingResult.finish();
                this.f9948i = null;
            }
        }
    }

    public void t() {
        if (Build.VERSION.SDK_INT >= 23) {
            y.k.a(i());
        }
        p().D().v();
        f.b(j(), p(), o());
    }

    public void u(BroadcastReceiver.PendingResult pendingResult) {
        synchronized (f9939m) {
            this.f9948i = pendingResult;
            if (this.f9947h) {
                pendingResult.finish();
                this.f9948i = null;
            }
        }
    }

    public void v(String str) {
        w(str, null);
    }

    public void w(String str, WorkerParameters.a aVar) {
        this.f9943d.b(new l(this, str, aVar));
    }

    public void x(String str) {
        this.f9943d.b(new e0.m(this, str, true));
    }

    public void y(String str) {
        this.f9943d.b(new e0.m(this, str, false));
    }
}
