package h5;

import java.util.Arrays;
import java.util.logging.Logger;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.u;

/* loaded from: classes.dex */
public final class b {
    public static final String b(long j6) {
        StringBuilder sb;
        long j7;
        long j8;
        long j9;
        if (j6 > -999500000) {
            if (j6 > -999500) {
                if (j6 <= 0) {
                    sb = new StringBuilder();
                    j9 = j6 - 500;
                } else if (j6 < 999500) {
                    sb = new StringBuilder();
                    j9 = j6 + 500;
                } else if (j6 < 999500000) {
                    sb = new StringBuilder();
                    j8 = j6 + 500000;
                } else {
                    sb = new StringBuilder();
                    j7 = j6 + 500000000;
                }
                sb.append(j9 / 1000);
                sb.append(" µs");
                String sb2 = sb.toString();
                u uVar = u.f7016a;
                String format = String.format("%6s", Arrays.copyOf(new Object[]{sb2}, 1));
                k.d(format, "java.lang.String.format(format, *args)");
                return format;
            }
            sb = new StringBuilder();
            j8 = j6 - 500000;
            sb.append(j8 / 1000000);
            sb.append(" ms");
            String sb22 = sb.toString();
            u uVar2 = u.f7016a;
            String format2 = String.format("%6s", Arrays.copyOf(new Object[]{sb22}, 1));
            k.d(format2, "java.lang.String.format(format, *args)");
            return format2;
        }
        sb = new StringBuilder();
        j7 = j6 - 500000000;
        sb.append(j7 / 1000000000);
        sb.append(" s ");
        String sb222 = sb.toString();
        u uVar22 = u.f7016a;
        String format22 = String.format("%6s", Arrays.copyOf(new Object[]{sb222}, 1));
        k.d(format22, "java.lang.String.format(format, *args)");
        return format22;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(a aVar, d dVar, String str) {
        Logger a6 = e.f5263j.a();
        StringBuilder sb = new StringBuilder();
        sb.append(dVar.f());
        sb.append(' ');
        u uVar = u.f7016a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        k.d(format, "java.lang.String.format(format, *args)");
        sb.append(format);
        sb.append(": ");
        sb.append(aVar.b());
        a6.fine(sb.toString());
    }
}
