package g3;

import com.tendcloud.tenddata.cs;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import y3.k;

/* loaded from: classes.dex */
public class c extends g3.a {

    /* renamed from: a, reason: collision with root package name */
    final Map<String, Object> f4225a;

    /* renamed from: b, reason: collision with root package name */
    final a f4226b = new a();

    /* renamed from: c, reason: collision with root package name */
    final boolean f4227c;

    public class a implements f {

        /* renamed from: a, reason: collision with root package name */
        Object f4228a;

        /* renamed from: b, reason: collision with root package name */
        String f4229b;

        /* renamed from: c, reason: collision with root package name */
        String f4230c;

        /* renamed from: d, reason: collision with root package name */
        Object f4231d;

        public a() {
        }

        @Override // g3.f
        public void a(String str, String str2, Object obj) {
            this.f4229b = str;
            this.f4230c = str2;
            this.f4231d = obj;
        }

        @Override // g3.f
        public void b(Object obj) {
            this.f4228a = obj;
        }
    }

    public c(Map<String, Object> map, boolean z5) {
        this.f4225a = map;
        this.f4227c = z5;
    }

    @Override // g3.e
    public <T> T c(String str) {
        return (T) this.f4225a.get(str);
    }

    @Override // g3.b, g3.e
    public boolean e() {
        return this.f4227c;
    }

    @Override // g3.e
    public String i() {
        return (String) this.f4225a.get("method");
    }

    @Override // g3.e
    public boolean j(String str) {
        return this.f4225a.containsKey(str);
    }

    @Override // g3.a
    public f o() {
        return this.f4226b;
    }

    public Map<String, Object> p() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", this.f4226b.f4229b);
        hashMap2.put("message", this.f4226b.f4230c);
        hashMap2.put(cs.a.DATA, this.f4226b.f4231d);
        hashMap.put("error", hashMap2);
        return hashMap;
    }

    public Map<String, Object> q() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.f4226b.f4228a);
        return hashMap;
    }

    public void r(k.d dVar) {
        a aVar = this.f4226b;
        dVar.a(aVar.f4229b, aVar.f4230c, aVar.f4231d);
    }

    public void s(List<Map<String, Object>> list) {
        if (e()) {
            return;
        }
        list.add(p());
    }

    public void t(List<Map<String, Object>> list) {
        if (e()) {
            return;
        }
        list.add(q());
    }
}
