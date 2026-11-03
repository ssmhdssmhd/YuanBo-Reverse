package p;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public class a {

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, Lock> f8485e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final File f8486a;

    /* renamed from: b, reason: collision with root package name */
    private final Lock f8487b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f8488c;

    /* renamed from: d, reason: collision with root package name */
    private FileChannel f8489d;

    public a(String str, File file, boolean z5) {
        File file2 = new File(file, str + ".lck");
        this.f8486a = file2;
        this.f8487b = a(file2.getAbsolutePath());
        this.f8488c = z5;
    }

    private static Lock a(String str) {
        Lock lock;
        Map<String, Lock> map = f8485e;
        synchronized (map) {
            lock = map.get(str);
            if (lock == null) {
                lock = new ReentrantLock();
                map.put(str, lock);
            }
        }
        return lock;
    }

    public void b() {
        this.f8487b.lock();
        if (this.f8488c) {
            try {
                FileChannel channel = new FileOutputStream(this.f8486a).getChannel();
                this.f8489d = channel;
                channel.lock();
            } catch (IOException e6) {
                throw new IllegalStateException("Unable to grab copy lock.", e6);
            }
        }
    }

    public void c() {
        FileChannel fileChannel = this.f8489d;
        if (fileChannel != null) {
            try {
                fileChannel.close();
            } catch (IOException unused) {
            }
        }
        this.f8487b.unlock();
    }
}
