package com.tendcloud.tenddata;

import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;

/* loaded from: classes.dex */
public class ct {

    /* renamed from: a, reason: collision with root package name */
    private static final int f2556a = 25;

    /* renamed from: b, reason: collision with root package name */
    private static ct f2557b;

    /* renamed from: c, reason: collision with root package name */
    private ExecutorService f2558c;

    /* renamed from: d, reason: collision with root package name */
    private HashMap<Integer, TreeSet<cs>> f2559d;

    /* renamed from: e, reason: collision with root package name */
    private CRC32 f2560e;

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, RandomAccessFile> f2561f;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, FileLock> f2562g;

    /* renamed from: h, reason: collision with root package name */
    private Lock f2563h = new ReentrantLock();

    class a implements Runnable {
        private final String mFolderPath;
        private final String mNewFolder;
        private final TreeSet<cs> mQueue;

        private a(com.tendcloud.tenddata.a aVar) {
            StringBuilder sb = new StringBuilder();
            sb.append(ab.f2233g.getFilesDir());
            String str = File.separator;
            sb.append(str);
            sb.append(aVar.getDataFolder());
            this.mFolderPath = sb.toString();
            this.mNewFolder = ab.f2233g.getFilesDir() + str + aVar.getRootFolder() + str + aVar.getDataFolder();
            this.mQueue = (TreeSet) ct.this.f2559d.get(Integer.valueOf(aVar.index()));
        }

        private void deleteFile(String str, cs csVar) {
            File file = new File(str + File.separator + csVar.b());
            if (file.exists()) {
                file.delete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TreeSet<cs> treeSet = this.mQueue;
                if (treeSet != null) {
                    treeSet.isEmpty();
                    while (!this.mQueue.isEmpty()) {
                        cs pollFirst = this.mQueue.pollFirst();
                        if (pollFirst != null) {
                            File file = new File(this.mFolderPath);
                            if (file.exists()) {
                                deleteFile(file.getAbsolutePath(), pollFirst);
                            }
                            File file2 = new File(this.mNewFolder);
                            if (file2.exists()) {
                                deleteFile(file2.getAbsolutePath(), pollFirst);
                            }
                        }
                    }
                    this.mQueue.clear();
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
    }

    class b implements Runnable {
        private final String mFolderPath;
        private final cs mOperation;

        private b(cs csVar, com.tendcloud.tenddata.a aVar, String str) {
            String absolutePath = ab.f2233g.getFilesDir().getAbsolutePath();
            if (!TextUtils.isEmpty(str)) {
                absolutePath = absolutePath + File.separator + str;
            }
            this.mFolderPath = absolutePath + File.separator + aVar.getDataFolder();
            this.mOperation = csVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                File file = new File(this.mFolderPath + File.separator + this.mOperation.b());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th) {
                bq.postSDKError(th);
            }
        }
    }

    class c implements Runnable {
        private cu callback;
        private com.tendcloud.tenddata.a features;
        private String mFolderPath;
        private final cs mOperation;
        private final ct opm;

        private c(cs csVar, bz bzVar, ct ctVar) {
            File filesDir = ab.f2233g.getFilesDir();
            this.opm = ctVar;
            StringBuilder sb = new StringBuilder();
            sb.append(filesDir.toString());
            String str = File.separator;
            sb.append(str);
            sb.append(bzVar.f2492a.getDataFolder());
            this.mFolderPath = sb.toString();
            this.mFolderPath = filesDir.toString() + str + bzVar.f2492a.getRootFolder() + str + bzVar.f2492a.getDataFolder();
            this.mOperation = csVar;
            this.callback = bzVar.f2497f;
            this.features = bzVar.f2492a;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x008c, code lost:
        
            if (r3 == null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x008e, code lost:
        
            r3.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0091, code lost:
        
            r2.close();
            r0 = r7.callback;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0096, code lost:
        
            if (r0 == null) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00cf, code lost:
        
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 227
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.ct.c.run():void");
        }
    }

    private ct() {
        c();
        this.f2559d = new HashMap<>();
        for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
            this.f2559d.put(Integer.valueOf(aVar.index()), new TreeSet<>());
        }
        this.f2558c = Executors.newSingleThreadExecutor();
        this.f2560e = new CRC32();
    }

    public static ct a() {
        synchronized (ct.class) {
            if (f2557b == null) {
                f2557b = new ct();
            }
        }
        return f2557b;
    }

    private synchronized void a(cs csVar, com.tendcloud.tenddata.a aVar) {
        if (aVar != null && csVar != null) {
            try {
                this.f2559d.get(Integer.valueOf(aVar.index())).add(csVar);
            } finally {
            }
        }
    }

    private void a(File file) {
        try {
            if (file.isDirectory()) {
                a(c(file).get(0));
            } else {
                file.delete();
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, com.tendcloud.tenddata.a aVar) {
        try {
            int fileLimitType = aVar.getFileLimitType();
            if (fileLimitType != 1) {
                if (fileLimitType != 2) {
                    if (fileLimitType != 3) {
                        return;
                    }
                } else if (file.listFiles().length < 10) {
                    return;
                }
            } else if (b(file) <= f2556a) {
                return;
            }
            a(file);
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    private int b(File file) {
        File[] listFiles;
        if (file == null) {
            return 0;
        }
        try {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
                long j6 = 0;
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        j6 += file2.length();
                    }
                }
                return (int) (j6 / 1048576);
            }
            return 0;
        } catch (Throwable th) {
            bq.postSDKError(th);
            return 0;
        }
    }

    private List<File> c(File file) {
        List<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        try {
            arrayList = Arrays.asList(listFiles);
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.tendcloud.tenddata.ct.1
                @Override // java.util.Comparator
                public int compare(File file2, File file3) {
                    return file2.getName().compareTo(file3.getName());
                }
            });
            return arrayList;
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    private void c() {
        this.f2561f = new HashMap();
        this.f2562g = new HashMap();
        try {
            for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
                File file = new File(ab.f2233g.getFilesDir(), aVar.getRootFolder());
                File file2 = new File(file, aVar.getDataFolder());
                if (!file2.exists() && !file2.mkdirs()) {
                    return;
                }
                this.f2561f.put(Integer.valueOf(aVar.index()), new RandomAccessFile(new File(file, "Lock" + aVar.index()), "rw"));
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x010d A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #6 {all -> 0x0118, blocks: (B:93:0x008e, B:88:0x0092, B:51:0x00e5, B:69:0x010d, B:71:0x0113), top: B:92:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0113 A[Catch: all -> 0x0118, TRY_LEAVE, TryCatch #6 {all -> 0x0118, blocks: (B:93:0x008e, B:88:0x0092, B:51:0x00e5, B:69:0x010d, B:71:0x0113), top: B:92:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.TreeSet<com.tendcloud.tenddata.cs> a(com.tendcloud.tenddata.a r18, int r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tendcloud.tenddata.ct.a(com.tendcloud.tenddata.a, int, java.lang.String):java.util.TreeSet");
    }

    public synchronized void a(cs csVar, bz bzVar) {
        this.f2558c.execute(new c(csVar, bzVar, this));
    }

    public void b() {
        File filesDir = ab.f2233g.getFilesDir();
        try {
            int i6 = 0;
            for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
                File file = new File(filesDir, aVar.getDataFolder());
                if (file.exists()) {
                    Iterator<File> it = c(file).iterator();
                    while (it.hasNext()) {
                        it.next().delete();
                    }
                }
            }
            com.tendcloud.tenddata.a[] values = com.tendcloud.tenddata.a.values();
            int length = values.length;
            while (i6 < length) {
                com.tendcloud.tenddata.a aVar2 = values[i6];
                File file2 = new File(filesDir, aVar2.getRootFolder());
                File file3 = new File(file2, aVar2.getDataFolder());
                if (file3.exists()) {
                    Iterator<File> it2 = c(file3).iterator();
                    while (it2.hasNext()) {
                        it2.next().delete();
                    }
                }
                i6++;
                filesDir = file2;
            }
        } catch (Throwable th) {
            bq.postSDKError(th);
        }
    }

    public void clearDataCache(com.tendcloud.tenddata.a aVar) {
        try {
            this.f2559d.get(Integer.valueOf(aVar.index())).clear();
        } catch (Throwable unused) {
        }
    }

    public void confirmRead(com.tendcloud.tenddata.a aVar) {
        new a(aVar).run();
    }

    public void getFileLock(com.tendcloud.tenddata.a aVar) {
        try {
            this.f2563h.lock();
            this.f2562g.put(Integer.valueOf(aVar.index()), this.f2561f.get(Integer.valueOf(aVar.index())).getChannel().lock());
        } catch (Throwable unused) {
        }
    }

    public void releaseFileLock(com.tendcloud.tenddata.a aVar) {
        try {
            if (this.f2562g.get(Integer.valueOf(aVar.index())) != null) {
                this.f2562g.get(Integer.valueOf(aVar.index())).release();
                this.f2563h.unlock();
            }
        } catch (Throwable unused) {
        }
    }
}
