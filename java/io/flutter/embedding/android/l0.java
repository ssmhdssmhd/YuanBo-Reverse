package io.flutter.embedding.android;

import android.app.Activity;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import androidx.window.layout.WindowLayoutInfo;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class l0 {

    /* renamed from: a, reason: collision with root package name */
    final WindowInfoTrackerCallbackAdapter f5915a;

    public l0(WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter) {
        this.f5915a = windowInfoTrackerCallbackAdapter;
    }

    public void a(Activity activity, Executor executor, androidx.core.util.a<WindowLayoutInfo> aVar) {
        this.f5915a.addWindowLayoutInfoListener(activity, executor, aVar);
    }

    public void b(androidx.core.util.a<WindowLayoutInfo> aVar) {
        this.f5915a.removeWindowLayoutInfoListener(aVar);
    }
}
