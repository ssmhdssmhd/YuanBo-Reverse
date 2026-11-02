package e3;

import android.database.sqlite.SQLiteProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3628a;

    /* renamed from: b, reason: collision with root package name */
    private final List<Object> f3629b;

    public d0(String str, List<Object> list) {
        this.f3628a = str;
        this.f3629b = list == null ? new ArrayList<>() : list;
    }

    private Object[] e(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator<Object> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(f(it.next()));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    private static Object f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            bArr[i6] = (byte) ((Integer) list.get(i6)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        long j6;
        List<Object> list = this.f3629b;
        if (list != null) {
            int size = list.size();
            int i6 = 0;
            while (i6 < size) {
                Object f6 = f(this.f3629b.get(i6));
                int i7 = i6 + 1;
                if (f6 == null) {
                    sQLiteProgram.bindNull(i7);
                } else if (f6 instanceof byte[]) {
                    sQLiteProgram.bindBlob(i7, (byte[]) f6);
                } else if (f6 instanceof Double) {
                    sQLiteProgram.bindDouble(i7, ((Double) f6).doubleValue());
                } else {
                    if (f6 instanceof Integer) {
                        j6 = ((Integer) f6).intValue();
                    } else if (f6 instanceof Long) {
                        j6 = ((Long) f6).longValue();
                    } else if (f6 instanceof String) {
                        sQLiteProgram.bindString(i7, (String) f6);
                    } else {
                        if (!(f6 instanceof Boolean)) {
                            throw new IllegalArgumentException("Could not bind " + f6 + " from index " + i6 + ": Supported types are null, byte[], double, long, boolean and String");
                        }
                        j6 = ((Boolean) f6).booleanValue() ? 1L : 0L;
                    }
                    sQLiteProgram.bindLong(i7, j6);
                }
                i6 = i7;
            }
        }
    }

    public List<Object> b() {
        return this.f3629b;
    }

    public String c() {
        return this.f3628a;
    }

    public Object[] d() {
        return e(this.f3629b);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        String str = this.f3628a;
        if (str != null) {
            if (!str.equals(d0Var.f3628a)) {
                return false;
            }
        } else if (d0Var.f3628a != null) {
            return false;
        }
        if (this.f3629b.size() != d0Var.f3629b.size()) {
            return false;
        }
        for (int i6 = 0; i6 < this.f3629b.size(); i6++) {
            if ((this.f3629b.get(i6) instanceof byte[]) && (d0Var.f3629b.get(i6) instanceof byte[])) {
                if (!Arrays.equals((byte[]) this.f3629b.get(i6), (byte[]) d0Var.f3629b.get(i6))) {
                    return false;
                }
            } else if (!this.f3629b.get(i6).equals(d0Var.f3629b.get(i6))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f3628a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3628a);
        List<Object> list = this.f3629b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + this.f3629b;
        }
        sb.append(str);
        return sb.toString();
    }
}
