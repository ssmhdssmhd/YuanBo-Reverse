package q2;

import java.io.IOException;
import java.io.StringWriter;

/* loaded from: classes.dex */
public abstract class k {
    @Deprecated
    public k() {
    }

    public h b() {
        if (f()) {
            return (h) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public n c() {
        if (h()) {
            return (n) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public p d() {
        if (i()) {
            return (p) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String e() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean f() {
        return this instanceof h;
    }

    public boolean g() {
        return this instanceof m;
    }

    public boolean h() {
        return this instanceof n;
    }

    public boolean i() {
        return this instanceof p;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            y2.c cVar = new y2.c(stringWriter);
            cVar.c0(true);
            s2.m.b(this, cVar);
            return stringWriter.toString();
        } catch (IOException e6) {
            throw new AssertionError(e6);
        }
    }
}
