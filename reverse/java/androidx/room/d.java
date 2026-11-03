package androidx.room;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    final Set<LiveData> f1311a = Collections.newSetFromMap(new IdentityHashMap());

    /* renamed from: b, reason: collision with root package name */
    private final h f1312b;

    d(h hVar) {
        this.f1312b = hVar;
    }

    <T> LiveData<T> a(String[] strArr, boolean z5, Callable<T> callable) {
        return new j(this.f1312b, this, z5, callable, strArr);
    }

    void b(LiveData liveData) {
        this.f1311a.add(liveData);
    }

    void c(LiveData liveData) {
        this.f1311a.remove(liveData);
    }
}
