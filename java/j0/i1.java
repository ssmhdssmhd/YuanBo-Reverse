package j0;

import j0.i;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class i1 extends b0 {

    /* renamed from: i, reason: collision with root package name */
    private static final int f6448i = Float.floatToIntBits(Float.NaN);

    i1() {
    }

    private static void m(int i6, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (i6 * 4.656612875245797E-10d));
        if (floatToIntBits == f6448i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    @Override // j0.i
    public void e(ByteBuffer byteBuffer) {
        ByteBuffer l6;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i6 = limit - position;
        int i7 = this.f6386b.f6446c;
        if (i7 == 536870912) {
            l6 = l((i6 / 3) * 4);
            while (position < limit) {
                m(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << 24), l6);
                position += 3;
            }
        } else {
            if (i7 != 805306368) {
                throw new IllegalStateException();
            }
            l6 = l(i6);
            while (position < limit) {
                m((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << 24), l6);
                position += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        l6.flip();
    }

    @Override // j0.b0
    public i.a h(i.a aVar) {
        int i6 = aVar.f6446c;
        if (i2.c1.u0(i6)) {
            return i6 != 4 ? new i.a(aVar.f6444a, aVar.f6445b, 4) : i.a.f6443e;
        }
        throw new i.b(aVar);
    }
}
