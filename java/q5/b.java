package q5;

/* loaded from: classes.dex */
public final class b {
    public static final byte[] a(String asUtf8ToByteArray) {
        kotlin.jvm.internal.k.e(asUtf8ToByteArray, "$this$asUtf8ToByteArray");
        byte[] bytes = asUtf8ToByteArray.getBytes(v4.d.f9880b);
        kotlin.jvm.internal.k.d(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    public static final String b(byte[] toUtf8String) {
        kotlin.jvm.internal.k.e(toUtf8String, "$this$toUtf8String");
        return new String(toUtf8String, v4.d.f9880b);
    }
}
