package com.example.yuanping.uilist.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.yuanping.uilist.Application;
import com.example.yuanping.uilist.CommonAdapter;
import com.example.yuanping.uilist.R;

import java.util.List;

/**
 * @created by PingYuan at 8/2/18
 * @email: husteryp@gmail.com
 * @description: 类似于Google的API Demo那样的展示, 大多数条目都是触发界面跳转, 故抽取
 */

public class RvUtils {
    public static void setCommonRv(RecyclerView rv, List<Class> listeners,
                                   List<String> titles, Context context) {
        rv.setLayoutManager(new LinearLayoutManager(Application.sAppContext, LinearLayoutManager.VERTICAL, false));
        DividerItemDecoration itemDecoration = new DividerItemDecoration(context, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(new ColorDrawable(Color.parseColor("#FF0000")));
        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(new CommonAdapter(titles, listeners, context));
    }
}
