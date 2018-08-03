package com.example.yuanping.uilist.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

import com.example.yuanping.uilist.Application;

/**
 * @created by PingYuan at 8/2/18
 * @email: husteryp@gmail.com
 * @description:
 * Use this class to help get the information about the screen !
 */
public class ScreenUtils {

    private static Context sContext = Application.sAppContext;

    public static int getScreenWidth() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)sContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public static int getScreenHeight() {
        DisplayMetrics metrics = new DisplayMetrics();
        ((Activity)sContext).getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.heightPixels;
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
