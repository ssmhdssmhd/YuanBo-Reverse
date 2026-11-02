package io.flutter.plugin.editing;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.TextPaint;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputContentInfo;
import android.view.inputmethod.InputMethodManager;
import com.tendcloud.tenddata.cs;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.editing.j;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/* loaded from: classes.dex */
public class i extends BaseInputConnection implements j.b {

    /* renamed from: a, reason: collision with root package name */
    private final View f6077a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6078b;

    /* renamed from: c, reason: collision with root package name */
    private final x3.p f6079c;

    /* renamed from: d, reason: collision with root package name */
    private final j f6080d;

    /* renamed from: e, reason: collision with root package name */
    private final EditorInfo f6081e;

    /* renamed from: f, reason: collision with root package name */
    private ExtractedTextRequest f6082f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f6083g;

    /* renamed from: h, reason: collision with root package name */
    private CursorAnchorInfo.Builder f6084h;

    /* renamed from: i, reason: collision with root package name */
    private ExtractedText f6085i;

    /* renamed from: j, reason: collision with root package name */
    private InputMethodManager f6086j;

    /* renamed from: k, reason: collision with root package name */
    private final Layout f6087k;

    /* renamed from: l, reason: collision with root package name */
    private io.flutter.plugin.editing.a f6088l;

    /* renamed from: m, reason: collision with root package name */
    private final a f6089m;

    /* renamed from: n, reason: collision with root package name */
    private int f6090n;

    public interface a {
        boolean a(KeyEvent keyEvent);
    }

    public i(View view, int i6, x3.p pVar, a aVar, j jVar, EditorInfo editorInfo) {
        this(view, i6, pVar, aVar, jVar, editorInfo, new FlutterJNI());
    }

    public i(View view, int i6, x3.p pVar, a aVar, j jVar, EditorInfo editorInfo, FlutterJNI flutterJNI) {
        super(view, true);
        this.f6083g = false;
        this.f6085i = new ExtractedText();
        this.f6090n = 0;
        this.f6077a = view;
        this.f6078b = i6;
        this.f6079c = pVar;
        this.f6080d = jVar;
        jVar.a(this);
        this.f6081e = editorInfo;
        this.f6089m = aVar;
        this.f6088l = new io.flutter.plugin.editing.a(flutterJNI);
        this.f6087k = new DynamicLayout(jVar, new TextPaint(), Integer.MAX_VALUE, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false);
        this.f6086j = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    private boolean b(int i6) {
        if (i6 == 16908319) {
            setSelection(0, this.f6080d.length());
            return true;
        }
        if (i6 == 16908320) {
            int selectionStart = Selection.getSelectionStart(this.f6080d);
            int selectionEnd = Selection.getSelectionEnd(this.f6080d);
            if (selectionStart != selectionEnd) {
                int min = Math.min(selectionStart, selectionEnd);
                int max = Math.max(selectionStart, selectionEnd);
                ((ClipboardManager) this.f6077a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f6080d.subSequence(min, max)));
                this.f6080d.delete(min, max);
                setSelection(min, min);
            }
            return true;
        }
        if (i6 == 16908321) {
            int selectionStart2 = Selection.getSelectionStart(this.f6080d);
            int selectionEnd2 = Selection.getSelectionEnd(this.f6080d);
            if (selectionStart2 != selectionEnd2) {
                ((ClipboardManager) this.f6077a.getContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", this.f6080d.subSequence(Math.min(selectionStart2, selectionEnd2), Math.max(selectionStart2, selectionEnd2))));
            }
            return true;
        }
        if (i6 != 16908322) {
            return false;
        }
        ClipData primaryClip = ((ClipboardManager) this.f6077a.getContext().getSystemService("clipboard")).getPrimaryClip();
        if (primaryClip != null) {
            CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(this.f6077a.getContext());
            int max2 = Math.max(0, Selection.getSelectionStart(this.f6080d));
            int max3 = Math.max(0, Selection.getSelectionEnd(this.f6080d));
            int min2 = Math.min(max2, max3);
            int max4 = Math.max(max2, max3);
            if (min2 != max4) {
                this.f6080d.delete(min2, max4);
            }
            this.f6080d.insert(min2, coerceToText);
            int length = min2 + coerceToText.length();
            setSelection(length, length);
        }
        return true;
    }

    private CursorAnchorInfo c() {
        CursorAnchorInfo.Builder builder = this.f6084h;
        if (builder == null) {
            this.f6084h = new CursorAnchorInfo.Builder();
        } else {
            builder.reset();
        }
        this.f6084h.setSelectionRange(this.f6080d.i(), this.f6080d.h());
        int g6 = this.f6080d.g();
        int f6 = this.f6080d.f();
        if (g6 < 0 || f6 <= g6) {
            this.f6084h.setComposingText(-1, "");
        } else {
            this.f6084h.setComposingText(g6, this.f6080d.toString().subSequence(g6, f6));
        }
        return this.f6084h.build();
    }

    private ExtractedText d(ExtractedTextRequest extractedTextRequest) {
        ExtractedText extractedText = this.f6085i;
        extractedText.startOffset = 0;
        extractedText.partialStartOffset = -1;
        extractedText.partialEndOffset = -1;
        extractedText.selectionStart = this.f6080d.i();
        this.f6085i.selectionEnd = this.f6080d.h();
        this.f6085i.text = (extractedTextRequest == null || (extractedTextRequest.flags & 1) == 0) ? this.f6080d.toString() : this.f6080d;
        return this.f6085i;
    }

    private boolean e(boolean z5, boolean z6) {
        int selectionStart = Selection.getSelectionStart(this.f6080d);
        int selectionEnd = Selection.getSelectionEnd(this.f6080d);
        boolean z7 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        int max = z5 ? Math.max(this.f6088l.b(this.f6080d, selectionEnd), 0) : Math.min(this.f6088l.a(this.f6080d, selectionEnd), this.f6080d.length());
        if (selectionStart == selectionEnd && !z6) {
            z7 = true;
        }
        if (z7) {
            setSelection(max, max);
        } else {
            setSelection(selectionStart, max);
        }
        return true;
    }

    private boolean g(boolean z5, boolean z6) {
        int selectionStart = Selection.getSelectionStart(this.f6080d);
        int selectionEnd = Selection.getSelectionEnd(this.f6080d);
        boolean z7 = false;
        if (selectionStart < 0 || selectionEnd < 0) {
            return false;
        }
        if (selectionStart == selectionEnd && !z6) {
            z7 = true;
        }
        beginBatchEdit();
        if (z7) {
            if (z5) {
                Selection.moveUp(this.f6080d, this.f6087k);
            } else {
                Selection.moveDown(this.f6080d, this.f6087k);
            }
            int selectionStart2 = Selection.getSelectionStart(this.f6080d);
            setSelection(selectionStart2, selectionStart2);
        } else {
            if (z5) {
                Selection.extendUp(this.f6080d, this.f6087k);
            } else {
                Selection.extendDown(this.f6080d, this.f6087k);
            }
            setSelection(Selection.getSelectionStart(this.f6080d), Selection.getSelectionEnd(this.f6080d));
        }
        endBatchEdit();
        return true;
    }

    private byte[] h(InputStream inputStream, int i6) {
        int i7;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i6];
        while (true) {
            try {
                i7 = inputStream.read(bArr);
            } catch (IOException unused) {
                i7 = -1;
            }
            if (i7 == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i7);
        }
    }

    @Override // io.flutter.plugin.editing.j.b
    public void a(boolean z5, boolean z6, boolean z7) {
        this.f6086j.updateSelection(this.f6077a, this.f6080d.i(), this.f6080d.h(), this.f6080d.g(), this.f6080d.f());
        ExtractedTextRequest extractedTextRequest = this.f6082f;
        if (extractedTextRequest != null) {
            this.f6086j.updateExtractedText(this.f6077a, extractedTextRequest.token, d(extractedTextRequest));
        }
        if (this.f6083g) {
            this.f6086j.updateCursorAnchorInfo(this.f6077a, c());
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        this.f6080d.b();
        this.f6090n++;
        return super.beginBatchEdit();
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i6) {
        return super.clearMetaKeyStates(i6);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public void closeConnection() {
        super.closeConnection();
        this.f6080d.l(this);
        while (this.f6090n > 0) {
            endBatchEdit();
            this.f6090n--;
        }
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitContent(InputContentInfo inputContentInfo, int i6, Bundle bundle) {
        ClipDescription description;
        Uri contentUri;
        ClipDescription description2;
        if (Build.VERSION.SDK_INT >= 25 && (i6 & 1) != 0) {
            try {
                inputContentInfo.requestPermission();
                description = inputContentInfo.getDescription();
                if (description.getMimeTypeCount() > 0) {
                    inputContentInfo.requestPermission();
                    contentUri = inputContentInfo.getContentUri();
                    description2 = inputContentInfo.getDescription();
                    String mimeType = description2.getMimeType(0);
                    Context context = this.f6077a.getContext();
                    if (contentUri != null) {
                        try {
                            InputStream openInputStream = context.getContentResolver().openInputStream(contentUri);
                            if (openInputStream != null) {
                                byte[] h6 = h(openInputStream, 65536);
                                HashMap hashMap = new HashMap();
                                hashMap.put("mimeType", mimeType);
                                hashMap.put(cs.a.DATA, h6);
                                hashMap.put("uri", contentUri.toString());
                                this.f6079c.b(this.f6078b, hashMap);
                                inputContentInfo.releasePermission();
                                return true;
                            }
                        } catch (FileNotFoundException unused) {
                            inputContentInfo.releasePermission();
                            return false;
                        }
                    }
                    inputContentInfo.releasePermission();
                }
            } catch (Exception unused2) {
            }
        }
        return false;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i6) {
        return super.commitText(charSequence, i6);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i6, int i7) {
        if (this.f6080d.i() == -1) {
            return true;
        }
        return super.deleteSurroundingText(i6, i7);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i6, int i7) {
        return super.deleteSurroundingTextInCodePoints(i6, i7);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        boolean endBatchEdit = super.endBatchEdit();
        this.f6090n--;
        this.f6080d.d();
        return endBatchEdit;
    }

    public boolean f(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            if (keyEvent.getAction() != 1 || (keyEvent.getKeyCode() != 59 && keyEvent.getKeyCode() != 60)) {
                return false;
            }
            int selectionEnd = Selection.getSelectionEnd(this.f6080d);
            setSelection(selectionEnd, selectionEnd);
            return true;
        }
        if (keyEvent.getKeyCode() == 21) {
            return e(true, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 22) {
            return e(false, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 19) {
            return g(true, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 20) {
            return g(false, keyEvent.isShiftPressed());
        }
        if (keyEvent.getKeyCode() == 66 || keyEvent.getKeyCode() == 160) {
            EditorInfo editorInfo = this.f6081e;
            if ((editorInfo.inputType & 131072) == 0) {
                performEditorAction(editorInfo.imeOptions & 255);
                return true;
            }
        }
        int selectionStart = Selection.getSelectionStart(this.f6080d);
        int selectionEnd2 = Selection.getSelectionEnd(this.f6080d);
        int unicodeChar = keyEvent.getUnicodeChar();
        if (selectionStart < 0 || selectionEnd2 < 0 || unicodeChar == 0) {
            return false;
        }
        int min = Math.min(selectionStart, selectionEnd2);
        int max = Math.max(selectionStart, selectionEnd2);
        beginBatchEdit();
        if (min != max) {
            this.f6080d.delete(min, max);
        }
        this.f6080d.insert(min, (CharSequence) String.valueOf((char) unicodeChar));
        int i6 = min + 1;
        setSelection(i6, i6);
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        return super.finishComposingText();
    }

    @Override // android.view.inputmethod.BaseInputConnection
    public Editable getEditable() {
        return this.f6080d;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i6) {
        boolean z5 = (i6 & 1) != 0;
        if (z5 == (this.f6082f == null)) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled text monitoring ");
            sb.append(z5 ? "on" : "off");
            k3.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f6082f = z5 ? extractedTextRequest : null;
        return d(extractedTextRequest);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i6) {
        beginBatchEdit();
        boolean b6 = b(i6);
        endBatchEdit();
        return b6;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i6) {
        if (i6 == 0) {
            this.f6079c.o(this.f6078b);
        } else if (i6 == 1) {
            this.f6079c.g(this.f6078b);
        } else if (i6 == 2) {
            this.f6079c.f(this.f6078b);
        } else if (i6 == 3) {
            this.f6079c.l(this.f6078b);
        } else if (i6 == 4) {
            this.f6079c.m(this.f6078b);
        } else if (i6 == 5) {
            this.f6079c.h(this.f6078b);
        } else if (i6 != 7) {
            this.f6079c.e(this.f6078b);
        } else {
            this.f6079c.j(this.f6078b);
        }
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        this.f6079c.i(this.f6078b, str, bundle);
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i6) {
        if ((i6 & 1) != 0) {
            this.f6086j.updateCursorAnchorInfo(this.f6077a, c());
        }
        boolean z5 = (i6 & 2) != 0;
        if (z5 != this.f6083g) {
            StringBuilder sb = new StringBuilder();
            sb.append("The input method toggled cursor monitoring ");
            sb.append(z5 ? "on" : "off");
            k3.b.a("InputConnectionAdaptor", sb.toString());
        }
        this.f6083g = z5;
        return true;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        return this.f6089m.a(keyEvent);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i6, int i7) {
        return super.setComposingRegion(i6, i7);
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i6) {
        beginBatchEdit();
        boolean commitText = charSequence.length() == 0 ? super.commitText(charSequence, i6) : super.setComposingText(charSequence, i6);
        endBatchEdit();
        return commitText;
    }

    @Override // android.view.inputmethod.BaseInputConnection, android.view.inputmethod.InputConnection
    public boolean setSelection(int i6, int i7) {
        beginBatchEdit();
        boolean selection = super.setSelection(i6, i7);
        endBatchEdit();
        return selection;
    }
}
