package dev.fluttercommunity.plus.share;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class SharePlusPendingIntent extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final a f3302a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static String f3303b = "";

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final String a() {
            return SharePlusPendingIntent.f3303b;
        }

        public final void b(String str) {
            k.e(str, "<set-?>");
            SharePlusPendingIntent.f3303b = str;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        k.e(context, "context");
        k.e(intent, "intent");
        ComponentName componentName = (ComponentName) (Build.VERSION.SDK_INT >= 33 ? intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT", ComponentName.class) : intent.getParcelableExtra("android.intent.extra.CHOSEN_COMPONENT"));
        if (componentName != null) {
            String flattenToString = componentName.flattenToString();
            k.d(flattenToString, "chosenComponent.flattenToString()");
            f3303b = flattenToString;
        }
    }
}
