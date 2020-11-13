package ceui.lisa.rrshare.fragments;

import android.content.Intent;
import android.view.View;

import ceui.lisa.rrshare.R;
import ceui.lisa.rrshare.SearchActivity;
import ceui.lisa.rrshare.databinding.FragmentMineBinding;

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
    }
}
