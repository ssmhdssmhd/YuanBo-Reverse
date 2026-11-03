package w0;

import i2.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f9985a;

    /* renamed from: w0.a$a, reason: collision with other inner class name */
    static final class C0154a extends a {

        /* renamed from: b, reason: collision with root package name */
        public final long f9986b;

        /* renamed from: c, reason: collision with root package name */
        public final List<b> f9987c;

        /* renamed from: d, reason: collision with root package name */
        public final List<C0154a> f9988d;

        public C0154a(int i6, long j6) {
            super(i6);
            this.f9986b = j6;
            this.f9987c = new ArrayList();
            this.f9988d = new ArrayList();
        }

        public void d(C0154a c0154a) {
            this.f9988d.add(c0154a);
        }

        public void e(b bVar) {
            this.f9987c.add(bVar);
        }

        public C0154a f(int i6) {
            int size = this.f9988d.size();
            for (int i7 = 0; i7 < size; i7++) {
                C0154a c0154a = this.f9988d.get(i7);
                if (c0154a.f9985a == i6) {
                    return c0154a;
                }
            }
            return null;
        }

        public b g(int i6) {
            int size = this.f9987c.size();
            for (int i7 = 0; i7 < size; i7++) {
                b bVar = this.f9987c.get(i7);
                if (bVar.f9985a == i6) {
                    return bVar;
                }
            }
            return null;
        }

        @Override // w0.a
        public String toString() {
            return a.a(this.f9985a) + " leaves: " + Arrays.toString(this.f9987c.toArray()) + " containers: " + Arrays.toString(this.f9988d.toArray());
        }
    }

    static final class b extends a {

        /* renamed from: b, reason: collision with root package name */
        public final i0 f9989b;

        public b(int i6, i0 i0Var) {
            super(i6);
            this.f9989b = i0Var;
        }
    }

    public a(int i6) {
        this.f9985a = i6;
    }

    public static String a(int i6) {
        return "" + ((char) ((i6 >> 24) & 255)) + ((char) ((i6 >> 16) & 255)) + ((char) ((i6 >> 8) & 255)) + ((char) (i6 & 255));
    }

    public static int b(int i6) {
        return i6 & 16777215;
    }

    public static int c(int i6) {
        return (i6 >> 24) & 255;
    }

    public String toString() {
        return a(this.f9985a);
    }
}
