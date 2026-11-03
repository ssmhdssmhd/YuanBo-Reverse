package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f900a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f901b = false;

    private static void b(Object obj) {
        if (obj instanceof Closeable) {
            try {
                ((Closeable) obj).close();
            } catch (IOException e6) {
                throw new RuntimeException(e6);
            }
        }
    }

    final void a() {
        this.f901b = true;
        Map<String, Object> map = this.f900a;
        if (map != null) {
            synchronized (map) {
                Iterator<Object> it = this.f900a.values().iterator();
                while (it.hasNext()) {
                    b(it.next());
                }
            }
        }
        c();
    }

    protected void c() {
    }
}
