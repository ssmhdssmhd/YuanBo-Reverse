package androidx.window.layout;

import android.app.Activity;
import e4.q;
import kotlin.coroutines.jvm.internal.k;
import o4.p;

@kotlin.coroutines.jvm.internal.f(c = "androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1", f = "WindowInfoTrackerImpl.kt", l = {54, 55}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WindowInfoTrackerImpl$windowLayoutInfo$1 extends k implements p<z4.c<? super WindowLayoutInfo>, h4.d<? super q>, Object> {
    final /* synthetic */ Activity $activity;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ WindowInfoTrackerImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WindowInfoTrackerImpl$windowLayoutInfo$1(WindowInfoTrackerImpl windowInfoTrackerImpl, Activity activity, h4.d<? super WindowInfoTrackerImpl$windowLayoutInfo$1> dVar) {
        super(2, dVar);
        this.this$0 = windowInfoTrackerImpl;
        this.$activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invokeSuspend$lambda-0, reason: not valid java name */
    public static final void m7invokeSuspend$lambda0(y4.f fVar, WindowLayoutInfo info) {
        kotlin.jvm.internal.k.d(info, "info");
        fVar.a(info);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final h4.d<q> create(Object obj, h4.d<?> dVar) {
        WindowInfoTrackerImpl$windowLayoutInfo$1 windowInfoTrackerImpl$windowLayoutInfo$1 = new WindowInfoTrackerImpl$windowLayoutInfo$1(this.this$0, this.$activity, dVar);
        windowInfoTrackerImpl$windowLayoutInfo$1.L$0 = obj;
        return windowInfoTrackerImpl$windowLayoutInfo$1;
    }

    @Override // o4.p
    public final Object invoke(z4.c<? super WindowLayoutInfo> cVar, h4.d<? super q> dVar) {
        return ((WindowInfoTrackerImpl$windowLayoutInfo$1) create(cVar, dVar)).invokeSuspend(q.f3710a);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007e A[Catch: all -> 0x00a1, TRY_LEAVE, TryCatch #0 {all -> 0x00a1, blocks: (B:11:0x0064, B:16:0x0076, B:18:0x007e), top: B:10:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0093 -> B:10:0x0064). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = i4.b.c()
            int r1 = r9.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L39
            if (r1 == r3) goto L27
            if (r1 != r2) goto L1f
            java.lang.Object r1 = r9.L$2
            y4.g r1 = (y4.g) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.a r4 = (androidx.core.util.a) r4
            java.lang.Object r5 = r9.L$0
            z4.c r5 = (z4.c) r5
            e4.l.b(r10)     // Catch: java.lang.Throwable -> La3
            r10 = r5
            goto L63
        L1f:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L27:
            java.lang.Object r1 = r9.L$2
            y4.g r1 = (y4.g) r1
            java.lang.Object r4 = r9.L$1
            androidx.core.util.a r4 = (androidx.core.util.a) r4
            java.lang.Object r5 = r9.L$0
            z4.c r5 = (z4.c) r5
            e4.l.b(r10)     // Catch: java.lang.Throwable -> La3
            r6 = r5
            r5 = r9
            goto L76
        L39:
            e4.l.b(r10)
            java.lang.Object r10 = r9.L$0
            z4.c r10 = (z4.c) r10
            y4.e r1 = y4.e.DROP_OLDEST
            r4 = 4
            r5 = 10
            r6 = 0
            y4.f r1 = y4.h.b(r5, r1, r6, r4, r6)
            androidx.window.layout.f r4 = new androidx.window.layout.f
            r4.<init>()
            androidx.window.layout.WindowInfoTrackerImpl r5 = r9.this$0
            androidx.window.layout.WindowBackend r5 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r5)
            android.app.Activity r6 = r9.$activity
            androidx.window.layout.g r7 = new androidx.window.layout.g
            r7.<init>()
            r5.registerLayoutChangeCallback(r6, r7, r4)
            y4.g r1 = r1.iterator()     // Catch: java.lang.Throwable -> La3
        L63:
            r5 = r9
        L64:
            r5.L$0 = r10     // Catch: java.lang.Throwable -> La1
            r5.L$1 = r4     // Catch: java.lang.Throwable -> La1
            r5.L$2 = r1     // Catch: java.lang.Throwable -> La1
            r5.label = r3     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = r1.a(r5)     // Catch: java.lang.Throwable -> La1
            if (r6 != r0) goto L73
            return r0
        L73:
            r8 = r6
            r6 = r10
            r10 = r8
        L76:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch: java.lang.Throwable -> La1
            boolean r10 = r10.booleanValue()     // Catch: java.lang.Throwable -> La1
            if (r10 == 0) goto L95
            java.lang.Object r10 = r1.next()     // Catch: java.lang.Throwable -> La1
            androidx.window.layout.WindowLayoutInfo r10 = (androidx.window.layout.WindowLayoutInfo) r10     // Catch: java.lang.Throwable -> La1
            r5.L$0 = r6     // Catch: java.lang.Throwable -> La1
            r5.L$1 = r4     // Catch: java.lang.Throwable -> La1
            r5.L$2 = r1     // Catch: java.lang.Throwable -> La1
            r5.label = r2     // Catch: java.lang.Throwable -> La1
            java.lang.Object r10 = r6.emit(r10, r5)     // Catch: java.lang.Throwable -> La1
            if (r10 != r0) goto L93
            return r0
        L93:
            r10 = r6
            goto L64
        L95:
            androidx.window.layout.WindowInfoTrackerImpl r10 = r5.this$0
            androidx.window.layout.WindowBackend r10 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r10)
            r10.unregisterLayoutChangeCallback(r4)
            e4.q r10 = e4.q.f3710a
            return r10
        La1:
            r10 = move-exception
            goto La5
        La3:
            r10 = move-exception
            r5 = r9
        La5:
            androidx.window.layout.WindowInfoTrackerImpl r0 = r5.this$0
            androidx.window.layout.WindowBackend r0 = androidx.window.layout.WindowInfoTrackerImpl.access$getWindowBackend$p(r0)
            r0.unregisterLayoutChangeCallback(r4)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.WindowInfoTrackerImpl$windowLayoutInfo$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
