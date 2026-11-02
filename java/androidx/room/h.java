package androidx.room;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.os.CancellationSignal;
import android.os.Looper;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import q.c;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    protected volatile q.b f1360a;

    /* renamed from: b, reason: collision with root package name */
    private Executor f1361b;

    /* renamed from: c, reason: collision with root package name */
    private Executor f1362c;

    /* renamed from: d, reason: collision with root package name */
    private q.c f1363d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1365f;

    /* renamed from: g, reason: collision with root package name */
    boolean f1366g;

    /* renamed from: h, reason: collision with root package name */
    @Deprecated
    protected List<b> f1367h;

    /* renamed from: i, reason: collision with root package name */
    private final ReentrantReadWriteLock f1368i = new ReentrantReadWriteLock();

    /* renamed from: j, reason: collision with root package name */
    private final ThreadLocal<Integer> f1369j = new ThreadLocal<>();

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, Object> f1370k = new ConcurrentHashMap();

    /* renamed from: e, reason: collision with root package name */
    private final e f1364e = e();

    public static class a<T extends h> {

        /* renamed from: a, reason: collision with root package name */
        private final Class<T> f1371a;

        /* renamed from: b, reason: collision with root package name */
        private final String f1372b;

        /* renamed from: c, reason: collision with root package name */
        private final Context f1373c;

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<b> f1374d;

        /* renamed from: e, reason: collision with root package name */
        private Executor f1375e;

        /* renamed from: f, reason: collision with root package name */
        private Executor f1376f;

        /* renamed from: g, reason: collision with root package name */
        private c.InterfaceC0129c f1377g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f1378h;

        /* renamed from: j, reason: collision with root package name */
        private boolean f1380j;

        /* renamed from: l, reason: collision with root package name */
        private boolean f1382l;

        /* renamed from: n, reason: collision with root package name */
        private Set<Integer> f1384n;

        /* renamed from: o, reason: collision with root package name */
        private Set<Integer> f1385o;

        /* renamed from: p, reason: collision with root package name */
        private String f1386p;

        /* renamed from: q, reason: collision with root package name */
        private File f1387q;

        /* renamed from: i, reason: collision with root package name */
        private c f1379i = c.AUTOMATIC;

        /* renamed from: k, reason: collision with root package name */
        private boolean f1381k = true;

        /* renamed from: m, reason: collision with root package name */
        private final d f1383m = new d();

        a(Context context, Class<T> cls, String str) {
            this.f1373c = context;
            this.f1371a = cls;
            this.f1372b = str;
        }

        public a<T> a(b bVar) {
            if (this.f1374d == null) {
                this.f1374d = new ArrayList<>();
            }
            this.f1374d.add(bVar);
            return this;
        }

        public a<T> b(o.a... aVarArr) {
            if (this.f1385o == null) {
                this.f1385o = new HashSet();
            }
            for (o.a aVar : aVarArr) {
                this.f1385o.add(Integer.valueOf(aVar.f8301a));
                this.f1385o.add(Integer.valueOf(aVar.f8302b));
            }
            this.f1383m.b(aVarArr);
            return this;
        }

        public a<T> c() {
            this.f1378h = true;
            return this;
        }

        /* JADX WARN: Code restructure failed: missing block: B:51:0x0028, code lost:
        
            if (r1 != null) goto L11;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0067  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x007a  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public T d() {
            /*
                Method dump skipped, instructions count: 236
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.h.a.d():androidx.room.h");
        }

        public a<T> e() {
            this.f1381k = false;
            this.f1382l = true;
            return this;
        }

        public a<T> f(c.InterfaceC0129c interfaceC0129c) {
            this.f1377g = interfaceC0129c;
            return this;
        }

        public a<T> g(Executor executor) {
            this.f1375e = executor;
            return this;
        }
    }

    public static abstract class b {
        public void a(q.b bVar) {
        }

        public void b(q.b bVar) {
        }

        public void c(q.b bVar) {
        }
    }

    public enum c {
        AUTOMATIC,
        TRUNCATE,
        WRITE_AHEAD_LOGGING;

        private static boolean a(ActivityManager activityManager) {
            return activityManager.isLowRamDevice();
        }

        c b(Context context) {
            if (this != AUTOMATIC) {
                return this;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (activityManager == null || a(activityManager)) ? TRUNCATE : WRITE_AHEAD_LOGGING;
        }
    }

    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private HashMap<Integer, TreeMap<Integer, o.a>> f1392a = new HashMap<>();

        private void a(o.a aVar) {
            int i6 = aVar.f8301a;
            int i7 = aVar.f8302b;
            TreeMap<Integer, o.a> treeMap = this.f1392a.get(Integer.valueOf(i6));
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                this.f1392a.put(Integer.valueOf(i6), treeMap);
            }
            o.a aVar2 = treeMap.get(Integer.valueOf(i7));
            if (aVar2 != null) {
                Log.w("ROOM", "Overriding migration " + aVar2 + " with " + aVar);
            }
            treeMap.put(Integer.valueOf(i7), aVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0016 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:5:0x0017  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private java.util.List<o.a> d(java.util.List<o.a> r7, boolean r8, int r9, int r10) {
            /*
                r6 = this;
            L0:
                if (r8 == 0) goto L5
                if (r9 >= r10) goto L57
                goto L7
            L5:
                if (r9 <= r10) goto L57
            L7:
                java.util.HashMap<java.lang.Integer, java.util.TreeMap<java.lang.Integer, o.a>> r0 = r6.f1392a
                java.lang.Integer r1 = java.lang.Integer.valueOf(r9)
                java.lang.Object r0 = r0.get(r1)
                java.util.TreeMap r0 = (java.util.TreeMap) r0
                r1 = 0
                if (r0 != 0) goto L17
                return r1
            L17:
                if (r8 == 0) goto L1e
                java.util.NavigableSet r2 = r0.descendingKeySet()
                goto L22
            L1e:
                java.util.Set r2 = r0.keySet()
            L22:
                java.util.Iterator r2 = r2.iterator()
            L26:
                boolean r3 = r2.hasNext()
                r4 = 0
                if (r3 == 0) goto L54
                java.lang.Object r3 = r2.next()
                java.lang.Integer r3 = (java.lang.Integer) r3
                int r3 = r3.intValue()
                r5 = 1
                if (r8 == 0) goto L40
                if (r3 > r10) goto L45
                if (r3 <= r9) goto L45
            L3e:
                r4 = 1
                goto L45
            L40:
                if (r3 < r10) goto L45
                if (r3 >= r9) goto L45
                goto L3e
            L45:
                if (r4 == 0) goto L26
                java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
                java.lang.Object r9 = r0.get(r9)
                r7.add(r9)
                r9 = r3
                r4 = 1
            L54:
                if (r4 != 0) goto L0
                return r1
            L57:
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.h.d.d(java.util.List, boolean, int, int):java.util.List");
        }

        public void b(o.a... aVarArr) {
            for (o.a aVar : aVarArr) {
                a(aVar);
            }
        }

        public List<o.a> c(int i6, int i7) {
            if (i6 == i7) {
                return Collections.emptyList();
            }
            return d(new ArrayList(), i7 > i6, i6, i7);
        }
    }

    private static boolean p() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void a() {
        if (!this.f1365f && p()) {
            throw new IllegalStateException("Cannot access database on the main thread since it may potentially lock the UI for a long period of time.");
        }
    }

    public void b() {
        if (!m() && this.f1369j.get() != null) {
            throw new IllegalStateException("Cannot access database on a different coroutine context inherited from a suspending transaction.");
        }
    }

    @Deprecated
    public void c() {
        a();
        q.b writableDatabase = this.f1363d.getWritableDatabase();
        this.f1364e.o(writableDatabase);
        writableDatabase.f();
    }

    public q.f d(String str) {
        a();
        b();
        return this.f1363d.getWritableDatabase().p(str);
    }

    protected abstract e e();

    protected abstract q.c f(androidx.room.a aVar);

    @Deprecated
    public void g() {
        this.f1363d.getWritableDatabase().e();
        if (m()) {
            return;
        }
        this.f1364e.h();
    }

    Lock h() {
        return this.f1368i.readLock();
    }

    public e i() {
        return this.f1364e;
    }

    public q.c j() {
        return this.f1363d;
    }

    public Executor k() {
        return this.f1361b;
    }

    public Executor l() {
        return this.f1362c;
    }

    public boolean m() {
        return this.f1363d.getWritableDatabase().B();
    }

    public void n(androidx.room.a aVar) {
        q.c f6 = f(aVar);
        this.f1363d = f6;
        if (f6 instanceof k) {
            ((k) f6).j(aVar);
        }
        boolean z5 = aVar.f1300g == c.WRITE_AHEAD_LOGGING;
        this.f1363d.setWriteAheadLoggingEnabled(z5);
        this.f1367h = aVar.f1298e;
        this.f1361b = aVar.f1301h;
        this.f1362c = new m(aVar.f1302i);
        this.f1365f = aVar.f1299f;
        this.f1366g = z5;
        if (aVar.f1303j) {
            this.f1364e.k(aVar.f1295b, aVar.f1296c);
        }
    }

    protected void o(q.b bVar) {
        this.f1364e.f(bVar);
    }

    public boolean q() {
        q.b bVar = this.f1360a;
        return bVar != null && bVar.isOpen();
    }

    public Cursor r(q.e eVar) {
        return s(eVar, null);
    }

    public Cursor s(q.e eVar, CancellationSignal cancellationSignal) {
        a();
        b();
        return cancellationSignal != null ? this.f1363d.getWritableDatabase().n(eVar, cancellationSignal) : this.f1363d.getWritableDatabase().N(eVar);
    }

    @Deprecated
    public void t() {
        this.f1363d.getWritableDatabase().J();
    }
}
