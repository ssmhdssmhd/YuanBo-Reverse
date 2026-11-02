package h0;

import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public final class e4 extends v3 {

    /* renamed from: e, reason: collision with root package name */
    private static final String f4311e = i2.c1.s0(1);

    /* renamed from: j, reason: collision with root package name */
    private static final String f4312j = i2.c1.s0(2);

    /* renamed from: k, reason: collision with root package name */
    public static final o.a<e4> f4313k = new o.a() { // from class: h0.d4
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            e4 d6;
            d6 = e4.d(bundle);
            return d6;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final int f4314c;

    /* renamed from: d, reason: collision with root package name */
    private final float f4315d;

    public e4(int i6) {
        i2.a.b(i6 > 0, "maxStars must be a positive integer");
        this.f4314c = i6;
        this.f4315d = -1.0f;
    }

    public e4(int i6, float f6) {
        i2.a.b(i6 > 0, "maxStars must be a positive integer");
        i2.a.b(f6 >= 0.0f && f6 <= ((float) i6), "starRating is out of range [0, maxStars]");
        this.f4314c = i6;
        this.f4315d = f6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static e4 d(Bundle bundle) {
        i2.a.a(bundle.getInt(v3.f4979a, -1) == 2);
        int i6 = bundle.getInt(f4311e, 5);
        float f6 = bundle.getFloat(f4312j, -1.0f);
        return f6 == -1.0f ? new e4(i6) : new e4(i6, f6);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e4)) {
            return false;
        }
        e4 e4Var = (e4) obj;
        return this.f4314c == e4Var.f4314c && this.f4315d == e4Var.f4315d;
    }

    public int hashCode() {
        return l2.j.b(Integer.valueOf(this.f4314c), Float.valueOf(this.f4315d));
    }
}
