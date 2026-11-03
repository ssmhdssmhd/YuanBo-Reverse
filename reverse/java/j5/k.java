package j5;

import d5.y;
import java.net.ProtocolException;
import v4.p;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: d, reason: collision with root package name */
    public static final a f6848d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final y f6849a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6850b;

    /* renamed from: c, reason: collision with root package name */
    public final String f6851c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final k a(String statusLine) {
            y yVar;
            int i6;
            String str;
            kotlin.jvm.internal.k.e(statusLine, "statusLine");
            if (p.A(statusLine, "HTTP/1.", false, 2, null)) {
                i6 = 9;
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                int charAt = statusLine.charAt(7) - '0';
                if (charAt == 0) {
                    yVar = y.HTTP_1_0;
                } else {
                    if (charAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                    yVar = y.HTTP_1_1;
                }
            } else {
                if (!p.A(statusLine, "ICY ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                yVar = y.HTTP_1_0;
                i6 = 4;
            }
            int i7 = i6 + 3;
            if (statusLine.length() < i7) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            try {
                String substring = statusLine.substring(i6, i7);
                kotlin.jvm.internal.k.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int parseInt = Integer.parseInt(substring);
                if (statusLine.length() <= i7) {
                    str = "";
                } else {
                    if (statusLine.charAt(i7) != ' ') {
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                    }
                    str = statusLine.substring(i6 + 4);
                    kotlin.jvm.internal.k.d(str, "(this as java.lang.String).substring(startIndex)");
                }
                return new k(yVar, parseInt, str);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
        }
    }

    public k(y protocol, int i6, String message) {
        kotlin.jvm.internal.k.e(protocol, "protocol");
        kotlin.jvm.internal.k.e(message, "message");
        this.f6849a = protocol;
        this.f6850b = i6;
        this.f6851c = message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6849a == y.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f6850b);
        sb.append(' ');
        sb.append(this.f6851c);
        String sb2 = sb.toString();
        kotlin.jvm.internal.k.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
