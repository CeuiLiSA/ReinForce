package ceui.lisa.rrshare.fragments;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Map;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.CommentAdapter;
import ceui.lisa.rrshare.databinding.FragmentCommentBinding;
import ceui.lisa.rrshare.network.BaseRequest;
import ceui.lisa.rrshare.response.Comment;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.utils.Common;

public class FragmentComment extends BaseMovieFragment<FragmentCommentBinding> {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_comment;
    }

    @Override
    protected void initView() {
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
    }

    @Override
    public void initModel() {
        super.initModel();
        model.getMovie().observe(getViewLifecycleOwner(), new Observer<Content>() {
            @Override
            public void onChanged(Content content) {
                if (content != null) {
                    Common.showLog("view model " + className + "收到了" + content.getTitle());
                    getComment(content.getId());
                } else {
                    Common.showLog("view model " + className + "收到了 null");
                }
            }
        });
    }

    private void getComment(int id) {
        new BaseRequest<Comment>("rrtv-comment/comment/mergeList") {

            @Override
            public void callBack(Comment comment) {
                CommentAdapter adapter = new CommentAdapter(comment.getData().getContent(), mContext);
                baseBind.recyList.setAdapter(adapter);
            }

            @Override
            public Class<Comment> asClass() {
                return Comment.class;
            }

            @Override
            public void addData(Map<String, Object> map) {
                map.put("page", 1);
                map.put("type", "相关视频".equals(model.getMovie().getValue().getFrom()) ? "VIDEO" : "SEASON");
                map.put("typeId", id);
            }
        }.run();
    }
}
