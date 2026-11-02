package x4;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.CancellationException;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;
import w4.p1;
import w4.t0;

/* loaded from: classes.dex */
public final class a extends b {
    private volatile a _immediate;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f10658b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10659c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f10660d;

    /* renamed from: e, reason: collision with root package name */
    private final a f10661e;

    public a(Handler handler, String str) {
        this(handler, str, false);
    }

    public /* synthetic */ a(Handler handler, String str, int i6, g gVar) {
        this(handler, (i6 & 2) != 0 ? null : str);
    }

    private a(Handler handler, String str, boolean z5) {
        super(null);
        this.f10658b = handler;
        this.f10659c = str;
        this.f10660d = z5;
        this._immediate = z5 ? this : null;
        a aVar = this._immediate;
        if (aVar == null) {
            aVar = new a(handler, str, true);
            this._immediate = aVar;
        }
        this.f10661e = aVar;
    }

    private final void a0(h4.g gVar, Runnable runnable) {
        p1.c(gVar, new CancellationException("The task was rejected, the handler underlying the dispatcher '" + this + "' was closed"));
        t0.b().V(gVar, runnable);
    }

    @Override // w4.c0
    public void V(h4.g gVar, Runnable runnable) {
        if (this.f10658b.post(runnable)) {
            return;
        }
        a0(gVar, runnable);
    }

    @Override // w4.c0
    public boolean W(h4.g gVar) {
        return (this.f10660d && k.a(Looper.myLooper(), this.f10658b.getLooper())) ? false : true;
    }

    @Override // w4.v1
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public a Y() {
        return this.f10661e;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f10658b == this.f10658b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f10658b);
    }

    @Override // w4.v1, w4.c0
    public String toString() {
        String Z = Z();
        if (Z != null) {
            return Z;
        }
        String str = this.f10659c;
        if (str == null) {
            str = this.f10658b.toString();
        }
        return this.f10660d ? k.j(str, ".immediate") : str;
    }
}
