package m0;

import java.util.UUID;
import m0.g0;

/* loaded from: classes.dex */
public final class r0 implements s0 {

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f7873a;

    public r0(byte[] bArr) {
        this.f7873a = (byte[]) i2.a.e(bArr);
    }

    @Override // m0.s0
    public byte[] a(UUID uuid, g0.a aVar) {
        return this.f7873a;
    }

    @Override // m0.s0
    public byte[] b(UUID uuid, g0.d dVar) {
        throw new UnsupportedOperationException();
    }
}
