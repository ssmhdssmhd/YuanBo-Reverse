package m0;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import h0.y1;
import i0.o3;
import i2.c1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import m0.g;
import m0.g0;
import m0.h;
import m0.m;
import m0.o;
import m0.w;
import m0.y;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* loaded from: classes.dex */
public class h implements y {

    /* renamed from: c, reason: collision with root package name */
    private final UUID f7794c;

    /* renamed from: d, reason: collision with root package name */
    private final g0.c f7795d;

    /* renamed from: e, reason: collision with root package name */
    private final s0 f7796e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<String, String> f7797f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f7798g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f7799h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f7800i;

    /* renamed from: j, reason: collision with root package name */
    private final g f7801j;

    /* renamed from: k, reason: collision with root package name */
    private final g2.h0 f7802k;

    /* renamed from: l, reason: collision with root package name */
    private final C0113h f7803l;

    /* renamed from: m, reason: collision with root package name */
    private final long f7804m;

    /* renamed from: n, reason: collision with root package name */
    private final List<m0.g> f7805n;

    /* renamed from: o, reason: collision with root package name */
    private final Set<f> f7806o;

    /* renamed from: p, reason: collision with root package name */
    private final Set<m0.g> f7807p;

    /* renamed from: q, reason: collision with root package name */
    private int f7808q;

    /* renamed from: r, reason: collision with root package name */
    private g0 f7809r;

    /* renamed from: s, reason: collision with root package name */
    private m0.g f7810s;

    /* renamed from: t, reason: collision with root package name */
    private m0.g f7811t;

    /* renamed from: u, reason: collision with root package name */
    private Looper f7812u;

    /* renamed from: v, reason: collision with root package name */
    private Handler f7813v;

    /* renamed from: w, reason: collision with root package name */
    private int f7814w;

    /* renamed from: x, reason: collision with root package name */
    private byte[] f7815x;

    /* renamed from: y, reason: collision with root package name */
    private o3 f7816y;

    /* renamed from: z, reason: collision with root package name */
    volatile d f7817z;

    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        private boolean f7821d;

        /* renamed from: f, reason: collision with root package name */
        private boolean f7823f;

        /* renamed from: a, reason: collision with root package name */
        private final HashMap<String, String> f7818a = new HashMap<>();

        /* renamed from: b, reason: collision with root package name */
        private UUID f7819b = h0.p.f4774d;

        /* renamed from: c, reason: collision with root package name */
        private g0.c f7820c = o0.f7860d;

        /* renamed from: g, reason: collision with root package name */
        private g2.h0 f7824g = new g2.y();

        /* renamed from: e, reason: collision with root package name */
        private int[] f7822e = new int[0];

        /* renamed from: h, reason: collision with root package name */
        private long f7825h = 300000;

        public h a(s0 s0Var) {
            return new h(this.f7819b, this.f7820c, s0Var, this.f7818a, this.f7821d, this.f7822e, this.f7823f, this.f7824g, this.f7825h);
        }

        public b b(Map<String, String> map) {
            this.f7818a.clear();
            if (map != null) {
                this.f7818a.putAll(map);
            }
            return this;
        }

        public b c(boolean z5) {
            this.f7821d = z5;
            return this;
        }

        public b d(boolean z5) {
            this.f7823f = z5;
            return this;
        }

        public b e(int... iArr) {
            for (int i6 : iArr) {
                boolean z5 = true;
                if (i6 != 2 && i6 != 1) {
                    z5 = false;
                }
                i2.a.a(z5);
            }
            this.f7822e = (int[]) iArr.clone();
            return this;
        }

        public b f(UUID uuid, g0.c cVar) {
            this.f7819b = (UUID) i2.a.e(uuid);
            this.f7820c = (g0.c) i2.a.e(cVar);
            return this;
        }
    }

    private class c implements g0.b {
        private c() {
        }

        @Override // m0.g0.b
        public void a(g0 g0Var, byte[] bArr, int i6, int i7, byte[] bArr2) {
            ((d) i2.a.e(h.this.f7817z)).obtainMessage(i6, bArr).sendToTarget();
        }
    }

    private class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (m0.g gVar : h.this.f7805n) {
                if (gVar.r(bArr)) {
                    gVar.z(message.what);
                    return;
                }
            }
        }
    }

    public static final class e extends Exception {
        private e(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class f implements y.b {

        /* renamed from: b, reason: collision with root package name */
        private final w.a f7828b;

        /* renamed from: c, reason: collision with root package name */
        private o f7829c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f7830d;

        public f(w.a aVar) {
            this.f7828b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(y1 y1Var) {
            if (h.this.f7808q == 0 || this.f7830d) {
                return;
            }
            h hVar = h.this;
            this.f7829c = hVar.u((Looper) i2.a.e(hVar.f7812u), this.f7828b, y1Var, false);
            h.this.f7806o.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            if (this.f7830d) {
                return;
            }
            o oVar = this.f7829c;
            if (oVar != null) {
                oVar.e(this.f7828b);
            }
            h.this.f7806o.remove(this);
            this.f7830d = true;
        }

        @Override // m0.y.b
        public void a() {
            c1.M0((Handler) i2.a.e(h.this.f7813v), new Runnable() { // from class: m0.i
                @Override // java.lang.Runnable
                public final void run() {
                    h.f.this.f();
                }
            });
        }

        public void d(final y1 y1Var) {
            ((Handler) i2.a.e(h.this.f7813v)).post(new Runnable() { // from class: m0.j
                @Override // java.lang.Runnable
                public final void run() {
                    h.f.this.e(y1Var);
                }
            });
        }
    }

    private class g implements g.a {

        /* renamed from: a, reason: collision with root package name */
        private final Set<m0.g> f7832a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        private m0.g f7833b;

        public g(h hVar) {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // m0.g.a
        public void a() {
            this.f7833b = null;
            m2.q m6 = m2.q.m(this.f7832a);
            this.f7832a.clear();
            m2.s0 it = m6.iterator();
            while (it.hasNext()) {
                ((m0.g) it.next()).A();
            }
        }

        @Override // m0.g.a
        public void b(m0.g gVar) {
            this.f7832a.add(gVar);
            if (this.f7833b != null) {
                return;
            }
            this.f7833b = gVar;
            gVar.F();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // m0.g.a
        public void c(Exception exc, boolean z5) {
            this.f7833b = null;
            m2.q m6 = m2.q.m(this.f7832a);
            this.f7832a.clear();
            m2.s0 it = m6.iterator();
            while (it.hasNext()) {
                ((m0.g) it.next()).B(exc, z5);
            }
        }

        public void d(m0.g gVar) {
            this.f7832a.remove(gVar);
            if (this.f7833b == gVar) {
                this.f7833b = null;
                if (this.f7832a.isEmpty()) {
                    return;
                }
                m0.g next = this.f7832a.iterator().next();
                this.f7833b = next;
                next.F();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m0.h$h, reason: collision with other inner class name */
    class C0113h implements g.b {
        private C0113h() {
        }

        @Override // m0.g.b
        public void a(m0.g gVar, int i6) {
            if (h.this.f7804m != -9223372036854775807L) {
                h.this.f7807p.remove(gVar);
                ((Handler) i2.a.e(h.this.f7813v)).removeCallbacksAndMessages(gVar);
            }
        }

        @Override // m0.g.b
        public void b(final m0.g gVar, int i6) {
            if (i6 == 1 && h.this.f7808q > 0 && h.this.f7804m != -9223372036854775807L) {
                h.this.f7807p.add(gVar);
                ((Handler) i2.a.e(h.this.f7813v)).postAtTime(new Runnable() { // from class: m0.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.this.e(null);
                    }
                }, gVar, SystemClock.uptimeMillis() + h.this.f7804m);
            } else if (i6 == 0) {
                h.this.f7805n.remove(gVar);
                if (h.this.f7810s == gVar) {
                    h.this.f7810s = null;
                }
                if (h.this.f7811t == gVar) {
                    h.this.f7811t = null;
                }
                h.this.f7801j.d(gVar);
                if (h.this.f7804m != -9223372036854775807L) {
                    ((Handler) i2.a.e(h.this.f7813v)).removeCallbacksAndMessages(gVar);
                    h.this.f7807p.remove(gVar);
                }
            }
            h.this.D();
        }
    }

    private h(UUID uuid, g0.c cVar, s0 s0Var, HashMap<String, String> hashMap, boolean z5, int[] iArr, boolean z6, g2.h0 h0Var, long j6) {
        i2.a.e(uuid);
        i2.a.b(!h0.p.f4772b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f7794c = uuid;
        this.f7795d = cVar;
        this.f7796e = s0Var;
        this.f7797f = hashMap;
        this.f7798g = z5;
        this.f7799h = iArr;
        this.f7800i = z6;
        this.f7802k = h0Var;
        this.f7801j = new g(this);
        this.f7803l = new C0113h();
        this.f7814w = 0;
        this.f7805n = new ArrayList();
        this.f7806o = m2.p0.h();
        this.f7807p = m2.p0.h();
        this.f7804m = j6;
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    private synchronized void A(Looper looper) {
        Looper looper2 = this.f7812u;
        if (looper2 == null) {
            this.f7812u = looper;
            this.f7813v = new Handler(looper);
        } else {
            i2.a.g(looper2 == looper);
            i2.a.e(this.f7813v);
        }
    }

    private o B(int i6, boolean z5) {
        g0 g0Var = (g0) i2.a.e(this.f7809r);
        if ((g0Var.l() == 2 && h0.f7835d) || c1.A0(this.f7799h, i6) == -1 || g0Var.l() == 1) {
            return null;
        }
        m0.g gVar = this.f7810s;
        if (gVar == null) {
            m0.g y5 = y(m2.q.q(), true, null, z5);
            this.f7805n.add(y5);
            this.f7810s = y5;
        } else {
            gVar.b(null);
        }
        return this.f7810s;
    }

    private void C(Looper looper) {
        if (this.f7817z == null) {
            this.f7817z = new d(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        if (this.f7809r != null && this.f7808q == 0 && this.f7805n.isEmpty() && this.f7806o.isEmpty()) {
            ((g0) i2.a.e(this.f7809r)).a();
            this.f7809r = null;
        }
    }

    private void E() {
        m2.s0 it = m2.s.k(this.f7807p).iterator();
        while (it.hasNext()) {
            ((o) it.next()).e(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void F() {
        m2.s0 it = m2.s.k(this.f7806o).iterator();
        while (it.hasNext()) {
            ((f) it.next()).a();
        }
    }

    private void H(o oVar, w.a aVar) {
        oVar.e(aVar);
        if (this.f7804m != -9223372036854775807L) {
            oVar.e(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public o u(Looper looper, w.a aVar, y1 y1Var, boolean z5) {
        List<m.b> list;
        C(looper);
        m mVar = y1Var.f5069s;
        if (mVar == null) {
            return B(i2.x.k(y1Var.f5066p), z5);
        }
        m0.g gVar = null;
        Object[] objArr = 0;
        if (this.f7815x == null) {
            list = z((m) i2.a.e(mVar), this.f7794c, false);
            if (list.isEmpty()) {
                e eVar = new e(this.f7794c);
                i2.t.d("DefaultDrmSessionMgr", "DRM error", eVar);
                if (aVar != null) {
                    aVar.l(eVar);
                }
                return new e0(new o.a(eVar, 6003));
            }
        } else {
            list = null;
        }
        if (this.f7798g) {
            Iterator<m0.g> it = this.f7805n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                m0.g next = it.next();
                if (c1.c(next.f7757a, list)) {
                    gVar = next;
                    break;
                }
            }
        } else {
            gVar = this.f7811t;
        }
        if (gVar == null) {
            gVar = y(list, false, aVar, z5);
            if (!this.f7798g) {
                this.f7811t = gVar;
            }
            this.f7805n.add(gVar);
        } else {
            gVar.b(aVar);
        }
        return gVar;
    }

    private static boolean v(o oVar) {
        return oVar.getState() == 1 && (c1.f5548a < 19 || (((o.a) i2.a.e(oVar.h())).getCause() instanceof ResourceBusyException));
    }

    private boolean w(m mVar) {
        if (this.f7815x != null) {
            return true;
        }
        if (z(mVar, this.f7794c, true).isEmpty()) {
            if (mVar.f7853d != 1 || !mVar.h(0).g(h0.p.f4772b)) {
                return false;
            }
            i2.t.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f7794c);
        }
        String str = mVar.f7852c;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? c1.f5548a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    private m0.g x(List<m.b> list, boolean z5, w.a aVar) {
        i2.a.e(this.f7809r);
        m0.g gVar = new m0.g(this.f7794c, this.f7809r, this.f7801j, this.f7803l, list, this.f7814w, this.f7800i | z5, z5, this.f7815x, this.f7797f, this.f7796e, (Looper) i2.a.e(this.f7812u), this.f7802k, (o3) i2.a.e(this.f7816y));
        gVar.b(aVar);
        if (this.f7804m != -9223372036854775807L) {
            gVar.b(null);
        }
        return gVar;
    }

    private m0.g y(List<m.b> list, boolean z5, w.a aVar, boolean z6) {
        m0.g x5 = x(list, z5, aVar);
        if (v(x5) && !this.f7807p.isEmpty()) {
            E();
            H(x5, aVar);
            x5 = x(list, z5, aVar);
        }
        if (!v(x5) || !z6 || this.f7806o.isEmpty()) {
            return x5;
        }
        F();
        if (!this.f7807p.isEmpty()) {
            E();
        }
        H(x5, aVar);
        return x(list, z5, aVar);
    }

    private static List<m.b> z(m mVar, UUID uuid, boolean z5) {
        ArrayList arrayList = new ArrayList(mVar.f7853d);
        for (int i6 = 0; i6 < mVar.f7853d; i6++) {
            m.b h6 = mVar.h(i6);
            if ((h6.g(uuid) || (h0.p.f4773c.equals(uuid) && h6.g(h0.p.f4772b))) && (h6.f7858e != null || z5)) {
                arrayList.add(h6);
            }
        }
        return arrayList;
    }

    public void G(int i6, byte[] bArr) {
        i2.a.g(this.f7805n.isEmpty());
        if (i6 == 1 || i6 == 3) {
            i2.a.e(bArr);
        }
        this.f7814w = i6;
        this.f7815x = bArr;
    }

    @Override // m0.y
    public final void a() {
        int i6 = this.f7808q - 1;
        this.f7808q = i6;
        if (i6 != 0) {
            return;
        }
        if (this.f7804m != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f7805n);
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                ((m0.g) arrayList.get(i7)).e(null);
            }
        }
        F();
        D();
    }

    @Override // m0.y
    public void b(Looper looper, o3 o3Var) {
        A(looper);
        this.f7816y = o3Var;
    }

    @Override // m0.y
    public int c(y1 y1Var) {
        int l6 = ((g0) i2.a.e(this.f7809r)).l();
        m mVar = y1Var.f5069s;
        if (mVar != null) {
            if (w(mVar)) {
                return l6;
            }
            return 1;
        }
        if (c1.A0(this.f7799h, i2.x.k(y1Var.f5066p)) != -1) {
            return l6;
        }
        return 0;
    }

    @Override // m0.y
    public y.b d(w.a aVar, y1 y1Var) {
        i2.a.g(this.f7808q > 0);
        i2.a.i(this.f7812u);
        f fVar = new f(aVar);
        fVar.d(y1Var);
        return fVar;
    }

    @Override // m0.y
    public final void e() {
        int i6 = this.f7808q;
        this.f7808q = i6 + 1;
        if (i6 != 0) {
            return;
        }
        if (this.f7809r == null) {
            g0 a6 = this.f7795d.a(this.f7794c);
            this.f7809r = a6;
            a6.j(new c());
        } else if (this.f7804m != -9223372036854775807L) {
            for (int i7 = 0; i7 < this.f7805n.size(); i7++) {
                this.f7805n.get(i7).b(null);
            }
        }
    }

    @Override // m0.y
    public o f(w.a aVar, y1 y1Var) {
        i2.a.g(this.f7808q > 0);
        i2.a.i(this.f7812u);
        return u(this.f7812u, aVar, y1Var, true);
    }
}
