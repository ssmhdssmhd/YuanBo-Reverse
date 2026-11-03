package g2;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class t0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final m f4169a;

    /* renamed from: b, reason: collision with root package name */
    private final k f4170b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4171c;

    /* renamed from: d, reason: collision with root package name */
    private long f4172d;

    public t0(m mVar, k kVar) {
        this.f4169a = (m) i2.a.e(mVar);
        this.f4170b = (k) i2.a.e(kVar);
    }

    @Override // g2.m
    public long a(q qVar) {
        long a6 = this.f4169a.a(qVar);
        this.f4172d = a6;
        if (a6 == 0) {
            return 0L;
        }
        if (qVar.f4104h == -1 && a6 != -1) {
            qVar = qVar.f(0L, a6);
        }
        this.f4171c = true;
        this.f4170b.a(qVar);
        return this.f4172d;
    }

    @Override // g2.m
    public void c(u0 u0Var) {
        i2.a.e(u0Var);
        this.f4169a.c(u0Var);
    }

    @Override // g2.m
    public void close() {
        try {
            this.f4169a.close();
        } finally {
            if (this.f4171c) {
                this.f4171c = false;
                this.f4170b.close();
            }
        }
    }

    @Override // g2.m
    public Map<String, List<String>> f() {
        return this.f4169a.f();
    }

    @Override // g2.m
    public Uri j() {
        return this.f4169a.j();
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (this.f4172d == 0) {
            return -1;
        }
        int read = this.f4169a.read(bArr, i6, i7);
        if (read > 0) {
            this.f4170b.write(bArr, i6, read);
            long j6 = this.f4172d;
            if (j6 != -1) {
                this.f4172d = j6 - read;
            }
        }
        return read;
    }
}
