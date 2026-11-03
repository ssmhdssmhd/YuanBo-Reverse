package androidx.core.app;

import android.app.Notification;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.n;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
class h0 implements m {

    /* renamed from: a, reason: collision with root package name */
    private final Context f320a;

    /* renamed from: b, reason: collision with root package name */
    private final Notification.Builder f321b;

    /* renamed from: c, reason: collision with root package name */
    private final n.c f322c;

    /* renamed from: d, reason: collision with root package name */
    private RemoteViews f323d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f324e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Bundle> f325f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f326g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    private int f327h;

    /* renamed from: i, reason: collision with root package name */
    private RemoteViews f328i;

    h0(n.c cVar) {
        int i6;
        Notification.Builder badgeIconType;
        Notification.Builder settingsText;
        Notification.Builder shortcutId;
        Notification.Builder timeoutAfter;
        Icon icon;
        this.f322c = cVar;
        this.f320a = cVar.f368a;
        this.f321b = Build.VERSION.SDK_INT >= 26 ? new Notification.Builder(cVar.f368a, cVar.K) : new Notification.Builder(cVar.f368a);
        Notification notification = cVar.R;
        this.f321b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, cVar.f376i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(cVar.f372e).setContentText(cVar.f373f).setContentInfo(cVar.f378k).setContentIntent(cVar.f374g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(cVar.f375h, (notification.flags & 128) != 0).setLargeIcon(cVar.f377j).setNumber(cVar.f379l).setProgress(cVar.f387t, cVar.f388u, cVar.f389v);
        this.f321b.setSubText(cVar.f384q).setUsesChronometer(cVar.f382o).setPriority(cVar.f380m);
        Iterator<n.a> it = cVar.f369b.iterator();
        while (it.hasNext()) {
            b(it.next());
        }
        Bundle bundle = cVar.D;
        if (bundle != null) {
            this.f326g.putAll(bundle);
        }
        int i7 = Build.VERSION.SDK_INT;
        this.f323d = cVar.H;
        this.f324e = cVar.I;
        this.f321b.setShowWhen(cVar.f381n);
        this.f321b.setLocalOnly(cVar.f393z).setGroup(cVar.f390w).setGroupSummary(cVar.f391x).setSortKey(cVar.f392y);
        this.f327h = cVar.O;
        this.f321b.setCategory(cVar.C).setColor(cVar.E).setVisibility(cVar.F).setPublicVersion(cVar.G).setSound(notification.sound, notification.audioAttributes);
        List e6 = i7 < 28 ? e(f(cVar.f370c), cVar.U) : cVar.U;
        if (e6 != null && !e6.isEmpty()) {
            Iterator it2 = e6.iterator();
            while (it2.hasNext()) {
                this.f321b.addPerson((String) it2.next());
            }
        }
        this.f328i = cVar.J;
        if (cVar.f371d.size() > 0) {
            Bundle bundle2 = cVar.c().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i8 = 0; i8 < cVar.f371d.size(); i8++) {
                bundle4.putBundle(Integer.toString(i8), i0.a(cVar.f371d.get(i8)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            cVar.c().putBundle("android.car.EXTENSIONS", bundle2);
            this.f326g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i9 = Build.VERSION.SDK_INT;
        if (i9 >= 23 && (icon = cVar.T) != null) {
            this.f321b.setSmallIcon(icon);
        }
        if (i9 >= 24) {
            this.f321b.setExtras(cVar.D).setRemoteInputHistory(cVar.f386s);
            RemoteViews remoteViews = cVar.H;
            if (remoteViews != null) {
                this.f321b.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = cVar.I;
            if (remoteViews2 != null) {
                this.f321b.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = cVar.J;
            if (remoteViews3 != null) {
                this.f321b.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i9 >= 26) {
            badgeIconType = this.f321b.setBadgeIconType(cVar.L);
            settingsText = badgeIconType.setSettingsText(cVar.f385r);
            shortcutId = settingsText.setShortcutId(cVar.M);
            timeoutAfter = shortcutId.setTimeoutAfter(cVar.N);
            timeoutAfter.setGroupAlertBehavior(cVar.O);
            if (cVar.B) {
                this.f321b.setColorized(cVar.A);
            }
            if (!TextUtils.isEmpty(cVar.K)) {
                this.f321b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i9 >= 28) {
            Iterator<y0> it3 = cVar.f370c.iterator();
            while (it3.hasNext()) {
                this.f321b.addPerson(it3.next().h());
            }
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 29) {
            this.f321b.setAllowSystemGeneratedContextualActions(cVar.Q);
            this.f321b.setBubbleMetadata(n.b.a(null));
        }
        if (i10 >= 31 && (i6 = cVar.P) != 0) {
            this.f321b.setForegroundServiceBehavior(i6);
        }
        if (cVar.S) {
            if (this.f322c.f391x) {
                this.f327h = 2;
            } else {
                this.f327h = 1;
            }
            this.f321b.setVibrate(null);
            this.f321b.setSound(null);
            int i11 = notification.defaults & (-2) & (-3);
            notification.defaults = i11;
            this.f321b.setDefaults(i11);
            if (i10 >= 26) {
                if (TextUtils.isEmpty(this.f322c.f390w)) {
                    this.f321b.setGroup("silent");
                }
                this.f321b.setGroupAlertBehavior(this.f327h);
            }
        }
    }

    private void b(n.a aVar) {
        int i6 = Build.VERSION.SDK_INT;
        IconCompat d6 = aVar.d();
        Notification.Action.Builder builder = i6 >= 23 ? new Notification.Action.Builder(d6 != null ? d6.o() : null, aVar.h(), aVar.a()) : new Notification.Action.Builder(d6 != null ? d6.h() : 0, aVar.h(), aVar.a());
        if (aVar.e() != null) {
            for (RemoteInput remoteInput : z0.b(aVar.e())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            builder.setAllowGeneratedReplies(aVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", aVar.f());
        if (i7 >= 28) {
            builder.setSemanticAction(aVar.f());
        }
        if (i7 >= 29) {
            builder.setContextual(aVar.j());
        }
        if (i7 >= 31) {
            builder.setAuthenticationRequired(aVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", aVar.g());
        builder.addExtras(bundle);
        this.f321b.addAction(builder.build());
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        f.b bVar = new f.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List<String> f(List<y0> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<y0> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().g());
        }
        return arrayList;
    }

    private void g(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults = notification.defaults & (-2) & (-3);
    }

    @Override // androidx.core.app.m
    public Notification.Builder a() {
        return this.f321b;
    }

    public Notification c() {
        Bundle a6;
        RemoteViews f6;
        RemoteViews d6;
        n.d dVar = this.f322c.f383p;
        if (dVar != null) {
            dVar.b(this);
        }
        RemoteViews e6 = dVar != null ? dVar.e(this) : null;
        Notification d7 = d();
        if (e6 != null || (e6 = this.f322c.H) != null) {
            d7.contentView = e6;
        }
        if (dVar != null && (d6 = dVar.d(this)) != null) {
            d7.bigContentView = d6;
        }
        if (dVar != null && (f6 = this.f322c.f383p.f(this)) != null) {
            d7.headsUpContentView = f6;
        }
        if (dVar != null && (a6 = n.a(d7)) != null) {
            dVar.a(a6);
        }
        return d7;
    }

    protected Notification d() {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 26) {
            return this.f321b.build();
        }
        if (i6 >= 24) {
            Notification build = this.f321b.build();
            if (this.f327h != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f327h == 2) {
                    g(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f327h == 1) {
                    g(build);
                }
            }
            return build;
        }
        this.f321b.setExtras(this.f326g);
        Notification build2 = this.f321b.build();
        RemoteViews remoteViews = this.f323d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f324e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f328i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f327h != 0) {
            if (build2.getGroup() != null && (build2.flags & 512) != 0 && this.f327h == 2) {
                g(build2);
            }
            if (build2.getGroup() != null && (build2.flags & 512) == 0 && this.f327h == 1) {
                g(build2);
            }
        }
        return build2;
    }
}
