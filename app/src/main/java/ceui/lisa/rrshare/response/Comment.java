package ceui.lisa.rrshare.response;

import java.util.List;

import ceui.lisa.rrshare.core.ListShow;

public class Comment extends BaseObject<CommentData> implements ListShow<CommentBean> {

    @Override
    public List<CommentBean> getList() {
        return getData().getContent();
    }

    @Override
    public boolean isEnd() {
        return getData().isEnd();
    }
}
