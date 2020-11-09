package ceui.lisa.rrshare.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.CallBack;
import ceui.lisa.rrshare.ItemView;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.PartAdapter;
import ceui.lisa.rrshare.databinding.FragmentRBinding;
import ceui.lisa.rrshare.databinding.FragmentRNewBinding;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.response.Section;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class FragmentRNew extends BaseFragment<FragmentRNewBinding> {

    private String type;

    public static FragmentRNew newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        FragmentRNew fragment = new FragmentRNew();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        type = bundle.getString("type");
    }

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_r_new;
    }

    @Override
    protected void initView() {
        baseBind.smartRefreshLayout.setEnableRefresh(true);
        baseBind.smartRefreshLayout.setEnableLoadMore(true);
        baseBind.smartRefreshLayout.setRefreshHeader(new MaterialHeader(mContext));
        baseBind.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                fetch();
            }
        });
        baseBind.smartRefreshLayout.setRefreshFooter(new FalsifyFooter(mContext));
        baseBind.smartRefreshLayout.autoRefresh();
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void fetch() {
        RxHttp.get("https://api.rr.tv/v3plus/index/channel")
                .addAllHeader(Net.header())
                .add("position", type)
                .asClass(Page.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Page>() {
                    @Override
                    public void accept(Page rankResponse) {
                        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager(), 0) {
                            @NonNull
                            @Override
                            public Fragment getItem(int position) {
                                return FragmentBanner.newInstance(
                                        rankResponse.getData().getBannerTop().get(position)
                                );
                            }

                            @Override
                            public int getCount() {
                                return rankResponse.getData().getBannerTop().size();
                            }
                        });
                        baseBind.bannerCard.setVisibility(View.VISIBLE);
                        new Thread(new Runnable() {
                            @Override
                            public void run() {
                                PartAdapter adapter = new PartAdapter(rankResponse.getData().getSections(), mContext);
                                adapter.initNow(new CallBack() {
                                    @Override
                                    public void callBack() {
                                        mActivity.runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                baseBind.recyList.setAdapter(adapter);
                                                baseBind.smartRefreshLayout.finishRefresh(true);
                                            }
                                        });
                                    }
                                });
                            }
                        }).start();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Throwable {
                        baseBind.smartRefreshLayout.finishRefresh(false);
                        throwable.printStackTrace();
                    }
                });
    }
}
