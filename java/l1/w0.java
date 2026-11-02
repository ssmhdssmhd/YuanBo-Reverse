package l1;

import android.os.Bundle;
import h0.o;
import i2.c1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w0 implements h0.o {

    /* renamed from: d, reason: collision with root package name */
    public static final w0 f7454d = new w0(new u0[0]);

    /* renamed from: e, reason: collision with root package name */
    private static final String f7455e = c1.s0(0);

    /* renamed from: j, reason: collision with root package name */
    public static final o.a<w0> f7456j = new o.a() { // from class: l1.v0
        @Override // h0.o.a
        public final h0.o a(Bundle bundle) {
            w0 d6;
            d6 = w0.d(bundle);
            return d6;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final int f7457a;

    /* renamed from: b, reason: collision with root package name */
    private final m2.q<u0> f7458b;

    /* renamed from: c, reason: collision with root package name */
    private int f7459c;

    public w0(u0... u0VarArr) {
        this.f7458b = m2.q.n(u0VarArr);
        this.f7457a = u0VarArr.length;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ w0 d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f7455e);
        return parcelableArrayList == null ? new w0(new u0[0]) : new w0((u0[]) i2.d.b(u0.f7444l, parcelableArrayList).toArray(new u0[0]));
    }

    private void e() {
        int i6 = 0;
        while (i6 < this.f7458b.size()) {
            int i7 = i6 + 1;
            for (int i8 = i7; i8 < this.f7458b.size(); i8++) {
                if (this.f7458b.get(i6).equals(this.f7458b.get(i8))) {
                    i2.t.d("TrackGroupArray", "", new IllegalArgumentException("Multiple identical TrackGroups added to one TrackGroupArray."));
                }
            }
            i6 = i7;
        }
    }

    public u0 b(int i6) {
        return this.f7458b.get(i6);
    }

    public int c(u0 u0Var) {
        int indexOf = this.f7458b.indexOf(u0Var);
        if (indexOf >= 0) {
            return indexOf;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w0.class != obj.getClass()) {
            return false;
        }
        w0 w0Var = (w0) obj;
        return this.f7457a == w0Var.f7457a && this.f7458b.equals(w0Var.f7458b);
    }

    public int hashCode() {
        if (this.f7459c == 0) {
            this.f7459c = this.f7458b.hashCode();
        }
        return this.f7459c;
    }
}
