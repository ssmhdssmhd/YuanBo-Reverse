package j5;

import e4.q;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final a f6827a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f6828b;

    /* renamed from: c, reason: collision with root package name */
    private static final DateFormat[] f6829c;

    public static final class a extends ThreadLocal<DateFormat> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(e5.b.f3716f);
            return simpleDateFormat;
        }
    }

    static {
        String[] strArr = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};
        f6828b = strArr;
        f6829c = new DateFormat[strArr.length];
    }

    public static final Date a(String toHttpDateOrNull) {
        kotlin.jvm.internal.k.e(toHttpDateOrNull, "$this$toHttpDateOrNull");
        if (toHttpDateOrNull.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date parse = f6827a.get().parse(toHttpDateOrNull, parsePosition);
        if (parsePosition.getIndex() == toHttpDateOrNull.length()) {
            return parse;
        }
        String[] strArr = f6828b;
        synchronized (strArr) {
            int length = strArr.length;
            for (int i6 = 0; i6 < length; i6++) {
                DateFormat[] dateFormatArr = f6829c;
                DateFormat dateFormat = dateFormatArr[i6];
                if (dateFormat == null) {
                    dateFormat = new SimpleDateFormat(f6828b[i6], Locale.US);
                    dateFormat.setTimeZone(e5.b.f3716f);
                    dateFormatArr[i6] = dateFormat;
                }
                parsePosition.setIndex(0);
                Date parse2 = dateFormat.parse(toHttpDateOrNull, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return parse2;
                }
            }
            q qVar = q.f3710a;
            return null;
        }
    }

    public static final String b(Date toHttpDateString) {
        kotlin.jvm.internal.k.e(toHttpDateString, "$this$toHttpDateString");
        String format = f6827a.get().format(toHttpDateString);
        kotlin.jvm.internal.k.d(format, "STANDARD_DATE_FORMAT.get().format(this)");
        return format;
    }
}
