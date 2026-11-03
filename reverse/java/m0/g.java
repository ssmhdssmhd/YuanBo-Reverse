package m0;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.window.embedding.EmbeddingCompat;
import g2.h0;
import i0.o3;
import i2.c1;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m0.g0;
import m0.m;
import m0.o;
import m0.w;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
class g implements o {

    /* renamed from: a, reason: collision with root package name */
    public final List<m.b> f7757a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f7758b;

    /* renamed from: c, reason: collision with root package name */
    private final a f7759c;

    /* renamed from: d, reason: collision with root package name */
    private final b f7760d;

    /* renamed from: e, reason: collision with root package name */
    private final int f7761e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f7762f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f7763g;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<String, String> f7764h;

    /* renamed from: i, reason: collision with root package name */
    private final i2.j<w.a> f7765i;

    /* renamed from: j, reason: collision with root package name */
    private final g2.h0 f7766j;

    /* renamed from: k, reason: collision with root package name */
    private final o3 f7767k;

    /* renamed from: l, reason: collision with root package name */
    final s0 f7768l;

    /* renamed from: m, reason: collision with root package name */
    final UUID f7769m;

    /* renamed from: n, reason: collision with root package name */
    final e f7770n;

    /* renamed from: o, reason: collision with root package name */
    private int f7771o;

    /* renamed from: p, reason: collision with root package name */
    private int f7772p;

    /* renamed from: q, reason: collision with root package name */
    private HandlerThread f7773q;

    /* renamed from: r, reason: collision with root package name */
    private c f7774r;

    /* renamed from: s, reason: collision with root package name */
    private l0.b f7775s;

    /* renamed from: t, reason: collision with root package name */
    private o.a f7776t;

    /* renamed from: u, reason: collision with root package name */
    private byte[] f7777u;

    /* renamed from: v, reason: collision with root package name */
    private byte[] f7778v;

    /* renamed from: w, reason: collision with root package name */
    private g0.a f7779w;

    /* renamed from: x, reason: collision with root package name */
    private g0.d f7780x;

    public interface a {
        void a();

        void b(g gVar);

        void c(Exception exc, boolean z5);
    }

    public interface b {
        void a(g gVar, int i6);

        void b(g gVar, int i6);
    }

    private class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private boolean f7781a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, t0 t0Var) {
            d dVar = (d) message.obj;
            if (!dVar.f7784b) {
                return false;
            }
            int i6 = dVar.f7787e + 1;
            dVar.f7787e = i6;
            if (i6 > g.this.f7766j.c(3)) {
                return false;
            }
            long d6 = g.this.f7766j.d(new h0.c(new l1.o(dVar.f7783a, t0Var.f7879a, t0Var.f7880b, t0Var.f7881c, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f7785c, t0Var.f7882d), new l1.r(3), t0Var.getCause() instanceof IOException ? (IOException) t0Var.getCause() : new f(t0Var.getCause()), dVar.f7787e));
            if (d6 == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.f7781a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), d6);
                return true;
            }
        }

        void b(int i6, Object obj, boolean z5) {
            obtainMessage(i6, new d(l1.o.a(), z5, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f7781a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Throwable th;
            d dVar = (d) message.obj;
            try {
                int i6 = message.what;
                if (i6 == 0) {
                    g gVar = g.this;
                    th = gVar.f7768l.b(gVar.f7769m, (g0.d) dVar.f7786d);
                } else {
                    if (i6 != 1) {
                        throw new RuntimeException();
                    }
                    g gVar2 = g.this;
                    th = gVar2.f7768l.a(gVar2.f7769m, (g0.a) dVar.f7786d);
                }
            } catch (t0 e6) {
                boolean a6 = a(message, e6);
                th = e6;
                if (a6) {
                    return;
                }
            } catch (Exception e7) {
                i2.t.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e7);
                th = e7;
            }
            g.this.f7766j.a(dVar.f7783a);
            synchronized (this) {
                if (!this.f7781a) {
                    g.this.f7770n.obtainMessage(message.what, Pair.create(dVar.f7786d, th)).sendToTarget();
                }
            }
        }
    }

    private static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f7783a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f7784b;

        /* renamed from: c, reason: collision with root package name */
        public final long f7785c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f7786d;

        /* renamed from: e, reason: collision with root package name */
        public int f7787e;

        public d(long j6, boolean z5, long j7, Object obj) {
            this.f7783a = j6;
            this.f7784b = z5;
            this.f7785c = j7;
            this.f7786d = obj;
        }
    }

    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i6 = message.what;
            if (i6 == 0) {
                g.this.C(obj, obj2);
            } else {
                if (i6 != 1) {
                    return;
                }
                g.this.w(obj, obj2);
            }
        }
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super(th);
        }
    }

    public g(UUID uuid, g0 g0Var, a aVar, b bVar, List<m.b> list, int i6, boolean z5, boolean z6, byte[] bArr, HashMap<String, String> hashMap, s0 s0Var, Looper looper, g2.h0 h0Var, o3 o3Var) {
        List<m.b> unmodifiableList;
        if (i6 == 1 || i6 == 3) {
            i2.a.e(bArr);
        }
        this.f7769m = uuid;
        this.f7759c = aVar;
        this.f7760d = bVar;
        this.f7758b = g0Var;
        this.f7761e = i6;
        this.f7762f = z5;
        this.f7763g = z6;
        if (bArr != null) {
            this.f7778v = bArr;
            unmodifiableList = null;
        } else {
            unmodifiableList = Collections.unmodifiableList((List) i2.a.e(list));
        }
        this.f7757a = unmodifiableList;
        this.f7764h = hashMap;
        this.f7768l = s0Var;
        this.f7765i = new i2.j<>();
        this.f7766j = h0Var;
        this.f7767k = o3Var;
        this.f7771o = 2;
        this.f7770n = new e(looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Object obj, Object obj2) {
        if (obj == this.f7780x) {
            if (this.f7771o == 2 || s()) {
                this.f7780x = null;
                if (obj2 instanceof Exception) {
                    this.f7759c.c((Exception) obj2, false);
                    return;
                }
                try {
                    this.f7758b.i((byte[]) obj2);
                    this.f7759c.a();
                } catch (Exception e6) {
                    this.f7759c.c(e6, true);
                }
            }
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = EmbeddingCompat.DEBUG)
    private boolean D() {
        if (s()) {
            return true;
        }
        try {
            byte[] n6 = this.f7758b.n();
            this.f7777u = n6;
            this.f7758b.g(n6, this.f7767k);
            this.f7775s = this.f7758b.m(this.f7777u);
            final int i6 = 3;
            this.f7771o = 3;
            o(new i2.i() { // from class: m0.d
                @Override // i2.i
                public final void accept(Object obj) {
                    ((w.a) obj).k(i6);
                }
            });
            i2.a.e(this.f7777u);
            return true;
        } catch (NotProvisionedException unused) {
            this.f7759c.b(this);
            return false;
        } catch (Exception e6) {
            v(e6, 1);
            return false;
        }
    }

    private void E(byte[] bArr, int i6, boolean z5) {
        try {
            this.f7779w = this.f7758b.k(bArr, this.f7757a, i6, this.f7764h);
            ((c) c1.j(this.f7774r)).b(1, i2.a.e(this.f7779w), z5);
        } catch (Exception e6) {
            x(e6, true);
        }
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    private boolean G() {
        try {
            this.f7758b.c(this.f7777u, this.f7778v);
            return true;
        } catch (Exception e6) {
            v(e6, 1);
            return false;
        }
    }

    private void o(i2.i<w.a> iVar) {
        Iterator<w.a> it = this.f7765i.a().iterator();
        while (it.hasNext()) {
            iVar.accept(it.next());
        }
    }

    @RequiresNonNull({"sessionId"})
    private void p(boolean z5) {
        if (this.f7763g) {
            return;
        }
        byte[] bArr = (byte[]) c1.j(this.f7777u);
        int i6 = this.f7761e;
        if (i6 == 0 || i6 == 1) {
            if (this.f7778v == null) {
                E(bArr, 1, z5);
                return;
            }
            if (this.f7771o != 4 && !G()) {
                return;
            }
            long q6 = q();
            if (this.f7761e != 0 || q6 > 60) {
                if (q6 <= 0) {
                    v(new q0(), 2);
                    return;
                } else {
                    this.f7771o = 4;
                    o(new i2.i() { // from class: m0.f
                        @Override // i2.i
                        public final void accept(Object obj) {
                            ((w.a) obj).j();
                        }
                    });
                    return;
                }
            }
            i2.t.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + q6);
        } else {
            if (i6 != 2) {
                if (i6 != 3) {
                    return;
                }
                i2.a.e(this.f7778v);
                i2.a.e(this.f7777u);
                E(this.f7778v, 3, z5);
                return;
            }
            if (this.f7778v != null && !G()) {
                return;
            }
        }
        E(bArr, 2, z5);
    }

    private long q() {
        if (!h0.p.f4774d.equals(this.f7769m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) i2.a.e(w0.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = EmbeddingCompat.DEBUG)
    private boolean s() {
        int i6 = this.f7771o;
        return i6 == 3 || i6 == 4;
    }

    private void v(final Exception exc, int i6) {
        this.f7776t = new o.a(exc, c0.a(exc, i6));
        i2.t.d("DefaultDrmSession", "DRM session error", exc);
        o(new i2.i() { // from class: m0.e
            @Override // i2.i
            public final void accept(Object obj) {
                ((w.a) obj).l(exc);
            }
        });
        if (this.f7771o != 4) {
            this.f7771o = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Object obj, Object obj2) {
        i2.i<w.a> iVar;
        if (obj == this.f7779w && s()) {
            this.f7779w = null;
            if (obj2 instanceof Exception) {
                x((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f7761e == 3) {
                    this.f7758b.f((byte[]) c1.j(this.f7778v), bArr);
                    iVar = new i2.i() { // from class: m0.b
                        @Override // i2.i
                        public final void accept(Object obj3) {
                            ((w.a) obj3).i();
                        }
                    };
                } else {
                    byte[] f6 = this.f7758b.f(this.f7777u, bArr);
                    int i6 = this.f7761e;
                    if ((i6 == 2 || (i6 == 0 && this.f7778v != null)) && f6 != null && f6.length != 0) {
                        this.f7778v = f6;
                    }
                    this.f7771o = 4;
                    iVar = new i2.i() { // from class: m0.c
                        @Override // i2.i
                        public final void accept(Object obj3) {
                            ((w.a) obj3).h();
                        }
                    };
                }
                o(iVar);
            } catch (Exception e6) {
                x(e6, true);
            }
        }
    }

    private void x(Exception exc, boolean z5) {
        if (exc instanceof NotProvisionedException) {
            this.f7759c.b(this);
        } else {
            v(exc, z5 ? 1 : 2);
        }
    }

    private void y() {
        if (this.f7761e == 0 && this.f7771o == 4) {
            c1.j(this.f7777u);
            p(false);
        }
    }

    public void A() {
        if (D()) {
            p(true);
        }
    }

    public void B(Exception exc, boolean z5) {
        v(exc, z5 ? 1 : 3);
    }

    public void F() {
        this.f7780x = this.f7758b.h();
        ((c) c1.j(this.f7774r)).b(0, i2.a.e(this.f7780x), true);
    }

    @Override // m0.o
    public boolean a() {
        return this.f7762f;
    }

    @Override // m0.o
    public void b(w.a aVar) {
        if (this.f7772p < 0) {
            i2.t.c("DefaultDrmSession", "Session reference count less than zero: " + this.f7772p);
            this.f7772p = 0;
        }
        if (aVar != null) {
            this.f7765i.b(aVar);
        }
        int i6 = this.f7772p + 1;
        this.f7772p = i6;
        if (i6 == 1) {
            i2.a.g(this.f7771o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f7773q = handlerThread;
            handlerThread.start();
            this.f7774r = new c(this.f7773q.getLooper());
            if (D()) {
                p(true);
            }
        } else if (aVar != null && s() && this.f7765i.c(aVar) == 1) {
            aVar.k(this.f7771o);
        }
        this.f7760d.a(this, this.f7772p);
    }

    @Override // m0.o
    public Map<String, String> c() {
        byte[] bArr = this.f7777u;
        if (bArr == null) {
            return null;
        }
        return this.f7758b.d(bArr);
    }

    @Override // m0.o
    public final UUID d() {
        return this.f7769m;
    }

    @Override // m0.o
    public void e(w.a aVar) {
        int i6 = this.f7772p;
        if (i6 <= 0) {
            i2.t.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i7 = i6 - 1;
        this.f7772p = i7;
        if (i7 == 0) {
            this.f7771o = 0;
            ((e) c1.j(this.f7770n)).removeCallbacksAndMessages(null);
            ((c) c1.j(this.f7774r)).c();
            this.f7774r = null;
            ((HandlerThread) c1.j(this.f7773q)).quit();
            this.f7773q = null;
            this.f7775s = null;
            this.f7776t = null;
            this.f7779w = null;
            this.f7780x = null;
            byte[] bArr = this.f7777u;
            if (bArr != null) {
                this.f7758b.e(bArr);
                this.f7777u = null;
            }
        }
        if (aVar != null) {
            this.f7765i.d(aVar);
            if (this.f7765i.c(aVar) == 0) {
                aVar.m();
            }
        }
        this.f7760d.b(this, this.f7772p);
    }

    @Override // m0.o
    public byte[] f() {
        return this.f7778v;
    }

    @Override // m0.o
    public boolean g(String str) {
        return this.f7758b.b((byte[]) i2.a.i(this.f7777u), str);
    }

    @Override // m0.o
    public final int getState() {
        return this.f7771o;
    }

    @Override // m0.o
    public final o.a h() {
        if (this.f7771o == 1) {
            return this.f7776t;
        }
        return null;
    }

    @Override // m0.o
    public final l0.b i() {
        return this.f7775s;
    }

    public boolean r(byte[] bArr) {
        return Arrays.equals(this.f7777u, bArr);
    }

    public void z(int i6) {
        if (i6 != 2) {
            return;
        }
        y();
    }
}
