package com.example.yuanping.uilist.utils;

import android.content.Context;

import com.example.yuanping.uilist.Application;

/**
 * @created by PingYuan at 8/2/18
 * @email: husteryp@gmail.com
 * @description:
 * Use this class to get the resource from app
 */
public class AssetsUtils {
    private static Context sContext = Application.sAppContext;

    public static String getStringFromResource(int id) {
        return sContext.getResources().getString(id);
    }
}
