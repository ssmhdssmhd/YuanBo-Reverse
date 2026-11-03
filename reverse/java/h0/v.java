package h0;

import android.os.Bundle;
import h0.o;

/* loaded from: classes.dex */
public final class v implements o {

    /* renamed from: d, reason: collision with root package name */
    public static final v f4966d = new v(0, 0, 0);

    /* renamed from: e, reason: collision with root package name */
    private static final String f4967e = i2.c1.s0(0);

    /* renamed from: j, reason: collision with root package name */
    private static final String f4968j = i2.c1.s0(1);

    /* renamed from: k, reason: collision with root package name */
    private static final String f4969k = i2.c1.s0(2);

    /* renamed from: l, reason: collision with root package name */
    public static final o.a<v> f4970l = new o.a() { // from class: h0.u
        @Override // h0.o.a
        public final o a(Bundle bundle) {
            v b6;
            b6 = v.b(bundle);
            return b6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f4971a;

    /* renamed from: b, reason: collision with root package name */
    public final int f4972b;

    /* renamed from: c, reason: collision with root package name */
    public final int f4973c;

    public v(int i6, int i7, int i8) {
        this.f4971a = i6;
        this.f4972b = i7;
        this.f4973c = i8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v b(Bundle bundle) {
        return new v(bundle.getInt(f4967e, 0), bundle.getInt(f4968j, 0), bundle.getInt(f4969k, 0));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return this.f4971a == vVar.f4971a && this.f4972b == vVar.f4972b && this.f4973c == vVar.f4973c;
    }

    public int hashCode() {
        return ((((527 + this.f4971a) * 31) + this.f4972b) * 31) + this.f4973c;
    }
}
