package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.i;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
public class l extends Activity implements androidx.lifecycle.i, i.a {

    /* renamed from: a, reason: collision with root package name */
    private f.f<Class<Object>, Object> f354a = new f.f<>();

    /* renamed from: b, reason: collision with root package name */
    private androidx.lifecycle.j f355b = new androidx.lifecycle.j(this);

    @Override // androidx.core.view.i.a
    public boolean c(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.i.d(decorView, keyEvent)) {
            return androidx.core.view.i.e(this, decorView, this, keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        View decorView = getWindow().getDecorView();
        if (decorView == null || !androidx.core.view.i.d(decorView, keyEvent)) {
            return super.dispatchKeyShortcutEvent(keyEvent);
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.s.f(this);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        this.f355b.j(d.c.CREATED);
        super.onSaveInstanceState(bundle);
    }
}
