package ceui.lisa.rrshare;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import ceui.lisa.rrshare.databinding.ActivitySearchBinding;
import ceui.lisa.rrshare.fragments.FragmentSearchEpisode;
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
        String[] titles = new String[]{"影视", "视频"};
        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 0) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                if (position == 0) {
                    return new FragmentSearchEpisode();
                } else if (position == 1) {
                    return new FragmentSearchVideo();
                } else {
                    return new Fragment();
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
        baseBind.more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(baseBind.inputBox.getText().toString())) {
                    keyword = baseBind.inputBox.getText().toString();
                    initData();
                }
            }
        });
    }

    @Override
    protected void initData() {
        mModel.getMovie().setValue(keyword);
    }
}
