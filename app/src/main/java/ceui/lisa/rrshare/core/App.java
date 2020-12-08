package ceui.lisa.rrshare.core;

import android.app.Application;
import android.content.Context;

import com.tencent.mmkv.MMKV;

public class App extends Application {

    private static Context sContext;
    private static MMKV sMMKV = null;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;

        MMKV.initialize(this);
        sMMKV = MMKV.defaultMMKV();
    }

    public static MMKV getMMKV() {
        if (sMMKV == null) {
            sMMKV = MMKV.defaultMMKV();
        }
        return sMMKV;
    }

    public static Context getContext() {
        return sContext;
    }
}
