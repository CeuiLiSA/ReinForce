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

import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.FalsifyHeader;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.wrapper.RefreshFooterWrapper;

import ceui.lisa.rrshare.adapters.InfoAdapter;
import ceui.lisa.rrshare.adapters.NewInfoAdapter;
import ceui.lisa.rrshare.adapters.OnItemClickListener;
import ceui.lisa.rrshare.adapters.SCardAdapter;
import ceui.lisa.rrshare.adapters.SimpleAdapter;
import ceui.lisa.rrshare.databinding.RecyPageBinding;
import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecoration;
import ceui.lisa.rrshare.utils.LinearItemDecorationHorizon;

public class ItemView extends FrameLayout {

    protected Context mContext;
    private RecyPageBinding baseBind;

    public ItemView(@NonNull Context context) {
        super(context);
        init();
    }

    public ItemView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ItemView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public void init() {
        mContext = getContext();
        baseBind = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.recy_page, this, true);
    }

    public void bindSection(Section section) {
        baseBind.title.setText(section.getName());
        if ("BILLBOARD".equals(section.getSectionType())) {
            Common.showLog("bindSection 000 " + section.getName());
            baseBind.recyList.addItemDecoration(
                    new LinearItemDecorationHorizon(DensityUtil.dp2px(8.0f))
            );
            baseBind.recyList.setLayoutManager(
                    new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            );
            SimpleAdapter adapter = new SimpleAdapter(section.getContent().get(0).getDataList(), mContext);
            adapter.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(View v, int position, int viewType) {
                    Intent intent = new Intent(mContext, MovieActivity.class);
                    intent.putExtra("content", section.getContent().get(0).getDataList().get(position));
                    mContext.startActivity(intent);
                }
            });
            baseBind.recyList.setAdapter(adapter);
        } else if ("SEASON_CARD".equals(section.getSectionType()) ||
                "SEASON".equals(section.getSectionType())) {
            Common.showLog("bindSection 111 " + section.getName());
            baseBind.recyList.addItemDecoration(
                    new LinearItemDecorationHorizon(DensityUtil.dp2px(8.0f))
            );
            baseBind.recyList.setLayoutManager(
                    new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            );
            SCardAdapter adapter = new SCardAdapter(section.getContent(), mContext);
            baseBind.recyList.setAdapter(adapter);
        } else if ("INFO".equals(section.getSectionType())) {
            Common.showLog("bindSection 222 " + section.getName());
            baseBind.recyList.addItemDecoration(
                    new LinearItemDecoration(DensityUtil.dp2px(8.0f))
            );
            baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
            NewInfoAdapter adapter = new NewInfoAdapter(section.getContent(), mContext);
            baseBind.recyList.setAdapter(adapter);
        }
    }
}
