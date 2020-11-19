package ceui.lisa.rrshare.fragments;

import ceui.lisa.rrshare.adapters.BaseAdapter;
import ceui.lisa.rrshare.adapters.InfoAdapter;
import ceui.lisa.rrshare.network.Rx;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.SearchEpisode;
import io.reactivex.rxjava3.core.Observable;

public class FragmentSearchVideo extends BaseSearchFragment {

    @Override
    public Observable<SearchEpisode> initApi() {
        return Rx.searchVideo(keyword, id, sort);
    }

    @Override
    public BaseAdapter<Content, ?> initAdapter() {
        return new InfoAdapter(allItems, mContext);
    }
}
