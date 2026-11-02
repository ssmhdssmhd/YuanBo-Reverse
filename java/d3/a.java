package d3;

import android.content.Context;
import com.tendcloud.tenddata.TalkingDataGender;
import com.tendcloud.tenddata.TalkingDataProfile;
import com.tendcloud.tenddata.TalkingDataProfileType;
import com.tendcloud.tenddata.TalkingDataSDK;
import java.util.Map;
import q3.a;
import y3.j;
import y3.k;

/* loaded from: classes.dex */
public class a implements q3.a, k.c {

    /* renamed from: b, reason: collision with root package name */
    private static Context f2980b;

    /* renamed from: a, reason: collision with root package name */
    private k f2981a;

    public static void a(Context context) {
        f2980b = context;
    }

    @Override // q3.a
    public void b(a.b bVar) {
        k kVar = new k(bVar.b(), "talkingdata_sdk_plugin");
        this.f2981a = kVar;
        kVar.e(this);
    }

    @Override // y3.k.c
    public void e(j jVar, k.d dVar) {
        k.d dVar2;
        String deviceId;
        String str = jVar.f11100a;
        str.hashCode();
        switch (str) {
            case "removeGlobalKV":
                TalkingDataSDK.removeGlobalKV((String) jVar.a("key"));
                return;
            case "onEvent":
                TalkingDataSDK.onEvent(f2980b, (String) jVar.a("eventID"), jVar.a("params") instanceof Map ? (Map) jVar.a("params") : null);
                return;
            case "onLogin":
                TalkingDataProfile createProfile = TalkingDataProfile.createProfile();
                createProfile.setType(TalkingDataProfileType.valueOf((String) jVar.a("type")));
                createProfile.setName((String) jVar.a("name"));
                createProfile.setGender(TalkingDataGender.valueOf((String) jVar.a("gender")));
                createProfile.setAge(((Integer) jVar.a("age")).intValue());
                createProfile.setProperty1(jVar.a("property1"));
                createProfile.setProperty2(jVar.a("property2"));
                createProfile.setProperty3(jVar.a("property3"));
                createProfile.setProperty4(jVar.a("property4"));
                createProfile.setProperty5(jVar.a("property5"));
                createProfile.setProperty6(jVar.a("property6"));
                createProfile.setProperty7(jVar.a("property7"));
                createProfile.setProperty8(jVar.a("property8"));
                createProfile.setProperty9(jVar.a("property9"));
                createProfile.setProperty10(jVar.a("property10"));
                TalkingDataSDK.onLogin((String) jVar.a("profileId"), createProfile);
                return;
            case "onPunch":
                TalkingDataSDK.onPunch((String) jVar.a("profile"), (String) jVar.a("punchId"));
                return;
            case "onShare":
                TalkingDataSDK.onShare((String) jVar.a("profile"), (String) jVar.a("content"));
                return;
            case "getDeviceID":
                dVar2 = dVar;
                deviceId = TalkingDataSDK.getDeviceId(f2980b);
                break;
            case "onFavorite":
                TalkingDataSDK.onFavorite((String) jVar.a("category"), (String) jVar.a("content"));
                return;
            case "onProfileUpdate":
                TalkingDataProfile createProfile2 = TalkingDataProfile.createProfile();
                createProfile2.setType(TalkingDataProfileType.valueOf((String) jVar.a("type")));
                createProfile2.setName((String) jVar.a("name"));
                createProfile2.setGender(TalkingDataGender.valueOf((String) jVar.a("gender")));
                createProfile2.setAge(((Integer) jVar.a("age")).intValue());
                createProfile2.setProperty1(jVar.a("property1"));
                createProfile2.setProperty2(jVar.a("property2"));
                createProfile2.setProperty3(jVar.a("property3"));
                createProfile2.setProperty4(jVar.a("property4"));
                createProfile2.setProperty5(jVar.a("property5"));
                createProfile2.setProperty6(jVar.a("property6"));
                createProfile2.setProperty7(jVar.a("property7"));
                createProfile2.setProperty8(jVar.a("property8"));
                createProfile2.setProperty9(jVar.a("property9"));
                createProfile2.setProperty10(jVar.a("property10"));
                TalkingDataSDK.onProfileUpdate(createProfile2);
                return;
            case "getOAID":
                deviceId = TalkingDataSDK.getOAID(f2980b);
                dVar2 = dVar;
                break;
            case "init":
                TalkingDataSDK.init(f2980b, (String) jVar.a("appID"), (String) jVar.a("channelID"), (String) jVar.a("custom"));
                return;
            case "onCreateCard":
                TalkingDataSDK.onCreateCard((String) jVar.a("profile"), (String) jVar.a("method"), (String) jVar.a("content"));
                return;
            case "onPageEnd":
                TalkingDataSDK.onPageEnd(f2980b, (String) jVar.a("pageName"));
                return;
            case "onPageBegin":
                TalkingDataSDK.onPageBegin(f2980b, (String) jVar.a("pageName"));
                return;
            case "setGlobalKV":
                TalkingDataSDK.setGlobalKV((String) jVar.a("key"), jVar.a("value"));
                return;
            case "onReceiveDeepLink":
                TalkingDataSDK.onReceiveDeepLink((String) jVar.a("link"));
                return;
            case "onRegister":
                String str2 = (String) jVar.a("profileId");
                String str3 = (String) jVar.a("invitationCode");
                TalkingDataProfile createProfile3 = TalkingDataProfile.createProfile();
                createProfile3.setType(TalkingDataProfileType.valueOf((String) jVar.a("type")));
                createProfile3.setName((String) jVar.a("name"));
                createProfile3.setGender(TalkingDataGender.valueOf((String) jVar.a("gender")));
                createProfile3.setAge(((Integer) jVar.a("age")).intValue());
                createProfile3.setProperty1(jVar.a("property1"));
                createProfile3.setProperty2(jVar.a("property2"));
                createProfile3.setProperty3(jVar.a("property3"));
                createProfile3.setProperty4(jVar.a("property4"));
                createProfile3.setProperty5(jVar.a("property5"));
                createProfile3.setProperty6(jVar.a("property6"));
                createProfile3.setProperty7(jVar.a("property7"));
                createProfile3.setProperty8(jVar.a("property8"));
                createProfile3.setProperty9(jVar.a("property9"));
                createProfile3.setProperty10(jVar.a("property10"));
                TalkingDataSDK.onRegister(str2, createProfile3, str3);
                return;
            default:
                dVar.c();
                return;
        }
        dVar2.b(deviceId);
    }

    @Override // q3.a
    public void j(a.b bVar) {
        this.f2981a.e(null);
    }
}
