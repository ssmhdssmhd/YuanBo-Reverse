package h0;

import android.net.Uri;
import android.os.Bundle;
import h0.h2;
import h0.o;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import m2.q;

/* loaded from: classes.dex */
public final class h2 implements o {

    /* renamed from: m, reason: collision with root package name */
    public static final h2 f4398m = new c().a();

    /* renamed from: n, reason: collision with root package name */
    private static final String f4399n = i2.c1.s0(0);

    /* renamed from: o, reason: collision with root package name */
    private static final String f4400o = i2.c1.s0(1);

    /* renamed from: p, reason: collision with root package name */
    private static final String f4401p = i2.c1.s0(2);

    /* renamed from: q, reason: collision with root package name */
    private static final String f4402q = i2.c1.s0(3);

    /* renamed from: r, reason: collision with root package name */
    private static final String f4403r = i2.c1.s0(4);

    /* renamed from: s, reason: collision with root package name */
    public static final o.a<h2> f4404s = new o.a() { // from class: h0.g2
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            h2 c6;
            c6 = h2.c(bundle);
            return c6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final String f4405a;

    /* renamed from: b, reason: collision with root package name */
    public final h f4406b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    public final i f4407c;

    /* renamed from: d, reason: collision with root package name */
    public final g f4408d;

    /* renamed from: e, reason: collision with root package name */
    public final m2 f4409e;

    /* renamed from: j, reason: collision with root package name */
    public final d f4410j;

    /* renamed from: k, reason: collision with root package name */
    @Deprecated
    public final e f4411k;

    /* renamed from: l, reason: collision with root package name */
    public final j f4412l;

    public static final class b {
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        private String f4413a;

        /* renamed from: b, reason: collision with root package name */
        private Uri f4414b;

        /* renamed from: c, reason: collision with root package name */
        private String f4415c;

        /* renamed from: d, reason: collision with root package name */
        private d.a f4416d;

        /* renamed from: e, reason: collision with root package name */
        private f.a f4417e;

        /* renamed from: f, reason: collision with root package name */
        private List<k1.c> f4418f;

        /* renamed from: g, reason: collision with root package name */
        private String f4419g;

        /* renamed from: h, reason: collision with root package name */
        private m2.q<l> f4420h;

        /* renamed from: i, reason: collision with root package name */
        private Object f4421i;

        /* renamed from: j, reason: collision with root package name */
        private m2 f4422j;

        /* renamed from: k, reason: collision with root package name */
        private g.a f4423k;

        /* renamed from: l, reason: collision with root package name */
        private j f4424l;

        public c() {
            this.f4416d = new d.a();
            this.f4417e = new f.a();
            this.f4418f = Collections.emptyList();
            this.f4420h = m2.q.q();
            this.f4423k = new g.a();
            this.f4424l = j.f4487d;
        }

        private c(h2 h2Var) {
            this();
            this.f4416d = h2Var.f4410j.b();
            this.f4413a = h2Var.f4405a;
            this.f4422j = h2Var.f4409e;
            this.f4423k = h2Var.f4408d.b();
            this.f4424l = h2Var.f4412l;
            h hVar = h2Var.f4406b;
            if (hVar != null) {
                this.f4419g = hVar.f4483e;
                this.f4415c = hVar.f4480b;
                this.f4414b = hVar.f4479a;
                this.f4418f = hVar.f4482d;
                this.f4420h = hVar.f4484f;
                this.f4421i = hVar.f4486h;
                f fVar = hVar.f4481c;
                this.f4417e = fVar != null ? fVar.b() : new f.a();
            }
        }

        public h2 a() {
            i iVar;
            i2.a.g(this.f4417e.f4455b == null || this.f4417e.f4454a != null);
            Uri uri = this.f4414b;
            if (uri != null) {
                iVar = new i(uri, this.f4415c, this.f4417e.f4454a != null ? this.f4417e.i() : null, null, this.f4418f, this.f4419g, this.f4420h, this.f4421i);
            } else {
                iVar = null;
            }
            String str = this.f4413a;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            e g6 = this.f4416d.g();
            g f6 = this.f4423k.f();
            m2 m2Var = this.f4422j;
            if (m2Var == null) {
                m2Var = m2.M;
            }
            return new h2(str2, g6, iVar, f6, m2Var, this.f4424l);
        }

        public c b(String str) {
            this.f4419g = str;
            return this;
        }

        public c c(String str) {
            this.f4413a = (String) i2.a.e(str);
            return this;
        }

        public c d(Object obj) {
            this.f4421i = obj;
            return this;
        }

        public c e(Uri uri) {
            this.f4414b = uri;
            return this;
        }
    }

    public static class d implements o {

        /* renamed from: j, reason: collision with root package name */
        public static final d f4425j = new a().f();

        /* renamed from: k, reason: collision with root package name */
        private static final String f4426k = i2.c1.s0(0);

        /* renamed from: l, reason: collision with root package name */
        private static final String f4427l = i2.c1.s0(1);

        /* renamed from: m, reason: collision with root package name */
        private static final String f4428m = i2.c1.s0(2);

        /* renamed from: n, reason: collision with root package name */
        private static final String f4429n = i2.c1.s0(3);

        /* renamed from: o, reason: collision with root package name */
        private static final String f4430o = i2.c1.s0(4);

        /* renamed from: p, reason: collision with root package name */
        public static final o.a<e> f4431p = new o.a() { // from class: h0.i2
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                h2.e c6;
                c6 = h2.d.c(bundle);
                return c6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f4432a;

        /* renamed from: b, reason: collision with root package name */
        public final long f4433b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f4434c;

        /* renamed from: d, reason: collision with root package name */
        public final boolean f4435d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f4436e;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f4437a;

            /* renamed from: b, reason: collision with root package name */
            private long f4438b;

            /* renamed from: c, reason: collision with root package name */
            private boolean f4439c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f4440d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f4441e;

            public a() {
                this.f4438b = Long.MIN_VALUE;
            }

            private a(d dVar) {
                this.f4437a = dVar.f4432a;
                this.f4438b = dVar.f4433b;
                this.f4439c = dVar.f4434c;
                this.f4440d = dVar.f4435d;
                this.f4441e = dVar.f4436e;
            }

            public d f() {
                return g();
            }

            @Deprecated
            public e g() {
                return new e(this);
            }

            public a h(long j6) {
                i2.a.a(j6 == Long.MIN_VALUE || j6 >= 0);
                this.f4438b = j6;
                return this;
            }

            public a i(boolean z5) {
                this.f4440d = z5;
                return this;
            }

            public a j(boolean z5) {
                this.f4439c = z5;
                return this;
            }

            public a k(long j6) {
                i2.a.a(j6 >= 0);
                this.f4437a = j6;
                return this;
            }

            public a l(boolean z5) {
                this.f4441e = z5;
                return this;
            }
        }

        private d(a aVar) {
            this.f4432a = aVar.f4437a;
            this.f4433b = aVar.f4438b;
            this.f4434c = aVar.f4439c;
            this.f4435d = aVar.f4440d;
            this.f4436e = aVar.f4441e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ e c(Bundle bundle) {
            a aVar = new a();
            String str = f4426k;
            d dVar = f4425j;
            return aVar.k(bundle.getLong(str, dVar.f4432a)).h(bundle.getLong(f4427l, dVar.f4433b)).j(bundle.getBoolean(f4428m, dVar.f4434c)).i(bundle.getBoolean(f4429n, dVar.f4435d)).l(bundle.getBoolean(f4430o, dVar.f4436e)).g();
        }

        public a b() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.f4432a == dVar.f4432a && this.f4433b == dVar.f4433b && this.f4434c == dVar.f4434c && this.f4435d == dVar.f4435d && this.f4436e == dVar.f4436e;
        }

        public int hashCode() {
            long j6 = this.f4432a;
            int i6 = ((int) (j6 ^ (j6 >>> 32))) * 31;
            long j7 = this.f4433b;
            return ((((((i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.f4434c ? 1 : 0)) * 31) + (this.f4435d ? 1 : 0)) * 31) + (this.f4436e ? 1 : 0);
        }
    }

    @Deprecated
    public static final class e extends d {

        /* renamed from: q, reason: collision with root package name */
        public static final e f4442q = new d.a().g();

        private e(d.a aVar) {
            super(aVar);
        }
    }

    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f4443a;

        /* renamed from: b, reason: collision with root package name */
        @Deprecated
        public final UUID f4444b;

        /* renamed from: c, reason: collision with root package name */
        public final Uri f4445c;

        /* renamed from: d, reason: collision with root package name */
        @Deprecated
        public final m2.r<String, String> f4446d;

        /* renamed from: e, reason: collision with root package name */
        public final m2.r<String, String> f4447e;

        /* renamed from: f, reason: collision with root package name */
        public final boolean f4448f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f4449g;

        /* renamed from: h, reason: collision with root package name */
        public final boolean f4450h;

        /* renamed from: i, reason: collision with root package name */
        @Deprecated
        public final m2.q<Integer> f4451i;

        /* renamed from: j, reason: collision with root package name */
        public final m2.q<Integer> f4452j;

        /* renamed from: k, reason: collision with root package name */
        private final byte[] f4453k;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private UUID f4454a;

            /* renamed from: b, reason: collision with root package name */
            private Uri f4455b;

            /* renamed from: c, reason: collision with root package name */
            private m2.r<String, String> f4456c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f4457d;

            /* renamed from: e, reason: collision with root package name */
            private boolean f4458e;

            /* renamed from: f, reason: collision with root package name */
            private boolean f4459f;

            /* renamed from: g, reason: collision with root package name */
            private m2.q<Integer> f4460g;

            /* renamed from: h, reason: collision with root package name */
            private byte[] f4461h;

            @Deprecated
            private a() {
                this.f4456c = m2.r.j();
                this.f4460g = m2.q.q();
            }

            private a(f fVar) {
                this.f4454a = fVar.f4443a;
                this.f4455b = fVar.f4445c;
                this.f4456c = fVar.f4447e;
                this.f4457d = fVar.f4448f;
                this.f4458e = fVar.f4449g;
                this.f4459f = fVar.f4450h;
                this.f4460g = fVar.f4452j;
                this.f4461h = fVar.f4453k;
            }

            public f i() {
                return new f(this);
            }
        }

        private f(a aVar) {
            i2.a.g((aVar.f4459f && aVar.f4455b == null) ? false : true);
            UUID uuid = (UUID) i2.a.e(aVar.f4454a);
            this.f4443a = uuid;
            this.f4444b = uuid;
            this.f4445c = aVar.f4455b;
            this.f4446d = aVar.f4456c;
            this.f4447e = aVar.f4456c;
            this.f4448f = aVar.f4457d;
            this.f4450h = aVar.f4459f;
            this.f4449g = aVar.f4458e;
            this.f4451i = aVar.f4460g;
            this.f4452j = aVar.f4460g;
            this.f4453k = aVar.f4461h != null ? Arrays.copyOf(aVar.f4461h, aVar.f4461h.length) : null;
        }

        public a b() {
            return new a();
        }

        public byte[] c() {
            byte[] bArr = this.f4453k;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            return this.f4443a.equals(fVar.f4443a) && i2.c1.c(this.f4445c, fVar.f4445c) && i2.c1.c(this.f4447e, fVar.f4447e) && this.f4448f == fVar.f4448f && this.f4450h == fVar.f4450h && this.f4449g == fVar.f4449g && this.f4452j.equals(fVar.f4452j) && Arrays.equals(this.f4453k, fVar.f4453k);
        }

        public int hashCode() {
            int hashCode = this.f4443a.hashCode() * 31;
            Uri uri = this.f4445c;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.f4447e.hashCode()) * 31) + (this.f4448f ? 1 : 0)) * 31) + (this.f4450h ? 1 : 0)) * 31) + (this.f4449g ? 1 : 0)) * 31) + this.f4452j.hashCode()) * 31) + Arrays.hashCode(this.f4453k);
        }
    }

    public static final class g implements o {

        /* renamed from: j, reason: collision with root package name */
        public static final g f4462j = new a().f();

        /* renamed from: k, reason: collision with root package name */
        private static final String f4463k = i2.c1.s0(0);

        /* renamed from: l, reason: collision with root package name */
        private static final String f4464l = i2.c1.s0(1);

        /* renamed from: m, reason: collision with root package name */
        private static final String f4465m = i2.c1.s0(2);

        /* renamed from: n, reason: collision with root package name */
        private static final String f4466n = i2.c1.s0(3);

        /* renamed from: o, reason: collision with root package name */
        private static final String f4467o = i2.c1.s0(4);

        /* renamed from: p, reason: collision with root package name */
        public static final o.a<g> f4468p = new o.a() { // from class: h0.j2
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                h2.g c6;
                c6 = h2.g.c(bundle);
                return c6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final long f4469a;

        /* renamed from: b, reason: collision with root package name */
        public final long f4470b;

        /* renamed from: c, reason: collision with root package name */
        public final long f4471c;

        /* renamed from: d, reason: collision with root package name */
        public final float f4472d;

        /* renamed from: e, reason: collision with root package name */
        public final float f4473e;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private long f4474a;

            /* renamed from: b, reason: collision with root package name */
            private long f4475b;

            /* renamed from: c, reason: collision with root package name */
            private long f4476c;

            /* renamed from: d, reason: collision with root package name */
            private float f4477d;

            /* renamed from: e, reason: collision with root package name */
            private float f4478e;

            public a() {
                this.f4474a = -9223372036854775807L;
                this.f4475b = -9223372036854775807L;
                this.f4476c = -9223372036854775807L;
                this.f4477d = -3.4028235E38f;
                this.f4478e = -3.4028235E38f;
            }

            private a(g gVar) {
                this.f4474a = gVar.f4469a;
                this.f4475b = gVar.f4470b;
                this.f4476c = gVar.f4471c;
                this.f4477d = gVar.f4472d;
                this.f4478e = gVar.f4473e;
            }

            public g f() {
                return new g(this);
            }

            public a g(long j6) {
                this.f4476c = j6;
                return this;
            }

            public a h(float f6) {
                this.f4478e = f6;
                return this;
            }

            public a i(long j6) {
                this.f4475b = j6;
                return this;
            }

            public a j(float f6) {
                this.f4477d = f6;
                return this;
            }

            public a k(long j6) {
                this.f4474a = j6;
                return this;
            }
        }

        @Deprecated
        public g(long j6, long j7, long j8, float f6, float f7) {
            this.f4469a = j6;
            this.f4470b = j7;
            this.f4471c = j8;
            this.f4472d = f6;
            this.f4473e = f7;
        }

        private g(a aVar) {
            this(aVar.f4474a, aVar.f4475b, aVar.f4476c, aVar.f4477d, aVar.f4478e);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ g c(Bundle bundle) {
            String str = f4463k;
            g gVar = f4462j;
            return new g(bundle.getLong(str, gVar.f4469a), bundle.getLong(f4464l, gVar.f4470b), bundle.getLong(f4465m, gVar.f4471c), bundle.getFloat(f4466n, gVar.f4472d), bundle.getFloat(f4467o, gVar.f4473e));
        }

        public a b() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            g gVar = (g) obj;
            return this.f4469a == gVar.f4469a && this.f4470b == gVar.f4470b && this.f4471c == gVar.f4471c && this.f4472d == gVar.f4472d && this.f4473e == gVar.f4473e;
        }

        public int hashCode() {
            long j6 = this.f4469a;
            long j7 = this.f4470b;
            int i6 = ((((int) (j6 ^ (j6 >>> 32))) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31;
            long j8 = this.f4471c;
            int i7 = (i6 + ((int) (j8 ^ (j8 >>> 32)))) * 31;
            float f6 = this.f4472d;
            int floatToIntBits = (i7 + (f6 != 0.0f ? Float.floatToIntBits(f6) : 0)) * 31;
            float f7 = this.f4473e;
            return floatToIntBits + (f7 != 0.0f ? Float.floatToIntBits(f7) : 0);
        }
    }

    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f4479a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4480b;

        /* renamed from: c, reason: collision with root package name */
        public final f f4481c;

        /* renamed from: d, reason: collision with root package name */
        public final List<k1.c> f4482d;

        /* renamed from: e, reason: collision with root package name */
        public final String f4483e;

        /* renamed from: f, reason: collision with root package name */
        public final m2.q<l> f4484f;

        /* renamed from: g, reason: collision with root package name */
        @Deprecated
        public final List<k> f4485g;

        /* renamed from: h, reason: collision with root package name */
        public final Object f4486h;

        private h(Uri uri, String str, f fVar, b bVar, List<k1.c> list, String str2, m2.q<l> qVar, Object obj) {
            this.f4479a = uri;
            this.f4480b = str;
            this.f4481c = fVar;
            this.f4482d = list;
            this.f4483e = str2;
            this.f4484f = qVar;
            q.a k6 = m2.q.k();
            for (int i6 = 0; i6 < qVar.size(); i6++) {
                k6.a(qVar.get(i6).a().i());
            }
            this.f4485g = k6.h();
            this.f4486h = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof h)) {
                return false;
            }
            h hVar = (h) obj;
            return this.f4479a.equals(hVar.f4479a) && i2.c1.c(this.f4480b, hVar.f4480b) && i2.c1.c(this.f4481c, hVar.f4481c) && i2.c1.c(null, null) && this.f4482d.equals(hVar.f4482d) && i2.c1.c(this.f4483e, hVar.f4483e) && this.f4484f.equals(hVar.f4484f) && i2.c1.c(this.f4486h, hVar.f4486h);
        }

        public int hashCode() {
            int hashCode = this.f4479a.hashCode() * 31;
            String str = this.f4480b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            f fVar = this.f4481c;
            int hashCode3 = (((((hashCode2 + (fVar == null ? 0 : fVar.hashCode())) * 31) + 0) * 31) + this.f4482d.hashCode()) * 31;
            String str2 = this.f4483e;
            int hashCode4 = (((hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f4484f.hashCode()) * 31;
            Object obj = this.f4486h;
            return hashCode4 + (obj != null ? obj.hashCode() : 0);
        }
    }

    @Deprecated
    public static final class i extends h {
        private i(Uri uri, String str, f fVar, b bVar, List<k1.c> list, String str2, m2.q<l> qVar, Object obj) {
            super(uri, str, fVar, bVar, list, str2, qVar, obj);
        }
    }

    public static final class j implements o {

        /* renamed from: d, reason: collision with root package name */
        public static final j f4487d = new a().d();

        /* renamed from: e, reason: collision with root package name */
        private static final String f4488e = i2.c1.s0(0);

        /* renamed from: j, reason: collision with root package name */
        private static final String f4489j = i2.c1.s0(1);

        /* renamed from: k, reason: collision with root package name */
        private static final String f4490k = i2.c1.s0(2);

        /* renamed from: l, reason: collision with root package name */
        public static final o.a<j> f4491l = new o.a() { // from class: h0.k2
            @Override // h0.o.a
            public final o a(Bundle bundle) {
                h2.j b6;
                b6 = h2.j.b(bundle);
                return b6;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final Uri f4492a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4493b;

        /* renamed from: c, reason: collision with root package name */
        public final Bundle f4494c;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f4495a;

            /* renamed from: b, reason: collision with root package name */
            private String f4496b;

            /* renamed from: c, reason: collision with root package name */
            private Bundle f4497c;

            public j d() {
                return new j(this);
            }

            public a e(Bundle bundle) {
                this.f4497c = bundle;
                return this;
            }

            public a f(Uri uri) {
                this.f4495a = uri;
                return this;
            }

            public a g(String str) {
                this.f4496b = str;
                return this;
            }
        }

        private j(a aVar) {
            this.f4492a = aVar.f4495a;
            this.f4493b = aVar.f4496b;
            this.f4494c = aVar.f4497c;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ j b(Bundle bundle) {
            return new a().f((Uri) bundle.getParcelable(f4488e)).g(bundle.getString(f4489j)).e(bundle.getBundle(f4490k)).d();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof j)) {
                return false;
            }
            j jVar = (j) obj;
            return i2.c1.c(this.f4492a, jVar.f4492a) && i2.c1.c(this.f4493b, jVar.f4493b);
        }

        public int hashCode() {
            Uri uri = this.f4492a;
            int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
            String str = this.f4493b;
            return hashCode + (str != null ? str.hashCode() : 0);
        }
    }

    @Deprecated
    public static final class k extends l {
        private k(l.a aVar) {
            super(aVar);
        }
    }

    public static class l {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f4498a;

        /* renamed from: b, reason: collision with root package name */
        public final String f4499b;

        /* renamed from: c, reason: collision with root package name */
        public final String f4500c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4501d;

        /* renamed from: e, reason: collision with root package name */
        public final int f4502e;

        /* renamed from: f, reason: collision with root package name */
        public final String f4503f;

        /* renamed from: g, reason: collision with root package name */
        public final String f4504g;

        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private Uri f4505a;

            /* renamed from: b, reason: collision with root package name */
            private String f4506b;

            /* renamed from: c, reason: collision with root package name */
            private String f4507c;

            /* renamed from: d, reason: collision with root package name */
            private int f4508d;

            /* renamed from: e, reason: collision with root package name */
            private int f4509e;

            /* renamed from: f, reason: collision with root package name */
            private String f4510f;

            /* renamed from: g, reason: collision with root package name */
            private String f4511g;

            private a(l lVar) {
                this.f4505a = lVar.f4498a;
                this.f4506b = lVar.f4499b;
                this.f4507c = lVar.f4500c;
                this.f4508d = lVar.f4501d;
                this.f4509e = lVar.f4502e;
                this.f4510f = lVar.f4503f;
                this.f4511g = lVar.f4504g;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public k i() {
                return new k(this);
            }
        }

        private l(a aVar) {
            this.f4498a = aVar.f4505a;
            this.f4499b = aVar.f4506b;
            this.f4500c = aVar.f4507c;
            this.f4501d = aVar.f4508d;
            this.f4502e = aVar.f4509e;
            this.f4503f = aVar.f4510f;
            this.f4504g = aVar.f4511g;
        }

        public a a() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof l)) {
                return false;
            }
            l lVar = (l) obj;
            return this.f4498a.equals(lVar.f4498a) && i2.c1.c(this.f4499b, lVar.f4499b) && i2.c1.c(this.f4500c, lVar.f4500c) && this.f4501d == lVar.f4501d && this.f4502e == lVar.f4502e && i2.c1.c(this.f4503f, lVar.f4503f) && i2.c1.c(this.f4504g, lVar.f4504g);
        }

        public int hashCode() {
            int hashCode = this.f4498a.hashCode() * 31;
            String str = this.f4499b;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f4500c;
            int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.f4501d) * 31) + this.f4502e) * 31;
            String str3 = this.f4503f;
            int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.f4504g;
            return hashCode4 + (str4 != null ? str4.hashCode() : 0);
        }
    }

    private h2(String str, e eVar, i iVar, g gVar, m2 m2Var, j jVar) {
        this.f4405a = str;
        this.f4406b = iVar;
        this.f4407c = iVar;
        this.f4408d = gVar;
        this.f4409e = m2Var;
        this.f4410j = eVar;
        this.f4411k = eVar;
        this.f4412l = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static h2 c(Bundle bundle) {
        String str = (String) i2.a.e(bundle.getString(f4399n, ""));
        Bundle bundle2 = bundle.getBundle(f4400o);
        g a6 = bundle2 == null ? g.f4462j : g.f4468p.a(bundle2);
        Bundle bundle3 = bundle.getBundle(f4401p);
        m2 a7 = bundle3 == null ? m2.M : m2.f4615u0.a(bundle3);
        Bundle bundle4 = bundle.getBundle(f4402q);
        e a8 = bundle4 == null ? e.f4442q : d.f4431p.a(bundle4);
        Bundle bundle5 = bundle.getBundle(f4403r);
        return new h2(str, a8, null, a6, a7, bundle5 == null ? j.f4487d : j.f4491l.a(bundle5));
    }

    public static h2 d(Uri uri) {
        return new c().e(uri).a();
    }

    public c b() {
        return new c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h2)) {
            return false;
        }
        h2 h2Var = (h2) obj;
        return i2.c1.c(this.f4405a, h2Var.f4405a) && this.f4410j.equals(h2Var.f4410j) && i2.c1.c(this.f4406b, h2Var.f4406b) && i2.c1.c(this.f4408d, h2Var.f4408d) && i2.c1.c(this.f4409e, h2Var.f4409e) && i2.c1.c(this.f4412l, h2Var.f4412l);
    }

    public int hashCode() {
        int hashCode = this.f4405a.hashCode() * 31;
        h hVar = this.f4406b;
        return ((((((((hashCode + (hVar != null ? hVar.hashCode() : 0)) * 31) + this.f4408d.hashCode()) * 31) + this.f4410j.hashCode()) * 31) + this.f4409e.hashCode()) * 31) + this.f4412l.hashCode();
    }
}
