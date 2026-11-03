package h0;

import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public final class i3 extends v3 {

    /* renamed from: d, reason: collision with root package name */
    private static final String f4525d = i2.c1.s0(1);

    /* renamed from: e, reason: collision with root package name */
    public static final o.a<i3> f4526e = new o.a() { // from class: h0.h3
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            i3 d6;
            d6 = i3.d(bundle);
            return d6;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final float f4527c;

    public i3() {
        this.f4527c = -1.0f;
    }

    public i3(float f6) {
        i2.a.b(f6 >= 0.0f && f6 <= 100.0f, "percent must be in the range of [0, 100]");
        this.f4527c = f6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static i3 d(Bundle bundle) {
        i2.a.a(bundle.getInt(v3.f4979a, -1) == 1);
        float f6 = bundle.getFloat(f4525d, -1.0f);
        return f6 == -1.0f ? new i3() : new i3(f6);
    }

    public boolean equals(Object obj) {
        return (obj instanceof i3) && this.f4527c == ((i3) obj).f4527c;
    }

    public int hashCode() {
        return l2.j.b(Float.valueOf(this.f4527c));
    }
}
