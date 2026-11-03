package p2;

import com.google.errorprone.annotations.DoNotMock;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@DoNotMock("Use the methods in Futures (like immediateFuture) or SettableFuture")
/* loaded from: classes.dex */
public interface a<V> extends Future<V> {
    void a(Runnable runnable, Executor executor);
}
