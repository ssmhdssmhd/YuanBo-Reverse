package h3;

import h3.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import y3.a;
import y3.i;

/* loaded from: classes.dex */
public final /* synthetic */ class d {
    public static i<Object> a() {
        return a.d.f5234d;
    }

    public static /* synthetic */ void b(a.c cVar, Object obj, a.e eVar) {
        Map b6;
        a.b bVar;
        HashMap hashMap = new HashMap();
        try {
            bVar = (a.b) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (bVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        cVar.e(bVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void c(a.c cVar, Object obj, a.e eVar) {
        Map b6;
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("result", cVar.isEnabled());
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        eVar.a(hashMap);
    }

    public static void d(y3.c cVar, final a.c cVar2) {
        y3.a aVar = new y3.a(cVar, "dev.flutter.pigeon.WakelockApi.toggle", a());
        if (cVar2 != null) {
            aVar.e(new a.d() { // from class: h3.b
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    d.b(a.c.this, obj, eVar);
                }
            });
        } else {
            aVar.e(null);
        }
        y3.a aVar2 = new y3.a(cVar, "dev.flutter.pigeon.WakelockApi.isEnabled", a());
        if (cVar2 != null) {
            aVar2.e(new a.d() { // from class: h3.c
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    d.c(a.c.this, obj, eVar);
                }
            });
        } else {
            aVar2.e(null);
        }
    }
}
