package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyScardBinding;
import ceui.lisa.rrshare.response.ContentHolder;

public class SCardAdapter extends BaseAdapter<ContentHolder, RecyScardBinding> {

    public SCardAdapter(@Nullable List<ContentHolder> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_scard;
    }

    @Override
    public void bindData(ContentHolder target, ViewHolder<RecyScardBinding> bindView, int position) {
        bindView.baseBind.desc.setText(target.getSubTitle());
        if (target.getTitle().contains("第")) {
            bindView.baseBind.title.setText(target.getTitle().split("第")[0]);
            bindView.baseBind.season.setText("第" + target.getTitle().split("第")[1]);
        } else {
            bindView.baseBind.title.setText(target.getTitle());
            bindView.baseBind.season.setText("第一季");
        }
        bindView.baseBind.score.setText(target.getScore());
        bindView.baseBind.tags.setText(target.getCat());
        Glide.with(mContext).load(target.getCover()).into(bindView.baseBind.imageView);
    }
}
