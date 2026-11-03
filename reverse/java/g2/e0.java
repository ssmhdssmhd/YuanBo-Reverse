package g2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, String> f4020a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f4021b;

    public synchronized void a(Map<String, String> map) {
        this.f4021b = null;
        this.f4020a.clear();
        this.f4020a.putAll(map);
    }

    public synchronized Map<String, String> b() {
        if (this.f4021b == null) {
            this.f4021b = Collections.unmodifiableMap(new HashMap(this.f4020a));
        }
        return this.f4021b;
    }
}
