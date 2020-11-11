package ceui.lisa.rrshare.utils;

import android.util.Log;

import java.util.List;

public class Common {

    public static <T> void showLog(T t) {
        Log.d("==Rein== log ==> ", String.valueOf(t));
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

}
