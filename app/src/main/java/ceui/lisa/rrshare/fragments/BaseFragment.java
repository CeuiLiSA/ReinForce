package ceui.lisa.rrshare.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


public abstract class BaseFragment<Layout extends ViewDataBinding> extends Fragment {

    protected View rootView;
    protected Layout baseBind;
    protected String className = getClass().getSimpleName() + " ";

    protected int mLayoutID = -1;

    protected FragmentActivity mActivity;
    protected Context mContext;
    private boolean isVertical;
    protected boolean viewCreated;

    public BaseFragment() {
        Log.d(className, " newInstance");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            mActivity = requireActivity();
            mContext = requireContext();


            Bundle bundle = getArguments();
            if (bundle != null) {
                initBundle(bundle);
            }

            Intent intent = mActivity.getIntent();
            if (intent != null) {
                Bundle activityBundle = intent.getExtras();
                if (activityBundle != null) {
                    initActivityBundle(activityBundle);
                }
            }

            //获取屏幕方向
            int ori = getResources().getConfiguration().orientation;
            if (ori == Configuration.ORIENTATION_LANDSCAPE) {
                isVertical = false;
            } else if (ori == Configuration.ORIENTATION_PORTRAIT) {
                isVertical = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        try {
            if (rootView != null) {
                if (baseBind == null) {
                    baseBind = DataBindingUtil.bind(rootView);
                }
                return rootView;
            }
            initLayout();

            if (mLayoutID != -1) {
                baseBind = DataBindingUtil.inflate(inflater, mLayoutID, container, false);
                if (baseBind != null) {
                    rootView = baseBind.getRoot();
                } else {
                    rootView = inflater.inflate(mLayoutID, container, false);
                }
                initModel();
                initView();
                initData();
                return rootView;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {
            if (isVertical) {
                vertical();
            } else {
                horizon();
            }
            viewCreated = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected abstract void initLayout();

    protected void initBundle(Bundle bundle) {

    }

    protected void initActivityBundle(Bundle bundle) {

    }

    protected void initView() {

    }

    protected void initData() {

    }

    public void horizon() {

    }

    public void vertical() {

    }

    public void finish() {
        if (mActivity != null) {
            mActivity.finish();
        }
    }

    public void initModel() {

    }
}