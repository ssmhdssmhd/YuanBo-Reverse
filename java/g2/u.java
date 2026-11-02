package g2;

import android.content.Context;
import android.net.Uri;
import com.tendcloud.tenddata.cs;
import g2.m;
import g2.v;
import i2.c1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class u implements m {

    /* renamed from: a, reason: collision with root package name */
    private final Context f4173a;

    /* renamed from: b, reason: collision with root package name */
    private final List<u0> f4174b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final m f4175c;

    /* renamed from: d, reason: collision with root package name */
    private m f4176d;

    /* renamed from: e, reason: collision with root package name */
    private m f4177e;

    /* renamed from: f, reason: collision with root package name */
    private m f4178f;

    /* renamed from: g, reason: collision with root package name */
    private m f4179g;

    /* renamed from: h, reason: collision with root package name */
    private m f4180h;

    /* renamed from: i, reason: collision with root package name */
    private m f4181i;

    /* renamed from: j, reason: collision with root package name */
    private m f4182j;

    /* renamed from: k, reason: collision with root package name */
    private m f4183k;

    public static final class a implements m.a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f4184a;

        /* renamed from: b, reason: collision with root package name */
        private final m.a f4185b;

        /* renamed from: c, reason: collision with root package name */
        private u0 f4186c;

        public a(Context context) {
            this(context, new v.b());
        }

        public a(Context context, m.a aVar) {
            this.f4184a = context.getApplicationContext();
            this.f4185b = aVar;
        }

        @Override // g2.m.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u a() {
            u uVar = new u(this.f4184a, this.f4185b.a());
            u0 u0Var = this.f4186c;
            if (u0Var != null) {
                uVar.c(u0Var);
            }
            return uVar;
        }

        public a c(u0 u0Var) {
            this.f4186c = u0Var;
            return this;
        }
    }

    public u(Context context, m mVar) {
        this.f4173a = context.getApplicationContext();
        this.f4175c = (m) i2.a.e(mVar);
    }

    private void o(m mVar) {
        for (int i6 = 0; i6 < this.f4174b.size(); i6++) {
            mVar.c(this.f4174b.get(i6));
        }
    }

    private m p() {
        if (this.f4177e == null) {
            c cVar = new c(this.f4173a);
            this.f4177e = cVar;
            o(cVar);
        }
        return this.f4177e;
    }

    private m q() {
        if (this.f4178f == null) {
            h hVar = new h(this.f4173a);
            this.f4178f = hVar;
            o(hVar);
        }
        return this.f4178f;
    }

    private m r() {
        if (this.f4181i == null) {
            j jVar = new j();
            this.f4181i = jVar;
            o(jVar);
        }
        return this.f4181i;
    }

    private m s() {
        if (this.f4176d == null) {
            z zVar = new z();
            this.f4176d = zVar;
            o(zVar);
        }
        return this.f4176d;
    }

    private m t() {
        if (this.f4182j == null) {
            o0 o0Var = new o0(this.f4173a);
            this.f4182j = o0Var;
            o(o0Var);
        }
        return this.f4182j;
    }

    private m u() {
        if (this.f4179g == null) {
            try {
                m mVar = (m) Class.forName("com.google.android.exoplayer2.ext.rtmp.RtmpDataSource").getConstructor(new Class[0]).newInstance(new Object[0]);
                this.f4179g = mVar;
                o(mVar);
            } catch (ClassNotFoundException unused) {
                i2.t.i("DefaultDataSource", "Attempting to play RTMP stream without depending on the RTMP extension");
            } catch (Exception e6) {
                throw new RuntimeException("Error instantiating RTMP extension", e6);
            }
            if (this.f4179g == null) {
                this.f4179g = this.f4175c;
            }
        }
        return this.f4179g;
    }

    private m v() {
        if (this.f4180h == null) {
            v0 v0Var = new v0();
            this.f4180h = v0Var;
            o(v0Var);
        }
        return this.f4180h;
    }

    private void w(m mVar, u0 u0Var) {
        if (mVar != null) {
            mVar.c(u0Var);
        }
    }

    @Override // g2.m
    public long a(q qVar) {
        m q6;
        i2.a.g(this.f4183k == null);
        String scheme = qVar.f4097a.getScheme();
        if (c1.x0(qVar.f4097a)) {
            String path = qVar.f4097a.getPath();
            if (path == null || !path.startsWith("/android_asset/")) {
                q6 = s();
            }
            q6 = p();
        } else {
            if (!"asset".equals(scheme)) {
                q6 = "content".equals(scheme) ? q() : "rtmp".equals(scheme) ? u() : "udp".equals(scheme) ? v() : cs.a.DATA.equals(scheme) ? r() : ("rawresource".equals(scheme) || "android.resource".equals(scheme)) ? t() : this.f4175c;
            }
            q6 = p();
        }
        this.f4183k = q6;
        return this.f4183k.a(qVar);
    }

    @Override // g2.m
    public void c(u0 u0Var) {
        i2.a.e(u0Var);
        this.f4175c.c(u0Var);
        this.f4174b.add(u0Var);
        w(this.f4176d, u0Var);
        w(this.f4177e, u0Var);
        w(this.f4178f, u0Var);
        w(this.f4179g, u0Var);
        w(this.f4180h, u0Var);
        w(this.f4181i, u0Var);
        w(this.f4182j, u0Var);
    }

    @Override // g2.m
    public void close() {
        m mVar = this.f4183k;
        if (mVar != null) {
            try {
                mVar.close();
            } finally {
                this.f4183k = null;
            }
        }
    }

    @Override // g2.m
    public Map<String, List<String>> f() {
        m mVar = this.f4183k;
        return mVar == null ? Collections.emptyMap() : mVar.f();
    }

    @Override // g2.m
    public Uri j() {
        m mVar = this.f4183k;
        if (mVar == null) {
            return null;
        }
        return mVar.j();
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        return ((m) i2.a.e(this.f4183k)).read(bArr, i6, i7);
    }
}
