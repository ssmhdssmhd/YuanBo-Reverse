package b1;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class h implements c {
    @Override // b1.c
    public final a a(e eVar) {
        ByteBuffer byteBuffer = (ByteBuffer) i2.a.e(eVar.f7162c);
        i2.a.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (eVar.j()) {
            return null;
        }
        return b(eVar, byteBuffer);
    }

    protected abstract a b(e eVar, ByteBuffer byteBuffer);
}
