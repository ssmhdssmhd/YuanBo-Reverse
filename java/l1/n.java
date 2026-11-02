package l1;

import android.net.Uri;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class n implements g2.m {

    /* renamed from: a, reason: collision with root package name */
    private final g2.m f7346a;

    /* renamed from: b, reason: collision with root package name */
    private final int f7347b;

    /* renamed from: c, reason: collision with root package name */
    private final a f7348c;

    /* renamed from: d, reason: collision with root package name */
    private final byte[] f7349d;

    /* renamed from: e, reason: collision with root package name */
    private int f7350e;

    public interface a {
        void b(i2.i0 i0Var);
    }

    public n(g2.m mVar, int i6, a aVar) {
        i2.a.a(i6 > 0);
        this.f7346a = mVar;
        this.f7347b = i6;
        this.f7348c = aVar;
        this.f7349d = new byte[1];
        this.f7350e = i6;
    }

    private boolean o() {
        if (this.f7346a.read(this.f7349d, 0, 1) == -1) {
            return false;
        }
        int i6 = (this.f7349d[0] & 255) << 4;
        if (i6 == 0) {
            return true;
        }
        byte[] bArr = new byte[i6];
        int i7 = i6;
        int i8 = 0;
        while (i7 > 0) {
            int read = this.f7346a.read(bArr, i8, i7);
            if (read == -1) {
                return false;
            }
            i8 += read;
            i7 -= read;
        }
        while (i6 > 0 && bArr[i6 - 1] == 0) {
            i6--;
        }
        if (i6 > 0) {
            this.f7348c.b(new i2.i0(bArr, i6));
        }
        return true;
    }

    @Override // g2.m
    public long a(g2.q qVar) {
        throw new UnsupportedOperationException();
    }

    @Override // g2.m
    public void c(g2.u0 u0Var) {
        i2.a.e(u0Var);
        this.f7346a.c(u0Var);
    }

    @Override // g2.m
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Override // g2.m
    public Map<String, List<String>> f() {
        return this.f7346a.f();
    }

    @Override // g2.m
    public Uri j() {
        return this.f7346a.j();
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (this.f7350e == 0) {
            if (!o()) {
                return -1;
            }
            this.f7350e = this.f7347b;
        }
        int read = this.f7346a.read(bArr, i6, Math.min(this.f7350e, i7));
        if (read != -1) {
            this.f7350e -= read;
        }
        return read;
    }
}
