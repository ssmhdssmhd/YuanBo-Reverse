package j3;

import java.util.Map;
import y3.j;
import y3.k;

/* loaded from: classes.dex */
public final class a implements k.c {

    /* renamed from: a, reason: collision with root package name */
    private final c f6805a;

    /* renamed from: b, reason: collision with root package name */
    private final dev.fluttercommunity.plus.share.a f6806b;

    public a(c share, dev.fluttercommunity.plus.share.a manager) {
        kotlin.jvm.internal.k.e(share, "share");
        kotlin.jvm.internal.k.e(manager, "manager");
        this.f6805a = share;
        this.f6806b = manager;
    }

    private final void a(j jVar) {
        if (!(jVar.f11101b instanceof Map)) {
            throw new IllegalArgumentException("Map arguments expected".toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r1.equals("share") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0053, code lost:
    
        a(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0056, code lost:
    
        if (r2 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005e, code lost:
    
        if (r12.f6806b.c(r14) != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        r1 = r12.f6805a;
        r3 = r13.a("text");
        kotlin.jvm.internal.k.c(r3, "null cannot be cast to non-null type kotlin.String");
        r1.n((java.lang.String) r3, (java.lang.String) r13.a("subject"), r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0077, code lost:
    
        if (r2 != false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0079, code lost:
    
        if (r0 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007b, code lost:
    
        r14.b("dev.fluttercommunity.plus/share/unavailable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        r14.b(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0045, code lost:
    
        if (r1.equals("shareFilesWithResult") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008c, code lost:
    
        a(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x008f, code lost:
    
        if (r2 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0097, code lost:
    
        if (r12.f6806b.c(r14) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
    
        r1 = r12.f6805a;
        r3 = r13.a("paths");
        kotlin.jvm.internal.k.b(r3);
        r1.o((java.util.List) r3, (java.util.List) r13.a("mimeTypes"), (java.lang.String) r13.a("text"), (java.lang.String) r13.a("subject"), r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c3, code lost:
    
        if (r2 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c5, code lost:
    
        if (r0 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c7, code lost:
    
        r14.b("dev.fluttercommunity.plus/share/unavailable");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        r14.b(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cf, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d0, code lost:
    
        r14.a("Share failed", r13.getMessage(), null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x004f, code lost:
    
        if (r1.equals("shareWithResult") == false) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0089, code lost:
    
        if (r1.equals("shareFiles") == false) goto L47;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00d0 -> B:37:0x00dd). Please report as a decompilation issue!!! */
    @Override // y3.k.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(y3.j r13, y3.k.d r14) {
        /*
            r12 = this;
            java.lang.String r0 = "call"
            kotlin.jvm.internal.k.e(r13, r0)
            java.lang.String r0 = "result"
            kotlin.jvm.internal.k.e(r14, r0)
            java.lang.String r0 = r13.f11100a
            java.lang.String r1 = "call.method"
            kotlin.jvm.internal.k.d(r0, r1)
            java.lang.String r1 = "WithResult"
            r2 = 0
            r3 = 2
            r4 = 0
            boolean r0 = v4.g.n(r0, r1, r2, r3, r4)
            if (r0 == 0) goto L23
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 22
            if (r1 < r3) goto L23
            r2 = 1
        L23:
            java.lang.String r1 = r13.f11100a
            if (r1 == 0) goto Lda
            int r3 = r1.hashCode()
            java.lang.String r11 = "dev.fluttercommunity.plus/share/unavailable"
            java.lang.String r5 = "subject"
            java.lang.String r6 = "text"
            switch(r3) {
                case -1811378728: goto L83;
                case -1594861118: goto L49;
                case -1212337029: goto L3f;
                case 109400031: goto L36;
                default: goto L34;
            }
        L34:
            goto Lda
        L36:
            java.lang.String r3 = "share"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto Lda
            goto L53
        L3f:
            java.lang.String r3 = "shareFilesWithResult"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L8c
            goto Lda
        L49:
            java.lang.String r3 = "shareWithResult"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L53
            goto Lda
        L53:
            r12.a(r13)
            if (r2 == 0) goto L61
            dev.fluttercommunity.plus.share.a r1 = r12.f6806b
            boolean r1 = r1.c(r14)
            if (r1 != 0) goto L61
            return
        L61:
            j3.c r1 = r12.f6805a
            java.lang.Object r3 = r13.a(r6)
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.k.c(r3, r6)
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r13 = r13.a(r5)
            java.lang.String r13 = (java.lang.String) r13
            r1.n(r3, r13, r2)
            if (r2 != 0) goto Ldd
            if (r0 == 0) goto L7f
            r14.b(r11)
            goto Ldd
        L7f:
            r14.b(r4)
            goto Ldd
        L83:
            java.lang.String r3 = "shareFiles"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L8c
            goto Lda
        L8c:
            r12.a(r13)
            if (r2 == 0) goto L9a
            dev.fluttercommunity.plus.share.a r1 = r12.f6806b
            boolean r1 = r1.c(r14)
            if (r1 != 0) goto L9a
            return
        L9a:
            j3.c r1 = r12.f6805a     // Catch: java.io.IOException -> Lcf
            java.lang.String r3 = "paths"
            java.lang.Object r3 = r13.a(r3)     // Catch: java.io.IOException -> Lcf
            kotlin.jvm.internal.k.b(r3)     // Catch: java.io.IOException -> Lcf
            java.util.List r3 = (java.util.List) r3     // Catch: java.io.IOException -> Lcf
            java.lang.String r7 = "mimeTypes"
            java.lang.Object r7 = r13.a(r7)     // Catch: java.io.IOException -> Lcf
            java.util.List r7 = (java.util.List) r7     // Catch: java.io.IOException -> Lcf
            java.lang.Object r6 = r13.a(r6)     // Catch: java.io.IOException -> Lcf
            r8 = r6
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.io.IOException -> Lcf
            java.lang.Object r13 = r13.a(r5)     // Catch: java.io.IOException -> Lcf
            r9 = r13
            java.lang.String r9 = (java.lang.String) r9     // Catch: java.io.IOException -> Lcf
            r5 = r1
            r6 = r3
            r10 = r2
            r5.o(r6, r7, r8, r9, r10)     // Catch: java.io.IOException -> Lcf
            if (r2 != 0) goto Ldd
            if (r0 == 0) goto Lcb
            r14.b(r11)     // Catch: java.io.IOException -> Lcf
            goto Ldd
        Lcb:
            r14.b(r4)     // Catch: java.io.IOException -> Lcf
            goto Ldd
        Lcf:
            r13 = move-exception
            java.lang.String r0 = "Share failed"
            java.lang.String r13 = r13.getMessage()
            r14.a(r0, r13, r4)
            goto Ldd
        Lda:
            r14.c()
        Ldd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.a.e(y3.j, y3.k$d):void");
    }
}
