package m0;

import i0.o3;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import m0.m;

/* loaded from: classes.dex */
public interface g0 {

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f7789a;

        /* renamed from: b, reason: collision with root package name */
        private final String f7790b;

        /* renamed from: c, reason: collision with root package name */
        private final int f7791c;

        public a(byte[] bArr, String str, int i6) {
            this.f7789a = bArr;
            this.f7790b = str;
            this.f7791c = i6;
        }

        public byte[] a() {
            return this.f7789a;
        }

        public String b() {
            return this.f7790b;
        }
    }

    public interface b {
        void a(g0 g0Var, byte[] bArr, int i6, int i7, byte[] bArr2);
    }

    public interface c {
        g0 a(UUID uuid);
    }

    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f7792a;

        /* renamed from: b, reason: collision with root package name */
        private final String f7793b;

        public d(byte[] bArr, String str) {
            this.f7792a = bArr;
            this.f7793b = str;
        }

        public byte[] a() {
            return this.f7792a;
        }

        public String b() {
            return this.f7793b;
        }
    }

    void a();

    boolean b(byte[] bArr, String str);

    void c(byte[] bArr, byte[] bArr2);

    Map<String, String> d(byte[] bArr);

    void e(byte[] bArr);

    byte[] f(byte[] bArr, byte[] bArr2);

    void g(byte[] bArr, o3 o3Var);

    d h();

    void i(byte[] bArr);

    void j(b bVar);

    a k(byte[] bArr, List<m.b> list, int i6, HashMap<String, String> hashMap);

    int l();

    l0.b m(byte[] bArr);

    byte[] n();
}
