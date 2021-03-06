package ceui.lisa.rrshare;

import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import ceui.lisa.rrshare.databinding.ActivitySearchBinding;
import ceui.lisa.rrshare.databinding.TabItemBinding;
import ceui.lisa.rrshare.fragments.FragmentHotWords;
import ceui.lisa.rrshare.network.BaseRequest;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Hot;
import ceui.lisa.rrshare.response.HotData;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.viewmodel.SearchModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class SearchActivity extends BaseActivity<ActivitySearchBinding> {

    private SearchModel model;

    @Override
    protected int initLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initView() {
        baseBind.tabLayout.setupWithViewPager(baseBind.viewPager);
        baseBind.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(baseBind.inputBox.getText().toString())) {
                    Intent intent = new Intent(mContext, SearchResultActivity.class);
                    intent.putExtra("keyword", baseBind.inputBox.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void initModel() {
        model = new ViewModelProvider(this).get(SearchModel.class);
        model.getMovie().observe(this, new Observer<Hot>() {
            @Override
            public void onChanged(Hot hot) {
                List<HotData> enable = new ArrayList<>();
                for (HotData datum : hot.getData()) {
                    if ("1".equals(datum.getEnabled())) {
                        enable.add(datum);
                    }
                }
                baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 0) {
                    @NonNull
                    @Override
                    public Fragment getItem(int position) {
                        return FragmentHotWords.newInstance(enable.get(position));
                    }

                    @Override
                    public int getCount() {
                        return enable.size();
                    }

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return enable.get(position).getHotRecommend();
                    }
                });
                baseBind.tabLayout.init();
            }
        });
    }

    @Override
    protected void initData() {
        if (model.getMovie().getValue() == null) {
            new BaseRequest<Hot>("hot/recommend/list") {
                @Override
                public void callBack(Hot hot) {
                    model.getMovie().setValue(hot);
                }

                @Override
                public Class<Hot> asClass() {
                    return Hot.class;
                }
            }.run();
        }
    }
}
