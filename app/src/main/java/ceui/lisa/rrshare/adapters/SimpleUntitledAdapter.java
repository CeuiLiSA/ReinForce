package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyHorizonBinding;
import ceui.lisa.rrshare.response.Content;

public class SimpleUntitledAdapter extends BaseAdapter<Content, RecyHorizonBinding> {

    private boolean showSubtitle;

    public SimpleUntitledAdapter(@Nullable List<Content> targetList, Context context, boolean showSubtitle) {
        super(targetList, context);
        this.showSubtitle = showSubtitle;
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_horizon;
    }

    @Override
    public void bindData(Content target, ViewHolder<RecyHorizonBinding> bindView, int position) {
        bindView.baseBind.score.setText(String.valueOf(target.getScore()));
        if (target.getTitle().contains("第")) {
            bindView.baseBind.name.setText(target.getTitle().split("第")[0]);
        } else {
            bindView.baseBind.name.setText(target.getTitle());
        }
        if (showSubtitle) {
            bindView.baseBind.subtitle.setText(target.getSubTitle());
        } else {
            bindView.baseBind.subtitle.setText(target.getCat());
        }
        Glide.with(mContext).load(target.getCover()).into(bindView.baseBind.imageView);
    }
}
