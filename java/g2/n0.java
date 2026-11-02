package g2;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class n0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final m f4081a;

    /* renamed from: b, reason: collision with root package name */
    private final i2.k0 f4082b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4083c;

    public n0(m mVar, i2.k0 k0Var, int i6) {
        this.f4081a = (m) i2.a.e(mVar);
        this.f4082b = (i2.k0) i2.a.e(k0Var);
        this.f4083c = i6;
    }

    @Override // g2.m
    public long a(q qVar) {
        this.f4082b.b(this.f4083c);
        return this.f4081a.a(qVar);
    }

    @Override // g2.m
    public void c(u0 u0Var) {
        i2.a.e(u0Var);
        this.f4081a.c(u0Var);
    }

    @Override // g2.m
    public void close() {
        this.f4081a.close();
    }

    @Override // g2.m
    public Map<String, List<String>> f() {
        return this.f4081a.f();
    }

    @Override // g2.m
    public Uri j() {
        return this.f4081a.j();
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        this.f4082b.b(this.f4083c);
        return this.f4081a.read(bArr, i6, i7);
    }
}
