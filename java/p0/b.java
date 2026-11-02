package p0;

import android.net.Uri;
import h0.g3;
import h0.y1;
import i2.c1;
import java.io.EOFException;
import java.util.Arrays;
import java.util.Map;
import o0.a0;
import o0.b0;
import o0.e;
import o0.e0;
import o0.l;
import o0.m;
import o0.n;
import o0.q;
import o0.r;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* loaded from: classes.dex */
public final class b implements l {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f8516r;

    /* renamed from: u, reason: collision with root package name */
    private static final int f8519u;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8520a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8521b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8522c;

    /* renamed from: d, reason: collision with root package name */
    private long f8523d;

    /* renamed from: e, reason: collision with root package name */
    private int f8524e;

    /* renamed from: f, reason: collision with root package name */
    private int f8525f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8526g;

    /* renamed from: h, reason: collision with root package name */
    private long f8527h;

    /* renamed from: i, reason: collision with root package name */
    private int f8528i;

    /* renamed from: j, reason: collision with root package name */
    private int f8529j;

    /* renamed from: k, reason: collision with root package name */
    private long f8530k;

    /* renamed from: l, reason: collision with root package name */
    private n f8531l;

    /* renamed from: m, reason: collision with root package name */
    private e0 f8532m;

    /* renamed from: n, reason: collision with root package name */
    private b0 f8533n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f8534o;

    /* renamed from: p, reason: collision with root package name */
    public static final r f8514p = new r() { // from class: p0.a
        @Override // o0.r
        public final l[] a() {
            l[] n6;
            n6 = b.n();
            return n6;
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* renamed from: q, reason: collision with root package name */
    private static final int[] f8515q = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};

    /* renamed from: s, reason: collision with root package name */
    private static final byte[] f8517s = c1.n0("#!AMR\n");

    /* renamed from: t, reason: collision with root package name */
    private static final byte[] f8518t = c1.n0("#!AMR-WB\n");

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        f8516r = iArr;
        f8519u = iArr[8];
    }

    public b() {
        this(0);
    }

    public b(int i6) {
        this.f8521b = (i6 & 2) != 0 ? i6 | 1 : i6;
        this.f8520a = new byte[1];
        this.f8528i = -1;
    }

    @EnsuresNonNull({"extractorOutput", "trackOutput"})
    private void e() {
        i2.a.i(this.f8532m);
        c1.j(this.f8531l);
    }

    private static int f(int i6, long j6) {
        return (int) (((i6 * 8) * 1000000) / j6);
    }

    private b0 h(long j6, boolean z5) {
        return new e(j6, this.f8527h, f(this.f8528i, 20000L), this.f8528i, z5);
    }

    private int i(int i6) {
        if (l(i6)) {
            return this.f8522c ? f8516r[i6] : f8515q[i6];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Illegal AMR ");
        sb.append(this.f8522c ? "WB" : "NB");
        sb.append(" frame type ");
        sb.append(i6);
        throw g3.a(sb.toString(), null);
    }

    private boolean k(int i6) {
        return !this.f8522c && (i6 < 12 || i6 > 14);
    }

    private boolean l(int i6) {
        return i6 >= 0 && i6 <= 15 && (m(i6) || k(i6));
    }

    private boolean m(int i6) {
        return this.f8522c && (i6 < 10 || i6 > 13);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] n() {
        return new l[]{new b()};
    }

    @RequiresNonNull({"trackOutput"})
    private void o() {
        if (this.f8534o) {
            return;
        }
        this.f8534o = true;
        boolean z5 = this.f8522c;
        this.f8532m.c(new y1.b().g0(z5 ? "audio/amr-wb" : "audio/3gpp").Y(f8519u).J(1).h0(z5 ? 16000 : 8000).G());
    }

    @RequiresNonNull({"extractorOutput"})
    private void p(long j6, int i6) {
        b0 bVar;
        int i7;
        if (this.f8526g) {
            return;
        }
        int i8 = this.f8521b;
        if ((i8 & 1) == 0 || j6 == -1 || !((i7 = this.f8528i) == -1 || i7 == this.f8524e)) {
            bVar = new b0.b(-9223372036854775807L);
        } else if (this.f8529j < 20 && i6 != -1) {
            return;
        } else {
            bVar = h(j6, (i8 & 2) != 0);
        }
        this.f8533n = bVar;
        this.f8531l.t(bVar);
        this.f8526g = true;
    }

    private static boolean q(m mVar, byte[] bArr) {
        mVar.g();
        byte[] bArr2 = new byte[bArr.length];
        mVar.m(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    private int r(m mVar) {
        mVar.g();
        mVar.m(this.f8520a, 0, 1);
        byte b6 = this.f8520a[0];
        if ((b6 & 131) <= 0) {
            return i((b6 >> 3) & 15);
        }
        throw g3.a("Invalid padding bits for frame header " + ((int) b6), null);
    }

    private boolean s(m mVar) {
        int length;
        byte[] bArr = f8517s;
        if (q(mVar, bArr)) {
            this.f8522c = false;
            length = bArr.length;
        } else {
            byte[] bArr2 = f8518t;
            if (!q(mVar, bArr2)) {
                return false;
            }
            this.f8522c = true;
            length = bArr2.length;
        }
        mVar.h(length);
        return true;
    }

    @RequiresNonNull({"trackOutput"})
    private int t(m mVar) {
        if (this.f8525f == 0) {
            try {
                int r6 = r(mVar);
                this.f8524e = r6;
                this.f8525f = r6;
                if (this.f8528i == -1) {
                    this.f8527h = mVar.getPosition();
                    this.f8528i = this.f8524e;
                }
                if (this.f8528i == this.f8524e) {
                    this.f8529j++;
                }
            } catch (EOFException unused) {
                return -1;
            }
        }
        int b6 = this.f8532m.b(mVar, this.f8525f, true);
        if (b6 == -1) {
            return -1;
        }
        int i6 = this.f8525f - b6;
        this.f8525f = i6;
        if (i6 > 0) {
            return 0;
        }
        this.f8532m.e(this.f8530k + this.f8523d, 1, this.f8524e, 0, null);
        this.f8523d += 20000;
        return 0;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        this.f8523d = 0L;
        this.f8524e = 0;
        this.f8525f = 0;
        if (j6 != 0) {
            b0 b0Var = this.f8533n;
            if (b0Var instanceof e) {
                this.f8530k = ((e) b0Var).b(j6);
                return;
            }
        }
        this.f8530k = 0L;
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f8531l = nVar;
        this.f8532m = nVar.e(0, 1);
        nVar.j();
    }

    @Override // o0.l
    public boolean g(m mVar) {
        return s(mVar);
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        e();
        if (mVar.getPosition() == 0 && !s(mVar)) {
            throw g3.a("Could not find AMR header.", null);
        }
        o();
        int t5 = t(mVar);
        p(mVar.getLength(), t5);
        return t5;
    }
}
