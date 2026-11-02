package androidx.core.util;

/* loaded from: classes.dex */
public class f<T> implements e<T> {

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f446a;

    /* renamed from: b, reason: collision with root package name */
    private int f447b;

    public f(int i6) {
        if (i6 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0");
        }
        this.f446a = new Object[i6];
    }

    private boolean c(T t5) {
        for (int i6 = 0; i6 < this.f447b; i6++) {
            if (this.f446a[i6] == t5) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.util.e
    public boolean a(T t5) {
        if (c(t5)) {
            throw new IllegalStateException("Already in the pool!");
        }
        int i6 = this.f447b;
        Object[] objArr = this.f446a;
        if (i6 >= objArr.length) {
            return false;
        }
        objArr[i6] = t5;
        this.f447b = i6 + 1;
        return true;
    }

    @Override // androidx.core.util.e
    public T b() {
        int i6 = this.f447b;
        if (i6 <= 0) {
            return null;
        }
        int i7 = i6 - 1;
        Object[] objArr = this.f446a;
        T t5 = (T) objArr[i7];
        objArr[i7] = null;
        this.f447b = i6 - 1;
        return t5;
    }
}
