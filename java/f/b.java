package f;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class b<E> implements Collection<E>, Set<E> {

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f3725e = new int[0];

    /* renamed from: j, reason: collision with root package name */
    private static final Object[] f3726j = new Object[0];

    /* renamed from: k, reason: collision with root package name */
    private static Object[] f3727k;

    /* renamed from: l, reason: collision with root package name */
    private static int f3728l;

    /* renamed from: m, reason: collision with root package name */
    private static Object[] f3729m;

    /* renamed from: n, reason: collision with root package name */
    private static int f3730n;

    /* renamed from: a, reason: collision with root package name */
    private int[] f3731a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f3732b;

    /* renamed from: c, reason: collision with root package name */
    int f3733c;

    /* renamed from: d, reason: collision with root package name */
    private e<E, E> f3734d;

    class a extends e<E, E> {
        a() {
        }

        @Override // f.e
        protected void a() {
            b.this.clear();
        }

        @Override // f.e
        protected Object b(int i6, int i7) {
            return b.this.f3732b[i6];
        }

        @Override // f.e
        protected Map<E, E> c() {
            throw new UnsupportedOperationException("not a map");
        }

        @Override // f.e
        protected int d() {
            return b.this.f3733c;
        }

        @Override // f.e
        protected int e(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // f.e
        protected int f(Object obj) {
            return b.this.indexOf(obj);
        }

        @Override // f.e
        protected void g(E e6, E e7) {
            b.this.add(e6);
        }

        @Override // f.e
        protected void h(int i6) {
            b.this.h(i6);
        }

        @Override // f.e
        protected E i(int i6, E e6) {
            throw new UnsupportedOperationException("not a map");
        }
    }

    public b() {
        this(0);
    }

    public b(int i6) {
        if (i6 == 0) {
            this.f3731a = f3725e;
            this.f3732b = f3726j;
        } else {
            b(i6);
        }
        this.f3733c = 0;
    }

    private void b(int i6) {
        if (i6 == 8) {
            synchronized (b.class) {
                Object[] objArr = f3729m;
                if (objArr != null) {
                    this.f3732b = objArr;
                    f3729m = (Object[]) objArr[0];
                    this.f3731a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3730n--;
                    return;
                }
            }
        } else if (i6 == 4) {
            synchronized (b.class) {
                Object[] objArr2 = f3727k;
                if (objArr2 != null) {
                    this.f3732b = objArr2;
                    f3727k = (Object[]) objArr2[0];
                    this.f3731a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f3728l--;
                    return;
                }
            }
        }
        this.f3731a = new int[i6];
        this.f3732b = new Object[i6];
    }

    private static void d(int[] iArr, Object[] objArr, int i6) {
        if (iArr.length == 8) {
            synchronized (b.class) {
                if (f3730n < 10) {
                    objArr[0] = f3729m;
                    objArr[1] = iArr;
                    for (int i7 = i6 - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f3729m = objArr;
                    f3730n++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (b.class) {
                if (f3728l < 10) {
                    objArr[0] = f3727k;
                    objArr[1] = iArr;
                    for (int i8 = i6 - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f3727k = objArr;
                    f3728l++;
                }
            }
        }
    }

    private e<E, E> e() {
        if (this.f3734d == null) {
            this.f3734d = new a();
        }
        return this.f3734d;
    }

    private int f(Object obj, int i6) {
        int i7 = this.f3733c;
        if (i7 == 0) {
            return -1;
        }
        int a6 = c.a(this.f3731a, i7, i6);
        if (a6 < 0 || obj.equals(this.f3732b[a6])) {
            return a6;
        }
        int i8 = a6 + 1;
        while (i8 < i7 && this.f3731a[i8] == i6) {
            if (obj.equals(this.f3732b[i8])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = a6 - 1; i9 >= 0 && this.f3731a[i9] == i6; i9--) {
            if (obj.equals(this.f3732b[i9])) {
                return i9;
            }
        }
        return ~i8;
    }

    private int g() {
        int i6 = this.f3733c;
        if (i6 == 0) {
            return -1;
        }
        int a6 = c.a(this.f3731a, i6, 0);
        if (a6 < 0 || this.f3732b[a6] == null) {
            return a6;
        }
        int i7 = a6 + 1;
        while (i7 < i6 && this.f3731a[i7] == 0) {
            if (this.f3732b[i7] == null) {
                return i7;
            }
            i7++;
        }
        for (int i8 = a6 - 1; i8 >= 0 && this.f3731a[i8] == 0; i8--) {
            if (this.f3732b[i8] == null) {
                return i8;
            }
        }
        return ~i7;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(E e6) {
        int i6;
        int f6;
        if (e6 == null) {
            f6 = g();
            i6 = 0;
        } else {
            int hashCode = e6.hashCode();
            i6 = hashCode;
            f6 = f(e6, hashCode);
        }
        if (f6 >= 0) {
            return false;
        }
        int i7 = ~f6;
        int i8 = this.f3733c;
        int[] iArr = this.f3731a;
        if (i8 >= iArr.length) {
            int i9 = 8;
            if (i8 >= 8) {
                i9 = (i8 >> 1) + i8;
            } else if (i8 < 4) {
                i9 = 4;
            }
            Object[] objArr = this.f3732b;
            b(i9);
            int[] iArr2 = this.f3731a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr, 0, this.f3732b, 0, objArr.length);
            }
            d(iArr, objArr, this.f3733c);
        }
        int i10 = this.f3733c;
        if (i7 < i10) {
            int[] iArr3 = this.f3731a;
            int i11 = i7 + 1;
            System.arraycopy(iArr3, i7, iArr3, i11, i10 - i7);
            Object[] objArr2 = this.f3732b;
            System.arraycopy(objArr2, i7, objArr2, i11, this.f3733c - i7);
        }
        this.f3731a[i7] = i6;
        this.f3732b[i7] = e6;
        this.f3733c++;
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection<? extends E> collection) {
        c(this.f3733c + collection.size());
        Iterator<? extends E> it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= add(it.next());
        }
        return z5;
    }

    public void c(int i6) {
        int[] iArr = this.f3731a;
        if (iArr.length < i6) {
            Object[] objArr = this.f3732b;
            b(i6);
            int i7 = this.f3733c;
            if (i7 > 0) {
                System.arraycopy(iArr, 0, this.f3731a, 0, i7);
                System.arraycopy(objArr, 0, this.f3732b, 0, this.f3733c);
            }
            d(iArr, objArr, this.f3733c);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i6 = this.f3733c;
        if (i6 != 0) {
            d(this.f3731a, this.f3732b, i6);
            this.f3731a = f3725e;
            this.f3732b = f3726j;
            this.f3733c = 0;
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f3733c; i6++) {
                try {
                    if (!set.contains(i(i6))) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public E h(int i6) {
        Object[] objArr = this.f3732b;
        E e6 = (E) objArr[i6];
        int i7 = this.f3733c;
        if (i7 <= 1) {
            d(this.f3731a, objArr, i7);
            this.f3731a = f3725e;
            this.f3732b = f3726j;
            this.f3733c = 0;
        } else {
            int[] iArr = this.f3731a;
            if (iArr.length <= 8 || i7 >= iArr.length / 3) {
                int i8 = i7 - 1;
                this.f3733c = i8;
                if (i6 < i8) {
                    int i9 = i6 + 1;
                    System.arraycopy(iArr, i9, iArr, i6, i8 - i6);
                    Object[] objArr2 = this.f3732b;
                    System.arraycopy(objArr2, i9, objArr2, i6, this.f3733c - i6);
                }
                this.f3732b[this.f3733c] = null;
            } else {
                b(i7 > 8 ? i7 + (i7 >> 1) : 8);
                this.f3733c--;
                if (i6 > 0) {
                    System.arraycopy(iArr, 0, this.f3731a, 0, i6);
                    System.arraycopy(objArr, 0, this.f3732b, 0, i6);
                }
                int i10 = this.f3733c;
                if (i6 < i10) {
                    int i11 = i6 + 1;
                    System.arraycopy(iArr, i11, this.f3731a, i6, i10 - i6);
                    System.arraycopy(objArr, i11, this.f3732b, i6, this.f3733c - i6);
                }
            }
        }
        return e6;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArr = this.f3731a;
        int i6 = this.f3733c;
        int i7 = 0;
        for (int i8 = 0; i8 < i6; i8++) {
            i7 += iArr[i8];
        }
        return i7;
    }

    public E i(int i6) {
        return (E) this.f3732b[i6];
    }

    public int indexOf(Object obj) {
        return obj == null ? g() : f(obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f3733c <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return e().m().iterator();
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        h(indexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z5 = false;
        while (it.hasNext()) {
            z5 |= remove(it.next());
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection<?> collection) {
        boolean z5 = false;
        for (int i6 = this.f3733c - 1; i6 >= 0; i6--) {
            if (!collection.contains(this.f3732b[i6])) {
                h(i6);
                z5 = true;
            }
        }
        return z5;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.f3733c;
    }

    @Override // java.util.Collection, java.util.Set
    public Object[] toArray() {
        int i6 = this.f3733c;
        Object[] objArr = new Object[i6];
        System.arraycopy(this.f3732b, 0, objArr, 0, i6);
        return objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.f3733c) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.f3733c));
        }
        System.arraycopy(this.f3732b, 0, tArr, 0, this.f3733c);
        int length = tArr.length;
        int i6 = this.f3733c;
        if (length > i6) {
            tArr[i6] = null;
        }
        return tArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3733c * 14);
        sb.append('{');
        for (int i6 = 0; i6 < this.f3733c; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            E i7 = i(i6);
            if (i7 != this) {
                sb.append(i7);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
