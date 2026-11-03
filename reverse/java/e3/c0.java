package e3;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import q3.a;
import y3.k;

/* loaded from: classes.dex */
public class c0 implements q3.a, k.c {

    /* renamed from: h, reason: collision with root package name */
    static String f3612h;

    /* renamed from: l, reason: collision with root package name */
    private static o f3616l;

    /* renamed from: a, reason: collision with root package name */
    private Context f3617a;

    /* renamed from: b, reason: collision with root package name */
    private y3.k f3618b;

    /* renamed from: c, reason: collision with root package name */
    static final Map<String, Integer> f3607c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    static final Map<Integer, i> f3608d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private static final Object f3609e = new Object();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f3610f = new Object();

    /* renamed from: g, reason: collision with root package name */
    static int f3611g = 0;

    /* renamed from: i, reason: collision with root package name */
    private static int f3613i = 0;

    /* renamed from: j, reason: collision with root package name */
    private static int f3614j = 1;

    /* renamed from: k, reason: collision with root package name */
    private static int f3615k = 0;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f3619a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ k.d f3620b;

        a(i iVar, k.d dVar) {
            this.f3619a = iVar;
            this.f3620b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c0.f3610f) {
                c0.this.o(this.f3619a);
            }
            this.f3620b.b(null);
        }
    }

    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f3622a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f3623b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ k.d f3624c;

        b(i iVar, String str, k.d dVar) {
            this.f3622a = iVar;
            this.f3623b = str;
            this.f3624c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (c0.f3610f) {
                i iVar = this.f3622a;
                if (iVar != null) {
                    c0.this.o(iVar);
                }
                try {
                    if (r.c(c0.f3611g)) {
                        Log.d("Sqflite", "delete database " + this.f3623b);
                    }
                    i.n(this.f3623b);
                } catch (Exception e6) {
                    Log.e("Sqflite", "error " + e6 + " while closing database " + c0.f3615k);
                }
            }
            this.f3624c.b(null);
        }
    }

    static Map A(int i6, boolean z5, boolean z6) {
        HashMap hashMap = new HashMap();
        hashMap.put("id", Integer.valueOf(i6));
        if (z5) {
            hashMap.put("recovered", Boolean.TRUE);
        }
        if (z6) {
            hashMap.put("recoveredInTransaction", Boolean.TRUE);
        }
        return hashMap;
    }

    private void B(Context context, y3.c cVar) {
        this.f3617a = context;
        y3.k kVar = new y3.k(cVar, "com.tekartik.sqflite", y3.r.f11115b, cVar.d());
        this.f3618b = kVar;
        kVar.e(this);
    }

    private void C(final y3.j jVar, final k.d dVar) {
        final i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        f3616l.a(q6, new Runnable() { // from class: e3.b0
            @Override // java.lang.Runnable
            public final void run() {
                i.this.h(jVar, dVar);
            }
        });
    }

    private void D(y3.j jVar, k.d dVar) {
        int intValue = ((Integer) jVar.a("id")).intValue();
        i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        if (r.b(q6.f3640d)) {
            Log.d("Sqflite", q6.y() + "closing " + intValue + " " + q6.f3638b);
        }
        String str = q6.f3638b;
        synchronized (f3609e) {
            f3608d.remove(Integer.valueOf(intValue));
            if (q6.f3637a) {
                f3607c.remove(str);
            }
        }
        f3616l.a(q6, new a(q6, dVar));
    }

    private void E(y3.j jVar, k.d dVar) {
        dVar.b(Boolean.valueOf(i.w((String) jVar.a("path"))));
    }

    private void F(y3.j jVar, k.d dVar) {
        String str = (String) jVar.a("cmd");
        HashMap hashMap = new HashMap();
        if ("get".equals(str)) {
            int i6 = f3611g;
            if (i6 > 0) {
                hashMap.put("logLevel", Integer.valueOf(i6));
            }
            Map<Integer, i> map = f3608d;
            if (!map.isEmpty()) {
                HashMap hashMap2 = new HashMap();
                for (Map.Entry<Integer, i> entry : map.entrySet()) {
                    i value = entry.getValue();
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("path", value.f3638b);
                    hashMap3.put("singleInstance", Boolean.valueOf(value.f3637a));
                    int i7 = value.f3640d;
                    if (i7 > 0) {
                        hashMap3.put("logLevel", Integer.valueOf(i7));
                    }
                    hashMap2.put(entry.getKey().toString(), hashMap3);
                }
                hashMap.put("databases", hashMap2);
            }
        }
        dVar.b(hashMap);
    }

    private void G(y3.j jVar, k.d dVar) {
        f3.a.f3888a = Boolean.TRUE.equals(jVar.b());
        f3.a.f3890c = f3.a.f3889b && f3.a.f3888a;
        if (!f3.a.f3888a) {
            f3611g = 0;
        } else if (f3.a.f3890c) {
            f3611g = 2;
        } else if (f3.a.f3888a) {
            f3611g = 1;
        }
        dVar.b(null);
    }

    private void H(y3.j jVar, k.d dVar) {
        i iVar;
        Map<Integer, i> map;
        String str = (String) jVar.a("path");
        synchronized (f3609e) {
            if (r.c(f3611g)) {
                Log.d("Sqflite", "Look for " + str + " in " + f3607c.keySet());
            }
            Map<String, Integer> map2 = f3607c;
            Integer num = map2.get(str);
            if (num == null || (iVar = (map = f3608d).get(num)) == null || !iVar.f3645i.isOpen()) {
                iVar = null;
            } else {
                if (r.c(f3611g)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(iVar.y());
                    sb.append("found single instance ");
                    sb.append(iVar.D() ? "(in transaction) " : "");
                    sb.append(num);
                    sb.append(" ");
                    sb.append(str);
                    Log.d("Sqflite", sb.toString());
                }
                map.remove(num);
                map2.remove(str);
            }
        }
        b bVar = new b(iVar, str, dVar);
        o oVar = f3616l;
        if (oVar != null) {
            oVar.a(iVar, bVar);
        } else {
            bVar.run();
        }
    }

    private void I(final y3.j jVar, final k.d dVar) {
        final i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        f3616l.a(q6, new Runnable() { // from class: e3.x
            @Override // java.lang.Runnable
            public final void run() {
                c0.t(y3.j.this, dVar, q6);
            }
        });
    }

    private void K(final y3.j jVar, final k.d dVar) {
        final i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        f3616l.a(q6, new Runnable() { // from class: e3.u
            @Override // java.lang.Runnable
            public final void run() {
                c0.u(y3.j.this, dVar, q6);
            }
        });
    }

    private void L(final y3.j jVar, final k.d dVar) {
        final int i6;
        i iVar;
        final String str = (String) jVar.a("path");
        final Boolean bool = (Boolean) jVar.a("readOnly");
        final boolean r6 = r(str);
        boolean z5 = (Boolean.FALSE.equals(jVar.a("singleInstance")) || r6) ? false : true;
        if (z5) {
            synchronized (f3609e) {
                if (r.c(f3611g)) {
                    Log.d("Sqflite", "Look for " + str + " in " + f3607c.keySet());
                }
                Integer num = f3607c.get(str);
                if (num != null && (iVar = f3608d.get(num)) != null) {
                    if (iVar.f3645i.isOpen()) {
                        if (r.c(f3611g)) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(iVar.y());
                            sb.append("re-opened single instance ");
                            sb.append(iVar.D() ? "(in transaction) " : "");
                            sb.append(num);
                            sb.append(" ");
                            sb.append(str);
                            Log.d("Sqflite", sb.toString());
                        }
                        dVar.b(A(num.intValue(), true, iVar.D()));
                        return;
                    }
                    if (r.c(f3611g)) {
                        Log.d("Sqflite", iVar.y() + "single instance database of " + str + " not opened");
                    }
                }
            }
        }
        Object obj = f3609e;
        synchronized (obj) {
            i6 = f3615k + 1;
            f3615k = i6;
        }
        final i iVar2 = new i(this.f3617a, str, i6, z5, f3611g);
        synchronized (obj) {
            if (f3616l == null) {
                o b6 = n.b("Sqflite", f3614j, f3613i);
                f3616l = b6;
                b6.start();
                if (r.b(iVar2.f3640d)) {
                    Log.d("Sqflite", iVar2.y() + "starting worker pool with priority " + f3613i);
                }
            }
            iVar2.f3644h = f3616l;
            if (r.b(iVar2.f3640d)) {
                Log.d("Sqflite", iVar2.y() + "opened " + i6 + " " + str);
            }
            final boolean z6 = z5;
            f3616l.a(iVar2, new Runnable() { // from class: e3.z
                @Override // java.lang.Runnable
                public final void run() {
                    c0.v(r6, str, dVar, bool, iVar2, jVar, z6, i6);
                }
            });
        }
    }

    private void N(final y3.j jVar, final k.d dVar) {
        final i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        f3616l.a(q6, new Runnable() { // from class: e3.y
            @Override // java.lang.Runnable
            public final void run() {
                c0.w(y3.j.this, dVar, q6);
            }
        });
    }

    private void O(final y3.j jVar, final k.d dVar) {
        final i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        f3616l.a(q6, new Runnable() { // from class: e3.v
            @Override // java.lang.Runnable
            public final void run() {
                c0.x(y3.j.this, dVar, q6);
            }
        });
    }

    private void P(final y3.j jVar, final k.d dVar) {
        final i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        f3616l.a(q6, new Runnable() { // from class: e3.a0
            @Override // java.lang.Runnable
            public final void run() {
                c0.y(y3.j.this, q6, dVar);
            }
        });
    }

    private void Q(final y3.j jVar, final k.d dVar) {
        final i q6 = q(jVar, dVar);
        if (q6 == null) {
            return;
        }
        f3616l.a(q6, new Runnable() { // from class: e3.w
            @Override // java.lang.Runnable
            public final void run() {
                c0.z(y3.j.this, dVar, q6);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(i iVar) {
        try {
            if (r.b(iVar.f3640d)) {
                Log.d("Sqflite", iVar.y() + "closing database ");
            }
            iVar.j();
        } catch (Exception e6) {
            Log.e("Sqflite", "error " + e6 + " while closing database " + f3615k);
        }
        synchronized (f3609e) {
            if (f3608d.isEmpty() && f3616l != null) {
                if (r.b(iVar.f3640d)) {
                    Log.d("Sqflite", iVar.y() + "stopping thread");
                }
                f3616l.c();
                f3616l = null;
            }
        }
    }

    private i p(int i6) {
        return f3608d.get(Integer.valueOf(i6));
    }

    private i q(y3.j jVar, k.d dVar) {
        int intValue = ((Integer) jVar.a("id")).intValue();
        i p6 = p(intValue);
        if (p6 != null) {
            return p6;
        }
        dVar.a("sqlite_error", "database_closed " + intValue, null);
        return null;
    }

    static boolean r(String str) {
        return str == null || str.equals(":memory:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(y3.j jVar, k.d dVar, i iVar) {
        iVar.u(new g3.d(jVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(y3.j jVar, k.d dVar, i iVar) {
        iVar.C(new g3.d(jVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(boolean z5, String str, k.d dVar, Boolean bool, i iVar, y3.j jVar, boolean z6, int i6) {
        synchronized (f3610f) {
            if (!z5) {
                try {
                    File file = new File(new File(str).getParent());
                    if (!file.exists() && !file.mkdirs() && !file.exists()) {
                        dVar.a("sqlite_error", "open_failed " + str, null);
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            try {
                if (Boolean.TRUE.equals(bool)) {
                    iVar.L();
                } else {
                    iVar.K();
                }
                synchronized (f3609e) {
                    if (z6) {
                        f3607c.put(str, Integer.valueOf(i6));
                    }
                    f3608d.put(Integer.valueOf(i6), iVar);
                }
                if (r.b(iVar.f3640d)) {
                    Log.d("Sqflite", iVar.y() + "opened " + i6 + " " + str);
                }
                dVar.b(A(i6, false, false));
            } catch (Exception e6) {
                iVar.B(e6, new g3.d(jVar, dVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(y3.j jVar, k.d dVar, i iVar) {
        iVar.M(new g3.d(jVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(y3.j jVar, k.d dVar, i iVar) {
        iVar.N(new g3.d(jVar, dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void y(y3.j jVar, i iVar, k.d dVar) {
        try {
            iVar.f3645i.setLocale(e0.d((String) jVar.a("locale")));
            dVar.b(null);
        } catch (Exception e6) {
            dVar.a("sqlite_error", "Error calling setLocale: " + e6.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(y3.j jVar, k.d dVar, i iVar) {
        iVar.P(new g3.d(jVar, dVar));
    }

    void J(y3.j jVar, k.d dVar) {
        if (f3612h == null) {
            f3612h = this.f3617a.getDatabasePath("tekartik_sqflite.db").getParent();
        }
        dVar.b(f3612h);
    }

    void M(y3.j jVar, k.d dVar) {
        Object a6 = jVar.a("androidThreadPriority");
        if (a6 != null) {
            f3613i = ((Integer) a6).intValue();
        }
        Object a7 = jVar.a("androidThreadCount");
        if (a7 != null && !a7.equals(Integer.valueOf(f3614j))) {
            f3614j = ((Integer) a7).intValue();
            o oVar = f3616l;
            if (oVar != null) {
                oVar.c();
                f3616l = null;
            }
        }
        Integer a8 = r.a(jVar);
        if (a8 != null) {
            f3611g = a8.intValue();
        }
        dVar.b(null);
    }

    @Override // q3.a
    public void b(a.b bVar) {
        B(bVar.a(), bVar.b());
    }

    @Override // y3.k.c
    public void e(y3.j jVar, k.d dVar) {
        String str = jVar.f11100a;
        str.hashCode();
        switch (str) {
            case "execute":
                I(jVar, dVar);
                break;
            case "closeDatabase":
                D(jVar, dVar);
                break;
            case "options":
                M(jVar, dVar);
                break;
            case "insert":
                K(jVar, dVar);
                break;
            case "update":
                Q(jVar, dVar);
                break;
            case "androidSetLocale":
                P(jVar, dVar);
                break;
            case "deleteDatabase":
                H(jVar, dVar);
                break;
            case "debugMode":
                G(jVar, dVar);
                break;
            case "openDatabase":
                L(jVar, dVar);
                break;
            case "batch":
                C(jVar, dVar);
                break;
            case "debug":
                F(jVar, dVar);
                break;
            case "query":
                N(jVar, dVar);
                break;
            case "databaseExists":
                E(jVar, dVar);
                break;
            case "queryCursorNext":
                O(jVar, dVar);
                break;
            case "getPlatformVersion":
                dVar.b("Android " + Build.VERSION.RELEASE);
                break;
            case "getDatabasesPath":
                J(jVar, dVar);
                break;
            default:
                dVar.c();
                break;
        }
    }

    @Override // q3.a
    public void j(a.b bVar) {
        this.f3617a = null;
        this.f3618b.e(null);
        this.f3618b = null;
    }
}
