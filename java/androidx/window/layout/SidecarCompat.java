package androidx.window.layout;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.ExtensionInterfaceCompat;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import e4.q;
import f4.l;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class SidecarCompat implements ExtensionInterfaceCompat {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "SidecarCompat";
    private final Map<Activity, ComponentCallbacks> componentCallbackMap;
    private ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback;
    private final SidecarInterface sidecar;
    private final SidecarAdapter sidecarAdapter;
    private final Map<IBinder, Activity> windowListenerRegisteredContexts;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final IBinder getActivityWindowToken$window_release(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final Version getSidecarVersion() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.Companion.parse(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    private static final class DistinctElementCallback implements ExtensionInterfaceCompat.ExtensionCallbackInterface {
        private final WeakHashMap<Activity, WindowLayoutInfo> activityWindowLayoutInfo;
        private final ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface;
        private final ReentrantLock lock;

        public DistinctElementCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface callbackInterface) {
            k.e(callbackInterface, "callbackInterface");
            this.callbackInterface = callbackInterface;
            this.lock = new ReentrantLock();
            this.activityWindowLayoutInfo = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.ExtensionInterfaceCompat.ExtensionCallbackInterface
        public void onWindowLayoutChanged(Activity activity, WindowLayoutInfo newLayout) {
            k.e(activity, "activity");
            k.e(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (k.a(newLayout, this.activityWindowLayoutInfo.get(activity))) {
                    return;
                }
                this.activityWindowLayoutInfo.put(activity, newLayout);
                reentrantLock.unlock();
                this.callbackInterface.onWindowLayoutChanged(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {
        private final SidecarInterface.SidecarCallback callbackInterface;
        private SidecarDeviceState lastDeviceState;
        private final ReentrantLock lock;
        private final WeakHashMap<IBinder, SidecarWindowLayoutInfo> mActivityWindowLayoutInfo;
        private final SidecarAdapter sidecarAdapter;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback callbackInterface) {
            k.e(sidecarAdapter, "sidecarAdapter");
            k.e(callbackInterface, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter;
            this.callbackInterface = callbackInterface;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap<>();
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            k.e(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.sidecarAdapter.isEqualSidecarDeviceState(this.lastDeviceState, newDeviceState)) {
                    return;
                }
                this.lastDeviceState = newDeviceState;
                this.callbackInterface.onDeviceStateChanged(newDeviceState);
                q qVar = q.f3710a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            k.e(token, "token");
            k.e(newLayout, "newLayout");
            synchronized (this.lock) {
                if (this.sidecarAdapter.isEqualSidecarWindowLayoutInfo(this.mActivityWindowLayoutInfo.get(token), newLayout)) {
                    return;
                }
                this.mActivityWindowLayoutInfo.put(token, newLayout);
                this.callbackInterface.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    private static final class FirstAttachAdapter implements View.OnAttachStateChangeListener {
        private final WeakReference<Activity> activityWeakReference;
        private final SidecarCompat sidecarCompat;

        public FirstAttachAdapter(SidecarCompat sidecarCompat, Activity activity) {
            k.e(sidecarCompat, "sidecarCompat");
            k.e(activity, "activity");
            this.sidecarCompat = sidecarCompat;
            this.activityWeakReference = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            k.e(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.activityWeakReference.get();
            IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
            if (activity == null || activityWindowToken$window_release == null) {
                return;
            }
            this.sidecarCompat.register(activityWindowToken$window_release, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            k.e(view, "view");
        }
    }

    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        final /* synthetic */ SidecarCompat this$0;

        public TranslatingCallback(SidecarCompat this$0) {
            k.e(this$0, "this$0");
            this.this$0 = this$0;
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecar;
            k.e(newDeviceState, "newDeviceState");
            Collection<Activity> values = this.this$0.windowListenerRegisteredContexts.values();
            SidecarCompat sidecarCompat = this.this$0;
            for (Activity activity : values) {
                IBinder activityWindowToken$window_release = SidecarCompat.Companion.getActivityWindowToken$window_release(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (activityWindowToken$window_release != null && (sidecar = sidecarCompat.getSidecar()) != null) {
                    sidecarWindowLayoutInfo = sidecar.getWindowLayoutInfo(activityWindowToken$window_release);
                }
                ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = sidecarCompat.extensionCallback;
                if (extensionCallbackInterface != null) {
                    extensionCallbackInterface.onWindowLayoutChanged(activity, sidecarCompat.sidecarAdapter.translate(sidecarWindowLayoutInfo, newDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            k.e(windowToken, "windowToken");
            k.e(newLayout, "newLayout");
            Activity activity = (Activity) this.this$0.windowListenerRegisteredContexts.get(windowToken);
            if (activity == null) {
                Log.w(SidecarCompat.TAG, "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = this.this$0.sidecarAdapter;
            SidecarInterface sidecar = this.this$0.getSidecar();
            SidecarDeviceState deviceState = sidecar == null ? null : sidecar.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            WindowLayoutInfo translate = sidecarAdapter.translate(newLayout, deviceState);
            ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.this$0.extensionCallback;
            if (extensionCallbackInterface == null) {
                return;
            }
            extensionCallbackInterface.onWindowLayoutChanged(activity, translate);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(SidecarProvider.getSidecarImpl(context.getApplicationContext()), new SidecarAdapter());
        k.e(context, "context");
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        k.e(sidecarAdapter, "sidecarAdapter");
        this.sidecar = sidecarInterface;
        this.sidecarAdapter = sidecarAdapter;
        this.windowListenerRegisteredContexts = new LinkedHashMap();
        this.componentCallbackMap = new LinkedHashMap();
    }

    private final void registerConfigurationChangeListener(final Activity activity) {
        if (this.componentCallbackMap.get(activity) == null) {
            ComponentCallbacks componentCallbacks = new ComponentCallbacks() { // from class: androidx.window.layout.SidecarCompat$registerConfigurationChangeListener$configChangeObserver$1
                @Override // android.content.ComponentCallbacks
                public void onConfigurationChanged(Configuration newConfig) {
                    k.e(newConfig, "newConfig");
                    ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = SidecarCompat.this.extensionCallback;
                    if (extensionCallbackInterface == null) {
                        return;
                    }
                    Activity activity2 = activity;
                    extensionCallbackInterface.onWindowLayoutChanged(activity2, SidecarCompat.this.getWindowLayoutInfo(activity2));
                }

                @Override // android.content.ComponentCallbacks
                public void onLowMemory() {
                }
            };
            this.componentCallbackMap.put(activity, componentCallbacks);
            activity.registerComponentCallbacks(componentCallbacks);
        }
    }

    private final void unregisterComponentCallback(Activity activity) {
        activity.unregisterComponentCallbacks(this.componentCallbackMap.get(activity));
        this.componentCallbackMap.remove(activity);
    }

    public final SidecarInterface getSidecar() {
        return this.sidecar;
    }

    public final WindowLayoutInfo getWindowLayoutInfo(Activity activity) {
        k.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return new WindowLayoutInfo(l.f());
        }
        SidecarInterface sidecarInterface = this.sidecar;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(activityWindowToken$window_release);
        SidecarAdapter sidecarAdapter = this.sidecarAdapter;
        SidecarInterface sidecarInterface2 = this.sidecar;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.translate(windowLayoutInfo, deviceState);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerAdded(Activity activity) {
        k.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release != null) {
            register(activityWindowToken$window_release, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new FirstAttachAdapter(this, activity));
        }
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void onWindowLayoutChangeListenerRemoved(Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(activity, "activity");
        IBinder activityWindowToken$window_release = Companion.getActivityWindowToken$window_release(activity);
        if (activityWindowToken$window_release == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(activityWindowToken$window_release);
        }
        unregisterComponentCallback(activity);
        boolean z5 = this.windowListenerRegisteredContexts.size() == 1;
        this.windowListenerRegisteredContexts.remove(activityWindowToken$window_release);
        if (!z5 || (sidecarInterface = this.sidecar) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final void register(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(windowToken, "windowToken");
        k.e(activity, "activity");
        this.windowListenerRegisteredContexts.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.sidecar;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.windowListenerRegisteredContexts.size() == 1 && (sidecarInterface = this.sidecar) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallbackInterface = this.extensionCallback;
        if (extensionCallbackInterface != null) {
            extensionCallbackInterface.onWindowLayoutChanged(activity, getWindowLayoutInfo(activity));
        }
        registerConfigurationChangeListener(activity);
    }

    @Override // androidx.window.layout.ExtensionInterfaceCompat
    public void setExtensionCallback(ExtensionInterfaceCompat.ExtensionCallbackInterface extensionCallback) {
        k.e(extensionCallback, "extensionCallback");
        this.extensionCallback = new DistinctElementCallback(extensionCallback);
        SidecarInterface sidecarInterface = this.sidecar;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.sidecarAdapter, new TranslatingCallback(this)));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008c A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b2 A[Catch: all -> 0x0196, TRY_LEAVE, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0166 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a6 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0172 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0080 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x017e A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0059 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x018a A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0020 A[Catch: all -> 0x0196, TryCatch #1 {all -> 0x0196, blocks: (B:3:0x0001, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008c, B:36:0x00aa, B:38:0x00b2, B:41:0x00b8, B:42:0x00ee, B:44:0x010a, B:49:0x010d, B:51:0x013c, B:53:0x0146, B:54:0x014d, B:55:0x014e, B:56:0x0155, B:58:0x00bb, B:60:0x00e6, B:62:0x0156, B:63:0x015d, B:64:0x015e, B:65:0x0165, B:66:0x0166, B:67:0x0171, B:68:0x00a6, B:69:0x0092, B:72:0x0099, B:73:0x0172, B:74:0x017d, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x017e, B:81:0x0189, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x018a, B:90:0x0195, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0001, inners: #0, #2 }] */
    @Override // androidx.window.layout.ExtensionInterfaceCompat
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean validateExtensionInterface() {
        /*
            Method dump skipped, instructions count: 407
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.validateExtensionInterface():boolean");
    }
}
