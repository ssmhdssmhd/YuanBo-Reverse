package i1;

import b1.a;
import b1.h;
import i2.h0;
import i2.i0;
import i2.r0;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class c extends h {

    /* renamed from: a, reason: collision with root package name */
    private final i0 f5500a = new i0();

    /* renamed from: b, reason: collision with root package name */
    private final h0 f5501b = new h0();

    /* renamed from: c, reason: collision with root package name */
    private r0 f5502c;

    @Override // b1.h
    protected b1.a b(b1.e eVar, ByteBuffer byteBuffer) {
        r0 r0Var = this.f5502c;
        if (r0Var == null || eVar.f1697m != r0Var.e()) {
            r0 r0Var2 = new r0(eVar.f7164e);
            this.f5502c = r0Var2;
            r0Var2.a(eVar.f7164e - eVar.f1697m);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f5500a.Q(array, limit);
        this.f5501b.o(array, limit);
        this.f5501b.r(39);
        long h6 = (this.f5501b.h(1) << 32) | this.f5501b.h(32);
        this.f5501b.r(20);
        int h7 = this.f5501b.h(12);
        int h8 = this.f5501b.h(8);
        this.f5500a.T(14);
        a.b d6 = h8 != 0 ? h8 != 255 ? h8 != 4 ? h8 != 5 ? h8 != 6 ? null : g.d(this.f5500a, h6, this.f5502c) : d.d(this.f5500a, h6, this.f5502c) : f.d(this.f5500a) : a.d(this.f5500a, h7, h6) : new e();
        return d6 == null ? new b1.a(new a.b[0]) : new b1.a(d6);
    }
}
