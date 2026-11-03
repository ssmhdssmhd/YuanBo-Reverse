package androidx.core.app;

import a.a;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class k0 {

    /* renamed from: d, reason: collision with root package name */
    private static String f332d;

    /* renamed from: g, reason: collision with root package name */
    private static c f335g;

    /* renamed from: a, reason: collision with root package name */
    private final Context f336a;

    /* renamed from: b, reason: collision with root package name */
    private final NotificationManager f337b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f331c = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static Set<String> f333e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private static final Object f334f = new Object();

    private static class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final String f338a;

        /* renamed from: b, reason: collision with root package name */
        final int f339b;

        /* renamed from: c, reason: collision with root package name */
        final String f340c;

        /* renamed from: d, reason: collision with root package name */
        final Notification f341d;

        a(String str, int i6, String str2, Notification notification) {
            this.f338a = str;
            this.f339b = i6;
            this.f340c = str2;
            this.f341d = notification;
        }

        @Override // androidx.core.app.k0.d
        public void a(a.a aVar) {
            aVar.g0(this.f338a, this.f339b, this.f340c, this.f341d);
        }

        public String toString() {
            return "NotifyTask[packageName:" + this.f338a + ", id:" + this.f339b + ", tag:" + this.f340c + "]";
        }
    }

    private static class b {

        /* renamed from: a, reason: collision with root package name */
        final ComponentName f342a;

        /* renamed from: b, reason: collision with root package name */
        final IBinder f343b;

        b(ComponentName componentName, IBinder iBinder) {
            this.f342a = componentName;
            this.f343b = iBinder;
        }
    }

    private static class c implements Handler.Callback, ServiceConnection {

        /* renamed from: a, reason: collision with root package name */
        private final Context f344a;

        /* renamed from: b, reason: collision with root package name */
        private final HandlerThread f345b;

        /* renamed from: c, reason: collision with root package name */
        private final Handler f346c;

        /* renamed from: d, reason: collision with root package name */
        private final Map<ComponentName, a> f347d = new HashMap();

        /* renamed from: e, reason: collision with root package name */
        private Set<String> f348e = new HashSet();

        private static class a {

            /* renamed from: a, reason: collision with root package name */
            final ComponentName f349a;

            /* renamed from: c, reason: collision with root package name */
            a.a f351c;

            /* renamed from: b, reason: collision with root package name */
            boolean f350b = false;

            /* renamed from: d, reason: collision with root package name */
            ArrayDeque<d> f352d = new ArrayDeque<>();

            /* renamed from: e, reason: collision with root package name */
            int f353e = 0;

            a(ComponentName componentName) {
                this.f349a = componentName;
            }
        }

        c(Context context) {
            this.f344a = context;
            HandlerThread handlerThread = new HandlerThread("NotificationManagerCompat");
            this.f345b = handlerThread;
            handlerThread.start();
            this.f346c = new Handler(handlerThread.getLooper(), this);
        }

        private boolean a(a aVar) {
            if (aVar.f350b) {
                return true;
            }
            boolean bindService = this.f344a.bindService(new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(aVar.f349a), this, 33);
            aVar.f350b = bindService;
            if (bindService) {
                aVar.f353e = 0;
            } else {
                Log.w("NotifManCompat", "Unable to bind to listener " + aVar.f349a);
                this.f344a.unbindService(this);
            }
            return aVar.f350b;
        }

        private void b(a aVar) {
            if (aVar.f350b) {
                this.f344a.unbindService(this);
                aVar.f350b = false;
            }
            aVar.f351c = null;
        }

        private void c(d dVar) {
            j();
            for (a aVar : this.f347d.values()) {
                aVar.f352d.add(dVar);
                g(aVar);
            }
        }

        private void d(ComponentName componentName) {
            a aVar = this.f347d.get(componentName);
            if (aVar != null) {
                g(aVar);
            }
        }

        private void e(ComponentName componentName, IBinder iBinder) {
            a aVar = this.f347d.get(componentName);
            if (aVar != null) {
                aVar.f351c = a.AbstractBinderC0000a.p0(iBinder);
                aVar.f353e = 0;
                g(aVar);
            }
        }

        private void f(ComponentName componentName) {
            a aVar = this.f347d.get(componentName);
            if (aVar != null) {
                b(aVar);
            }
        }

        private void g(a aVar) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Processing component " + aVar.f349a + ", " + aVar.f352d.size() + " queued tasks");
            }
            if (aVar.f352d.isEmpty()) {
                return;
            }
            if (!a(aVar) || aVar.f351c == null) {
                i(aVar);
                return;
            }
            while (true) {
                d peek = aVar.f352d.peek();
                if (peek == null) {
                    break;
                }
                try {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Sending task " + peek);
                    }
                    peek.a(aVar.f351c);
                    aVar.f352d.remove();
                } catch (DeadObjectException unused) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Remote service has died: " + aVar.f349a);
                    }
                } catch (RemoteException e6) {
                    Log.w("NotifManCompat", "RemoteException communicating with " + aVar.f349a, e6);
                }
            }
            if (aVar.f352d.isEmpty()) {
                return;
            }
            i(aVar);
        }

        private void i(a aVar) {
            if (this.f346c.hasMessages(3, aVar.f349a)) {
                return;
            }
            int i6 = aVar.f353e + 1;
            aVar.f353e = i6;
            if (i6 <= 6) {
                int i7 = (1 << (i6 - 1)) * 1000;
                if (Log.isLoggable("NotifManCompat", 3)) {
                    Log.d("NotifManCompat", "Scheduling retry for " + i7 + " ms");
                }
                this.f346c.sendMessageDelayed(this.f346c.obtainMessage(3, aVar.f349a), i7);
                return;
            }
            Log.w("NotifManCompat", "Giving up on delivering " + aVar.f352d.size() + " tasks to " + aVar.f349a + " after " + aVar.f353e + " retries");
            aVar.f352d.clear();
        }

        private void j() {
            Set<String> e6 = k0.e(this.f344a);
            if (e6.equals(this.f348e)) {
                return;
            }
            this.f348e = e6;
            List<ResolveInfo> queryIntentServices = this.f344a.getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
            HashSet<ComponentName> hashSet = new HashSet();
            for (ResolveInfo resolveInfo : queryIntentServices) {
                if (e6.contains(resolveInfo.serviceInfo.packageName)) {
                    ServiceInfo serviceInfo = resolveInfo.serviceInfo;
                    ComponentName componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
                    if (resolveInfo.serviceInfo.permission != null) {
                        Log.w("NotifManCompat", "Permission present on component " + componentName + ", not adding listener record.");
                    } else {
                        hashSet.add(componentName);
                    }
                }
            }
            for (ComponentName componentName2 : hashSet) {
                if (!this.f347d.containsKey(componentName2)) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Adding listener record for " + componentName2);
                    }
                    this.f347d.put(componentName2, new a(componentName2));
                }
            }
            Iterator<Map.Entry<ComponentName, a>> it = this.f347d.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<ComponentName, a> next = it.next();
                if (!hashSet.contains(next.getKey())) {
                    if (Log.isLoggable("NotifManCompat", 3)) {
                        Log.d("NotifManCompat", "Removing listener record for " + next.getKey());
                    }
                    b(next.getValue());
                    it.remove();
                }
            }
        }

        public void h(d dVar) {
            this.f346c.obtainMessage(0, dVar).sendToTarget();
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i6 = message.what;
            if (i6 == 0) {
                c((d) message.obj);
                return true;
            }
            if (i6 == 1) {
                b bVar = (b) message.obj;
                e(bVar.f342a, bVar.f343b);
                return true;
            }
            if (i6 == 2) {
                f((ComponentName) message.obj);
                return true;
            }
            if (i6 != 3) {
                return false;
            }
            d((ComponentName) message.obj);
            return true;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Connected to service " + componentName);
            }
            this.f346c.obtainMessage(1, new b(componentName, iBinder)).sendToTarget();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            if (Log.isLoggable("NotifManCompat", 3)) {
                Log.d("NotifManCompat", "Disconnected from service " + componentName);
            }
            this.f346c.obtainMessage(2, componentName).sendToTarget();
        }
    }

    private interface d {
        void a(a.a aVar);
    }

    private k0(Context context) {
        this.f336a = context;
        this.f337b = (NotificationManager) context.getSystemService("notification");
    }

    public static k0 d(Context context) {
        return new k0(context);
    }

    public static Set<String> e(Context context) {
        Set<String> set;
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_notification_listeners");
        synchronized (f331c) {
            if (string != null) {
                if (!string.equals(f332d)) {
                    String[] split = string.split(":", -1);
                    HashSet hashSet = new HashSet(split.length);
                    for (String str : split) {
                        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
                        if (unflattenFromString != null) {
                            hashSet.add(unflattenFromString.getPackageName());
                        }
                    }
                    f333e = hashSet;
                    f332d = string;
                }
            }
            set = f333e;
        }
        return set;
    }

    private void h(d dVar) {
        synchronized (f334f) {
            if (f335g == null) {
                f335g = new c(this.f336a.getApplicationContext());
            }
            f335g.h(dVar);
        }
    }

    private static boolean i(Notification notification) {
        Bundle a6 = n.a(notification);
        return a6 != null && a6.getBoolean("android.support.useSideChannel");
    }

    public boolean a() {
        boolean areNotificationsEnabled;
        if (Build.VERSION.SDK_INT >= 24) {
            areNotificationsEnabled = this.f337b.areNotificationsEnabled();
            return areNotificationsEnabled;
        }
        AppOpsManager appOpsManager = (AppOpsManager) this.f336a.getSystemService("appops");
        ApplicationInfo applicationInfo = this.f336a.getApplicationInfo();
        String packageName = this.f336a.getApplicationContext().getPackageName();
        int i6 = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i6), packageName)).intValue() == 0;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException unused) {
            return true;
        }
    }

    public void b(int i6) {
        c(null, i6);
    }

    public void c(String str, int i6) {
        this.f337b.cancel(str, i6);
    }

    public void f(int i6, Notification notification) {
        g(null, i6, notification);
    }

    public void g(String str, int i6, Notification notification) {
        if (!i(notification)) {
            this.f337b.notify(str, i6, notification);
        } else {
            h(new a(this.f336a.getPackageName(), i6, str, notification));
            this.f337b.cancel(str, i6);
        }
    }
}
