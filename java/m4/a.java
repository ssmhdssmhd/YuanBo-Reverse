package m4;

import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes.dex */
public final class a {
    public static final long a(InputStream inputStream, OutputStream out, int i6) {
        kotlin.jvm.internal.k.e(inputStream, "<this>");
        kotlin.jvm.internal.k.e(out, "out");
        byte[] bArr = new byte[i6];
        int read = inputStream.read(bArr);
        long j6 = 0;
        while (read >= 0) {
            out.write(bArr, 0, read);
            j6 += read;
            read = inputStream.read(bArr);
        }
        return j6;
    }
}
