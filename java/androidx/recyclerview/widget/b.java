package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    final InterfaceC0020b f1158a;

    /* renamed from: b, reason: collision with root package name */
    final a f1159b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List<View> f1160c = new ArrayList();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        long f1161a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f1162b;

        a() {
        }

        private void c() {
            if (this.f1162b == null) {
                this.f1162b = new a();
            }
        }

        void a(int i6) {
            if (i6 < 64) {
                this.f1161a &= ~(1 << i6);
                return;
            }
            a aVar = this.f1162b;
            if (aVar != null) {
                aVar.a(i6 - 64);
            }
        }

        int b(int i6) {
            a aVar = this.f1162b;
            return aVar == null ? i6 >= 64 ? Long.bitCount(this.f1161a) : Long.bitCount(this.f1161a & ((1 << i6) - 1)) : i6 < 64 ? Long.bitCount(this.f1161a & ((1 << i6) - 1)) : aVar.b(i6 - 64) + Long.bitCount(this.f1161a);
        }

        boolean d(int i6) {
            if (i6 < 64) {
                return (this.f1161a & (1 << i6)) != 0;
            }
            c();
            return this.f1162b.d(i6 - 64);
        }

        boolean e(int i6) {
            if (i6 >= 64) {
                c();
                return this.f1162b.e(i6 - 64);
            }
            long j6 = 1 << i6;
            long j7 = this.f1161a;
            boolean z5 = (j7 & j6) != 0;
            long j8 = j7 & (~j6);
            this.f1161a = j8;
            long j9 = j6 - 1;
            this.f1161a = (j8 & j9) | Long.rotateRight((~j9) & j8, 1);
            a aVar = this.f1162b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    g(63);
                }
                this.f1162b.e(0);
            }
            return z5;
        }

        void f() {
            this.f1161a = 0L;
            a aVar = this.f1162b;
            if (aVar != null) {
                aVar.f();
            }
        }

        void g(int i6) {
            if (i6 < 64) {
                this.f1161a |= 1 << i6;
            } else {
                c();
                this.f1162b.g(i6 - 64);
            }
        }

        public String toString() {
            if (this.f1162b == null) {
                return Long.toBinaryString(this.f1161a);
            }
            return this.f1162b.toString() + "xx" + Long.toBinaryString(this.f1161a);
        }
    }

    /* renamed from: androidx.recyclerview.widget.b$b, reason: collision with other inner class name */
    interface InterfaceC0020b {
        View a(int i6);

        RecyclerView.b0 b(View view);

        void c(int i6);

        void d(View view);

        int e();

        void f(int i6);

        void g();

        int h(View view);
    }

    b(InterfaceC0020b interfaceC0020b) {
        this.f1158a = interfaceC0020b;
    }

    private int e(int i6) {
        if (i6 < 0) {
            return -1;
        }
        int e6 = this.f1158a.e();
        int i7 = i6;
        while (i7 < e6) {
            int b6 = i6 - (i7 - this.f1159b.b(i7));
            if (b6 == 0) {
                while (this.f1159b.d(i7)) {
                    i7++;
                }
                return i7;
            }
            i7 += b6;
        }
        return -1;
    }

    private boolean n(View view) {
        if (!this.f1160c.remove(view)) {
            return false;
        }
        this.f1158a.d(view);
        return true;
    }

    void a(int i6) {
        int e6 = e(i6);
        this.f1159b.e(e6);
        this.f1158a.c(e6);
    }

    View b(int i6) {
        int size = this.f1160c.size();
        for (int i7 = 0; i7 < size; i7++) {
            View view = this.f1160c.get(i7);
            RecyclerView.b0 b6 = this.f1158a.b(view);
            if (b6.k() == i6 && !b6.r() && !b6.t()) {
                return view;
            }
        }
        return null;
    }

    View c(int i6) {
        return this.f1158a.a(e(i6));
    }

    int d() {
        return this.f1158a.e() - this.f1160c.size();
    }

    View f(int i6) {
        return this.f1158a.a(i6);
    }

    int g() {
        return this.f1158a.e();
    }

    int h(View view) {
        int h6 = this.f1158a.h(view);
        if (h6 == -1 || this.f1159b.d(h6)) {
            return -1;
        }
        return h6 - this.f1159b.b(h6);
    }

    boolean i(View view) {
        return this.f1160c.contains(view);
    }

    void j() {
        this.f1159b.f();
        for (int size = this.f1160c.size() - 1; size >= 0; size--) {
            this.f1158a.d(this.f1160c.get(size));
            this.f1160c.remove(size);
        }
        this.f1158a.g();
    }

    void k(int i6) {
        int e6 = e(i6);
        View a6 = this.f1158a.a(e6);
        if (a6 == null) {
            return;
        }
        if (this.f1159b.e(e6)) {
            n(a6);
        }
        this.f1158a.f(e6);
    }

    boolean l(View view) {
        int h6 = this.f1158a.h(view);
        if (h6 == -1) {
            n(view);
            return true;
        }
        if (!this.f1159b.d(h6)) {
            return false;
        }
        this.f1159b.e(h6);
        n(view);
        this.f1158a.f(h6);
        return true;
    }

    void m(View view) {
        int h6 = this.f1158a.h(view);
        if (h6 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f1159b.d(h6)) {
            this.f1159b.a(h6);
            n(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f1159b.toString() + ", hidden list:" + this.f1160c.size();
    }
}
