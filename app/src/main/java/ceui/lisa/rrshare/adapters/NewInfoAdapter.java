package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyInfoBinding;
import ceui.lisa.rrshare.response.Content;

public class NewInfoAdapter extends BaseAdapter<Content, RecyInfoBinding>{

    public NewInfoAdapter(@Nullable List<Content> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_info;
    }

    @Override
    public void bindData(Content target, ViewHolder<RecyInfoBinding> bindView, int position) {
        Glide.with(mContext).load(target.getCover()).into(bindView.baseBind.imageView);
        bindView.baseBind.title.setText(target.getTitle());
        bindView.baseBind.auther.setText(target.getAuthor().getName());
    }
}
