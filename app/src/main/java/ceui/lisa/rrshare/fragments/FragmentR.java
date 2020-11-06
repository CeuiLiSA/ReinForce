package ceui.lisa.rrshare.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.ItemView;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.FragmentRBinding;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.response.Section;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class FragmentR extends BaseFragment<FragmentRBinding> {

    private String type;

    public static FragmentR newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        FragmentR fragment = new FragmentR();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        type = bundle.getString("type");
    }

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_r;
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
                        baseBind.createLinear.removeAllViews();
                        for (Section section : rankResponse.getData().getSections()) {
                            if (!"AD".equals(section.getSectionType())) {
                                if ("TAB".equals(section.getDisplay())) {

                                } else {
                                    ItemView itemView = new ItemView(mContext);
                                    itemView.bindSection(section);
                                    baseBind.createLinear.addView(itemView);
                                }
                            }
                        }
                        baseBind.smartRefreshLayout.finishRefresh(true);
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
