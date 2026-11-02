package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class k {
    public static boolean a(MotionEvent motionEvent, int i6) {
        return (motionEvent.getSource() & i6) == i6;
    }
}
