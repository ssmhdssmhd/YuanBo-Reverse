package g3;

import e3.d0;
import java.util.List;

/* loaded from: classes.dex */
public abstract class b implements e {
    private Boolean k(String str) {
        Object c6 = c(str);
        if (c6 instanceof Boolean) {
            return (Boolean) c6;
        }
        return null;
    }

    private String m() {
        return (String) c("sql");
    }

    private List<Object> n() {
        return (List) c("arguments");
    }

    @Override // g3.e
    public d0 d() {
        return new d0(m(), n());
    }

    @Override // g3.e
    public boolean e() {
        return Boolean.TRUE.equals(c("noResult"));
    }

    @Override // g3.e
    public Boolean f() {
        return k("inTransaction");
    }

    @Override // g3.e
    public Integer g() {
        return (Integer) c("transactionId");
    }

    @Override // g3.e
    public boolean h() {
        return j("transactionId") && g() == null;
    }

    public boolean l() {
        return Boolean.TRUE.equals(c("continueOnError"));
    }

    public String toString() {
        return "" + i() + " " + m() + " " + n();
    }
}
