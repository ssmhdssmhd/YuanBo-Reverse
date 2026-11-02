package i0;

import android.media.metrics.LogSessionId;

/* loaded from: classes.dex */
public final class o3 {

    /* renamed from: b, reason: collision with root package name */
    public static final o3 f5416b;

    /* renamed from: a, reason: collision with root package name */
    private final a f5417a;

    private static final class a {

        /* renamed from: b, reason: collision with root package name */
        public static final a f5418b;

        /* renamed from: a, reason: collision with root package name */
        public final LogSessionId f5419a;

        static {
            LogSessionId logSessionId;
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            f5418b = new a(logSessionId);
        }

        public a(LogSessionId logSessionId) {
            this.f5419a = logSessionId;
        }
    }

    static {
        f5416b = i2.c1.f5548a < 31 ? new o3() : new o3(a.f5418b);
    }

    public o3() {
        this((a) null);
        i2.a.g(i2.c1.f5548a < 31);
    }

    public o3(LogSessionId logSessionId) {
        this(new a(logSessionId));
    }

    private o3(a aVar) {
        this.f5417a = aVar;
    }

    public LogSessionId a() {
        return ((a) i2.a.e(this.f5417a)).f5419a;
    }
}
