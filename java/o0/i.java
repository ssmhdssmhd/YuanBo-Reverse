package o0;

import android.net.Uri;
import h0.y1;
import i2.r0;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class i implements r {

    /* renamed from: o, reason: collision with root package name */
    private static final int[] f8391o = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* renamed from: p, reason: collision with root package name */
    private static final a f8392p = new a(new a.InterfaceC0126a() { // from class: o0.g
        @Override // o0.i.a.InterfaceC0126a
        public final Constructor a() {
            Constructor f6;
            f6 = i.f();
            return f6;
        }
    });

    /* renamed from: q, reason: collision with root package name */
    private static final a f8393q = new a(new a.InterfaceC0126a() { // from class: o0.h
        @Override // o0.i.a.InterfaceC0126a
        public final Constructor a() {
            Constructor g6;
            g6 = i.g();
            return g6;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private boolean f8394b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8395c;

    /* renamed from: d, reason: collision with root package name */
    private int f8396d;

    /* renamed from: e, reason: collision with root package name */
    private int f8397e;

    /* renamed from: f, reason: collision with root package name */
    private int f8398f;

    /* renamed from: g, reason: collision with root package name */
    private int f8399g;

    /* renamed from: h, reason: collision with root package name */
    private int f8400h;

    /* renamed from: i, reason: collision with root package name */
    private int f8401i;

    /* renamed from: j, reason: collision with root package name */
    private int f8402j;

    /* renamed from: l, reason: collision with root package name */
    private int f8404l;

    /* renamed from: k, reason: collision with root package name */
    private int f8403k = 1;

    /* renamed from: n, reason: collision with root package name */
    private int f8406n = 112800;

    /* renamed from: m, reason: collision with root package name */
    private m2.q<y1> f8405m = m2.q.q();

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final InterfaceC0126a f8407a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicBoolean f8408b = new AtomicBoolean(false);

        /* renamed from: c, reason: collision with root package name */
        private Constructor<? extends l> f8409c;

        /* renamed from: o0.i$a$a, reason: collision with other inner class name */
        public interface InterfaceC0126a {
            Constructor<? extends l> a();
        }

        public a(InterfaceC0126a interfaceC0126a) {
            this.f8407a = interfaceC0126a;
        }

        private Constructor<? extends l> b() {
            synchronized (this.f8408b) {
                if (this.f8408b.get()) {
                    return this.f8409c;
                }
                try {
                    return this.f8407a.a();
                } catch (ClassNotFoundException unused) {
                    this.f8408b.set(true);
                    return this.f8409c;
                } catch (Exception e6) {
                    throw new RuntimeException("Error instantiating extension", e6);
                }
            }
        }

        public l a(Object... objArr) {
            Constructor<? extends l> b6 = b();
            if (b6 == null) {
                return null;
            }
            try {
                return b6.newInstance(objArr);
            } catch (Exception e6) {
                throw new IllegalStateException("Unexpected error creating extractor", e6);
            }
        }
    }

    private void e(int i6, List<l> list) {
        l bVar;
        switch (i6) {
            case 0:
                bVar = new y0.b();
                break;
            case 1:
                bVar = new y0.e();
                break;
            case 2:
                bVar = new y0.h((this.f8395c ? 2 : 0) | this.f8396d | (this.f8394b ? 1 : 0));
                break;
            case 3:
                bVar = new p0.b((this.f8395c ? 2 : 0) | this.f8397e | (this.f8394b ? 1 : 0));
                break;
            case 4:
                bVar = f8392p.a(Integer.valueOf(this.f8398f));
                if (bVar == null) {
                    bVar = new r0.d(this.f8398f);
                    break;
                }
                break;
            case 5:
                bVar = new s0.c();
                break;
            case 6:
                bVar = new u0.e(this.f8399g);
                break;
            case 7:
                bVar = new v0.f((this.f8395c ? 2 : 0) | this.f8402j | (this.f8394b ? 1 : 0));
                break;
            case 8:
                list.add(new w0.g(this.f8401i));
                bVar = new w0.k(this.f8400h);
                break;
            case 9:
                bVar = new x0.d();
                break;
            case 10:
                bVar = new y0.a0();
                break;
            case 11:
                bVar = new y0.h0(this.f8403k, new r0(0L), new y0.j(this.f8404l, this.f8405m), this.f8406n);
                break;
            case 12:
                bVar = new z0.b();
                break;
            case 13:
            default:
                return;
            case 14:
                bVar = new t0.a();
                break;
            case 15:
                bVar = f8393q.a(new Object[0]);
                if (bVar == null) {
                    return;
                }
                break;
            case 16:
                bVar = new q0.b();
                break;
        }
        list.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor<? extends l> f() {
        if (Boolean.TRUE.equals(Class.forName("com.google.android.exoplayer2.ext.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke(null, new Object[0]))) {
            return Class.forName("com.google.android.exoplayer2.ext.flac.FlacExtractor").asSubclass(l.class).getConstructor(Integer.TYPE);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Constructor<? extends l> g() {
        return Class.forName("com.google.android.exoplayer2.decoder.midi.MidiExtractor").asSubclass(l.class).getConstructor(new Class[0]);
    }

    @Override // o0.r
    public synchronized l[] a() {
        return b(Uri.EMPTY, new HashMap());
    }

    @Override // o0.r
    public synchronized l[] b(Uri uri, Map<String, List<String>> map) {
        ArrayList arrayList;
        int[] iArr = f8391o;
        arrayList = new ArrayList(iArr.length);
        int b6 = i2.l.b(map);
        if (b6 != -1) {
            e(b6, arrayList);
        }
        int c6 = i2.l.c(uri);
        if (c6 != -1 && c6 != b6) {
            e(c6, arrayList);
        }
        for (int i6 : iArr) {
            if (i6 != b6 && i6 != c6) {
                e(i6, arrayList);
            }
        }
        return (l[]) arrayList.toArray(new l[arrayList.size()]);
    }
}
