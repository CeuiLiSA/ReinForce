package ceui.lisa.rrshare.response;

import java.util.List;

import ceui.lisa.rrshare.core.ListShow;
import ceui.lisa.rrshare.utils.Common;

public class SearchEpisode extends BaseList<Content> implements ListShow<Content> {

    @Override
    public List<Content> getList() {
        return getData();
    }

    @Override
    public boolean isEnd() {
        return Common.isEmpty(getData());
    }
}
