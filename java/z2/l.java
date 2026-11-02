package z2;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.util.Log;
import android.util.LongSparseArray;
import com.tendcloud.tenddata.ab;
import io.flutter.view.t;
import java.util.HashMap;
import java.util.Map;
import q3.a;
import y3.k;
import z2.e;

/* loaded from: classes.dex */
public final class l implements q3.a, r3.a, k.c {

    /* renamed from: j, reason: collision with root package name */
    public static final a f11291j = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private b f11294c;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, ? extends Object> f11296e;

    /* renamed from: f, reason: collision with root package name */
    private Activity f11297f;

    /* renamed from: g, reason: collision with root package name */
    private Handler f11298g;

    /* renamed from: h, reason: collision with root package name */
    private Runnable f11299h;

    /* renamed from: i, reason: collision with root package name */
    private s f11300i;

    /* renamed from: a, reason: collision with root package name */
    private final LongSparseArray<z2.e> f11292a = new LongSparseArray<>();

    /* renamed from: b, reason: collision with root package name */
    private final LongSparseArray<Map<String, Object>> f11293b = new LongSparseArray<>();

    /* renamed from: d, reason: collision with root package name */
    private long f11295d = -1;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f11301a;

        /* renamed from: b, reason: collision with root package name */
        private final y3.c f11302b;

        /* renamed from: c, reason: collision with root package name */
        private final d f11303c;

        /* renamed from: d, reason: collision with root package name */
        private final c f11304d;

        /* renamed from: e, reason: collision with root package name */
        private final io.flutter.view.t f11305e;

        /* renamed from: f, reason: collision with root package name */
        private final y3.k f11306f;

        public b(Context applicationContext, y3.c binaryMessenger, d keyForAsset, c keyForAssetAndPackageName, io.flutter.view.t tVar) {
            kotlin.jvm.internal.k.e(applicationContext, "applicationContext");
            kotlin.jvm.internal.k.e(binaryMessenger, "binaryMessenger");
            kotlin.jvm.internal.k.e(keyForAsset, "keyForAsset");
            kotlin.jvm.internal.k.e(keyForAssetAndPackageName, "keyForAssetAndPackageName");
            this.f11301a = applicationContext;
            this.f11302b = binaryMessenger;
            this.f11303c = keyForAsset;
            this.f11304d = keyForAssetAndPackageName;
            this.f11305e = tVar;
            this.f11306f = new y3.k(binaryMessenger, "better_player_channel");
        }

        public final Context a() {
            return this.f11301a;
        }

        public final y3.c b() {
            return this.f11302b;
        }

        public final d c() {
            return this.f11303c;
        }

        public final c d() {
            return this.f11304d;
        }

        public final io.flutter.view.t e() {
            return this.f11305e;
        }

        public final void f(l lVar) {
            this.f11306f.e(lVar);
        }

        public final void g() {
            this.f11306f.e(null);
        }
    }

    private interface c {
        String a(String str, String str2);
    }

    private interface d {
        String a(String str);
    }

    public static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o3.d f11307a;

        e(o3.d dVar) {
            this.f11307a = dVar;
        }

        @Override // z2.l.d
        public String a(String str) {
            o3.d dVar = this.f11307a;
            kotlin.jvm.internal.k.b(str);
            String h6 = dVar.h(str);
            kotlin.jvm.internal.k.d(h6, "loader.getLookupKeyForAs…t!!\n                    )");
            return h6;
        }
    }

    public static final class f implements c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o3.d f11308a;

        f(o3.d dVar) {
            this.f11308a = dVar;
        }

        @Override // z2.l.c
        public String a(String str, String str2) {
            o3.d dVar = this.f11308a;
            kotlin.jvm.internal.k.b(str);
            kotlin.jvm.internal.k.b(str2);
            String i6 = dVar.i(str, str2);
            kotlin.jvm.internal.k.d(i6, "loader.getLookupKeyForAs…e!!\n                    )");
            return i6;
        }
    }

    private final void h(k.d dVar) {
        e.a aVar = z2.e.f11250x;
        b bVar = this.f11294c;
        aVar.a(bVar != null ? bVar.a() : null, dVar);
    }

    private final void i(z2.e eVar) {
        x();
        Activity activity = this.f11297f;
        kotlin.jvm.internal.k.b(activity);
        activity.moveTaskToBack(false);
        eVar.C(false);
        eVar.x();
    }

    private final void k(z2.e eVar, long j6) {
        eVar.w();
        this.f11292a.remove(j6);
        this.f11293b.remove(j6);
        x();
    }

    private final void l() {
        int size = this.f11292a.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f11292a.valueAt(i6).w();
        }
        this.f11292a.clear();
        this.f11293b.clear();
    }

    private final void m(z2.e eVar) {
        PictureInPictureParams build;
        if (Build.VERSION.SDK_INT >= 26) {
            b bVar = this.f11294c;
            kotlin.jvm.internal.k.b(bVar);
            eVar.S(bVar.a());
            Activity activity = this.f11297f;
            kotlin.jvm.internal.k.b(activity);
            build = new PictureInPictureParams.Builder().build();
            activity.enterPictureInPictureMode(build);
            v(eVar);
            eVar.C(true);
        }
    }

    private final <T> T n(Map<String, ? extends Object> map, String str, T t5) {
        T t6;
        boolean z5 = false;
        if (map != null && map.containsKey(str)) {
            z5 = true;
        }
        return (!z5 || (t6 = (T) map.get(str)) == null) ? t5 : t6;
    }

    private final Long o(z2.e eVar) {
        int size = this.f11292a.size();
        for (int i6 = 0; i6 < size; i6++) {
            if (eVar == this.f11292a.valueAt(i6)) {
                return Long.valueOf(this.f11292a.keyAt(i6));
            }
        }
        return null;
    }

    private final boolean p() {
        Activity activity;
        if (Build.VERSION.SDK_INT >= 26 && (activity = this.f11297f) != null) {
            kotlin.jvm.internal.k.b(activity);
            if (activity.getPackageManager().hasSystemFeature("android.software.picture_in_picture")) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final void q(y3.j jVar, k.d dVar, long j6, z2.e eVar) {
        Object valueOf;
        String str = jVar.f11100a;
        if (str != null) {
            switch (str.hashCode()) {
                case -1904142125:
                    if (str.equals("setTrackParameters")) {
                        Object a6 = jVar.a("width");
                        kotlin.jvm.internal.k.b(a6);
                        int intValue = ((Number) a6).intValue();
                        Object a7 = jVar.a("height");
                        kotlin.jvm.internal.k.b(a7);
                        int intValue2 = ((Number) a7).intValue();
                        Object a8 = jVar.a("bitrate");
                        kotlin.jvm.internal.k.b(a8);
                        eVar.Q(intValue, intValue2, ((Number) a8).intValue());
                        dVar.b(null);
                        break;
                    }
                    break;
                case -1022740989:
                    if (str.equals("setMixWithOthers")) {
                        Boolean bool = (Boolean) jVar.a("mixWithOthers");
                        if (bool != null) {
                            eVar.O(bool.booleanValue());
                            break;
                        }
                    }
                    break;
                case -971364356:
                    if (str.equals("setLooping")) {
                        Object a9 = jVar.a("looping");
                        kotlin.jvm.internal.k.b(a9);
                        eVar.N(((Boolean) a9).booleanValue());
                        dVar.b(null);
                        break;
                    }
                    break;
                case -906224877:
                    if (str.equals("seekTo")) {
                        Number number = (Number) jVar.a("location");
                        kotlin.jvm.internal.k.b(number);
                        eVar.F(number.intValue());
                        dVar.b(null);
                        break;
                    }
                    break;
                case -651597783:
                    if (str.equals("isPictureInPictureSupported")) {
                        valueOf = Boolean.valueOf(p());
                        dVar.b(valueOf);
                        break;
                    }
                    break;
                case -547403682:
                    if (str.equals("enablePictureInPicture")) {
                        m(eVar);
                        dVar.b(null);
                        break;
                    }
                    break;
                case 3443508:
                    if (str.equals("play")) {
                        u(eVar);
                        eVar.E();
                        dVar.b(null);
                        break;
                    }
                    break;
                case 106440182:
                    if (str.equals("pause")) {
                        eVar.D();
                        dVar.b(null);
                        break;
                    }
                    break;
                case 670514716:
                    if (str.equals("setVolume")) {
                        Object a10 = jVar.a("volume");
                        kotlin.jvm.internal.k.b(a10);
                        eVar.R(((Number) a10).doubleValue());
                        dVar.b(null);
                        break;
                    }
                    break;
                case 747804969:
                    if (str.equals("position")) {
                        dVar.b(Long.valueOf(eVar.B()));
                        eVar.G(false);
                        break;
                    }
                    break;
                case 869456835:
                    if (str.equals("disablePictureInPicture")) {
                        i(eVar);
                        dVar.b(null);
                        break;
                    }
                    break;
                case 1404354821:
                    if (str.equals("setSpeed")) {
                        Object a11 = jVar.a("speed");
                        kotlin.jvm.internal.k.b(a11);
                        eVar.P(((Number) a11).doubleValue());
                        dVar.b(null);
                        break;
                    }
                    break;
                case 1671767583:
                    if (str.equals("dispose")) {
                        k(eVar, j6);
                        dVar.b(null);
                        break;
                    }
                    break;
                case 1748853351:
                    if (str.equals("setDataSource")) {
                        t(jVar, dVar, eVar);
                        break;
                    }
                    break;
                case 1809884096:
                    if (str.equals("absolutePosition")) {
                        valueOf = Long.valueOf(eVar.z());
                        dVar.b(valueOf);
                        break;
                    }
                    break;
                case 2015518999:
                    if (str.equals("setAudioTrack")) {
                        String str2 = (String) jVar.a("name");
                        Integer num = (Integer) jVar.a("index");
                        if (str2 != null && num != null) {
                            eVar.L(str2, num.intValue());
                        }
                        dVar.b(null);
                        break;
                    }
                    break;
            }
        }
        dVar.c();
    }

    private final void r(y3.j jVar, k.d dVar) {
        Map<String, ? extends Object> map = (Map) jVar.a("dataSource");
        if (map != null) {
            Number number = (Number) n(map, "maxCacheSize", Integer.valueOf(ab.L));
            Number number2 = (Number) n(map, "maxCacheFileSize", 10485760);
            long longValue = number.longValue();
            long longValue2 = number2.longValue();
            long longValue3 = ((Number) n(map, "preCacheSize", 3145728)).longValue();
            String str = (String) n(map, "uri", "");
            String str2 = (String) n(map, "cacheKey", null);
            Map<String, String> map2 = (Map) n(map, "headers", new HashMap());
            e.a aVar = z2.e.f11250x;
            b bVar = this.f11294c;
            aVar.c(bVar != null ? bVar.a() : null, str, longValue3, longValue, longValue2, map2, str2, dVar);
        }
    }

    private final void s() {
        int size = this.f11292a.size();
        for (int i6 = 0; i6 < size; i6++) {
            this.f11292a.valueAt(i6).y();
        }
    }

    private final void t(y3.j jVar, k.d dVar, z2.e eVar) {
        boolean booleanValue;
        long longValue;
        long longValue2;
        String str;
        String str2;
        String str3;
        String str4;
        boolean booleanValue2;
        String str5;
        Activity activity;
        long longValue3;
        Map<String, String> map;
        z2.e eVar2;
        Context context;
        String str6;
        String a6;
        Object a7 = jVar.a("dataSource");
        kotlin.jvm.internal.k.b(a7);
        Map<String, ? extends Object> map2 = (Map) a7;
        LongSparseArray<Map<String, Object>> longSparseArray = this.f11293b;
        Long o6 = o(eVar);
        kotlin.jvm.internal.k.b(o6);
        longSparseArray.put(o6.longValue(), map2);
        String str7 = (String) n(map2, "key", "");
        Map<String, String> map3 = (Map) n(map2, "headers", new HashMap());
        Number number = (Number) n(map2, "overriddenDuration", 0);
        if (map2.get("asset") != null) {
            String str8 = (String) n(map2, "asset", "");
            if (map2.get("package") != null) {
                String str9 = (String) n(map2, "package", "");
                b bVar = this.f11294c;
                kotlin.jvm.internal.k.b(bVar);
                a6 = bVar.d().a(str8, str9);
            } else {
                b bVar2 = this.f11294c;
                kotlin.jvm.internal.k.b(bVar2);
                a6 = bVar2.c().a(str8);
            }
            b bVar3 = this.f11294c;
            context = bVar3 != null ? bVar3.a() : null;
            kotlin.jvm.internal.k.b(context);
            activity = this.f11297f;
            str = "asset:///" + a6;
            str6 = null;
            booleanValue = false;
            longValue = 0;
            longValue2 = 0;
            longValue3 = number.longValue();
            str3 = null;
            map = null;
            str2 = null;
            str4 = null;
            booleanValue2 = false;
            str5 = null;
            eVar2 = eVar;
        } else {
            Boolean bool = Boolean.FALSE;
            booleanValue = ((Boolean) n(map2, "useCache", bool)).booleanValue();
            Number number2 = (Number) n(map2, "maxCacheSize", 0);
            Number number3 = (Number) n(map2, "maxCacheFileSize", 0);
            longValue = number2.longValue();
            longValue2 = number3.longValue();
            str = (String) n(map2, "uri", "");
            str2 = (String) n(map2, "cacheKey", null);
            String str10 = (String) n(map2, "formatHint", null);
            str3 = (String) n(map2, "licenseUrl", null);
            str4 = (String) n(map2, "clearKey", null);
            Map<String, String> map4 = (Map) n(map2, "drmHeaders", new HashMap());
            Map<String, String> map5 = (Map) n(map2, "licenseHeaders", new HashMap());
            booleanValue2 = ((Boolean) n(map2, "isOffline", bool)).booleanValue();
            str5 = (String) n(map2, "licenseId", null);
            Log.i("BetterPlayerPlugin", ">>> DATASOURCE: " + map2);
            b bVar4 = this.f11294c;
            kotlin.jvm.internal.k.b(bVar4);
            Context a8 = bVar4.a();
            activity = this.f11297f;
            longValue3 = number.longValue();
            map = booleanValue2 ? map5 : map4;
            eVar2 = eVar;
            context = a8;
            str6 = str10;
        }
        eVar2.M(context, activity, str7, str, str6, dVar, map3, booleanValue, longValue, longValue2, longValue3, str3, map, str2, str4, booleanValue2, str5);
    }

    private final void u(z2.e eVar) {
        Map<String, ? extends Object> map;
        try {
            Long o6 = o(eVar);
            if (o6 != null) {
                Map<String, ? extends Object> map2 = (Map) this.f11293b.get(o6.longValue());
                if (o6.longValue() != this.f11295d || (map = this.f11296e) == null || map2 == null || map != map2) {
                    this.f11296e = map2;
                    this.f11295d = o6.longValue();
                    s();
                    if (((Boolean) n(map2, "showNotification", Boolean.FALSE)).booleanValue()) {
                        String str = (String) n(map2, "title", "");
                        String str2 = (String) n(map2, "author", "");
                        String str3 = (String) n(map2, "imageUrl", "");
                        String str4 = (String) n(map2, "notificationChannelName", null);
                        String str5 = (String) n(map2, "activityName", "MainActivity");
                        b bVar = this.f11294c;
                        Context a6 = bVar != null ? bVar.a() : null;
                        kotlin.jvm.internal.k.b(a6);
                        eVar.T(a6, str, str2, str3, str4, str5);
                    }
                }
            }
        } catch (Exception e6) {
            Log.e("BetterPlayerPlugin", "SetupNotification failed", e6);
        }
    }

    private final void v(final z2.e eVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f11298g = new Handler(Looper.getMainLooper());
            this.f11299h = new Runnable() { // from class: z2.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.w(l.this, eVar);
                }
            };
            Handler handler = this.f11298g;
            kotlin.jvm.internal.k.b(handler);
            Runnable runnable = this.f11299h;
            kotlin.jvm.internal.k.b(runnable);
            handler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(l this$0, z2.e player) {
        boolean isInPictureInPictureMode;
        kotlin.jvm.internal.k.e(this$0, "this$0");
        kotlin.jvm.internal.k.e(player, "$player");
        Activity activity = this$0.f11297f;
        kotlin.jvm.internal.k.b(activity);
        isInPictureInPictureMode = activity.isInPictureInPictureMode();
        if (!isInPictureInPictureMode) {
            player.C(false);
            player.x();
            this$0.x();
        } else {
            Handler handler = this$0.f11298g;
            kotlin.jvm.internal.k.b(handler);
            Runnable runnable = this$0.f11299h;
            kotlin.jvm.internal.k.b(runnable);
            handler.postDelayed(runnable, 100L);
        }
    }

    private final void x() {
        Handler handler = this.f11298g;
        if (handler != null) {
            kotlin.jvm.internal.k.b(handler);
            handler.removeCallbacksAndMessages(null);
            this.f11298g = null;
        }
        this.f11299h = null;
    }

    private final void y(y3.j jVar, k.d dVar) {
        String str = (String) jVar.a("url");
        e.a aVar = z2.e.f11250x;
        b bVar = this.f11294c;
        aVar.d(bVar != null ? bVar.a() : null, str, dVar);
    }

    @Override // r3.a
    public void a(r3.c binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
    }

    @Override // q3.a
    public void b(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        o3.d dVar = new o3.d();
        Context a6 = binding.a();
        kotlin.jvm.internal.k.d(a6, "binding.applicationContext");
        y3.c b6 = binding.b();
        kotlin.jvm.internal.k.d(b6, "binding.binaryMessenger");
        b bVar = new b(a6, b6, new e(dVar), new f(dVar), binding.c());
        this.f11294c = bVar;
        bVar.f(this);
        b bVar2 = this.f11294c;
        kotlin.jvm.internal.k.b(bVar2);
        this.f11300i = new s(bVar2.a());
    }

    @Override // r3.a
    public void c() {
    }

    @Override // r3.a
    public void d(r3.c binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        this.f11297f = binding.d();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.content.Context, java.lang.Object] */
    @Override // y3.k.c
    public void e(y3.j call, k.d result) {
        String str;
        kotlin.jvm.internal.k.e(call, "call");
        kotlin.jvm.internal.k.e(result, "result");
        b bVar = this.f11294c;
        if (bVar != null) {
            if ((bVar != null ? bVar.e() : null) != null) {
                Log.d("BetterPlayerPlugin", "Call Method: " + call.f11100a);
                String str2 = call.f11100a;
                if (str2 != null) {
                    switch (str2.hashCode()) {
                        case -1352294148:
                            if (str2.equals("create")) {
                                b bVar2 = this.f11294c;
                                kotlin.jvm.internal.k.b(bVar2);
                                io.flutter.view.t e6 = bVar2.e();
                                kotlin.jvm.internal.k.b(e6);
                                t.c a6 = e6.a();
                                kotlin.jvm.internal.k.d(a6, "flutterState!!.textureRe…!!.createSurfaceTexture()");
                                b bVar3 = this.f11294c;
                                y3.d dVar = new y3.d(bVar3 != null ? bVar3.b() : null, "better_player_channel/videoEvents" + a6.e());
                                o oVar = (call.c("minBufferMs") && call.c("maxBufferMs") && call.c("bufferForPlaybackMs") && call.c("bufferForPlaybackAfterRebufferMs")) ? new o((Integer) call.a("minBufferMs"), (Integer) call.a("maxBufferMs"), (Integer) call.a("bufferForPlaybackMs"), (Integer) call.a("bufferForPlaybackAfterRebufferMs")) : null;
                                b bVar4 = this.f11294c;
                                ?? a7 = bVar4 != null ? bVar4.a() : null;
                                kotlin.jvm.internal.k.b(a7);
                                this.f11292a.put(a6.e(), new z2.e(a7, dVar, a6, oVar, result));
                                break;
                            }
                            break;
                        case -1321125217:
                            if (str2.equals("preCache")) {
                                r(call, result);
                                break;
                            }
                            break;
                        case -1266855969:
                            if (str2.equals("addOfflineLicense")) {
                                String str3 = (String) call.a("licenseId");
                                String str4 = (String) call.a("videoUrl");
                                String str5 = (String) call.a("licenseUrl");
                                Map<String, String> map = (Map) call.a("licenseHeaders");
                                if (str3 != null && str4 != null && str5 != null) {
                                    s sVar = this.f11300i;
                                    result.b(sVar != null ? sVar.b(str5, map, str4, str3) : null);
                                    break;
                                } else {
                                    str = "licenseId, videoUrl, or licenseUrl is NULL";
                                    result.a("E001", "Incomplete Parameters", str);
                                    break;
                                }
                            }
                            break;
                        case -759238347:
                            if (str2.equals("clearCache")) {
                                h(result);
                                break;
                            }
                            break;
                        case 3237136:
                            if (str2.equals("init")) {
                                l();
                                break;
                            }
                            break;
                        case 132875887:
                            if (str2.equals("getOfflineLicenseRemainingSec")) {
                                String str6 = (String) call.a("licenseId");
                                if (str6 != null) {
                                    s sVar2 = this.f11300i;
                                    if (sVar2 != null) {
                                        r1 = sVar2.f(str6);
                                    }
                                    result.b(r1);
                                    break;
                                }
                                result.a("E001", "Incomplete Parameters", "licenseId is NULL");
                                break;
                            }
                            break;
                        case 398525908:
                            if (str2.equals("getOfflineLicense")) {
                                String str7 = (String) call.a("licenseId");
                                if (str7 != null) {
                                    s sVar3 = this.f11300i;
                                    b3.a d6 = sVar3 != null ? sVar3.d(str7) : null;
                                    if (d6 != null) {
                                        result.b(d6.a());
                                        break;
                                    }
                                    result.b(r1);
                                    break;
                                }
                                result.a("E001", "Incomplete Parameters", "licenseId is NULL");
                                break;
                            }
                            break;
                        case 1333435494:
                            if (str2.equals("getExpiredOfflineLicenses")) {
                                Integer num = (Integer) call.a("days");
                                if (num == null) {
                                    str = "days is NULL";
                                    result.a("E001", "Incomplete Parameters", str);
                                    break;
                                } else {
                                    s sVar4 = this.f11300i;
                                    if (sVar4 != null) {
                                        r1 = sVar4.e(num.intValue());
                                    }
                                    result.b(r1);
                                    break;
                                }
                            }
                            break;
                        case 1347143298:
                            if (str2.equals("removeOfflineLicense")) {
                                String str8 = (String) call.a("licenseId");
                                if (str8 != null) {
                                    s sVar5 = this.f11300i;
                                    if (sVar5 != null) {
                                        r1 = Boolean.valueOf(sVar5.g(str8));
                                    }
                                    result.b(r1);
                                    break;
                                }
                                result.a("E001", "Incomplete Parameters", "licenseId is NULL");
                                break;
                            }
                            break;
                        case 1800570049:
                            if (str2.equals("stopPreCache")) {
                                y(call, result);
                                break;
                            }
                            break;
                    }
                    return;
                }
                Number number = (Number) call.a("textureId");
                kotlin.jvm.internal.k.b(number);
                long longValue = number.longValue();
                z2.e eVar = this.f11292a.get(longValue);
                kotlin.jvm.internal.k.d(eVar, "videoPlayers[textureId]");
                q(call, result, longValue, eVar);
                return;
            }
        }
        result.a("no_activity", "better_player plugin requires a foreground activity", null);
    }

    @Override // r3.a
    public void f() {
    }

    @Override // q3.a
    public void j(a.b binding) {
        kotlin.jvm.internal.k.e(binding, "binding");
        if (this.f11294c == null) {
            Log.wtf("BetterPlayerPlugin", "Detached from the engine before registering to it.");
        }
        l();
        g.b();
        b bVar = this.f11294c;
        if (bVar != null) {
            bVar.g();
        }
        this.f11294c = null;
    }
}
