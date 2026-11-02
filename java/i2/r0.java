package i2;

/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    private long f5645a;

    /* renamed from: b, reason: collision with root package name */
    private long f5646b;

    /* renamed from: c, reason: collision with root package name */
    private long f5647c;

    /* renamed from: d, reason: collision with root package name */
    private final ThreadLocal<Long> f5648d = new ThreadLocal<>();

    public r0(long j6) {
        g(j6);
    }

    public static long f(long j6) {
        return (j6 * 1000000) / 90000;
    }

    public static long i(long j6) {
        return (j6 * 90000) / 1000000;
    }

    public static long j(long j6) {
        return i(j6) % 8589934592L;
    }

    public synchronized long a(long j6) {
        if (j6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (this.f5646b == -9223372036854775807L) {
            long j7 = this.f5645a;
            if (j7 == 9223372036854775806L) {
                j7 = ((Long) a.e(this.f5648d.get())).longValue();
            }
            this.f5646b = j7 - j6;
            notifyAll();
        }
        this.f5647c = j6;
        return j6 + this.f5646b;
    }

    public synchronized long b(long j6) {
        if (j6 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j7 = this.f5647c;
        if (j7 != -9223372036854775807L) {
            long i6 = i(j7);
            long j8 = (4294967296L + i6) / 8589934592L;
            long j9 = ((j8 - 1) * 8589934592L) + j6;
            j6 += j8 * 8589934592L;
            if (Math.abs(j9 - i6) < Math.abs(j6 - i6)) {
                j6 = j9;
            }
        }
        return a(f(j6));
    }

    public synchronized long c() {
        long j6;
        j6 = this.f5645a;
        if (j6 == Long.MAX_VALUE || j6 == 9223372036854775806L) {
            j6 = -9223372036854775807L;
        }
        return j6;
    }

    public synchronized long d() {
        long j6;
        j6 = this.f5647c;
        return j6 != -9223372036854775807L ? j6 + this.f5646b : c();
    }

    public synchronized long e() {
        return this.f5646b;
    }

    public synchronized void g(long j6) {
        this.f5645a = j6;
        this.f5646b = j6 == Long.MAX_VALUE ? 0L : -9223372036854775807L;
        this.f5647c = -9223372036854775807L;
    }

    public synchronized void h(boolean z5, long j6) {
        a.g(this.f5645a == 9223372036854775806L);
        if (this.f5646b != -9223372036854775807L) {
            return;
        }
        if (z5) {
            this.f5648d.set(Long.valueOf(j6));
        } else {
            while (this.f5646b == -9223372036854775807L) {
                wait();
            }
        }
    }
}
