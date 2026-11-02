package g2;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import i2.c1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class c extends g {

    /* renamed from: e, reason: collision with root package name */
    private final AssetManager f4006e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f4007f;

    /* renamed from: g, reason: collision with root package name */
    private InputStream f4008g;

    /* renamed from: h, reason: collision with root package name */
    private long f4009h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f4010i;

    public static final class a extends n {
        public a(Throwable th, int i6) {
            super(th, i6);
        }
    }

    public c(Context context) {
        super(false);
        this.f4006e = context.getAssets();
    }

    @Override // g2.m
    public long a(q qVar) {
        try {
            Uri uri = qVar.f4097a;
            this.f4007f = uri;
            String str = (String) i2.a.e(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            q(qVar);
            InputStream open = this.f4006e.open(str, 1);
            this.f4008g = open;
            if (open.skip(qVar.f4103g) < qVar.f4103g) {
                throw new a(null, 2008);
            }
            long j6 = qVar.f4104h;
            if (j6 != -1) {
                this.f4009h = j6;
            } else {
                long available = this.f4008g.available();
                this.f4009h = available;
                if (available == 2147483647L) {
                    this.f4009h = -1L;
                }
            }
            this.f4010i = true;
            r(qVar);
            return this.f4009h;
        } catch (a e6) {
            throw e6;
        } catch (IOException e7) {
            throw new a(e7, e7 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // g2.m
    public void close() {
        this.f4007f = null;
        try {
            try {
                InputStream inputStream = this.f4008g;
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e6) {
                throw new a(e6, 2000);
            }
        } finally {
            this.f4008g = null;
            if (this.f4010i) {
                this.f4010i = false;
                p();
            }
        }
    }

    @Override // g2.m
    public Uri j() {
        return this.f4007f;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f4009h;
        if (j6 == 0) {
            return -1;
        }
        if (j6 != -1) {
            try {
                i7 = (int) Math.min(j6, i7);
            } catch (IOException e6) {
                throw new a(e6, 2000);
            }
        }
        int read = ((InputStream) c1.j(this.f4008g)).read(bArr, i6, i7);
        if (read == -1) {
            return -1;
        }
        long j7 = this.f4009h;
        if (j7 != -1) {
            this.f4009h = j7 - read;
        }
        o(read);
        return read;
    }
}
