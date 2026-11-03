package q1;

import android.net.Uri;
import g2.u0;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
class a implements g2.m {

    /* renamed from: a, reason: collision with root package name */
    private final g2.m f8709a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f8710b;

    /* renamed from: c, reason: collision with root package name */
    private final byte[] f8711c;

    /* renamed from: d, reason: collision with root package name */
    private CipherInputStream f8712d;

    public a(g2.m mVar, byte[] bArr, byte[] bArr2) {
        this.f8709a = mVar;
        this.f8710b = bArr;
        this.f8711c = bArr2;
    }

    @Override // g2.m
    public final long a(g2.q qVar) {
        try {
            Cipher o6 = o();
            try {
                o6.init(2, new SecretKeySpec(this.f8710b, "AES"), new IvParameterSpec(this.f8711c));
                g2.o oVar = new g2.o(this.f8709a, qVar);
                this.f8712d = new CipherInputStream(oVar, o6);
                oVar.j();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e6) {
                throw new RuntimeException(e6);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e7) {
            throw new RuntimeException(e7);
        }
    }

    @Override // g2.m
    public final void c(u0 u0Var) {
        i2.a.e(u0Var);
        this.f8709a.c(u0Var);
    }

    @Override // g2.m
    public void close() {
        if (this.f8712d != null) {
            this.f8712d = null;
            this.f8709a.close();
        }
    }

    @Override // g2.m
    public final Map<String, List<String>> f() {
        return this.f8709a.f();
    }

    @Override // g2.m
    public final Uri j() {
        return this.f8709a.j();
    }

    protected Cipher o() {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // g2.i
    public final int read(byte[] bArr, int i6, int i7) {
        i2.a.e(this.f8712d);
        int read = this.f8712d.read(bArr, i6, i7);
        if (read < 0) {
            return -1;
        }
        return read;
    }
}
