package com.tendcloud.tenddata;

import android.text.TextUtils;
import com.tendcloud.tenddata.n;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class aw {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2321a = "Archimedes_p";

    /* renamed from: b, reason: collision with root package name */
    private static final int f2322b = 1000000000;

    static int a() {
        try {
            n.b bVar = n.b.AES_DATA_LOCK;
            n.getFileLock(bVar.toString());
            int a6 = at.a(b());
            if (a6 == 0) {
                a6 = y.b().nextInt(f2322b);
                a(a6);
            }
            n.releaseFileLock(bVar.toString());
            return a6;
        } catch (Throwable unused) {
            n.releaseFileLock(n.b.AES_DATA_LOCK.toString());
            return 0;
        }
    }

    private static void a(int i6) {
        int i7;
        int i8;
        int i9;
        ArrayList arrayList = new ArrayList(16);
        int i10 = 0;
        do {
            int[] iArr = new int[3];
            int[] iArr2 = new int[7];
            int[] iArr3 = new int[7];
            SecureRandom b6 = y.b();
            for (int i11 = 0; i11 < 3; i11++) {
                iArr[i11] = b6.nextInt(1000);
            }
            for (int i12 = 0; i12 < 7; i12++) {
                iArr2[i12] = b6.nextInt(100);
            }
            int i13 = 0;
            while (true) {
                i7 = 1;
                if (i13 >= 7) {
                    break;
                }
                int i14 = iArr[0];
                int i15 = iArr2[i13];
                iArr3[i13] = (i14 * i15 * i15 * i15) + (iArr[1] * i15 * i15) + (iArr[2] * i15) + i6;
                arrayList.add(iArr2[i13] + "," + iArr3[i13] + ",");
                i13++;
            }
            if (a(arrayList, i6)) {
                break;
            }
            arrayList.clear();
            i10++;
        } while (i10 < 7);
        while (true) {
            i8 = 4;
            if (i7 >= 4) {
                break;
            }
            av.a(f2321a + i7, (String) arrayList.get(i7 - 1));
            i7++;
        }
        while (true) {
            if (i8 >= 6) {
                break;
            }
            av.b(f2321a + i8, (String) arrayList.get(i8 - 1));
            i8++;
        }
        for (i9 = 6; i9 < 8; i9++) {
            av.c(ab.f2233g.getPackageName() + i9, (String) arrayList.get(i9 - 1));
        }
    }

    private static boolean a(ArrayList<String> arrayList, int i6) {
        String str = "";
        for (int i7 = 0; i7 < 4; i7++) {
            try {
                str = str.concat(arrayList.get(i7));
            } catch (Throwable unused) {
                return false;
            }
        }
        return i6 == at.a(a(str, 4, 2));
    }

    private static int[][] a(String str, int i6, int i7) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i6, i7);
        String[] split = str.split(",");
        int i8 = 0;
        for (int i9 = 0; i9 < i6; i9++) {
            for (int i10 = 0; i10 < i7; i10++) {
                iArr[i9][i10] = Integer.parseInt(split[i8]);
                i8++;
            }
        }
        return iArr;
    }

    private static int[][] b() {
        int i6;
        try {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int i7 = 0;
            for (int i8 = 1; i8 < 4; i8++) {
                String a6 = av.a(f2321a + i8);
                if (!TextUtils.isEmpty(a6)) {
                    arrayList.add(a6);
                    i7++;
                }
            }
            int i9 = 4;
            while (true) {
                if (i9 >= 6) {
                    break;
                }
                String b6 = av.b(f2321a + i9);
                if (!TextUtils.isEmpty(b6)) {
                    arrayList.add(b6);
                    i7++;
                }
                i9++;
            }
            if (i7 < 4) {
                for (i6 = 6; i6 < 8; i6++) {
                    String c6 = av.c(ab.f2233g.getPackageName() + i6);
                    if (!TextUtils.isEmpty(c6)) {
                        arrayList.add(c6);
                    }
                }
            }
            if (arrayList.size() < 4) {
                return null;
            }
            for (int i10 = 0; i10 < 4; i10++) {
                sb.append((String) arrayList.get(i10));
            }
            return a(sb.toString(), 4, 2);
        } catch (Throwable unused) {
            return null;
        }
    }
}
