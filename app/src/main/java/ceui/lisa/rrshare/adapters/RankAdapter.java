package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyRankBinding;
import ceui.lisa.rrshare.response.RankBean;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class RankAdapter extends BaseAdapter<RankBean, RecyRankBinding>{

    public RankAdapter(@Nullable List<RankBean> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_rank;
    }

    @Override
    public void bindData(RankBean target, ViewHolder<RecyRankBinding> bindView, int position) {
        bindView.baseBind.name.setText(target.getCnname());
        Glide.with(mContext)
                .load(target.getPoster())
                .transition(withCrossFade())
                .into(bindView.baseBind.imageView);
    }
}
