package kotlinx.coroutines.internal;

import w4.b2;

/* loaded from: classes.dex */
final class i0 {

    /* renamed from: a, reason: collision with root package name */
    public final h4.g f7046a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f7047b;

    /* renamed from: c, reason: collision with root package name */
    private final b2<Object>[] f7048c;

    /* renamed from: d, reason: collision with root package name */
    private int f7049d;

    public i0(h4.g gVar, int i6) {
        this.f7046a = gVar;
        this.f7047b = new Object[i6];
        this.f7048c = new b2[i6];
    }

    public final void a(b2<?> b2Var, Object obj) {
        Object[] objArr = this.f7047b;
        int i6 = this.f7049d;
        objArr[i6] = obj;
        b2<Object>[] b2VarArr = this.f7048c;
        this.f7049d = i6 + 1;
        b2VarArr[i6] = b2Var;
    }

    public final void b(h4.g gVar) {
        int length = this.f7048c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i6 = length - 1;
            b2<Object> b2Var = this.f7048c[length];
            kotlin.jvm.internal.k.b(b2Var);
            b2Var.U(gVar, this.f7047b[length]);
            if (i6 < 0) {
                return;
            } else {
                length = i6;
            }
        }
    }
}
