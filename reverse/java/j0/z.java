package j0;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.tendcloud.tenddata.ab;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
final class z {
    private long A;
    private long B;
    private long C;
    private long D;
    private boolean E;
    private long F;
    private long G;

    /* renamed from: a, reason: collision with root package name */
    private final a f6637a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f6638b;

    /* renamed from: c, reason: collision with root package name */
    private AudioTrack f6639c;

    /* renamed from: d, reason: collision with root package name */
    private int f6640d;

    /* renamed from: e, reason: collision with root package name */
    private int f6641e;

    /* renamed from: f, reason: collision with root package name */
    private y f6642f;

    /* renamed from: g, reason: collision with root package name */
    private int f6643g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f6644h;

    /* renamed from: i, reason: collision with root package name */
    private long f6645i;

    /* renamed from: j, reason: collision with root package name */
    private float f6646j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f6647k;

    /* renamed from: l, reason: collision with root package name */
    private long f6648l;

    /* renamed from: m, reason: collision with root package name */
    private long f6649m;

    /* renamed from: n, reason: collision with root package name */
    private Method f6650n;

    /* renamed from: o, reason: collision with root package name */
    private long f6651o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f6652p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f6653q;

    /* renamed from: r, reason: collision with root package name */
    private long f6654r;

    /* renamed from: s, reason: collision with root package name */
    private long f6655s;

    /* renamed from: t, reason: collision with root package name */
    private long f6656t;

    /* renamed from: u, reason: collision with root package name */
    private long f6657u;

    /* renamed from: v, reason: collision with root package name */
    private long f6658v;

    /* renamed from: w, reason: collision with root package name */
    private int f6659w;

    /* renamed from: x, reason: collision with root package name */
    private int f6660x;

    /* renamed from: y, reason: collision with root package name */
    private long f6661y;

    /* renamed from: z, reason: collision with root package name */
    private long f6662z;

    public interface a {
        void a(long j6);

        void b(int i6, long j6);

        void c(long j6, long j7, long j8, long j9);

        void d(long j6, long j7, long j8, long j9);

        void e(long j6);
    }

    public z(a aVar) {
        this.f6637a = (a) i2.a.e(aVar);
        if (i2.c1.f5548a >= 18) {
            try {
                this.f6650n = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.f6638b = new long[10];
    }

    private boolean a() {
        return this.f6644h && ((AudioTrack) i2.a.e(this.f6639c)).getPlayState() == 2 && e() == 0;
    }

    private long b(long j6) {
        return (j6 * 1000000) / this.f6643g;
    }

    private long e() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j6 = this.f6661y;
        if (j6 != -9223372036854775807L) {
            return Math.min(this.B, this.A + ((i2.c1.b0((elapsedRealtime * 1000) - j6, this.f6646j) * this.f6643g) / 1000000));
        }
        if (elapsedRealtime - this.f6655s >= 5) {
            v(elapsedRealtime);
            this.f6655s = elapsedRealtime;
        }
        return this.f6656t + (this.f6657u << 32);
    }

    private long f() {
        return b(e());
    }

    private void l(long j6) {
        y yVar = (y) i2.a.e(this.f6642f);
        if (yVar.e(j6)) {
            long c6 = yVar.c();
            long b6 = yVar.b();
            long f6 = f();
            if (Math.abs(c6 - j6) > 5000000) {
                this.f6637a.d(b6, c6, j6, f6);
            } else {
                if (Math.abs(b(b6) - f6) <= 5000000) {
                    yVar.a();
                    return;
                }
                this.f6637a.c(b6, c6, j6, f6);
            }
            yVar.f();
        }
    }

    private void m() {
        long nanoTime = System.nanoTime() / 1000;
        if (nanoTime - this.f6649m >= ab.aa) {
            long f6 = f();
            if (f6 != 0) {
                this.f6638b[this.f6659w] = i2.c1.g0(f6, this.f6646j) - nanoTime;
                this.f6659w = (this.f6659w + 1) % 10;
                int i6 = this.f6660x;
                if (i6 < 10) {
                    this.f6660x = i6 + 1;
                }
                this.f6649m = nanoTime;
                this.f6648l = 0L;
                int i7 = 0;
                while (true) {
                    int i8 = this.f6660x;
                    if (i7 >= i8) {
                        break;
                    }
                    this.f6648l += this.f6638b[i7] / i8;
                    i7++;
                }
            } else {
                return;
            }
        }
        if (this.f6644h) {
            return;
        }
        l(nanoTime);
        n(nanoTime);
    }

    private void n(long j6) {
        Method method;
        if (!this.f6653q || (method = this.f6650n) == null || j6 - this.f6654r < 500000) {
            return;
        }
        try {
            long intValue = (((Integer) i2.c1.j((Integer) method.invoke(i2.a.e(this.f6639c), new Object[0]))).intValue() * 1000) - this.f6645i;
            this.f6651o = intValue;
            long max = Math.max(intValue, 0L);
            this.f6651o = max;
            if (max > 5000000) {
                this.f6637a.e(max);
                this.f6651o = 0L;
            }
        } catch (Exception unused) {
            this.f6650n = null;
        }
        this.f6654r = j6;
    }

    private static boolean o(int i6) {
        return i2.c1.f5548a < 23 && (i6 == 5 || i6 == 6);
    }

    private void r() {
        this.f6648l = 0L;
        this.f6660x = 0;
        this.f6659w = 0;
        this.f6649m = 0L;
        this.D = 0L;
        this.G = 0L;
        this.f6647k = false;
    }

    private void v(long j6) {
        int playState = ((AudioTrack) i2.a.e(this.f6639c)).getPlayState();
        if (playState == 1) {
            return;
        }
        long playbackHeadPosition = r0.getPlaybackHeadPosition() & 4294967295L;
        if (this.f6644h) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.f6658v = this.f6656t;
            }
            playbackHeadPosition += this.f6658v;
        }
        if (i2.c1.f5548a <= 29) {
            if (playbackHeadPosition == 0 && this.f6656t > 0 && playState == 3) {
                if (this.f6662z == -9223372036854775807L) {
                    this.f6662z = j6;
                    return;
                }
                return;
            }
            this.f6662z = -9223372036854775807L;
        }
        if (this.f6656t > playbackHeadPosition) {
            this.f6657u++;
        }
        this.f6656t = playbackHeadPosition;
    }

    public int c(long j6) {
        return this.f6641e - ((int) (j6 - (e() * this.f6640d)));
    }

    public long d(boolean z5) {
        long f6;
        if (((AudioTrack) i2.a.e(this.f6639c)).getPlayState() == 3) {
            m();
        }
        long nanoTime = System.nanoTime() / 1000;
        y yVar = (y) i2.a.e(this.f6642f);
        boolean d6 = yVar.d();
        if (d6) {
            f6 = b(yVar.b()) + i2.c1.b0(nanoTime - yVar.c(), this.f6646j);
        } else {
            f6 = this.f6660x == 0 ? f() : i2.c1.b0(this.f6648l + nanoTime, this.f6646j);
            if (!z5) {
                f6 = Math.max(0L, f6 - this.f6651o);
            }
        }
        if (this.E != d6) {
            this.G = this.D;
            this.F = this.C;
        }
        long j6 = nanoTime - this.G;
        if (j6 < 1000000) {
            long b02 = this.F + i2.c1.b0(j6, this.f6646j);
            long j7 = (j6 * 1000) / 1000000;
            f6 = ((f6 * j7) + ((1000 - j7) * b02)) / 1000;
        }
        if (!this.f6647k) {
            long j8 = this.C;
            if (f6 > j8) {
                this.f6647k = true;
                this.f6637a.a(System.currentTimeMillis() - i2.c1.e1(i2.c1.g0(i2.c1.e1(f6 - j8), this.f6646j)));
            }
        }
        this.D = nanoTime;
        this.C = f6;
        this.E = d6;
        return f6;
    }

    public void g(long j6) {
        this.A = e();
        this.f6661y = SystemClock.elapsedRealtime() * 1000;
        this.B = j6;
    }

    public boolean h(long j6) {
        return j6 > e() || a();
    }

    public boolean i() {
        return ((AudioTrack) i2.a.e(this.f6639c)).getPlayState() == 3;
    }

    public boolean j(long j6) {
        return this.f6662z != -9223372036854775807L && j6 > 0 && SystemClock.elapsedRealtime() - this.f6662z >= 200;
    }

    public boolean k(long j6) {
        int playState = ((AudioTrack) i2.a.e(this.f6639c)).getPlayState();
        if (this.f6644h) {
            if (playState == 2) {
                this.f6652p = false;
                return false;
            }
            if (playState == 1 && e() == 0) {
                return false;
            }
        }
        boolean z5 = this.f6652p;
        boolean h6 = h(j6);
        this.f6652p = h6;
        if (z5 && !h6 && playState != 1) {
            this.f6637a.b(this.f6641e, i2.c1.e1(this.f6645i));
        }
        return true;
    }

    public boolean p() {
        r();
        if (this.f6661y != -9223372036854775807L) {
            return false;
        }
        ((y) i2.a.e(this.f6642f)).g();
        return true;
    }

    public void q() {
        r();
        this.f6639c = null;
        this.f6642f = null;
    }

    public void s(AudioTrack audioTrack, boolean z5, int i6, int i7, int i8) {
        this.f6639c = audioTrack;
        this.f6640d = i7;
        this.f6641e = i8;
        this.f6642f = new y(audioTrack);
        this.f6643g = audioTrack.getSampleRate();
        this.f6644h = z5 && o(i6);
        boolean v02 = i2.c1.v0(i6);
        this.f6653q = v02;
        this.f6645i = v02 ? b(i8 / i7) : -9223372036854775807L;
        this.f6656t = 0L;
        this.f6657u = 0L;
        this.f6658v = 0L;
        this.f6652p = false;
        this.f6661y = -9223372036854775807L;
        this.f6662z = -9223372036854775807L;
        this.f6654r = 0L;
        this.f6651o = 0L;
        this.f6646j = 1.0f;
    }

    public void t(float f6) {
        this.f6646j = f6;
        y yVar = this.f6642f;
        if (yVar != null) {
            yVar.g();
        }
        r();
    }

    public void u() {
        ((y) i2.a.e(this.f6642f)).g();
    }
}
