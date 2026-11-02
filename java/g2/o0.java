package g2;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import i2.c1;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class o0 extends g {

    /* renamed from: e, reason: collision with root package name */
    private final Resources f4090e;

    /* renamed from: f, reason: collision with root package name */
    private final String f4091f;

    /* renamed from: g, reason: collision with root package name */
    private Uri f4092g;

    /* renamed from: h, reason: collision with root package name */
    private AssetFileDescriptor f4093h;

    /* renamed from: i, reason: collision with root package name */
    private InputStream f4094i;

    /* renamed from: j, reason: collision with root package name */
    private long f4095j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4096k;

    public static class a extends n {
        public a(String str, Throwable th, int i6) {
            super(str, th, i6);
        }
    }

    public o0(Context context) {
        super(false);
        this.f4090e = context.getResources();
        this.f4091f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i6) {
        return Uri.parse("rawresource:///" + i6);
    }

    @Override // g2.m
    public long a(q qVar) {
        int parseInt;
        String str;
        Uri uri = qVar.f4097a;
        this.f4092g = uri;
        if (TextUtils.equals("rawresource", uri.getScheme()) || (TextUtils.equals("android.resource", uri.getScheme()) && uri.getPathSegments().size() == 1 && ((String) i2.a.e(uri.getLastPathSegment())).matches("\\d+"))) {
            try {
                parseInt = Integer.parseInt((String) i2.a.e(uri.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new a("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uri.getScheme())) {
                throw new a("URI must either use scheme rawresource or android.resource", null, 1004);
            }
            String str2 = (String) i2.a.e(uri.getPath());
            if (str2.startsWith("/")) {
                str2 = str2.substring(1);
            }
            String host = uri.getHost();
            StringBuilder sb = new StringBuilder();
            if (TextUtils.isEmpty(host)) {
                str = "";
            } else {
                str = host + ":";
            }
            sb.append(str);
            sb.append(str2);
            parseInt = this.f4090e.getIdentifier(sb.toString(), "raw", this.f4091f);
            if (parseInt == 0) {
                throw new a("Resource not found.", null, 2005);
            }
        }
        q(qVar);
        try {
            AssetFileDescriptor openRawResourceFd = this.f4090e.openRawResourceFd(parseInt);
            this.f4093h = openRawResourceFd;
            if (openRawResourceFd == null) {
                throw new a("Resource is compressed: " + uri, null, 2000);
            }
            long length = openRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(openRawResourceFd.getFileDescriptor());
            this.f4094i = fileInputStream;
            if (length != -1) {
                try {
                    if (qVar.f4103g > length) {
                        throw new a(null, null, 2008);
                    }
                } catch (a e6) {
                    throw e6;
                } catch (IOException e7) {
                    throw new a(null, e7, 2000);
                }
            }
            long startOffset = openRawResourceFd.getStartOffset();
            long skip = fileInputStream.skip(qVar.f4103g + startOffset) - startOffset;
            if (skip != qVar.f4103g) {
                throw new a(null, null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f4095j = -1L;
                } else {
                    long size = channel.size() - channel.position();
                    this.f4095j = size;
                    if (size < 0) {
                        throw new a(null, null, 2008);
                    }
                }
            } else {
                long j6 = length - skip;
                this.f4095j = j6;
                if (j6 < 0) {
                    throw new n(2008);
                }
            }
            long j7 = qVar.f4104h;
            if (j7 != -1) {
                long j8 = this.f4095j;
                if (j8 != -1) {
                    j7 = Math.min(j8, j7);
                }
                this.f4095j = j7;
            }
            this.f4096k = true;
            r(qVar);
            long j9 = qVar.f4104h;
            return j9 != -1 ? j9 : this.f4095j;
        } catch (Resources.NotFoundException e8) {
            throw new a(null, e8, 2005);
        }
    }

    @Override // g2.m
    public void close() {
        this.f4092g = null;
        try {
            try {
                InputStream inputStream = this.f4094i;
                if (inputStream != null) {
                    inputStream.close();
                }
                this.f4094i = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f4093h;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f4093h = null;
                        if (this.f4096k) {
                            this.f4096k = false;
                            p();
                        }
                    }
                } catch (IOException e6) {
                    throw new a(null, e6, 2000);
                }
            } catch (IOException e7) {
                throw new a(null, e7, 2000);
            }
        } catch (Throwable th) {
            this.f4094i = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f4093h;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f4093h = null;
                    if (this.f4096k) {
                        this.f4096k = false;
                        p();
                    }
                    throw th;
                } catch (IOException e8) {
                    throw new a(null, e8, 2000);
                }
            } finally {
                this.f4093h = null;
                if (this.f4096k) {
                    this.f4096k = false;
                    p();
                }
            }
        }
    }

    @Override // g2.m
    public Uri j() {
        return this.f4092g;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f4095j;
        if (j6 == 0) {
            return -1;
        }
        if (j6 != -1) {
            try {
                i7 = (int) Math.min(j6, i7);
            } catch (IOException e6) {
                throw new a(null, e6, 2000);
            }
        }
        int read = ((InputStream) c1.j(this.f4094i)).read(bArr, i6, i7);
        if (read == -1) {
            if (this.f4095j == -1) {
                return -1;
            }
            throw new a("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
        long j7 = this.f4095j;
        if (j7 != -1) {
            this.f4095j = j7 - read;
        }
        o(read);
        return read;
    }
}
