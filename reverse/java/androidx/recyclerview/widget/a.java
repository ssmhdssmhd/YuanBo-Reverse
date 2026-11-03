package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
final class a implements g.a {

    /* renamed from: a, reason: collision with root package name */
    private androidx.core.util.e<b> f1146a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1147b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<b> f1148c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0019a f1149d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f1150e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f1151f;

    /* renamed from: g, reason: collision with root package name */
    final g f1152g;

    /* renamed from: h, reason: collision with root package name */
    private int f1153h;

    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    interface InterfaceC0019a {
        void a(int i6, int i7);

        void b(b bVar);

        RecyclerView.b0 c(int i6);

        void d(int i6, int i7);

        void e(int i6, int i7);

        void f(int i6, int i7);

        void g(b bVar);

        void h(int i6, int i7, Object obj);
    }

    static final class b {

        /* renamed from: a, reason: collision with root package name */
        int f1154a;

        /* renamed from: b, reason: collision with root package name */
        int f1155b;

        /* renamed from: c, reason: collision with root package name */
        Object f1156c;

        /* renamed from: d, reason: collision with root package name */
        int f1157d;

        b(int i6, int i7, int i8, Object obj) {
            this.f1154a = i6;
            this.f1155b = i7;
            this.f1157d = i8;
            this.f1156c = obj;
        }

        String a() {
            int i6 = this.f1154a;
            return i6 != 1 ? i6 != 2 ? i6 != 4 ? i6 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i6 = this.f1154a;
            if (i6 != bVar.f1154a) {
                return false;
            }
            if (i6 == 8 && Math.abs(this.f1157d - this.f1155b) == 1 && this.f1157d == bVar.f1155b && this.f1155b == bVar.f1157d) {
                return true;
            }
            if (this.f1157d != bVar.f1157d || this.f1155b != bVar.f1155b) {
                return false;
            }
            Object obj2 = this.f1156c;
            Object obj3 = bVar.f1156c;
            if (obj2 != null) {
                if (!obj2.equals(obj3)) {
                    return false;
                }
            } else if (obj3 != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1154a * 31) + this.f1155b) * 31) + this.f1157d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1155b + "c:" + this.f1157d + ",p:" + this.f1156c + "]";
        }
    }

    a(InterfaceC0019a interfaceC0019a) {
        this(interfaceC0019a, false);
    }

    a(InterfaceC0019a interfaceC0019a, boolean z5) {
        this.f1146a = new androidx.core.util.f(30);
        this.f1147b = new ArrayList<>();
        this.f1148c = new ArrayList<>();
        this.f1153h = 0;
        this.f1149d = interfaceC0019a;
        this.f1151f = z5;
        this.f1152g = new g(this);
    }

    private void c(b bVar) {
        q(bVar);
    }

    private void d(b bVar) {
        q(bVar);
    }

    private void f(b bVar) {
        boolean z5;
        char c6;
        int i6 = bVar.f1155b;
        int i7 = bVar.f1157d + i6;
        char c7 = 65535;
        int i8 = i6;
        int i9 = 0;
        while (i8 < i7) {
            if (this.f1149d.c(i8) != null || h(i8)) {
                if (c7 == 0) {
                    k(b(2, i6, i9, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c6 = 1;
            } else {
                if (c7 == 1) {
                    q(b(2, i6, i9, null));
                    z5 = true;
                } else {
                    z5 = false;
                }
                c6 = 0;
            }
            if (z5) {
                i8 -= i9;
                i7 -= i9;
                i9 = 1;
            } else {
                i9++;
            }
            i8++;
            c7 = c6;
        }
        if (i9 != bVar.f1157d) {
            a(bVar);
            bVar = b(2, i6, i9, null);
        }
        if (c7 == 0) {
            k(bVar);
        } else {
            q(bVar);
        }
    }

    private void g(b bVar) {
        int i6 = bVar.f1155b;
        int i7 = bVar.f1157d + i6;
        int i8 = i6;
        char c6 = 65535;
        int i9 = 0;
        while (i6 < i7) {
            if (this.f1149d.c(i6) != null || h(i6)) {
                if (c6 == 0) {
                    k(b(4, i8, i9, bVar.f1156c));
                    i8 = i6;
                    i9 = 0;
                }
                c6 = 1;
            } else {
                if (c6 == 1) {
                    q(b(4, i8, i9, bVar.f1156c));
                    i8 = i6;
                    i9 = 0;
                }
                c6 = 0;
            }
            i9++;
            i6++;
        }
        if (i9 != bVar.f1157d) {
            Object obj = bVar.f1156c;
            a(bVar);
            bVar = b(4, i8, i9, obj);
        }
        if (c6 == 0) {
            k(bVar);
        } else {
            q(bVar);
        }
    }

    private boolean h(int i6) {
        int size = this.f1148c.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f1148c.get(i7);
            int i8 = bVar.f1154a;
            if (i8 == 8) {
                if (n(bVar.f1157d, i7 + 1) == i6) {
                    return true;
                }
            } else if (i8 == 1) {
                int i9 = bVar.f1155b;
                int i10 = bVar.f1157d + i9;
                while (i9 < i10) {
                    if (n(i9, i7 + 1) == i6) {
                        return true;
                    }
                    i9++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i6;
        int i7 = bVar.f1154a;
        if (i7 == 1 || i7 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int u5 = u(bVar.f1155b, i7);
        int i8 = bVar.f1155b;
        int i9 = bVar.f1154a;
        if (i9 == 2) {
            i6 = 0;
        } else {
            if (i9 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i6 = 1;
        }
        int i10 = 1;
        for (int i11 = 1; i11 < bVar.f1157d; i11++) {
            int u6 = u(bVar.f1155b + (i6 * i11), bVar.f1154a);
            int i12 = bVar.f1154a;
            if (i12 == 2 ? u6 == u5 : i12 == 4 && u6 == u5 + 1) {
                i10++;
            } else {
                b b6 = b(i12, u5, i10, bVar.f1156c);
                l(b6, i8);
                a(b6);
                if (bVar.f1154a == 4) {
                    i8 += i10;
                }
                u5 = u6;
                i10 = 1;
            }
        }
        Object obj = bVar.f1156c;
        a(bVar);
        if (i10 > 0) {
            b b7 = b(bVar.f1154a, u5, i10, obj);
            l(b7, i8);
            a(b7);
        }
    }

    private void q(b bVar) {
        this.f1148c.add(bVar);
        int i6 = bVar.f1154a;
        if (i6 == 1) {
            this.f1149d.e(bVar.f1155b, bVar.f1157d);
            return;
        }
        if (i6 == 2) {
            this.f1149d.d(bVar.f1155b, bVar.f1157d);
            return;
        }
        if (i6 == 4) {
            this.f1149d.h(bVar.f1155b, bVar.f1157d, bVar.f1156c);
        } else {
            if (i6 == 8) {
                this.f1149d.a(bVar.f1155b, bVar.f1157d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int u(int i6, int i7) {
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        for (int size = this.f1148c.size() - 1; size >= 0; size--) {
            b bVar = this.f1148c.get(size);
            int i14 = bVar.f1154a;
            if (i14 == 8) {
                int i15 = bVar.f1155b;
                int i16 = bVar.f1157d;
                if (i15 < i16) {
                    i10 = i15;
                    i9 = i16;
                } else {
                    i9 = i15;
                    i10 = i16;
                }
                if (i6 < i10 || i6 > i9) {
                    if (i6 < i15) {
                        if (i7 == 1) {
                            bVar.f1155b = i15 + 1;
                            i11 = i16 + 1;
                        } else if (i7 == 2) {
                            bVar.f1155b = i15 - 1;
                            i11 = i16 - 1;
                        }
                        bVar.f1157d = i11;
                    }
                } else if (i10 == i15) {
                    if (i7 == 1) {
                        i13 = i16 + 1;
                    } else {
                        if (i7 == 2) {
                            i13 = i16 - 1;
                        }
                        i6++;
                    }
                    bVar.f1157d = i13;
                    i6++;
                } else {
                    if (i7 == 1) {
                        i12 = i15 + 1;
                    } else {
                        if (i7 == 2) {
                            i12 = i15 - 1;
                        }
                        i6--;
                    }
                    bVar.f1155b = i12;
                    i6--;
                }
            } else {
                int i17 = bVar.f1155b;
                if (i17 > i6) {
                    if (i7 == 1) {
                        i8 = i17 + 1;
                    } else if (i7 == 2) {
                        i8 = i17 - 1;
                    }
                    bVar.f1155b = i8;
                } else if (i14 == 1) {
                    i6 -= bVar.f1157d;
                } else if (i14 == 2) {
                    i6 += bVar.f1157d;
                }
            }
        }
        for (int size2 = this.f1148c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1148c.get(size2);
            if (bVar2.f1154a == 8) {
                int i18 = bVar2.f1157d;
                if (i18 != bVar2.f1155b && i18 >= 0) {
                }
                this.f1148c.remove(size2);
                a(bVar2);
            } else {
                if (bVar2.f1157d > 0) {
                }
                this.f1148c.remove(size2);
                a(bVar2);
            }
        }
        return i6;
    }

    @Override // androidx.recyclerview.widget.g.a
    public void a(b bVar) {
        if (this.f1151f) {
            return;
        }
        bVar.f1156c = null;
        this.f1146a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.g.a
    public b b(int i6, int i7, int i8, Object obj) {
        b b6 = this.f1146a.b();
        if (b6 == null) {
            return new b(i6, i7, i8, obj);
        }
        b6.f1154a = i6;
        b6.f1155b = i7;
        b6.f1157d = i8;
        b6.f1156c = obj;
        return b6;
    }

    public int e(int i6) {
        int size = this.f1147b.size();
        for (int i7 = 0; i7 < size; i7++) {
            b bVar = this.f1147b.get(i7);
            int i8 = bVar.f1154a;
            if (i8 != 1) {
                if (i8 == 2) {
                    int i9 = bVar.f1155b;
                    if (i9 <= i6) {
                        int i10 = bVar.f1157d;
                        if (i9 + i10 > i6) {
                            return -1;
                        }
                        i6 -= i10;
                    } else {
                        continue;
                    }
                } else if (i8 == 8) {
                    int i11 = bVar.f1155b;
                    if (i11 == i6) {
                        i6 = bVar.f1157d;
                    } else {
                        if (i11 < i6) {
                            i6--;
                        }
                        if (bVar.f1157d <= i6) {
                            i6++;
                        }
                    }
                }
            } else if (bVar.f1155b <= i6) {
                i6 += bVar.f1157d;
            }
        }
        return i6;
    }

    void i() {
        int size = this.f1148c.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f1149d.b(this.f1148c.get(i6));
        }
        s(this.f1148c);
        this.f1153h = 0;
    }

    void j() {
        i();
        int size = this.f1147b.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = this.f1147b.get(i6);
            int i7 = bVar.f1154a;
            if (i7 == 1) {
                this.f1149d.b(bVar);
                this.f1149d.e(bVar.f1155b, bVar.f1157d);
            } else if (i7 == 2) {
                this.f1149d.b(bVar);
                this.f1149d.f(bVar.f1155b, bVar.f1157d);
            } else if (i7 == 4) {
                this.f1149d.b(bVar);
                this.f1149d.h(bVar.f1155b, bVar.f1157d, bVar.f1156c);
            } else if (i7 == 8) {
                this.f1149d.b(bVar);
                this.f1149d.a(bVar.f1155b, bVar.f1157d);
            }
            Runnable runnable = this.f1150e;
            if (runnable != null) {
                runnable.run();
            }
        }
        s(this.f1147b);
        this.f1153h = 0;
    }

    void l(b bVar, int i6) {
        this.f1149d.g(bVar);
        int i7 = bVar.f1154a;
        if (i7 == 2) {
            this.f1149d.f(i6, bVar.f1157d);
        } else {
            if (i7 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f1149d.h(i6, bVar.f1157d, bVar.f1156c);
        }
    }

    int m(int i6) {
        return n(i6, 0);
    }

    int n(int i6, int i7) {
        int size = this.f1148c.size();
        while (i7 < size) {
            b bVar = this.f1148c.get(i7);
            int i8 = bVar.f1154a;
            if (i8 == 8) {
                int i9 = bVar.f1155b;
                if (i9 == i6) {
                    i6 = bVar.f1157d;
                } else {
                    if (i9 < i6) {
                        i6--;
                    }
                    if (bVar.f1157d <= i6) {
                        i6++;
                    }
                }
            } else {
                int i10 = bVar.f1155b;
                if (i10 > i6) {
                    continue;
                } else if (i8 == 2) {
                    int i11 = bVar.f1157d;
                    if (i6 < i10 + i11) {
                        return -1;
                    }
                    i6 -= i11;
                } else if (i8 == 1) {
                    i6 += bVar.f1157d;
                }
            }
            i7++;
        }
        return i6;
    }

    boolean o(int i6) {
        return (i6 & this.f1153h) != 0;
    }

    boolean p() {
        return this.f1147b.size() > 0;
    }

    void r() {
        this.f1152g.b(this.f1147b);
        int size = this.f1147b.size();
        for (int i6 = 0; i6 < size; i6++) {
            b bVar = this.f1147b.get(i6);
            int i7 = bVar.f1154a;
            if (i7 == 1) {
                c(bVar);
            } else if (i7 == 2) {
                f(bVar);
            } else if (i7 == 4) {
                g(bVar);
            } else if (i7 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f1150e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1147b.clear();
    }

    void s(List<b> list) {
        int size = list.size();
        for (int i6 = 0; i6 < size; i6++) {
            a(list.get(i6));
        }
        list.clear();
    }

    void t() {
        s(this.f1147b);
        s(this.f1148c);
        this.f1153h = 0;
    }
}
