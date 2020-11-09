package ceui.lisa.rrshare;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import ceui.lisa.rrshare.databinding.ActivityMovieBinding;
import ceui.lisa.rrshare.fragments.FragmentChat;
import ceui.lisa.rrshare.fragments.FragmentComment;
import ceui.lisa.rrshare.fragments.FragmentMovieDetail;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.response.BaseObject;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.Episode;
import ceui.lisa.rrshare.response.EpisodeData;
import ceui.lisa.rrshare.response.Movie;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.response.Quality;
import ceui.lisa.rrshare.response.QualityItem;
import ceui.lisa.rrshare.response.Watch;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.viewmodel.MovieModel;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class MovieActivity extends BaseActivity<ActivityMovieBinding> {

    private Content mContent;
    private MovieModel model;

    @Override
    protected int initLayout() {
        return R.layout.activity_movie;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        mContent = (Content) bundle.getSerializable("content");
    }

    @Override
    public void initModel() {
        model = new ViewModelProvider(this).get(MovieModel.class);
    }

    @Override
    protected void initView() {
        String[] titles = new String[]{"详情", "讨论", "热议"};
        BaseFragment<?>[] fragments = new BaseFragment<?>[]{
                new FragmentMovieDetail(),
                new FragmentComment(),
                new FragmentChat(),
        };
        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 0) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
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

    @Override
    protected void initData() {
        model.getMovie().setValue(mContent);
        Common.showLog("view model 发送了 " + mContent.getTitle());





//        RxHttp.get("https://api.rr.tv/watch/v4/priority_video_quality/get_priority_video_quality_config?seasonId=14752")
//                .addAllHeader(Net.header())
//                .asClass(Quality.class)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Quality>() {
//                    @Override
//                    public void accept(Quality quality) throws Throwable {
//                        for (QualityItem sortedItem : quality.getData().getSortedItems()) {
//                            if (sortedItem.isInitialQuality()) {
//
//                                break;
//                            }
//                        }
//
//                    }
//                });

    }

    @Override
    public boolean hideStatusBar() {
        return true;
    }
}
