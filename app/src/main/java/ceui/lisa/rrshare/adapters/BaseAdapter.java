package ceui.lisa.rrshare.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ceui.lisa.rrshare.utils.Common;


public abstract class BaseAdapter<Item, BindView extends ViewDataBinding> extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<Item> allIllust;
    protected Context mContext;
    protected int mLayoutID = -1;
    protected OnItemClickListener mOnItemClickListener;

    public BaseAdapter(@Nullable List<Item> targetList, Context context) {
        Common.showLog(getClass().getSimpleName() + " newInstance");
        this.allIllust = targetList;
        this.mContext = context;
        initLayout();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        tryCatchBindData(allIllust.get(position), (ViewHolder<BindView>) holder, position);
    }

    @Override
    public int getItemCount() {
        return allIllust.size();
    }

    public abstract void initLayout();

    public abstract void bindData(Item target, ViewHolder<BindView> bindView, int position);

    private void tryCatchBindData(Item target, ViewHolder<BindView> bindView, int position){
        try {
            bindData(target, bindView, position);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public ViewHolder<? extends ViewDataBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder<>(
                DataBindingUtil.inflate(
                        LayoutInflater.from(mContext),
                        mLayoutID,
                        parent,
                        false
                )
        );
    }

    public BaseAdapter<Item, BindView> setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
        return this;
    }

    public void clear() {
        final int size = allIllust.size();
        allIllust.clear();
        notifyItemRangeRemoved(0, size);
    }

    public Item getItemAt(int index) {
        if (index < allIllust.size()) {
            return allIllust.get(index);
        }
        return null;
    }
}
