package g2;

import android.net.Uri;
import g2.m;
import java.io.IOException;
import java.util.Map;

/* loaded from: classes.dex */
public final class m0 implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f4078a = new m0();

    /* renamed from: b, reason: collision with root package name */
    public static final m.a f4079b = new m.a() { // from class: g2.l0
        @Override // g2.m.a
        public final m a() {
            return m0.o();
        }
    };

    private m0() {
    }

    public static /* synthetic */ m0 o() {
        return new m0();
    }

    @Override // g2.m
    public long a(q qVar) {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // g2.m
    public void c(u0 u0Var) {
    }

    @Override // g2.m
    public void close() {
    }

    @Override // g2.m
    public /* synthetic */ Map f() {
        return l.a(this);
    }

    @Override // g2.m
    public Uri j() {
        return null;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        throw new UnsupportedOperationException();
    }
}
