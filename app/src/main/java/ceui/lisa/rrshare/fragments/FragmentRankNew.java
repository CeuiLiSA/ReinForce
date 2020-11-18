package ceui.lisa.rrshare.fragments;

import android.os.Bundle;

import ceui.lisa.rrshare.RankActivity;
import ceui.lisa.rrshare.adapters.BaseAdapter;
import ceui.lisa.rrshare.adapters.RankAdapter;
import ceui.lisa.rrshare.databinding.FragmentListBinding;
import ceui.lisa.rrshare.network.Rx;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.QueryContent;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.core.Observable;

public class FragmentRankNew extends BaseListFragment<FragmentListBinding, QueryContent, Content> {

    private String type;

    public static FragmentRankNew newInstance(String type) {
        Bundle args = new Bundle();
        args.putString("type", type);
        FragmentRankNew fragment = new FragmentRankNew();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        type = bundle.getString("type");
    }

    @Override
    public Observable<QueryContent> initApi() {
        return Rx.getRank(type, "T-1", nowPage);
    }

    @Override
    public BaseAdapter<Content, ?> initAdapter() {
        return new RankAdapter(allItems, mContext);
    }

    @Override
    public void firstAfter() {
        updateParent();
    }

    public void updateParent() {
        if (Common.isEmpty(allItems)) {
            return;
        }

        if (mActivity instanceof RankActivity) {
            ((RankActivity) mActivity).setData(allItems.get(0));
        }
    }
}
