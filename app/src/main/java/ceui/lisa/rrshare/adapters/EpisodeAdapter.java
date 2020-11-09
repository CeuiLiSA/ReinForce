package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyEpisodeBinding;
import ceui.lisa.rrshare.databinding.RecyInfoBinding;
import ceui.lisa.rrshare.response.ContentHolder;
import ceui.lisa.rrshare.response.EpisodeItem;

public class EpisodeAdapter extends BaseAdapter<EpisodeItem, RecyEpisodeBinding>{

    public EpisodeAdapter(@Nullable List<EpisodeItem> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_episode;
    }

    @Override
    public void bindData(EpisodeItem target, ViewHolder<RecyEpisodeBinding> bindView, int position) {
        bindView.baseBind.name.setText(String.valueOf(target.getEpisodeNo()));
    }
}
