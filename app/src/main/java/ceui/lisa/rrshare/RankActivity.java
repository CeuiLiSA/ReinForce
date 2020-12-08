package ceui.lisa.rrshare;

import android.text.TextUtils;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewTreeObserver;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.qmuiteam.qmui.skin.QMUISkinManager;
import com.qmuiteam.qmui.widget.dialog.QMUIBottomSheet;

import ceui.lisa.rrshare.databinding.ActivityRankBinding;
import ceui.lisa.rrshare.fragments.FragmentRankNew;
import ceui.lisa.rrshare.response.Content;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class RankActivity extends BaseActivity<ActivityRankBinding> {

    public static final String[] DURATION_VALUE = new String[]{"T-1", "T-7", "T-30", "ALL"};
    public static final String[] DURATION_TITLE = new String[]{"日排行榜", "周排行榜", "月排行榜", "全部排行榜"};

    @Override
    protected int initLayout() {
        return R.layout.activity_rank;
    }

    @Override
    protected void initView() {
        final int statusHeight;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusHeight = getResources().getDimensionPixelSize(resourceId);
        } else {
            statusHeight = 0;
        }
        String[] titles = new String[]{"美剧", "韩剧", "日剧", "泰剧"};
        baseBind.toolbar.setPadding(0, statusHeight, 0, 0);
        baseBind.toolbar.setNavigationOnClickListener(v -> finish());
        FragmentRankNew[] fragmentRanks = new FragmentRankNew[]{
                FragmentRankNew.newInstance(getArea(0)),
                FragmentRankNew.newInstance(getArea(1)),
                FragmentRankNew.newInstance(getArea(2)),
                FragmentRankNew.newInstance(getArea(3))
        };
        baseBind.viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager(), 0) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragmentRanks[position];
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
        baseBind.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                fragmentRanks[position].updateParent();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        baseBind.tabLayout.init();
        baseBind.rankSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QMUIBottomSheet.BottomListSheetBuilder builder = new QMUIBottomSheet.BottomListSheetBuilder(mActivity);
                builder.setGravityCenter(true)
                        .setSkinManager(QMUISkinManager.defaultInstance(mActivity))
                        .setTitle("排行类型")
                        .setAddCancelBtn(true)
                        .setAllowDrag(true)
                        .setNeedRightMark(false)
                        .setOnSheetItemClickListener(new QMUIBottomSheet.BottomListSheetBuilder.OnSheetItemClickListener() {
                            @Override
                            public void onClick(QMUIBottomSheet dialog, View itemView, int position, String tag) {
                                fragmentRanks[baseBind.viewPager.getCurrentItem()].updateSelf(position);
                                dialog.dismiss();
                            }
                        });
                for (int i = 0; i < DURATION_TITLE.length; i++) {
                    builder.addItem(DURATION_TITLE[i]);
                }
                builder.build().show();
            }
        });
        baseBind.toolbarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                final int offset = baseBind.toolbarLayout.getHeight() - statusHeight - DensityUtil.dp2px(56.0f);
                baseBind.appBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
                    @Override
                    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                        if (Math.abs(verticalOffset) < 15) {
                            baseBind.imageView.setAlpha(1.0f);
                            baseBind.rankSort.setAlpha(1.0f);
                            baseBind.toolbarTitle.setAlpha(0.0f);
                        } else if ((offset - Math.abs(verticalOffset)) < 15) {
                            baseBind.imageView.setAlpha(0.0f);
                            baseBind.rankSort.setAlpha(0.0f);
                            baseBind.toolbarTitle.setAlpha(1.0f);
                        } else {
                            baseBind.imageView.setAlpha(1 + (float) verticalOffset / offset);
                            baseBind.rankSort.setAlpha(1 + (float) verticalOffset / offset);
                            baseBind.toolbarTitle.setAlpha(-(float) verticalOffset / offset);
                        }
                        Common.showLog(className + verticalOffset);
                    }
                });
                baseBind.toolbarLayout.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }

    @Override
    protected void initData() {

    }

    public String getArea(int index) {
        if (index == 0) {
            return "USK";
        } else if (index == 1) {
            return "KR";
        } else if (index == 2) {
            return "JP";
        } else if (index == 3) {
            return "TH";
        }
        return "USK";
    }

    @Override
    public boolean hideStatusBar() {
        return true;
    }

    public void setData(Content content, int rankSort) {
        if (!TextUtils.isEmpty(content.getCover())) {
            Glide.with(mContext).load(content.getCover())
                    .placeholder(baseBind.imageviewBlur.getDrawable())
                    .apply(bitmapTransform(new BlurTransformation(25, 3)))
                    .transition(withCrossFade(1000)).into(baseBind.imageviewBlur);
            Glide.with(mContext).load(content.getCover())
                    .placeholder(baseBind.imageView.getDrawable())
                    .transition(withCrossFade(1000)).into(baseBind.imageView);
        }
        baseBind.rankSort.setText(DURATION_TITLE[rankSort]);
        baseBind.toolbarTitle.setText(DURATION_TITLE[rankSort]);
    }
}
