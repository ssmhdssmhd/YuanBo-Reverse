package androidx.lifecycle;

import androidx.lifecycle.d;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements g {

    /* renamed from: a, reason: collision with root package name */
    private final b f814a;

    /* renamed from: b, reason: collision with root package name */
    private final g f815b;

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f816a;

        static {
            int[] iArr = new int[d.b.values().length];
            f816a = iArr;
            try {
                iArr[d.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f816a[d.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f816a[d.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f816a[d.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f816a[d.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f816a[d.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f816a[d.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    FullLifecycleObserverAdapter(b bVar, g gVar) {
        this.f814a = bVar;
        this.f815b = gVar;
    }

    @Override // androidx.lifecycle.g
    public void d(i iVar, d.b bVar) {
        switch (a.f816a[bVar.ordinal()]) {
            case 1:
                this.f814a.c(iVar);
                break;
            case 2:
                this.f814a.g(iVar);
                break;
            case 3:
                this.f814a.a(iVar);
                break;
            case 4:
                this.f814a.f(iVar);
                break;
            case 5:
                this.f814a.h(iVar);
                break;
            case 6:
                this.f814a.b(iVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        g gVar = this.f815b;
        if (gVar != null) {
            gVar.d(iVar, bVar);
        }
    }
}
