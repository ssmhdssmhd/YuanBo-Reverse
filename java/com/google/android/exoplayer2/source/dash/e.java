package com.google.android.exoplayer2.source.dash;

import android.os.Handler;
import android.os.Message;
import g2.i;
import h0.g3;
import h0.y1;
import h0.z1;
import i2.c1;
import i2.i0;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import l1.n0;
import n1.f;
import o0.d0;
import o0.e0;

/* loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final g2.b f1987a;

    /* renamed from: b, reason: collision with root package name */
    private final b f1988b;

    /* renamed from: j, reason: collision with root package name */
    private p1.c f1992j;

    /* renamed from: k, reason: collision with root package name */
    private long f1993k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f1994l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f1995m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f1996n;

    /* renamed from: e, reason: collision with root package name */
    private final TreeMap<Long, Long> f1991e = new TreeMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f1990d = c1.x(this);

    /* renamed from: c, reason: collision with root package name */
    private final d1.b f1989c = new d1.b();

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f1997a;

        /* renamed from: b, reason: collision with root package name */
        public final long f1998b;

        public a(long j6, long j7) {
            this.f1997a = j6;
            this.f1998b = j7;
        }
    }

    public interface b {
        void a();

        void b(long j6);
    }

    public final class c implements e0 {

        /* renamed from: a, reason: collision with root package name */
        private final n0 f1999a;

        /* renamed from: b, reason: collision with root package name */
        private final z1 f2000b = new z1();

        /* renamed from: c, reason: collision with root package name */
        private final b1.e f2001c = new b1.e();

        /* renamed from: d, reason: collision with root package name */
        private long f2002d = -9223372036854775807L;

        c(g2.b bVar) {
            this.f1999a = n0.l(bVar);
        }

        private b1.e g() {
            this.f2001c.f();
            if (this.f1999a.S(this.f2000b, this.f2001c, 0, false) != -4) {
                return null;
            }
            this.f2001c.q();
            return this.f2001c;
        }

        private void k(long j6, long j7) {
            e.this.f1990d.sendMessage(e.this.f1990d.obtainMessage(1, new a(j6, j7)));
        }

        private void l() {
            while (this.f1999a.K(false)) {
                b1.e g6 = g();
                if (g6 != null) {
                    long j6 = g6.f7164e;
                    b1.a a6 = e.this.f1989c.a(g6);
                    if (a6 != null) {
                        d1.a aVar = (d1.a) a6.g(0);
                        if (e.h(aVar.f2916a, aVar.f2917b)) {
                            m(j6, aVar);
                        }
                    }
                }
            }
            this.f1999a.s();
        }

        private void m(long j6, d1.a aVar) {
            long f6 = e.f(aVar);
            if (f6 == -9223372036854775807L) {
                return;
            }
            k(j6, f6);
        }

        @Override // o0.e0
        public void a(i0 i0Var, int i6, int i7) {
            this.f1999a.d(i0Var, i6);
        }

        @Override // o0.e0
        public /* synthetic */ int b(i iVar, int i6, boolean z5) {
            return d0.a(this, iVar, i6, z5);
        }

        @Override // o0.e0
        public void c(y1 y1Var) {
            this.f1999a.c(y1Var);
        }

        @Override // o0.e0
        public /* synthetic */ void d(i0 i0Var, int i6) {
            d0.b(this, i0Var, i6);
        }

        @Override // o0.e0
        public void e(long j6, int i6, int i7, int i8, e0.a aVar) {
            this.f1999a.e(j6, i6, i7, i8, aVar);
            l();
        }

        @Override // o0.e0
        public int f(i iVar, int i6, boolean z5, int i7) {
            return this.f1999a.b(iVar, i6, z5);
        }

        public boolean h(long j6) {
            return e.this.j(j6);
        }

        public void i(f fVar) {
            long j6 = this.f2002d;
            if (j6 == -9223372036854775807L || fVar.f8206h > j6) {
                this.f2002d = fVar.f8206h;
            }
            e.this.m(fVar);
        }

        public boolean j(f fVar) {
            long j6 = this.f2002d;
            return e.this.n(j6 != -9223372036854775807L && j6 < fVar.f8205g);
        }

        public void n() {
            this.f1999a.T();
        }
    }

    public e(p1.c cVar, b bVar, g2.b bVar2) {
        this.f1992j = cVar;
        this.f1988b = bVar;
        this.f1987a = bVar2;
    }

    private Map.Entry<Long, Long> e(long j6) {
        return this.f1991e.ceilingEntry(Long.valueOf(j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long f(d1.a aVar) {
        try {
            return c1.K0(c1.D(aVar.f2920e));
        } catch (g3 unused) {
            return -9223372036854775807L;
        }
    }

    private void g(long j6, long j7) {
        Long l6 = this.f1991e.get(Long.valueOf(j7));
        if (l6 != null && l6.longValue() <= j6) {
            return;
        }
        this.f1991e.put(Long.valueOf(j7), Long.valueOf(j6));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    private void i() {
        if (this.f1994l) {
            this.f1995m = true;
            this.f1994l = false;
            this.f1988b.a();
        }
    }

    private void l() {
        this.f1988b.b(this.f1993k);
    }

    private void p() {
        Iterator<Map.Entry<Long, Long>> it = this.f1991e.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().longValue() < this.f1992j.f8552h) {
                it.remove();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f1996n) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f1997a, aVar.f1998b);
        return true;
    }

    boolean j(long j6) {
        p1.c cVar = this.f1992j;
        boolean z5 = false;
        if (!cVar.f8548d) {
            return false;
        }
        if (this.f1995m) {
            return true;
        }
        Map.Entry<Long, Long> e6 = e(cVar.f8552h);
        if (e6 != null && e6.getValue().longValue() < j6) {
            this.f1993k = e6.getKey().longValue();
            l();
            z5 = true;
        }
        if (z5) {
            i();
        }
        return z5;
    }

    public c k() {
        return new c(this.f1987a);
    }

    void m(f fVar) {
        this.f1994l = true;
    }

    boolean n(boolean z5) {
        if (!this.f1992j.f8548d) {
            return false;
        }
        if (this.f1995m) {
            return true;
        }
        if (!z5) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f1996n = true;
        this.f1990d.removeCallbacksAndMessages(null);
    }

    public void q(p1.c cVar) {
        this.f1995m = false;
        this.f1993k = -9223372036854775807L;
        this.f1992j = cVar;
        p();
    }
}
