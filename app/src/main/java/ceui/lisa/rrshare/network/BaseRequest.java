package ceui.lisa.rrshare.network;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public abstract class BaseRequest<T> {

    private static final String URL = "https://api.rr.tv/";
    private String method;
    private Map<String, Object> keyValues;

    public BaseRequest(String method) {
        this.method = method;
        keyValues = new HashMap<>();
        addData(keyValues);
    }

    public void run() {
        RxHttp.get(URL + method)
                .addAllHeader(Net.header())
                .addAll(keyValues)
                .asClass(asClass())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NullCtrl<T>() {
                    @Override
                    public void success(T t) {
                        callBack(t);
                    }
                });
    }

    public abstract void callBack(T t);

    public abstract Class<T> asClass();

    public void addData(Map<String, Object> map) {
    }
}
