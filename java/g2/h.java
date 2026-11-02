package g2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import i2.c1;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class h extends g {

    /* renamed from: e, reason: collision with root package name */
    private final ContentResolver f4032e;

    /* renamed from: f, reason: collision with root package name */
    private Uri f4033f;

    /* renamed from: g, reason: collision with root package name */
    private AssetFileDescriptor f4034g;

    /* renamed from: h, reason: collision with root package name */
    private FileInputStream f4035h;

    /* renamed from: i, reason: collision with root package name */
    private long f4036i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4037j;

    public static class a extends n {
        public a(IOException iOException, int i6) {
            super(iOException, i6);
        }
    }

    public h(Context context) {
        super(false);
        this.f4032e = context.getContentResolver();
    }

    @Override // g2.m
    public long a(q qVar) {
        AssetFileDescriptor openAssetFileDescriptor;
        try {
            Uri uri = qVar.f4097a;
            this.f4033f = uri;
            q(qVar);
            if ("content".equals(qVar.f4097a.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                openAssetFileDescriptor = this.f4032e.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                openAssetFileDescriptor = this.f4032e.openAssetFileDescriptor(uri, "r");
            }
            this.f4034g = openAssetFileDescriptor;
            if (openAssetFileDescriptor == null) {
                throw new a(new IOException("Could not open file descriptor for: " + uri), 2000);
            }
            long length = openAssetFileDescriptor.getLength();
            FileInputStream fileInputStream = new FileInputStream(openAssetFileDescriptor.getFileDescriptor());
            this.f4035h = fileInputStream;
            if (length != -1 && qVar.f4103g > length) {
                throw new a(null, 2008);
            }
            long startOffset = openAssetFileDescriptor.getStartOffset();
            long skip = fileInputStream.skip(qVar.f4103g + startOffset) - startOffset;
            if (skip != qVar.f4103g) {
                throw new a(null, 2008);
            }
            if (length == -1) {
                FileChannel channel = fileInputStream.getChannel();
                long size = channel.size();
                if (size == 0) {
                    this.f4036i = -1L;
                } else {
                    long position = size - channel.position();
                    this.f4036i = position;
                    if (position < 0) {
                        throw new a(null, 2008);
                    }
                }
            } else {
                long j6 = length - skip;
                this.f4036i = j6;
                if (j6 < 0) {
                    throw new a(null, 2008);
                }
            }
            long j7 = qVar.f4104h;
            if (j7 != -1) {
                long j8 = this.f4036i;
                if (j8 != -1) {
                    j7 = Math.min(j8, j7);
                }
                this.f4036i = j7;
            }
            this.f4037j = true;
            r(qVar);
            long j9 = qVar.f4104h;
            return j9 != -1 ? j9 : this.f4036i;
        } catch (a e6) {
            throw e6;
        } catch (IOException e7) {
            throw new a(e7, e7 instanceof FileNotFoundException ? 2005 : 2000);
        }
    }

    @Override // g2.m
    public void close() {
        this.f4033f = null;
        try {
            try {
                FileInputStream fileInputStream = this.f4035h;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.f4035h = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.f4034g;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } finally {
                        this.f4034g = null;
                        if (this.f4037j) {
                            this.f4037j = false;
                            p();
                        }
                    }
                } catch (IOException e6) {
                    throw new a(e6, 2000);
                }
            } catch (IOException e7) {
                throw new a(e7, 2000);
            }
        } catch (Throwable th) {
            this.f4035h = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.f4034g;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.f4034g = null;
                    if (this.f4037j) {
                        this.f4037j = false;
                        p();
                    }
                    throw th;
                } catch (IOException e8) {
                    throw new a(e8, 2000);
                }
            } finally {
                this.f4034g = null;
                if (this.f4037j) {
                    this.f4037j = false;
                    p();
                }
            }
        }
    }

    @Override // g2.m
    public Uri j() {
        return this.f4033f;
    }

    @Override // g2.i
    public int read(byte[] bArr, int i6, int i7) {
        if (i7 == 0) {
            return 0;
        }
        long j6 = this.f4036i;
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
        int read = ((FileInputStream) c1.j(this.f4035h)).read(bArr, i6, i7);
        if (read == -1) {
            return -1;
        }
        long j7 = this.f4036i;
        if (j7 != -1) {
            this.f4036i = j7 - read;
        }
        o(read);
        return read;
    }
}
