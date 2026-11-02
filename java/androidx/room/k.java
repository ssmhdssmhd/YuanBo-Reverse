package androidx.room;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/* loaded from: classes.dex */
class k implements q.c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f1413a;

    /* renamed from: b, reason: collision with root package name */
    private final String f1414b;

    /* renamed from: c, reason: collision with root package name */
    private final File f1415c;

    /* renamed from: d, reason: collision with root package name */
    private final int f1416d;

    /* renamed from: e, reason: collision with root package name */
    private final q.c f1417e;

    /* renamed from: j, reason: collision with root package name */
    private a f1418j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f1419k;

    k(Context context, String str, File file, int i6, q.c cVar) {
        this.f1413a = context;
        this.f1414b = str;
        this.f1415c = file;
        this.f1416d = i6;
        this.f1417e = cVar;
    }

    private void a(File file) {
        ReadableByteChannel channel;
        if (this.f1414b != null) {
            channel = Channels.newChannel(this.f1413a.getAssets().open(this.f1414b));
        } else {
            if (this.f1415c == null) {
                throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
            }
            channel = new FileInputStream(this.f1415c).getChannel();
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f1413a.getCacheDir());
        createTempFile.deleteOnExit();
        p.d.a(channel, new FileOutputStream(createTempFile).getChannel());
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            throw new IOException("Failed to create directories for " + file.getAbsolutePath());
        }
        if (createTempFile.renameTo(file)) {
            return;
        }
        throw new IOException("Failed to move intermediate file (" + createTempFile.getAbsolutePath() + ") to destination (" + file.getAbsolutePath() + ").");
    }

    private void k() {
        String databaseName = getDatabaseName();
        File databasePath = this.f1413a.getDatabasePath(databaseName);
        a aVar = this.f1418j;
        p.a aVar2 = new p.a(databaseName, this.f1413a.getFilesDir(), aVar == null || aVar.f1303j);
        try {
            aVar2.b();
            if (!databasePath.exists()) {
                try {
                    a(databasePath);
                    aVar2.c();
                    return;
                } catch (IOException e6) {
                    throw new RuntimeException("Unable to copy database file.", e6);
                }
            }
            if (this.f1418j == null) {
                aVar2.c();
                return;
            }
            try {
                int c6 = p.c.c(databasePath);
                int i6 = this.f1416d;
                if (c6 == i6) {
                    aVar2.c();
                    return;
                }
                if (this.f1418j.a(c6, i6)) {
                    aVar2.c();
                    return;
                }
                if (this.f1413a.deleteDatabase(databaseName)) {
                    try {
                        a(databasePath);
                    } catch (IOException e7) {
                        Log.w("ROOM", "Unable to copy database file.", e7);
                    }
                } else {
                    Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                }
                aVar2.c();
                return;
            } catch (IOException e8) {
                Log.w("ROOM", "Unable to read database version.", e8);
                aVar2.c();
                return;
            }
        } catch (Throwable th) {
            aVar2.c();
            throw th;
        }
        aVar2.c();
        throw th;
    }

    @Override // q.c, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f1417e.close();
        this.f1419k = false;
    }

    @Override // q.c
    public String getDatabaseName() {
        return this.f1417e.getDatabaseName();
    }

    @Override // q.c
    public synchronized q.b getWritableDatabase() {
        if (!this.f1419k) {
            k();
            this.f1419k = true;
        }
        return this.f1417e.getWritableDatabase();
    }

    void j(a aVar) {
        this.f1418j = aVar;
    }

    @Override // q.c
    public void setWriteAheadLoggingEnabled(boolean z5) {
        this.f1417e.setWriteAheadLoggingEnabled(z5);
    }
}
