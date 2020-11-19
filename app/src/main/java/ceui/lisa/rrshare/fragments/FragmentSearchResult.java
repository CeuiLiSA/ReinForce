package ceui.lisa.rrshare.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.Map;

import ceui.lisa.rrshare.MovieActivity;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.InfoAdapter;
import ceui.lisa.rrshare.adapters.OnItemClickListener;
import ceui.lisa.rrshare.adapters.SCardAdapter;
import ceui.lisa.rrshare.databinding.FragmentSearchResultBinding;
import ceui.lisa.rrshare.network.BaseRequest;
import ceui.lisa.rrshare.response.SearchEpisode;
import ceui.lisa.rrshare.response.SearchMulti;
import ceui.lisa.rrshare.response.SearchUser;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecoration;

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
                search(model.getMovie().getValue());
            }
        });
    }

    @Override
    public void lazyData() {
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
                baseBind.smartRefreshLayout.autoRefresh();
            }
        });
    }


    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_search_result;
    }

    private void search(String word) {
//        if (index == 0) {
//            new BaseRequest<SearchMulti>(method) {
//                @Override
//                public void callBack(SearchMulti searchMulti) {
//                    SCardAdapter adapter = new SCardAdapter(searchMulti.getData().getSeasonList(), mContext);
//                    baseBind.recyList.setAdapter(adapter);
//                    baseBind.smartRefreshLayout.finishRefresh(true);
//                }
//
//                @Override
//                public void addData(Map<String, Object> map) {
//                    map.put("keywords", word);
//                    map.put("size", "10");
//                    map.put("order", "");
//                }
//
//                @Override
//                public Class<SearchMulti> asClass() {
//                    return SearchMulti.class;
//                }
//            }.run();
//        } else if (index == 1) {
//            new BaseRequest<SearchEpisode>(method) {
//                @Override
//                public void callBack(SearchEpisode searchMulti) {
//                    SCardAdapter adapter = new SCardAdapter(searchMulti.getData(), mContext);
//                    baseBind.recyList.setAdapter(adapter);
//                    baseBind.smartRefreshLayout.finishRefresh(true);
//                }
//
//                @Override
//                public void addData(Map<String, Object> map) {
//                    map.put("keywords", word);
//                    map.put("size", "10");
//                    map.put("order", "");
//                }
//
//                @Override
//                public Class<SearchEpisode> asClass() {
//                    return SearchEpisode.class;
//                }
//            }.run();
//        } else if (index == 2) {
//            new BaseRequest<SearchEpisode>(method) {
//                @Override
//                public void callBack(SearchEpisode searchMulti) {
//                    InfoAdapter adapter = new InfoAdapter(searchMulti.getData(), mContext);
//                    adapter.setOnItemClickListener(new OnItemClickListener() {
//                        @Override
//                        public void onItemClick(View v, int position, int viewType) {
//                            Intent intent = new Intent(mContext, MovieActivity.class);
//                            intent.putExtra("content", searchMulti.getData().get(position));
//                            mContext.startActivity(intent);
//                        }
//                    });
//                    baseBind.recyList.setAdapter(adapter);
//                    baseBind.smartRefreshLayout.finishRefresh(true);
//                }
//
//                @Override
//                public void addData(Map<String, Object> map) {
//                    map.put("keywords", word);
//                    map.put("size", "10");
//                    map.put("order", "");
//                }
//
//                @Override
//                public Class<SearchEpisode> asClass() {
//                    return SearchEpisode.class;
//                }
//            }.run();
//        } else if (index == 3) {
//            new BaseRequest<SearchUser>(method) {
//                @Override
//                public void callBack(SearchUser searchMulti) {
//                    baseBind.smartRefreshLayout.finishRefresh(true);
//                }
//
//                @Override
//                public void addData(Map<String, Object> map) {
//                    map.put("keywords", word);
//                    map.put("size", "10");
//                    map.put("order", "");
//                }
//
//                @Override
//                public Class<SearchUser> asClass() {
//                    return SearchUser.class;
//                }
//            }.run();
//        }
    }

}
