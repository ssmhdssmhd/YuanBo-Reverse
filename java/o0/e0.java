package o0;

import h0.y1;
import i2.i0;
import java.util.Arrays;

/* loaded from: classes.dex */
public interface e0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f8347a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f8348b;

        /* renamed from: c, reason: collision with root package name */
        public final int f8349c;

        /* renamed from: d, reason: collision with root package name */
        public final int f8350d;

        public a(int i6, byte[] bArr, int i7, int i8) {
            this.f8347a = i6;
            this.f8348b = bArr;
            this.f8349c = i7;
            this.f8350d = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f8347a == aVar.f8347a && this.f8349c == aVar.f8349c && this.f8350d == aVar.f8350d && Arrays.equals(this.f8348b, aVar.f8348b);
        }

        public int hashCode() {
            return (((((this.f8347a * 31) + Arrays.hashCode(this.f8348b)) * 31) + this.f8349c) * 31) + this.f8350d;
        }
    }

    void a(i0 i0Var, int i6, int i7);

    int b(g2.i iVar, int i6, boolean z5);

    void c(y1 y1Var);

    void d(i0 i0Var, int i6);

    void e(long j6, int i6, int i7, int i8, a aVar);

    int f(g2.i iVar, int i6, boolean z5, int i7);
}
