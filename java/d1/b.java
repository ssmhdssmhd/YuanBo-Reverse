package d1;

import b1.e;
import b1.h;
import i2.i0;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class b extends h {
    @Override // b1.h
    protected b1.a b(e eVar, ByteBuffer byteBuffer) {
        return new b1.a(c(new i0(byteBuffer.array(), byteBuffer.limit())));
    }

    public a c(i0 i0Var) {
        return new a((String) i2.a.e(i0Var.z()), (String) i2.a.e(i0Var.z()), i0Var.y(), i0Var.y(), Arrays.copyOfRange(i0Var.e(), i0Var.f(), i0Var.g()));
    }
}
