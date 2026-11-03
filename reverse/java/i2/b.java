package i2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final File f5542a;

    /* renamed from: b, reason: collision with root package name */
    private final File f5543b;

    private static final class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final FileOutputStream f5544a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f5545b = false;

        public a(File file) {
            this.f5544a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5545b) {
                return;
            }
            this.f5545b = true;
            flush();
            try {
                this.f5544a.getFD().sync();
            } catch (IOException e6) {
                t.j("AtomicFile", "Failed to sync file descriptor:", e6);
            }
            this.f5544a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f5544a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i6) {
            this.f5544a.write(i6);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f5544a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i6, int i7) {
            this.f5544a.write(bArr, i6, i7);
        }
    }

    public b(File file) {
        this.f5542a = file;
        this.f5543b = new File(file.getPath() + ".bak");
    }

    private void e() {
        if (this.f5543b.exists()) {
            this.f5542a.delete();
            this.f5543b.renameTo(this.f5542a);
        }
    }

    public void a() {
        this.f5542a.delete();
        this.f5543b.delete();
    }

    public void b(OutputStream outputStream) {
        outputStream.close();
        this.f5543b.delete();
    }

    public boolean c() {
        return this.f5542a.exists() || this.f5543b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.f5542a);
    }

    public OutputStream f() {
        if (this.f5542a.exists()) {
            if (this.f5543b.exists()) {
                this.f5542a.delete();
            } else if (!this.f5542a.renameTo(this.f5543b)) {
                t.i("AtomicFile", "Couldn't rename file " + this.f5542a + " to backup file " + this.f5543b);
            }
        }
        try {
            return new a(this.f5542a);
        } catch (FileNotFoundException e6) {
            File parentFile = this.f5542a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f5542a, e6);
            }
            try {
                return new a(this.f5542a);
            } catch (FileNotFoundException e7) {
                throw new IOException("Couldn't create " + this.f5542a, e7);
            }
        }
    }
}
