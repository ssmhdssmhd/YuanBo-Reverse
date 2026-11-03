package o2;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import l2.k;

/* loaded from: classes.dex */
public final class e extends f {

    private static class a extends AbstractList<Integer> implements RandomAccess, Serializable {

        /* renamed from: a, reason: collision with root package name */
        final int[] f8448a;

        /* renamed from: b, reason: collision with root package name */
        final int f8449b;

        /* renamed from: c, reason: collision with root package name */
        final int f8450c;

        a(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        a(int[] iArr, int i6, int i7) {
            this.f8448a = iArr;
            this.f8449b = i6;
            this.f8450c = i7;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Integer get(int i6) {
            k.g(i6, size());
            return Integer.valueOf(this.f8448a[this.f8449b + i6]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Integer set(int i6, Integer num) {
            k.g(i6, size());
            int[] iArr = this.f8448a;
            int i7 = this.f8449b;
            int i8 = iArr[i7 + i6];
            iArr[i7 + i6] = ((Integer) k.i(num)).intValue();
            return Integer.valueOf(i8);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Integer) && e.h(this.f8448a, ((Integer) obj).intValue(), this.f8449b, this.f8450c) != -1;
        }

        int[] d() {
            return Arrays.copyOfRange(this.f8448a, this.f8449b, this.f8450c);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return super.equals(obj);
            }
            a aVar = (a) obj;
            int size = size();
            if (aVar.size() != size) {
                return false;
            }
            for (int i6 = 0; i6 < size; i6++) {
                if (this.f8448a[this.f8449b + i6] != aVar.f8448a[aVar.f8449b + i6]) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i6 = 1;
            for (int i7 = this.f8449b; i7 < this.f8450c; i7++) {
                i6 = (i6 * 31) + e.f(this.f8448a[i7]);
            }
            return i6;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int h6;
            if (!(obj instanceof Integer) || (h6 = e.h(this.f8448a, ((Integer) obj).intValue(), this.f8449b, this.f8450c)) < 0) {
                return -1;
            }
            return h6 - this.f8449b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int i6;
            if (!(obj instanceof Integer) || (i6 = e.i(this.f8448a, ((Integer) obj).intValue(), this.f8449b, this.f8450c)) < 0) {
                return -1;
            }
            return i6 - this.f8449b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f8450c - this.f8449b;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i6, int i7) {
            k.m(i6, i7, size());
            if (i6 == i7) {
                return Collections.emptyList();
            }
            int[] iArr = this.f8448a;
            int i8 = this.f8449b;
            return new a(iArr, i6 + i8, i8 + i7);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
            sb.append('[');
            sb.append(this.f8448a[this.f8449b]);
            int i6 = this.f8449b;
            while (true) {
                i6++;
                if (i6 >= this.f8450c) {
                    sb.append(']');
                    return sb.toString();
                }
                sb.append(", ");
                sb.append(this.f8448a[i6]);
            }
        }
    }

    public static List<Integer> c(int... iArr) {
        return iArr.length == 0 ? Collections.emptyList() : new a(iArr);
    }

    public static int d(long j6) {
        int i6 = (int) j6;
        k.f(((long) i6) == j6, "Out of range: %s", j6);
        return i6;
    }

    public static int e(int i6, int i7) {
        if (i6 < i7) {
            return -1;
        }
        return i6 > i7 ? 1 : 0;
    }

    public static int f(int i6) {
        return i6;
    }

    public static int g(int[] iArr, int i6) {
        return h(iArr, i6, 0, iArr.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(int[] iArr, int i6, int i7, int i8) {
        while (i7 < i8) {
            if (iArr[i7] == i6) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int[] iArr, int i6, int i7, int i8) {
        for (int i9 = i8 - 1; i9 >= i7; i9--) {
            if (iArr[i9] == i6) {
                return i9;
            }
        }
        return -1;
    }

    public static int j(long j6) {
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j6 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j6;
    }

    public static int[] k(Collection<? extends Number> collection) {
        if (collection instanceof a) {
            return ((a) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i6 = 0; i6 < length; i6++) {
            iArr[i6] = ((Number) k.i(array[i6])).intValue();
        }
        return iArr;
    }
}
