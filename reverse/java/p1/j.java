package p1;

import android.net.Uri;
import h0.y1;
import java.util.Collections;
import java.util.List;
import m2.q;
import p1.k;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public final long f8594a;

    /* renamed from: b, reason: collision with root package name */
    public final y1 f8595b;

    /* renamed from: c, reason: collision with root package name */
    public final q<p1.b> f8596c;

    /* renamed from: d, reason: collision with root package name */
    public final long f8597d;

    /* renamed from: e, reason: collision with root package name */
    public final List<e> f8598e;

    /* renamed from: f, reason: collision with root package name */
    public final List<e> f8599f;

    /* renamed from: g, reason: collision with root package name */
    public final List<e> f8600g;

    /* renamed from: h, reason: collision with root package name */
    private final i f8601h;

    public static class b extends j implements o1.f {

        /* renamed from: i, reason: collision with root package name */
        final k.a f8602i;

        public b(long j6, y1 y1Var, List<p1.b> list, k.a aVar, List<e> list2, List<e> list3, List<e> list4) {
            super(j6, y1Var, list, aVar, list2, list3, list4);
            this.f8602i = aVar;
        }

        @Override // p1.j
        public String a() {
            return null;
        }

        @Override // p1.j
        public o1.f b() {
            return this;
        }

        @Override // p1.j
        public i c() {
            return null;
        }

        @Override // o1.f
        public long d(long j6) {
            return this.f8602i.j(j6);
        }

        @Override // o1.f
        public long e(long j6, long j7) {
            return this.f8602i.i(j6, j7);
        }

        @Override // o1.f
        public long f(long j6, long j7) {
            return this.f8602i.h(j6, j7);
        }

        @Override // o1.f
        public long g(long j6, long j7) {
            return this.f8602i.d(j6, j7);
        }

        @Override // o1.f
        public long h(long j6, long j7) {
            return this.f8602i.f(j6, j7);
        }

        @Override // o1.f
        public i i(long j6) {
            return this.f8602i.k(this, j6);
        }

        @Override // o1.f
        public boolean j() {
            return this.f8602i.l();
        }

        @Override // o1.f
        public long k() {
            return this.f8602i.e();
        }

        @Override // o1.f
        public long l(long j6) {
            return this.f8602i.g(j6);
        }

        @Override // o1.f
        public long m(long j6, long j7) {
            return this.f8602i.c(j6, j7);
        }
    }

    public static class c extends j {

        /* renamed from: i, reason: collision with root package name */
        public final Uri f8603i;

        /* renamed from: j, reason: collision with root package name */
        public final long f8604j;

        /* renamed from: k, reason: collision with root package name */
        private final String f8605k;

        /* renamed from: l, reason: collision with root package name */
        private final i f8606l;

        /* renamed from: m, reason: collision with root package name */
        private final m f8607m;

        public c(long j6, y1 y1Var, List<p1.b> list, k.e eVar, List<e> list2, List<e> list3, List<e> list4, String str, long j7) {
            super(j6, y1Var, list, eVar, list2, list3, list4);
            this.f8603i = Uri.parse(list.get(0).f8541a);
            i c6 = eVar.c();
            this.f8606l = c6;
            this.f8605k = str;
            this.f8604j = j7;
            this.f8607m = c6 != null ? null : new m(new i(null, 0L, j7));
        }

        @Override // p1.j
        public String a() {
            return this.f8605k;
        }

        @Override // p1.j
        public o1.f b() {
            return this.f8607m;
        }

        @Override // p1.j
        public i c() {
            return this.f8606l;
        }
    }

    private j(long j6, y1 y1Var, List<p1.b> list, k kVar, List<e> list2, List<e> list3, List<e> list4) {
        i2.a.a(!list.isEmpty());
        this.f8594a = j6;
        this.f8595b = y1Var;
        this.f8596c = q.m(list);
        this.f8598e = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f8599f = list3;
        this.f8600g = list4;
        this.f8601h = kVar.a(this);
        this.f8597d = kVar.b();
    }

    public static j o(long j6, y1 y1Var, List<p1.b> list, k kVar, List<e> list2, List<e> list3, List<e> list4, String str) {
        if (kVar instanceof k.e) {
            return new c(j6, y1Var, list, (k.e) kVar, list2, list3, list4, str, -1L);
        }
        if (kVar instanceof k.a) {
            return new b(j6, y1Var, list, (k.a) kVar, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    public abstract String a();

    public abstract o1.f b();

    public abstract i c();

    public i n() {
        return this.f8601h;
    }
}
