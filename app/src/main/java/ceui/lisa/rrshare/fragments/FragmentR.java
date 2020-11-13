package ceui.lisa.rrshare.fragments;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.List;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.ItemView;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.TabItem;
import ceui.lisa.rrshare.databinding.FragmentRBinding;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.viewmodel.PageModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

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
                baseBind.smartRefreshLayout.autoRefresh();
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

    @Override
    public boolean forceLoad() {
        return true;
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
