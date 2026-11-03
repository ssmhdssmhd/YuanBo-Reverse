package n1;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public interface o {

    /* renamed from: a, reason: collision with root package name */
    public static final o f8250a = new a();

    class a implements o {
        a() {
        }

        @Override // n1.o
        public long a() {
            throw new NoSuchElementException();
        }

        @Override // n1.o
        public long b() {
            throw new NoSuchElementException();
        }

        @Override // n1.o
        public boolean next() {
            return false;
        }
    }

    long a();

    long b();

    boolean next();
}
