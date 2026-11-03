package com.tendcloud.tenddata;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class bt {

    /* renamed from: g, reason: collision with root package name */
    private static volatile bt f2452g;

    /* renamed from: a, reason: collision with root package name */
    private ca f2453a;

    /* renamed from: b, reason: collision with root package name */
    private int f2454b;

    /* renamed from: c, reason: collision with root package name */
    private int f2455c;

    /* renamed from: d, reason: collision with root package name */
    private int f2456d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Integer, Integer> f2457e;

    /* renamed from: f, reason: collision with root package name */
    private List<WeakReference<Window>> f2458f;

    class a implements Window.Callback {
        private WeakReference<Window> window;
        private Window.Callback wrappedCallback;

        public a(Window window) {
            try {
                this.wrappedCallback = window.getCallback();
                this.window = new WeakReference<>(window);
                window.setCallback(this);
            } catch (Throwable unused) {
            }
        }

        @Override // android.view.Window.Callback
        public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.dispatchGenericMotionEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.dispatchKeyEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.dispatchKeyShortcutEvent(keyEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            try {
                Window window = this.window.get();
                if (window != null && bt.this.f2456d <= 5) {
                    bt.this.a(motionEvent, System.currentTimeMillis(), window);
                }
            } catch (Throwable unused) {
            }
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.dispatchTouchEvent(motionEvent);
        }

        @Override // android.view.Window.Callback
        public boolean dispatchTrackballEvent(MotionEvent motionEvent) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.dispatchTrackballEvent(motionEvent);
        }

        public Window.Callback getWrappedCallback() {
            return this.wrappedCallback;
        }

        @Override // android.view.Window.Callback
        public void onActionModeFinished(ActionMode actionMode) {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onActionModeFinished(actionMode);
            }
        }

        @Override // android.view.Window.Callback
        public void onActionModeStarted(ActionMode actionMode) {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onActionModeStarted(actionMode);
            }
        }

        @Override // android.view.Window.Callback
        public void onAttachedToWindow() {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onAttachedToWindow();
            }
        }

        @Override // android.view.Window.Callback
        public void onContentChanged() {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onContentChanged();
            }
        }

        @Override // android.view.Window.Callback
        public boolean onCreatePanelMenu(int i6, Menu menu) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.onCreatePanelMenu(i6, menu);
        }

        @Override // android.view.Window.Callback
        public View onCreatePanelView(int i6) {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                return callback.onCreatePanelView(i6);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public void onDetachedFromWindow() {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onDetachedFromWindow();
            }
        }

        @Override // android.view.Window.Callback
        public boolean onMenuItemSelected(int i6, MenuItem menuItem) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.onMenuItemSelected(i6, menuItem);
        }

        @Override // android.view.Window.Callback
        public boolean onMenuOpened(int i6, Menu menu) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.onMenuOpened(i6, menu);
        }

        @Override // android.view.Window.Callback
        public void onPanelClosed(int i6, Menu menu) {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onPanelClosed(i6, menu);
            }
        }

        @Override // android.view.Window.Callback
        public boolean onPreparePanel(int i6, View view, Menu menu) {
            Window.Callback callback = this.wrappedCallback;
            return callback != null && callback.onPreparePanel(i6, view, menu);
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested() {
            return this.wrappedCallback.onSearchRequested();
        }

        @Override // android.view.Window.Callback
        public boolean onSearchRequested(SearchEvent searchEvent) {
            boolean onSearchRequested;
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                onSearchRequested = callback.onSearchRequested(searchEvent);
                if (onSearchRequested) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.view.Window.Callback
        public void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onWindowAttributesChanged(layoutParams);
            }
        }

        @Override // android.view.Window.Callback
        public void onWindowFocusChanged(boolean z5) {
            Window.Callback callback = this.wrappedCallback;
            if (callback != null) {
                callback.onWindowFocusChanged(z5);
            }
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            Window.Callback callback2 = this.wrappedCallback;
            if (callback2 != null) {
                return callback2.onWindowStartingActionMode(callback);
            }
            return null;
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i6) {
            ActionMode onWindowStartingActionMode;
            Window.Callback callback2 = this.wrappedCallback;
            if (callback2 == null) {
                return null;
            }
            onWindowStartingActionMode = callback2.onWindowStartingActionMode(callback, i6);
            return onWindowStartingActionMode;
        }
    }

    static {
        try {
            z.a().register(b());
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private bt() {
        try {
            this.f2454b = 0;
            this.f2455c = 0;
            this.f2456d = 0;
            this.f2457e = new HashMap<>();
            ca caVar = new ca();
            this.f2453a = caVar;
            caVar.f2499a = "bio";
            caVar.f2500b = "touch";
            this.f2458f = new ArrayList();
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private View a(MotionEvent motionEvent, Window window) {
        return a((ViewGroup) window.getDecorView(), motionEvent.getRawX(), motionEvent.getRawY());
    }

    private View a(ViewGroup viewGroup, float f6, float f7) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (a(f6, f7, childAt)) {
                return childAt instanceof ViewGroup ? a((ViewGroup) childAt, f6, f7) : childAt;
            }
        }
        return viewGroup;
    }

    private void a(MotionEvent motionEvent, View view, long j6) {
        try {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 6 && actionMasked != 5) {
                int pointerCount = motionEvent.getPointerCount();
                for (int i6 = 0; i6 < pointerCount; i6++) {
                    a(motionEvent, view, j6, i6);
                }
                return;
            }
            a(motionEvent, view, j6, motionEvent.getActionIndex());
        } catch (Throwable unused) {
        }
    }

    private void a(MotionEvent motionEvent, View view, long j6, int i6) {
        try {
            if (this.f2453a == null) {
                return;
            }
            int pointerId = motionEvent.getPointerId(i6);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    this.f2456d++;
                    if (this.f2457e.get(Integer.valueOf(pointerId)) == null) {
                        HashMap<Integer, Integer> hashMap = this.f2457e;
                        Integer valueOf = Integer.valueOf(pointerId);
                        int i7 = this.f2455c;
                        this.f2455c = i7 + 1;
                        hashMap.put(valueOf, Integer.valueOf(i7));
                    }
                    int intValue = this.f2457e.get(Integer.valueOf(pointerId)).intValue() + this.f2454b;
                    if (this.f2453a.f2502d.length() < 5) {
                        this.f2453a.a(new cb(intValue, motionEvent, j6, i6, view, false), this.f2453a.f2502d);
                    } else {
                        a(this.f2453a);
                    }
                    this.f2457e.clear();
                    this.f2454b += this.f2455c;
                    this.f2455c = 0;
                    return;
                }
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return;
                    }
                    this.f2456d++;
                    if (this.f2457e.get(Integer.valueOf(pointerId)) == null) {
                        HashMap<Integer, Integer> hashMap2 = this.f2457e;
                        Integer valueOf2 = Integer.valueOf(pointerId);
                        int i8 = this.f2455c;
                        this.f2455c = i8 + 1;
                        hashMap2.put(valueOf2, Integer.valueOf(i8));
                    }
                    int intValue2 = this.f2457e.get(Integer.valueOf(pointerId)).intValue() + this.f2454b;
                    if (this.f2453a.f2502d.length() < 5) {
                        this.f2453a.a(new cb(intValue2, motionEvent, j6, i6, view, false), this.f2453a.f2502d);
                    } else {
                        a(this.f2453a);
                    }
                    this.f2457e.remove(Integer.valueOf(pointerId));
                    return;
                }
            }
            this.f2456d++;
            int i9 = this.f2455c + this.f2454b;
            HashMap<Integer, Integer> hashMap3 = this.f2457e;
            Integer valueOf3 = Integer.valueOf(pointerId);
            int i10 = this.f2455c;
            this.f2455c = i10 + 1;
            hashMap3.put(valueOf3, Integer.valueOf(i10));
            if (this.f2453a.f2502d.length() < 5) {
                this.f2453a.a(new cb(i9, motionEvent, j6, i6, view, false), this.f2453a.f2502d);
            } else {
                a(this.f2453a);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Window window) {
        Window window2;
        try {
            Iterator<WeakReference<Window>> it = this.f2458f.iterator();
            while (true) {
                if (!it.hasNext()) {
                    window2 = null;
                    break;
                }
                window2 = it.next().get();
                if (window2 != null && window.equals(window2)) {
                    break;
                }
            }
            if (window2 == null) {
                new a(window);
                this.f2458f.add(new WeakReference<>(window));
                return;
            }
            Window.Callback callback = window.getCallback();
            if (callback instanceof a) {
                return;
            }
            if (callback == null) {
                new a(window);
            } else {
                new a(window);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(final ca caVar) {
        try {
            y.execute(new Runnable() { // from class: com.tendcloud.tenddata.bt.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        bz bzVar = new bz();
                        ca caVar2 = caVar;
                        bzVar.f2493b = caVar2.f2499a;
                        bzVar.f2494c = caVar2.f2500b;
                        bzVar.f2495d = caVar2.a();
                        bzVar.f2492a = com.tendcloud.tenddata.a.ENV;
                        z.a().post(bzVar);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    private boolean a(float f6, float f7, View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.contains((int) f6, (int) f7);
    }

    public static bt b() {
        if (f2452g == null) {
            synchronized (bt.class) {
                if (f2452g == null) {
                    f2452g = new bt();
                }
            }
        }
        return f2452g;
    }

    public void a() {
        try {
            Iterator<WeakReference<Window>> it = this.f2458f.iterator();
            while (it.hasNext()) {
                Window window = it.next().get();
                if (window != null) {
                    Window.Callback callback = window.getCallback();
                    if (callback instanceof a) {
                        window.setCallback(((a) callback).getWrappedCallback());
                    }
                    it.remove();
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(MotionEvent motionEvent, long j6, Window window) {
        try {
            View a6 = a(motionEvent, window);
            h.iForInternal("Touch captured: " + motionEvent.getAction() + ", view " + a6);
            a(motionEvent, a6, j6);
        } catch (Throwable unused) {
        }
    }

    public void startCollectingData(Window window) {
        try {
            if (this.f2456d <= 5 && window != null) {
                a(window);
            }
        } catch (Throwable unused) {
        }
    }
}
