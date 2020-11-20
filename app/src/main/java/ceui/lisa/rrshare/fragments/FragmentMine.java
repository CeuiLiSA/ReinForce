package ceui.lisa.rrshare.fragments;

import android.content.Intent;
import android.view.View;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.RankActivity;
import ceui.lisa.rrshare.SearchActivity;
import ceui.lisa.rrshare.databinding.FragmentMineBinding;
import ceui.lisa.rrshare.network.NullCtrl;
import ceui.lisa.rrshare.network.Rx;
import ceui.lisa.rrshare.response.Empty;
import ceui.lisa.rrshare.utils.Common;

public class FragmentMine extends BaseFragment<FragmentMineBinding> {

    @Override
    protected void initLayout() {
        mLayoutID = R.layout.fragment_mine;
    }

    @Override
    protected void initView() {
        baseBind.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, SearchActivity.class);
                startActivity(intent);
            }
        });
        baseBind.rank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, RankActivity.class);
                startActivity(intent);
            }
        });
        baseBind.token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rx.freshToken(new NullCtrl<Empty>() {
                    @Override
                    public void success(Empty empty) {
                        Common.showToast("刷新成功");
                    }
                });
            }
        });
    }
}
