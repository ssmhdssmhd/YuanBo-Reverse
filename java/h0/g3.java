package h0;

import java.io.IOException;

/* loaded from: classes.dex */
public class g3 extends IOException {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f4342a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4343b;

    protected g3(String str, Throwable th, boolean z5, int i6) {
        super(str, th);
        this.f4342a = z5;
        this.f4343b = i6;
    }

    public static g3 a(String str, Throwable th) {
        return new g3(str, th, true, 1);
    }

    public static g3 b(String str, Throwable th) {
        return new g3(str, th, true, 0);
    }

    public static g3 c(String str, Throwable th) {
        return new g3(str, th, true, 4);
    }

    public static g3 d(String str) {
        return new g3(str, null, false, 1);
    }
}
