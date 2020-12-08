package ceui.lisa.rrshare.fragments;

import android.view.View;

import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.HashMap;

import ceui.lisa.rrshare.CallBack;
import ceui.lisa.rrshare.MovieActivity;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.OnItemClickListener;
import ceui.lisa.rrshare.response.M3u8;
import ceui.lisa.rrshare.response.NewDetail;
import ceui.lisa.rrshare.response.NewDetailData;
import ceui.lisa.rrshare.view.BottomView;
import ceui.lisa.rrshare.view.FirstView;
import ceui.lisa.rrshare.view.TopView;
import ceui.lisa.rrshare.adapters.EpisodeAdapter;
import ceui.lisa.rrshare.databinding.FragmentMovieDetailBinding;
import ceui.lisa.rrshare.network.Net;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.response.Episode;
import ceui.lisa.rrshare.response.Movie;
import ceui.lisa.rrshare.response.Watch;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecorationHorizon;
import fun.aragaki.rr.RR;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;
import rxhttp.RxHttp;

public class FragmentMovieDetail extends BaseMovieFragment<FragmentMovieDetailBinding> {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_movie_detail;
    }

    @Override
    protected void initView() {
        baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        baseBind.recyList.addItemDecoration(
                new LinearItemDecorationHorizon(DensityUtil.dp2px(16.0f))
        );
    }

    @Override
    public void initModel() {
        super.initModel();
        model.getMovie().observe(getViewLifecycleOwner(), new Observer<Content>() {
            @Override
            public void onChanged(Content content) {
                if (content != null) {
                    Common.showLog("view model " + className + "收到了" + content.getTitle());
                    if ("相关视频".equals(content.getFrom())) {
                        getPlayUrl(content.getId());
                        getVideoDetail(content.getId());
                    } else {
                        getNewDetail(content.getId());
                    }
                } else {
                    Common.showLog("view model " + className + "收到了 null");
                }
            }
        });
    }

    private void getPlayUrl(int seasonID, String episodeSid) {
        RxHttp.get("https://api.rr.tv/watch/v4/get_movie_play_info")
                .addAllHeader(Net.header())
                .add("quality", "HD")
                .add("seasonId", seasonID)
                .add("episodeSid", episodeSid)
                .asClass(Watch.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NullCtrl<Watch>() {
                    @Override
                    public void success(Watch watch) {
                        nowPlay(watch.getData().getM3u8());
                    }
                });
    }


    private void getPlayUrl(int videoId) {
        RxHttp.get("https://api.rr.tv/watch/get_video_info")
                .addAllHeader(Net.header())
                .add("quality", "super")
                .add("videoId", videoId)
                .asClass(Watch.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NullCtrl<Watch>() {
                    @Override
                    public void success(Watch watch) {
                        nowPlay(watch.getData().getM3u8());
                    }
                });
    }


    private void getNewDetail(int seasonID) {
        RxHttp.get("https://api.rr.tv/drama/app/get_combined_drama_detail")
                .addAllHeader(Net.header())
                .add("isAgeLimit", "0")
                .add("quality", "HD")
                .add("seasonId", seasonID)
                .asClass(NewDetail.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NullCtrl<NewDetail>() {
                    @Override
                    public void success(NewDetail movie) {
                        //设置抢先看
                        if (!Common.isEmpty(movie.getData().getFirstLook())) {
                            FirstView firstView = new FirstView(mContext);
                            firstView.bindContent(movie.getData().getFirstLook());
                            baseBind.createLinear.addView(firstView);
                        }


                        //设置相关视频
                        if (!Common.isEmpty(movie.getData().getDramaDetail().getRecommendVideoList())) {
                            TopView topView = new TopView(mContext);
                            topView.bindContent(movie.getData().getDramaDetail().getRecommendVideoList());
                            baseBind.createLinear.addView(topView);
                        }

                        //设置推荐视频
                        if (!Common.isEmpty(movie.getData().getDramaDetail().getRecommendForYou())) {
                            BottomView bottomView = new BottomView(mContext);
                            bottomView.bindContent(movie.getData().getDramaDetail().getRecommendForYou());
                            baseBind.createLinear.addView(bottomView);
                        }

                        //设置剧集
                        if (!Common.isEmpty(movie.getData().getEpisodeList().getEpisodeList())) {
                            baseBind.episodeLl.setVisibility(View.VISIBLE);
                            movie.getData().getEpisodeList().getEpisodeList().get(0).setPlaying(true);
                            EpisodeAdapter adapter = new EpisodeAdapter(movie.getData().getEpisodeList().getEpisodeList(), mContext);
                            adapter.setOnItemClickListener(new OnItemClickListener() {
                                @Override
                                public void onItemClick(View v, int position, int viewType) {
                                    for (int i = 0; i < movie.getData().getEpisodeList().getEpisodeList().size(); i++) {
                                        if (i == position) {
                                            movie.getData().getEpisodeList().getEpisodeList().get(i).setPlaying(true);
                                        } else {
                                            movie.getData().getEpisodeList().getEpisodeList().get(i).setPlaying(false);
                                        }
                                    }
                                    adapter.notifyDataSetChanged();

                                    getPlayUrl(movie.getData().getDramaDetail().getSeason().getId(),
                                            movie.getData().getEpisodeList().getEpisodeList().get(position).getSid());
                                }
                            });
                            baseBind.recyList.setAdapter(adapter);
                            baseBind.allEpisode.setText("查看全部" + movie.getData().getEpisodeList().getEpisodeList().size() + "集");

                            //默认播放第一集
                            getPlayUrl(movie.getData().getDramaDetail().getSeason().getId(),
                                    movie.getData().getEpisodeList().getEpisodeList().get(0).getSid());
                        }
                    }
                });
    }

    private void nowPlay(M3u8 m3u8) {
        if ("DIRECT".equals(m3u8.getParserType())) {
            if (mActivity instanceof MovieActivity) {
                ((MovieActivity) mActivity).play(m3u8.getUrl());
            }
        } else {
            String url = RR.INSTANCE.decrypt(m3u8.getUrl(),
                    Net.TOKEN , new HashMap<>());
            if (mActivity instanceof MovieActivity) {
                ((MovieActivity) mActivity).play(url);
            }
        }
    }

    private void getVideoDetail(int videoId) {
        RxHttp.get("https://api.rr.tv/v3plus/video/detail")
                .addAllHeader(Net.header())
                .add("videoId", videoId)
                .add("token", "rrtv-b2228b19a37039db54172e9648c02a5dab579c88")
                .asClass(Movie.class)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new NullCtrl<Movie>() {
                    @Override
                    public void success(Movie movie) {
                        if (!Common.isEmpty(movie.getData().getRecommendVideoList())) {
                            TopView topView = new TopView(mContext);
                            topView.bindContent(movie.getData().getRecommendVideoList());
                            baseBind.createLinear.addView(topView);
                        }

                        if (!Common.isEmpty(movie.getData().getRecommendForYou())) {
                            BottomView bottomView = new BottomView(mContext);
                            bottomView.bindContent(movie.getData().getRecommendForYou());
                            baseBind.createLinear.addView(bottomView);
                        }
                    }
                });
    }
}
