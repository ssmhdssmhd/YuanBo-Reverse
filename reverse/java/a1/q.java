package a1;

import android.media.MediaCodec;

/* loaded from: classes.dex */
public class q extends l0.h {

    /* renamed from: a, reason: collision with root package name */
    public final t f83a;

    /* renamed from: b, reason: collision with root package name */
    public final String f84b;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q(java.lang.Throwable r4, a1.t r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Decoder failed: "
            r0.append(r1)
            r1 = 0
            if (r5 != 0) goto Lf
            r2 = r1
            goto L11
        Lf:
            java.lang.String r2 = r5.f85a
        L11:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            r3.f83a = r5
            int r5 = i2.c1.f5548a
            r0 = 21
            if (r5 < r0) goto L27
            java.lang.String r1 = a(r4)
        L27:
            r3.f84b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a1.q.<init>(java.lang.Throwable, a1.t):void");
    }

    private static String a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
