package j2;

import android.view.Surface;

/* loaded from: classes.dex */
public class g extends a1.q {

    /* renamed from: c, reason: collision with root package name */
    public final int f6719c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f6720d;

    public g(Throwable th, a1.t tVar, Surface surface) {
        super(th, tVar);
        this.f6719c = System.identityHashCode(surface);
        this.f6720d = surface == null || surface.isValid();
    }
}
