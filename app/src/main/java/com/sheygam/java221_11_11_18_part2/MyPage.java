package com.sheygam.java221_11_11_18_part2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MyPage#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MyPage extends Fragment {


    private int color;
    private String title;
    public static MyPage newInstance(int color, String title) {
        MyPage fragment = new MyPage();
        fragment.color = color;
        fragment.title = title;
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_page, container, false);
        TextView titleTxt = view.findViewById(R.id.titleTxt);
        FrameLayout root = view.findViewById(R.id.root);
        titleTxt.setText(title);
        root.setBackgroundColor(color);
        return view;
    }

}
