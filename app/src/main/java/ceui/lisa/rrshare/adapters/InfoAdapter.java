package ceui.lisa.rrshare.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

import ceui.lisa.rrshare.MovieActivity;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyInfoBinding;
import ceui.lisa.rrshare.response.Content;

public class InfoAdapter extends BaseAdapter<Content, RecyInfoBinding>{

    public InfoAdapter(@Nullable List<Content> targetList, Context context) {
        super(targetList, context);
        handleClick();
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_info;
    }

    @Override
    public void bindData(Content target, ViewHolder<RecyInfoBinding> bindView, int position) {
        Glide.with(mContext).load(target.getCover()).into(bindView.baseBind.imageView);
        bindView.baseBind.title.setText(target.getTitle());
        bindView.baseBind.auther.setText(target.getAuthor().getNickName());
    }

    public void handleClick() {
        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, int viewType) {
                Intent intent = new Intent(mContext, MovieActivity.class);
                allIllust.get(position).setFrom("相关视频");
                intent.putExtra("content", allIllust.get(position));
                mContext.startActivity(intent);
            }
        });
    }
}
