package ceui.lisa.rrshare.fragments;

import ceui.lisa.rrshare.adapters.BaseAdapter;
import ceui.lisa.rrshare.adapters.SearchEpisodeAdapter;
import ceui.lisa.rrshare.network.Rx;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.SearchEpisode;
import io.reactivex.rxjava3.core.Observable;

public class FragmentSearchEpisode extends BaseSearchFragment {

    @Override
    public Observable<SearchEpisode> initApi() {
        return Rx.searchEpisode(keyword, id, sort);
    }

    @Override
    public BaseAdapter<Content, ?> initAdapter() {
        return new SearchEpisodeAdapter(allItems, mContext);
    }
}
