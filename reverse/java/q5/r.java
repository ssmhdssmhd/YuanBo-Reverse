package q5;

import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class r extends f4.b<h> implements RandomAccess {

    /* renamed from: d, reason: collision with root package name */
    public static final a f8978d = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final h[] f8979b;

    /* renamed from: c, reason: collision with root package name */
    private final int[] f8980c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final void a(long j6, e eVar, int i6, List<? extends h> list, int i7, int i8, List<Integer> list2) {
            int i9;
            int i10;
            int i11;
            int i12;
            e eVar2;
            int i13 = i6;
            if (!(i7 < i8)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i14 = i7; i14 < i8; i14++) {
                if (!(list.get(i14).r() >= i13)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            h hVar = list.get(i7);
            h hVar2 = list.get(i8 - 1);
            if (i13 == hVar.r()) {
                int intValue = list2.get(i7).intValue();
                int i15 = i7 + 1;
                h hVar3 = list.get(i15);
                i9 = i15;
                i10 = intValue;
                hVar = hVar3;
            } else {
                i9 = i7;
                i10 = -1;
            }
            if (hVar.d(i13) == hVar2.d(i13)) {
                int min = Math.min(hVar.r(), hVar2.r());
                int i16 = 0;
                for (int i17 = i13; i17 < min && hVar.d(i17) == hVar2.d(i17); i17++) {
                    i16++;
                }
                long c6 = j6 + c(eVar) + 2 + i16 + 1;
                eVar.writeInt(-i16);
                eVar.writeInt(i10);
                int i18 = i13 + i16;
                while (i13 < i18) {
                    eVar.writeInt(hVar.d(i13) & 255);
                    i13++;
                }
                if (i9 + 1 == i8) {
                    if (!(i18 == list.get(i9).r())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    eVar.writeInt(list2.get(i9).intValue());
                    return;
                } else {
                    e eVar3 = new e();
                    eVar.writeInt(((int) (c(eVar3) + c6)) * (-1));
                    a(c6, eVar3, i18, list, i9, i8, list2);
                    eVar.g0(eVar3);
                    return;
                }
            }
            int i19 = 1;
            for (int i20 = i9 + 1; i20 < i8; i20++) {
                if (list.get(i20 - 1).d(i13) != list.get(i20).d(i13)) {
                    i19++;
                }
            }
            long c7 = j6 + c(eVar) + 2 + (i19 * 2);
            eVar.writeInt(i19);
            eVar.writeInt(i10);
            for (int i21 = i9; i21 < i8; i21++) {
                byte d6 = list.get(i21).d(i13);
                if (i21 == i9 || d6 != list.get(i21 - 1).d(i13)) {
                    eVar.writeInt(d6 & 255);
                }
            }
            e eVar4 = new e();
            while (i9 < i8) {
                byte d7 = list.get(i9).d(i13);
                int i22 = i9 + 1;
                int i23 = i22;
                while (true) {
                    if (i23 >= i8) {
                        i11 = i8;
                        break;
                    } else {
                        if (d7 != list.get(i23).d(i13)) {
                            i11 = i23;
                            break;
                        }
                        i23++;
                    }
                }
                if (i22 == i11 && i13 + 1 == list.get(i9).r()) {
                    eVar.writeInt(list2.get(i9).intValue());
                    i12 = i11;
                    eVar2 = eVar4;
                } else {
                    eVar.writeInt(((int) (c7 + c(eVar4))) * (-1));
                    i12 = i11;
                    eVar2 = eVar4;
                    a(c7, eVar4, i13 + 1, list, i9, i11, list2);
                }
                eVar4 = eVar2;
                i9 = i12;
            }
            eVar.g0(eVar4);
        }

        static /* synthetic */ void b(a aVar, long j6, e eVar, int i6, List list, int i7, int i8, List list2, int i9, Object obj) {
            aVar.a((i9 & 1) != 0 ? 0L : j6, eVar, (i9 & 4) != 0 ? 0 : i6, list, (i9 & 16) != 0 ? 0 : i7, (i9 & 32) != 0 ? list.size() : i8, list2);
        }

        private final long c(e eVar) {
            return eVar.size() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x00ee, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final q5.r d(q5.h... r17) {
            /*
                Method dump skipped, instructions count: 336
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: q5.r.a.d(q5.h[]):q5.r");
        }
    }

    private r(h[] hVarArr, int[] iArr) {
        this.f8979b = hVarArr;
        this.f8980c = iArr;
    }

    public /* synthetic */ r(h[] hVarArr, int[] iArr, kotlin.jvm.internal.g gVar) {
        this(hVarArr, iArr);
    }

    @Override // f4.a
    public int b() {
        return this.f8979b.length;
    }

    public /* bridge */ boolean c(h hVar) {
        return super.contains(hVar);
    }

    @Override // f4.a, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof h) {
            return c((h) obj);
        }
        return false;
    }

    @Override // f4.b, java.util.List
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public h get(int i6) {
        return this.f8979b[i6];
    }

    public /* bridge */ int e(h hVar) {
        return super.indexOf(hVar);
    }

    public /* bridge */ int f(h hVar) {
        return super.lastIndexOf(hVar);
    }

    @Override // f4.b, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof h) {
            return e((h) obj);
        }
        return -1;
    }

    @Override // f4.b, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof h) {
            return f((h) obj);
        }
        return -1;
    }
}
