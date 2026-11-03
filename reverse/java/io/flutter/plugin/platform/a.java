package io.flutter.plugin.platform;

import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private io.flutter.view.h f6130a;

    a() {
    }

    public boolean a(MotionEvent motionEvent, boolean z5) {
        io.flutter.view.h hVar = this.f6130a;
        if (hVar == null) {
            return false;
        }
        return hVar.K(motionEvent, z5);
    }

    public boolean b(View view, View view2, AccessibilityEvent accessibilityEvent) {
        io.flutter.view.h hVar = this.f6130a;
        if (hVar == null) {
            return false;
        }
        return hVar.x(view, view2, accessibilityEvent);
    }

    void c(io.flutter.view.h hVar) {
        this.f6130a = hVar;
    }
}
