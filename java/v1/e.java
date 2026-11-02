package v1;

import i2.c1;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import l0.j;
import u1.h;
import u1.i;
import u1.l;
import u1.m;
import v1.e;

/* loaded from: classes.dex */
abstract class e implements i {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayDeque<b> f9865a = new ArrayDeque<>();

    /* renamed from: b, reason: collision with root package name */
    private final ArrayDeque<m> f9866b;

    /* renamed from: c, reason: collision with root package name */
    private final PriorityQueue<b> f9867c;

    /* renamed from: d, reason: collision with root package name */
    private b f9868d;

    /* renamed from: e, reason: collision with root package name */
    private long f9869e;

    /* renamed from: f, reason: collision with root package name */
    private long f9870f;

    private static final class b extends l implements Comparable<b> {

        /* renamed from: n, reason: collision with root package name */
        private long f9871n;

        private b() {
        }

        @Override // java.lang.Comparable
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (k() != bVar.k()) {
                return k() ? 1 : -1;
            }
            long j6 = this.f7164e - bVar.f7164e;
            if (j6 == 0) {
                j6 = this.f9871n - bVar.f9871n;
                if (j6 == 0) {
                    return 0;
                }
            }
            return j6 > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class c extends m {

        /* renamed from: j, reason: collision with root package name */
        private j.a<c> f9872j;

        public c(j.a<c> aVar) {
            this.f9872j = aVar;
        }

        @Override // l0.j
        public final void o() {
            this.f9872j.a(this);
        }
    }

    public e() {
        for (int i6 = 0; i6 < 10; i6++) {
            this.f9865a.add(new b());
        }
        this.f9866b = new ArrayDeque<>();
        for (int i7 = 0; i7 < 2; i7++) {
            this.f9866b.add(new c(new j.a() { // from class: v1.d
                @Override // l0.j.a
                public final void a(j jVar) {
                    e.this.o((e.c) jVar);
                }
            }));
        }
        this.f9867c = new PriorityQueue<>();
    }

    private void n(b bVar) {
        bVar.f();
        this.f9865a.add(bVar);
    }

    @Override // l0.f
    public void a() {
    }

    @Override // u1.i
    public void b(long j6) {
        this.f9869e = j6;
    }

    protected abstract h f();

    @Override // l0.f
    public void flush() {
        this.f9870f = 0L;
        this.f9869e = 0L;
        while (!this.f9867c.isEmpty()) {
            n((b) c1.j(this.f9867c.poll()));
        }
        b bVar = this.f9868d;
        if (bVar != null) {
            n(bVar);
            this.f9868d = null;
        }
    }

    protected abstract void g(l lVar);

    @Override // l0.f
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public l e() {
        i2.a.g(this.f9868d == null);
        if (this.f9865a.isEmpty()) {
            return null;
        }
        b pollFirst = this.f9865a.pollFirst();
        this.f9868d = pollFirst;
        return pollFirst;
    }

    @Override // l0.f
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public m d() {
        m mVar;
        if (this.f9866b.isEmpty()) {
            return null;
        }
        while (!this.f9867c.isEmpty() && ((b) c1.j(this.f9867c.peek())).f7164e <= this.f9869e) {
            b bVar = (b) c1.j(this.f9867c.poll());
            if (bVar.k()) {
                mVar = (m) c1.j(this.f9866b.pollFirst());
                mVar.e(4);
            } else {
                g(bVar);
                if (l()) {
                    h f6 = f();
                    mVar = (m) c1.j(this.f9866b.pollFirst());
                    mVar.p(bVar.f7164e, f6, Long.MAX_VALUE);
                } else {
                    n(bVar);
                }
            }
            n(bVar);
            return mVar;
        }
        return null;
    }

    protected final m j() {
        return this.f9866b.pollFirst();
    }

    protected final long k() {
        return this.f9869e;
    }

    protected abstract boolean l();

    @Override // l0.f
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void c(l lVar) {
        i2.a.a(lVar == this.f9868d);
        b bVar = (b) lVar;
        if (bVar.j()) {
            n(bVar);
        } else {
            long j6 = this.f9870f;
            this.f9870f = 1 + j6;
            bVar.f9871n = j6;
            this.f9867c.add(bVar);
        }
        this.f9868d = null;
    }

    protected void o(m mVar) {
        mVar.f();
        this.f9866b.add(mVar);
    }
}
