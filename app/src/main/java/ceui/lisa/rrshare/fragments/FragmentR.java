package ceui.lisa.rrshare.fragments;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;

import ceui.lisa.rrshare.R;

public class FragmentR extends FragmentMovie {

    @Override
    protected void initView() {
        super.initView();
        baseBind.toolbar.setVisibility(View.VISIBLE);
        baseBind.toolbar.inflateMenu(R.menu.main_menu);
        baseBind.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_1) {
                    type = "CHANNEL_INDEX";
                } else if (item.getItemId() == R.id.action_2) {
                    type = "CHANNEL_USK";
                } else if (item.getItemId() == R.id.action_3) {
                    type = "CHANNEL_KR";
                } else if (item.getItemId() == R.id.action_4) {
                    type = "CHANNEL_JP";
                } else if (item.getItemId() == R.id.action_5) {
                    type = "CHANNEL_TH";
                } else if (item.getItemId() == R.id.action_6) {
                    type = "CHANNEL_CHN";
                }
                baseBind.toolbar.setTitle(getNameByType());
                baseBind.scrollView.smoothScrollTo(0, 0);
                baseBind.scrollView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        baseBind.smartRefreshLayout.autoRefresh();
                    }
                }, 300L);
                return true;
            }
        });
    }

    @Override
    public void lazyData() {
        type = "CHANNEL_INDEX";
        baseBind.toolbar.setTitle(getNameByType());
        super.lazyData();
    }

    private String getNameByType() {
        if ("CHANNEL_INDEX".equals(type)) {
            return "精选";
        } else if ("CHANNEL_USK".equals(type)) {
            return "美剧";
        } else if ("CHANNEL_KR".equals(type)) {
            return "韩剧";
        } else if ("CHANNEL_JP".equals(type)) {
            return "日剧";
        } else if ("CHANNEL_TH".equals(type)) {
            return "泰剧";
        } else if ("CHANNEL_CHN".equals(type)) {
            return "国产剧";
        }
        return "ReinForce";
    }
}
