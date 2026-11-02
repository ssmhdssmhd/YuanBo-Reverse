package s2;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import q2.s;
import t2.o;

/* loaded from: classes.dex */
public final class m {

    private static final class b extends Writer {

        /* renamed from: a, reason: collision with root package name */
        private final Appendable f9284a;

        /* renamed from: b, reason: collision with root package name */
        private final a f9285b = new a();

        private static class a implements CharSequence {

            /* renamed from: a, reason: collision with root package name */
            private char[] f9286a;

            /* renamed from: b, reason: collision with root package name */
            private String f9287b;

            private a() {
            }

            void a(char[] cArr) {
                this.f9286a = cArr;
                this.f9287b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i6) {
                return this.f9286a[i6];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f9286a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i6, int i7) {
                return new String(this.f9286a, i6, i7 - i6);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f9287b == null) {
                    this.f9287b = new String(this.f9286a);
                }
                return this.f9287b;
            }
        }

        b(Appendable appendable) {
            this.f9284a = appendable;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            this.f9284a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i6, int i7) {
            this.f9284a.append(charSequence, i6, i7);
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i6) {
            this.f9284a.append((char) i6);
        }

        @Override // java.io.Writer
        public void write(String str, int i6, int i7) {
            Objects.requireNonNull(str);
            this.f9284a.append(str, i6, i7 + i6);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i6, int i7) {
            this.f9285b.a(cArr);
            this.f9284a.append(this.f9285b, i6, i7 + i6);
        }
    }

    public static q2.k a(y2.a aVar) {
        boolean z5;
        try {
            try {
                aVar.g0();
                z5 = false;
            } catch (EOFException e6) {
                e = e6;
                z5 = true;
            }
            try {
                return o.V.b(aVar);
            } catch (EOFException e7) {
                e = e7;
                if (z5) {
                    return q2.m.f8912a;
                }
                throw new s(e);
            }
        } catch (NumberFormatException e8) {
            throw new s(e8);
        } catch (y2.d e9) {
            throw new s(e9);
        } catch (IOException e10) {
            throw new q2.l(e10);
        }
    }

    public static void b(q2.k kVar, y2.c cVar) {
        o.V.d(cVar, kVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
