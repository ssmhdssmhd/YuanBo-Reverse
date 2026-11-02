package l1;

import android.util.SparseArray;

/* loaded from: classes.dex */
final class s0<V> {

    /* renamed from: c, reason: collision with root package name */
    private final i2.i<V> f7436c;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray<V> f7435b = new SparseArray<>();

    /* renamed from: a, reason: collision with root package name */
    private int f7434a = -1;

    public s0(i2.i<V> iVar) {
        this.f7436c = iVar;
    }

    public void a(int i6, V v5) {
        if (this.f7434a == -1) {
            i2.a.g(this.f7435b.size() == 0);
            this.f7434a = 0;
        }
        if (this.f7435b.size() > 0) {
            SparseArray<V> sparseArray = this.f7435b;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            i2.a.a(i6 >= keyAt);
            if (keyAt == i6) {
                i2.i<V> iVar = this.f7436c;
                SparseArray<V> sparseArray2 = this.f7435b;
                iVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.f7435b.append(i6, v5);
    }

    public void b() {
        for (int i6 = 0; i6 < this.f7435b.size(); i6++) {
            this.f7436c.accept(this.f7435b.valueAt(i6));
        }
        this.f7434a = -1;
        this.f7435b.clear();
    }

    public void c(int i6) {
        for (int size = this.f7435b.size() - 1; size >= 0 && i6 < this.f7435b.keyAt(size); size--) {
            this.f7436c.accept(this.f7435b.valueAt(size));
            this.f7435b.removeAt(size);
        }
        this.f7434a = this.f7435b.size() > 0 ? Math.min(this.f7434a, this.f7435b.size() - 1) : -1;
    }

    public void d(int i6) {
        int i7 = 0;
        while (i7 < this.f7435b.size() - 1) {
            int i8 = i7 + 1;
            if (i6 < this.f7435b.keyAt(i8)) {
                return;
            }
            this.f7436c.accept(this.f7435b.valueAt(i7));
            this.f7435b.removeAt(i7);
            int i9 = this.f7434a;
            if (i9 > 0) {
                this.f7434a = i9 - 1;
            }
            i7 = i8;
        }
    }

    public V e(int i6) {
        if (this.f7434a == -1) {
            this.f7434a = 0;
        }
        while (true) {
            int i7 = this.f7434a;
            if (i7 <= 0 || i6 >= this.f7435b.keyAt(i7)) {
                break;
            }
            this.f7434a--;
        }
        while (this.f7434a < this.f7435b.size() - 1 && i6 >= this.f7435b.keyAt(this.f7434a + 1)) {
            this.f7434a++;
        }
        return this.f7435b.valueAt(this.f7434a);
    }

    public V f() {
        return this.f7435b.valueAt(r0.size() - 1);
    }

    public boolean g() {
        return this.f7435b.size() == 0;
    }
}
