package j2;

import android.os.Bundle;
import h0.o;
import i2.c1;

/* loaded from: classes.dex */
public final class d0 implements h0.o {

    /* renamed from: e, reason: collision with root package name */
    public static final d0 f6689e = new d0(0, 0);

    /* renamed from: j, reason: collision with root package name */
    private static final String f6690j = c1.s0(0);

    /* renamed from: k, reason: collision with root package name */
    private static final String f6691k = c1.s0(1);

    /* renamed from: l, reason: collision with root package name */
    private static final String f6692l = c1.s0(2);

    /* renamed from: m, reason: collision with root package name */
    private static final String f6693m = c1.s0(3);

    /* renamed from: n, reason: collision with root package name */
    public static final o.a<d0> f6694n = new o.a() { // from class: j2.c0
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            d0 b6;
            b6 = d0.b(bundle);
            return b6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f6695a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6696b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6697c;

    /* renamed from: d, reason: collision with root package name */
    public final float f6698d;

    public d0(int i6, int i7) {
        this(i6, i7, 0, 1.0f);
    }

    public d0(int i6, int i7, int i8, float f6) {
        this.f6695a = i6;
        this.f6696b = i7;
        this.f6697c = i8;
        this.f6698d = f6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ d0 b(Bundle bundle) {
        return new d0(bundle.getInt(f6690j, 0), bundle.getInt(f6691k, 0), bundle.getInt(f6692l, 0), bundle.getFloat(f6693m, 1.0f));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return this.f6695a == d0Var.f6695a && this.f6696b == d0Var.f6696b && this.f6697c == d0Var.f6697c && this.f6698d == d0Var.f6698d;
    }

    public int hashCode() {
        return ((((((217 + this.f6695a) * 31) + this.f6696b) * 31) + this.f6697c) * 31) + Float.floatToRawIntBits(this.f6698d);
    }
}
