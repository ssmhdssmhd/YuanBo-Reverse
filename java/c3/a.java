package c3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import java.io.File;
import kotlin.jvm.internal.k;

/* loaded from: classes.dex */
public final class a {
    public final void a(Activity context, String filePath, int i6) {
        k.e(context, "context");
        k.e(filePath, "filePath");
        Log.e("TAG", "install apk" + filePath);
        if (TextUtils.isEmpty(filePath)) {
            Toast.makeText(context, "安装路径出错", 0).show();
            return;
        }
        File file = new File(filePath);
        Uri fromFile = Uri.fromFile(file);
        if (fromFile == null) {
            throw new RuntimeException("安装路径不正确");
        }
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 24) {
            fromFile = FileProvider.f(context, context.getPackageName() + ".FileProvider", file);
            k.d(fromFile, "getUriForFile(context, \"…ame}.FileProvider\", file)");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.INSTALL_PACKAGE");
        if (i7 < 24) {
            intent.setFlags(268435456);
            intent.setDataAndType(fromFile, "application/vnd.android.package-archive");
        } else {
            intent.setData(fromFile);
            intent.addFlags(1);
        }
        intent.putExtra("android.intent.extra.RETURN_RESULT", true);
        intent.putExtra("android.intent.extra.NOT_UNKNOWN_SOURCE", true);
        intent.putExtra("android.intent.extra.ALLOW_REPLACE", true);
        try {
            context.startActivityForResult(intent, i6);
        } catch (Exception e6) {
            String message = e6.getMessage();
            if (message != null) {
                Log.e("TAG", message);
            }
        }
    }
}
