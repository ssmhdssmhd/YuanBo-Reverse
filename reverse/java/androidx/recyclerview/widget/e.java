package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class e implements Runnable {

    /* renamed from: e, reason: collision with root package name */
    static final ThreadLocal<e> f1244e = new ThreadLocal<>();

    /* renamed from: j, reason: collision with root package name */
    static Comparator<c> f1245j = new a();

    /* renamed from: b, reason: collision with root package name */
    long f1247b;

    /* renamed from: c, reason: collision with root package name */
    long f1248c;

    /* renamed from: a, reason: collision with root package name */
    ArrayList<RecyclerView> f1246a = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<c> f1249d = new ArrayList<>();

    class a implements Comparator<c> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(c cVar, c cVar2) {
            RecyclerView recyclerView = cVar.f1257d;
            if ((recyclerView == null) != (cVar2.f1257d == null)) {
                return recyclerView == null ? 1 : -1;
            }
            boolean z5 = cVar.f1254a;
            if (z5 != cVar2.f1254a) {
                return z5 ? -1 : 1;
            }
            int i6 = cVar2.f1255b - cVar.f1255b;
            if (i6 != 0) {
                return i6;
            }
            int i7 = cVar.f1256c - cVar2.f1256c;
            if (i7 != 0) {
                return i7;
            }
            return 0;
        }
    }

    static class b {

        /* renamed from: a, reason: collision with root package name */
        int f1250a;

        /* renamed from: b, reason: collision with root package name */
        int f1251b;

        /* renamed from: c, reason: collision with root package name */
        int[] f1252c;

        /* renamed from: d, reason: collision with root package name */
        int f1253d;

        b() {
        }

        void a() {
            int[] iArr = this.f1252c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f1253d = 0;
        }

        void b(RecyclerView recyclerView, boolean z5) {
            this.f1253d = 0;
            int[] iArr = this.f1252c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.n nVar = recyclerView.f979l;
        }

        boolean c(int i6) {
            if (this.f1252c != null) {
                int i7 = this.f1253d * 2;
                for (int i8 = 0; i8 < i7; i8 += 2) {
                    if (this.f1252c[i8] == i6) {
                        return true;
                    }
                }
            }
            return false;
        }

        void d(int i6, int i7) {
            this.f1250a = i6;
            this.f1251b = i7;
        }
    }

    static class c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f1254a;

        /* renamed from: b, reason: collision with root package name */
        public int f1255b;

        /* renamed from: c, reason: collision with root package name */
        public int f1256c;

        /* renamed from: d, reason: collision with root package name */
        public RecyclerView f1257d;

        /* renamed from: e, reason: collision with root package name */
        public int f1258e;

        c() {
        }

        public void a() {
            this.f1254a = false;
            this.f1255b = 0;
            this.f1256c = 0;
            this.f1257d = null;
            this.f1258e = 0;
        }
    }

    e() {
    }

    private void b() {
        c cVar;
        int size = this.f1246a.size();
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            RecyclerView recyclerView = this.f1246a.get(i7);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.f968f0.b(recyclerView, false);
                i6 += recyclerView.f968f0.f1253d;
            }
        }
        this.f1249d.ensureCapacity(i6);
        int i8 = 0;
        for (int i9 = 0; i9 < size; i9++) {
            RecyclerView recyclerView2 = this.f1246a.get(i9);
            if (recyclerView2.getWindowVisibility() == 0) {
                b bVar = recyclerView2.f968f0;
                int abs = Math.abs(bVar.f1250a) + Math.abs(bVar.f1251b);
                for (int i10 = 0; i10 < bVar.f1253d * 2; i10 += 2) {
                    if (i8 >= this.f1249d.size()) {
                        cVar = new c();
                        this.f1249d.add(cVar);
                    } else {
                        cVar = this.f1249d.get(i8);
                    }
                    int[] iArr = bVar.f1252c;
                    int i11 = iArr[i10 + 1];
                    cVar.f1254a = i11 <= abs;
                    cVar.f1255b = abs;
                    cVar.f1256c = i11;
                    cVar.f1257d = recyclerView2;
                    cVar.f1258e = iArr[i10];
                    i8++;
                }
            }
        }
        Collections.sort(this.f1249d, f1245j);
    }

    private void c(c cVar, long j6) {
        RecyclerView.b0 i6 = i(cVar.f1257d, cVar.f1258e, cVar.f1254a ? Long.MAX_VALUE : j6);
        if (i6 == null || i6.f1019b == null || !i6.q() || i6.r()) {
            return;
        }
        h(i6.f1019b.get(), j6);
    }

    private void d(long j6) {
        for (int i6 = 0; i6 < this.f1249d.size(); i6++) {
            c cVar = this.f1249d.get(i6);
            if (cVar.f1257d == null) {
                return;
            }
            c(cVar, j6);
            cVar.a();
        }
    }

    static boolean e(RecyclerView recyclerView, int i6) {
        int g6 = recyclerView.f965e.g();
        for (int i7 = 0; i7 < g6; i7++) {
            RecyclerView.b0 I = RecyclerView.I(recyclerView.f965e.f(i7));
            if (I.f1020c == i6 && !I.r()) {
                return true;
            }
        }
        return false;
    }

    private void h(RecyclerView recyclerView, long j6) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.D && recyclerView.f965e.g() != 0) {
            recyclerView.n0();
        }
        b bVar = recyclerView.f968f0;
        bVar.b(recyclerView, true);
        if (bVar.f1253d != 0) {
            try {
                androidx.core.os.d.a("RV Nested Prefetch");
                recyclerView.f970g0.c(null);
                for (int i6 = 0; i6 < bVar.f1253d * 2; i6 += 2) {
                    i(recyclerView, bVar.f1252c[i6], j6);
                }
            } finally {
                androidx.core.os.d.b();
            }
        }
    }

    private RecyclerView.b0 i(RecyclerView recyclerView, int i6, long j6) {
        if (e(recyclerView, i6)) {
            return null;
        }
        RecyclerView.u uVar = recyclerView.f959b;
        try {
            recyclerView.c0();
            RecyclerView.b0 A = uVar.A(i6, false, j6);
            if (A != null) {
                if (!A.q() || A.r()) {
                    uVar.a(A, false);
                } else {
                    uVar.t(A.f1018a);
                }
            }
            return A;
        } finally {
            recyclerView.e0(false);
        }
    }

    public void a(RecyclerView recyclerView) {
        this.f1246a.add(recyclerView);
    }

    void f(RecyclerView recyclerView, int i6, int i7) {
        if (recyclerView.isAttachedToWindow() && this.f1247b == 0) {
            this.f1247b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.f968f0.d(i6, i7);
    }

    void g(long j6) {
        b();
        d(j6);
    }

    public void j(RecyclerView recyclerView) {
        this.f1246a.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.d.a("RV Prefetch");
            if (!this.f1246a.isEmpty()) {
                int size = this.f1246a.size();
                long j6 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    RecyclerView recyclerView = this.f1246a.get(i6);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j6 = Math.max(recyclerView.getDrawingTime(), j6);
                    }
                }
                if (j6 != 0) {
                    g(TimeUnit.MILLISECONDS.toNanos(j6) + this.f1248c);
                }
            }
        } finally {
            this.f1247b = 0L;
            androidx.core.os.d.b();
        }
    }
}
