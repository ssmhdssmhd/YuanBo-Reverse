package j3;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import dev.fluttercommunity.plus.share.SharePlusPendingIntent;
import e4.e;
import e4.g;
import e4.q;
import f4.t;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.r;
import m4.j;
import v4.p;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final Context f6807a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f6808b;

    /* renamed from: c, reason: collision with root package name */
    private final dev.fluttercommunity.plus.share.a f6809c;

    /* renamed from: d, reason: collision with root package name */
    private final e f6810d;

    /* renamed from: e, reason: collision with root package name */
    private final e f6811e;

    static final class a extends l implements o4.a<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6812a = new a();

        a() {
            super(0);
        }

        @Override // o4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            return Integer.valueOf(Build.VERSION.SDK_INT >= 23 ? 33554432 : 0);
        }
    }

    static final class b extends l implements o4.a<String> {
        b() {
            super(0);
        }

        @Override // o4.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke() {
            return c.this.f().getPackageName() + ".flutter.share_provider";
        }
    }

    /* renamed from: j3.c$c, reason: collision with other inner class name */
    static final class C0098c extends l implements o4.a<q> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<String> f6814a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ r<String> f6815b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f6816c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0098c(List<String> list, r<String> rVar, c cVar) {
            super(0);
            this.f6814a = list;
            this.f6815b = rVar;
            this.f6816c = cVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v12, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v18 */
        /* JADX WARN: Type inference failed for: r0v19 */
        /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.Object] */
        public final void a() {
            int i6 = 1;
            if (this.f6814a.size() == 1) {
                this.f6815b.f7013a = t.u(this.f6814a);
                return;
            }
            if (this.f6814a.size() > 1) {
                T t5 = (String) t.u(this.f6814a);
                int g6 = f4.l.g(this.f6814a);
                String str = t5;
                if (1 <= g6) {
                    while (true) {
                        boolean a6 = k.a(str, this.f6814a.get(i6));
                        t5 = str;
                        if (!a6) {
                            if (!k.a(this.f6816c.h(str), this.f6816c.h(this.f6814a.get(i6)))) {
                                t5 = "*/*";
                                break;
                            }
                            t5 = this.f6816c.h(this.f6814a.get(i6)) + "/*";
                        }
                        if (i6 == g6) {
                            break;
                        }
                        i6++;
                        str = t5;
                    }
                }
                this.f6815b.f7013a = t5;
            }
        }

        @Override // o4.a
        public /* bridge */ /* synthetic */ q invoke() {
            a();
            return q.f3710a;
        }
    }

    public c(Context context, Activity activity, dev.fluttercommunity.plus.share.a manager) {
        e a6;
        e a7;
        k.e(context, "context");
        k.e(manager, "manager");
        this.f6807a = context;
        this.f6808b = activity;
        this.f6809c = manager;
        a6 = g.a(new b());
        this.f6810d = a6;
        a7 = g.a(a.f6812a);
        this.f6811e = a7;
    }

    private final void c() {
        File j6 = j();
        File[] files = j6.listFiles();
        if (j6.exists()) {
            boolean z5 = true;
            if (files != null) {
                if (!(files.length == 0)) {
                    z5 = false;
                }
            }
            if (z5) {
                return;
            }
            k.d(files, "files");
            for (File file : files) {
                file.delete();
            }
            j6.delete();
        }
    }

    private final File d(File file) {
        File j6 = j();
        if (!j6.exists()) {
            j6.mkdirs();
        }
        File file2 = new File(j6, file.getName());
        j.b(file, file2, true, 0, 4, null);
        return file2;
    }

    private final boolean e(File file) {
        try {
            String filePath = file.getCanonicalPath();
            k.d(filePath, "filePath");
            String canonicalPath = j().getCanonicalPath();
            k.d(canonicalPath, "shareCacheFolder.canonicalPath");
            return p.A(filePath, canonicalPath, false, 2, null);
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context f() {
        Activity activity = this.f6808b;
        if (activity == null) {
            return this.f6807a;
        }
        k.b(activity);
        return activity;
    }

    private final int g() {
        return ((Number) this.f6811e.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h(String str) {
        boolean F;
        if (str != null) {
            F = v4.q.F(str, "/", false, 2, null);
            if (F) {
                String substring = str.substring(0, v4.q.Q(str, "/", 0, false, 6, null));
                k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return "*";
    }

    private final String i() {
        return (String) this.f6810d.getValue();
    }

    private final File j() {
        return new File(f().getCacheDir(), "share_plus");
    }

    private final ArrayList<Uri> k(List<String> list) {
        ArrayList<Uri> arrayList = new ArrayList<>(list.size());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            File file = new File((String) it.next());
            if (e(file)) {
                throw new IOException("Shared file can not be located in '" + j().getCanonicalPath() + '\'');
            }
            arrayList.add(FileProvider.f(f(), i(), d(file)));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String l(List<String> list) {
        r rVar = new r();
        rVar.f7013a = "*/*";
        if (list != null) {
            new C0098c(list, rVar, this);
        }
        return (String) rVar.f7013a;
    }

    private final void p(Intent intent, boolean z5) {
        Activity activity = this.f6808b;
        if (activity == null) {
            intent.addFlags(268435456);
            if (z5) {
                this.f6809c.d();
            }
            this.f6807a.startActivity(intent);
            return;
        }
        k.b(activity);
        if (z5) {
            activity.startActivityForResult(intent, 22643);
        } else {
            activity.startActivity(intent);
        }
    }

    public final void m(Activity activity) {
        this.f6808b = activity;
    }

    public final void n(String text, String str, boolean z5) {
        k.e(text, "text");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", text);
        intent.putExtra("android.intent.extra.SUBJECT", str);
        Intent chooserIntent = z5 ? Intent.createChooser(intent, null, PendingIntent.getBroadcast(this.f6807a, 0, new Intent(this.f6807a, (Class<?>) SharePlusPendingIntent.class), 134217728 | g()).getIntentSender()) : Intent.createChooser(intent, null);
        k.d(chooserIntent, "chooserIntent");
        p(chooserIntent, z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void o(java.util.List<java.lang.String> r6, java.util.List<java.lang.String> r7, java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
            r5 = this;
            java.lang.String r0 = "paths"
            kotlin.jvm.internal.k.e(r6, r0)
            r5.c()
            java.util.ArrayList r6 = r5.k(r6)
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            boolean r1 = r6.isEmpty()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2b
            if (r8 == 0) goto L24
            boolean r1 = v4.g.p(r8)
            if (r1 == 0) goto L22
            goto L24
        L22:
            r1 = 0
            goto L25
        L24:
            r1 = 1
        L25:
            if (r1 != 0) goto L2b
            r5.n(r8, r9, r10)
            return
        L2b:
            int r1 = r6.size()
            java.lang.String r4 = "android.intent.extra.STREAM"
            if (r1 != r3) goto L5c
            if (r7 == 0) goto L3e
            boolean r1 = r7.isEmpty()
            if (r1 == 0) goto L3c
            goto L3e
        L3c:
            r1 = 0
            goto L3f
        L3e:
            r1 = 1
        L3f:
            if (r1 != 0) goto L48
            java.lang.Object r7 = f4.j.u(r7)
            java.lang.String r7 = (java.lang.String) r7
            goto L4a
        L48:
        */
        //  java.lang.String r7 = "*/*"
        /*
        L4a:
            java.lang.String r1 = "android.intent.action.SEND"
            r0.setAction(r1)
            r0.setType(r7)
            java.lang.Object r7 = f4.j.u(r6)
            android.os.Parcelable r7 = (android.os.Parcelable) r7
            r0.putExtra(r4, r7)
            goto L6b
        L5c:
            java.lang.String r1 = "android.intent.action.SEND_MULTIPLE"
            r0.setAction(r1)
            java.lang.String r7 = r5.l(r7)
            r0.setType(r7)
            r0.putParcelableArrayListExtra(r4, r6)
        L6b:
            if (r8 == 0) goto L72
            java.lang.String r7 = "android.intent.extra.TEXT"
            r0.putExtra(r7, r8)
        L72:
            if (r9 == 0) goto L79
            java.lang.String r7 = "android.intent.extra.SUBJECT"
            r0.putExtra(r7, r9)
        L79:
            r0.addFlags(r3)
            r7 = 0
            if (r10 == 0) goto L9e
            android.content.Context r8 = r5.f6807a
            android.content.Intent r9 = new android.content.Intent
            android.content.Context r1 = r5.f6807a
            java.lang.Class<dev.fluttercommunity.plus.share.SharePlusPendingIntent> r3 = dev.fluttercommunity.plus.share.SharePlusPendingIntent.class
            r9.<init>(r1, r3)
            r1 = 134217728(0x8000000, float:3.85186E-34)
            int r3 = r5.g()
            r1 = r1 | r3
            android.app.PendingIntent r8 = android.app.PendingIntent.getBroadcast(r8, r2, r9, r1)
            android.content.IntentSender r8 = r8.getIntentSender()
            android.content.Intent r7 = j3.b.a(r0, r7, r8)
            goto La2
        L9e:
            android.content.Intent r7 = android.content.Intent.createChooser(r0, r7)
        La2:
            android.content.Context r8 = r5.f()
            android.content.pm.PackageManager r8 = r8.getPackageManager()
            r9 = 65536(0x10000, float:9.1835E-41)
            java.util.List r8 = r8.queryIntentActivities(r7, r9)
            java.lang.String r9 = "getContext().packageMana…CH_DEFAULT_ONLY\n        )"
            kotlin.jvm.internal.k.d(r8, r9)
            java.util.Iterator r8 = r8.iterator()
        Lb9:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto Le2
            java.lang.Object r9 = r8.next()
            android.content.pm.ResolveInfo r9 = (android.content.pm.ResolveInfo) r9
            android.content.pm.ActivityInfo r9 = r9.activityInfo
            java.lang.String r9 = r9.packageName
            java.util.Iterator r0 = r6.iterator()
        Lcd:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb9
            java.lang.Object r1 = r0.next()
            android.net.Uri r1 = (android.net.Uri) r1
            android.content.Context r2 = r5.f()
            r3 = 3
            r2.grantUriPermission(r9, r1, r3)
            goto Lcd
        Le2:
            java.lang.String r6 = "chooserIntent"
            kotlin.jvm.internal.k.d(r7, r6)
            r5.p(r7, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.c.o(java.util.List, java.util.List, java.lang.String, java.lang.String, boolean):void");
    }
}
