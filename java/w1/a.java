package w1;

import i2.i0;
import java.util.List;
import u1.g;
import u1.h;

/* loaded from: classes.dex */
public final class a extends g {

    /* renamed from: o, reason: collision with root package name */
    private final b f10156o;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        i0 i0Var = new i0(list.get(0));
        this.f10156o = new b(i0Var.L(), i0Var.L());
    }

    @Override // u1.g
    protected h A(byte[] bArr, int i6, boolean z5) {
        if (z5) {
            this.f10156o.r();
        }
        return new c(this.f10156o.b(bArr, i6));
    }
}
