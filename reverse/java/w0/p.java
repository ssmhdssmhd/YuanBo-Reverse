package w0;

import i2.t;
import o0.e0;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f10125a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10126b;

    /* renamed from: c, reason: collision with root package name */
    public final e0.a f10127c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10128d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f10129e;

    public p(boolean z5, String str, int i6, byte[] bArr, int i7, int i8, byte[] bArr2) {
        i2.a.a((bArr2 == null) ^ (i6 == 0));
        this.f10125a = z5;
        this.f10126b = str;
        this.f10128d = i6;
        this.f10129e = bArr2;
        this.f10127c = new e0.a(a(str), bArr, i7, i8);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private static int a(String str) {
        if (str == null) {
            return 1;
        }
        char c6 = 65535;
        switch (str.hashCode()) {
            case 3046605:
                if (str.equals("cbc1")) {
                    c6 = 0;
                    break;
                }
                break;
            case 3046671:
                if (str.equals("cbcs")) {
                    c6 = 1;
                    break;
                }
                break;
            case 3049879:
                if (str.equals("cenc")) {
                    c6 = 2;
                    break;
                }
                break;
            case 3049895:
                if (str.equals("cens")) {
                    c6 = 3;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
            case 1:
                return 2;
            default:
                t.i("TrackEncryptionBox", "Unsupported protection scheme type '" + str + "'. Assuming AES-CTR crypto mode.");
            case 2:
            case 3:
                return 1;
        }
    }
}
