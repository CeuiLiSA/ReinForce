package ceui.lisa.rrshare;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecoration;
import ceui.lisa.rrshare.utils.LinearItemDecorationHorizon;

public class TabItem extends ItemView {

    public TabItem(@NonNull Context context) {
        super(context);
    }

    public TabItem(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TabItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TabItem(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void bindSection(Section section) {

    }

    @Override
    public void init() {
        mContext = getContext();
        baseBind = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.recy_page, this, true);
        baseBind.recyList.addItemDecoration(
                new LinearItemDecoration(DensityUtil.dp2px(8.0f))
        );
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
    }
}
