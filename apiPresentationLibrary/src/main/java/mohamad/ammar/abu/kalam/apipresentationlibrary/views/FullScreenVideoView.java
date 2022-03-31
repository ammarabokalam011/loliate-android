package mohamad.ammar.abu.kalam.apipresentationlibrary.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

import mohamad.ammar.abu.kalam.apipresentationlibrary.listeners.OnSeekChangeListener;


public class FullScreenVideoView extends VideoView {

    private OnSeekChangeListener onSeekChangeListener;

    public FullScreenVideoView(Context context) {
        super(context);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullScreenVideoView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public OnSeekChangeListener getOnSeekChangeListener() {
        return onSeekChangeListener;
    }

    public void setOnSeekChangeListener(OnSeekChangeListener onSeekChangeListener) {
        this.onSeekChangeListener = onSeekChangeListener;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }

    public void setFixedVideoSize(int width, int height) {
        getHolder().setFixedSize(width, height);
    }

    @Override
    public void seekTo(int msec) {
        super.seekTo(msec);
        if (onSeekChangeListener != null)
            onSeekChangeListener.onSeekChange(msec);
    }

}
