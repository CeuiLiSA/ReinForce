package ceui.lisa.rrshare.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.callback.Callback;

import ceui.lisa.rrshare.CallBack;
import ceui.lisa.rrshare.MovieActivity;
import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyPageBinding;
import ceui.lisa.rrshare.response.Movie;
import ceui.lisa.rrshare.response.Section;
import ceui.lisa.rrshare.utils.Common;
import ceui.lisa.rrshare.utils.DensityUtil;
import ceui.lisa.rrshare.utils.LinearItemDecorationHorizon;

public class PartAdapter extends BaseAdapter<Section, RecyPageBinding> {

    private HashMap<Integer, BaseAdapter> map = new HashMap<>();

    public PartAdapter(@Nullable List<Section> targetList, Context context) {
        super(targetList, context);
    }

    @Override
    public void initLayout() {
        mLayoutID = R.layout.recy_page;
    }

    @Override
    public void bindData(Section target, ViewHolder<RecyPageBinding> bindView, int position) {
        Common.showLog("bindData " + position);
        if (bindView.baseBind.recyList.getItemDecorationCount() == 0) {
            bindView.baseBind.recyList.addItemDecoration(
                    new LinearItemDecorationHorizon(DensityUtil.dp2px(8.0f))
            );
        }
        if (bindView.baseBind.recyList.getLayoutManager() == null) {
            bindView.baseBind.recyList.setLayoutManager(
                    new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false)
            );
        }

        bindView.baseBind.title.setText(target.getName());
        bindView.baseBind.recyList.setAdapter(map.get(target.getId()));
    }

    public void initNow(CallBack callback) {
        for (Section target : allIllust) {
            BaseAdapter adapter = map.get(target.getId());
            if (adapter == null) {
                if ("BILLBOARD".equals(target.getSectionType())) {
                    adapter = new SimpleAdapter(target.getContent().get(0).getDataList(), mContext);
                    adapter.setOnItemClickListener(new OnItemClickListener() {
                        @Override
                        public void onItemClick(View v, int position, int viewType) {
                            Intent intent = new Intent(mContext, MovieActivity.class);
                            intent.putExtra("content", target.getContent().get(0).getDataList().get(position));
                            mContext.startActivity(intent);
                        }
                    });
                    map.put(target.getId(), adapter);
                } else if ("SEASON_CARD".equals(target.getSectionType())) {
                    adapter = new SCardAdapter(target.getContent(), mContext);
                    Common.showLog("PartAdapter 新建SCardAdapter");
                    map.put(target.getId(), adapter);
                }
            }
        }
        if (callback != null) {
            callback.callBack();
        }
    }
}
