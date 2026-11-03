package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* loaded from: classes.dex */
class g {

    /* renamed from: a, reason: collision with root package name */
    final a f1266a;

    interface a {
        void a(a.b bVar);

        a.b b(int i6, int i7, int i8, Object obj);
    }

    g(a aVar) {
        this.f1266a = aVar;
    }

    private int a(List<a.b> list) {
        boolean z5 = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f1154a != 8) {
                z5 = true;
            } else if (z5) {
                return size;
            }
        }
        return -1;
    }

    private void c(List<a.b> list, int i6, a.b bVar, int i7, a.b bVar2) {
        int i8 = bVar.f1157d;
        int i9 = bVar2.f1155b;
        int i10 = i8 < i9 ? -1 : 0;
        int i11 = bVar.f1155b;
        if (i11 < i9) {
            i10++;
        }
        if (i9 <= i11) {
            bVar.f1155b = i11 + bVar2.f1157d;
        }
        int i12 = bVar2.f1155b;
        if (i12 <= i8) {
            bVar.f1157d = i8 + bVar2.f1157d;
        }
        bVar2.f1155b = i12 + i10;
        list.set(i6, bVar2);
        list.set(i7, bVar);
    }

    private void d(List<a.b> list, int i6, int i7) {
        a.b bVar = list.get(i6);
        a.b bVar2 = list.get(i7);
        int i8 = bVar2.f1154a;
        if (i8 == 1) {
            c(list, i6, bVar, i7, bVar2);
        } else if (i8 == 2) {
            e(list, i6, bVar, i7, bVar2);
        } else {
            if (i8 != 4) {
                return;
            }
            f(list, i6, bVar, i7, bVar2);
        }
    }

    void b(List<a.b> list) {
        while (true) {
            int a6 = a(list);
            if (a6 == -1) {
                return;
            } else {
                d(list, a6, a6 + 1);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009d, code lost:
    
        if (r0 > r14.f1155b) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c9, code lost:
    
        r12.f1157d = r0 - r14.f1157d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00c7, code lost:
    
        if (r0 >= r14.f1155b) goto L60;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void e(java.util.List<androidx.recyclerview.widget.a.b> r10, int r11, androidx.recyclerview.widget.a.b r12, int r13, androidx.recyclerview.widget.a.b r14) {
        /*
            Method dump skipped, instructions count: 228
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.g.e(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void f(java.util.List<androidx.recyclerview.widget.a.b> r9, int r10, androidx.recyclerview.widget.a.b r11, int r12, androidx.recyclerview.widget.a.b r13) {
        /*
            r8 = this;
            int r0 = r11.f1157d
            int r1 = r13.f1155b
            r2 = 4
            r3 = 1
            r4 = 0
            if (r0 >= r1) goto Ld
            int r1 = r1 - r3
            r13.f1155b = r1
            goto L20
        Ld:
            int r5 = r13.f1157d
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r3
            r13.f1157d = r5
            androidx.recyclerview.widget.g$a r0 = r8.f1266a
            int r1 = r11.f1155b
            java.lang.Object r5 = r13.f1156c
            androidx.recyclerview.widget.a$b r0 = r0.b(r2, r1, r3, r5)
            goto L21
        L20:
            r0 = r4
        L21:
            int r1 = r11.f1155b
            int r5 = r13.f1155b
            if (r1 > r5) goto L2b
            int r5 = r5 + r3
            r13.f1155b = r5
            goto L41
        L2b:
            int r6 = r13.f1157d
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            androidx.recyclerview.widget.g$a r4 = r8.f1266a
            int r1 = r1 + r3
            java.lang.Object r3 = r13.f1156c
            androidx.recyclerview.widget.a$b r4 = r4.b(r2, r1, r5, r3)
            int r1 = r13.f1157d
            int r1 = r1 - r5
            r13.f1157d = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.f1157d
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            androidx.recyclerview.widget.g$a r11 = r8.f1266a
            r11.a(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r4 == 0) goto L5e
            r9.add(r10, r4)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.g.f(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
