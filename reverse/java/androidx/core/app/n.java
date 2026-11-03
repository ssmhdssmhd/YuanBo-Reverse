package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class n {

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f356a;

        /* renamed from: b, reason: collision with root package name */
        private IconCompat f357b;

        /* renamed from: c, reason: collision with root package name */
        private final z0[] f358c;

        /* renamed from: d, reason: collision with root package name */
        private final z0[] f359d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f360e;

        /* renamed from: f, reason: collision with root package name */
        boolean f361f;

        /* renamed from: g, reason: collision with root package name */
        private final int f362g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f363h;

        /* renamed from: i, reason: collision with root package name */
        @Deprecated
        public int f364i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f365j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f366k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f367l;

        public a(int i6, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i6 != 0 ? IconCompat.g(null, "", i6) : null, charSequence, pendingIntent);
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, z0[] z0VarArr, z0[] z0VarArr2, boolean z5, int i6, boolean z6, boolean z7, boolean z8) {
            this.f361f = true;
            this.f357b = iconCompat;
            if (iconCompat != null && iconCompat.j() == 2) {
                this.f364i = iconCompat.h();
            }
            this.f365j = c.d(charSequence);
            this.f366k = pendingIntent;
            this.f356a = bundle == null ? new Bundle() : bundle;
            this.f358c = z0VarArr;
            this.f359d = z0VarArr2;
            this.f360e = z5;
            this.f362g = i6;
            this.f361f = z6;
            this.f363h = z7;
            this.f367l = z8;
        }

        public PendingIntent a() {
            return this.f366k;
        }

        public boolean b() {
            return this.f360e;
        }

        public Bundle c() {
            return this.f356a;
        }

        public IconCompat d() {
            int i6;
            if (this.f357b == null && (i6 = this.f364i) != 0) {
                this.f357b = IconCompat.g(null, "", i6);
            }
            return this.f357b;
        }

        public z0[] e() {
            return this.f358c;
        }

        public int f() {
            return this.f362g;
        }

        public boolean g() {
            return this.f361f;
        }

        public CharSequence h() {
            return this.f365j;
        }

        public boolean i() {
            return this.f367l;
        }

        public boolean j() {
            return this.f363h;
        }
    }

    public static final class b {
        public static Notification.BubbleMetadata a(b bVar) {
            return null;
        }
    }

    public static class c {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        String M;
        long N;
        boolean Q;
        Notification R;
        boolean S;
        Icon T;

        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a, reason: collision with root package name */
        public Context f368a;

        /* renamed from: e, reason: collision with root package name */
        CharSequence f372e;

        /* renamed from: f, reason: collision with root package name */
        CharSequence f373f;

        /* renamed from: g, reason: collision with root package name */
        PendingIntent f374g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f375h;

        /* renamed from: i, reason: collision with root package name */
        RemoteViews f376i;

        /* renamed from: j, reason: collision with root package name */
        Bitmap f377j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f378k;

        /* renamed from: l, reason: collision with root package name */
        int f379l;

        /* renamed from: m, reason: collision with root package name */
        int f380m;

        /* renamed from: o, reason: collision with root package name */
        boolean f382o;

        /* renamed from: p, reason: collision with root package name */
        d f383p;

        /* renamed from: q, reason: collision with root package name */
        CharSequence f384q;

        /* renamed from: r, reason: collision with root package name */
        CharSequence f385r;

        /* renamed from: s, reason: collision with root package name */
        CharSequence[] f386s;

        /* renamed from: t, reason: collision with root package name */
        int f387t;

        /* renamed from: u, reason: collision with root package name */
        int f388u;

        /* renamed from: v, reason: collision with root package name */
        boolean f389v;

        /* renamed from: w, reason: collision with root package name */
        String f390w;

        /* renamed from: x, reason: collision with root package name */
        boolean f391x;

        /* renamed from: y, reason: collision with root package name */
        String f392y;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList<a> f369b = new ArrayList<>();

        /* renamed from: c, reason: collision with root package name */
        public ArrayList<y0> f370c = new ArrayList<>();

        /* renamed from: d, reason: collision with root package name */
        ArrayList<a> f371d = new ArrayList<>();

        /* renamed from: n, reason: collision with root package name */
        boolean f381n = true;

        /* renamed from: z, reason: collision with root package name */
        boolean f393z = false;
        int E = 0;
        int F = 0;
        int L = 0;
        int O = 0;
        int P = 0;

        public c(Context context, String str) {
            Notification notification = new Notification();
            this.R = notification;
            this.f368a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f380m = 0;
            this.U = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private Bitmap e(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f368a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(g.a.f3909b);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(g.a.f3908a);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
        }

        private void n(int i6, boolean z5) {
            Notification notification;
            int i7;
            if (z5) {
                notification = this.R;
                i7 = i6 | notification.flags;
            } else {
                notification = this.R;
                i7 = (~i6) & notification.flags;
            }
            notification.flags = i7;
        }

        public c a(a aVar) {
            if (aVar != null) {
                this.f369b.add(aVar);
            }
            return this;
        }

        public Notification b() {
            return new h0(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public c f(int i6) {
            this.L = i6;
            return this;
        }

        public c g(int i6) {
            this.E = i6;
            return this;
        }

        public c h(boolean z5) {
            this.A = z5;
            this.B = true;
            return this;
        }

        public c i(PendingIntent pendingIntent) {
            this.f374g = pendingIntent;
            return this;
        }

        public c j(CharSequence charSequence) {
            this.f373f = d(charSequence);
            return this;
        }

        public c k(CharSequence charSequence) {
            this.f372e = d(charSequence);
            return this;
        }

        public c l(int i6) {
            Notification notification = this.R;
            notification.defaults = i6;
            if ((i6 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public c m(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        public c o(String str) {
            this.f390w = str;
            return this;
        }

        public c p(Bitmap bitmap) {
            this.f377j = e(bitmap);
            return this;
        }

        public c q(boolean z5) {
            n(2, z5);
            return this;
        }

        public c r(boolean z5) {
            n(8, z5);
            return this;
        }

        public c s(int i6) {
            this.f380m = i6;
            return this;
        }

        public c t(boolean z5) {
            this.f381n = z5;
            return this;
        }

        public c u(int i6) {
            this.R.icon = i6;
            return this;
        }

        public c v(d dVar) {
            if (this.f383p != dVar) {
                this.f383p = dVar;
                if (dVar != null) {
                    dVar.g(this);
                }
            }
            return this;
        }

        public c w(CharSequence charSequence) {
            this.f384q = d(charSequence);
            return this;
        }

        public c x(boolean z5) {
            this.f382o = z5;
            return this;
        }

        public c y(int i6) {
            this.F = i6;
            return this;
        }

        public c z(long j6) {
            this.R.when = j6;
            return this;
        }
    }

    public static abstract class d {

        /* renamed from: a, reason: collision with root package name */
        protected c f394a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f395b;

        /* renamed from: c, reason: collision with root package name */
        CharSequence f396c;

        /* renamed from: d, reason: collision with root package name */
        boolean f397d = false;

        public void a(Bundle bundle) {
            if (this.f397d) {
                bundle.putCharSequence("android.summaryText", this.f396c);
            }
            CharSequence charSequence = this.f395b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c6 = c();
            if (c6 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c6);
            }
        }

        public abstract void b(m mVar);

        protected String c() {
            return null;
        }

        public abstract RemoteViews d(m mVar);

        public abstract RemoteViews e(m mVar);

        public RemoteViews f(m mVar) {
            return null;
        }

        public void g(c cVar) {
            if (this.f394a != cVar) {
                this.f394a = cVar;
                if (cVar != null) {
                    cVar.v(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }
}
