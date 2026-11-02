package e3;

import android.database.Cursor;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class e0 {
    public static List<Object> a(Cursor cursor, int i6) {
        String str;
        ArrayList arrayList = new ArrayList(i6);
        for (int i7 = 0; i7 < i6; i7++) {
            Object b6 = b(cursor, i7);
            if (f3.a.f3890c) {
                if (b6 == null) {
                    str = null;
                } else if (b6.getClass().isArray()) {
                    str = "array(" + b6.getClass().getComponentType().getName() + ")";
                } else {
                    str = b6.getClass().getName();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i7);
                sb.append(" ");
                sb.append(cursor.getType(i7));
                sb.append(": ");
                sb.append(b6);
                sb.append(str == null ? "" : " (" + str + ")");
                Log.d("Sqflite", sb.toString());
            }
            arrayList.add(b6);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i6) {
        int type = cursor.getType(i6);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i6));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i6));
        }
        if (type == 3) {
            return cursor.getString(i6);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i6);
    }

    static Locale c(String str) {
        return Locale.forLanguageTag(str);
    }

    static Locale d(String str) {
        return c(str);
    }
}
