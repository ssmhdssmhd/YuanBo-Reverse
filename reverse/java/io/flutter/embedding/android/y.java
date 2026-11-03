package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.e0;
import x3.d;

/* loaded from: classes.dex */
public class y implements e0.d {

    /* renamed from: a, reason: collision with root package name */
    private final x3.d f5978a;

    /* renamed from: b, reason: collision with root package name */
    private final e0.b f5979b = new e0.b();

    public y(x3.d dVar) {
        this.f5978a = dVar;
    }

    @Override // io.flutter.embedding.android.e0.d
    public void a(KeyEvent keyEvent, final e0.d.a aVar) {
        int action = keyEvent.getAction();
        if (action == 0 || action == 1) {
            this.f5978a.e(new d.b(keyEvent, this.f5979b.a(keyEvent.getUnicodeChar())), action != 0, new d.a() { // from class: io.flutter.embedding.android.x
                @Override // x3.d.a
                public final void a(boolean z5) {
                    e0.d.a.this.a(z5);
                }
            });
        } else {
            aVar.a(false);
        }
    }
}
