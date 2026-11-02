package com.tendcloud.tenddata;

import java.text.DecimalFormat;

/* loaded from: classes.dex */
final class at {
    at() {
    }

    private static int a(double d6) {
        try {
            return Integer.parseInt(new DecimalFormat("######0").format(d6));
        } catch (Throwable th) {
            bq.postSDKError(th);
            return 0;
        }
    }

    private static int a(double[][] dArr) {
        double[] dArr2 = dArr[0];
        double[] dArr3 = {dArr2[0], dArr2[1], dArr2[2], dArr2[3]};
        double[] dArr4 = dArr[1];
        double[] dArr5 = {dArr4[0], dArr4[1], dArr4[2], dArr4[3]};
        double[] dArr6 = dArr[2];
        double[] dArr7 = {dArr6[0], dArr6[1], dArr6[2], dArr6[3]};
        double[] dArr8 = dArr[3];
        double[][] dArr9 = {dArr3, dArr5, dArr7, new double[]{dArr8[0], dArr8[1], dArr8[2], dArr8[3]}};
        double[] dArr10 = dArr[0];
        double[] dArr11 = {dArr10[0], dArr10[1], dArr10[2], dArr10[4]};
        double[] dArr12 = dArr[1];
        double[] dArr13 = {dArr12[0], dArr12[1], dArr12[2], dArr12[4]};
        double[] dArr14 = dArr[2];
        double[] dArr15 = {dArr14[0], dArr14[1], dArr14[2], dArr14[4]};
        double[] dArr16 = dArr[3];
        double[][] dArr17 = {dArr11, dArr13, dArr15, new double[]{dArr16[0], dArr16[1], dArr16[2], dArr16[4]}};
        double b6 = b(dArr9);
        if (b6 == 0.0d) {
            return 0;
        }
        return a(b(dArr17) / b6);
    }

    static int a(int[][] iArr) {
        if (iArr != null) {
            try {
                if (iArr.length >= 4) {
                    return a(new double[][]{new double[]{r6 * r6 * r6, r6 * r6, iArr[0][0], 1.0d, r5[1]}, new double[]{r11 * r11 * r11, r11 * r11, iArr[1][0], 1.0d, r5[1]}, new double[]{r11 * r11 * r11, r11 * r11, iArr[2][0], 1.0d, r5[1]}, new double[]{r4 * r4 * r4, r4 * r4, iArr[3][0], 1.0d, r14[1]}});
                }
            } catch (Throwable unused) {
            }
        }
        return 0;
    }

    private static double b(double[][] dArr) {
        double[] dArr2 = dArr[1];
        double[] dArr3 = {dArr2[1], dArr2[2], dArr2[3]};
        double[] dArr4 = dArr[2];
        double[] dArr5 = {dArr4[1], dArr4[2], dArr4[3]};
        double[] dArr6 = dArr[3];
        double d6 = dArr6[3];
        double[][] dArr7 = {dArr3, dArr5, new double[]{dArr6[1], dArr6[2], d6}};
        double[] dArr8 = dArr[1];
        double[] dArr9 = {dArr8[0], dArr8[2], dArr8[3]};
        double[] dArr10 = dArr[2];
        double[][] dArr11 = {dArr9, new double[]{dArr10[0], dArr10[2], dArr10[3]}, new double[]{dArr6[0], dArr6[2], d6}};
        double[] dArr12 = dArr[1];
        double[] dArr13 = {dArr12[0], dArr12[1], dArr12[3]};
        double[] dArr14 = dArr[2];
        double[][] dArr15 = {dArr13, new double[]{dArr14[0], dArr14[1], dArr14[3]}, new double[]{dArr6[0], dArr6[1], d6}};
        double[] dArr16 = dArr[1];
        double[] dArr17 = {dArr16[0], dArr16[1], dArr16[2]};
        double[] dArr18 = dArr[2];
        return (Math.pow(-1.0d, 0.0d) * dArr[0][0] * c(dArr7)) + (Math.pow(-1.0d, 1.0d) * dArr[0][1] * c(dArr11)) + (Math.pow(-1.0d, 2.0d) * dArr[0][2] * c(dArr15)) + (Math.pow(-1.0d, 3.0d) * dArr[0][3] * c(new double[][]{dArr17, new double[]{dArr18[0], dArr18[1], dArr18[2]}, new double[]{dArr6[0], dArr6[1], dArr6[2]}}));
    }

    private static double c(double[][] dArr) {
        double[] dArr2 = dArr[0];
        double d6 = dArr2[0];
        double[] dArr3 = dArr[1];
        double d7 = dArr3[1];
        double[] dArr4 = dArr[2];
        double d8 = dArr4[2];
        double d9 = dArr2[1];
        double d10 = dArr3[2];
        double d11 = dArr4[0];
        double d12 = (d6 * d7 * d8) + (d9 * d10 * d11);
        double d13 = dArr2[2];
        double d14 = dArr3[0];
        double d15 = dArr4[1];
        return (((d12 + ((d13 * d14) * d15)) + (((-d13) * d7) * d11)) - ((d9 * d14) * d8)) - ((d6 * d15) * d10);
    }
}
