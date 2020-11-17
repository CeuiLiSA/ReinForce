package ceui.lisa.rrshare.response;

import java.util.List;

import ceui.lisa.rrshare.core.ListShow;

public class QueryContent extends BaseObject<ListContent> implements ListShow<Content> {

    @Override
    public List<Content> getList() {
        return getData().getResults();
    }

    @Override
    public boolean isEnd() {
        return getData().isIsEnd();
    }
}
