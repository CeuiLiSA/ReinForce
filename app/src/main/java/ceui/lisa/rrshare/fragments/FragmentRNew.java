package ceui.lisa.rrshare.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.CallBack;
import ceui.lisa.rrshare.ItemView;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.PartAdapter;
import ceui.lisa.rrshare.databinding.FragmentRBinding;
import ceui.lisa.rrshare.databinding.FragmentRNewBinding;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class FragmentRNew extends BaseFragment<FragmentRNewBinding> {

    private String type;
    private List<Section> sections = new ArrayList<>();
    private PartAdapter mAdapter;
    private Page page;
    private int nowPage = 1;

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
        baseBind.smartRefreshLayout.setRefreshFooter(new ClassicsFooter(mContext));
        baseBind.smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                if (page != null) {
                    int startSize = sections.size();
                    List<Section> nextList = page.getPage(nowPage);
                    if (nextList != null && nextList.size() != 0) {
                        sections.addAll(nextList);
                        mAdapter.notifyItemRangeInserted(startSize, nextList.size());
                        nowPage++;
                    } else {
                    }
                    baseBind.smartRefreshLayout.finishLoadMore(true);
                }
            }
        });
        baseBind.smartRefreshLayout.autoRefresh();
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new PartAdapter(sections, mContext);
        baseBind.recyList.setAdapter(mAdapter);
    }

    private void fetch() {
        nowPage = 1;
        mAdapter.clear();
        RxHttp.get("https://api.rr.tv/v3plus/index/channel")
                .addAllHeader(Net.header())
                .add("position", type)
                .asClass(Page.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NullCtrl<Page>() {
                    @Override
                    public void success(Page rankResponse) {
                        page = rankResponse;
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
                        int startSize = sections.size();
                        baseBind.bannerCard.setVisibility(View.VISIBLE);
                        for (int i = 0; i < 8; i++) {
                            sections.add(rankResponse.getData().getSections().get(i));
                        }
                        mAdapter.notifyItemRangeInserted(startSize, sections.size());
                        baseBind.smartRefreshLayout.finishRefresh(true);
                        nowPage++;
                    }
                }, new NullCtrl<Throwable>() {
                    @Override
                    public void success(Throwable throwable) {
                        baseBind.smartRefreshLayout.finishRefresh(false);
                        throwable.printStackTrace();
                    }
                });
    }
}
