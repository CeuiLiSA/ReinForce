package ceui.lisa.rrshare.network;

import io.reactivex.rxjava3.functions.Consumer;

public abstract class NullCtrl<T> implements Consumer<T> {

    @Override
    public void accept(T t) throws Throwable {
        if (t != null) {
            success(t);
        }
    }

    public abstract void success(T t);
}
