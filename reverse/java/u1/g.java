package u1;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class g extends l0.l<l, m, j> implements i {

    /* renamed from: n, reason: collision with root package name */
    private final String f9652n;

    class a extends m {
        a() {
        }

        @Override // l0.j
        public void o() {
            g.this.s(this);
        }
    }

    protected g(String str) {
        super(new l[2], new m[2]);
        this.f9652n = str;
        v(1024);
    }

    protected abstract h A(byte[] bArr, int i6, boolean z5);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l0.l
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public final j k(l lVar, m mVar, boolean z5) {
        try {
            ByteBuffer byteBuffer = (ByteBuffer) i2.a.e(lVar.f7162c);
            mVar.p(lVar.f7164e, A(byteBuffer.array(), byteBuffer.limit(), z5), lVar.f9655m);
            mVar.g(Integer.MIN_VALUE);
            return null;
        } catch (j e6) {
            return e6;
        }
    }

    @Override // u1.i
    public void b(long j6) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l0.l
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public final l h() {
        return new l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l0.l
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final m i() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // l0.l
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public final j j(Throwable th) {
        return new j("Unexpected decode error", th);
    }
}
