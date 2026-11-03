package h0;

import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public final class c2 extends v3 {

    /* renamed from: e, reason: collision with root package name */
    private static final String f4282e = i2.c1.s0(1);

    /* renamed from: j, reason: collision with root package name */
    private static final String f4283j = i2.c1.s0(2);

    /* renamed from: k, reason: collision with root package name */
    public static final o.a<c2> f4284k = new o.a() { // from class: h0.b2
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            c2 d6;
            d6 = c2.d(bundle);
            return d6;
        }
    };

    /* renamed from: c, reason: collision with root package name */
    private final boolean f4285c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f4286d;

    public c2() {
        this.f4285c = false;
        this.f4286d = false;
    }

    public c2(boolean z5) {
        this.f4285c = true;
        this.f4286d = z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static c2 d(Bundle bundle) {
        i2.a.a(bundle.getInt(v3.f4979a, -1) == 0);
        return bundle.getBoolean(f4282e, false) ? new c2(bundle.getBoolean(f4283j, false)) : new c2();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return this.f4286d == c2Var.f4286d && this.f4285c == c2Var.f4285c;
    }

    public int hashCode() {
        return l2.j.b(Boolean.valueOf(this.f4285c), Boolean.valueOf(this.f4286d));
    }
}
