package m0;

import i2.c1;
import java.util.UUID;

/* loaded from: classes.dex */
public final class h0 implements l0.b {

    /* renamed from: d, reason: collision with root package name */
    public static final boolean f7835d;

    /* renamed from: a, reason: collision with root package name */
    public final UUID f7836a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f7837b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f7838c;

    static {
        boolean z5;
        if ("Amazon".equals(c1.f5550c)) {
            String str = c1.f5551d;
            if ("AFTM".equals(str) || "AFTB".equals(str)) {
                z5 = true;
                f7835d = z5;
            }
        }
        z5 = false;
        f7835d = z5;
    }

    public h0(UUID uuid, byte[] bArr, boolean z5) {
        this.f7836a = uuid;
        this.f7837b = bArr;
        this.f7838c = z5;
    }
}
