package h2;

import android.os.ConditionVariable;
import h2.a;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/* loaded from: classes.dex */
public final class u implements h2.a {

    /* renamed from: l, reason: collision with root package name */
    private static final HashSet<File> f5215l = new HashSet<>();

    /* renamed from: a, reason: collision with root package name */
    private final File f5216a;

    /* renamed from: b, reason: collision with root package name */
    private final d f5217b;

    /* renamed from: c, reason: collision with root package name */
    private final m f5218c;

    /* renamed from: d, reason: collision with root package name */
    private final f f5219d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap<String, ArrayList<a.b>> f5220e;

    /* renamed from: f, reason: collision with root package name */
    private final Random f5221f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f5222g;

    /* renamed from: h, reason: collision with root package name */
    private long f5223h;

    /* renamed from: i, reason: collision with root package name */
    private long f5224i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f5225j;

    /* renamed from: k, reason: collision with root package name */
    private a.C0083a f5226k;

    class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ConditionVariable f5227a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f5227a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (u.this) {
                this.f5227a.open();
                u.this.r();
                u.this.f5217b.e();
            }
        }
    }

    u(File file, d dVar, m mVar, f fVar) {
        if (!u(file)) {
            throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
        }
        this.f5216a = file;
        this.f5217b = dVar;
        this.f5218c = mVar;
        this.f5219d = fVar;
        this.f5220e = new HashMap<>();
        this.f5221f = new Random();
        this.f5222g = dVar.f();
        this.f5223h = -1L;
        ConditionVariable conditionVariable = new ConditionVariable();
        new a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
        conditionVariable.block();
    }

    public u(File file, d dVar, k0.b bVar) {
        this(file, dVar, bVar, null, false, false);
    }

    public u(File file, d dVar, k0.b bVar, byte[] bArr, boolean z5, boolean z6) {
        this(file, dVar, new m(bVar, file, bArr, z5, z6), (bVar == null || z6) ? null : new f(bVar));
    }

    private void A(j jVar) {
        l g6 = this.f5218c.g(jVar.f5165a);
        if (g6 == null || !g6.k(jVar)) {
            return;
        }
        this.f5224i -= jVar.f5167c;
        if (this.f5219d != null) {
            String name = jVar.f5169e.getName();
            try {
                this.f5219d.f(name);
            } catch (IOException unused) {
                i2.t.i("SimpleCache", "Failed to remove file index entry for: " + name);
            }
        }
        this.f5218c.p(g6.f5182b);
        w(jVar);
    }

    private void B() {
        ArrayList arrayList = new ArrayList();
        Iterator<l> it = this.f5218c.h().iterator();
        while (it.hasNext()) {
            Iterator<v> it2 = it.next().f().iterator();
            while (it2.hasNext()) {
                v next = it2.next();
                if (next.f5169e.length() != next.f5167c) {
                    arrayList.add(next);
                }
            }
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            A((j) arrayList.get(i6));
        }
    }

    private v C(String str, v vVar) {
        boolean z5;
        if (!this.f5222g) {
            return vVar;
        }
        String name = ((File) i2.a.e(vVar.f5169e)).getName();
        long j6 = vVar.f5167c;
        long currentTimeMillis = System.currentTimeMillis();
        f fVar = this.f5219d;
        if (fVar != null) {
            try {
                fVar.h(name, j6, currentTimeMillis);
            } catch (IOException unused) {
                i2.t.i("SimpleCache", "Failed to update index with new touch timestamp.");
            }
            z5 = false;
        } else {
            z5 = true;
        }
        v l6 = this.f5218c.g(str).l(vVar, currentTimeMillis, z5);
        x(vVar, l6);
        return l6;
    }

    private static synchronized void D(File file) {
        synchronized (u.class) {
            f5215l.remove(file.getAbsoluteFile());
        }
    }

    private void m(v vVar) {
        this.f5218c.m(vVar.f5165a).a(vVar);
        this.f5224i += vVar.f5167c;
        v(vVar);
    }

    private static void o(File file) {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        i2.t.c("SimpleCache", str);
        throw new a.C0083a(str);
    }

    private static long p(File file) {
        long nextLong = new SecureRandom().nextLong();
        long abs = nextLong == Long.MIN_VALUE ? 0L : Math.abs(nextLong);
        File file2 = new File(file, Long.toString(abs, 16) + ".uid");
        if (file2.createNewFile()) {
            return abs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    private v q(String str, long j6, long j7) {
        v e6;
        l g6 = this.f5218c.g(str);
        if (g6 == null) {
            return v.g(str, j6, j7);
        }
        while (true) {
            e6 = g6.e(j6, j7);
            if (!e6.f5168d || e6.f5169e.length() == e6.f5167c) {
                break;
            }
            B();
        }
        return e6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        a.C0083a c0083a;
        if (!this.f5216a.exists()) {
            try {
                o(this.f5216a);
            } catch (a.C0083a e6) {
                this.f5226k = e6;
                return;
            }
        }
        File[] listFiles = this.f5216a.listFiles();
        if (listFiles == null) {
            String str = "Failed to list cache directory files: " + this.f5216a;
            i2.t.c("SimpleCache", str);
            c0083a = new a.C0083a(str);
        } else {
            long t5 = t(listFiles);
            this.f5223h = t5;
            if (t5 == -1) {
                try {
                    this.f5223h = p(this.f5216a);
                } catch (IOException e7) {
                    String str2 = "Failed to create cache UID: " + this.f5216a;
                    i2.t.d("SimpleCache", str2, e7);
                    c0083a = new a.C0083a(str2, e7);
                }
            }
            try {
                this.f5218c.n(this.f5223h);
                f fVar = this.f5219d;
                if (fVar != null) {
                    fVar.e(this.f5223h);
                    Map<String, e> b6 = this.f5219d.b();
                    s(this.f5216a, true, listFiles, b6);
                    this.f5219d.g(b6.keySet());
                } else {
                    s(this.f5216a, true, listFiles, null);
                }
                this.f5218c.r();
                try {
                    this.f5218c.s();
                    return;
                } catch (IOException e8) {
                    i2.t.d("SimpleCache", "Storing index file failed", e8);
                    return;
                }
            } catch (IOException e9) {
                String str3 = "Failed to initialize cache indices: " + this.f5216a;
                i2.t.d("SimpleCache", str3, e9);
                c0083a = new a.C0083a(str3, e9);
            }
        }
        this.f5226k = c0083a;
    }

    private void s(File file, boolean z5, File[] fileArr, Map<String, e> map) {
        long j6;
        long j7;
        if (fileArr == null || fileArr.length == 0) {
            if (z5) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z5 && name.indexOf(46) == -1) {
                s(file2, false, file2.listFiles(), map);
            } else if (!z5 || (!m.o(name) && !name.endsWith(".uid"))) {
                e remove = map != null ? map.remove(name) : null;
                if (remove != null) {
                    j7 = remove.f5159a;
                    j6 = remove.f5160b;
                } else {
                    j6 = -9223372036854775807L;
                    j7 = -1;
                }
                v e6 = v.e(file2, j7, j6, this.f5218c);
                if (e6 != null) {
                    m(e6);
                } else {
                    file2.delete();
                }
            }
        }
    }

    private static long t(File[] fileArr) {
        int length = fileArr.length;
        for (int i6 = 0; i6 < length; i6++) {
            File file = fileArr[i6];
            String name = file.getName();
            if (name.endsWith(".uid")) {
                try {
                    return y(name);
                } catch (NumberFormatException unused) {
                    i2.t.c("SimpleCache", "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    private static synchronized boolean u(File file) {
        boolean add;
        synchronized (u.class) {
            add = f5215l.add(file.getAbsoluteFile());
        }
        return add;
    }

    private void v(v vVar) {
        ArrayList<a.b> arrayList = this.f5220e.get(vVar.f5165a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).d(this, vVar);
            }
        }
        this.f5217b.d(this, vVar);
    }

    private void w(j jVar) {
        ArrayList<a.b> arrayList = this.f5220e.get(jVar.f5165a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).c(this, jVar);
            }
        }
        this.f5217b.c(this, jVar);
    }

    private void x(v vVar, j jVar) {
        ArrayList<a.b> arrayList = this.f5220e.get(vVar.f5165a);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, vVar, jVar);
            }
        }
        this.f5217b.a(this, vVar, jVar);
    }

    private static long y(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    @Override // h2.a
    public synchronized File a(String str, long j6, long j7) {
        l g6;
        File file;
        i2.a.g(!this.f5225j);
        n();
        g6 = this.f5218c.g(str);
        i2.a.e(g6);
        i2.a.g(g6.h(j6, j7));
        if (!this.f5216a.exists()) {
            o(this.f5216a);
            B();
        }
        this.f5217b.b(this, str, j6, j7);
        file = new File(this.f5216a, Integer.toString(this.f5221f.nextInt(10)));
        if (!file.exists()) {
            o(file);
        }
        return v.i(file, g6.f5181a, j6, System.currentTimeMillis());
    }

    @Override // h2.a
    public synchronized void b(j jVar) {
        i2.a.g(!this.f5225j);
        A(jVar);
    }

    @Override // h2.a
    public synchronized void c(File file, long j6) {
        boolean z5 = true;
        i2.a.g(!this.f5225j);
        if (file.exists()) {
            if (j6 == 0) {
                file.delete();
                return;
            }
            v vVar = (v) i2.a.e(v.f(file, j6, this.f5218c));
            l lVar = (l) i2.a.e(this.f5218c.g(vVar.f5165a));
            i2.a.g(lVar.h(vVar.f5166b, vVar.f5167c));
            long a6 = n.a(lVar.d());
            if (a6 != -1) {
                if (vVar.f5166b + vVar.f5167c > a6) {
                    z5 = false;
                }
                i2.a.g(z5);
            }
            if (this.f5219d != null) {
                try {
                    this.f5219d.h(file.getName(), vVar.f5167c, vVar.f5170j);
                } catch (IOException e6) {
                    throw new a.C0083a(e6);
                }
            }
            m(vVar);
            try {
                this.f5218c.s();
                notifyAll();
            } catch (IOException e7) {
                throw new a.C0083a(e7);
            }
        }
    }

    @Override // h2.a
    public synchronized o d(String str) {
        i2.a.g(!this.f5225j);
        return this.f5218c.j(str);
    }

    @Override // h2.a
    public synchronized void e(String str, p pVar) {
        i2.a.g(!this.f5225j);
        n();
        this.f5218c.e(str, pVar);
        try {
            this.f5218c.s();
        } catch (IOException e6) {
            throw new a.C0083a(e6);
        }
    }

    @Override // h2.a
    public synchronized long f(String str, long j6, long j7) {
        long j8;
        long j9 = j7 == -1 ? Long.MAX_VALUE : j7 + j6;
        long j10 = j9 >= 0 ? j9 : Long.MAX_VALUE;
        j8 = 0;
        while (j6 < j10) {
            long i6 = i(str, j6, j10 - j6);
            if (i6 > 0) {
                j8 += i6;
            } else {
                i6 = -i6;
            }
            j6 += i6;
        }
        return j8;
    }

    @Override // h2.a
    public synchronized void g(j jVar) {
        i2.a.g(!this.f5225j);
        l lVar = (l) i2.a.e(this.f5218c.g(jVar.f5165a));
        lVar.m(jVar.f5166b);
        this.f5218c.p(lVar.f5182b);
        notifyAll();
    }

    @Override // h2.a
    public synchronized j h(String str, long j6, long j7) {
        i2.a.g(!this.f5225j);
        n();
        v q6 = q(str, j6, j7);
        if (q6.f5168d) {
            return C(str, q6);
        }
        if (this.f5218c.m(str).j(j6, q6.f5167c)) {
            return q6;
        }
        return null;
    }

    @Override // h2.a
    public synchronized long i(String str, long j6, long j7) {
        l g6;
        i2.a.g(!this.f5225j);
        if (j7 == -1) {
            j7 = Long.MAX_VALUE;
        }
        g6 = this.f5218c.g(str);
        return g6 != null ? g6.c(j6, j7) : -j7;
    }

    @Override // h2.a
    public synchronized j j(String str, long j6, long j7) {
        j h6;
        i2.a.g(!this.f5225j);
        n();
        while (true) {
            h6 = h(str, j6, j7);
            if (h6 == null) {
                wait();
            }
        }
        return h6;
    }

    public synchronized void n() {
        a.C0083a c0083a = this.f5226k;
        if (c0083a != null) {
            throw c0083a;
        }
    }

    public synchronized void z() {
        if (this.f5225j) {
            return;
        }
        this.f5220e.clear();
        B();
        try {
            try {
                this.f5218c.s();
                D(this.f5216a);
            } catch (IOException e6) {
                i2.t.d("SimpleCache", "Storing index file failed", e6);
                D(this.f5216a);
            }
            this.f5225j = true;
        } catch (Throwable th) {
            D(this.f5216a);
            this.f5225j = true;
            throw th;
        }
    }
}
