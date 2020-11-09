package ceui.lisa.rrshare.fragments;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.viewmodel.MovieModel;

public abstract class BaseMovieFragment<T extends ViewDataBinding> extends SwipeFragment<T> {

    protected MovieModel model;

    @Override
    public void initModel() {
        model = new ViewModelProvider(mActivity).get(MovieModel.class);
    }

    @Override
    public SmartRefreshLayout getSmartRefreshLayout() {
        return rootView.findViewById(R.id.smartRefreshLayout);
    }
}
