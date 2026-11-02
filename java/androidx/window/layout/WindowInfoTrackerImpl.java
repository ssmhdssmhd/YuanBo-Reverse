package androidx.window.layout;

import android.app.Activity;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class WindowInfoTrackerImpl implements WindowInfoTracker {
    private static final int BUFFER_CAPACITY = 10;
    public static final Companion Companion = new Companion(null);
    private final WindowBackend windowBackend;
    private final WindowMetricsCalculator windowMetricsCalculator;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public WindowInfoTrackerImpl(WindowMetricsCalculator windowMetricsCalculator, WindowBackend windowBackend) {
        k.e(windowMetricsCalculator, "windowMetricsCalculator");
        k.e(windowBackend, "windowBackend");
        this.windowMetricsCalculator = windowMetricsCalculator;
        this.windowBackend = windowBackend;
    }

    @Override // androidx.window.layout.WindowInfoTracker
    public z4.b<WindowLayoutInfo> windowLayoutInfo(Activity activity) {
        k.e(activity, "activity");
        return z4.d.a(new WindowInfoTrackerImpl$windowLayoutInfo$1(this, activity, null));
    }
}
