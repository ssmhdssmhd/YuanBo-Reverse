package i0;

import android.util.Base64;
import h0.m4;
import i0.c;
import i0.n3;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import l1.v;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class r1 implements n3 {

    /* renamed from: h, reason: collision with root package name */
    public static final l2.p<String> f5449h = new l2.p() { // from class: i0.q1
        @Override // l2.p
        public final Object get() {
            String k6;
            k6 = r1.k();
            return k6;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final Random f5450i = new Random();

    /* renamed from: a, reason: collision with root package name */
    private final m4.d f5451a;

    /* renamed from: b, reason: collision with root package name */
    private final m4.b f5452b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<String, a> f5453c;

    /* renamed from: d, reason: collision with root package name */
    private final l2.p<String> f5454d;

    /* renamed from: e, reason: collision with root package name */
    private n3.a f5455e;

    /* renamed from: f, reason: collision with root package name */
    private m4 f5456f;

    /* renamed from: g, reason: collision with root package name */
    private String f5457g;

    private final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f5458a;

        /* renamed from: b, reason: collision with root package name */
        private int f5459b;

        /* renamed from: c, reason: collision with root package name */
        private long f5460c;

        /* renamed from: d, reason: collision with root package name */
        private v.b f5461d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f5462e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f5463f;

        public a(String str, int i6, v.b bVar) {
            this.f5458a = str;
            this.f5459b = i6;
            this.f5460c = bVar == null ? -1L : bVar.f7440d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.f5461d = bVar;
        }

        private int l(m4 m4Var, m4 m4Var2, int i6) {
            if (i6 >= m4Var.t()) {
                if (i6 < m4Var2.t()) {
                    return i6;
                }
                return -1;
            }
            m4Var.r(i6, r1.this.f5451a);
            for (int i7 = r1.this.f5451a.f4705s; i7 <= r1.this.f5451a.f4706t; i7++) {
                int f6 = m4Var2.f(m4Var.q(i7));
                if (f6 != -1) {
                    return m4Var2.j(f6, r1.this.f5452b).f4677c;
                }
            }
            return -1;
        }

        public boolean i(int i6, v.b bVar) {
            if (bVar == null) {
                return i6 == this.f5459b;
            }
            v.b bVar2 = this.f5461d;
            return bVar2 == null ? !bVar.b() && bVar.f7440d == this.f5460c : bVar.f7440d == bVar2.f7440d && bVar.f7438b == bVar2.f7438b && bVar.f7439c == bVar2.f7439c;
        }

        public boolean j(c.a aVar) {
            v.b bVar = aVar.f5286d;
            if (bVar == null) {
                return this.f5459b != aVar.f5285c;
            }
            long j6 = this.f5460c;
            if (j6 == -1) {
                return false;
            }
            if (bVar.f7440d > j6) {
                return true;
            }
            if (this.f5461d == null) {
                return false;
            }
            int f6 = aVar.f5284b.f(bVar.f7437a);
            int f7 = aVar.f5284b.f(this.f5461d.f7437a);
            v.b bVar2 = aVar.f5286d;
            if (bVar2.f7440d < this.f5461d.f7440d || f6 < f7) {
                return false;
            }
            if (f6 > f7) {
                return true;
            }
            boolean b6 = bVar2.b();
            v.b bVar3 = aVar.f5286d;
            if (!b6) {
                int i6 = bVar3.f7441e;
                return i6 == -1 || i6 > this.f5461d.f7438b;
            }
            int i7 = bVar3.f7438b;
            int i8 = bVar3.f7439c;
            v.b bVar4 = this.f5461d;
            int i9 = bVar4.f7438b;
            if (i7 <= i9) {
                return i7 == i9 && i8 > bVar4.f7439c;
            }
            return true;
        }

        public void k(int i6, v.b bVar) {
            if (this.f5460c == -1 && i6 == this.f5459b && bVar != null) {
                this.f5460c = bVar.f7440d;
            }
        }

        public boolean m(m4 m4Var, m4 m4Var2) {
            int l6 = l(m4Var, m4Var2, this.f5459b);
            this.f5459b = l6;
            if (l6 == -1) {
                return false;
            }
            v.b bVar = this.f5461d;
            return bVar == null || m4Var2.f(bVar.f7437a) != -1;
        }
    }

    public r1() {
        this(f5449h);
    }

    public r1(l2.p<String> pVar) {
        this.f5454d = pVar;
        this.f5451a = new m4.d();
        this.f5452b = new m4.b();
        this.f5453c = new HashMap<>();
        this.f5456f = m4.f4664a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k() {
        byte[] bArr = new byte[12];
        f5450i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private a l(int i6, v.b bVar) {
        a aVar = null;
        long j6 = Long.MAX_VALUE;
        for (a aVar2 : this.f5453c.values()) {
            aVar2.k(i6, bVar);
            if (aVar2.i(i6, bVar)) {
                long j7 = aVar2.f5460c;
                if (j7 == -1 || j7 < j6) {
                    aVar = aVar2;
                    j6 = j7;
                } else if (j7 == j6 && ((a) i2.c1.j(aVar)).f5461d != null && aVar2.f5461d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = this.f5454d.get();
        a aVar3 = new a(str, i6, bVar);
        this.f5453c.put(str, aVar3);
        return aVar3;
    }

    @RequiresNonNull({"listener"})
    private void m(c.a aVar) {
        if (aVar.f5284b.u()) {
            this.f5457g = null;
            return;
        }
        a aVar2 = this.f5453c.get(this.f5457g);
        a l6 = l(aVar.f5285c, aVar.f5286d);
        this.f5457g = l6.f5458a;
        b(aVar);
        v.b bVar = aVar.f5286d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.f5460c == aVar.f5286d.f7440d && aVar2.f5461d != null && aVar2.f5461d.f7438b == aVar.f5286d.f7438b && aVar2.f5461d.f7439c == aVar.f5286d.f7439c) {
            return;
        }
        v.b bVar2 = aVar.f5286d;
        this.f5455e.w0(aVar, l(aVar.f5285c, new v.b(bVar2.f7437a, bVar2.f7440d)).f5458a, l6.f5458a);
    }

    @Override // i0.n3
    public synchronized String a() {
        return this.f5457g;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e1 A[Catch: all -> 0x0118, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x0014, B:12:0x0025, B:14:0x0030, B:20:0x003a, B:23:0x004b, B:25:0x0057, B:26:0x005d, B:28:0x0061, B:30:0x0067, B:32:0x0080, B:33:0x00db, B:35:0x00e1, B:36:0x00f7, B:38:0x0103, B:40:0x0109), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00f3  */
    @Override // i0.n3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void b(i0.c.a r25) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i0.r1.b(i0.c$a):void");
    }

    @Override // i0.n3
    public synchronized void c(c.a aVar) {
        n3.a aVar2;
        this.f5457g = null;
        Iterator<a> it = this.f5453c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            it.remove();
            if (next.f5462e && (aVar2 = this.f5455e) != null) {
                aVar2.n0(aVar, next.f5458a, false);
            }
        }
    }

    @Override // i0.n3
    public synchronized void d(c.a aVar) {
        i2.a.e(this.f5455e);
        m4 m4Var = this.f5456f;
        this.f5456f = aVar.f5284b;
        Iterator<a> it = this.f5453c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (!next.m(m4Var, this.f5456f) || next.j(aVar)) {
                it.remove();
                if (next.f5462e) {
                    if (next.f5458a.equals(this.f5457g)) {
                        this.f5457g = null;
                    }
                    this.f5455e.n0(aVar, next.f5458a, false);
                }
            }
        }
        m(aVar);
    }

    @Override // i0.n3
    public synchronized String e(m4 m4Var, v.b bVar) {
        return l(m4Var.l(bVar.f7437a, this.f5452b).f4677c, bVar).f5458a;
    }

    @Override // i0.n3
    public void f(n3.a aVar) {
        this.f5455e = aVar;
    }

    @Override // i0.n3
    public synchronized void g(c.a aVar, int i6) {
        i2.a.e(this.f5455e);
        boolean z5 = i6 == 0;
        Iterator<a> it = this.f5453c.values().iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (next.j(aVar)) {
                it.remove();
                if (next.f5462e) {
                    boolean equals = next.f5458a.equals(this.f5457g);
                    boolean z6 = z5 && equals && next.f5463f;
                    if (equals) {
                        this.f5457g = null;
                    }
                    this.f5455e.n0(aVar, next.f5458a, z6);
                }
            }
        }
        m(aVar);
    }
}
