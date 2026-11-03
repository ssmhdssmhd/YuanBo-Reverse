package l1;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes.dex */
public interface q0 {

    public static class a implements q0 {

        /* renamed from: a, reason: collision with root package name */
        private final Random f7409a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f7410b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f7411c;

        public a(int i6) {
            this(i6, new Random());
        }

        private a(int i6, Random random) {
            this(h(i6, random), random);
        }

        private a(int[] iArr, Random random) {
            this.f7410b = iArr;
            this.f7409a = random;
            this.f7411c = new int[iArr.length];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                this.f7411c[iArr[i6]] = i6;
            }
        }

        private static int[] h(int i6, Random random) {
            int[] iArr = new int[i6];
            int i7 = 0;
            while (i7 < i6) {
                int i8 = i7 + 1;
                int nextInt = random.nextInt(i8);
                iArr[i7] = iArr[nextInt];
                iArr[nextInt] = i7;
                i7 = i8;
            }
            return iArr;
        }

        @Override // l1.q0
        public q0 a(int i6, int i7) {
            int i8 = i7 - i6;
            int[] iArr = new int[this.f7410b.length - i8];
            int i9 = 0;
            int i10 = 0;
            while (true) {
                int[] iArr2 = this.f7410b;
                if (i9 >= iArr2.length) {
                    return new a(iArr, new Random(this.f7409a.nextLong()));
                }
                int i11 = iArr2[i9];
                if (i11 < i6 || i11 >= i7) {
                    int i12 = i9 - i10;
                    if (i11 >= i6) {
                        i11 -= i8;
                    }
                    iArr[i12] = i11;
                } else {
                    i10++;
                }
                i9++;
            }
        }

        @Override // l1.q0
        public int b(int i6) {
            int i7 = this.f7411c[i6] + 1;
            int[] iArr = this.f7410b;
            if (i7 < iArr.length) {
                return iArr[i7];
            }
            return -1;
        }

        @Override // l1.q0
        public q0 c(int i6, int i7) {
            int[] iArr = new int[i7];
            int[] iArr2 = new int[i7];
            int i8 = 0;
            int i9 = 0;
            while (i9 < i7) {
                iArr[i9] = this.f7409a.nextInt(this.f7410b.length + 1);
                int i10 = i9 + 1;
                int nextInt = this.f7409a.nextInt(i10);
                iArr2[i9] = iArr2[nextInt];
                iArr2[nextInt] = i9 + i6;
                i9 = i10;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f7410b.length + i7];
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int[] iArr4 = this.f7410b;
                if (i8 >= iArr4.length + i7) {
                    return new a(iArr3, new Random(this.f7409a.nextLong()));
                }
                if (i11 >= i7 || i12 != iArr[i11]) {
                    int i13 = i12 + 1;
                    int i14 = iArr4[i12];
                    iArr3[i8] = i14;
                    if (i14 >= i6) {
                        iArr3[i8] = i14 + i7;
                    }
                    i12 = i13;
                } else {
                    iArr3[i8] = iArr2[i11];
                    i11++;
                }
                i8++;
            }
        }

        @Override // l1.q0
        public int d() {
            int[] iArr = this.f7410b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // l1.q0
        public int e(int i6) {
            int i7 = this.f7411c[i6] - 1;
            if (i7 >= 0) {
                return this.f7410b[i7];
            }
            return -1;
        }

        @Override // l1.q0
        public int f() {
            int[] iArr = this.f7410b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // l1.q0
        public q0 g() {
            return new a(0, new Random(this.f7409a.nextLong()));
        }

        @Override // l1.q0
        public int getLength() {
            return this.f7410b.length;
        }
    }

    q0 a(int i6, int i7);

    int b(int i6);

    q0 c(int i6, int i7);

    int d();

    int e(int i6);

    int f();

    q0 g();

    int getLength();
}
