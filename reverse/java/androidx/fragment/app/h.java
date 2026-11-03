package androidx.fragment.app;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: b, reason: collision with root package name */
    static final f f644b = new f();

    /* renamed from: a, reason: collision with root package name */
    private f f645a = null;

    public interface a {
        void onBackStackChanged();
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public f b() {
        if (this.f645a == null) {
            this.f645a = f644b;
        }
        return this.f645a;
    }

    public abstract List<Fragment> c();

    public abstract boolean d();

    public void e(f fVar) {
        this.f645a = fVar;
    }
}
