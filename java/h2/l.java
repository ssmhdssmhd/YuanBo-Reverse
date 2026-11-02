package h2;

import java.io.File;
import java.util.ArrayList;
import java.util.TreeSet;

/* loaded from: classes.dex */
final class l {

    /* renamed from: a, reason: collision with root package name */
    public final int f5181a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5182b;

    /* renamed from: c, reason: collision with root package name */
    private final TreeSet<v> f5183c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayList<a> f5184d;

    /* renamed from: e, reason: collision with root package name */
    private q f5185e;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f5186a;

        /* renamed from: b, reason: collision with root package name */
        public final long f5187b;

        public a(long j6, long j7) {
            this.f5186a = j6;
            this.f5187b = j7;
        }

        public boolean a(long j6, long j7) {
            long j8 = this.f5187b;
            if (j8 == -1) {
                return j6 >= this.f5186a;
            }
            if (j7 == -1) {
                return false;
            }
            long j9 = this.f5186a;
            return j9 <= j6 && j6 + j7 <= j9 + j8;
        }

        public boolean b(long j6, long j7) {
            long j8 = this.f5186a;
            if (j8 > j6) {
                return j7 == -1 || j6 + j7 > j8;
            }
            long j9 = this.f5187b;
            return j9 == -1 || j8 + j9 > j6;
        }
    }

    public l(int i6, String str) {
        this(i6, str, q.f5208c);
    }

    public l(int i6, String str, q qVar) {
        this.f5181a = i6;
        this.f5182b = str;
        this.f5185e = qVar;
        this.f5183c = new TreeSet<>();
        this.f5184d = new ArrayList<>();
    }

    public void a(v vVar) {
        this.f5183c.add(vVar);
    }

    public boolean b(p pVar) {
        this.f5185e = this.f5185e.e(pVar);
        return !r2.equals(r0);
    }

    public long c(long j6, long j7) {
        i2.a.a(j6 >= 0);
        i2.a.a(j7 >= 0);
        v e6 = e(j6, j7);
        if (e6.b()) {
            return -Math.min(e6.c() ? Long.MAX_VALUE : e6.f5167c, j7);
        }
        long j8 = j6 + j7;
        long j9 = j8 >= 0 ? j8 : Long.MAX_VALUE;
        long j10 = e6.f5166b + e6.f5167c;
        if (j10 < j9) {
            for (v vVar : this.f5183c.tailSet(e6, false)) {
                long j11 = vVar.f5166b;
                if (j11 > j10) {
                    break;
                }
                j10 = Math.max(j10, j11 + vVar.f5167c);
                if (j10 >= j9) {
                    break;
                }
            }
        }
        return Math.min(j10 - j6, j7);
    }

    public q d() {
        return this.f5185e;
    }

    public v e(long j6, long j7) {
        v h6 = v.h(this.f5182b, j6);
        v floor = this.f5183c.floor(h6);
        if (floor != null && floor.f5166b + floor.f5167c > j6) {
            return floor;
        }
        v ceiling = this.f5183c.ceiling(h6);
        if (ceiling != null) {
            long j8 = ceiling.f5166b - j6;
            j7 = j7 == -1 ? j8 : Math.min(j8, j7);
        }
        return v.g(this.f5182b, j6, j7);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.f5181a == lVar.f5181a && this.f5182b.equals(lVar.f5182b) && this.f5183c.equals(lVar.f5183c) && this.f5185e.equals(lVar.f5185e);
    }

    public TreeSet<v> f() {
        return this.f5183c;
    }

    public boolean g() {
        return this.f5183c.isEmpty();
    }

    public boolean h(long j6, long j7) {
        for (int i6 = 0; i6 < this.f5184d.size(); i6++) {
            if (this.f5184d.get(i6).a(j6, j7)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (((this.f5181a * 31) + this.f5182b.hashCode()) * 31) + this.f5185e.hashCode();
    }

    public boolean i() {
        return this.f5184d.isEmpty();
    }

    public boolean j(long j6, long j7) {
        for (int i6 = 0; i6 < this.f5184d.size(); i6++) {
            if (this.f5184d.get(i6).b(j6, j7)) {
                return false;
            }
        }
        this.f5184d.add(new a(j6, j7));
        return true;
    }

    public boolean k(j jVar) {
        if (!this.f5183c.remove(jVar)) {
            return false;
        }
        File file = jVar.f5169e;
        if (file == null) {
            return true;
        }
        file.delete();
        return true;
    }

    public v l(v vVar, long j6, boolean z5) {
        i2.a.g(this.f5183c.remove(vVar));
        File file = (File) i2.a.e(vVar.f5169e);
        if (z5) {
            File i6 = v.i((File) i2.a.e(file.getParentFile()), this.f5181a, vVar.f5166b, j6);
            if (file.renameTo(i6)) {
                file = i6;
            } else {
                i2.t.i("CachedContent", "Failed to rename " + file + " to " + i6);
            }
        }
        v d6 = vVar.d(file, j6);
        this.f5183c.add(d6);
        return d6;
    }

    public void m(long j6) {
        for (int i6 = 0; i6 < this.f5184d.size(); i6++) {
            if (this.f5184d.get(i6).f5186a == j6) {
                this.f5184d.remove(i6);
                return;
            }
        }
        throw new IllegalStateException();
    }
}
