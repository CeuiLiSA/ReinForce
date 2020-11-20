package ceui.lisa.rrshare.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import ceui.lisa.rrshare.MovieActivity;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.FirstAdapter;
import ceui.lisa.rrshare.adapters.OnItemClickListener;
import ceui.lisa.rrshare.adapters.SimpleAdapter;
import ceui.lisa.rrshare.databinding.RecyPageBinding;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.FirstLook;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecorationHorizon;

public class FirstView extends FrameLayout {

    protected Context mContext;
    protected RecyPageBinding baseBind;

    public FirstView(@NonNull Context context) {
        super(context);
        init();
    }

    public FirstView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FirstView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public FirstView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        mContext = getContext();
        baseBind = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.recy_page, this, true);

    }

    public void bindContent(List<FirstLook> list) {
        baseBind.title.setText("抢先看");
        baseBind.recyList.addItemDecoration(
                new LinearItemDecorationHorizon(DensityUtil.dp2px(12.0f))
        );
        baseBind.recyList.setLayoutManager(
                new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
        );
        FirstAdapter adapter = new FirstAdapter(list, mContext);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position, int viewType) {
//                Intent intent = new Intent(mContext, MovieActivity.class);
//                intent.putExtra("content", list.get(position));
//                mContext.startActivity(intent);
            }
        });
        baseBind.recyList.setAdapter(adapter);
    }
}
