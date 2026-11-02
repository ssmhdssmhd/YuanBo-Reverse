package o0;

import h0.y1;
import i2.i0;
import java.io.EOFException;
import o0.e0;

/* loaded from: classes.dex */
public final class k implements e0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f8410a = new byte[4096];

    @Override // o0.e0
    public void a(i0 i0Var, int i6, int i7) {
        i0Var.T(i6);
    }

    @Override // o0.e0
    public /* synthetic */ int b(g2.i iVar, int i6, boolean z5) {
        return d0.a(this, iVar, i6, z5);
    }

    @Override // o0.e0
    public void c(y1 y1Var) {
    }

    @Override // o0.e0
    public /* synthetic */ void d(i0 i0Var, int i6) {
        d0.b(this, i0Var, i6);
    }

    @Override // o0.e0
    public void e(long j6, int i6, int i7, int i8, e0.a aVar) {
    }

    @Override // o0.e0
    public int f(g2.i iVar, int i6, boolean z5, int i7) {
        int read = iVar.read(this.f8410a, 0, Math.min(this.f8410a.length, i6));
        if (read != -1) {
            return read;
        }
        if (z5) {
            return -1;
        }
        throw new EOFException();
    }
}
