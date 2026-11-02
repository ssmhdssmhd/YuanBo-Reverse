package h0;

import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public final class n3 implements o {

    /* renamed from: d, reason: collision with root package name */
    public static final n3 f4728d = new n3(1.0f);

    /* renamed from: e, reason: collision with root package name */
    private static final String f4729e = i2.c1.s0(0);

    /* renamed from: j, reason: collision with root package name */
    private static final String f4730j = i2.c1.s0(1);

    /* renamed from: k, reason: collision with root package name */
    public static final o.a<n3> f4731k = new o.a() { // from class: h0.m3
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            n3 c6;
            c6 = n3.c(bundle);
            return c6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final float f4732a;

    /* renamed from: b, reason: collision with root package name */
    public final float f4733b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4734c;

    public n3(float f6) {
        this(f6, 1.0f);
    }

    public n3(float f6, float f7) {
        i2.a.a(f6 > 0.0f);
        i2.a.a(f7 > 0.0f);
        this.f4732a = f6;
        this.f4733b = f7;
        this.f4734c = Math.round(f6 * 1000.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ n3 c(Bundle bundle) {
        return new n3(bundle.getFloat(f4729e, 1.0f), bundle.getFloat(f4730j, 1.0f));
    }

    public long b(long j6) {
        return j6 * this.f4734c;
    }

    public n3 d(float f6) {
        return new n3(f6, this.f4733b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n3.class != obj.getClass()) {
            return false;
        }
        n3 n3Var = (n3) obj;
        return this.f4732a == n3Var.f4732a && this.f4733b == n3Var.f4733b;
    }

    public int hashCode() {
        return ((527 + Float.floatToRawIntBits(this.f4732a)) * 31) + Float.floatToRawIntBits(this.f4733b);
    }

    public String toString() {
        return i2.c1.C("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f4732a), Float.valueOf(this.f4733b));
    }
}
