package ceui.lisa.rrshare.fragments;

import android.os.Bundle;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.io.Serializable;
import java.util.List;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.RankAdapter;
import ceui.lisa.rrshare.databinding.FragmentRankBinding;
import ceui.lisa.rrshare.response.RankBean;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.TagItemDecoration;

public class FragmentRank extends BaseFragment<FragmentRankBinding> {

    private List<RankBean> content;

    public static FragmentRank newInstance(List<RankBean> list) {
        Bundle args = new Bundle();
        args.putSerializable("content", (Serializable) list);
        FragmentRank fragment = new FragmentRank();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_rank;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        content = (List<RankBean>) bundle.getSerializable("content");
    }

    @Override
    protected void initView() {
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        baseBind.recyList.setLayoutManager(manager);
        baseBind.recyList.addItemDecoration(new TagItemDecoration(DensityUtil.dp2px(8.0f)));
        RankAdapter adapter = new RankAdapter(content, mContext);
        baseBind.recyList.setAdapter(adapter);
        Common.showLog("data set adapter");
    }
}
