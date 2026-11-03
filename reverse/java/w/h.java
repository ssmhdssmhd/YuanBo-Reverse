package w;

import android.content.Context;
import android.os.Build;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9934a = v.j.f("WrkDbPathHelper");

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f9935b = {"-journal", "-shm", "-wal"};

    public static File a(Context context) {
        return Build.VERSION.SDK_INT < 23 ? b(context) : c(context, "androidx.work.workdb");
    }

    public static File b(Context context) {
        return context.getDatabasePath("androidx.work.workdb");
    }

    private static File c(Context context, String str) {
        return new File(context.getNoBackupFilesDir(), str);
    }

    public static String d() {
        return "androidx.work.workdb";
    }

    public static void e(Context context) {
        File b6 = b(context);
        if (Build.VERSION.SDK_INT < 23 || !b6.exists()) {
            return;
        }
        v.j.c().a(f9934a, "Migrating WorkDatabase to the no-backup directory", new Throwable[0]);
        Map<File, File> f6 = f(context);
        for (File file : f6.keySet()) {
            File file2 = f6.get(file);
            if (file.exists() && file2 != null) {
                if (file2.exists()) {
                    v.j.c().h(f9934a, String.format("Over-writing contents of %s", file2), new Throwable[0]);
                }
                v.j.c().a(f9934a, file.renameTo(file2) ? String.format("Migrated %s to %s", file, file2) : String.format("Renaming %s to %s failed", file, file2), new Throwable[0]);
            }
        }
    }

    public static Map<File, File> f(Context context) {
        HashMap hashMap = new HashMap();
        if (Build.VERSION.SDK_INT >= 23) {
            File b6 = b(context);
            File a6 = a(context);
            hashMap.put(b6, a6);
            for (String str : f9935b) {
                hashMap.put(new File(b6.getPath() + str), new File(a6.getPath() + str));
            }
        }
        return hashMap;
    }
}
