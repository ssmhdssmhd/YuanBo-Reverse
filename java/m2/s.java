package m2;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
public abstract class s<E> extends o<E> implements Set<E> {

    /* renamed from: b, reason: collision with root package name */
    @CheckForNull
    @LazyInit
    private transient q<E> f8044b;

    s() {
    }

    static int i(int i6) {
        int max = Math.max(i6, 2);
        if (max >= 751619276) {
            l2.k.e(max < 1073741824, "collection too large");
            return 1073741824;
        }
        int highestOneBit = Integer.highestOneBit(max - 1) << 1;
        while (highestOneBit * 0.7d < max) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    private static <E> s<E> j(int i6, Object... objArr) {
        if (i6 == 0) {
            return o();
        }
        if (i6 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return p(obj);
        }
        int i7 = i(i6);
        Object[] objArr2 = new Object[i7];
        int i8 = i7 - 1;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i6; i11++) {
            Object a6 = g0.a(objArr[i11], i11);
            int hashCode = a6.hashCode();
            int a7 = n.a(hashCode);
            while (true) {
                int i12 = a7 & i8;
                Object obj2 = objArr2[i12];
                if (obj2 == null) {
                    objArr[i10] = a6;
                    objArr2[i12] = a6;
                    i9 += hashCode;
                    i10++;
                    break;
                }
                if (obj2.equals(a6)) {
                    break;
                }
                a7++;
            }
        }
        Arrays.fill(objArr, i10, i6, (Object) null);
        if (i10 == 1) {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return new q0(obj3);
        }
        if (i(i10) < i7 / 2) {
            return j(i10, objArr);
        }
        if (t(i10, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i10);
        }
        return new l0(objArr, i9, objArr2, i8, i10);
    }

    public static <E> s<E> k(Collection<? extends E> collection) {
        if ((collection instanceof s) && !(collection instanceof SortedSet)) {
            s<E> sVar = (s) collection;
            if (!sVar.g()) {
                return sVar;
            }
        }
        Object[] array = collection.toArray();
        return j(array.length, array);
    }

    public static <E> s<E> l(E[] eArr) {
        int length = eArr.length;
        return length != 0 ? length != 1 ? j(eArr.length, (Object[]) eArr.clone()) : p(eArr[0]) : o();
    }

    public static <E> s<E> o() {
        return l0.f8011m;
    }

    public static <E> s<E> p(E e6) {
        return new q0(e6);
    }

    public static <E> s<E> q(E e6, E e7) {
        return j(2, e6, e7);
    }

    public static <E> s<E> r(E e6, E e7, E e8) {
        return j(3, e6, e7, e8);
    }

    public static <E> s<E> s(E e6, E e7, E e8, E e9, E e10) {
        return j(5, e6, e7, e8, e9, e10);
    }

    private static boolean t(int i6, int i7) {
        return i6 < (i7 >> 1) + (i7 >> 2);
    }

    @Override // m2.o
    public q<E> b() {
        q<E> qVar = this.f8044b;
        if (qVar != null) {
            return qVar;
        }
        q<E> m6 = m();
        this.f8044b = m6;
        return m6;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof s) && n() && ((s) obj).n() && hashCode() != obj.hashCode()) {
            return false;
        }
        return p0.a(this, obj);
    }

    @Override // m2.o, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public abstract s0<E> iterator();

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return p0.d(this);
    }

    q<E> m() {
        return q.i(toArray());
    }

    boolean n() {
        return false;
    }
}
