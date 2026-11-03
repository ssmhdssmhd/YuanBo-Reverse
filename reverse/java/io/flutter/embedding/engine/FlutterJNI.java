package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.Size;
import android.view.Surface;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.platform.u;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.h;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import y3.q;

/* loaded from: classes.dex */
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static b asyncWaitForVsyncDelegate = null;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static String observatoryUri = null;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private a accessibilityDelegate;
    private n3.a deferredComponentManager;
    private z3.d localizationPlugin;
    private Long nativeShellHolderId;
    private m3.f platformMessageHandler;
    private u platformViewsController;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();
    private final Set<a.b> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<w3.b> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private final Looper mainLooper = Looper.getMainLooper();

    public interface a {
        void b(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr);

        void c(ByteBuffer byteBuffer, String[] strArr);
    }

    public interface b {
        void a(long j6);
    }

    public static class c {
        public FlutterJNI a() {
            return new FlutterJNI();
        }
    }

    private static void asyncWaitForVsync(long j6) {
        b bVar = asyncWaitForVsyncDelegate;
        if (bVar == null) {
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
        bVar.a(j6);
    }

    public static Bitmap decodeImage(ByteBuffer byteBuffer, final long j6) {
        ImageDecoder.Source createSource;
        Bitmap decodeBitmap;
        if (Build.VERSION.SDK_INT >= 28) {
            createSource = ImageDecoder.createSource(byteBuffer);
            try {
                decodeBitmap = ImageDecoder.decodeBitmap(createSource, new ImageDecoder.OnHeaderDecodedListener() { // from class: io.flutter.embedding.engine.i
                    @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        FlutterJNI.lambda$decodeImage$0(j6, imageDecoder, imageInfo, source);
                    }
                });
                return decodeBitmap;
            } catch (IOException e6) {
                k3.b.c(TAG, "Failed to decode image", e6);
            }
        }
        return null;
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    public static String getObservatoryUri() {
        return observatoryUri;
    }

    private void handlePlatformMessageResponse(int i6, ByteBuffer byteBuffer) {
        m3.f fVar = this.platformMessageHandler;
        if (fVar != null) {
            fVar.g(i6, byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$0(long j6, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        ColorSpace.Named named;
        ColorSpace colorSpace;
        Size size;
        named = ColorSpace.Named.SRGB;
        colorSpace = ColorSpace.get(named);
        imageDecoder.setTargetColorSpace(colorSpace);
        imageDecoder.setAllocator(1);
        size = imageInfo.getSize();
        nativeImageHeaderCallback(j6, size.getWidth(), size.getHeight());
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j6);

    private native void nativeDeferredComponentInstallFailure(int i6, String str, boolean z5);

    private native void nativeDestroy(long j6);

    private native void nativeDispatchEmptyPlatformMessage(long j6, String str, int i6);

    private native void nativeDispatchPlatformMessage(long j6, String str, ByteBuffer byteBuffer, int i6, int i7);

    private native void nativeDispatchPointerDataPacket(long j6, ByteBuffer byteBuffer, int i6);

    private native void nativeDispatchSemanticsAction(long j6, int i6, int i7, ByteBuffer byteBuffer, int i8);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i6);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i6);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i6);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i6);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i6);

    private native Bitmap nativeGetBitmap(long j6);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j6, int i6, int i7);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j6);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j6, int i6);

    private native void nativeInvokePlatformMessageResponseCallback(long j6, int i6, ByteBuffer byteBuffer, int i7);

    private native void nativeLoadDartDeferredLibrary(long j6, int i6, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j6);

    private native void nativeMarkTextureFrameAvailable(long j6, long j7);

    private native void nativeNotifyLowMemoryWarning(long j6);

    private native void nativeOnVsync(long j6, long j7, long j8);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterTexture(long j6, long j7, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j6, String str, String str2, String str3, AssetManager assetManager, List<String> list);

    private native void nativeSetAccessibilityFeatures(long j6, int i6);

    private native void nativeSetSemanticsEnabled(long j6, boolean z5);

    private native void nativeSetViewportMetrics(long j6, float f6, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int[] iArr, int[] iArr2, int[] iArr3);

    private native FlutterJNI nativeSpawn(long j6, String str, String str2, String str3, List<String> list);

    private native void nativeSurfaceChanged(long j6, int i6, int i7);

    private native void nativeSurfaceCreated(long j6, Surface surface);

    private native void nativeSurfaceDestroyed(long j6);

    private native void nativeSurfaceWindowChanged(long j6, Surface surface);

    private native void nativeUnregisterTexture(long j6, long j7);

    private native void nativeUpdateJavaAssetManager(long j6, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f6);

    private void onPreEngineRestart() {
        Iterator<a.b> it = this.engineLifecycleListeners.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar != null) {
            aVar.c(byteBuffer, strArr);
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar != null) {
            aVar.b(byteBuffer, strArr, byteBufferArr);
        }
    }

    public void addEngineLifecycleListener(a.b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(bVar);
    }

    public void addIsDisplayingFlutterUiListener(w3.b bVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(bVar);
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j6) {
        nativeCleanupMessageData(j6);
    }

    public String[] computePlatformResolvedLocale(String[] strArr) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i6 = 0; i6 < strArr.length; i6 += 3) {
            String str = strArr[i6 + 0];
            String str2 = strArr[i6 + 1];
            String str3 = strArr[i6 + 2];
            Locale.Builder builder = new Locale.Builder();
            if (!str.isEmpty()) {
                builder.setLanguage(str);
            }
            if (!str2.isEmpty()) {
                builder.setRegion(str2);
            }
            if (!str3.isEmpty()) {
                builder.setScript(str3);
            }
            arrayList.add(builder.build());
        }
        Locale c6 = this.localizationPlugin.c(arrayList);
        return c6 == null ? new String[0] : new String[]{c6.getLanguage(), c6.getCountry(), c6.getScript()};
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        u uVar = this.platformViewsController;
        if (uVar != null) {
            return uVar.G();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void deferredComponentInstallFailure(int i6, String str, boolean z5) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i6, str, z5);
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        u uVar = this.platformViewsController;
        if (uVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        uVar.I();
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i6) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i6);
            return;
        }
        k3.b.g(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i6);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i6, int i7) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i6, i7);
            return;
        }
        k3.b.g(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i7);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i6);
    }

    public void dispatchSemanticsAction(int i6, int i7, ByteBuffer byteBuffer, int i8) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i6, i7, byteBuffer, i8);
    }

    public void dispatchSemanticsAction(int i6, h.g gVar) {
        dispatchSemanticsAction(i6, gVar, null);
    }

    public void dispatchSemanticsAction(int i6, h.g gVar, Object obj) {
        ByteBuffer byteBuffer;
        int i7;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = q.f11112a.a(obj);
            i7 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i7 = 0;
        }
        dispatchSemanticsAction(i6, gVar.f6289a, byteBuffer, i7);
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i6, long j6) {
        m3.f fVar = this.platformMessageHandler;
        if (fVar != null) {
            fVar.h(str, byteBuffer, i6, j6);
        } else {
            nativeCleanupMessageData(j6);
        }
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j6) {
        if (initCalled) {
            k3.b.g(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j6);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i6) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i6);
            } else {
                k3.b.g(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i6);
            }
        } finally {
            this.shellHolderLock.readLock().unlock();
        }
    }

    public void invokePlatformMessageResponseCallback(int i6, ByteBuffer byteBuffer, int i7) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i6, byteBuffer, i7);
            } else {
                k3.b.g(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i6);
            }
        } finally {
            this.shellHolderLock.readLock().unlock();
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i6) {
        return nativeFlutterTextUtilsIsEmoji(i6);
    }

    public boolean isCodePointEmojiModifier(int i6) {
        return nativeFlutterTextUtilsIsEmojiModifier(i6);
    }

    public boolean isCodePointEmojiModifierBase(int i6) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i6);
    }

    public boolean isCodePointRegionalIndicator(int i6) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i6);
    }

    public boolean isCodePointVariantSelector(int i6) {
        return nativeFlutterTextUtilsIsVariationSelector(i6);
    }

    public void loadDartDeferredLibrary(int i6, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i6, strArr);
    }

    public void loadLibrary() {
        if (loadLibraryCalled) {
            k3.b.g(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        System.loadLibrary("flutter");
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j6);
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        u uVar = this.platformViewsController;
        if (uVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
        }
        uVar.W();
    }

    public void onDisplayOverlaySurface(int i6, int i7, int i8, int i9, int i10) {
        ensureRunningOnMainThread();
        u uVar = this.platformViewsController;
        if (uVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        uVar.Y(i6, i7, i8, i9, i10);
    }

    public void onDisplayPlatformView(int i6, int i7, int i8, int i9, int i10, int i11, int i12, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        u uVar = this.platformViewsController;
        if (uVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        uVar.Z(i6, i7, i8, i9, i10, i11, i12, flutterMutatorsStack);
    }

    public void onEndFrame() {
        ensureRunningOnMainThread();
        u uVar = this.platformViewsController;
        if (uVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
        }
        uVar.a0();
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        Iterator<w3.b> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    void onRenderingStopped() {
        ensureRunningOnMainThread();
        Iterator<w3.b> it = this.flutterUiDisplayListeners.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public void onSurfaceChanged(int i6, int i7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i6, i7);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j6, long j7, long j8) {
        nativeOnVsync(j6, j7, j8);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            k3.b.g(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerTexture(long j6, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j6, new WeakReference<>(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(a.b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(bVar);
    }

    public void removeIsDisplayingFlutterUiListener(w3.b bVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(bVar);
    }

    public void requestDartDeferredLibrary(int i6) {
        k3.b.b(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list);
    }

    public void setAccessibilityDelegate(a aVar) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = aVar;
    }

    public void setAccessibilityFeatures(int i6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i6);
    }

    public void setAsyncWaitForVsyncDelegate(b bVar) {
        asyncWaitForVsyncDelegate = bVar;
    }

    public void setDeferredComponentManager(n3.a aVar) {
        ensureRunningOnMainThread();
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void setLocalizationPlugin(z3.d dVar) {
        ensureRunningOnMainThread();
        this.localizationPlugin = dVar;
    }

    public void setPlatformMessageHandler(m3.f fVar) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = fVar;
    }

    public void setPlatformViewsController(u uVar) {
        ensureRunningOnMainThread();
        this.platformViewsController = uVar;
    }

    public void setRefreshRateFPS(float f6) {
        refreshRateFPS = f6;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z5);
    }

    public void setViewportMetrics(float f6, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int[] iArr, int[] iArr2, int[] iArr3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f6, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, i20, iArr, iArr2, iArr3);
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list);
        Long l6 = nativeSpawn.nativeShellHolderId;
        d4.d.a((l6 == null || l6.longValue() == 0) ? false : true, "Failed to spawn new JNI connected shell from existing shell.");
        return nativeSpawn;
    }

    public void unregisterTexture(long j6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j6);
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }
}
