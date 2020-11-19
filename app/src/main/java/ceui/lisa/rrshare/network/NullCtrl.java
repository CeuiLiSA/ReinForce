package ceui.lisa.rrshare.network;

import android.text.TextUtils;

import ceui.lisa.rrshare.response.Base;
import ceui.lisa.rrshare.response.BaseObject;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.functions.Consumer;

public abstract class NullCtrl<T> implements Consumer<T> {

    @Override
    public void accept(T t) {
        try {
            if (t != null) {
                if (t instanceof Base) {
                    if (!"0000".equals(((Base) t).getCode())) {
                        if (!TextUtils.isEmpty(((Base) t).getMsg())) {
                            Common.showToast(((Base) t).getMsg());
                        }
                    }
                }

                success(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void success(T t);
}
