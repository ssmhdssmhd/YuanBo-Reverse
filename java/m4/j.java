package m4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {
    public static final File a(File file, File target, boolean z5, int i6) {
        kotlin.jvm.internal.k.e(file, "<this>");
        kotlin.jvm.internal.k.e(target, "target");
        if (!file.exists()) {
            throw new k(file, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!z5) {
                throw new d(file, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new d(file, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (!file.isDirectory()) {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    a.a(fileInputStream, fileOutputStream, i6);
                    b.a(fileOutputStream, null);
                    b.a(fileInputStream, null);
                } finally {
                }
            } finally {
            }
        } else if (!target.mkdirs()) {
            throw new e(file, target, "Failed to create target directory.");
        }
        return target;
    }

    public static /* synthetic */ File b(File file, File file2, boolean z5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z5 = false;
        }
        if ((i7 & 4) != 0) {
            i6 = 8192;
        }
        return a(file, file2, z5, i6);
    }
}
