package ceui.lisa.rrshare.core;

import android.app.Application;
import android.content.Context;

public class ReinForce extends Application {

    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }

    public static void setContext(Context context) {
        sContext = context;
    }
}
