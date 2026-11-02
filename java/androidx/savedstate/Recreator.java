package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.d;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.savedstate.SavedStateRegistry;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
final class Recreator implements g {

    /* renamed from: a, reason: collision with root package name */
    private final b f1428a;

    Recreator(b bVar) {
        this.f1428a = bVar;
    }

    private void e(String str) {
        try {
            Class<? extends U> asSubclass = Class.forName(str, false, Recreator.class.getClassLoader()).asSubclass(SavedStateRegistry.a.class);
            try {
                Constructor declaredConstructor = asSubclass.getDeclaredConstructor(new Class[0]);
                declaredConstructor.setAccessible(true);
                try {
                    ((SavedStateRegistry.a) declaredConstructor.newInstance(new Object[0])).a(this.f1428a);
                } catch (Exception e6) {
                    throw new RuntimeException("Failed to instantiate " + str, e6);
                }
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException("Class" + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e7);
            }
        } catch (ClassNotFoundException e8) {
            throw new RuntimeException("Class " + str + " wasn't found", e8);
        }
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, d.b bVar) {
        if (bVar != d.b.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        iVar.a().c(this);
        Bundle a6 = this.f1428a.i().a("androidx.savedstate.Restarter");
        if (a6 == null) {
            return;
        }
        ArrayList<String> stringArrayList = a6.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        Iterator<String> it = stringArrayList.iterator();
        while (it.hasNext()) {
            e(it.next());
        }
    }
}
