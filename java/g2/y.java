package g2;

import g2.h0;
import g2.i0;
import h0.g3;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public class y implements h0 {

    /* renamed from: a, reason: collision with root package name */
    private final int f4220a;

    public y() {
        this(-1);
    }

    public y(int i6) {
        this.f4220a = i6;
    }

    @Override // g2.h0
    public /* synthetic */ void a(long j6) {
        g0.a(this, j6);
    }

    @Override // g2.h0
    public h0.b b(h0.a aVar, h0.c cVar) {
        if (!e(cVar.f4046c)) {
            return null;
        }
        if (aVar.a(1)) {
            return new h0.b(1, 300000L);
        }
        if (aVar.a(2)) {
            return new h0.b(2, 60000L);
        }
        return null;
    }

    @Override // g2.h0
    public int c(int i6) {
        int i7 = this.f4220a;
        return i7 == -1 ? i6 == 7 ? 6 : 3 : i7;
    }

    @Override // g2.h0
    public long d(h0.c cVar) {
        IOException iOException = cVar.f4046c;
        if ((iOException instanceof g3) || (iOException instanceof FileNotFoundException) || (iOException instanceof a0) || (iOException instanceof i0.h) || n.a(iOException)) {
            return -9223372036854775807L;
        }
        return Math.min((cVar.f4047d - 1) * 1000, 5000);
    }

    protected boolean e(IOException iOException) {
        if (!(iOException instanceof d0)) {
            return false;
        }
        int i6 = ((d0) iOException).f4012d;
        return i6 == 403 || i6 == 404 || i6 == 410 || i6 == 416 || i6 == 500 || i6 == 503;
    }
}
