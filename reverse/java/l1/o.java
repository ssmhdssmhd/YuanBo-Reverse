package l1;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: h, reason: collision with root package name */
    private static final AtomicLong f7382h = new AtomicLong();

    /* renamed from: a, reason: collision with root package name */
    public final long f7383a;

    /* renamed from: b, reason: collision with root package name */
    public final g2.q f7384b;

    /* renamed from: c, reason: collision with root package name */
    public final Uri f7385c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f7386d;

    /* renamed from: e, reason: collision with root package name */
    public final long f7387e;

    /* renamed from: f, reason: collision with root package name */
    public final long f7388f;

    /* renamed from: g, reason: collision with root package name */
    public final long f7389g;

    public o(long j6, g2.q qVar, long j7) {
        this(j6, qVar, qVar.f4097a, Collections.emptyMap(), j7, 0L, 0L);
    }

    public o(long j6, g2.q qVar, Uri uri, Map<String, List<String>> map, long j7, long j8, long j9) {
        this.f7383a = j6;
        this.f7384b = qVar;
        this.f7385c = uri;
        this.f7386d = map;
        this.f7387e = j7;
        this.f7388f = j8;
        this.f7389g = j9;
    }

    public static long a() {
        return f7382h.getAndIncrement();
    }
}
