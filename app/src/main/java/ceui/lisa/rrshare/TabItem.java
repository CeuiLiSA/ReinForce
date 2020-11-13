package ceui.lisa.rrshare;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.google.android.material.tabs.TabLayout;

import ceui.lisa.rrshare.adapters.OnItemClickListener;
import ceui.lisa.rrshare.adapters.SimpleAdapter;
import ceui.lisa.rrshare.databinding.RecyTabBinding;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecorationHorizon;

public class TabItem extends ItemView {

    private RecyTabBinding baseBind;

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
        for (Content content : section.getContent()) {
            TabLayout.Tab tab = baseBind.tabLayout.newTab();
            tab.setText(content.getName());
            tab.setTag(content);
            baseBind.tabLayout.addTab(tab);
        }
        baseBind.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getTag() instanceof Content) {
                    Content holder = (Content) tab.getTag();
                    SimpleAdapter adapter = new SimpleAdapter(holder.getDataList(), mContext);
                    adapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int position, int viewType) {
                            Intent intent = new Intent(mContext, MovieActivity.class);
                            intent.putExtra("content", holder.getDataList().get(position));
                            mContext.startActivity(intent);
                        }
                    });
                    baseBind.recyList.setAdapter(adapter);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

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
    }

    @Override
    public void init() {
        mContext = getContext();
        baseBind = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                R.layout.recy_tab, this, true);
        baseBind.recyList.addItemDecoration(
                new LinearItemDecorationHorizon(DensityUtil.dp2px(8.0f))
        );
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(
                mContext, LinearLayoutManager.HORIZONTAL, false
        ));
    }
}
