package ceui.lisa.rrshare.utils;

import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import ceui.lisa.rrshare.core.ReinForce;

public class Common {

    public static <T> void showLog(T t) {
        Log.d("==Rein== log ==> ", String.valueOf(t));
    }

    public static boolean isEmpty(List<?> list) {
        return list == null || list.size() == 0;
    }

    private static Toast toast = null;

    public static <T> void showToast(T t) {
        if (t == null) {
            return;
        }

        if (TextUtils.isEmpty(String.valueOf(t))) {
            return;
        }

        if (toast == null) {
            toast = Toast.makeText(ReinForce.getContext(), String.valueOf(t), Toast.LENGTH_SHORT);
        } else {
            toast.cancel();
            toast = Toast.makeText(ReinForce.getContext(), String.valueOf(t), Toast.LENGTH_SHORT);
            toast.setText(String.valueOf(t));
            toast.setDuration(Toast.LENGTH_SHORT);
        }
        toast.show();
    }

}
