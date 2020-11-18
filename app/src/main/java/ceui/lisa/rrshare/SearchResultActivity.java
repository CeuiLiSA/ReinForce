package ceui.lisa.rrshare;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import ceui.lisa.rrshare.databinding.ActivitySearchBinding;
import ceui.lisa.rrshare.fragments.FragmentSearchResult;
import ceui.lisa.rrshare.fragments.FragmentSearchVideo;
import ceui.lisa.rrshare.viewmodel.WordModel;

public class SearchResultActivity extends BaseActivity<ActivitySearchBinding> {

    private String keyword;
    private WordModel mModel;

    @Override
    public void initModel() {
        mModel = new ViewModelProvider(this).get(WordModel.class);
    }

    @Override
    protected int initLayout() {
        return R.layout.activity_search;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        keyword = bundle.getString("keyword");
    }

    @Override
    protected void initView() {
        baseBind.inputBox.setText(keyword);
        String[] titles = new String[]{"综合", "影视", "视频", "用户"};
        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 0) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                if (position == 2) {
                    return new FragmentSearchVideo();
                } else {
                    return FragmentSearchResult.newInstance(position);
                }
            }

            @Override
            public int getCount() {
                return titles.length;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return titles[position];
            }
        });
        baseBind.tabLayout.setupWithViewPager(baseBind.viewPager);
        baseBind.tabLayout.init();
    }

    @Override
    protected void initData() {
        mModel.getMovie().setValue(keyword);
    }
}
