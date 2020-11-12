package ceui.lisa.rrshare.fragments;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.ItemView;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.TabItem;
import ceui.lisa.rrshare.databinding.FragmentRBinding;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.viewmodel.PageModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class FragmentR extends BaseFragment<FragmentRBinding> {

    private String type = "CHANNEL_INDEX";

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_r;
    }

    @Override
    protected void initView() {
        baseBind.toolbar.setTitle(getNameByType());
        baseBind.toolbar.inflateMenu(R.menu.main_menu);
        baseBind.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_1) {
                    type = "CHANNEL_USK";
                    return true;
                } else if (item.getItemId() == R.id.action_2) {
                    type = "CHANNEL_KR";
                    return true;
                } else if (item.getItemId() == R.id.action_3) {
                    type = "CHANNEL_JP";
                    return true;
                } else if (item.getItemId() == R.id.action_4) {
                    type = "CHANNEL_TH";
                    return true;
                } else if (item.getItemId() == R.id.action_5) {
                    type = "CHANNEL_INDEX";
                    return true;
                } else if (item.getItemId() == R.id.action_6) {
                    type = "CHANNEL_CHN";
                    return true;
                }
                return false;
            }
        });
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
                .subscribe(new NullCtrl<Page>() {
                    @Override
                    public void success(Page rankResponse) {
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
                                    TabItem itemView = new TabItem(mContext);
                                    itemView.bindSection(section);
                                    baseBind.createLinear.addView(itemView);
                                } else {
                                    ItemView itemView = new ItemView(mContext);
                                    itemView.bindSection(section);
                                    baseBind.createLinear.addView(itemView);
                                }
                            }
                        }
                        baseBind.smartRefreshLayout.finishRefresh(true);
                    }
                }, new NullCtrl<Throwable>() {
                    @Override
                    public void success(Throwable throwable) {
                        baseBind.smartRefreshLayout.finishRefresh(false);
                        throwable.printStackTrace();
                    }
                });
    }

    private String getNameByType() {
        if (type.equals("CHANNEL_USK")) {
            return "美剧";
        } else if (type.equals("CHANNEL_KR")) {
            return "韩剧";
        } else if (type.equals("CHANNEL_JP")) {
            return "日剧";
        } else if (type.equals("CHANNEL_TH")) {
            return "泰剧";
        } else if (type.equals("CHANNEL_INDEX")) {
            return "精选";
        } else if (type.equals("CHANNEL_CHN")) {
            return "国产剧";
        }
        return "ReinForce";
    }
}
