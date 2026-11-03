package h0;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import h0.o;
import java.io.IOException;

/* loaded from: classes.dex */
public final class x extends k3 {

    /* renamed from: t, reason: collision with root package name */
    public static final o.a<x> f4990t = new o.a() { // from class: h0.w
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            return x.d(bundle);
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private static final String f4991u = i2.c1.s0(1001);

    /* renamed from: v, reason: collision with root package name */
    private static final String f4992v = i2.c1.s0(1002);

    /* renamed from: w, reason: collision with root package name */
    private static final String f4993w = i2.c1.s0(1003);

    /* renamed from: x, reason: collision with root package name */
    private static final String f4994x = i2.c1.s0(1004);

    /* renamed from: y, reason: collision with root package name */
    private static final String f4995y = i2.c1.s0(1005);

    /* renamed from: z, reason: collision with root package name */
    private static final String f4996z = i2.c1.s0(1006);

    /* renamed from: m, reason: collision with root package name */
    public final int f4997m;

    /* renamed from: n, reason: collision with root package name */
    public final String f4998n;

    /* renamed from: o, reason: collision with root package name */
    public final int f4999o;

    /* renamed from: p, reason: collision with root package name */
    public final y1 f5000p;

    /* renamed from: q, reason: collision with root package name */
    public final int f5001q;

    /* renamed from: r, reason: collision with root package name */
    public final l1.t f5002r;

    /* renamed from: s, reason: collision with root package name */
    final boolean f5003s;

    private x(int i6, Throwable th, int i7) {
        this(i6, th, null, i7, null, -1, null, 4, false);
    }

    private x(int i6, Throwable th, String str, int i7, String str2, int i8, y1 y1Var, int i9, boolean z5) {
        this(j(i6, str, str2, i8, y1Var, i9), th, i7, i6, str2, i8, y1Var, i9, null, SystemClock.elapsedRealtime(), z5);
    }

    private x(Bundle bundle) {
        super(bundle);
        this.f4997m = bundle.getInt(f4991u, 2);
        this.f4998n = bundle.getString(f4992v);
        this.f4999o = bundle.getInt(f4993w, -1);
        Bundle bundle2 = bundle.getBundle(f4994x);
        this.f5000p = bundle2 == null ? null : y1.f5054t0.a(bundle2);
        this.f5001q = bundle.getInt(f4995y, 4);
        this.f5003s = bundle.getBoolean(f4996z, false);
        this.f5002r = null;
    }

    private x(String str, Throwable th, int i6, int i7, String str2, int i8, y1 y1Var, int i9, l1.t tVar, long j6, boolean z5) {
        super(str, th, i6, j6);
        i2.a.a(!z5 || i7 == 1);
        i2.a.a(th != null || i7 == 3);
        this.f4997m = i7;
        this.f4998n = str2;
        this.f4999o = i8;
        this.f5000p = y1Var;
        this.f5001q = i9;
        this.f5002r = tVar;
        this.f5003s = z5;
    }

    public static /* synthetic */ x d(Bundle bundle) {
        return new x(bundle);
    }

    public static x f(Throwable th, String str, int i6, y1 y1Var, int i7, boolean z5, int i8) {
        return new x(1, th, null, i8, str, i6, y1Var, y1Var == null ? 4 : i7, z5);
    }

    public static x g(IOException iOException, int i6) {
        return new x(0, iOException, i6);
    }

    @Deprecated
    public static x h(RuntimeException runtimeException) {
        return i(runtimeException, 1000);
    }

    public static x i(RuntimeException runtimeException, int i6) {
        return new x(2, runtimeException, i6);
    }

    private static String j(int i6, String str, String str2, int i7, y1 y1Var, int i8) {
        String str3;
        if (i6 == 0) {
            str3 = "Source error";
        } else if (i6 != 1) {
            str3 = i6 != 3 ? "Unexpected runtime error" : "Remote error";
        } else {
            str3 = str2 + " error, index=" + i7 + ", format=" + y1Var + ", format_supported=" + i2.c1.Y(i8);
        }
        if (TextUtils.isEmpty(str)) {
            return str3;
        }
        return str3 + ": " + str;
    }

    x e(l1.t tVar) {
        return new x((String) i2.c1.j(getMessage()), getCause(), this.f4551a, this.f4997m, this.f4998n, this.f4999o, this.f5000p, this.f5001q, tVar, this.f4552b, this.f5003s);
    }
}
