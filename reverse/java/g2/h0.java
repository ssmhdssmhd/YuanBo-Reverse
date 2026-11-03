package g2;

import java.io.IOException;

/* loaded from: classes.dex */
public interface h0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f4038a;

        /* renamed from: b, reason: collision with root package name */
        public final int f4039b;

        /* renamed from: c, reason: collision with root package name */
        public final int f4040c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4041d;

        public a(int i6, int i7, int i8, int i9) {
            this.f4038a = i6;
            this.f4039b = i7;
            this.f4040c = i8;
            this.f4041d = i9;
        }

        public boolean a(int i6) {
            if (i6 == 1) {
                if (this.f4038a - this.f4039b <= 1) {
                    return false;
                }
            } else if (this.f4040c - this.f4041d <= 1) {
                return false;
            }
            return true;
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f4042a;

        /* renamed from: b, reason: collision with root package name */
        public final long f4043b;

        public b(int i6, long j6) {
            i2.a.a(j6 >= 0);
            this.f4042a = i6;
            this.f4043b = j6;
        }
    }

    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final l1.o f4044a;

        /* renamed from: b, reason: collision with root package name */
        public final l1.r f4045b;

        /* renamed from: c, reason: collision with root package name */
        public final IOException f4046c;

        /* renamed from: d, reason: collision with root package name */
        public final int f4047d;

        public c(l1.o oVar, l1.r rVar, IOException iOException, int i6) {
            this.f4044a = oVar;
            this.f4045b = rVar;
            this.f4046c = iOException;
            this.f4047d = i6;
        }
    }

    void a(long j6);

    b b(a aVar, c cVar);

    int c(int i6);

    long d(c cVar);
}
