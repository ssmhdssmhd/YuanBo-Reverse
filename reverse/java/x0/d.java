package x0;

import android.net.Uri;
import androidx.window.embedding.EmbeddingCompat;
import h0.g3;
import i2.i0;
import java.util.Map;
import o0.a0;
import o0.e0;
import o0.l;
import o0.m;
import o0.n;
import o0.q;
import o0.r;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* loaded from: classes.dex */
public class d implements l {

    /* renamed from: d, reason: collision with root package name */
    public static final r f10410d = new r() { // from class: x0.c
        @Override // o0.r
        public final l[] a() {
            l[] e6;
            e6 = d.e();
            return e6;
        }

        @Override // o0.r
        public /* synthetic */ l[] b(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private n f10411a;

    /* renamed from: b, reason: collision with root package name */
    private i f10412b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f10413c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] e() {
        return new l[]{new d()};
    }

    private static i0 f(i0 i0Var) {
        i0Var.S(0);
        return i0Var;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = EmbeddingCompat.DEBUG)
    private boolean h(m mVar) {
        i hVar;
        f fVar = new f();
        if (fVar.a(mVar, true) && (fVar.f10420b & 2) == 2) {
            int min = Math.min(fVar.f10427i, 8);
            i0 i0Var = new i0(min);
            mVar.m(i0Var.e(), 0, min);
            if (b.p(f(i0Var))) {
                hVar = new b();
            } else if (j.r(f(i0Var))) {
                hVar = new j();
            } else if (h.o(f(i0Var))) {
                hVar = new h();
            }
            this.f10412b = hVar;
            return true;
        }
        return false;
    }

    @Override // o0.l
    public void a() {
    }

    @Override // o0.l
    public void b(long j6, long j7) {
        i iVar = this.f10412b;
        if (iVar != null) {
            iVar.m(j6, j7);
        }
    }

    @Override // o0.l
    public void c(n nVar) {
        this.f10411a = nVar;
    }

    @Override // o0.l
    public boolean g(m mVar) {
        try {
            return h(mVar);
        } catch (g3 unused) {
            return false;
        }
    }

    @Override // o0.l
    public int j(m mVar, a0 a0Var) {
        i2.a.i(this.f10411a);
        if (this.f10412b == null) {
            if (!h(mVar)) {
                throw g3.a("Failed to determine bitstream type", null);
            }
            mVar.g();
        }
        if (!this.f10413c) {
            e0 e6 = this.f10411a.e(0, 1);
            this.f10411a.j();
            this.f10412b.d(this.f10411a, e6);
            this.f10413c = true;
        }
        return this.f10412b.g(mVar, a0Var);
    }
}
