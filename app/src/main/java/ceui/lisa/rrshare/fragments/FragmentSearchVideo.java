package ceui.lisa.rrshare.fragments;

import android.text.TextUtils;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ceui.lisa.rrshare.adapters.BaseAdapter;
import ceui.lisa.rrshare.adapters.InfoAdapter;
import ceui.lisa.rrshare.databinding.FragmentListBinding;
import ceui.lisa.rrshare.network.Rx;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.SearchEpisode;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecoration;
import ceui.lisa.rrshare.viewmodel.WordModel;
import io.reactivex.rxjava3.core.Observable;

public class FragmentSearchVideo extends BaseListFragment<FragmentListBinding, SearchEpisode, Content>{

    private WordModel model;
    private String keyword;
    private float sort;
    private int id;

    @Override
    public void initModel() {
        model = new ViewModelProvider(mActivity).get(WordModel.class);
        model.getMovie().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                keyword = s;
                sort = 0.0f;
                id = 0;
                if (!TextUtils.isEmpty(keyword) && isLoaded) {
                    if (isLoaded) {
                        isLoaded = false;
                    }
                    shouldLoadData();
                }
            }
        });
    }

    @Override
    public Observable<SearchEpisode> initApi() {
        return Rx.searchVideo(keyword, id, sort);
    }

    @Override
    public void beforeRefresh() {
        super.beforeRefresh();
        sort = 0.0f;
        id = 0;
    }

    @Override
    public void initRecyclerView() {
        mRecyclerView.addItemDecoration(new LinearItemDecoration(DensityUtil.dp2px(12.0f)));
    }

    @Override
    public void firstAfter() {
        if (!Common.isEmpty(allItems)) {
            sort = allItems.get(allItems.size() - 1).getSort();
            id = allItems.get(allItems.size() - 1).getId();
        }
    }

    @Override
    public void nextAfter() {
        if (!Common.isEmpty(allItems)) {
            sort = allItems.get(allItems.size() - 1).getSort();
            id = allItems.get(allItems.size() - 1).getId();
        }
    }

    @Override
    public BaseAdapter<Content, ?> initAdapter() {
        return new InfoAdapter(allItems, mContext);
    }
}
