package ceui.lisa.rrshare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import ceui.lisa.rrshare.databinding.ActivityMovieBinding;
import ceui.lisa.rrshare.fragments.FragmentMovieDetail;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.response.Episode;
import ceui.lisa.rrshare.response.Movie;
import ceui.lisa.rrshare.response.Page;
import ceui.lisa.rrshare.response.Quality;
import ceui.lisa.rrshare.response.QualityItem;
import ceui.lisa.rrshare.response.Watch;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class MovieActivity extends BaseActivity<ActivityMovieBinding> {

    @Override
    protected int initLayout() {
        return R.layout.activity_movie;
    }

    @Override
    protected void initView() {
        String[] titles = new String[]{"详情", "讨论", "热议"};
        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 0) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return new FragmentMovieDetail();
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
//        RxHttp.get("https://api.rr.tv/rrtv-video/v4plus/season/get_episode_list")
//                .addAllHeader(Net.header())
//                .add("seasonId", "14752")
//                .asClass(Episode.class)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Episode>() {
//                    @Override
//                    public void accept(Episode episode) throws Throwable {
//
//                    }
//                });


//        RxHttp.get("https://api.rr.tv/rrtv-video/v4plus/season/detail")
//                .addAllHeader(Net.header())
//                .add("seasonId", "14752")
//                .add("token", "rrtv-b2228b19a37039db54172e9648c02a5dab579c88")
//                .asClass(Movie.class)
//                .subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<Movie>() {
//                    @Override
//                    public void accept(Movie episode) throws Throwable {
//
//                    }
//                });

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

        RxHttp.get("https://api.rr.tv/watch/v4/get_movie_play_info?episodeSid=143417&seasonId=14752")
                .addAllHeader(Net.header())
                .add("quality", "HD")
                .asClass(Watch.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Watch>() {
                    @Override
                    public void accept(Watch watch) throws Throwable {
                        Common.showLog(className + watch.getData().getM3u8().getUrl().length());
                    }
                });

    }
}
