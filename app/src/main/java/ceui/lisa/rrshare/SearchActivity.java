package ceui.lisa.rrshare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ceui.lisa.rrshare.databinding.ActivitySearchBinding;
import ceui.lisa.rrshare.fragments.FragmentHotWords;
import ceui.lisa.rrshare.network.BaseRequest;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Hot;
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
    }

    @Override
    public void initModel() {
        model = new ViewModelProvider(this).get(SearchModel.class);
        model.getMovie().observe(this, new Observer<Hot>() {
            @Override
            public void onChanged(Hot hot) {
                baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 0) {
                    @NonNull
                    @Override
                    public Fragment getItem(int position) {
                        return FragmentHotWords.newInstance(position);
                    }

                    @Override
                    public int getCount() {
                        return hot.getData().size();
                    }

                    @Nullable
                    @Override
                    public CharSequence getPageTitle(int position) {
                        return hot.getData().get(position).getHotRecommend();
                    }
                });
            }
        });
    }

    @Override
    protected void initData() {
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
