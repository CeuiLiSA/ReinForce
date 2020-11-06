package ceui.lisa.rrshare.adapters;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.databinding.RecyPageBinding;
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
        BaseAdapter adapter = map.get(target.getId());
        if (adapter != null) {
            bindView.baseBind.recyList.setAdapter(adapter);
            Common.showLog("PartAdapter 用已有的");
        } else {
            if ("BILLBOARD".equals(target.getSectionType())) {
                adapter = new SimpleAdapter(target.getContent().get(0).getDataList(), mContext);
                bindView.baseBind.recyList.setAdapter(adapter);
                Common.showLog("PartAdapter 新建SimpleAdapter");
                map.put(target.getId(), adapter);
            } else if ("SEASON_CARD".equals(target.getSectionType())) {
                adapter = new SCardAdapter(target.getContent(), mContext);
                bindView.baseBind.recyList.setAdapter(adapter);
                Common.showLog("PartAdapter 新建SCardAdapter");
                map.put(target.getId(), adapter);
            }
        }
        Common.showLog("PartAdapter 总数：" + map.size());

    }
}
