package y0;

import android.net.Uri;
import h0.g3;
import java.io.EOFException;
import java.util.Map;
import o0.b0;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import y0.i0;

/* loaded from: classes.dex */
public final class h implements o0.l {

    /* renamed from: m, reason: collision with root package name */
    public static final o0.r f10745m = new o0.r() { // from class: y0.g
        @Override // o0.r
        public final o0.l[] a() {
            o0.l[] i6;
            i6 = h.i();
            return i6;
        }

        @Override // o0.r
        public /* synthetic */ o0.l[] b(Uri uri, Map map) {
            return o0.q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final int f10746a;

    /* renamed from: b, reason: collision with root package name */
    private final i f10747b;

    /* renamed from: c, reason: collision with root package name */
    private final i2.i0 f10748c;

    /* renamed from: d, reason: collision with root package name */
    private final i2.i0 f10749d;

    /* renamed from: e, reason: collision with root package name */
    private final i2.h0 f10750e;

    /* renamed from: f, reason: collision with root package name */
    private o0.n f10751f;

    /* renamed from: g, reason: collision with root package name */
    private long f10752g;

    /* renamed from: h, reason: collision with root package name */
    private long f10753h;

    /* renamed from: i, reason: collision with root package name */
    private int f10754i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f10755j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f10756k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f10757l;

    public h() {
        this(0);
    }

    public h(int i6) {
        this.f10746a = (i6 & 2) != 0 ? i6 | 1 : i6;
        this.f10747b = new i(true);
        this.f10748c = new i2.i0(2048);
        this.f10754i = -1;
        this.f10753h = -1L;
        i2.i0 i0Var = new i2.i0(10);
        this.f10749d = i0Var;
        this.f10750e = new i2.h0(i0Var.e());
    }

    private void e(o0.m mVar) {
        if (this.f10755j) {
            return;
        }
        this.f10754i = -1;
        mVar.g();
        long j6 = 0;
        if (mVar.getPosition() == 0) {
            l(mVar);
        }
        int i6 = 0;
        int i7 = 0;
        while (mVar.k(this.f10749d.e(), 0, 2, true)) {
            try {
                this.f10749d.S(0);
                if (!i.m(this.f10749d.L())) {
                    break;
                }
                if (!mVar.k(this.f10749d.e(), 0, 4, true)) {
                    break;
                }
                this.f10750e.p(14);
                int h6 = this.f10750e.h(13);
                if (h6 <= 6) {
                    this.f10755j = true;
                    throw g3.a("Malformed ADTS stream", null);
                }
                j6 += h6;
                i7++;
                if (i7 != 1000 && mVar.i(h6 - 6, true)) {
                }
                break;
            } catch (EOFException unused) {
            }
        }
        i6 = i7;
        mVar.g();
        if (i6 > 0) {
            this.f10754i = (int) (j6 / i6);
        } else {
            this.f10754i = -1;
        }
        this.f10755j = true;
    }

    private static int f(int i6, long j6) {
        return (int) (((i6 * 8) * 1000000) / j6);
    }

    private o0.b0 h(long j6, boolean z5) {
        return new o0.e(j6, this.f10753h, f(this.f10754i, this.f10747b.k()), this.f10754i, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ o0.l[] i() {
        return new o0.l[]{new h()};
    }

    @RequiresNonNull({"extractorOutput"})
    private void k(long j6, boolean z5) {
        if (this.f10757l) {
            return;
        }
        boolean z6 = (this.f10746a & 1) != 0 && this.f10754i > 0;
        if (z6 && this.f10747b.k() == -9223372036854775807L && !z5) {
            return;
        }
        if (!z6 || this.f10747b.k() == -9223372036854775807L) {
            this.f10751f.t(new b0.b(-9223372036854775807L));
        } else {
            this.f10751f.t(h(j6, (this.f10746a & 2) != 0));
        }
        this.f10757l = true;
    }

    private int l(o0.m mVar) {
        int i6 = 0;
        while (true) {
            mVar.m(this.f10749d.e(), 0, 10);
            this.f10749d.S(0);
            if (this.f10749d.I() != 4801587) {
                break;
            }
            this.f10749d.T(3);
            int E = this.f10749d.E();
            i6 += E + 10;
            mVar.n(E);
        }
        mVar.g();
        mVar.n(i6);
        if (this.f10753h == -1) {
            this.f10753h = i6;
        }
        return i6;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f10756k = false;
        this.f10747b.a();
        this.f10752g = j7;
    }

    @Override // o0.l
    public void c(o0.n nVar) {
        this.f10751f = nVar;
        this.f10747b.e(nVar, new i0.d(0, 1));
        nVar.j();
    }

    @Override // o0.l
    public boolean g(o0.m mVar) {
        int l6 = l(mVar);
        int i6 = l6;
        int i7 = 0;
        int i8 = 0;
        do {
            mVar.m(this.f10749d.e(), 0, 2);
            this.f10749d.S(0);
            if (i.m(this.f10749d.L())) {
                i7++;
                if (i7 >= 4 && i8 > 188) {
                    return true;
                }
                mVar.m(this.f10749d.e(), 0, 4);
                this.f10750e.p(14);
                int h6 = this.f10750e.h(13);
                if (h6 > 6) {
                    mVar.n(h6 - 6);
                    i8 += h6;
                }
            }
            i6++;
            mVar.g();
            mVar.n(i6);
            i7 = 0;
            i8 = 0;
        } while (i6 - l6 < 8192);
        return false;
    }

    @Override // o0.l
    public int j(o0.m mVar, o0.a0 a0Var) {
        i2.a.i(this.f10751f);
        long length = mVar.getLength();
        int i6 = this.f10746a;
        if (((i6 & 2) == 0 && ((i6 & 1) == 0 || length == -1)) ? false : true) {
            e(mVar);
        }
        int read = mVar.read(this.f10748c.e(), 0, 2048);
        boolean z5 = read == -1;
        k(length, z5);
        if (z5) {
            return -1;
        }
        this.f10748c.S(0);
        this.f10748c.R(read);
        if (!this.f10756k) {
            this.f10747b.d(this.f10752g, 4);
            this.f10756k = true;
        }
        this.f10747b.b(this.f10748c);
        return 0;
    }
}
