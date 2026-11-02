package d0;

import com.tendcloud.tenddata.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import v.s;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: s, reason: collision with root package name */
    private static final String f2856s = v.j.f("WorkSpec");

    /* renamed from: t, reason: collision with root package name */
    public static final e.a<List<c>, List<v.s>> f2857t = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f2858a;

    /* renamed from: b, reason: collision with root package name */
    public s.a f2859b;

    /* renamed from: c, reason: collision with root package name */
    public String f2860c;

    /* renamed from: d, reason: collision with root package name */
    public String f2861d;

    /* renamed from: e, reason: collision with root package name */
    public androidx.work.b f2862e;

    /* renamed from: f, reason: collision with root package name */
    public androidx.work.b f2863f;

    /* renamed from: g, reason: collision with root package name */
    public long f2864g;

    /* renamed from: h, reason: collision with root package name */
    public long f2865h;

    /* renamed from: i, reason: collision with root package name */
    public long f2866i;

    /* renamed from: j, reason: collision with root package name */
    public v.b f2867j;

    /* renamed from: k, reason: collision with root package name */
    public int f2868k;

    /* renamed from: l, reason: collision with root package name */
    public v.a f2869l;

    /* renamed from: m, reason: collision with root package name */
    public long f2870m;

    /* renamed from: n, reason: collision with root package name */
    public long f2871n;

    /* renamed from: o, reason: collision with root package name */
    public long f2872o;

    /* renamed from: p, reason: collision with root package name */
    public long f2873p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f2874q;

    /* renamed from: r, reason: collision with root package name */
    public v.n f2875r;

    class a implements e.a<List<c>, List<v.s>> {
        a() {
        }

        @Override // e.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<v.s> apply(List<c> list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a());
            }
            return arrayList;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f2876a;

        /* renamed from: b, reason: collision with root package name */
        public s.a f2877b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f2877b != bVar.f2877b) {
                return false;
            }
            return this.f2876a.equals(bVar.f2876a);
        }

        public int hashCode() {
            return (this.f2876a.hashCode() * 31) + this.f2877b.hashCode();
        }
    }

    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public String f2878a;

        /* renamed from: b, reason: collision with root package name */
        public s.a f2879b;

        /* renamed from: c, reason: collision with root package name */
        public androidx.work.b f2880c;

        /* renamed from: d, reason: collision with root package name */
        public int f2881d;

        /* renamed from: e, reason: collision with root package name */
        public List<String> f2882e;

        /* renamed from: f, reason: collision with root package name */
        public List<androidx.work.b> f2883f;

        public v.s a() {
            List<androidx.work.b> list = this.f2883f;
            return new v.s(UUID.fromString(this.f2878a), this.f2879b, this.f2880c, this.f2882e, (list == null || list.isEmpty()) ? androidx.work.b.f1513c : this.f2883f.get(0), this.f2881d);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f2881d != cVar.f2881d) {
                return false;
            }
            String str = this.f2878a;
            if (str == null ? cVar.f2878a != null : !str.equals(cVar.f2878a)) {
                return false;
            }
            if (this.f2879b != cVar.f2879b) {
                return false;
            }
            androidx.work.b bVar = this.f2880c;
            if (bVar == null ? cVar.f2880c != null : !bVar.equals(cVar.f2880c)) {
                return false;
            }
            List<String> list = this.f2882e;
            if (list == null ? cVar.f2882e != null : !list.equals(cVar.f2882e)) {
                return false;
            }
            List<androidx.work.b> list2 = this.f2883f;
            List<androidx.work.b> list3 = cVar.f2883f;
            return list2 != null ? list2.equals(list3) : list3 == null;
        }

        public int hashCode() {
            String str = this.f2878a;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            s.a aVar = this.f2879b;
            int hashCode2 = (hashCode + (aVar != null ? aVar.hashCode() : 0)) * 31;
            androidx.work.b bVar = this.f2880c;
            int hashCode3 = (((hashCode2 + (bVar != null ? bVar.hashCode() : 0)) * 31) + this.f2881d) * 31;
            List<String> list = this.f2882e;
            int hashCode4 = (hashCode3 + (list != null ? list.hashCode() : 0)) * 31;
            List<androidx.work.b> list2 = this.f2883f;
            return hashCode4 + (list2 != null ? list2.hashCode() : 0);
        }
    }

    public p(p pVar) {
        this.f2859b = s.a.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.f1513c;
        this.f2862e = bVar;
        this.f2863f = bVar;
        this.f2867j = v.b.f9682i;
        this.f2869l = v.a.EXPONENTIAL;
        this.f2870m = ab.aa;
        this.f2873p = -1L;
        this.f2875r = v.n.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f2858a = pVar.f2858a;
        this.f2860c = pVar.f2860c;
        this.f2859b = pVar.f2859b;
        this.f2861d = pVar.f2861d;
        this.f2862e = new androidx.work.b(pVar.f2862e);
        this.f2863f = new androidx.work.b(pVar.f2863f);
        this.f2864g = pVar.f2864g;
        this.f2865h = pVar.f2865h;
        this.f2866i = pVar.f2866i;
        this.f2867j = new v.b(pVar.f2867j);
        this.f2868k = pVar.f2868k;
        this.f2869l = pVar.f2869l;
        this.f2870m = pVar.f2870m;
        this.f2871n = pVar.f2871n;
        this.f2872o = pVar.f2872o;
        this.f2873p = pVar.f2873p;
        this.f2874q = pVar.f2874q;
        this.f2875r = pVar.f2875r;
    }

    public p(String str, String str2) {
        this.f2859b = s.a.ENQUEUED;
        androidx.work.b bVar = androidx.work.b.f1513c;
        this.f2862e = bVar;
        this.f2863f = bVar;
        this.f2867j = v.b.f9682i;
        this.f2869l = v.a.EXPONENTIAL;
        this.f2870m = ab.aa;
        this.f2873p = -1L;
        this.f2875r = v.n.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.f2858a = str;
        this.f2860c = str2;
    }

    public long a() {
        if (c()) {
            return this.f2871n + Math.min(18000000L, this.f2869l == v.a.LINEAR ? this.f2870m * this.f2868k : (long) Math.scalb(this.f2870m, this.f2868k - 1));
        }
        if (!d()) {
            long j6 = this.f2871n;
            if (j6 == 0) {
                j6 = System.currentTimeMillis();
            }
            return j6 + this.f2864g;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j7 = this.f2871n;
        long j8 = j7 == 0 ? currentTimeMillis + this.f2864g : j7;
        long j9 = this.f2866i;
        long j10 = this.f2865h;
        if (j9 != j10) {
            return j8 + j10 + (j7 == 0 ? j9 * (-1) : 0L);
        }
        return j8 + (j7 != 0 ? j10 : 0L);
    }

    public boolean b() {
        return !v.b.f9682i.equals(this.f2867j);
    }

    public boolean c() {
        return this.f2859b == s.a.ENQUEUED && this.f2868k > 0;
    }

    public boolean d() {
        return this.f2865h != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p.class != obj.getClass()) {
            return false;
        }
        p pVar = (p) obj;
        if (this.f2864g != pVar.f2864g || this.f2865h != pVar.f2865h || this.f2866i != pVar.f2866i || this.f2868k != pVar.f2868k || this.f2870m != pVar.f2870m || this.f2871n != pVar.f2871n || this.f2872o != pVar.f2872o || this.f2873p != pVar.f2873p || this.f2874q != pVar.f2874q || !this.f2858a.equals(pVar.f2858a) || this.f2859b != pVar.f2859b || !this.f2860c.equals(pVar.f2860c)) {
            return false;
        }
        String str = this.f2861d;
        if (str == null ? pVar.f2861d == null : str.equals(pVar.f2861d)) {
            return this.f2862e.equals(pVar.f2862e) && this.f2863f.equals(pVar.f2863f) && this.f2867j.equals(pVar.f2867j) && this.f2869l == pVar.f2869l && this.f2875r == pVar.f2875r;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((this.f2858a.hashCode() * 31) + this.f2859b.hashCode()) * 31) + this.f2860c.hashCode()) * 31;
        String str = this.f2861d;
        int hashCode2 = (((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.f2862e.hashCode()) * 31) + this.f2863f.hashCode()) * 31;
        long j6 = this.f2864g;
        int i6 = (hashCode2 + ((int) (j6 ^ (j6 >>> 32)))) * 31;
        long j7 = this.f2865h;
        int i7 = (i6 + ((int) (j7 ^ (j7 >>> 32)))) * 31;
        long j8 = this.f2866i;
        int hashCode3 = (((((((i7 + ((int) (j8 ^ (j8 >>> 32)))) * 31) + this.f2867j.hashCode()) * 31) + this.f2868k) * 31) + this.f2869l.hashCode()) * 31;
        long j9 = this.f2870m;
        int i8 = (hashCode3 + ((int) (j9 ^ (j9 >>> 32)))) * 31;
        long j10 = this.f2871n;
        int i9 = (i8 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        long j11 = this.f2872o;
        int i10 = (i9 + ((int) (j11 ^ (j11 >>> 32)))) * 31;
        long j12 = this.f2873p;
        return ((((i10 + ((int) (j12 ^ (j12 >>> 32)))) * 31) + (this.f2874q ? 1 : 0)) * 31) + this.f2875r.hashCode();
    }

    public String toString() {
        return "{WorkSpec: " + this.f2858a + "}";
    }
}
