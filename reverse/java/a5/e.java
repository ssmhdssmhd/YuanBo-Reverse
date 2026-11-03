package a5;

import h4.g;
import kotlin.jvm.internal.l;
import kotlinx.coroutines.internal.z;
import o4.p;
import w4.l1;

/* loaded from: classes.dex */
public final class e {

    static final class a extends l implements p<Integer, g.b, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ c<?> f165a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(c<?> cVar) {
            super(2);
            this.f165a = cVar;
        }

        public final Integer a(int i6, g.b bVar) {
            g.c<?> key = bVar.getKey();
            g.b bVar2 = this.f165a.f158b.get(key);
            if (key != l1.f10320i) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i6 + 1);
            }
            l1 l1Var = (l1) bVar2;
            l1 b6 = e.b((l1) bVar, l1Var);
            if (b6 == l1Var) {
                if (l1Var != null) {
                    i6++;
                }
                return Integer.valueOf(i6);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + b6 + ", expected child of " + l1Var + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // o4.p
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    public static final void a(c<?> cVar, g gVar) {
        if (((Number) gVar.fold(0, new a(cVar))).intValue() == cVar.f159c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + cVar.f158b + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final l1 b(l1 l1Var, l1 l1Var2) {
        while (l1Var != null) {
            if (l1Var == l1Var2 || !(l1Var instanceof z)) {
                return l1Var;
            }
            l1Var = ((z) l1Var).y0();
        }
        return null;
    }
}
