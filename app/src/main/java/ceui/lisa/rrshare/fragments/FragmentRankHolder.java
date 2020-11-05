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
        getFirstData();
    }

    private void getFirstData() {
        RxHttp.get("http://a.zmzapi.com/index.php?g=api/v3&m=index&accesskey=519f9cab85c8059d17544947k361a827&client=2&a=hot&limit=50")
                .addHeader("Accept-Language", "zh-CN,zh;q=0.8")
                .addHeader("User-Agent", "Mozilla/5.0 (Linux; U; Android 6.0.1; zh-cn; D6653 Build/23.5.A.1.291) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30")
                .addHeader("Host", "a.zmzapi.com")
                .asClass(RankResponse.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RankResponse>() {
                    @Override
                    public void accept(RankResponse rankResponse) {
                        try {
                            final String[] titles = new String[]{"今日", "本月", "电影", "日剧", "新剧", "总榜"};
                            baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager(), 0) {
                                @NonNull
                                @Override
                                public Fragment getItem(int position) {
                                    return FragmentRank.newInstance(rankResponse.getList(position));
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
                            Common.showLog("data set setupWithViewPager");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });
    }
}
