package h3;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import y3.q;

/* loaded from: classes.dex */
public class a {

    /* renamed from: h3.a$a, reason: collision with other inner class name */
    public static class C0084a {

        /* renamed from: a, reason: collision with root package name */
        private Boolean f5232a;

        static C0084a a(Map<String, Object> map) {
            C0084a c0084a = new C0084a();
            c0084a.f5232a = (Boolean) map.get("enabled");
            return c0084a;
        }

        public void b(Boolean bool) {
            this.f5232a = bool;
        }

        Map<String, Object> c() {
            HashMap hashMap = new HashMap();
            hashMap.put("enabled", this.f5232a);
            return hashMap;
        }
    }

    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Boolean f5233a;

        static b a(Map<String, Object> map) {
            b bVar = new b();
            bVar.f5233a = (Boolean) map.get("enable");
            return bVar;
        }

        public Boolean b() {
            return this.f5233a;
        }

        Map<String, Object> c() {
            HashMap hashMap = new HashMap();
            hashMap.put("enable", this.f5233a);
            return hashMap;
        }
    }

    public interface c {
        void e(b bVar);

        C0084a isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d extends q {

        /* renamed from: d, reason: collision with root package name */
        public static final d f5234d = new d();

        private d() {
        }

        @Override // y3.q
        protected Object g(byte b6, ByteBuffer byteBuffer) {
            return b6 != Byte.MIN_VALUE ? b6 != -127 ? super.g(b6, byteBuffer) : b.a((Map) f(byteBuffer)) : C0084a.a((Map) f(byteBuffer));
        }

        @Override // y3.q
        protected void p(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            Map<String, Object> c6;
            if (obj instanceof C0084a) {
                byteArrayOutputStream.write(128);
                c6 = ((C0084a) obj).c();
            } else if (!(obj instanceof b)) {
                super.p(byteArrayOutputStream, obj);
                return;
            } else {
                byteArrayOutputStream.write(129);
                c6 = ((b) obj).c();
            }
            p(byteArrayOutputStream, c6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, Object> b(Throwable th) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th.toString());
        hashMap.put("code", th.getClass().getSimpleName());
        hashMap.put("details", null);
        return hashMap;
    }
}
