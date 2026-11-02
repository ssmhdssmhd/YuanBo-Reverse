package m4;

import java.io.File;

/* loaded from: classes.dex */
public final class k extends e {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(File file, File file2, String str) {
        super(file, file2, str);
        kotlin.jvm.internal.k.e(file, "file");
    }

    public /* synthetic */ k(File file, File file2, String str, int i6, kotlin.jvm.internal.g gVar) {
        this(file, (i6 & 2) != 0 ? null : file2, (i6 & 4) != 0 ? null : str);
    }
}
