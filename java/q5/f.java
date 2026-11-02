package q5;

import java.nio.channels.WritableByteChannel;

/* loaded from: classes.dex */
public interface f extends y, WritableByteChannel {
    f E(h hVar);

    f Q(String str);

    e b();

    @Override // q5.y, java.io.Flushable
    void flush();

    f g(long j6);

    f write(byte[] bArr);

    f write(byte[] bArr, int i6, int i7);

    f writeByte(int i6);

    f writeInt(int i6);

    f writeShort(int i6);
}
