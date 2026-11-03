package m0;

import android.os.Looper;
import h0.y1;
import i0.o3;
import m0.o;
import m0.w;

/* loaded from: classes.dex */
public interface y {

    /* renamed from: a, reason: collision with root package name */
    public static final y f7899a;

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final y f7900b;

    class a implements y {
        a() {
        }

        @Override // m0.y
        public /* synthetic */ void a() {
            x.c(this);
        }

        @Override // m0.y
        public void b(Looper looper, o3 o3Var) {
        }

        @Override // m0.y
        public int c(y1 y1Var) {
            return y1Var.f5069s != null ? 1 : 0;
        }

        @Override // m0.y
        public /* synthetic */ b d(w.a aVar, y1 y1Var) {
            return x.a(this, aVar, y1Var);
        }

        @Override // m0.y
        public /* synthetic */ void e() {
            x.b(this);
        }

        @Override // m0.y
        public o f(w.a aVar, y1 y1Var) {
            if (y1Var.f5069s == null) {
                return null;
            }
            return new e0(new o.a(new v0(1), 6001));
        }
    }

    public interface b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f7901a = new b() { // from class: m0.z
            @Override // m0.y.b
            public final void a() {
                a0.a();
            }
        };

        void a();
    }

    static {
        a aVar = new a();
        f7899a = aVar;
        f7900b = aVar;
    }

    void a();

    void b(Looper looper, o3 o3Var);

    int c(y1 y1Var);

    b d(w.a aVar, y1 y1Var);

    void e();

    o f(w.a aVar, y1 y1Var);
}
