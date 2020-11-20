package ceui.lisa.rrshare.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.MovieActivity;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecySearchEpisodeBinding;
import ceui.lisa.rrshare.response.Content;

public class SearchEpisodeAdapter extends BaseAdapter<Content, RecySearchEpisodeBinding> {

    public SearchEpisodeAdapter(@Nullable List<Content> targetList, Context context) {
        super(targetList, context);
        handleClick();
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_search_episode;
    }

    @Override
    public void bindData(Content target, ViewHolder<RecySearchEpisodeBinding> bindView, int position) {
        bindView.baseBind.desc.setText(target.getBrief());
        bindView.baseBind.title.setText(target.getTitle());
        bindView.baseBind.season.setText(target.getAreaDetail());
        bindView.baseBind.score.setText(target.getScore());
        bindView.baseBind.year.setText(target.getYear());
        bindView.baseBind.tags.setText(target.getCat());
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
