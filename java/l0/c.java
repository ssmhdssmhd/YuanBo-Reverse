package l0;

import android.media.MediaCodec;
import i2.c1;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public byte[] f7137a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f7138b;

    /* renamed from: c, reason: collision with root package name */
    public int f7139c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f7140d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f7141e;

    /* renamed from: f, reason: collision with root package name */
    public int f7142f;

    /* renamed from: g, reason: collision with root package name */
    public int f7143g;

    /* renamed from: h, reason: collision with root package name */
    public int f7144h;

    /* renamed from: i, reason: collision with root package name */
    private final MediaCodec.CryptoInfo f7145i;

    /* renamed from: j, reason: collision with root package name */
    private final b f7146j;

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final MediaCodec.CryptoInfo f7147a;

        /* renamed from: b, reason: collision with root package name */
        private final MediaCodec.CryptoInfo.Pattern f7148b;

        private b(MediaCodec.CryptoInfo cryptoInfo) {
            this.f7147a = cryptoInfo;
            this.f7148b = new MediaCodec.CryptoInfo.Pattern(0, 0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(int i6, int i7) {
            this.f7148b.set(i6, i7);
            this.f7147a.setPattern(this.f7148b);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c() {
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        this.f7145i = cryptoInfo;
        this.f7146j = c1.f5548a >= 24 ? new b(cryptoInfo) : null;
    }

    public MediaCodec.CryptoInfo a() {
        return this.f7145i;
    }

    public void b(int i6) {
        if (i6 == 0) {
            return;
        }
        if (this.f7140d == null) {
            int[] iArr = new int[1];
            this.f7140d = iArr;
            this.f7145i.numBytesOfClearData = iArr;
        }
        int[] iArr2 = this.f7140d;
        iArr2[0] = iArr2[0] + i6;
    }

    public void c(int i6, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i7, int i8, int i9) {
        this.f7142f = i6;
        this.f7140d = iArr;
        this.f7141e = iArr2;
        this.f7138b = bArr;
        this.f7137a = bArr2;
        this.f7139c = i7;
        this.f7143g = i8;
        this.f7144h = i9;
        MediaCodec.CryptoInfo cryptoInfo = this.f7145i;
        cryptoInfo.numSubSamples = i6;
        cryptoInfo.numBytesOfClearData = iArr;
        cryptoInfo.numBytesOfEncryptedData = iArr2;
        cryptoInfo.key = bArr;
        cryptoInfo.iv = bArr2;
        cryptoInfo.mode = i7;
        if (c1.f5548a >= 24) {
            ((b) i2.a.e(this.f7146j)).b(i8, i9);
        }
    }
}
