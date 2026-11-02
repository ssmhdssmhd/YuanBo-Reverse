package g2;

import android.net.Uri;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class s0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final m f4138a;

    /* renamed from: b, reason: collision with root package name */
    private long f4139b;

    /* renamed from: c, reason: collision with root package name */
    private Uri f4140c = Uri.EMPTY;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, List<String>> f4141d = Collections.emptyMap();

    public s0(m mVar) {
        this.f4138a = (m) i2.a.e(mVar);
    }

    @Override // g2.m
    public long a(q qVar) {
        this.f4140c = qVar.f4097a;
        this.f4141d = Collections.emptyMap();
        long a6 = this.f4138a.a(qVar);
        this.f4140c = (Uri) i2.a.e(j());
        this.f4141d = f();
        return a6;
    }

    @Override // g2.m
    public void c(u0 u0Var) {
        i2.a.e(u0Var);
        this.f4138a.c(u0Var);
    }

    @Override // g2.m
    public void close() {
        this.f4138a.close();
    }

    @Override // g2.m
    public Map<String, List<String>> f() {
        return this.f4138a.f();
    }

    @Override // g2.m
    public Uri j() {
        return this.f4138a.j();
    }

    public long o() {
        return this.f4139b;
    }

    public Uri p() {
        return this.f4140c;
    }

    public Map<String, List<String>> q() {
        return this.f4141d;
    }

    public void r() {
        this.f4139b = 0L;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        int read = this.f4138a.read(bArr, i6, i7);
        if (read != -1) {
            this.f4139b += read;
        }
        return read;
    }
}
