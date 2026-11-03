package androidx.window.layout;

import android.app.Activity;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public interface WindowBackend {
    void registerLayoutChangeCallback(Activity activity, Executor executor, androidx.core.util.a<WindowLayoutInfo> aVar);

    void unregisterLayoutChangeCallback(androidx.core.util.a<WindowLayoutInfo> aVar);
}
