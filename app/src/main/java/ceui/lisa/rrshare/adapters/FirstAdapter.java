package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyEpisodeBinding;
import ceui.lisa.rrshare.databinding.RecyFirstLookBinding;
import ceui.lisa.rrshare.response.EpisodeItem;
import ceui.lisa.rrshare.response.FirstLook;

public class FirstAdapter extends BaseAdapter<FirstLook, RecyFirstLookBinding>{

    public FirstAdapter(@Nullable List<FirstLook> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_first_look;
    }

    @Override
    public void bindData(FirstLook target, ViewHolder<RecyFirstLookBinding> bindView, int position) {
        bindView.baseBind.name.setText(String.valueOf(target.getTitle()));
        if (target.isPlaying()) {
            bindView.baseBind.name.setTextColor(mContext.getResources().getColor(R.color.orange));
        } else {
            bindView.baseBind.name.setTextColor(mContext.getResources().getColor(R.color.black));
        }
    }
}
