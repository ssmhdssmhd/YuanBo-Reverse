package a2;

import i2.c1;
import java.util.Collections;
import java.util.List;
import u1.h;

/* loaded from: classes.dex */
final class b implements h {

    /* renamed from: a, reason: collision with root package name */
    private final u1.b[] f146a;

    /* renamed from: b, reason: collision with root package name */
    private final long[] f147b;

    public b(u1.b[] bVarArr, long[] jArr) {
        this.f146a = bVarArr;
        this.f147b = jArr;
    }

    @Override // u1.h
    public int a(long j6) {
        int e6 = c1.e(this.f147b, j6, false, false);
        if (e6 < this.f147b.length) {
            return e6;
        }
        return -1;
    }

    @Override // u1.h
    public long b(int i6) {
        i2.a.a(i6 >= 0);
        i2.a.a(i6 < this.f147b.length);
        return this.f147b[i6];
    }

    @Override // u1.h
    public List<u1.b> c(long j6) {
        u1.b bVar;
        int i6 = c1.i(this.f147b, j6, true, false);
        return (i6 == -1 || (bVar = this.f146a[i6]) == u1.b.f9599v) ? Collections.emptyList() : Collections.singletonList(bVar);
    }

    @Override // u1.h
    public int d() {
        return this.f147b.length;
    }
}
