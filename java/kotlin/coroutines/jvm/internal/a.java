package kotlin.coroutines.jvm.internal;

import e4.k;
import e4.l;
import e4.q;
import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class a implements h4.d<Object>, e, Serializable {
    private final h4.d<Object> completion;

    public a(h4.d<Object> dVar) {
        this.completion = dVar;
    }

    public h4.d<q> create(h4.d<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public h4.d<q> create(Object obj, h4.d<?> completion) {
        kotlin.jvm.internal.k.e(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }

    public e getCallerFrame() {
        h4.d<Object> dVar = this.completion;
        if (dVar instanceof e) {
            return (e) dVar;
        }
        return null;
    }

    public final h4.d<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return g.d(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // h4.d
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        Object c6;
        h4.d dVar = this;
        while (true) {
            h.b(dVar);
            a aVar = (a) dVar;
            h4.d dVar2 = aVar.completion;
            kotlin.jvm.internal.k.b(dVar2);
            try {
                invokeSuspend = aVar.invokeSuspend(obj);
                c6 = i4.d.c();
            } catch (Throwable th) {
                k.a aVar2 = e4.k.f3704a;
                obj = e4.k.a(l.a(th));
            }
            if (invokeSuspend == c6) {
                return;
            }
            obj = e4.k.a(invokeSuspend);
            aVar.releaseIntercepted();
            if (!(dVar2 instanceof a)) {
                dVar2.resumeWith(obj);
                return;
            }
            dVar = dVar2;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }
}
