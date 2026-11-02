package p1;

import h0.y1;
import i2.c1;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    final i f8608a;

    /* renamed from: b, reason: collision with root package name */
    final long f8609b;

    /* renamed from: c, reason: collision with root package name */
    final long f8610c;

    public static abstract class a extends k {

        /* renamed from: d, reason: collision with root package name */
        final long f8611d;

        /* renamed from: e, reason: collision with root package name */
        final long f8612e;

        /* renamed from: f, reason: collision with root package name */
        final List<d> f8613f;

        /* renamed from: g, reason: collision with root package name */
        private final long f8614g;

        /* renamed from: h, reason: collision with root package name */
        private final long f8615h;

        /* renamed from: i, reason: collision with root package name */
        final long f8616i;

        public a(i iVar, long j6, long j7, long j8, long j9, List<d> list, long j10, long j11, long j12) {
            super(iVar, j6, j7);
            this.f8611d = j8;
            this.f8612e = j9;
            this.f8613f = list;
            this.f8616i = j10;
            this.f8614g = j11;
            this.f8615h = j12;
        }

        public long c(long j6, long j7) {
            long g6 = g(j6);
            return g6 != -1 ? g6 : (int) (i((j7 - this.f8615h) + this.f8616i, j6) - d(j6, j7));
        }

        public long d(long j6, long j7) {
            if (g(j6) == -1) {
                long j8 = this.f8614g;
                if (j8 != -9223372036854775807L) {
                    return Math.max(e(), i((j7 - this.f8615h) - j8, j6));
                }
            }
            return e();
        }

        public long e() {
            return this.f8611d;
        }

        public long f(long j6, long j7) {
            if (this.f8613f != null) {
                return -9223372036854775807L;
            }
            long d6 = d(j6, j7) + c(j6, j7);
            return (j(d6) + h(d6, j6)) - this.f8616i;
        }

        public abstract long g(long j6);

        public final long h(long j6, long j7) {
            List<d> list = this.f8613f;
            if (list != null) {
                return (list.get((int) (j6 - this.f8611d)).f8622b * 1000000) / this.f8609b;
            }
            long g6 = g(j7);
            return (g6 == -1 || j6 != (e() + g6) - 1) ? (this.f8612e * 1000000) / this.f8609b : j7 - j(j6);
        }

        public long i(long j6, long j7) {
            long e6 = e();
            long g6 = g(j7);
            if (g6 == 0) {
                return e6;
            }
            if (this.f8613f == null) {
                long j8 = this.f8611d + (j6 / ((this.f8612e * 1000000) / this.f8609b));
                return j8 < e6 ? e6 : g6 == -1 ? j8 : Math.min(j8, (e6 + g6) - 1);
            }
            long j9 = (g6 + e6) - 1;
            long j10 = e6;
            while (j10 <= j9) {
                long j11 = ((j9 - j10) / 2) + j10;
                long j12 = j(j11);
                if (j12 < j6) {
                    j10 = j11 + 1;
                } else {
                    if (j12 <= j6) {
                        return j11;
                    }
                    j9 = j11 - 1;
                }
            }
            return j10 == e6 ? j10 : j9;
        }

        public final long j(long j6) {
            List<d> list = this.f8613f;
            return c1.P0(list != null ? list.get((int) (j6 - this.f8611d)).f8621a - this.f8610c : (j6 - this.f8611d) * this.f8612e, 1000000L, this.f8609b);
        }

        public abstract i k(j jVar, long j6);

        public boolean l() {
            return this.f8613f != null;
        }
    }

    public static final class b extends a {

        /* renamed from: j, reason: collision with root package name */
        final List<i> f8617j;

        public b(i iVar, long j6, long j7, long j8, long j9, List<d> list, long j10, List<i> list2, long j11, long j12) {
            super(iVar, j6, j7, j8, j9, list, j10, j11, j12);
            this.f8617j = list2;
        }

        @Override // p1.k.a
        public long g(long j6) {
            return this.f8617j.size();
        }

        @Override // p1.k.a
        public i k(j jVar, long j6) {
            return this.f8617j.get((int) (j6 - this.f8611d));
        }

        @Override // p1.k.a
        public boolean l() {
            return true;
        }
    }

    public static final class c extends a {

        /* renamed from: j, reason: collision with root package name */
        final n f8618j;

        /* renamed from: k, reason: collision with root package name */
        final n f8619k;

        /* renamed from: l, reason: collision with root package name */
        final long f8620l;

        public c(i iVar, long j6, long j7, long j8, long j9, long j10, List<d> list, long j11, n nVar, n nVar2, long j12, long j13) {
            super(iVar, j6, j7, j8, j10, list, j11, j12, j13);
            this.f8618j = nVar;
            this.f8619k = nVar2;
            this.f8620l = j9;
        }

        @Override // p1.k
        public i a(j jVar) {
            n nVar = this.f8618j;
            if (nVar == null) {
                return super.a(jVar);
            }
            y1 y1Var = jVar.f8595b;
            return new i(nVar.a(y1Var.f5055a, 0L, y1Var.f5062l, 0L), 0L, -1L);
        }

        @Override // p1.k.a
        public long g(long j6) {
            if (this.f8613f != null) {
                return r0.size();
            }
            long j7 = this.f8620l;
            if (j7 != -1) {
                return (j7 - this.f8611d) + 1;
            }
            if (j6 != -9223372036854775807L) {
                return n2.a.a(BigInteger.valueOf(j6).multiply(BigInteger.valueOf(this.f8609b)), BigInteger.valueOf(this.f8612e).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // p1.k.a
        public i k(j jVar, long j6) {
            List<d> list = this.f8613f;
            long j7 = list != null ? list.get((int) (j6 - this.f8611d)).f8621a : (j6 - this.f8611d) * this.f8612e;
            n nVar = this.f8619k;
            y1 y1Var = jVar.f8595b;
            return new i(nVar.a(y1Var.f5055a, j6, y1Var.f5062l, j7), 0L, -1L);
        }
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        final long f8621a;

        /* renamed from: b, reason: collision with root package name */
        final long f8622b;

        public d(long j6, long j7) {
            this.f8621a = j6;
            this.f8622b = j7;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.f8621a == dVar.f8621a && this.f8622b == dVar.f8622b;
        }

        public int hashCode() {
            return (((int) this.f8621a) * 31) + ((int) this.f8622b);
        }
    }

    public static class e extends k {

        /* renamed from: d, reason: collision with root package name */
        final long f8623d;

        /* renamed from: e, reason: collision with root package name */
        final long f8624e;

        public e() {
            this(null, 1L, 0L, 0L, 0L);
        }

        public e(i iVar, long j6, long j7, long j8, long j9) {
            super(iVar, j6, j7);
            this.f8623d = j8;
            this.f8624e = j9;
        }

        public i c() {
            long j6 = this.f8624e;
            if (j6 <= 0) {
                return null;
            }
            return new i(null, this.f8623d, j6);
        }
    }

    public k(i iVar, long j6, long j7) {
        this.f8608a = iVar;
        this.f8609b = j6;
        this.f8610c = j7;
    }

    public i a(j jVar) {
        return this.f8608a;
    }

    public long b() {
        return c1.P0(this.f8610c, 1000000L, this.f8609b);
    }
}
