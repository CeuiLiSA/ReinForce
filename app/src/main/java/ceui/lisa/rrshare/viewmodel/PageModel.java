package ceui.lisa.rrshare.viewmodel;

import androidx.lifecycle.ViewModel;

import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class PageModel extends ViewModel {

    private Page mPage;
    private boolean isLoad = false;

    public Page getPage() {
        return mPage;
    }

    public void setPage(Page page) {
        this.mPage = page;
    }

    public boolean isLoad() {
        return isLoad;
    }

    public void setLoad(boolean load) {
        isLoad = load;
    }

    public void load(String type, NullCtrl<Page> nullCtrl) {
        if (isLoad && mPage != null) {
            Common.showLog("load 加载过了");
            return;
        }
        Common.showLog("load 重新加载");
        RxHttp.get("https://api.rr.tv/v3plus/index/channel")
                .addAllHeader(Net.header())
                .add("position", type)
                .asClass(Page.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NullCtrl<Page>() {
                    @Override
                    public void success(Page page) {
                        isLoad = true;
                        mPage = page;
                        if (nullCtrl != null) {
                            nullCtrl.success(mPage);
                        }
                    }
                });
    }
}
