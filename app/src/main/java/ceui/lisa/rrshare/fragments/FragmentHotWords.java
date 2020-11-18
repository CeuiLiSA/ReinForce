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
import ceui.lisa.rrshare.response.HotData;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.viewmodel.SearchModel;

public class FragmentHotWords extends SwipeFragment<FragmentHotWordsBinding> {

    private HotData hotData;

    public static FragmentHotWords newInstance(HotData hotData) {
        Bundle args = new Bundle();
        args.putSerializable("hotData", hotData);
        FragmentHotWords fragment = new FragmentHotWords();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        hotData = (HotData) bundle.getSerializable("hotData");
    }

    @Override
    protected void initView() {
        baseBind.recyList.setLayoutManager(new GridLayoutManager(mContext, 2));
        HotWordAdapter adapter = new HotWordAdapter(hotData.getSearchRecommendDtos(), mContext);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, int viewType) {
                if (!TextUtils.isEmpty(hotData.getSearchRecommendDtos().get(position).getSearchKeyword())) {
                    Intent intent = new Intent(mContext, SearchResultActivity.class);
                    intent.putExtra("keyword", hotData.getSearchRecommendDtos().get(position).getSearchKeyword());
                    startActivity(intent);
                }
            }
        });
        baseBind.recyList.setAdapter(adapter);
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
