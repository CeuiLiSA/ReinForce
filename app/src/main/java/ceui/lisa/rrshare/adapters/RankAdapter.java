package ceui.lisa.rrshare.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.MovieActivity;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyRankBinding;
import ceui.lisa.rrshare.response.Content;

public class RankAdapter extends BaseAdapter<Content, RecyRankBinding> {

    public RankAdapter(@Nullable List<Content> targetList, Context context) {
        super(targetList, context);
        handleClick();
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_rank;
    }

    @Override
    public void bindData(Content target, ViewHolder<RecyRankBinding> bindView, int position) {
        bindView.baseBind.index.setText(String.valueOf(position + 1));
        bindView.baseBind.title.setText(target.getTitle());
        bindView.baseBind.tags.setText(target.getCat());
        bindView.baseBind.size.setText("共" + target.getUpInfo() + "集");
        Glide.with(mContext).load(target.getCover()).into(bindView.baseBind.imageView);
    }

    public void handleClick() {
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, int viewType) {
                Intent intent = new Intent(mContext, MovieActivity.class);
                intent.putExtra("content", allIllust.get(position));
                mContext.startActivity(intent);
            }
        });
    }
}
