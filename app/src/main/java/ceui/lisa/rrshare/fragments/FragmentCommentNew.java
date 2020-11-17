package ceui.lisa.rrshare.fragments;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ceui.lisa.rrshare.adapters.BaseAdapter;
import ceui.lisa.rrshare.adapters.CommentAdapter;
import ceui.lisa.rrshare.databinding.FragmentListBinding;
import ceui.lisa.rrshare.network.Rx;
import ceui.lisa.rrshare.response.Comment;
import ceui.lisa.rrshare.response.CommentBean;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.viewmodel.MovieModel;
import io.reactivex.rxjava3.core.Observable;

public class FragmentCommentNew extends BaseListFragment<FragmentListBinding, Comment, CommentBean> {

    private MovieModel model;
    private int typeID;
    private String type;

    @Override
    public void initModel() {
        model = new ViewModelProvider(mActivity).get(MovieModel.class);
        model.getMovie().observe(getViewLifecycleOwner(), new Observer<Content>() {
            @Override
            public void onChanged(Content content) {
                if (content != null) {
                    type = "相关视频".equals(model.getMovie().getValue().getFrom()) ? "VIDEO" : "SEASON";
                    typeID = content.getId();
                }
            }
        });
    }

    @Override
    public Observable<Comment> initApi() {
        return Rx.getComment(type, typeID, nowPage);
    }

    @Override
    public BaseAdapter<CommentBean, ?> initAdapter() {
        return new CommentAdapter(allItems, mContext);
    }
}
