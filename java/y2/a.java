package y2;

import com.tendcloud.tenddata.ab;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import s2.f;

/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    private final Reader f11038a;

    /* renamed from: m, reason: collision with root package name */
    private long f11046m;

    /* renamed from: n, reason: collision with root package name */
    private int f11047n;

    /* renamed from: o, reason: collision with root package name */
    private String f11048o;

    /* renamed from: p, reason: collision with root package name */
    private int[] f11049p;

    /* renamed from: r, reason: collision with root package name */
    private String[] f11051r;

    /* renamed from: s, reason: collision with root package name */
    private int[] f11052s;

    /* renamed from: b, reason: collision with root package name */
    private boolean f11039b = false;

    /* renamed from: c, reason: collision with root package name */
    private final char[] f11040c = new char[1024];

    /* renamed from: d, reason: collision with root package name */
    private int f11041d = 0;

    /* renamed from: e, reason: collision with root package name */
    private int f11042e = 0;

    /* renamed from: j, reason: collision with root package name */
    private int f11043j = 0;

    /* renamed from: k, reason: collision with root package name */
    private int f11044k = 0;

    /* renamed from: l, reason: collision with root package name */
    int f11045l = 0;

    /* renamed from: q, reason: collision with root package name */
    private int f11050q = 0 + 1;

    /* renamed from: y2.a$a, reason: collision with other inner class name */
    class C0167a extends f {
        C0167a() {
        }

        @Override // s2.f
        public void a(a aVar) {
            int i6;
            if (aVar instanceof t2.f) {
                ((t2.f) aVar).x0();
                return;
            }
            int i7 = aVar.f11045l;
            if (i7 == 0) {
                i7 = aVar.s();
            }
            if (i7 == 13) {
                i6 = 9;
            } else if (i7 == 12) {
                i6 = 8;
            } else {
                if (i7 != 14) {
                    throw new IllegalStateException("Expected a name but was " + aVar.g0() + aVar.V());
                }
                i6 = 10;
            }
            aVar.f11045l = i6;
        }
    }

    static {
        f.f9254a = new C0167a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f11049p = iArr;
        iArr[0] = 6;
        this.f11051r = new String[32];
        this.f11052s = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f11038a = reader;
    }

    private boolean D(int i6) {
        int i7;
        int i8;
        char[] cArr = this.f11040c;
        int i9 = this.f11044k;
        int i10 = this.f11041d;
        this.f11044k = i9 - i10;
        int i11 = this.f11042e;
        if (i11 != i10) {
            int i12 = i11 - i10;
            this.f11042e = i12;
            System.arraycopy(cArr, i10, cArr, 0, i12);
        } else {
            this.f11042e = 0;
        }
        this.f11041d = 0;
        do {
            Reader reader = this.f11038a;
            int i13 = this.f11042e;
            int read = reader.read(cArr, i13, cArr.length - i13);
            if (read == -1) {
                return false;
            }
            i7 = this.f11042e + read;
            this.f11042e = i7;
            if (this.f11043j == 0 && (i8 = this.f11044k) == 0 && i7 > 0 && cArr[0] == 65279) {
                this.f11041d++;
                this.f11044k = i8 + 1;
                i6++;
            }
        } while (i7 < i6);
        return true;
    }

    private String F(boolean z5) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i6 = 0;
        while (true) {
            int i7 = this.f11050q;
            if (i6 >= i7) {
                return sb.toString();
            }
            int i8 = this.f11049p[i6];
            if (i8 == 1 || i8 == 2) {
                int i9 = this.f11052s[i6];
                if (z5 && i9 > 0 && i6 == i7 - 1) {
                    i9--;
                }
                sb.append('[');
                sb.append(i9);
                sb.append(']');
            } else if (i8 == 3 || i8 == 4 || i8 == 5) {
                sb.append('.');
                String str = this.f11051r[i6];
                if (str != null) {
                    sb.append(str);
                }
            }
            i6++;
        }
    }

    private boolean U(char c6) {
        if (c6 == '\t' || c6 == '\n' || c6 == '\f' || c6 == '\r' || c6 == ' ') {
            return false;
        }
        if (c6 != '#') {
            if (c6 == ',') {
                return false;
            }
            if (c6 != '/' && c6 != '=') {
                if (c6 == '{' || c6 == '}' || c6 == ':') {
                    return false;
                }
                if (c6 != ';') {
                    switch (c6) {
                        case ab.b.API_MYNA_START /* 91 */:
                        case ']':
                            return false;
                        case ab.b.API_MYNA_STOP /* 92 */:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        k();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        if (r1 != '/') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0055, code lost:
    
        r7.f11041d = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0058, code lost:
    
        if (r4 != r2) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r7.f11041d = r4 - 1;
        r2 = D(2);
        r7.f11041d++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r2 != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
    
        k();
        r2 = r7.f11041d;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0073, code lost:
    
        if (r3 == '*') goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0080, code lost:
    
        r7.f11041d = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008a, code lost:
    
        if (n0("*\/") == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
    
        throw r0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0075, code lost:
    
        if (r3 == '/') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0078, code lost:
    
        r7.f11041d = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0077, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0098, code lost:
    
        r7.f11041d = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x009c, code lost:
    
        if (r1 != '#') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x009e, code lost:
    
        k();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a2, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int b0(boolean r8) {
        /*
            r7 = this;
            char[] r0 = r7.f11040c
        L2:
            int r1 = r7.f11041d
        L4:
            int r2 = r7.f11042e
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r7.f11041d = r1
            boolean r1 = r7.D(r3)
            if (r1 != 0) goto L30
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r7.V()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L30:
            int r1 = r7.f11041d
            int r2 = r7.f11042e
        L34:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L44
            int r1 = r7.f11043j
            int r1 = r1 + r3
            r7.f11043j = r1
            r7.f11044k = r4
            goto La3
        L44:
            r5 = 32
            if (r1 == r5) goto La3
            r5 = 13
            if (r1 == r5) goto La3
            r5 = 9
            if (r1 != r5) goto L51
            goto La3
        L51:
            r5 = 47
            if (r1 != r5) goto L98
            r7.f11041d = r4
            r6 = 2
            if (r4 != r2) goto L6a
            int r4 = r4 + (-1)
            r7.f11041d = r4
            boolean r2 = r7.D(r6)
            int r4 = r7.f11041d
            int r4 = r4 + r3
            r7.f11041d = r4
            if (r2 != 0) goto L6a
            return r1
        L6a:
            r7.k()
            int r2 = r7.f11041d
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L80
            if (r3 == r5) goto L78
            return r1
        L78:
            int r2 = r2 + 1
            r7.f11041d = r2
        L7c:
            r7.o0()
            goto L2
        L80:
            int r2 = r2 + 1
            r7.f11041d = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.n0(r1)
            if (r1 == 0) goto L91
            int r1 = r7.f11041d
            int r1 = r1 + r6
            goto L4
        L91:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.r0(r8)
            throw r8
        L98:
            r2 = 35
            r7.f11041d = r4
            if (r1 != r2) goto La2
            r7.k()
            goto L7c
        La2:
            return r1
        La3:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.a.b0(boolean):int");
    }

    private String d0(char c6) {
        char[] cArr = this.f11040c;
        StringBuilder sb = null;
        while (true) {
            int i6 = this.f11041d;
            int i7 = this.f11042e;
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    char c7 = cArr[i6];
                    if (c7 == c6) {
                        this.f11041d = i8;
                        int i9 = (i8 - i6) - 1;
                        if (sb == null) {
                            return new String(cArr, i6, i9);
                        }
                        sb.append(cArr, i6, i9);
                        return sb.toString();
                    }
                    if (c7 == '\\') {
                        this.f11041d = i8;
                        int i10 = (i8 - i6) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i10 + 1) * 2, 16));
                        }
                        sb.append(cArr, i6, i10);
                        sb.append(k0());
                    } else {
                        if (c7 == '\n') {
                            this.f11043j++;
                            this.f11044k = i8;
                        }
                        i6 = i8;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i6 - i6) * 2, 16));
                    }
                    sb.append(cArr, i6, i6 - i6);
                    this.f11041d = i6;
                    if (!D(1)) {
                        throw r0("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x004a, code lost:
    
        k();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String f0() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.f11041d
            int r4 = r3 + r2
            int r5 = r6.f11042e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f11040c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.k()
            goto L5c
        L4e:
            char[] r3 = r6.f11040c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.D(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r1 = r2
            goto L7e
        L5e:
            if (r0 != 0) goto L6b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r0.<init>(r3)
        L6b:
            char[] r3 = r6.f11040c
            int r4 = r6.f11041d
            r0.append(r3, r4, r2)
            int r3 = r6.f11041d
            int r3 = r3 + r2
            r6.f11041d = r3
            r2 = 1
            boolean r2 = r6.D(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r0 != 0) goto L8a
            java.lang.String r0 = new java.lang.String
            char[] r2 = r6.f11040c
            int r3 = r6.f11041d
            r0.<init>(r2, r3, r1)
            goto L95
        L8a:
            char[] r2 = r6.f11040c
            int r3 = r6.f11041d
            r0.append(r2, r3, r1)
            java.lang.String r0 = r0.toString()
        L95:
            int r2 = r6.f11041d
            int r2 = r2 + r1
            r6.f11041d = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.a.f0():java.lang.String");
    }

    private int h0() {
        String str;
        String str2;
        int i6;
        char c6 = this.f11040c[this.f11041d];
        if (c6 == 't' || c6 == 'T') {
            str = "true";
            str2 = "TRUE";
            i6 = 5;
        } else if (c6 == 'f' || c6 == 'F') {
            str = "false";
            str2 = "FALSE";
            i6 = 6;
        } else {
            if (c6 != 'n' && c6 != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i6 = 7;
        }
        int length = str.length();
        for (int i7 = 1; i7 < length; i7++) {
            if (this.f11041d + i7 >= this.f11042e && !D(i7 + 1)) {
                return 0;
            }
            char c7 = this.f11040c[this.f11041d + i7];
            if (c7 != str.charAt(i7) && c7 != str2.charAt(i7)) {
                return 0;
            }
        }
        if ((this.f11041d + length < this.f11042e || D(length + 1)) && U(this.f11040c[this.f11041d + length])) {
            return 0;
        }
        this.f11041d += length;
        this.f11045l = i6;
        return i6;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0097, code lost:
    
        if (r9 != 2) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0099, code lost:
    
        if (r10 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x009f, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x00a1, code lost:
    
        if (r13 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x00a7, code lost:
    
        if (r11 != 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00a9, code lost:
    
        if (r13 != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00ab, code lost:
    
        if (r13 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x00ae, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00af, code lost:
    
        r18.f11046m = r11;
        r18.f11041d += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00b8, code lost:
    
        r18.f11045l = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00ba, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bb, code lost:
    
        if (r9 == 2) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00be, code lost:
    
        if (r9 == 4) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c1, code lost:
    
        if (r9 != 7) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c4, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c6, code lost:
    
        r18.f11047n = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0095, code lost:
    
        if (U(r14) != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00cb, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int i0() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.a.i0():int");
    }

    private void j0(int i6) {
        int i7 = this.f11050q;
        int[] iArr = this.f11049p;
        if (i7 == iArr.length) {
            int i8 = i7 * 2;
            this.f11049p = Arrays.copyOf(iArr, i8);
            this.f11052s = Arrays.copyOf(this.f11052s, i8);
            this.f11051r = (String[]) Arrays.copyOf(this.f11051r, i8);
        }
        int[] iArr2 = this.f11049p;
        int i9 = this.f11050q;
        this.f11050q = i9 + 1;
        iArr2[i9] = i6;
    }

    private void k() {
        if (!this.f11039b) {
            throw r0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private char k0() {
        int i6;
        int i7;
        if (this.f11041d == this.f11042e && !D(1)) {
            throw r0("Unterminated escape sequence");
        }
        char[] cArr = this.f11040c;
        int i8 = this.f11041d;
        int i9 = i8 + 1;
        this.f11041d = i9;
        char c6 = cArr[i8];
        if (c6 == '\n') {
            this.f11043j++;
            this.f11044k = i9;
        } else if (c6 != '\"' && c6 != '\'' && c6 != '/' && c6 != '\\') {
            if (c6 == 'b') {
                return '\b';
            }
            if (c6 == 'f') {
                return '\f';
            }
            if (c6 == 'n') {
                return '\n';
            }
            if (c6 == 'r') {
                return '\r';
            }
            if (c6 == 't') {
                return '\t';
            }
            if (c6 != 'u') {
                throw r0("Invalid escape sequence");
            }
            if (i9 + 4 > this.f11042e && !D(4)) {
                throw r0("Unterminated escape sequence");
            }
            int i10 = this.f11041d;
            int i11 = i10 + 4;
            char c7 = 0;
            while (i10 < i11) {
                char c8 = this.f11040c[i10];
                char c9 = (char) (c7 << 4);
                if (c8 < '0' || c8 > '9') {
                    if (c8 >= 'a' && c8 <= 'f') {
                        i6 = c8 - 'a';
                    } else {
                        if (c8 < 'A' || c8 > 'F') {
                            throw new NumberFormatException("\\u" + new String(this.f11040c, this.f11041d, 4));
                        }
                        i6 = c8 - 'A';
                    }
                    i7 = i6 + 10;
                } else {
                    i7 = c8 - '0';
                }
                c7 = (char) (c9 + i7);
                i10++;
            }
            this.f11041d += 4;
            return c7;
        }
        return c6;
    }

    private void m0(char c6) {
        char[] cArr = this.f11040c;
        while (true) {
            int i6 = this.f11041d;
            int i7 = this.f11042e;
            while (true) {
                if (i6 < i7) {
                    int i8 = i6 + 1;
                    char c7 = cArr[i6];
                    if (c7 == c6) {
                        this.f11041d = i8;
                        return;
                    }
                    if (c7 == '\\') {
                        this.f11041d = i8;
                        k0();
                        break;
                    } else {
                        if (c7 == '\n') {
                            this.f11043j++;
                            this.f11044k = i8;
                        }
                        i6 = i8;
                    }
                } else {
                    this.f11041d = i6;
                    if (!D(1)) {
                        throw r0("Unterminated string");
                    }
                }
            }
        }
    }

    private boolean n0(String str) {
        int length = str.length();
        while (true) {
            if (this.f11041d + length > this.f11042e && !D(length)) {
                return false;
            }
            char[] cArr = this.f11040c;
            int i6 = this.f11041d;
            if (cArr[i6] != '\n') {
                for (int i7 = 0; i7 < length; i7++) {
                    if (this.f11040c[this.f11041d + i7] != str.charAt(i7)) {
                        break;
                    }
                }
                return true;
            }
            this.f11043j++;
            this.f11044k = i6 + 1;
            this.f11041d++;
        }
    }

    private void o0() {
        char c6;
        do {
            if (this.f11041d >= this.f11042e && !D(1)) {
                return;
            }
            char[] cArr = this.f11040c;
            int i6 = this.f11041d;
            int i7 = i6 + 1;
            this.f11041d = i7;
            c6 = cArr[i6];
            if (c6 == '\n') {
                this.f11043j++;
                this.f11044k = i7;
                return;
            }
        } while (c6 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
    
        k();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void p0() {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f11041d
            int r2 = r1 + r0
            int r3 = r4.f11042e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f11040c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.k()
        L4b:
            int r1 = r4.f11041d
            int r1 = r1 + r0
            r4.f11041d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f11041d = r1
            r0 = 1
            boolean r0 = r4.D(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.a.p0():void");
    }

    private void q() {
        b0(true);
        int i6 = this.f11041d - 1;
        this.f11041d = i6;
        if (i6 + 5 <= this.f11042e || D(5)) {
            int i7 = this.f11041d;
            char[] cArr = this.f11040c;
            if (cArr[i7] == ')' && cArr[i7 + 1] == ']' && cArr[i7 + 2] == '}' && cArr[i7 + 3] == '\'' && cArr[i7 + 4] == '\n') {
                this.f11041d = i7 + 5;
            }
        }
    }

    private IOException r0(String str) {
        throw new d(str + V());
    }

    public String I() {
        return F(true);
    }

    public boolean K() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        return (i6 == 2 || i6 == 4 || i6 == 17) ? false : true;
    }

    public final boolean M() {
        return this.f11039b;
    }

    String V() {
        return " at line " + (this.f11043j + 1) + " column " + ((this.f11041d - this.f11044k) + 1) + " path " + z();
    }

    public boolean W() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 5) {
            this.f11045l = 0;
            int[] iArr = this.f11052s;
            int i7 = this.f11050q - 1;
            iArr[i7] = iArr[i7] + 1;
            return true;
        }
        if (i6 == 6) {
            this.f11045l = 0;
            int[] iArr2 = this.f11052s;
            int i8 = this.f11050q - 1;
            iArr2[i8] = iArr2[i8] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + g0() + V());
    }

    public double X() {
        String d02;
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 15) {
            this.f11045l = 0;
            int[] iArr = this.f11052s;
            int i7 = this.f11050q - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f11046m;
        }
        if (i6 == 16) {
            this.f11048o = new String(this.f11040c, this.f11041d, this.f11047n);
            this.f11041d += this.f11047n;
        } else {
            if (i6 == 8 || i6 == 9) {
                d02 = d0(i6 == 8 ? '\'' : '\"');
            } else if (i6 == 10) {
                d02 = f0();
            } else if (i6 != 11) {
                throw new IllegalStateException("Expected a double but was " + g0() + V());
            }
            this.f11048o = d02;
        }
        this.f11045l = 11;
        double parseDouble = Double.parseDouble(this.f11048o);
        if (!this.f11039b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new d("JSON forbids NaN and infinities: " + parseDouble + V());
        }
        this.f11048o = null;
        this.f11045l = 0;
        int[] iArr2 = this.f11052s;
        int i8 = this.f11050q - 1;
        iArr2[i8] = iArr2[i8] + 1;
        return parseDouble;
    }

    public int Y() {
        String d02;
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 15) {
            long j6 = this.f11046m;
            int i7 = (int) j6;
            if (j6 == i7) {
                this.f11045l = 0;
                int[] iArr = this.f11052s;
                int i8 = this.f11050q - 1;
                iArr[i8] = iArr[i8] + 1;
                return i7;
            }
            throw new NumberFormatException("Expected an int but was " + this.f11046m + V());
        }
        if (i6 == 16) {
            this.f11048o = new String(this.f11040c, this.f11041d, this.f11047n);
            this.f11041d += this.f11047n;
        } else {
            if (i6 != 8 && i6 != 9 && i6 != 10) {
                throw new IllegalStateException("Expected an int but was " + g0() + V());
            }
            if (i6 == 10) {
                d02 = f0();
            } else {
                d02 = d0(i6 == 8 ? '\'' : '\"');
            }
            this.f11048o = d02;
            try {
                int parseInt = Integer.parseInt(this.f11048o);
                this.f11045l = 0;
                int[] iArr2 = this.f11052s;
                int i9 = this.f11050q - 1;
                iArr2[i9] = iArr2[i9] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f11045l = 11;
        double parseDouble = Double.parseDouble(this.f11048o);
        int i10 = (int) parseDouble;
        if (i10 != parseDouble) {
            throw new NumberFormatException("Expected an int but was " + this.f11048o + V());
        }
        this.f11048o = null;
        this.f11045l = 0;
        int[] iArr3 = this.f11052s;
        int i11 = this.f11050q - 1;
        iArr3[i11] = iArr3[i11] + 1;
        return i10;
    }

    public long Z() {
        String d02;
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 15) {
            this.f11045l = 0;
            int[] iArr = this.f11052s;
            int i7 = this.f11050q - 1;
            iArr[i7] = iArr[i7] + 1;
            return this.f11046m;
        }
        if (i6 == 16) {
            this.f11048o = new String(this.f11040c, this.f11041d, this.f11047n);
            this.f11041d += this.f11047n;
        } else {
            if (i6 != 8 && i6 != 9 && i6 != 10) {
                throw new IllegalStateException("Expected a long but was " + g0() + V());
            }
            if (i6 == 10) {
                d02 = f0();
            } else {
                d02 = d0(i6 == 8 ? '\'' : '\"');
            }
            this.f11048o = d02;
            try {
                long parseLong = Long.parseLong(this.f11048o);
                this.f11045l = 0;
                int[] iArr2 = this.f11052s;
                int i8 = this.f11050q - 1;
                iArr2[i8] = iArr2[i8] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f11045l = 11;
        double parseDouble = Double.parseDouble(this.f11048o);
        long j6 = (long) parseDouble;
        if (j6 != parseDouble) {
            throw new NumberFormatException("Expected a long but was " + this.f11048o + V());
        }
        this.f11048o = null;
        this.f11045l = 0;
        int[] iArr3 = this.f11052s;
        int i9 = this.f11050q - 1;
        iArr3[i9] = iArr3[i9] + 1;
        return j6;
    }

    public void a() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 3) {
            j0(1);
            this.f11052s[this.f11050q - 1] = 0;
            this.f11045l = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + g0() + V());
        }
    }

    public String a0() {
        char c6;
        String d02;
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 14) {
            d02 = f0();
        } else {
            if (i6 == 12) {
                c6 = '\'';
            } else {
                if (i6 != 13) {
                    throw new IllegalStateException("Expected a name but was " + g0() + V());
                }
                c6 = '\"';
            }
            d02 = d0(c6);
        }
        this.f11045l = 0;
        this.f11051r[this.f11050q - 1] = d02;
        return d02;
    }

    public void c0() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 7) {
            this.f11045l = 0;
            int[] iArr = this.f11052s;
            int i7 = this.f11050q - 1;
            iArr[i7] = iArr[i7] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + g0() + V());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11045l = 0;
        this.f11049p[0] = 8;
        this.f11050q = 1;
        this.f11038a.close();
    }

    public String e0() {
        String str;
        char c6;
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 10) {
            str = f0();
        } else {
            if (i6 == 8) {
                c6 = '\'';
            } else if (i6 == 9) {
                c6 = '\"';
            } else if (i6 == 11) {
                str = this.f11048o;
                this.f11048o = null;
            } else if (i6 == 15) {
                str = Long.toString(this.f11046m);
            } else {
                if (i6 != 16) {
                    throw new IllegalStateException("Expected a string but was " + g0() + V());
                }
                str = new String(this.f11040c, this.f11041d, this.f11047n);
                this.f11041d += this.f11047n;
            }
            str = d0(c6);
        }
        this.f11045l = 0;
        int[] iArr = this.f11052s;
        int i7 = this.f11050q - 1;
        iArr[i7] = iArr[i7] + 1;
        return str;
    }

    public b g0() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        switch (i6) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case ab.b.API_TYPE_INDUSTRY /* 17 */:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void j() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 == 1) {
            j0(3);
            this.f11045l = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + g0() + V());
        }
    }

    public final void l0(boolean z5) {
        this.f11039b = z5;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public void q0() {
        int i6 = 0;
        do {
            int i7 = this.f11045l;
            if (i7 == 0) {
                i7 = s();
            }
            switch (i7) {
                case 1:
                    j0(3);
                    i6++;
                    this.f11045l = 0;
                    break;
                case 2:
                    if (i6 == 0) {
                        this.f11051r[this.f11050q - 1] = null;
                    }
                    this.f11050q--;
                    i6--;
                    this.f11045l = 0;
                    break;
                case 3:
                    j0(1);
                    i6++;
                    this.f11045l = 0;
                    break;
                case 4:
                    this.f11050q--;
                    i6--;
                    this.f11045l = 0;
                    break;
                case 5:
                case 6:
                case 7:
                case 11:
                case 15:
                default:
                    this.f11045l = 0;
                    break;
                case 8:
                    m0('\'');
                    this.f11045l = 0;
                    break;
                case 9:
                    m0('\"');
                    this.f11045l = 0;
                    break;
                case 10:
                    p0();
                    this.f11045l = 0;
                    break;
                case 12:
                    m0('\'');
                    if (i6 == 0) {
                        this.f11051r[this.f11050q - 1] = "<skipped>";
                    }
                    this.f11045l = 0;
                    break;
                case 13:
                    m0('\"');
                    if (i6 == 0) {
                        this.f11051r[this.f11050q - 1] = "<skipped>";
                    }
                    this.f11045l = 0;
                    break;
                case 14:
                    p0();
                    if (i6 == 0) {
                        this.f11051r[this.f11050q - 1] = "<skipped>";
                    }
                    this.f11045l = 0;
                    break;
                case 16:
                    this.f11041d += this.f11047n;
                    this.f11045l = 0;
                    break;
                case ab.b.API_TYPE_INDUSTRY /* 17 */:
                    break;
            }
            return;
        } while (i6 > 0);
        int[] iArr = this.f11052s;
        int i8 = this.f11050q - 1;
        iArr[i8] = iArr[i8] + 1;
    }

    int s() {
        int i6;
        int b02;
        int[] iArr = this.f11049p;
        int i7 = this.f11050q;
        int i8 = iArr[i7 - 1];
        if (i8 == 1) {
            iArr[i7 - 1] = 2;
        } else {
            if (i8 != 2) {
                if (i8 == 3 || i8 == 5) {
                    iArr[i7 - 1] = 4;
                    if (i8 == 5 && (b02 = b0(true)) != 44) {
                        if (b02 != 59) {
                            if (b02 != 125) {
                                throw r0("Unterminated object");
                            }
                            this.f11045l = 2;
                            return 2;
                        }
                        k();
                    }
                    int b03 = b0(true);
                    if (b03 == 34) {
                        i6 = 13;
                    } else if (b03 == 39) {
                        k();
                        i6 = 12;
                    } else {
                        if (b03 == 125) {
                            if (i8 == 5) {
                                throw r0("Expected name");
                            }
                            this.f11045l = 2;
                            return 2;
                        }
                        k();
                        this.f11041d--;
                        if (!U((char) b03)) {
                            throw r0("Expected name");
                        }
                        i6 = 14;
                    }
                } else if (i8 == 4) {
                    iArr[i7 - 1] = 5;
                    int b04 = b0(true);
                    if (b04 != 58) {
                        if (b04 != 61) {
                            throw r0("Expected ':'");
                        }
                        k();
                        if (this.f11041d < this.f11042e || D(1)) {
                            char[] cArr = this.f11040c;
                            int i9 = this.f11041d;
                            if (cArr[i9] == '>') {
                                this.f11041d = i9 + 1;
                            }
                        }
                    }
                } else if (i8 == 6) {
                    if (this.f11039b) {
                        q();
                    }
                    this.f11049p[this.f11050q - 1] = 7;
                } else if (i8 == 7) {
                    if (b0(false) == -1) {
                        i6 = 17;
                    } else {
                        k();
                        this.f11041d--;
                    }
                } else if (i8 == 8) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                this.f11045l = i6;
                return i6;
            }
            int b05 = b0(true);
            if (b05 != 44) {
                if (b05 != 59) {
                    if (b05 != 93) {
                        throw r0("Unterminated array");
                    }
                    this.f11045l = 4;
                    return 4;
                }
                k();
            }
        }
        int b06 = b0(true);
        if (b06 != 34) {
            if (b06 == 39) {
                k();
                this.f11045l = 8;
                return 8;
            }
            if (b06 != 44 && b06 != 59) {
                if (b06 == 91) {
                    this.f11045l = 3;
                    return 3;
                }
                if (b06 != 93) {
                    if (b06 == 123) {
                        this.f11045l = 1;
                        return 1;
                    }
                    this.f11041d--;
                    int h02 = h0();
                    if (h02 != 0) {
                        return h02;
                    }
                    int i02 = i0();
                    if (i02 != 0) {
                        return i02;
                    }
                    if (!U(this.f11040c[this.f11041d])) {
                        throw r0("Expected value");
                    }
                    k();
                    i6 = 10;
                } else if (i8 == 1) {
                    this.f11045l = 4;
                    return 4;
                }
            }
            if (i8 != 1 && i8 != 2) {
                throw r0("Unexpected value");
            }
            k();
            this.f11041d--;
            this.f11045l = 7;
            return 7;
        }
        i6 = 9;
        this.f11045l = i6;
        return i6;
    }

    public void t() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + g0() + V());
        }
        int i7 = this.f11050q - 1;
        this.f11050q = i7;
        int[] iArr = this.f11052s;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.f11045l = 0;
    }

    public String toString() {
        return getClass().getSimpleName() + V();
    }

    public void v() {
        int i6 = this.f11045l;
        if (i6 == 0) {
            i6 = s();
        }
        if (i6 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + g0() + V());
        }
        int i7 = this.f11050q - 1;
        this.f11050q = i7;
        this.f11051r[i7] = null;
        int[] iArr = this.f11052s;
        int i8 = i7 - 1;
        iArr[i8] = iArr[i8] + 1;
        this.f11045l = 0;
    }

    public String z() {
        return F(false);
    }
}
