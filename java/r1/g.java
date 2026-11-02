package r1;

import android.net.Uri;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m0.m;
import m2.q;

/* loaded from: classes.dex */
public final class g extends i {

    /* renamed from: d, reason: collision with root package name */
    public final int f9077d;

    /* renamed from: e, reason: collision with root package name */
    public final long f9078e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f9079f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f9080g;

    /* renamed from: h, reason: collision with root package name */
    public final long f9081h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f9082i;

    /* renamed from: j, reason: collision with root package name */
    public final int f9083j;

    /* renamed from: k, reason: collision with root package name */
    public final long f9084k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9085l;

    /* renamed from: m, reason: collision with root package name */
    public final long f9086m;

    /* renamed from: n, reason: collision with root package name */
    public final long f9087n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f9088o;

    /* renamed from: p, reason: collision with root package name */
    public final boolean f9089p;

    /* renamed from: q, reason: collision with root package name */
    public final m f9090q;

    /* renamed from: r, reason: collision with root package name */
    public final List<d> f9091r;

    /* renamed from: s, reason: collision with root package name */
    public final List<b> f9092s;

    /* renamed from: t, reason: collision with root package name */
    public final Map<Uri, c> f9093t;

    /* renamed from: u, reason: collision with root package name */
    public final long f9094u;

    /* renamed from: v, reason: collision with root package name */
    public final f f9095v;

    public static final class b extends e {

        /* renamed from: p, reason: collision with root package name */
        public final boolean f9096p;

        /* renamed from: q, reason: collision with root package name */
        public final boolean f9097q;

        public b(String str, d dVar, long j6, int i6, long j7, m mVar, String str2, String str3, long j8, long j9, boolean z5, boolean z6, boolean z7) {
            super(str, dVar, j6, i6, j7, mVar, str2, str3, j8, j9, z5);
            this.f9096p = z6;
            this.f9097q = z7;
        }

        public b b(long j6, int i6) {
            return new b(this.f9103a, this.f9104b, this.f9105c, i6, j6, this.f9108j, this.f9109k, this.f9110l, this.f9111m, this.f9112n, this.f9113o, this.f9096p, this.f9097q);
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f9098a;

        /* renamed from: b, reason: collision with root package name */
        public final long f9099b;

        /* renamed from: c, reason: collision with root package name */
        public final int f9100c;

        public c(Uri uri, long j6, int i6) {
            this.f9098a = uri;
            this.f9099b = j6;
            this.f9100c = i6;
        }
    }

    public static final class d extends e {

        /* renamed from: p, reason: collision with root package name */
        public final String f9101p;

        /* renamed from: q, reason: collision with root package name */
        public final List<b> f9102q;

        public d(String str, long j6, long j7, String str2, String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j6, j7, false, q.q());
        }

        public d(String str, d dVar, String str2, long j6, int i6, long j7, m mVar, String str3, String str4, long j8, long j9, boolean z5, List<b> list) {
            super(str, dVar, j6, i6, j7, mVar, str3, str4, j8, j9, z5);
            this.f9101p = str2;
            this.f9102q = q.m(list);
        }

        public d b(long j6, int i6) {
            ArrayList arrayList = new ArrayList();
            long j7 = j6;
            for (int i7 = 0; i7 < this.f9102q.size(); i7++) {
                b bVar = this.f9102q.get(i7);
                arrayList.add(bVar.b(j7, i6));
                j7 += bVar.f9105c;
            }
            return new d(this.f9103a, this.f9104b, this.f9101p, this.f9105c, i6, j6, this.f9108j, this.f9109k, this.f9110l, this.f9111m, this.f9112n, this.f9113o, arrayList);
        }
    }

    public static class e implements Comparable<Long> {

        /* renamed from: a, reason: collision with root package name */
        public final String f9103a;

        /* renamed from: b, reason: collision with root package name */
        public final d f9104b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9105c;

        /* renamed from: d, reason: collision with root package name */
        public final int f9106d;

        /* renamed from: e, reason: collision with root package name */
        public final long f9107e;

        /* renamed from: j, reason: collision with root package name */
        public final m f9108j;

        /* renamed from: k, reason: collision with root package name */
        public final String f9109k;

        /* renamed from: l, reason: collision with root package name */
        public final String f9110l;

        /* renamed from: m, reason: collision with root package name */
        public final long f9111m;

        /* renamed from: n, reason: collision with root package name */
        public final long f9112n;

        /* renamed from: o, reason: collision with root package name */
        public final boolean f9113o;

        private e(String str, d dVar, long j6, int i6, long j7, m mVar, String str2, String str3, long j8, long j9, boolean z5) {
            this.f9103a = str;
            this.f9104b = dVar;
            this.f9105c = j6;
            this.f9106d = i6;
            this.f9107e = j7;
            this.f9108j = mVar;
            this.f9109k = str2;
            this.f9110l = str3;
            this.f9111m = j8;
            this.f9112n = j9;
            this.f9113o = z5;
        }

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l6) {
            if (this.f9107e > l6.longValue()) {
                return 1;
            }
            return this.f9107e < l6.longValue() ? -1 : 0;
        }
    }

    public static final class f {

        /* renamed from: a, reason: collision with root package name */
        public final long f9114a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f9115b;

        /* renamed from: c, reason: collision with root package name */
        public final long f9116c;

        /* renamed from: d, reason: collision with root package name */
        public final long f9117d;

        /* renamed from: e, reason: collision with root package name */
        public final boolean f9118e;

        public f(long j6, boolean z5, long j7, long j8, boolean z6) {
            this.f9114a = j6;
            this.f9115b = z5;
            this.f9116c = j7;
            this.f9117d = j8;
            this.f9118e = z6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g(int r11, java.lang.String r12, java.util.List<java.lang.String> r13, long r14, boolean r16, long r17, boolean r19, int r20, long r21, int r23, long r24, long r26, boolean r28, boolean r29, boolean r30, m0.m r31, java.util.List<r1.g.d> r32, java.util.List<r1.g.b> r33, r1.g.f r34, java.util.Map<android.net.Uri, r1.g.c> r35) {
        /*
            r10 = this;
            r0 = r10
            r1 = r14
            r3 = r12
            r4 = r13
            r5 = r28
            r10.<init>(r12, r13, r5)
            r3 = r11
            r0.f9077d = r3
            r3 = r17
            r0.f9081h = r3
            r3 = r16
            r0.f9080g = r3
            r3 = r19
            r0.f9082i = r3
            r3 = r20
            r0.f9083j = r3
            r3 = r21
            r0.f9084k = r3
            r3 = r23
            r0.f9085l = r3
            r3 = r24
            r0.f9086m = r3
            r3 = r26
            r0.f9087n = r3
            r3 = r29
            r0.f9088o = r3
            r3 = r30
            r0.f9089p = r3
            r3 = r31
            r0.f9090q = r3
            m2.q r3 = m2.q.m(r32)
            r0.f9091r = r3
            m2.q r3 = m2.q.m(r33)
            r0.f9092s = r3
            m2.r r3 = m2.r.c(r35)
            r0.f9093t = r3
            boolean r3 = r33.isEmpty()
            r4 = 0
            if (r3 != 0) goto L60
            java.lang.Object r3 = m2.t.c(r33)
            r1.g$b r3 = (r1.g.b) r3
        L58:
            long r6 = r3.f9107e
            long r8 = r3.f9105c
            long r6 = r6 + r8
            r0.f9094u = r6
            goto L6f
        L60:
            boolean r3 = r32.isEmpty()
            if (r3 != 0) goto L6d
            java.lang.Object r3 = m2.t.c(r32)
            r1.g$d r3 = (r1.g.d) r3
            goto L58
        L6d:
            r0.f9094u = r4
        L6f:
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r3 != 0) goto L79
            goto L89
        L79:
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            long r6 = r0.f9094u
            if (r3 < 0) goto L84
            long r6 = java.lang.Math.min(r6, r14)
            goto L89
        L84:
            long r6 = r6 + r1
            long r6 = java.lang.Math.max(r4, r6)
        L89:
            r0.f9078e = r6
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 < 0) goto L91
            r1 = 1
            goto L92
        L91:
            r1 = 0
        L92:
            r0.f9079f = r1
            r1 = r34
            r0.f9095v = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r1.g.<init>(int, java.lang.String, java.util.List, long, boolean, long, boolean, int, long, int, long, long, boolean, boolean, boolean, m0.m, java.util.List, java.util.List, r1.g$f, java.util.Map):void");
    }

    @Override // k1.a
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g a(List<k1.c> list) {
        return this;
    }

    public g c(long j6, int i6) {
        return new g(this.f9077d, this.f9140a, this.f9141b, this.f9078e, this.f9080g, j6, true, i6, this.f9084k, this.f9085l, this.f9086m, this.f9087n, this.f9142c, this.f9088o, this.f9089p, this.f9090q, this.f9091r, this.f9092s, this.f9095v, this.f9093t);
    }

    public g d() {
        return this.f9088o ? this : new g(this.f9077d, this.f9140a, this.f9141b, this.f9078e, this.f9080g, this.f9081h, this.f9082i, this.f9083j, this.f9084k, this.f9085l, this.f9086m, this.f9087n, this.f9142c, true, this.f9089p, this.f9090q, this.f9091r, this.f9092s, this.f9095v, this.f9093t);
    }

    public long e() {
        return this.f9081h + this.f9094u;
    }

    public boolean f(g gVar) {
        if (gVar == null) {
            return true;
        }
        long j6 = this.f9084k;
        long j7 = gVar.f9084k;
        if (j6 > j7) {
            return true;
        }
        if (j6 < j7) {
            return false;
        }
        int size = this.f9091r.size() - gVar.f9091r.size();
        if (size != 0) {
            return size > 0;
        }
        int size2 = this.f9092s.size();
        int size3 = gVar.f9092s.size();
        if (size2 <= size3) {
            return size2 == size3 && this.f9088o && !gVar.f9088o;
        }
        return true;
    }
}
