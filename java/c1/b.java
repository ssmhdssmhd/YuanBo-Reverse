package c1;

import b1.e;
import b1.h;
import i2.h0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import l2.d;

/* loaded from: classes.dex */
public final class b extends h {
    private static b1.a c(h0 h0Var) {
        h0Var.r(12);
        int d6 = (h0Var.d() + h0Var.h(12)) - 4;
        h0Var.r(44);
        h0Var.s(h0Var.h(12));
        h0Var.r(16);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String str = null;
            if (h0Var.d() >= d6) {
                break;
            }
            h0Var.r(48);
            int h6 = h0Var.h(8);
            h0Var.r(4);
            int d7 = h0Var.d() + h0Var.h(12);
            String str2 = null;
            while (h0Var.d() < d7) {
                int h7 = h0Var.h(8);
                int h8 = h0Var.h(8);
                int d8 = h0Var.d() + h8;
                if (h7 == 2) {
                    int h9 = h0Var.h(16);
                    h0Var.r(8);
                    if (h9 == 3) {
                        while (h0Var.d() < d8) {
                            str = h0Var.l(h0Var.h(8), d.f7487a);
                            int h10 = h0Var.h(8);
                            for (int i6 = 0; i6 < h10; i6++) {
                                h0Var.s(h0Var.h(8));
                            }
                        }
                    }
                } else if (h7 == 21) {
                    str2 = h0Var.l(h8, d.f7487a);
                }
                h0Var.p(d8 * 8);
            }
            h0Var.p(d7 * 8);
            if (str != null && str2 != null) {
                arrayList.add(new a(h6, str + str2));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new b1.a(arrayList);
    }

    @Override // b1.h
    protected b1.a b(e eVar, ByteBuffer byteBuffer) {
        if (byteBuffer.get() == 116) {
            return c(new h0(byteBuffer.array(), byteBuffer.limit()));
        }
        return null;
    }
}
