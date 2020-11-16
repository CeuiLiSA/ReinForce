package ceui.lisa.rrshare;

import android.text.TextUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;

import ceui.lisa.rrshare.databinding.ActivityRankBinding;
import ceui.lisa.rrshare.fragments.FragmentRank;
import ceui.lisa.rrshare.response.Content;
import jp.wasabeef.glide.transformations.BlurTransformation;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;
import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class RankActivity extends BaseActivity<ActivityRankBinding> {

    @Override
    protected int initLayout() {
        return R.layout.activity_rank;
    }

    @Override
    protected void initView() {
        int statusHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusHeight = getResources().getDimensionPixelSize(resourceId);
        }
        String[] titles = new String[]{"美剧", "韩剧", "日剧", "泰剧"};
        baseBind.toolbar.setPadding(0, statusHeight, 0, 0);
        baseBind.toolbar.setNavigationOnClickListener(v -> finish());
        FragmentRank[] fragmentRanks = new FragmentRank[]{
                FragmentRank.newInstance(0),
                FragmentRank.newInstance(1),
                FragmentRank.newInstance(2),
                FragmentRank.newInstance(3)
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
    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean hideStatusBar() {
        return true;
    }

    public void setData(Content content) {
        if (!TextUtils.isEmpty(content.getCover())) {
            Glide.with(mContext).load(content.getCover())
                    .placeholder(baseBind.imageviewBlur.getDrawable())
                    .apply(bitmapTransform(new BlurTransformation(25, 3)))
                    .transition(withCrossFade(1000)).into(baseBind.imageviewBlur);
            Glide.with(mContext).load(content.getCover())
                    .placeholder(baseBind.imageView.getDrawable())
                    .transition(withCrossFade(1000)).into(baseBind.imageView);
        }
    }
}
