package h4;

import e4.k;
import e4.q;
import kotlin.jvm.internal.k;
import o4.p;

/* loaded from: classes.dex */
public final class f {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r6, d<? super T> completion) {
        d a6;
        d b6;
        k.e(pVar, "<this>");
        k.e(completion, "completion");
        a6 = i4.c.a(pVar, r6, completion);
        b6 = i4.c.b(a6);
        k.a aVar = e4.k.f3704a;
        b6.resumeWith(e4.k.a(q.f3710a));
    }
}
