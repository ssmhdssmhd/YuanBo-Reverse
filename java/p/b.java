package p;

import android.database.Cursor;
import android.database.MatrixCursor;

/* loaded from: classes.dex */
public class b {
    public static Cursor a(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i6 = 0; i6 < cursor.getColumnCount(); i6++) {
                    int type = cursor.getType(i6);
                    if (type == 0) {
                        objArr[i6] = null;
                    } else if (type == 1) {
                        objArr[i6] = Long.valueOf(cursor.getLong(i6));
                    } else if (type == 2) {
                        objArr[i6] = Double.valueOf(cursor.getDouble(i6));
                    } else if (type == 3) {
                        objArr[i6] = cursor.getString(i6);
                    } else {
                        if (type != 4) {
                            throw new IllegalStateException();
                        }
                        objArr[i6] = cursor.getBlob(i6);
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    public static int b(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndex("`" + str + "`");
    }

    public static int c(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }
}
