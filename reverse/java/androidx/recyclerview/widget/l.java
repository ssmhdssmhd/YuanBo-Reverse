package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes.dex */
class l {

    /* renamed from: a, reason: collision with root package name */
    final b f1275a;

    /* renamed from: b, reason: collision with root package name */
    a f1276b = new a();

    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f1277a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f1278b;

        /* renamed from: c, reason: collision with root package name */
        int f1279c;

        /* renamed from: d, reason: collision with root package name */
        int f1280d;

        /* renamed from: e, reason: collision with root package name */
        int f1281e;

        a() {
        }

        void a(int i6) {
            this.f1277a = i6 | this.f1277a;
        }

        boolean b() {
            int i6 = this.f1277a;
            if ((i6 & 7) != 0 && (i6 & (c(this.f1280d, this.f1278b) << 0)) == 0) {
                return false;
            }
            int i7 = this.f1277a;
            if ((i7 & 112) != 0 && (i7 & (c(this.f1280d, this.f1279c) << 4)) == 0) {
                return false;
            }
            int i8 = this.f1277a;
            if ((i8 & 1792) != 0 && (i8 & (c(this.f1281e, this.f1278b) << 8)) == 0) {
                return false;
            }
            int i9 = this.f1277a;
            return (i9 & 28672) == 0 || (i9 & (c(this.f1281e, this.f1279c) << 12)) != 0;
        }

        int c(int i6, int i7) {
            if (i6 > i7) {
                return 1;
            }
            return i6 == i7 ? 2 : 4;
        }

        void d() {
            this.f1277a = 0;
        }

        void e(int i6, int i7, int i8, int i9) {
            this.f1278b = i6;
            this.f1279c = i7;
            this.f1280d = i8;
            this.f1281e = i9;
        }
    }

    interface b {
        View a(int i6);

        int b();

        int c(View view);

        int d();

        int e(View view);
    }

    l(b bVar) {
        this.f1275a = bVar;
    }

    View a(int i6, int i7, int i8, int i9) {
        int d6 = this.f1275a.d();
        int b6 = this.f1275a.b();
        int i10 = i7 > i6 ? 1 : -1;
        View view = null;
        while (i6 != i7) {
            View a6 = this.f1275a.a(i6);
            this.f1276b.e(d6, b6, this.f1275a.c(a6), this.f1275a.e(a6));
            if (i8 != 0) {
                this.f1276b.d();
                this.f1276b.a(i8);
                if (this.f1276b.b()) {
                    return a6;
                }
            }
            if (i9 != 0) {
                this.f1276b.d();
                this.f1276b.a(i9);
                if (this.f1276b.b()) {
                    view = a6;
                }
            }
            i6 += i10;
        }
        return view;
    }
}
