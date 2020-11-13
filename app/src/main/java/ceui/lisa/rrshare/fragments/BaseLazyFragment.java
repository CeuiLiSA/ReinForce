package ceui.lisa.rrshare.fragments;

import androidx.databinding.ViewDataBinding;


public abstract class BaseLazyFragment<T extends ViewDataBinding> extends BaseFragment<T> {

    protected boolean isLoaded;

    public void lazyData() {
        isLoaded = true;
    }

    public boolean forceLoad() {
        return false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && !isLoaded && isAdded() && viewCreated) {
            lazyData();
        }
    }

    @Override
    protected void initData() {
        if (forceLoad()) {
            lazyData();
        }
    }
}
