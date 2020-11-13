package ceui.lisa.rrshare.fragments;

import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;

import com.scwang.smart.refresh.layout.SmartRefreshLayout;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.viewmodel.MovieModel;
import ceui.lisa.rrshare.viewmodel.WordModel;

public abstract class BaseWordFragment<T extends ViewDataBinding> extends BaseLazyFragment<T> {

    protected WordModel model;

    @Override
    public void initModel() {
        model = new ViewModelProvider(mActivity).get(WordModel.class);
    }
}
