package ceui.lisa.rrshare;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;

import com.shuyu.gsyvideoplayer.GSYVideoManager;
import com.shuyu.gsyvideoplayer.builder.GSYVideoOptionBuilder;
import com.shuyu.gsyvideoplayer.listener.GSYSampleCallBack;
import com.shuyu.gsyvideoplayer.listener.LockClickListener;
import com.shuyu.gsyvideoplayer.utils.OrientationUtils;

import ceui.lisa.rrshare.databinding.ActivityMovieBinding;
import ceui.lisa.rrshare.fragments.BaseFragment;
import ceui.lisa.rrshare.fragments.FragmentCommentNew;
import ceui.lisa.rrshare.fragments.FragmentMovieDetail;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.viewmodel.MovieModel;

public class MovieActivity extends BaseActivity<ActivityMovieBinding> {

    private Content mContent;
    private MovieModel model;

    private boolean isPlay;
    private boolean isPause;
    private OrientationUtils orientationUtils;

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
        baseBind.detailPlayer.setBackCallBack(new CallBack() {
            @Override
            public void callBack() {
                finish();
            }
        });
        //外部辅助的旋转，帮助全屏
        orientationUtils = new OrientationUtils(this, baseBind.detailPlayer);
        //初始化不打开外部的旋转
        orientationUtils.setEnable(false);

        baseBind.detailPlayer.getFullscreenButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //直接横屏
                orientationUtils.resolveByClick();

                //第一个true是否需要隐藏actionbar，第二个true是否需要隐藏statusbar
                baseBind.detailPlayer.startWindowFullscreen(mContext, true, true);
            }
        });

        String[] titles = new String[]{"详情", "讨论"};
        BaseFragment<?>[] fragments = new BaseFragment<?>[]{
                new FragmentMovieDetail(),
                new FragmentCommentNew(),
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
        baseBind.tabLayout.init();
    }

    public void play(String url) {
        GSYVideoOptionBuilder gsyVideoOption = new GSYVideoOptionBuilder();
        gsyVideoOption
                .setIsTouchWiget(true)
                .setRotateViewAuto(false)
                .setLockLand(false)
                .setAutoFullWithSize(true)
                .setShowFullAnimation(false)
                .setNeedLockFull(true)
                .setCacheWithPlay(false)
                .setUrl(url)
                .setVideoTitle(mContent.getTitle())
                .setVideoAllCallBack(new GSYSampleCallBack() {
                    @Override
                    public void onPrepared(String url, Object... objects) {
                        super.onPrepared(url, objects);
                        //开始播放了才能旋转和全屏
                        orientationUtils.setEnable(true);
                        isPlay = true;
                    }

                    @Override
                    public void onQuitFullscreen(String url, Object... objects) {
                        super.onQuitFullscreen(url, objects);
                        if (orientationUtils != null) {
                            orientationUtils.backToProtVideo();
                        }
                    }
                }).setLockClickListener(new LockClickListener() {
            @Override
            public void onClick(View view, boolean lock) {
                if (orientationUtils != null) {
                    //配合下方的onConfigurationChanged
                    orientationUtils.setEnable(!lock);
                }
            }
        }).build(baseBind.detailPlayer);
    }

    @Override
    protected void initData() {
        model.getMovie().setValue(mContent);
    }

    @Override
    public void onBackPressed() {
        if (orientationUtils != null) {
            orientationUtils.backToProtVideo();
        }
        if (GSYVideoManager.backFromWindowFull(this)) {
            return;
        }
        super.onBackPressed();
    }

    @Override
    protected void onPause() {
        baseBind.detailPlayer.getCurrentPlayer().onVideoPause();
        super.onPause();
        isPause = true;
    }

    @Override
    protected void onResume() {
        baseBind.detailPlayer.getCurrentPlayer().onVideoResume(false);
        super.onResume();
        isPause = false;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isPlay) {
            baseBind.detailPlayer.getCurrentPlayer().release();
        }
        if (orientationUtils != null)
            orientationUtils.releaseListener();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //如果旋转了就全屏
        if (isPlay && !isPause) {
            baseBind.detailPlayer.onConfigurationChanged(this, newConfig, orientationUtils, true, true);
        }
    }
}
