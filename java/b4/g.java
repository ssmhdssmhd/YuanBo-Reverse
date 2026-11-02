package b4;

import b4.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import y3.a;

/* loaded from: classes.dex */
public final /* synthetic */ class g {
    public static y3.i<Object> a() {
        return h.b.f1789d;
    }

    public static /* synthetic */ void b(h.a aVar, Object obj, a.e eVar) {
        Map b6;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", aVar.a());
        } catch (Error | RuntimeException e6) {
            b6 = h.b(e6);
            hashMap.put("error", b6);
        }
        eVar.a(hashMap);
    }

    public static /* synthetic */ void c(h.a aVar, Object obj, a.e eVar) {
        Map b6;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", aVar.e());
        } catch (Error | RuntimeException e6) {
            b6 = h.b(e6);
            hashMap.put("error", b6);
        }
        eVar.a(hashMap);
    }

    public static /* synthetic */ void d(h.a aVar, Object obj, a.e eVar) {
        Map b6;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", aVar.c());
        } catch (Error | RuntimeException e6) {
            b6 = h.b(e6);
            hashMap.put("error", b6);
        }
        eVar.a(hashMap);
    }

    public static /* synthetic */ void e(h.a aVar, Object obj, a.e eVar) {
        Map b6;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", aVar.f());
        } catch (Error | RuntimeException e6) {
            b6 = h.b(e6);
            hashMap.put("error", b6);
        }
        eVar.a(hashMap);
    }

    public static /* synthetic */ void f(h.a aVar, Object obj, a.e eVar) {
        Map b6;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", aVar.d());
        } catch (Error | RuntimeException e6) {
            b6 = h.b(e6);
            hashMap.put("error", b6);
        }
        eVar.a(hashMap);
    }

    public static /* synthetic */ void g(h.a aVar, Object obj, a.e eVar) {
        Map b6;
        h.c cVar;
        HashMap hashMap = new HashMap();
        try {
            ArrayList arrayList = (ArrayList) obj;
            cVar = arrayList.get(0) == null ? null : h.c.values()[((Integer) arrayList.get(0)).intValue()];
        } catch (Error | RuntimeException e6) {
            b6 = h.b(e6);
            hashMap.put("error", b6);
        }
        if (cVar == null) {
            throw new NullPointerException("directoryArg unexpectedly null.");
        }
        hashMap.put("result", aVar.g(cVar));
        eVar.a(hashMap);
    }

    public static void h(y3.c cVar, final h.a aVar) {
        y3.a aVar2 = new y3.a(cVar, "dev.flutter.pigeon.PathProviderApi.getTemporaryPath", a(), cVar.d());
        if (aVar != null) {
            aVar2.e(new a.d() { // from class: b4.a
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    g.b(h.a.this, obj, eVar);
                }
            });
        } else {
            aVar2.e(null);
        }
        y3.a aVar3 = new y3.a(cVar, "dev.flutter.pigeon.PathProviderApi.getApplicationSupportPath", a(), cVar.d());
        if (aVar != null) {
            aVar3.e(new a.d() { // from class: b4.b
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    g.c(h.a.this, obj, eVar);
                }
            });
        } else {
            aVar3.e(null);
        }
        y3.a aVar4 = new y3.a(cVar, "dev.flutter.pigeon.PathProviderApi.getApplicationDocumentsPath", a(), cVar.d());
        if (aVar != null) {
            aVar4.e(new a.d() { // from class: b4.c
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    g.d(h.a.this, obj, eVar);
                }
            });
        } else {
            aVar4.e(null);
        }
        y3.a aVar5 = new y3.a(cVar, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePath", a(), cVar.d());
        if (aVar != null) {
            aVar5.e(new a.d() { // from class: b4.d
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    g.e(h.a.this, obj, eVar);
                }
            });
        } else {
            aVar5.e(null);
        }
        y3.a aVar6 = new y3.a(cVar, "dev.flutter.pigeon.PathProviderApi.getExternalCachePaths", a(), cVar.d());
        if (aVar != null) {
            aVar6.e(new a.d() { // from class: b4.e
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    g.f(h.a.this, obj, eVar);
                }
            });
        } else {
            aVar6.e(null);
        }
        y3.a aVar7 = new y3.a(cVar, "dev.flutter.pigeon.PathProviderApi.getExternalStoragePaths", a(), cVar.d());
        if (aVar != null) {
            aVar7.e(new a.d() { // from class: b4.f
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    g.g(h.a.this, obj, eVar);
                }
            });
        } else {
            aVar7.e(null);
        }
    }
}
