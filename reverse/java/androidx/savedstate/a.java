package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private final b f1434a;

    /* renamed from: b, reason: collision with root package name */
    private final SavedStateRegistry f1435b = new SavedStateRegistry();

    private a(b bVar) {
        this.f1434a = bVar;
    }

    public static a a(b bVar) {
        return new a(bVar);
    }

    public SavedStateRegistry b() {
        return this.f1435b;
    }

    public void c(Bundle bundle) {
        d a6 = this.f1434a.a();
        if (a6.b() != d.c.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        a6.a(new Recreator(this.f1434a));
        this.f1435b.b(a6, bundle);
    }

    public void d(Bundle bundle) {
        this.f1435b.c(bundle);
    }
}
