package ceui.lisa.rrshare.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class LinearItemDecorationHorizon extends RecyclerView.ItemDecoration {

    private int space;

    public LinearItemDecorationHorizon(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {
        if (parent.getChildPosition(view) == 0) {
            outRect.left = DensityUtil.dp2px(12.0f);
        }
        outRect.right = space;
    }
}
