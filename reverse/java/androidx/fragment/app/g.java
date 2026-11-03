package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class g<E> extends d {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f639a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f640b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f641c;

    /* renamed from: d, reason: collision with root package name */
    private final int f642d;

    /* renamed from: e, reason: collision with root package name */
    final i f643e;

    g(Activity activity, Context context, Handler handler, int i6) {
        this.f643e = new i();
        this.f639a = activity;
        this.f640b = (Context) androidx.core.util.g.b(context, "context == null");
        this.f641c = (Handler) androidx.core.util.g.b(handler, "handler == null");
        this.f642d = i6;
    }

    g(c cVar) {
        this(cVar, cVar, new Handler(), 0);
    }

    @Override // androidx.fragment.app.d
    public View c(int i6) {
        return null;
    }

    @Override // androidx.fragment.app.d
    public boolean e() {
        return true;
    }

    Activity f() {
        return this.f639a;
    }

    Context g() {
        return this.f640b;
    }

    Handler j() {
        return this.f641c;
    }

    void k(Fragment fragment) {
    }

    public void l(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract E m();

    public LayoutInflater n() {
        return LayoutInflater.from(this.f640b);
    }

    public int o() {
        return this.f642d;
    }

    public boolean p() {
        return true;
    }

    public boolean q(Fragment fragment) {
        return true;
    }

    public void r() {
    }
}
