package ceui.lisa.rrshare;

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

import java.util.ArrayList;
import java.util.List;

import ceui.lisa.rrshare.adapters.InfoAdapter;
import ceui.lisa.rrshare.adapters.OnItemClickListener;
import ceui.lisa.rrshare.adapters.SCardAdapter;
import ceui.lisa.rrshare.adapters.SimpleAdapter;
import ceui.lisa.rrshare.databinding.RecyPageBinding;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecoration;
import ceui.lisa.rrshare.utils.LinearItemDecorationHorizon;

public class TopView extends FrameLayout {

    protected Context mContext;
    protected RecyPageBinding baseBind;

    public TopView(@NonNull Context context) {
        super(context);
        init();
    }

    public TopView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TopView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public TopView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        mContext = getContext();
        baseBind = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.recy_page, this, true);

    }

    public void bindContent(List<Content> list) {
        List<Content> contents;
        if (list == null || list.size() == 0) {
            return;
        }

        if (list.size() <= 3) {
            contents = list;
        } else {
            contents = new ArrayList<>(list.subList(0, 3));
        }
        baseBind.title.setText("相关视频");
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
        baseBind.recyList.addItemDecoration(
                new LinearItemDecoration(DensityUtil.dp2px(6.0f))
        );
        InfoAdapter adapter = new InfoAdapter(contents, mContext);
        baseBind.recyList.setAdapter(adapter);
    }
}
