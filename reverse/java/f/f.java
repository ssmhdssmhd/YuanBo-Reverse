package f;

import java.util.ConcurrentModificationException;
import java.util.Map;

/* loaded from: classes.dex */
public class f<K, V> {

    /* renamed from: d, reason: collision with root package name */
    static Object[] f3759d;

    /* renamed from: e, reason: collision with root package name */
    static int f3760e;

    /* renamed from: j, reason: collision with root package name */
    static Object[] f3761j;

    /* renamed from: k, reason: collision with root package name */
    static int f3762k;

    /* renamed from: a, reason: collision with root package name */
    int[] f3763a;

    /* renamed from: b, reason: collision with root package name */
    Object[] f3764b;

    /* renamed from: c, reason: collision with root package name */
    int f3765c;

    public f() {
        this.f3763a = c.f3736a;
        this.f3764b = c.f3738c;
        this.f3765c = 0;
    }

    public f(int i6) {
        if (i6 == 0) {
            this.f3763a = c.f3736a;
            this.f3764b = c.f3738c;
        } else {
            a(i6);
        }
        this.f3765c = 0;
    }

    private void a(int i6) {
        if (i6 == 8) {
            synchronized (f.class) {
                Object[] objArr = f3761j;
                if (objArr != null) {
                    this.f3764b = objArr;
                    f3761j = (Object[]) objArr[0];
                    this.f3763a = (int[]) objArr[1];
                    objArr[1] = null;
                    objArr[0] = null;
                    f3762k--;
                    return;
                }
            }
        } else if (i6 == 4) {
            synchronized (f.class) {
                Object[] objArr2 = f3759d;
                if (objArr2 != null) {
                    this.f3764b = objArr2;
                    f3759d = (Object[]) objArr2[0];
                    this.f3763a = (int[]) objArr2[1];
                    objArr2[1] = null;
                    objArr2[0] = null;
                    f3760e--;
                    return;
                }
            }
        }
        this.f3763a = new int[i6];
        this.f3764b = new Object[i6 << 1];
    }

    private static int b(int[] iArr, int i6, int i7) {
        try {
            return c.a(iArr, i6, i7);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i6) {
        if (iArr.length == 8) {
            synchronized (f.class) {
                if (f3762k < 10) {
                    objArr[0] = f3761j;
                    objArr[1] = iArr;
                    for (int i7 = (i6 << 1) - 1; i7 >= 2; i7--) {
                        objArr[i7] = null;
                    }
                    f3761j = objArr;
                    f3762k++;
                }
            }
            return;
        }
        if (iArr.length == 4) {
            synchronized (f.class) {
                if (f3760e < 10) {
                    objArr[0] = f3759d;
                    objArr[1] = iArr;
                    for (int i8 = (i6 << 1) - 1; i8 >= 2; i8--) {
                        objArr[i8] = null;
                    }
                    f3759d = objArr;
                    f3760e++;
                }
            }
        }
    }

    public void c(int i6) {
        int i7 = this.f3765c;
        int[] iArr = this.f3763a;
        if (iArr.length < i6) {
            Object[] objArr = this.f3764b;
            a(i6);
            if (this.f3765c > 0) {
                System.arraycopy(iArr, 0, this.f3763a, 0, i7);
                System.arraycopy(objArr, 0, this.f3764b, 0, i7 << 1);
            }
            d(iArr, objArr, i7);
        }
        if (this.f3765c != i7) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i6 = this.f3765c;
        if (i6 > 0) {
            int[] iArr = this.f3763a;
            Object[] objArr = this.f3764b;
            this.f3763a = c.f3736a;
            this.f3764b = c.f3738c;
            this.f3765c = 0;
            d(iArr, objArr, i6);
        }
        if (this.f3765c > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    int e(Object obj, int i6) {
        int i7 = this.f3765c;
        if (i7 == 0) {
            return -1;
        }
        int b6 = b(this.f3763a, i7, i6);
        if (b6 < 0 || obj.equals(this.f3764b[b6 << 1])) {
            return b6;
        }
        int i8 = b6 + 1;
        while (i8 < i7 && this.f3763a[i8] == i6) {
            if (obj.equals(this.f3764b[i8 << 1])) {
                return i8;
            }
            i8++;
        }
        for (int i9 = b6 - 1; i9 >= 0 && this.f3763a[i9] == i6; i9--) {
            if (obj.equals(this.f3764b[i9 << 1])) {
                return i9;
            }
        }
        return ~i8;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (size() != fVar.size()) {
                return false;
            }
            for (int i6 = 0; i6 < this.f3765c; i6++) {
                try {
                    K i7 = i(i6);
                    V l6 = l(i6);
                    Object obj2 = fVar.get(i7);
                    if (l6 == null) {
                        if (obj2 != null || !fVar.containsKey(i7)) {
                            return false;
                        }
                    } else if (!l6.equals(obj2)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                    return false;
                }
            }
            return true;
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (size() != map.size()) {
                return false;
            }
            for (int i8 = 0; i8 < this.f3765c; i8++) {
                try {
                    K i9 = i(i8);
                    V l7 = l(i8);
                    Object obj3 = map.get(i9);
                    if (l7 == null) {
                        if (obj3 != null || !map.containsKey(i9)) {
                            return false;
                        }
                    } else if (!l7.equals(obj3)) {
                        return false;
                    }
                } catch (ClassCastException | NullPointerException unused2) {
                }
            }
            return true;
        }
        return false;
    }

    public int f(Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    int g() {
        int i6 = this.f3765c;
        if (i6 == 0) {
            return -1;
        }
        int b6 = b(this.f3763a, i6, 0);
        if (b6 < 0 || this.f3764b[b6 << 1] == null) {
            return b6;
        }
        int i7 = b6 + 1;
        while (i7 < i6 && this.f3763a[i7] == 0) {
            if (this.f3764b[i7 << 1] == null) {
                return i7;
            }
            i7++;
        }
        for (int i8 = b6 - 1; i8 >= 0 && this.f3763a[i8] == 0; i8--) {
            if (this.f3764b[i8 << 1] == null) {
                return i8;
            }
        }
        return ~i7;
    }

    public V get(Object obj) {
        return getOrDefault(obj, null);
    }

    public V getOrDefault(Object obj, V v5) {
        int f6 = f(obj);
        return f6 >= 0 ? (V) this.f3764b[(f6 << 1) + 1] : v5;
    }

    int h(Object obj) {
        int i6 = this.f3765c * 2;
        Object[] objArr = this.f3764b;
        if (obj == null) {
            for (int i7 = 1; i7 < i6; i7 += 2) {
                if (objArr[i7] == null) {
                    return i7 >> 1;
                }
            }
            return -1;
        }
        for (int i8 = 1; i8 < i6; i8 += 2) {
            if (obj.equals(objArr[i8])) {
                return i8 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.f3763a;
        Object[] objArr = this.f3764b;
        int i6 = this.f3765c;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i8 < i6) {
            Object obj = objArr[i7];
            i9 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i8];
            i8++;
            i7 += 2;
        }
        return i9;
    }

    public K i(int i6) {
        return (K) this.f3764b[i6 << 1];
    }

    public boolean isEmpty() {
        return this.f3765c <= 0;
    }

    public V j(int i6) {
        Object[] objArr = this.f3764b;
        int i7 = i6 << 1;
        V v5 = (V) objArr[i7 + 1];
        int i8 = this.f3765c;
        int i9 = 0;
        if (i8 <= 1) {
            d(this.f3763a, objArr, i8);
            this.f3763a = c.f3736a;
            this.f3764b = c.f3738c;
        } else {
            int i10 = i8 - 1;
            int[] iArr = this.f3763a;
            if (iArr.length <= 8 || i8 >= iArr.length / 3) {
                if (i6 < i10) {
                    int i11 = i6 + 1;
                    int i12 = i10 - i6;
                    System.arraycopy(iArr, i11, iArr, i6, i12);
                    Object[] objArr2 = this.f3764b;
                    System.arraycopy(objArr2, i11 << 1, objArr2, i7, i12 << 1);
                }
                Object[] objArr3 = this.f3764b;
                int i13 = i10 << 1;
                objArr3[i13] = null;
                objArr3[i13 + 1] = null;
            } else {
                a(i8 > 8 ? i8 + (i8 >> 1) : 8);
                if (i8 != this.f3765c) {
                    throw new ConcurrentModificationException();
                }
                if (i6 > 0) {
                    System.arraycopy(iArr, 0, this.f3763a, 0, i6);
                    System.arraycopy(objArr, 0, this.f3764b, 0, i7);
                }
                if (i6 < i10) {
                    int i14 = i6 + 1;
                    int i15 = i10 - i6;
                    System.arraycopy(iArr, i14, this.f3763a, i6, i15);
                    System.arraycopy(objArr, i14 << 1, this.f3764b, i7, i15 << 1);
                }
            }
            i9 = i10;
        }
        if (i8 != this.f3765c) {
            throw new ConcurrentModificationException();
        }
        this.f3765c = i9;
        return v5;
    }

    public V k(int i6, V v5) {
        int i7 = (i6 << 1) + 1;
        Object[] objArr = this.f3764b;
        V v6 = (V) objArr[i7];
        objArr[i7] = v5;
        return v6;
    }

    public V l(int i6) {
        return (V) this.f3764b[(i6 << 1) + 1];
    }

    public V put(K k6, V v5) {
        int i6;
        int e6;
        int i7 = this.f3765c;
        if (k6 == null) {
            e6 = g();
            i6 = 0;
        } else {
            int hashCode = k6.hashCode();
            i6 = hashCode;
            e6 = e(k6, hashCode);
        }
        if (e6 >= 0) {
            int i8 = (e6 << 1) + 1;
            Object[] objArr = this.f3764b;
            V v6 = (V) objArr[i8];
            objArr[i8] = v5;
            return v6;
        }
        int i9 = ~e6;
        int[] iArr = this.f3763a;
        if (i7 >= iArr.length) {
            int i10 = 8;
            if (i7 >= 8) {
                i10 = (i7 >> 1) + i7;
            } else if (i7 < 4) {
                i10 = 4;
            }
            Object[] objArr2 = this.f3764b;
            a(i10);
            if (i7 != this.f3765c) {
                throw new ConcurrentModificationException();
            }
            int[] iArr2 = this.f3763a;
            if (iArr2.length > 0) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                System.arraycopy(objArr2, 0, this.f3764b, 0, objArr2.length);
            }
            d(iArr, objArr2, i7);
        }
        if (i9 < i7) {
            int[] iArr3 = this.f3763a;
            int i11 = i9 + 1;
            System.arraycopy(iArr3, i9, iArr3, i11, i7 - i9);
            Object[] objArr3 = this.f3764b;
            System.arraycopy(objArr3, i9 << 1, objArr3, i11 << 1, (this.f3765c - i9) << 1);
        }
        int i12 = this.f3765c;
        if (i7 == i12) {
            int[] iArr4 = this.f3763a;
            if (i9 < iArr4.length) {
                iArr4[i9] = i6;
                Object[] objArr4 = this.f3764b;
                int i13 = i9 << 1;
                objArr4[i13] = k6;
                objArr4[i13 + 1] = v5;
                this.f3765c = i12 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public V putIfAbsent(K k6, V v5) {
        V v6 = get(k6);
        return v6 == null ? put(k6, v5) : v6;
    }

    public V remove(Object obj) {
        int f6 = f(obj);
        if (f6 >= 0) {
            return j(f6);
        }
        return null;
    }

    public boolean remove(Object obj, Object obj2) {
        int f6 = f(obj);
        if (f6 < 0) {
            return false;
        }
        V l6 = l(f6);
        if (obj2 != l6 && (obj2 == null || !obj2.equals(l6))) {
            return false;
        }
        j(f6);
        return true;
    }

    public V replace(K k6, V v5) {
        int f6 = f(k6);
        if (f6 >= 0) {
            return k(f6, v5);
        }
        return null;
    }

    public boolean replace(K k6, V v5, V v6) {
        int f6 = f(k6);
        if (f6 < 0) {
            return false;
        }
        V l6 = l(f6);
        if (l6 != v5 && (v5 == null || !v5.equals(l6))) {
            return false;
        }
        k(f6, v6);
        return true;
    }

    public int size() {
        return this.f3765c;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f3765c * 28);
        sb.append('{');
        for (int i6 = 0; i6 < this.f3765c; i6++) {
            if (i6 > 0) {
                sb.append(", ");
            }
            K i7 = i(i6);
            if (i7 != this) {
                sb.append(i7);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            V l6 = l(i6);
            if (l6 != this) {
                sb.append(l6);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
