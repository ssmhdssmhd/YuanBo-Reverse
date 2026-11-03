package l5;

import q5.h;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name */
    public static final q5.h f7526d;

    /* renamed from: e, reason: collision with root package name */
    public static final q5.h f7527e;

    /* renamed from: f, reason: collision with root package name */
    public static final q5.h f7528f;

    /* renamed from: g, reason: collision with root package name */
    public static final q5.h f7529g;

    /* renamed from: h, reason: collision with root package name */
    public static final q5.h f7530h;

    /* renamed from: i, reason: collision with root package name */
    public static final q5.h f7531i;

    /* renamed from: j, reason: collision with root package name */
    public static final a f7532j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f7533a;

    /* renamed from: b, reason: collision with root package name */
    public final q5.h f7534b;

    /* renamed from: c, reason: collision with root package name */
    public final q5.h f7535c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    static {
        h.a aVar = q5.h.f8959e;
        f7526d = aVar.c(":");
        f7527e = aVar.c(":status");
        f7528f = aVar.c(":method");
        f7529g = aVar.c(":path");
        f7530h = aVar.c(":scheme");
        f7531i = aVar.c(":authority");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.k.e(r2, r0)
            java.lang.String r0 = "value"
            kotlin.jvm.internal.k.e(r3, r0)
            q5.h$a r0 = q5.h.f8959e
            q5.h r2 = r0.c(r2)
            q5.h r3 = r0.c(r3)
            r1.<init>(r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l5.c.<init>(java.lang.String, java.lang.String):void");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(q5.h name, String value) {
        this(name, q5.h.f8959e.c(value));
        kotlin.jvm.internal.k.e(name, "name");
        kotlin.jvm.internal.k.e(value, "value");
    }

    public c(q5.h name, q5.h value) {
        kotlin.jvm.internal.k.e(name, "name");
        kotlin.jvm.internal.k.e(value, "value");
        this.f7534b = name;
        this.f7535c = value;
        this.f7533a = name.r() + 32 + value.r();
    }

    public final q5.h a() {
        return this.f7534b;
    }

    public final q5.h b() {
        return this.f7535c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.k.a(this.f7534b, cVar.f7534b) && kotlin.jvm.internal.k.a(this.f7535c, cVar.f7535c);
    }

    public int hashCode() {
        q5.h hVar = this.f7534b;
        int hashCode = (hVar != null ? hVar.hashCode() : 0) * 31;
        q5.h hVar2 = this.f7535c;
        return hashCode + (hVar2 != null ? hVar2.hashCode() : 0);
    }

    public String toString() {
        return this.f7534b.u() + ": " + this.f7535c.u();
    }
}
