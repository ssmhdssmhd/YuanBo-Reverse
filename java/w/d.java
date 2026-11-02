package w;

import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import e0.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import w.k;

/* loaded from: classes.dex */
public class d implements b, c0.a {

    /* renamed from: l, reason: collision with root package name */
    private static final String f9908l = v.j.f("Processor");

    /* renamed from: b, reason: collision with root package name */
    private Context f9910b;

    /* renamed from: c, reason: collision with root package name */
    private androidx.work.a f9911c;

    /* renamed from: d, reason: collision with root package name */
    private f0.a f9912d;

    /* renamed from: e, reason: collision with root package name */
    private WorkDatabase f9913e;

    /* renamed from: h, reason: collision with root package name */
    private List<e> f9916h;

    /* renamed from: g, reason: collision with root package name */
    private Map<String, k> f9915g = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private Map<String, k> f9914f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private Set<String> f9917i = new HashSet();

    /* renamed from: j, reason: collision with root package name */
    private final List<b> f9918j = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private PowerManager.WakeLock f9909a = null;

    /* renamed from: k, reason: collision with root package name */
    private final Object f9919k = new Object();

    private static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private b f9920a;

        /* renamed from: b, reason: collision with root package name */
        private String f9921b;

        /* renamed from: c, reason: collision with root package name */
        private p2.a<Boolean> f9922c;

        a(b bVar, String str, p2.a<Boolean> aVar) {
            this.f9920a = bVar;
            this.f9921b = str;
            this.f9922c = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z5;
            try {
                z5 = this.f9922c.get().booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z5 = true;
            }
            this.f9920a.a(this.f9921b, z5);
        }
    }

    public d(Context context, androidx.work.a aVar, f0.a aVar2, WorkDatabase workDatabase, List<e> list) {
        this.f9910b = context;
        this.f9911c = aVar;
        this.f9912d = aVar2;
        this.f9913e = workDatabase;
        this.f9916h = list;
    }

    private static boolean e(String str, k kVar) {
        if (kVar == null) {
            v.j.c().a(f9908l, String.format("WorkerWrapper could not be found for %s", str), new Throwable[0]);
            return false;
        }
        kVar.d();
        v.j.c().a(f9908l, String.format("WorkerWrapper interrupted for %s", str), new Throwable[0]);
        return true;
    }

    private void m() {
        synchronized (this.f9919k) {
            if (!(!this.f9914f.isEmpty())) {
                try {
                    this.f9910b.startService(androidx.work.impl.foreground.a.f(this.f9910b));
                } catch (Throwable th) {
                    v.j.c().b(f9908l, "Unable to stop foreground service", th);
                }
                PowerManager.WakeLock wakeLock = this.f9909a;
                if (wakeLock != null) {
                    wakeLock.release();
                    this.f9909a = null;
                }
            }
        }
    }

    @Override // w.b
    public void a(String str, boolean z5) {
        synchronized (this.f9919k) {
            this.f9915g.remove(str);
            v.j.c().a(f9908l, String.format("%s %s executed; reschedule = %s", getClass().getSimpleName(), str, Boolean.valueOf(z5)), new Throwable[0]);
            Iterator<b> it = this.f9918j.iterator();
            while (it.hasNext()) {
                it.next().a(str, z5);
            }
        }
    }

    @Override // c0.a
    public void b(String str) {
        synchronized (this.f9919k) {
            this.f9914f.remove(str);
            m();
        }
    }

    @Override // c0.a
    public void c(String str, v.e eVar) {
        synchronized (this.f9919k) {
            v.j.c().d(f9908l, String.format("Moving WorkSpec (%s) to the foreground", str), new Throwable[0]);
            k remove = this.f9915g.remove(str);
            if (remove != null) {
                if (this.f9909a == null) {
                    PowerManager.WakeLock b6 = n.b(this.f9910b, "ProcessorForegroundLck");
                    this.f9909a = b6;
                    b6.acquire();
                }
                this.f9914f.put(str, remove);
                androidx.core.content.a.f(this.f9910b, androidx.work.impl.foreground.a.d(this.f9910b, str, eVar));
            }
        }
    }

    public void d(b bVar) {
        synchronized (this.f9919k) {
            this.f9918j.add(bVar);
        }
    }

    public boolean f(String str) {
        boolean contains;
        synchronized (this.f9919k) {
            contains = this.f9917i.contains(str);
        }
        return contains;
    }

    public boolean g(String str) {
        boolean z5;
        synchronized (this.f9919k) {
            z5 = this.f9915g.containsKey(str) || this.f9914f.containsKey(str);
        }
        return z5;
    }

    public boolean h(String str) {
        boolean containsKey;
        synchronized (this.f9919k) {
            containsKey = this.f9914f.containsKey(str);
        }
        return containsKey;
    }

    public void i(b bVar) {
        synchronized (this.f9919k) {
            this.f9918j.remove(bVar);
        }
    }

    public boolean j(String str) {
        return k(str, null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.f9919k) {
            if (g(str)) {
                v.j.c().a(f9908l, String.format("Work %s is already enqueued for processing", str), new Throwable[0]);
                return false;
            }
            k a6 = new k.c(this.f9910b, this.f9911c, this.f9912d, this, this.f9913e, str).c(this.f9916h).b(aVar).a();
            p2.a<Boolean> b6 = a6.b();
            b6.a(new a(this, str, b6), this.f9912d.a());
            this.f9915g.put(str, a6);
            this.f9912d.c().execute(a6);
            v.j.c().a(f9908l, String.format("%s: processing %s", getClass().getSimpleName(), str), new Throwable[0]);
            return true;
        }
    }

    public boolean l(String str) {
        boolean e6;
        synchronized (this.f9919k) {
            boolean z5 = true;
            v.j.c().a(f9908l, String.format("Processor cancelling %s", str), new Throwable[0]);
            this.f9917i.add(str);
            k remove = this.f9914f.remove(str);
            if (remove == null) {
                z5 = false;
            }
            if (remove == null) {
                remove = this.f9915g.remove(str);
            }
            e6 = e(str, remove);
            if (z5) {
                m();
            }
        }
        return e6;
    }

    public boolean n(String str) {
        boolean e6;
        synchronized (this.f9919k) {
            v.j.c().a(f9908l, String.format("Processor stopping foreground work %s", str), new Throwable[0]);
            e6 = e(str, this.f9914f.remove(str));
        }
        return e6;
    }

    public boolean o(String str) {
        boolean e6;
        synchronized (this.f9919k) {
            v.j.c().a(f9908l, String.format("Processor stopping background work %s", str), new Throwable[0]);
            e6 = e(str, this.f9915g.remove(str));
        }
        return e6;
    }
}
