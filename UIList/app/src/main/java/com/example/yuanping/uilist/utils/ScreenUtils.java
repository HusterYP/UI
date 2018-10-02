package com.example.yuanping.uilist.utils;

import android.content.Context;

import com.example.yuanping.uilist.Application;

/**
 * @created by PingYuan at 8/2/18
 * @email: husteryp@gmail.com
 * @description: Use this class to help get the information about the screen !
 */
public class ScreenUtils {

    private static Context sContext = Application.sAppContext;

    public static int getScreenWidth() {
        return sContext.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeight() {
        return sContext.getResources().getDisplayMetrics().heightPixels;
    }

    public static int dpTopx(int dp) {
        final float scale = sContext.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static int pxTodp(int px) {
        final float scale = sContext.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

}
