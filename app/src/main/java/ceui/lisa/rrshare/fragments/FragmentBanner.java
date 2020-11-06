package ceui.lisa.rrshare.fragments;

import android.os.Bundle;

import com.bumptech.glide.Glide;

import ceui.lisa.rrshare.BaseFragment;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.FragmentBannerBinding;
import ceui.lisa.rrshare.response.Banner;

public class FragmentBanner extends BaseFragment<FragmentBannerBinding> {

    private Banner mBanner;

    public static FragmentBanner newInstance(Banner banner) {
        Bundle args = new Bundle();
        args.putSerializable("content", banner);
        FragmentBanner fragment = new FragmentBanner();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initBundle(Bundle bundle) {
        mBanner = (Banner) bundle.getSerializable("content");
    }

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_banner;
    }

    @Override
    protected void initView() {
        Glide.with(mContext).load(mBanner.getImgUrl()).into(baseBind.imageView);
    }
}
