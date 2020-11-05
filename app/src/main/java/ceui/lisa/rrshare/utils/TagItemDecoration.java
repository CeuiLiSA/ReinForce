package ceui.lisa.rrshare.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

public class TagItemDecoration extends RecyclerView.ItemDecoration {

    private int spacing;

    public TagItemDecoration(int spacing) {
        this.spacing = spacing;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        int position = parent.getChildAdapterPosition(view); // item position

        if (position == 0 || position == 1 || position == 2) {
            outRect.top = spacing;
        }

        outRect.left = spacing;
        outRect.bottom = spacing;

        if (position % 3 == 2) {
            outRect.right = spacing;
        }

    }
}
