package ceui.lisa.rrshare.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.SearchResultActivity;
import ceui.lisa.rrshare.adapters.HotWordAdapter;
import ceui.lisa.rrshare.adapters.OnItemClickListener;
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
                HotWordAdapter adapter = new HotWordAdapter(hot.getData().get(index).getSearchRecommendDtos(), mContext);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(View v, int position, int viewType) {
                        if (!TextUtils.isEmpty(hot.getData().get(index).getSearchRecommendDtos().get(position).getSearchKeyword())) {
                            Intent intent = new Intent(mContext, SearchResultActivity.class);
                            intent.putExtra("keyword", hot.getData().get(index).getSearchRecommendDtos().get(position).getSearchKeyword());
                            startActivity(intent);
                        }
                    }
                });
                baseBind.recyList.setAdapter(adapter);
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
