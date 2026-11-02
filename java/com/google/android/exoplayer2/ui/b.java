package com.google.android.exoplayer2.ui;

import android.graphics.Color;
import i2.c1;

/* loaded from: classes.dex */
final class b {
    public static String a(String str) {
        return "." + str + ",." + str + " *";
    }

    public static String b(int i6) {
        return c1.C("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i6)), Integer.valueOf(Color.green(i6)), Integer.valueOf(Color.blue(i6)), Double.valueOf(Color.alpha(i6) / 255.0d));
    }
}
