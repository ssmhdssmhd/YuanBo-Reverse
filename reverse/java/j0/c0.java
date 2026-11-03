package j0;

import j0.i;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class c0 extends b0 {

    /* renamed from: i, reason: collision with root package name */
    private int[] f6399i;

    /* renamed from: j, reason: collision with root package name */
    private int[] f6400j;

    c0() {
    }

    @Override // j0.i
    public void e(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) i2.a.e(this.f6400j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer l6 = l(((limit - position) / this.f6386b.f6447d) * this.f6387c.f6447d);
        while (position < limit) {
            for (int i6 : iArr) {
                l6.putShort(byteBuffer.getShort((i6 * 2) + position));
            }
            position += this.f6386b.f6447d;
        }
        byteBuffer.position(limit);
        l6.flip();
    }

    @Override // j0.b0
    public i.a h(i.a aVar) {
        int[] iArr = this.f6399i;
        if (iArr == null) {
            return i.a.f6443e;
        }
        if (aVar.f6446c != 2) {
            throw new i.b(aVar);
        }
        boolean z5 = aVar.f6445b != iArr.length;
        int i6 = 0;
        while (i6 < iArr.length) {
            int i7 = iArr[i6];
            if (i7 >= aVar.f6445b) {
                throw new i.b(aVar);
            }
            z5 |= i7 != i6;
            i6++;
        }
        return z5 ? new i.a(aVar.f6444a, iArr.length, 2) : i.a.f6443e;
    }

    @Override // j0.b0
    protected void i() {
        this.f6400j = this.f6399i;
    }

    @Override // j0.b0
    protected void k() {
        this.f6400j = null;
        this.f6399i = null;
    }

    public void m(int[] iArr) {
        this.f6399i = iArr;
    }
}
