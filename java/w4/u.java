package w4;

/* loaded from: classes.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    public final Object f10355a;

    /* renamed from: b, reason: collision with root package name */
    public final i f10356b;

    /* renamed from: c, reason: collision with root package name */
    public final o4.l<Throwable, e4.q> f10357c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f10358d;

    /* renamed from: e, reason: collision with root package name */
    public final Throwable f10359e;

    /* JADX WARN: Multi-variable type inference failed */
    public u(Object obj, i iVar, o4.l<? super Throwable, e4.q> lVar, Object obj2, Throwable th) {
        this.f10355a = obj;
        this.f10356b = iVar;
        this.f10357c = lVar;
        this.f10358d = obj2;
        this.f10359e = th;
    }

    public /* synthetic */ u(Object obj, i iVar, o4.l lVar, Object obj2, Throwable th, int i6, kotlin.jvm.internal.g gVar) {
        this(obj, (i6 & 2) != 0 ? null : iVar, (i6 & 4) != 0 ? null : lVar, (i6 & 8) != 0 ? null : obj2, (i6 & 16) != 0 ? null : th);
    }

    public static /* synthetic */ u b(u uVar, Object obj, i iVar, o4.l lVar, Object obj2, Throwable th, int i6, Object obj3) {
        if ((i6 & 1) != 0) {
            obj = uVar.f10355a;
        }
        if ((i6 & 2) != 0) {
            iVar = uVar.f10356b;
        }
        i iVar2 = iVar;
        if ((i6 & 4) != 0) {
            lVar = uVar.f10357c;
        }
        o4.l lVar2 = lVar;
        if ((i6 & 8) != 0) {
            obj2 = uVar.f10358d;
        }
        Object obj4 = obj2;
        if ((i6 & 16) != 0) {
            th = uVar.f10359e;
        }
        return uVar.a(obj, iVar2, lVar2, obj4, th);
    }

    public final u a(Object obj, i iVar, o4.l<? super Throwable, e4.q> lVar, Object obj2, Throwable th) {
        return new u(obj, iVar, lVar, obj2, th);
    }

    public final boolean c() {
        return this.f10359e != null;
    }

    public final void d(l<?> lVar, Throwable th) {
        i iVar = this.f10356b;
        if (iVar != null) {
            lVar.o(iVar, th);
        }
        o4.l<Throwable, e4.q> lVar2 = this.f10357c;
        if (lVar2 == null) {
            return;
        }
        lVar.p(lVar2, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        return kotlin.jvm.internal.k.a(this.f10355a, uVar.f10355a) && kotlin.jvm.internal.k.a(this.f10356b, uVar.f10356b) && kotlin.jvm.internal.k.a(this.f10357c, uVar.f10357c) && kotlin.jvm.internal.k.a(this.f10358d, uVar.f10358d) && kotlin.jvm.internal.k.a(this.f10359e, uVar.f10359e);
    }

    public int hashCode() {
        Object obj = this.f10355a;
        int hashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        i iVar = this.f10356b;
        int hashCode2 = (hashCode + (iVar == null ? 0 : iVar.hashCode())) * 31;
        o4.l<Throwable, e4.q> lVar = this.f10357c;
        int hashCode3 = (hashCode2 + (lVar == null ? 0 : lVar.hashCode())) * 31;
        Object obj2 = this.f10358d;
        int hashCode4 = (hashCode3 + (obj2 == null ? 0 : obj2.hashCode())) * 31;
        Throwable th = this.f10359e;
        return hashCode4 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "CompletedContinuation(result=" + this.f10355a + ", cancelHandler=" + this.f10356b + ", onCancellation=" + this.f10357c + ", idempotentResume=" + this.f10358d + ", cancelCause=" + this.f10359e + ')';
    }
}
