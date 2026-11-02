package h0;

import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public final class k4 extends v3 {

    /* renamed from: e, reason: collision with root package name */
    private static final String f4553e = i2.c1.s0(1);

    /* renamed from: j, reason: collision with root package name */
    private static final String f4554j = i2.c1.s0(2);

    /* renamed from: k, reason: collision with root package name */
    public static final o.a<k4> f4555k = new o.a() { // from class: h0.j4
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            k4 d6;
            d6 = k4.d(bundle);
            return d6;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final boolean f4556c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f4557d;

    public k4() {
        this.f4556c = false;
        this.f4557d = false;
    }

    public k4(boolean z5) {
        this.f4556c = true;
        this.f4557d = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static k4 d(Bundle bundle) {
        i2.a.a(bundle.getInt(v3.f4979a, -1) == 3);
        return bundle.getBoolean(f4553e, false) ? new k4(bundle.getBoolean(f4554j, false)) : new k4();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k4)) {
            return false;
        }
        k4 k4Var = (k4) obj;
        return this.f4557d == k4Var.f4557d && this.f4556c == k4Var.f4556c;
    }

    public int hashCode() {
        return l2.j.b(Boolean.valueOf(this.f4556c), Boolean.valueOf(this.f4557d));
    }
}
