package ceui.lisa.rrshare.view;

import android.content.Context;
import android.telecom.Call;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import com.shuyu.gsyvideoplayer.video.StandardGSYVideoPlayer;

import java.io.File;

import ceui.lisa.rrshare.CallBack;
import ceui.lisa.rrshare.R;

public class PlayView extends StandardGSYVideoPlayer {

    public PlayView(Context context, Boolean fullFlag) {
        super(context, fullFlag);
    }

    public PlayView(Context context) {
        super(context);
    }

    public PlayView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private CallBack backCallBack;

    public CallBack getBackCallBack() {
        return backCallBack;
    }

    public void setBackCallBack(CallBack backCallBack) {
        this.backCallBack = backCallBack;
    }

    @Override
    public int getLayoutId() {
        return R.layout.video_layout_normal;
    }

    @Override
    public boolean setUp(String url, boolean cacheWithPlay, File cachePath, String title) {
        super.setUp(url, cacheWithPlay, cachePath, title);

        return true;
    }

    @Override
    public ImageView getBackButton() {
        return super.getBackButton();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (v.getId() == R.id.back) {
            if (backCallBack != null) {
                backCallBack.callBack();
            }
        }
    }

    public void play() {
        post(() -> findViewById(R.id.start).performClick());
    }
}
