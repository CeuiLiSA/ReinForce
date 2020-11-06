package ceui.lisa.rrshare.fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.FragmentRankHolderBinding;
import ceui.lisa.rrshare.response.RankResponse;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class FragmentRankHolder extends BaseFragment<FragmentRankHolderBinding> {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_rank_holder;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
//        final String[] titles = new String[]{
//                "精选",
//                "美剧",
//                "韩剧",
//                "日剧",
//                "泰剧"
//        };
//        final String[] values = new String[]{
//                "CHANNEL_INDEX",
//                "CHANNEL_USK",
//                "CHANNEL_KR",
//                "CHANNEL_JP",
//                "CHANNEL_TH"
//        };
        final String[] titles = new String[]{
                "美剧",
        };
        final String[] values = new String[]{
                "CHANNEL_USK",
        };
        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager(), 0) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return FragmentR.newInstance(values[position]);
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
    }
}
