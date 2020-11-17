package ceui.lisa.rrshare.fragments;

import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.FalsifyFooter;
import com.scwang.smart.refresh.header.MaterialHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.adapters.BaseAdapter;
import ceui.lisa.rrshare.core.ListShow;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.utils.Common;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public abstract class BaseListFragment<Layout extends ViewDataBinding,
        Response extends ListShow<Item>, Item> extends BaseLazyFragment<Layout> {

    protected RecyclerView mRecyclerView;
    protected SmartRefreshLayout mSmartRefreshLayout;
    protected BaseAdapter<Item, ?> mAdapter;
    protected Response mResponse;
    protected List<Item> allItems = new ArrayList<>();
    protected int nowPage = 1;

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_list;
    }

    @Override
    protected void initView() {
        mRecyclerView = rootView.findViewById(R.id.recy_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        initRecyclerView();
        mAdapter = initAdapter();
        if (mAdapter != null) {
            mRecyclerView.setAdapter(mAdapter);
        }
        mSmartRefreshLayout = rootView.findViewById(R.id.smartRefreshLayout);
        mSmartRefreshLayout.setEnableRefresh(true);
        mSmartRefreshLayout.setEnableLoadMore(true);
        mSmartRefreshLayout.setRefreshHeader(new MaterialHeader(mContext));
        mSmartRefreshLayout.setRefreshFooter(new ClassicsFooter(mContext));
        mSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                nowPage = 1;
                mAdapter.clear();
                getData(new NullCtrl<Response>() {
                    @Override
                    public void success(Response response) {
                        firstBefore();
                        nowPage++;
                        mResponse = response;
                        int startSize = allItems.size();
                        List<Item> newData = response.getList();
                        if (!Common.isEmpty(newData)) {
                            allItems.addAll(newData);
                            mAdapter.notifyItemRangeInserted(startSize, newData.size());
                        }
                        firstAfter();
                        mSmartRefreshLayout.finishRefresh(true);
                        if (response.isEnd()) {
                            mSmartRefreshLayout.setRefreshFooter(new FalsifyFooter(mContext));
                        }
                    }
                });
            }
        });
        mSmartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                getData(new NullCtrl<Response>() {
                    @Override
                    public void success(Response response) {
                        nextBefore();
                        nowPage++;
                        mResponse = response;
                        int startSize = allItems.size();
                        List<Item> newData = response.getList();
                        if (!Common.isEmpty(newData)) {
                            allItems.addAll(newData);
                            mAdapter.notifyItemRangeInserted(startSize, newData.size());
                        }
                        nextAfter();
                        mSmartRefreshLayout.finishLoadMore(true);
                        if (response.isEnd()) {
                            mSmartRefreshLayout.setRefreshFooter(new FalsifyFooter(mContext));
                        }
                    }
                });
            }
        });
    }

    public void initRecyclerView() {

    }

    public void firstBefore() {

    }

    public void firstAfter() {

    }

    public void nextBefore() {

    }

    public void nextAfter() {

    }

    @Override
    public void lazyData() {
        mSmartRefreshLayout.autoRefresh();
    }

    public abstract Observable<Response> initApi();

    private void getData(NullCtrl<Response> nullCtrl) {
        initApi().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(nullCtrl);
    }

    public abstract BaseAdapter<Item, ?> initAdapter();
}
