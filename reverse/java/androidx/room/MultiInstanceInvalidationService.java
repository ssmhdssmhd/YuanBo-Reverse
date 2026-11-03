package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.c;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationService extends Service {

    /* renamed from: a, reason: collision with root package name */
    int f1288a = 0;

    /* renamed from: b, reason: collision with root package name */
    final HashMap<Integer, String> f1289b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    final RemoteCallbackList<androidx.room.b> f1290c = new a();

    /* renamed from: d, reason: collision with root package name */
    private final c.a f1291d = new b();

    class a extends RemoteCallbackList<androidx.room.b> {
        a() {
        }

        @Override // android.os.RemoteCallbackList
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onCallbackDied(androidx.room.b bVar, Object obj) {
            MultiInstanceInvalidationService.this.f1289b.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    }

    class b extends c.a {
        b() {
        }

        @Override // androidx.room.c
        public int Q(androidx.room.b bVar, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.f1290c) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i6 = multiInstanceInvalidationService.f1288a + 1;
                multiInstanceInvalidationService.f1288a = i6;
                if (multiInstanceInvalidationService.f1290c.register(bVar, Integer.valueOf(i6))) {
                    MultiInstanceInvalidationService.this.f1289b.put(Integer.valueOf(i6), str);
                    return i6;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.f1288a--;
                return 0;
            }
        }

        @Override // androidx.room.c
        public void e0(int i6, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.f1290c) {
                String str = MultiInstanceInvalidationService.this.f1289b.get(Integer.valueOf(i6));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.f1290c.beginBroadcast();
                for (int i7 = 0; i7 < beginBroadcast; i7++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.f1290c.getBroadcastCookie(i7)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.f1289b.get(Integer.valueOf(intValue));
                        if (i6 != intValue && str.equals(str2)) {
                            try {
                                MultiInstanceInvalidationService.this.f1290c.getBroadcastItem(i7).a(strArr);
                            } catch (RemoteException e6) {
                                Log.w("ROOM", "Error invoking a remote callback", e6);
                            }
                        }
                    } finally {
                        MultiInstanceInvalidationService.this.f1290c.finishBroadcast();
                    }
                }
            }
        }

        @Override // androidx.room.c
        public void i0(androidx.room.b bVar, int i6) {
            synchronized (MultiInstanceInvalidationService.this.f1290c) {
                MultiInstanceInvalidationService.this.f1290c.unregister(bVar);
                MultiInstanceInvalidationService.this.f1289b.remove(Integer.valueOf(i6));
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f1291d;
    }
}
