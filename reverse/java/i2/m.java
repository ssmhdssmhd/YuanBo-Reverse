package i2;

import android.util.SparseBooleanArray;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    private final SparseBooleanArray f5604a;

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final SparseBooleanArray f5605a = new SparseBooleanArray();

        /* renamed from: b, reason: collision with root package name */
        private boolean f5606b;

        public b a(int i6) {
            i2.a.g(!this.f5606b);
            this.f5605a.append(i6, true);
            return this;
        }

        public b b(m mVar) {
            for (int i6 = 0; i6 < mVar.d(); i6++) {
                a(mVar.c(i6));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i6 : iArr) {
                a(i6);
            }
            return this;
        }

        public b d(int i6, boolean z5) {
            return z5 ? a(i6) : this;
        }

        public m e() {
            i2.a.g(!this.f5606b);
            this.f5606b = true;
            return new m(this.f5605a);
        }
    }

    private m(SparseBooleanArray sparseBooleanArray) {
        this.f5604a = sparseBooleanArray;
    }

    public boolean a(int i6) {
        return this.f5604a.get(i6);
    }

    public boolean b(int... iArr) {
        for (int i6 : iArr) {
            if (a(i6)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i6) {
        i2.a.c(i6, 0, d());
        return this.f5604a.keyAt(i6);
    }

    public int d() {
        return this.f5604a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (c1.f5548a >= 24) {
            return this.f5604a.equals(mVar.f5604a);
        }
        if (d() != mVar.d()) {
            return false;
        }
        for (int i6 = 0; i6 < d(); i6++) {
            if (c(i6) != mVar.c(i6)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (c1.f5548a >= 24) {
            return this.f5604a.hashCode();
        }
        int d6 = d();
        for (int i6 = 0; i6 < d(); i6++) {
            d6 = (d6 * 31) + c(i6);
        }
        return d6;
    }
}
