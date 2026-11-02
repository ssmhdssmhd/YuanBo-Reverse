package y0;

import android.util.SparseArray;
import i2.r0;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface i0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f10807a;

        /* renamed from: b, reason: collision with root package name */
        public final int f10808b;

        /* renamed from: c, reason: collision with root package name */
        public final byte[] f10809c;

        public a(String str, int i6, byte[] bArr) {
            this.f10807a = str;
            this.f10808b = i6;
            this.f10809c = bArr;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f10810a;

        /* renamed from: b, reason: collision with root package name */
        public final String f10811b;

        /* renamed from: c, reason: collision with root package name */
        public final List<a> f10812c;

        /* renamed from: d, reason: collision with root package name */
        public final byte[] f10813d;

        public b(int i6, String str, List<a> list, byte[] bArr) {
            this.f10810a = i6;
            this.f10811b = str;
            this.f10812c = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
            this.f10813d = bArr;
        }
    }

    public interface c {
        SparseArray<i0> a();

        i0 b(int i6, b bVar);
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f10814a;

        /* renamed from: b, reason: collision with root package name */
        private final int f10815b;

        /* renamed from: c, reason: collision with root package name */
        private final int f10816c;

        /* renamed from: d, reason: collision with root package name */
        private int f10817d;

        /* renamed from: e, reason: collision with root package name */
        private String f10818e;

        public d(int i6, int i7) {
            this(Integer.MIN_VALUE, i6, i7);
        }

        public d(int i6, int i7, int i8) {
            String str;
            if (i6 != Integer.MIN_VALUE) {
                str = i6 + "/";
            } else {
                str = "";
            }
            this.f10814a = str;
            this.f10815b = i7;
            this.f10816c = i8;
            this.f10817d = Integer.MIN_VALUE;
            this.f10818e = "";
        }

        private void d() {
            if (this.f10817d == Integer.MIN_VALUE) {
                throw new IllegalStateException("generateNewId() must be called before retrieving ids.");
            }
        }

        public void a() {
            int i6 = this.f10817d;
            this.f10817d = i6 == Integer.MIN_VALUE ? this.f10815b : i6 + this.f10816c;
            this.f10818e = this.f10814a + this.f10817d;
        }

        public String b() {
            d();
            return this.f10818e;
        }

        public int c() {
            d();
            return this.f10817d;
        }
    }

    void a();

    void b(i2.i0 i0Var, int i6);

    void c(r0 r0Var, o0.n nVar, d dVar);
}
