package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyInfoBinding;
import ceui.lisa.rrshare.response.ContentHolder;

public class InfoAdapter extends BaseAdapter<ContentHolder, RecyInfoBinding>{

    public InfoAdapter(@Nullable List<ContentHolder> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_info;
    }

    @Override
    public void bindData(ContentHolder target, ViewHolder<RecyInfoBinding> bindView, int position) {

    }
}
