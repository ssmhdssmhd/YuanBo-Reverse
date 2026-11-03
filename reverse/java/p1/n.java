package p1;

import java.util.Locale;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f8631a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f8632b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f8633c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8634d;

    private n(String[] strArr, int[] iArr, String[] strArr2, int i6) {
        this.f8631a = strArr;
        this.f8632b = iArr;
        this.f8633c = strArr2;
        this.f8634d = i6;
    }

    public static n b(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new n(strArr, iArr, strArr2, c(str, strArr, iArr, strArr2));
    }

    private static int c(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        strArr[0] = "";
        int i6 = 0;
        int i7 = 0;
        while (i6 < str.length()) {
            int indexOf = str.indexOf("$", i6);
            if (indexOf == -1) {
                strArr[i7] = strArr[i7] + str.substring(i6);
                i6 = str.length();
            } else if (indexOf != i6) {
                strArr[i7] = strArr[i7] + str.substring(i6, indexOf);
                i6 = indexOf;
            } else if (str.startsWith("$$", i6)) {
                strArr[i7] = strArr[i7] + "$";
                i6 += 2;
            } else {
                int i8 = i6 + 1;
                int indexOf2 = str.indexOf("$", i8);
                String substring = str.substring(i8, indexOf2);
                if (substring.equals("RepresentationID")) {
                    iArr[i7] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith("d") && !str2.endsWith("x") && !str2.endsWith("X")) {
                            str2 = str2 + "d";
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = "%01d";
                    }
                    substring.hashCode();
                    switch (substring) {
                        case "Number":
                            iArr[i7] = 2;
                            break;
                        case "Time":
                            iArr[i7] = 4;
                            break;
                        case "Bandwidth":
                            iArr[i7] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid template: " + str);
                    }
                    strArr2[i7] = str2;
                }
                i7++;
                strArr[i7] = "";
                i6 = indexOf2 + 1;
            }
        }
        return i7;
    }

    public String a(String str, long j6, int i6, long j7) {
        String format;
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        while (true) {
            int i8 = this.f8634d;
            if (i7 >= i8) {
                sb.append(this.f8631a[i8]);
                return sb.toString();
            }
            sb.append(this.f8631a[i7]);
            int i9 = this.f8632b[i7];
            if (i9 == 1) {
                sb.append(str);
            } else {
                if (i9 == 2) {
                    format = String.format(Locale.US, this.f8633c[i7], Long.valueOf(j6));
                } else if (i9 == 3) {
                    format = String.format(Locale.US, this.f8633c[i7], Integer.valueOf(i6));
                } else if (i9 == 4) {
                    format = String.format(Locale.US, this.f8633c[i7], Long.valueOf(j7));
                }
                sb.append(format);
            }
            i7++;
        }
    }
}
