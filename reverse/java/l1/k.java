package l1;

import android.content.Context;
import g2.m;
import g2.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import l1.v;

/* loaded from: classes.dex */
public final class k implements v.a {

    /* renamed from: a, reason: collision with root package name */
    private final a f7321a;

    /* renamed from: b, reason: collision with root package name */
    private m.a f7322b;

    /* renamed from: c, reason: collision with root package name */
    private long f7323c;

    /* renamed from: d, reason: collision with root package name */
    private long f7324d;

    /* renamed from: e, reason: collision with root package name */
    private long f7325e;

    /* renamed from: f, reason: collision with root package name */
    private float f7326f;

    /* renamed from: g, reason: collision with root package name */
    private float f7327g;

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final o0.r f7328a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<Integer, l2.p<v.a>> f7329b = new HashMap();

        /* renamed from: c, reason: collision with root package name */
        private final Set<Integer> f7330c = new HashSet();

        /* renamed from: d, reason: collision with root package name */
        private final Map<Integer, v.a> f7331d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private m.a f7332e;

        public a(o0.r rVar) {
            this.f7328a = rVar;
        }

        public void a(m.a aVar) {
            if (aVar != this.f7332e) {
                this.f7332e = aVar;
                this.f7329b.clear();
                this.f7331d.clear();
            }
        }
    }

    public k(Context context, o0.r rVar) {
        this(new u.a(context), rVar);
    }

    public k(m.a aVar, o0.r rVar) {
        this.f7322b = aVar;
        a aVar2 = new a(rVar);
        this.f7321a = aVar2;
        aVar2.a(aVar);
        this.f7323c = -9223372036854775807L;
        this.f7324d = -9223372036854775807L;
        this.f7325e = -9223372036854775807L;
        this.f7326f = -3.4028235E38f;
        this.f7327g = -3.4028235E38f;
    }
}
