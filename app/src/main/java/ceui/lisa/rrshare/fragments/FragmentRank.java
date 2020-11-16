package ceui.lisa.rrshare.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.Map;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.RankActivity;
import ceui.lisa.rrshare.adapters.SCardAdapter;
import ceui.lisa.rrshare.databinding.FragmentRankBinding;
import ceui.lisa.rrshare.network.BaseRequest;
import ceui.lisa.rrshare.response.QueryContent;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecoration;

public class FragmentRank extends BaseLazyFragment<FragmentRankBinding> {

    private int index;
    private QueryContent content;

    public static FragmentRank newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        FragmentRank fragment = new FragmentRank();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        index = bundle.getInt("index");
    }

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_rank;
    }

    @Override
    protected void initView() {
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
        baseBind.recyList.addItemDecoration(new LinearItemDecoration(DensityUtil.dp2px(12.0f)));
        baseBind.smartRefreshLayout.setEnableRefresh(true);
        baseBind.smartRefreshLayout.setEnableLoadMore(true);
        baseBind.smartRefreshLayout.setRefreshHeader(new MaterialHeader(mContext));
        baseBind.smartRefreshLayout.setRefreshFooter(new FalsifyFooter(mContext));
        baseBind.smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                new BaseRequest<QueryContent>("v3plus/season/topList") {
                    @Override
                    public void callBack(QueryContent queryContent) {
                        content = queryContent;
                        SCardAdapter adapter = new SCardAdapter(queryContent.getData().getResults(), mContext);
                        baseBind.recyList.setAdapter(adapter);
                        baseBind.smartRefreshLayout.finishRefresh(true);
                        updateParent();
                    }

                    @Override
                    public void addData(Map<String, Object> map) {
                        super.addData(map);
                        map.put("area", getArea());
                        map.put("page", "1");
                        map.put("range", "T-1");
                    }

                    @Override
                    public Class<QueryContent> asClass() {
                        return QueryContent.class;
                    }
                }.run();
            }
        });
    }

    public String getArea() {
        if (index == 0) {
            return "USK";
        } else if (index == 1) {
            return "KR";
        } else if (index == 2) {
            return "JP";
        } else if (index == 3) {
            return "TH";
        }
        return "USK";
    }

    @Override
    public void lazyData() {
        baseBind.smartRefreshLayout.autoRefresh();
    }

    public void updateParent() {
        if (content == null || content.getData() == null) {
            return;
        }

        if (Common.isEmpty(content.getData().getResults())) {
            return;
        }

        if (mActivity instanceof RankActivity) {
            ((RankActivity) mActivity).setData(content.getData().getResults().get(0));
        }
    }
}
