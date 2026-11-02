package g2;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class o extends InputStream {

    /* renamed from: a, reason: collision with root package name */
    private final m f4084a;

    /* renamed from: b, reason: collision with root package name */
    private final q f4085b;

    /* renamed from: j, reason: collision with root package name */
    private long f4089j;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4087d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f4088e = false;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f4086c = new byte[1];

    public o(m mVar, q qVar) {
        this.f4084a = mVar;
        this.f4085b = qVar;
    }

    private void a() {
        if (this.f4087d) {
            return;
        }
        this.f4084a.a(this.f4085b);
        this.f4087d = true;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f4088e) {
            return;
        }
        this.f4084a.close();
        this.f4088e = true;
    }

    public void j() {
        a();
    }

    @Override // java.io.InputStream
    public int read() {
        if (read(this.f4086c) == -1) {
            return -1;
        }
        return this.f4086c[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i6, int i7) {
        i2.a.g(!this.f4088e);
        a();
        int read = this.f4084a.read(bArr, i6, i7);
        if (read == -1) {
            return -1;
        }
        this.f4089j += read;
        return read;
    }
}
