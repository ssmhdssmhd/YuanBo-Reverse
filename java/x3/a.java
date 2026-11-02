package x3;

import com.tendcloud.tenddata.cs;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.h;
import java.util.HashMap;
import y3.a;
import y3.q;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public final y3.a<Object> f10475a;

    /* renamed from: b, reason: collision with root package name */
    public final FlutterJNI f10476b;

    /* renamed from: c, reason: collision with root package name */
    private b f10477c;

    /* renamed from: d, reason: collision with root package name */
    final a.d<Object> f10478d;

    /* renamed from: x3.a$a, reason: collision with other inner class name */
    class C0165a implements a.d<Object> {
        C0165a() {
        }

        @Override // y3.a.d
        public void a(Object obj, a.e<Object> eVar) {
            HashMap hashMap;
            HashMap hashMap2;
            if (a.this.f10477c == null) {
                eVar.a(null);
                return;
            }
            hashMap = (HashMap) obj;
            String str = (String) hashMap.get("type");
            hashMap2 = (HashMap) hashMap.get(cs.a.DATA);
            k3.b.f("AccessibilityChannel", "Received " + str + " message.");
            str.hashCode();
            switch (str) {
                case "tooltip":
                    String str2 = (String) hashMap2.get("message");
                    if (str2 != null) {
                        a.this.f10477c.d(str2);
                        break;
                    }
                    break;
                case "announce":
                    String str3 = (String) hashMap2.get("message");
                    if (str3 != null) {
                        a.this.f10477c.a(str3);
                        break;
                    }
                    break;
                case "tap":
                    Integer num = (Integer) hashMap.get("nodeId");
                    if (num != null) {
                        a.this.f10477c.f(num.intValue());
                        break;
                    }
                    break;
                case "longPress":
                    Integer num2 = (Integer) hashMap.get("nodeId");
                    if (num2 != null) {
                        a.this.f10477c.e(num2.intValue());
                        break;
                    }
                    break;
            }
            eVar.a(null);
        }
    }

    public interface b extends FlutterJNI.a {
        void a(String str);

        void d(String str);

        void e(int i6);

        void f(int i6);
    }

    public a(m3.a aVar, FlutterJNI flutterJNI) {
        C0165a c0165a = new C0165a();
        this.f10478d = c0165a;
        y3.a<Object> aVar2 = new y3.a<>(aVar, "flutter/accessibility", q.f11112a);
        this.f10475a = aVar2;
        aVar2.e(c0165a);
        this.f10476b = flutterJNI;
    }

    public void b(int i6, h.g gVar) {
        this.f10476b.dispatchSemanticsAction(i6, gVar);
    }

    public void c(int i6, h.g gVar, Object obj) {
        this.f10476b.dispatchSemanticsAction(i6, gVar, obj);
    }

    public void d() {
        this.f10476b.setSemanticsEnabled(false);
    }

    public void e() {
        this.f10476b.setSemanticsEnabled(true);
    }

    public void f(int i6) {
        this.f10476b.setAccessibilityFeatures(i6);
    }

    public void g(b bVar) {
        this.f10477c = bVar;
        this.f10476b.setAccessibilityDelegate(bVar);
    }
}
