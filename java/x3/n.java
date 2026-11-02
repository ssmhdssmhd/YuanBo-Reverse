package x3;

import java.util.ArrayList;
import y3.k;
import y3.r;

/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final y3.k f10606a;

    /* renamed from: b, reason: collision with root package name */
    private b f10607b;

    /* renamed from: c, reason: collision with root package name */
    public final k.c f10608c;

    class a implements k.c {
        a() {
        }

        @Override // y3.k.c
        public void e(y3.j jVar, k.d dVar) {
            if (n.this.f10607b == null) {
                k3.b.f("SpellCheckChannel", "No SpellCheckeMethodHandler registered, call not forwarded to spell check API.");
                return;
            }
            String str = jVar.f11100a;
            Object obj = jVar.f11101b;
            k3.b.f("SpellCheckChannel", "Received '" + str + "' message.");
            str.hashCode();
            if (!str.equals("SpellCheck.initiateSpellCheck")) {
                dVar.c();
                return;
            }
            try {
                ArrayList arrayList = (ArrayList) obj;
                n.this.f10607b.a((String) arrayList.get(0), (String) arrayList.get(1), dVar);
            } catch (IllegalStateException e6) {
                dVar.a("error", e6.getMessage(), null);
            }
        }
    }

    public interface b {
        void a(String str, String str2, k.d dVar);
    }

    public n(m3.a aVar) {
        a aVar2 = new a();
        this.f10608c = aVar2;
        y3.k kVar = new y3.k(aVar, "flutter/spellcheck", r.f11115b);
        this.f10606a = kVar;
        kVar.e(aVar2);
    }

    public void b(b bVar) {
        this.f10607b = bVar;
    }
}
