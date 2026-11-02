package u1;

import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import m2.q;

/* loaded from: classes.dex */
public final class f implements i {

    /* renamed from: a, reason: collision with root package name */
    private final c f9644a = new c();

    /* renamed from: b, reason: collision with root package name */
    private final l f9645b = new l();

    /* renamed from: c, reason: collision with root package name */
    private final Deque<m> f9646c = new ArrayDeque();

    /* renamed from: d, reason: collision with root package name */
    private int f9647d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f9648e;

    class a extends m {
        a() {
        }

        @Override // l0.j
        public void o() {
            f.this.j(this);
        }
    }

    private static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        private final long f9650a;

        /* renamed from: b, reason: collision with root package name */
        private final q<u1.b> f9651b;

        public b(long j6, q<u1.b> qVar) {
            this.f9650a = j6;
            this.f9651b = qVar;
        }

        @Override // u1.h
        public int a(long j6) {
            return this.f9650a > j6 ? 0 : -1;
        }

        @Override // u1.h
        public long b(int i6) {
            i2.a.a(i6 == 0);
            return this.f9650a;
        }

        @Override // u1.h
        public List<u1.b> c(long j6) {
            return j6 >= this.f9650a ? this.f9651b : q.q();
        }

        @Override // u1.h
        public int d() {
            return 1;
        }
    }

    public f() {
        for (int i6 = 0; i6 < 2; i6++) {
            this.f9646c.addFirst(new a());
        }
        this.f9647d = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(m mVar) {
        i2.a.g(this.f9646c.size() < 2);
        i2.a.a(!this.f9646c.contains(mVar));
        mVar.f();
        this.f9646c.addFirst(mVar);
    }

    @Override // l0.f
    public void a() {
        this.f9648e = true;
    }

    @Override // u1.i
    public void b(long j6) {
    }

    @Override // l0.f
    public void flush() {
        i2.a.g(!this.f9648e);
        this.f9645b.f();
        this.f9647d = 0;
    }

    @Override // l0.f
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public l e() {
        i2.a.g(!this.f9648e);
        if (this.f9647d != 0) {
            return null;
        }
        this.f9647d = 1;
        return this.f9645b;
    }

    @Override // l0.f
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public m d() {
        i2.a.g(!this.f9648e);
        if (this.f9647d != 2 || this.f9646c.isEmpty()) {
            return null;
        }
        m removeFirst = this.f9646c.removeFirst();
        if (this.f9645b.k()) {
            removeFirst.e(4);
        } else {
            l lVar = this.f9645b;
            removeFirst.p(this.f9645b.f7164e, new b(lVar.f7164e, this.f9644a.a(((ByteBuffer) i2.a.e(lVar.f7162c)).array())), 0L);
        }
        this.f9645b.f();
        this.f9647d = 0;
        return removeFirst;
    }

    @Override // l0.f
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void c(l lVar) {
        i2.a.g(!this.f9648e);
        i2.a.g(this.f9647d == 1);
        i2.a.a(this.f9645b == lVar);
        this.f9647d = 2;
    }
}
