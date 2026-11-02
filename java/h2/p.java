package h2;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f5206a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f5207b = new ArrayList();

    private p a(String str, Object obj) {
        this.f5206a.put((String) i2.a.e(str), i2.a.e(obj));
        this.f5207b.remove(str);
        return this;
    }

    public static p g(p pVar, long j6) {
        return pVar.e("exo_len", j6);
    }

    public static p h(p pVar, Uri uri) {
        return uri == null ? pVar.d("exo_redir") : pVar.f("exo_redir", uri.toString());
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap(this.f5206a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.f5207b));
    }

    public p d(String str) {
        this.f5207b.add(str);
        this.f5206a.remove(str);
        return this;
    }

    public p e(String str, long j6) {
        return a(str, Long.valueOf(j6));
    }

    public p f(String str, String str2) {
        return a(str, str2);
    }
}
