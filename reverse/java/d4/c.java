package d4;

import android.content.Context;
import android.os.Build;
import java.io.File;

/* loaded from: classes.dex */
public final class c {
    public static String a(Context context) {
        File codeCacheDir = context.getCodeCacheDir();
        if (codeCacheDir == null) {
            codeCacheDir = context.getCacheDir();
        }
        if (codeCacheDir == null) {
            codeCacheDir = new File(b(context), "cache");
        }
        return codeCacheDir.getPath();
    }

    private static String b(Context context) {
        File dataDir;
        if (Build.VERSION.SDK_INT < 24) {
            return context.getApplicationInfo().dataDir;
        }
        dataDir = context.getDataDir();
        return dataDir.getPath();
    }

    public static String c(Context context) {
        File dir = context.getDir("flutter", 0);
        if (dir == null) {
            dir = new File(b(context), "app_flutter");
        }
        return dir.getPath();
    }

    public static String d(Context context) {
        File filesDir = context.getFilesDir();
        if (filesDir == null) {
            filesDir = new File(b(context), "files");
        }
        return filesDir.getPath();
    }
}
