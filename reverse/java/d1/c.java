package d1;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f2922a;

    /* renamed from: b, reason: collision with root package name */
    private final DataOutputStream f2923b;

    public c() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f2922a = byteArrayOutputStream;
        this.f2923b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void b(DataOutputStream dataOutputStream, String str) {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(a aVar) {
        this.f2922a.reset();
        try {
            b(this.f2923b, aVar.f2916a);
            String str = aVar.f2917b;
            if (str == null) {
                str = "";
            }
            b(this.f2923b, str);
            this.f2923b.writeLong(aVar.f2918c);
            this.f2923b.writeLong(aVar.f2919d);
            this.f2923b.write(aVar.f2920e);
            this.f2923b.flush();
            return this.f2922a.toByteArray();
        } catch (IOException e6) {
            throw new RuntimeException(e6);
        }
    }
}
