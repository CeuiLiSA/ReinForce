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
import ceui.lisa.rrshare.utils.LinearItemDecoration;
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


        bindView.baseBind.title.setText(target.getName());

        BaseAdapter adapter = map.get(target.getId());
        if (adapter == null) {
            if ("BILLBOARD".equals(target.getSectionType())) {
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
            } else if ("SEASON_CARD".equals(target.getSectionType()) ||
                    "SEASON".equals(target.getSectionType())) {

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

                adapter = new SCardAdapter(target.getContent(), mContext);
                map.put(target.getId(), adapter);
            } else if ("INFO".equals(target.getSectionType())) {

                if (bindView.baseBind.recyList.getItemDecorationCount() == 0) {
                    bindView.baseBind.recyList.addItemDecoration(
                            new LinearItemDecoration(DensityUtil.dp2px(8.0f))
                    );
                }
                if (bindView.baseBind.recyList.getLayoutManager() == null) {
                    bindView.baseBind.recyList.setLayoutManager(new LinearLayoutManager(mContext));
                }

                adapter = new NewInfoAdapter(target.getContent(), mContext);
                map.put(target.getId(), adapter);
            }
        }

        bindView.baseBind.recyList.setAdapter(adapter);
    }

    @Override
    public void clear() {
        super.clear();
        map.clear();
    }
}
