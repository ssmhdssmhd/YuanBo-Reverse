package h2;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class q implements o {

    /* renamed from: c, reason: collision with root package name */
    public static final q f5208c = new q(Collections.emptyMap());

    /* renamed from: a, reason: collision with root package name */
    private int f5209a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, byte[]> f5210b;

    public q() {
        this(Collections.emptyMap());
    }

    public q(Map<String, byte[]> map) {
        this.f5210b = Collections.unmodifiableMap(map);
    }

    private static void c(HashMap<String, byte[]> hashMap, Map<String, Object> map) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), g(entry.getValue()));
        }
    }

    private static Map<String, byte[]> d(Map<String, byte[]> map, p pVar) {
        HashMap hashMap = new HashMap(map);
        i(hashMap, pVar.c());
        c(hashMap, pVar.b());
        return hashMap;
    }

    private static byte[] g(Object obj) {
        if (obj instanceof Long) {
            return ByteBuffer.allocate(8).putLong(((Long) obj).longValue()).array();
        }
        if (obj instanceof String) {
            return ((String) obj).getBytes(l2.d.f7489c);
        }
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        throw new IllegalArgumentException();
    }

    private static boolean h(Map<String, byte[]> map, Map<String, byte[]> map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<String, byte[]> entry : map.entrySet()) {
            if (!Arrays.equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    private static void i(HashMap<String, byte[]> hashMap, List<String> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            hashMap.remove(list.get(i6));
        }
    }

    @Override // h2.o
    public final String a(String str, String str2) {
        byte[] bArr = this.f5210b.get(str);
        return bArr != null ? new String(bArr, l2.d.f7489c) : str2;
    }

    @Override // h2.o
    public final long b(String str, long j6) {
        byte[] bArr = this.f5210b.get(str);
        return bArr != null ? ByteBuffer.wrap(bArr).getLong() : j6;
    }

    public q e(p pVar) {
        Map<String, byte[]> d6 = d(this.f5210b, pVar);
        return h(this.f5210b, d6) ? this : new q(d6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || q.class != obj.getClass()) {
            return false;
        }
        return h(this.f5210b, ((q) obj).f5210b);
    }

    public Set<Map.Entry<String, byte[]>> f() {
        return this.f5210b.entrySet();
    }

    public int hashCode() {
        if (this.f5209a == 0) {
            int i6 = 0;
            for (Map.Entry<String, byte[]> entry : this.f5210b.entrySet()) {
                i6 += Arrays.hashCode(entry.getValue()) ^ entry.getKey().hashCode();
            }
            this.f5209a = i6;
        }
        return this.f5209a;
    }
}
