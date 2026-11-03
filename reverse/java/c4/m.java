package c4;

import c4.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import y3.a;

/* loaded from: classes.dex */
public final /* synthetic */ class m {
    public static y3.i<Object> a() {
        return a.c.f1827d;
    }

    public static /* synthetic */ void b(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        HashMap hashMap = new HashMap();
        try {
            bVar.a();
            hashMap.put("result", null);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        eVar.a(hashMap);
    }

    public static /* synthetic */ void c(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.d dVar;
        HashMap hashMap = new HashMap();
        try {
            dVar = (a.d) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (dVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        hashMap.put("result", bVar.l(dVar));
        eVar.a(hashMap);
    }

    public static /* synthetic */ void d(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.f fVar;
        HashMap hashMap = new HashMap();
        try {
            fVar = (a.f) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (fVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.d(fVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void e(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.i iVar;
        HashMap hashMap = new HashMap();
        try {
            iVar = (a.i) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (iVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.i(iVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void f(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.e eVar2;
        HashMap hashMap = new HashMap();
        try {
            eVar2 = (a.e) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (eVar2 == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.m(eVar2);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void g(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.j jVar;
        HashMap hashMap = new HashMap();
        try {
            jVar = (a.j) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (jVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.g(jVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void h(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.g gVar;
        HashMap hashMap = new HashMap();
        try {
            gVar = (a.g) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (gVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.k(gVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void i(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.i iVar;
        HashMap hashMap = new HashMap();
        try {
            iVar = (a.i) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (iVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.h(iVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void j(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.i iVar;
        HashMap hashMap = new HashMap();
        try {
            iVar = (a.i) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (iVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        hashMap.put("result", bVar.c(iVar));
        eVar.a(hashMap);
    }

    public static /* synthetic */ void k(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.h hVar;
        HashMap hashMap = new HashMap();
        try {
            hVar = (a.h) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (hVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.f(hVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static /* synthetic */ void l(a.b bVar, Object obj, a.e eVar) {
        Map b6;
        a.i iVar;
        HashMap hashMap = new HashMap();
        try {
            iVar = (a.i) ((ArrayList) obj).get(0);
        } catch (Error | RuntimeException e6) {
            b6 = a.b(e6);
            hashMap.put("error", b6);
        }
        if (iVar == null) {
            throw new NullPointerException("msgArg unexpectedly null.");
        }
        bVar.e(iVar);
        hashMap.put("result", null);
        eVar.a(hashMap);
    }

    public static void m(y3.c cVar, final a.b bVar) {
        y3.a aVar = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.initialize", a());
        if (bVar != null) {
            aVar.e(new a.d() { // from class: c4.b
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.b(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar.e(null);
        }
        y3.a aVar2 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.create", a());
        if (bVar != null) {
            aVar2.e(new a.d() { // from class: c4.e
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.c(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar2.e(null);
        }
        y3.a aVar3 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.dispose", a());
        if (bVar != null) {
            aVar3.e(new a.d() { // from class: c4.f
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.e(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar3.e(null);
        }
        y3.a aVar4 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.setLooping", a());
        if (bVar != null) {
            aVar4.e(new a.d() { // from class: c4.g
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.f(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar4.e(null);
        }
        y3.a aVar5 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.setVolume", a());
        if (bVar != null) {
            aVar5.e(new a.d() { // from class: c4.h
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.g(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar5.e(null);
        }
        y3.a aVar6 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.setPlaybackSpeed", a());
        if (bVar != null) {
            aVar6.e(new a.d() { // from class: c4.i
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.h(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar6.e(null);
        }
        y3.a aVar7 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.play", a());
        if (bVar != null) {
            aVar7.e(new a.d() { // from class: c4.j
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.i(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar7.e(null);
        }
        y3.a aVar8 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.position", a());
        if (bVar != null) {
            aVar8.e(new a.d() { // from class: c4.k
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.j(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar8.e(null);
        }
        y3.a aVar9 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.seekTo", a());
        if (bVar != null) {
            aVar9.e(new a.d() { // from class: c4.l
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.k(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar9.e(null);
        }
        y3.a aVar10 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.pause", a());
        if (bVar != null) {
            aVar10.e(new a.d() { // from class: c4.c
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.l(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar10.e(null);
        }
        y3.a aVar11 = new y3.a(cVar, "dev.flutter.pigeon.AndroidVideoPlayerApi.setMixWithOthers", a());
        if (bVar != null) {
            aVar11.e(new a.d() { // from class: c4.d
                @Override // y3.a.d
                public final void a(Object obj, a.e eVar) {
                    m.d(a.b.this, obj, eVar);
                }
            });
        } else {
            aVar11.e(null);
        }
    }
}
