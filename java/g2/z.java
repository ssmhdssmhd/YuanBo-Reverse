package g2;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import i2.c1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes.dex */
public final class z extends g {

    /* renamed from: e, reason: collision with root package name */
    private RandomAccessFile f4221e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f4222f;

    /* renamed from: g, reason: collision with root package name */
    private long f4223g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f4224h;

    private static final class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static boolean b(Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public static class b extends n {
        public b(String str, Throwable th, int i6) {
            super(str, th, i6);
        }

        public b(Throwable th, int i6) {
            super(th, i6);
        }
    }

    public z() {
        super(false);
    }

    private static RandomAccessFile s(Uri uri) {
        try {
            return new RandomAccessFile((String) i2.a.e(uri.getPath()), "r");
        } catch (FileNotFoundException e6) {
            if (TextUtils.isEmpty(uri.getQuery()) && TextUtils.isEmpty(uri.getFragment())) {
                throw new b(e6, (c1.f5548a < 21 || !a.b(e6.getCause())) ? 2005 : 2006);
            }
            throw new b(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", uri.getPath(), uri.getQuery(), uri.getFragment()), e6, 1004);
        } catch (SecurityException e7) {
            throw new b(e7, 2006);
        } catch (RuntimeException e8) {
            throw new b(e8, 2000);
        }
    }

    @Override // g2.m
    public long a(q qVar) {
        Uri uri = qVar.f4097a;
        this.f4222f = uri;
        q(qVar);
        RandomAccessFile s5 = s(uri);
        this.f4221e = s5;
        try {
            s5.seek(qVar.f4103g);
            long j6 = qVar.f4104h;
            if (j6 == -1) {
                j6 = this.f4221e.length() - qVar.f4103g;
            }
            this.f4223g = j6;
            if (j6 < 0) {
                throw new b(null, null, 2008);
            }
            this.f4224h = true;
            r(qVar);
            return this.f4223g;
        } catch (IOException e6) {
            throw new b(e6, 2000);
        }
    }

    @Override // g2.m
    public void close() {
        this.f4222f = null;
        try {
            try {
                RandomAccessFile randomAccessFile = this.f4221e;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e6) {
                throw new b(e6, 2000);
            }
        } finally {
            this.f4221e = null;
            if (this.f4224h) {
                this.f4224h = false;
                p();
            }
        }
    }

    @Override // g2.m
    public Uri j() {
        return this.f4222f;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        if (this.f4223g == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) c1.j(this.f4221e)).read(bArr, i6, (int) Math.min(this.f4223g, i7));
            if (read > 0) {
                this.f4223g -= read;
                o(read);
            }
            return read;
        } catch (IOException e6) {
            throw new b(e6, 2000);
        }
    }
}
