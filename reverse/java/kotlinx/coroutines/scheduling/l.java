package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.e0;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final long f7123a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f7124b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f7125c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f7126d;

    /* renamed from: e, reason: collision with root package name */
    public static g f7127e;

    /* renamed from: f, reason: collision with root package name */
    public static final i f7128f;

    /* renamed from: g, reason: collision with root package name */
    public static final i f7129g;

    static {
        long e6;
        int b6;
        int d6;
        int d7;
        long e7;
        e6 = e0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f7123a = e6;
        b6 = s4.f.b(c0.a(), 2);
        d6 = e0.d("kotlinx.coroutines.scheduler.core.pool.size", b6, 1, 0, 8, null);
        f7124b = d6;
        d7 = e0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f7125c = d7;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e7 = e0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f7126d = timeUnit.toNanos(e7);
        f7127e = e.f7113a;
        f7128f = new j(0);
        f7129g = new j(1);
    }
}
