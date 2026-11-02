package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.util.Map;

/* loaded from: classes.dex */
public final class SavedStateRegistry {

    /* renamed from: b, reason: collision with root package name */
    private Bundle f1430b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1431c;

    /* renamed from: a, reason: collision with root package name */
    private d.b<String, b> f1429a = new d.b<>();

    /* renamed from: d, reason: collision with root package name */
    boolean f1432d = true;

    public interface a {
        void a(androidx.savedstate.b bVar);
    }

    public interface b {
        Bundle a();
    }

    SavedStateRegistry() {
    }

    public Bundle a(String str) {
        if (!this.f1431c) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.f1430b;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        this.f1430b.remove(str);
        if (this.f1430b.isEmpty()) {
            this.f1430b = null;
        }
        return bundle2;
    }

    void b(d dVar, Bundle bundle) {
        if (this.f1431c) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        if (bundle != null) {
            this.f1430b = bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key");
        }
        dVar.a(new g() { // from class: androidx.savedstate.SavedStateRegistry.1
            @Override // androidx.lifecycle.g
            public void d(i iVar, d.b bVar) {
                SavedStateRegistry savedStateRegistry;
                boolean z5;
                if (bVar == d.b.ON_START) {
                    savedStateRegistry = SavedStateRegistry.this;
                    z5 = true;
                } else {
                    if (bVar != d.b.ON_STOP) {
                        return;
                    }
                    savedStateRegistry = SavedStateRegistry.this;
                    z5 = false;
                }
                savedStateRegistry.f1432d = z5;
            }
        });
        this.f1431c = true;
    }

    void c(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.f1430b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        d.b<String, b>.d d6 = this.f1429a.d();
        while (d6.hasNext()) {
            Map.Entry next = d6.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
