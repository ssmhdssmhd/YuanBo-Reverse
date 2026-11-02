package i2;

import android.media.MediaFormat;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class w {
    public static void a(MediaFormat mediaFormat, String str, byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, j2.c cVar) {
        if (cVar != null) {
            d(mediaFormat, "color-transfer", cVar.f6683c);
            d(mediaFormat, "color-standard", cVar.f6681a);
            d(mediaFormat, "color-range", cVar.f6682b);
            a(mediaFormat, "hdr-static-info", cVar.f6684d);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f6) {
        if (f6 != -1.0f) {
            mediaFormat.setFloat(str, f6);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i6) {
        if (i6 != -1) {
            mediaFormat.setInteger(str, i6);
        }
    }

    public static void e(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            mediaFormat.setByteBuffer("csd-" + i6, ByteBuffer.wrap(list.get(i6)));
        }
    }
}
