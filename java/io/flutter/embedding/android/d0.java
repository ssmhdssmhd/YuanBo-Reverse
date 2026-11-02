package io.flutter.embedding.android;

import android.view.KeyEvent;
import io.flutter.embedding.android.e0;
import io.flutter.embedding.android.f0;
import io.flutter.embedding.android.z;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import y3.c;

/* loaded from: classes.dex */
public class d0 implements e0.d {

    /* renamed from: a, reason: collision with root package name */
    private final y3.c f5860a;

    /* renamed from: b, reason: collision with root package name */
    private final HashMap<Long, Long> f5861b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private final HashMap<Long, f0.e> f5862c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private final e0.b f5863d = new e0.b();

    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f5864a;

        static {
            int[] iArr = new int[z.a.values().length];
            f5864a = iArr;
            try {
                iArr[z.a.kDown.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5864a[z.a.kUp.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5864a[z.a.kRepeat.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public d0(y3.c cVar) {
        this.f5860a = cVar;
        for (f0.e eVar : f0.a()) {
            this.f5862c.put(Long.valueOf(eVar.f5901c), eVar);
        }
    }

    private static z.a e(KeyEvent keyEvent) {
        boolean z5 = keyEvent.getRepeatCount() > 0;
        int action = keyEvent.getAction();
        if (action == 0) {
            return z5 ? z.a.kRepeat : z.a.kDown;
        }
        if (action == 1) {
            return z.a.kUp;
        }
        throw new AssertionError("Unexpected event type");
    }

    private Long f(KeyEvent keyEvent) {
        Long l6 = f0.f5893b.get(Long.valueOf(keyEvent.getKeyCode()));
        return l6 != null ? l6 : Long.valueOf(i(keyEvent.getKeyCode(), 73014444032L));
    }

    private Long g(KeyEvent keyEvent) {
        int scanCode;
        long scanCode2 = keyEvent.getScanCode();
        if (scanCode2 == 0) {
            scanCode = keyEvent.getKeyCode();
        } else {
            Long l6 = f0.f5892a.get(Long.valueOf(scanCode2));
            if (l6 != null) {
                return l6;
            }
            scanCode = keyEvent.getScanCode();
        }
        return Long.valueOf(i(scanCode, 73014444032L));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0119 A[LOOP:2: B:52:0x0113->B:54:0x0119, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean h(android.view.KeyEvent r18, io.flutter.embedding.android.e0.d.a r19) {
        /*
            Method dump skipped, instructions count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.d0.h(android.view.KeyEvent, io.flutter.embedding.android.e0$d$a):boolean");
    }

    private static long i(long j6, long j7) {
        return (j6 & 4294967295L) | j7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(e0.d.a aVar, ByteBuffer byteBuffer) {
        Boolean bool = Boolean.FALSE;
        byteBuffer.rewind();
        if (byteBuffer.capacity() != 0) {
            bool = Boolean.valueOf(byteBuffer.get() != 0);
        }
        aVar.a(bool.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(f0.c cVar, long j6, KeyEvent keyEvent) {
        p(false, Long.valueOf(cVar.f5896b), Long.valueOf(j6), keyEvent.getEventTime());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(f0.c cVar, KeyEvent keyEvent) {
        p(false, Long.valueOf(cVar.f5896b), Long.valueOf(cVar.f5895a), keyEvent.getEventTime());
    }

    private void m(z zVar, final e0.d.a aVar) {
        this.f5860a.e("flutter/keydata", zVar.a(), aVar == null ? null : new c.b() { // from class: io.flutter.embedding.android.a0
            @Override // y3.c.b
            public final void a(ByteBuffer byteBuffer) {
                d0.j(e0.d.a.this, byteBuffer);
            }
        });
    }

    private void p(boolean z5, Long l6, Long l7, long j6) {
        z zVar = new z();
        zVar.f5980a = j6;
        zVar.f5981b = z5 ? z.a.kDown : z.a.kUp;
        zVar.f5983d = l6.longValue();
        zVar.f5982c = l7.longValue();
        zVar.f5985f = null;
        zVar.f5984e = true;
        if (l7.longValue() != 0 && l6.longValue() != 0) {
            if (!z5) {
                l6 = null;
            }
            q(l7, l6);
        }
        m(zVar, null);
    }

    @Override // io.flutter.embedding.android.e0.d
    public void a(KeyEvent keyEvent, e0.d.a aVar) {
        if (h(keyEvent, aVar)) {
            return;
        }
        p(true, 0L, 0L, 0L);
        aVar.a(true);
    }

    void n(f0.d dVar, boolean z5, long j6, final long j7, final KeyEvent keyEvent, ArrayList<Runnable> arrayList) {
        f0.c[] cVarArr = dVar.f5898b;
        boolean[] zArr = new boolean[cVarArr.length];
        Boolean[] boolArr = new Boolean[cVarArr.length];
        boolean z6 = false;
        int i6 = 0;
        while (true) {
            f0.c[] cVarArr2 = dVar.f5898b;
            boolean z7 = true;
            if (i6 >= cVarArr2.length) {
                break;
            }
            final f0.c cVar = cVarArr2[i6];
            boolean containsKey = this.f5861b.containsKey(Long.valueOf(cVar.f5895a));
            zArr[i6] = containsKey;
            if (cVar.f5896b == j6) {
                int i7 = a.f5864a[e(keyEvent).ordinal()];
                if (i7 == 1) {
                    boolArr[i6] = Boolean.FALSE;
                    if (!z5) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.b0
                            @Override // java.lang.Runnable
                            public final void run() {
                                d0.this.k(cVar, j7, keyEvent);
                            }
                        });
                    }
                } else if (i7 == 2) {
                    boolArr[i6] = Boolean.valueOf(zArr[i6]);
                } else if (i7 == 3) {
                    if (!z5) {
                        arrayList.add(new Runnable() { // from class: io.flutter.embedding.android.c0
                            @Override // java.lang.Runnable
                            public final void run() {
                                d0.this.l(cVar, keyEvent);
                            }
                        });
                    }
                    boolArr[i6] = Boolean.valueOf(zArr[i6]);
                }
                z6 = true;
            } else {
                if (!z6 && !containsKey) {
                    z7 = false;
                }
                z6 = z7;
            }
            i6++;
        }
        if (z5) {
            for (int i8 = 0; i8 < dVar.f5898b.length; i8++) {
                if (boolArr[i8] == null) {
                    if (z6) {
                        boolArr[i8] = Boolean.valueOf(zArr[i8]);
                    } else {
                        boolArr[i8] = Boolean.TRUE;
                        z6 = true;
                    }
                }
            }
            if (!z6) {
                boolArr[0] = Boolean.TRUE;
            }
        } else {
            for (int i9 = 0; i9 < dVar.f5898b.length; i9++) {
                if (boolArr[i9] == null) {
                    boolArr[i9] = Boolean.FALSE;
                }
            }
        }
        for (int i10 = 0; i10 < dVar.f5898b.length; i10++) {
            if (zArr[i10] != boolArr[i10].booleanValue()) {
                f0.c cVar2 = dVar.f5898b[i10];
                p(boolArr[i10].booleanValue(), Long.valueOf(cVar2.f5896b), Long.valueOf(cVar2.f5895a), keyEvent.getEventTime());
            }
        }
    }

    void o(f0.e eVar, boolean z5, long j6, KeyEvent keyEvent) {
        if (eVar.f5901c == j6 || eVar.f5902d == z5) {
            return;
        }
        boolean z6 = !this.f5861b.containsKey(Long.valueOf(eVar.f5900b));
        if (z6) {
            eVar.f5902d = !eVar.f5902d;
        }
        p(z6, Long.valueOf(eVar.f5901c), Long.valueOf(eVar.f5900b), keyEvent.getEventTime());
        if (!z6) {
            eVar.f5902d = !eVar.f5902d;
        }
        p(!z6, Long.valueOf(eVar.f5901c), Long.valueOf(eVar.f5900b), keyEvent.getEventTime());
    }

    void q(Long l6, Long l7) {
        if (l7 != null) {
            if (this.f5861b.put(l6, l7) != null) {
                throw new AssertionError("The key was not empty");
            }
        } else if (this.f5861b.remove(l6) == null) {
            throw new AssertionError("The key was empty");
        }
    }
}
