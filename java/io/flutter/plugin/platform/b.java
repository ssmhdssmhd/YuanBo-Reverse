package io.flutter.plugin.platform;

import android.content.Context;
import android.view.MotionEvent;
import io.flutter.embedding.android.m;

/* loaded from: classes.dex */
public class b extends io.flutter.embedding.android.m {

    /* renamed from: g, reason: collision with root package name */
    private a f6131g;

    public b(Context context, int i6, int i7, a aVar) {
        super(context, i6, i7, m.b.overlay);
        this.f6131g = aVar;
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f6131g;
        if (aVar == null || !aVar.a(motionEvent, true)) {
            return super.onHoverEvent(motionEvent);
        }
        return true;
    }
}
