package m2;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class l0<E> extends s<E> {

    /* renamed from: l, reason: collision with root package name */
    private static final Object[] f8010l;

    /* renamed from: m, reason: collision with root package name */
    static final l0<Object> f8011m;

    /* renamed from: c, reason: collision with root package name */
    final transient Object[] f8012c;

    /* renamed from: d, reason: collision with root package name */
    private final transient int f8013d;

    /* renamed from: e, reason: collision with root package name */
    final transient Object[] f8014e;

    /* renamed from: j, reason: collision with root package name */
    private final transient int f8015j;

    /* renamed from: k, reason: collision with root package name */
    private final transient int f8016k;

    static {
        Object[] objArr = new Object[0];
        f8010l = objArr;
        f8011m = new l0<>(objArr, 0, objArr, 0, 0);
    }

    l0(Object[] objArr, int i6, Object[] objArr2, int i7, int i8) {
        this.f8012c = objArr;
        this.f8013d = i6;
        this.f8014e = objArr2;
        this.f8015j = i7;
        this.f8016k = i8;
    }

    @Override // m2.o
    int c(Object[] objArr, int i6) {
        System.arraycopy(this.f8012c, 0, objArr, i6, this.f8016k);
        return i6 + this.f8016k;
    }

    @Override // m2.o, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.f8014e;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int b6 = n.b(obj);
        while (true) {
            int i6 = b6 & this.f8015j;
            Object obj2 = objArr[i6];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            b6 = i6 + 1;
        }
    }

    @Override // m2.o
    Object[] d() {
        return this.f8012c;
    }

    @Override // m2.o
    int e() {
        return this.f8016k;
    }

    @Override // m2.o
    int f() {
        return 0;
    }

    @Override // m2.o
    boolean g() {
        return false;
    }

    @Override // m2.s, m2.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: h */
    public s0<E> iterator() {
        return b().iterator();
    }

    @Override // m2.s, java.util.Collection, java.util.Set
    public int hashCode() {
        return this.f8013d;
    }

    @Override // m2.s
    q<E> m() {
        return q.j(this.f8012c, this.f8016k);
    }

    @Override // m2.s
    boolean n() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f8016k;
    }
}
