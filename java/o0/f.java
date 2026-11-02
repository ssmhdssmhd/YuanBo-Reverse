package o0;

import h0.v1;
import i2.c1;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class f implements m {

    /* renamed from: b, reason: collision with root package name */
    private final g2.i f8352b;

    /* renamed from: c, reason: collision with root package name */
    private final long f8353c;

    /* renamed from: d, reason: collision with root package name */
    private long f8354d;

    /* renamed from: f, reason: collision with root package name */
    private int f8356f;

    /* renamed from: g, reason: collision with root package name */
    private int f8357g;

    /* renamed from: e, reason: collision with root package name */
    private byte[] f8355e = new byte[65536];

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8351a = new byte[4096];

    static {
        v1.a("goog.exo.extractor");
    }

    public f(g2.i iVar, long j6, long j7) {
        this.f8352b = iVar;
        this.f8354d = j6;
        this.f8353c = j7;
    }

    private void o(int i6) {
        if (i6 != -1) {
            this.f8354d += i6;
        }
    }

    private void p(int i6) {
        int i7 = this.f8356f + i6;
        byte[] bArr = this.f8355e;
        if (i7 > bArr.length) {
            this.f8355e = Arrays.copyOf(this.f8355e, c1.q(bArr.length * 2, 65536 + i7, i7 + 524288));
        }
    }

    private int q(byte[] bArr, int i6, int i7) {
        int i8 = this.f8357g;
        if (i8 == 0) {
            return 0;
        }
        int min = Math.min(i8, i7);
        System.arraycopy(this.f8355e, 0, bArr, i6, min);
        u(min);
        return min;
    }

    private int r(byte[] bArr, int i6, int i7, int i8, boolean z5) {
        if (Thread.interrupted()) {
            throw new InterruptedIOException();
        }
        int read = this.f8352b.read(bArr, i6 + i8, i7 - i8);
        if (read != -1) {
            return i8 + read;
        }
        if (i8 == 0 && z5) {
            return -1;
        }
        throw new EOFException();
    }

    private int s(int i6) {
        int min = Math.min(this.f8357g, i6);
        u(min);
        return min;
    }

    private void u(int i6) {
        int i7 = this.f8357g - i6;
        this.f8357g = i7;
        this.f8356f = 0;
        byte[] bArr = this.f8355e;
        byte[] bArr2 = i7 < bArr.length - 524288 ? new byte[65536 + i7] : bArr;
        System.arraycopy(bArr, i6, bArr2, 0, i7);
        this.f8355e = bArr2;
    }

    @Override // o0.m
    public int b(int i6) {
        int s5 = s(i6);
        if (s5 == 0) {
            byte[] bArr = this.f8351a;
            s5 = r(bArr, 0, Math.min(i6, bArr.length), 0, true);
        }
        o(s5);
        return s5;
    }

    @Override // o0.m
    public boolean d(byte[] bArr, int i6, int i7, boolean z5) {
        int q6 = q(bArr, i6, i7);
        while (q6 < i7 && q6 != -1) {
            q6 = r(bArr, i6, i7, q6, z5);
        }
        o(q6);
        return q6 != -1;
    }

    @Override // o0.m
    public int e(byte[] bArr, int i6, int i7) {
        int min;
        p(i7);
        int i8 = this.f8357g;
        int i9 = this.f8356f;
        int i10 = i8 - i9;
        if (i10 == 0) {
            min = r(this.f8355e, i9, i7, 0, true);
            if (min == -1) {
                return -1;
            }
            this.f8357g += min;
        } else {
            min = Math.min(i7, i10);
        }
        System.arraycopy(this.f8355e, this.f8356f, bArr, i6, min);
        this.f8356f += min;
        return min;
    }

    @Override // o0.m
    public void g() {
        this.f8356f = 0;
    }

    @Override // o0.m
    public long getLength() {
        return this.f8353c;
    }

    @Override // o0.m
    public long getPosition() {
        return this.f8354d;
    }

    @Override // o0.m
    public void h(int i6) {
        t(i6, false);
    }

    @Override // o0.m
    public boolean i(int i6, boolean z5) {
        p(i6);
        int i7 = this.f8357g - this.f8356f;
        while (i7 < i6) {
            i7 = r(this.f8355e, this.f8356f, i6, i7, z5);
            if (i7 == -1) {
                return false;
            }
            this.f8357g = this.f8356f + i7;
        }
        this.f8356f += i6;
        return true;
    }

    @Override // o0.m
    public boolean k(byte[] bArr, int i6, int i7, boolean z5) {
        if (!i(i7, z5)) {
            return false;
        }
        System.arraycopy(this.f8355e, this.f8356f - i7, bArr, i6, i7);
        return true;
    }

    @Override // o0.m
    public long l() {
        return this.f8354d + this.f8356f;
    }

    @Override // o0.m
    public void m(byte[] bArr, int i6, int i7) {
        k(bArr, i6, i7, false);
    }

    @Override // o0.m
    public void n(int i6) {
        i(i6, false);
    }

    @Override // o0.m, g2.i
    public int read(byte[] bArr, int i6, int i7) {
        int q6 = q(bArr, i6, i7);
        if (q6 == 0) {
            q6 = r(bArr, i6, i7, 0, true);
        }
        o(q6);
        return q6;
    }

    @Override // o0.m
    public void readFully(byte[] bArr, int i6, int i7) {
        d(bArr, i6, i7, false);
    }

    public boolean t(int i6, boolean z5) {
        int s5 = s(i6);
        while (s5 < i6 && s5 != -1) {
            s5 = r(this.f8351a, -s5, Math.min(i6, this.f8351a.length + s5), s5, z5);
        }
        o(s5);
        return s5 != -1;
    }
}
