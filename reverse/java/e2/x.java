package e2;

import android.os.Bundle;
import h0.o;
import i2.c1;
import java.util.Collections;
import java.util.List;
import l1.u0;

/* loaded from: classes.dex */
public final class x implements h0.o {

    /* renamed from: c, reason: collision with root package name */
    private static final String f3536c = c1.s0(0);

    /* renamed from: d, reason: collision with root package name */
    private static final String f3537d = c1.s0(1);

    /* renamed from: e, reason: collision with root package name */
    public static final o.a<x> f3538e = new o.a() { // from class: e2.w
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            x c6;
            c6 = x.c(bundle);
            return c6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final u0 f3539a;

    /* renamed from: b, reason: collision with root package name */
    public final m2.q<Integer> f3540b;

    public x(u0 u0Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= u0Var.f7445a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f3539a = u0Var;
        this.f3540b = m2.q.m(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x c(Bundle bundle) {
        return new x(u0.f7444l.a((Bundle) i2.a.e(bundle.getBundle(f3536c))), o2.e.c((int[]) i2.a.e(bundle.getIntArray(f3537d))));
    }

    public int b() {
        return this.f3539a.f7447c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.f3539a.equals(xVar.f3539a) && this.f3540b.equals(xVar.f3540b);
    }

    public int hashCode() {
        return this.f3539a.hashCode() + (this.f3540b.hashCode() * 31);
    }
}
