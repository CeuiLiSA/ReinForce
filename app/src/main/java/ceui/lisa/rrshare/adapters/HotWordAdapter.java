package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyHotWordBinding;
import ceui.lisa.rrshare.response.SearchRecommend;

public class HotWordAdapter extends BaseAdapter<SearchRecommend, RecyHotWordBinding>{

    public HotWordAdapter(@Nullable List<SearchRecommend> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_hot_word;
    }

    @Override
    public void bindData(SearchRecommend target, ViewHolder<RecyHotWordBinding> bindView, int position) {
        bindView.baseBind.subtitle.setText(target.getSubtitle());
        bindView.baseBind.title.setText(target.getTitle());
    }
}
