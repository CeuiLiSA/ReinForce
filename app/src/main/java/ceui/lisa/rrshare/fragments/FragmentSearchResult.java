package ceui.lisa.rrshare.fragments;

import android.os.Bundle;
import android.view.View;

import androidx.lifecycle.Observer;

import java.util.Map;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.FragmentSearchResultBinding;
import ceui.lisa.rrshare.network.BaseRequest;
import ceui.lisa.rrshare.response.SearchResult;

public class FragmentSearchResult extends BaseWordFragment<FragmentSearchResultBinding> {

    private int index;
    private String method;

    public static FragmentSearchResult newInstance(int index) {
        Bundle args = new Bundle();
        args.putInt("index", index);
        FragmentSearchResult fragment = new FragmentSearchResult();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        index = bundle.getInt("index");
    }

    @Override
    public void lazyData() {
        super.lazyData();
        if (index == 0) {
            method = "search/multiple";
        } else if (index == 1) {
            method = "search/season";
        } else if (index == 2) {
            method = "search/video";
        } else if (index == 3) {
            method = "search/uper";
        }
        model.getMovie().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                search(s);
            }
        });
    }

    @Override
    public boolean forceLoad() {
        return index == 0;
    }

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_search_result;
    }

    private void search(String word) {
        new BaseRequest<SearchResult>(method) {
            @Override
            public void callBack(SearchResult searchResult) {
                baseBind.progress.setVisibility(View.GONE);
            }

            @Override
            public void addData(Map<String, Object> map) {
                map.put("keywords", word);
                map.put("size", "10");
                map.put("order", "");
            }

            @Override
            public Class<SearchResult> asClass() {
                return SearchResult.class;
            }
        }.run();
    }
}
