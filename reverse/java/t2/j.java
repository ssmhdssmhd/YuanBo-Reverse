package t2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import q2.v;
import q2.w;
import q2.x;
import q2.y;

/* loaded from: classes.dex */
public final class j extends x<Object> {

    /* renamed from: c, reason: collision with root package name */
    private static final y f9426c = f(v.f8923a);

    /* renamed from: a, reason: collision with root package name */
    private final q2.e f9427a;

    /* renamed from: b, reason: collision with root package name */
    private final w f9428b;

    class a implements y {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ w f9429a;

        a(w wVar) {
            this.f9429a = wVar;
        }

        @Override // q2.y
        public <T> x<T> a(q2.e eVar, x2.a<T> aVar) {
            a aVar2 = null;
            if (aVar.c() == Object.class) {
                return new j(eVar, this.f9429a, aVar2);
            }
            return null;
        }
    }

    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f9430a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f9430a = iArr;
            try {
                iArr[y2.b.BEGIN_ARRAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f9430a[y2.b.BEGIN_OBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f9430a[y2.b.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f9430a[y2.b.NUMBER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f9430a[y2.b.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f9430a[y2.b.NULL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private j(q2.e eVar, w wVar) {
        this.f9427a = eVar;
        this.f9428b = wVar;
    }

    /* synthetic */ j(q2.e eVar, w wVar, a aVar) {
        this(eVar, wVar);
    }

    public static y e(w wVar) {
        return wVar == v.f8923a ? f9426c : f(wVar);
    }

    private static y f(w wVar) {
        return new a(wVar);
    }

    private Object g(y2.a aVar, y2.b bVar) {
        int i6 = b.f9430a[bVar.ordinal()];
        if (i6 == 3) {
            return aVar.e0();
        }
        if (i6 == 4) {
            return this.f9428b.a(aVar);
        }
        if (i6 == 5) {
            return Boolean.valueOf(aVar.W());
        }
        if (i6 == 6) {
            aVar.c0();
            return null;
        }
        throw new IllegalStateException("Unexpected token: " + bVar);
    }

    private Object h(y2.a aVar, y2.b bVar) {
        int i6 = b.f9430a[bVar.ordinal()];
        if (i6 == 1) {
            aVar.a();
            return new ArrayList();
        }
        if (i6 != 2) {
            return null;
        }
        aVar.j();
        return new s2.h();
    }

    @Override // q2.x
    public Object b(y2.a aVar) {
        y2.b g02 = aVar.g0();
        Object h6 = h(aVar, g02);
        if (h6 == null) {
            return g(aVar, g02);
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        while (true) {
            if (aVar.K()) {
                String a02 = h6 instanceof Map ? aVar.a0() : null;
                y2.b g03 = aVar.g0();
                Object h7 = h(aVar, g03);
                boolean z5 = h7 != null;
                if (h7 == null) {
                    h7 = g(aVar, g03);
                }
                if (h6 instanceof List) {
                    ((List) h6).add(h7);
                } else {
                    ((Map) h6).put(a02, h7);
                }
                if (z5) {
                    arrayDeque.addLast(h6);
                    h6 = h7;
                }
            } else {
                if (h6 instanceof List) {
                    aVar.t();
                } else {
                    aVar.v();
                }
                if (arrayDeque.isEmpty()) {
                    return h6;
                }
                h6 = arrayDeque.removeLast();
            }
        }
    }

    @Override // q2.x
    public void d(y2.c cVar, Object obj) {
        if (obj == null) {
            cVar.V();
            return;
        }
        x k6 = this.f9427a.k(obj.getClass());
        if (!(k6 instanceof j)) {
            k6.d(cVar, obj);
        } else {
            cVar.q();
            cVar.v();
        }
    }
}
