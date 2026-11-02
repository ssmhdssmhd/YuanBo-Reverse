package io.flutter.plugin.editing;

import io.flutter.embedding.engine.FlutterJNI;

/* loaded from: classes.dex */
class a {

    /* renamed from: a, reason: collision with root package name */
    private final FlutterJNI f6049a;

    public a(FlutterJNI flutterJNI) {
        this.f6049a = flutterJNI;
    }

    public int a(CharSequence charSequence, int i6) {
        int length = charSequence.length();
        int i7 = length - 1;
        if (i6 >= i7) {
            return length;
        }
        int codePointAt = Character.codePointAt(charSequence, i6);
        int charCount = Character.charCount(codePointAt);
        int i8 = i6 + charCount;
        int i9 = 0;
        if (i8 == 0) {
            return 0;
        }
        if (codePointAt == 10) {
            if (Character.codePointAt(charSequence, i8) == 13) {
                charCount++;
            }
            return i6 + charCount;
        }
        if (g(codePointAt)) {
            if (i8 >= i7 || !g(Character.codePointAt(charSequence, i8))) {
                return i8;
            }
            int i10 = i6;
            while (i10 > 0 && g(Character.codePointBefore(charSequence, i6))) {
                i10 -= Character.charCount(Character.codePointBefore(charSequence, i6));
                i9++;
            }
            if (i9 % 2 == 0) {
                charCount += 2;
            }
            return i6 + charCount;
        }
        if (f(codePointAt)) {
            charCount += Character.charCount(codePointAt);
        }
        if (codePointAt == 8419) {
            int codePointBefore = Character.codePointBefore(charSequence, i8);
            int charCount2 = i8 + Character.charCount(codePointBefore);
            if (charCount2 < length && i(codePointBefore)) {
                int codePointAt2 = Character.codePointAt(charSequence, charCount2);
                if (f(codePointAt2)) {
                    charCount += Character.charCount(codePointBefore) + Character.charCount(codePointAt2);
                }
            } else if (f(codePointBefore)) {
                charCount += Character.charCount(codePointBefore);
            }
            return i6 + charCount;
        }
        if (c(codePointAt)) {
            boolean z5 = false;
            int i11 = 0;
            do {
                if (z5) {
                    charCount += Character.charCount(codePointAt) + i11 + 1;
                    z5 = false;
                }
                if (d(codePointAt)) {
                    break;
                }
                if (i8 < length) {
                    codePointAt = Character.codePointAt(charSequence, i8);
                    i8 += Character.charCount(codePointAt);
                    if (codePointAt != 8419) {
                        if (!d(codePointAt) && !i(codePointAt)) {
                            if (codePointAt == 8205) {
                                codePointAt = Character.codePointAt(charSequence, i8);
                                i8 += Character.charCount(codePointAt);
                                if (i8 < length && i(codePointAt)) {
                                    codePointAt = Character.codePointAt(charSequence, i8);
                                    int charCount3 = Character.charCount(codePointAt);
                                    i8 += Character.charCount(codePointAt);
                                    i11 = charCount3;
                                    z5 = true;
                                    if (i8 < length || !z5) {
                                        break;
                                        break;
                                    }
                                } else {
                                    z5 = true;
                                }
                            }
                        } else {
                            charCount += Character.charCount(codePointAt) + 0;
                            break;
                        }
                    } else {
                        int codePointBefore2 = Character.codePointBefore(charSequence, i8);
                        int charCount4 = i8 + Character.charCount(codePointBefore2);
                        if (charCount4 < length && i(codePointBefore2)) {
                            int codePointAt3 = Character.codePointAt(charSequence, charCount4);
                            if (f(codePointAt3)) {
                                charCount += Character.charCount(codePointBefore2) + Character.charCount(codePointAt3);
                            }
                        } else if (f(codePointBefore2)) {
                            charCount += Character.charCount(codePointBefore2);
                        }
                        return i6 + charCount;
                    }
                }
                i11 = 0;
                if (i8 < length) {
                    break;
                }
            } while (c(codePointAt));
        }
        return i6 + charCount;
    }

    public int b(CharSequence charSequence, int i6) {
        int codePointBefore;
        int charCount;
        int charCount2;
        int i7 = 0;
        int i8 = 1;
        if (i6 <= 1 || (charCount2 = i6 - (charCount = Character.charCount((codePointBefore = Character.codePointBefore(charSequence, i6))))) == 0) {
            return 0;
        }
        if (codePointBefore == 10) {
            if (Character.codePointBefore(charSequence, charCount2) == 13) {
                charCount++;
            }
            return i6 - charCount;
        }
        if (g(codePointBefore)) {
            int codePointBefore2 = Character.codePointBefore(charSequence, charCount2);
            int charCount3 = charCount2 - Character.charCount(codePointBefore2);
            while (charCount3 > 0 && g(codePointBefore2)) {
                codePointBefore2 = Character.codePointBefore(charSequence, charCount3);
                charCount3 -= Character.charCount(codePointBefore2);
                i8++;
            }
            if (i8 % 2 == 0) {
                charCount += 2;
            }
            return i6 - charCount;
        }
        if (codePointBefore == 8419) {
            int codePointBefore3 = Character.codePointBefore(charSequence, charCount2);
            int charCount4 = charCount2 - Character.charCount(codePointBefore3);
            if (charCount4 > 0 && i(codePointBefore3)) {
                int codePointBefore4 = Character.codePointBefore(charSequence, charCount4);
                if (f(codePointBefore4)) {
                    charCount += Character.charCount(codePointBefore3) + Character.charCount(codePointBefore4);
                }
            } else if (f(codePointBefore3)) {
                charCount += Character.charCount(codePointBefore3);
            }
            return i6 - charCount;
        }
        if (codePointBefore == 917631) {
            while (true) {
                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                charCount2 -= Character.charCount(codePointBefore);
                if (charCount2 <= 0 || !h(codePointBefore)) {
                    break;
                }
                charCount += Character.charCount(codePointBefore);
            }
            if (!c(codePointBefore)) {
                return i6 - 2;
            }
            charCount += Character.charCount(codePointBefore);
        }
        if (i(codePointBefore)) {
            codePointBefore = Character.codePointBefore(charSequence, charCount2);
            if (!c(codePointBefore)) {
                return i6 - charCount;
            }
            charCount += Character.charCount(codePointBefore);
            charCount2 -= charCount;
        }
        if (c(codePointBefore)) {
            boolean z5 = false;
            int i9 = 0;
            while (true) {
                if (z5) {
                    charCount += Character.charCount(codePointBefore) + i9 + 1;
                    z5 = false;
                }
                if (d(codePointBefore)) {
                    int codePointBefore5 = Character.codePointBefore(charSequence, charCount2);
                    int charCount5 = charCount2 - Character.charCount(codePointBefore5);
                    if (charCount5 > 0 && i(codePointBefore5)) {
                        codePointBefore5 = Character.codePointBefore(charSequence, charCount5);
                        if (!c(codePointBefore5)) {
                            return i6 - charCount;
                        }
                        i7 = Character.charCount(codePointBefore5);
                        Character.charCount(codePointBefore5);
                    }
                    if (e(codePointBefore5)) {
                        charCount += i7 + Character.charCount(codePointBefore5);
                    }
                } else {
                    if (charCount2 > 0) {
                        codePointBefore = Character.codePointBefore(charSequence, charCount2);
                        charCount2 -= Character.charCount(codePointBefore);
                        if (codePointBefore == 8205) {
                            codePointBefore = Character.codePointBefore(charSequence, charCount2);
                            charCount2 -= Character.charCount(codePointBefore);
                            if (charCount2 > 0 && i(codePointBefore)) {
                                codePointBefore = Character.codePointBefore(charSequence, charCount2);
                                int charCount6 = Character.charCount(codePointBefore);
                                charCount2 -= Character.charCount(codePointBefore);
                                i9 = charCount6;
                                z5 = true;
                                if (charCount2 != 0 || !z5 || !c(codePointBefore)) {
                                    break;
                                    break;
                                }
                            } else {
                                z5 = true;
                            }
                        }
                    }
                    i9 = 0;
                    if (charCount2 != 0) {
                        break;
                    }
                }
            }
        }
        return i6 - charCount;
    }

    public boolean c(int i6) {
        return this.f6049a.isCodePointEmoji(i6);
    }

    public boolean d(int i6) {
        return this.f6049a.isCodePointEmojiModifier(i6);
    }

    public boolean e(int i6) {
        return this.f6049a.isCodePointEmojiModifierBase(i6);
    }

    public boolean f(int i6) {
        return (48 <= i6 && i6 <= 57) || i6 == 35 || i6 == 42;
    }

    public boolean g(int i6) {
        return this.f6049a.isCodePointRegionalIndicator(i6);
    }

    public boolean h(int i6) {
        return 917536 <= i6 && i6 <= 917630;
    }

    public boolean i(int i6) {
        return this.f6049a.isCodePointVariantSelector(i6);
    }
}
