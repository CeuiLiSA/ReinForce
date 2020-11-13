package ceui.lisa.rrshare.fragments;

import android.os.Bundle;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.HotWordAdapter;
import ceui.lisa.rrshare.databinding.FragmentHotWordsBinding;
import ceui.lisa.rrshare.response.Hot;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.viewmodel.SearchModel;

public class FragmentHotWords extends SwipeFragment<FragmentHotWordsBinding> {

    private SearchModel model;
    private int index;

    public static FragmentHotWords newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        FragmentHotWords fragment = new FragmentHotWords();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        index = bundle.getInt("index");
    }

    @Override
    public void initModel() {
        model = new ViewModelProvider(mActivity).get(SearchModel.class);
        model.getMovie().observe(this, new Observer<Hot>() {
            @Override
            public void onChanged(Hot hot) {
                Common.showLog(className + hot.getData().get(index).getHotRecommend());
                baseBind.recyList.setAdapter(new HotWordAdapter(hot.getData().get(index).getSearchRecommendDtos(), mContext));
            }
        });
    }

    @Override
    protected void initView() {
        baseBind.recyList.setLayoutManager(new GridLayoutManager(mContext, 2));
    }

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_hot_words;
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return baseBind.smartRefreshLayout;
    }
}
