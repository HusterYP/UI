package com.example.yuanping.uilist.widget.practice5;

import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * @created by PingYuan at 10/4/18
 * @email: husteryp@gmail.com
 * @description:
 */
public class InsertAfterOnDrawView extends View {
    public InsertAfterOnDrawView(Context context) {
        super(context);
    }

    public InsertAfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public InsertAfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InsertAfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
                                 int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
