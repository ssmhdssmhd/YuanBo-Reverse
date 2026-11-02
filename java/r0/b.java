package r0;

import java.util.Objects;
import o0.a;
import o0.m;
import o0.s;
import o0.v;

/* loaded from: classes.dex */
final class b extends o0.a {

    /* renamed from: r0.b$b, reason: collision with other inner class name */
    private static final class C0137b implements a.f {

        /* renamed from: a, reason: collision with root package name */
        private final v f9027a;

        /* renamed from: b, reason: collision with root package name */
        private final int f9028b;

        /* renamed from: c, reason: collision with root package name */
        private final s.a f9029c;

        private C0137b(v vVar, int i6) {
            this.f9027a = vVar;
            this.f9028b = i6;
            this.f9029c = new s.a();
        }

        private long c(m mVar) {
            while (mVar.l() < mVar.getLength() - 6 && !s.h(mVar, this.f9027a, this.f9028b, this.f9029c)) {
                mVar.n(1);
            }
            if (mVar.l() < mVar.getLength() - 6) {
                return this.f9029c.f8413a;
            }
            mVar.n((int) (mVar.getLength() - mVar.l()));
            return this.f9027a.f8426j;
        }

        @Override // o0.a.f
        public a.e a(m mVar, long j6) {
            long position = mVar.getPosition();
            long c6 = c(mVar);
            long l6 = mVar.l();
            mVar.n(Math.max(6, this.f9027a.f8419c));
            long c7 = c(mVar);
            return (c6 > j6 || c7 <= j6) ? c7 <= j6 ? a.e.f(c7, mVar.l()) : a.e.d(c6, position) : a.e.e(l6);
        }

        @Override // o0.a.f
        public /* synthetic */ void b() {
            o0.b.a(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(final v vVar, int i6, long j6, long j7) {
        super(new a.d() { // from class: r0.a
            @Override // o0.a.d
            public final long a(long j8) {
                return v.this.i(j8);
            }
        }, new C0137b(vVar, i6), vVar.f(), 0L, vVar.f8426j, j6, j7, vVar.d(), Math.max(6, vVar.f8419c));
        Objects.requireNonNull(vVar);
    }
}
