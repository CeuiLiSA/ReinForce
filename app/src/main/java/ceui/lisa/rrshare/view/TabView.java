package ceui.lisa.rrshare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.TabItemBinding;

public class TabView extends TabLayout {

    public TabView(@NonNull Context context) {
        super(context);
    }

    public TabView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TabView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void init() {
        setSelectedTabIndicatorHeight(0);
        for (int i = 0; i < getTabCount(); i++) {
            getTabAt(i).setCustomView(getTabView(getTabAt(i).getText().toString(), i));
        }

        addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView textView = view.findViewById(R.id.tab_text);
                textView.setTextAppearance(R.style.TabSelected);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView textView = view.findViewById(R.id.tab_text);
                textView.setTextAppearance(R.style.TabUnSelect);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private View getTabView(String text, int index) {
        TabItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                R.layout.tab_item, null, false);
        binding.tabText.setText(text);
        if (index == 0) {
            binding.tabText.setTextAppearance(R.style.TabSelected);
        }
        return binding.getRoot();
    }
}
