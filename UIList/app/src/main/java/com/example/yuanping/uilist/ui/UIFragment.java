package com.example.yuanping.uilist.ui;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.yuanping.uilist.R;

/**
 * @created by PingYuan at 9/29/18
 * @email: husteryp@gmail.com
 * @description:
 */
@SuppressLint("ValidFragment")
public class UIFragment extends Fragment {

    private View mView;

    public UIFragment(View view) {
        this.mView = view;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_root, container, false);
        RelativeLayout root = view.findViewById(R.id.fragment_root);
        if (mView.getParent() != null) {
            ((ViewGroup) mView.getParent()).removeView(mView);
        }
        root.addView(mView);
        return view;
    }
}
