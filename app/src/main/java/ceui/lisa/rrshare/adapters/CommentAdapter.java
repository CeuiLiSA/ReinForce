package ceui.lisa.rrshare.adapters;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyCommentBinding;
import ceui.lisa.rrshare.response.CommentBean;

public class CommentAdapter extends BaseAdapter<CommentBean, RecyCommentBinding> {

    public CommentAdapter(@Nullable List<CommentBean> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_comment;
    }

    @Override
    public void bindData(CommentBean target, ViewHolder<RecyCommentBinding> bindView, int position) {
        bindView.baseBind.userName.setText(target.getAuthor().getNickName());
        bindView.baseBind.content.setText(target.getContent());
        bindView.baseBind.time.setText(target.getCreateTimeStr());
        bindView.baseBind.likeCount.setText(String.valueOf(target.getLikeCount()));
        if (target.getReplies() != null && target.getReplies().size() != 0) {
            bindView.baseBind.replyComment.setVisibility(View.VISIBLE);


            ClickableSpan clickableSpan = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    mOnItemClickListener.onItemClick(widget, position, 3);
                }

                @Override
                public void updateDrawState(TextPaint ds) {
                    ds.setColor(Color.parseColor("#507daf"));
                }
            };

            SpannableString spannableString = new SpannableString(String.format("@%s：%s",
                    target.getReplies().get(0).getAuthorName(),
                    target.getReplies().get(0).getContent()));
            spannableString.setSpan(clickableSpan,
                    0, target.getReplies().get(0).getAuthorName().length() + 1,
                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            bindView.baseBind.replyContent.setText(spannableString);
        } else {
            bindView.baseBind.replyComment.setVisibility(View.GONE);
        }
        Glide.with(mContext).load(target.getAuthor().getHeadImgUrl()).into(bindView.baseBind.userHead);
    }
}
