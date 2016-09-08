package np.com.vikashparajuli.dynamicviewpager.viewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Mshrjn on 2/29/2016.
 */

public class CustomViewPager extends VerticalViewPager {


    private boolean mSwipable = true;

    public CustomViewPager(Context context) {
        super(context);
    }

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mSwipable ? super.onInterceptTouchEvent(event) : false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return mSwipable ? super.onTouchEvent(event) : false;
    }

    public boolean isSwipable() {
        return mSwipable;
    }

    public void setSwipable(boolean swipable) {
        mSwipable = swipable;
    }
}