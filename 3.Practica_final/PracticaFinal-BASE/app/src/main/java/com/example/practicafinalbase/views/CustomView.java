package com.example.practicafinalbase.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.practicafinalbase.R;
import com.example.practicafinalbase.recoverinfo.dto.HeroInfo;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EViewGroup;

@EViewGroup(R.layout.custom_avenger_view)
public class CustomView extends RelativeLayout {

    ImageView imageView;
    CustomTextView_ customTextView;
    Button b1, b2, b3, b4, b5;
    View custom_avenger_view;

    int[] colors;


    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @AfterViews
    void initUI() {
        custom_avenger_view = findViewById(R.id.custom_avenger_view);
        imageView = findViewById(R.id.iv_avenger_avatar);
        customTextView = findViewById(R.id.ctv_avenger_info);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b5 = findViewById(R.id.button5);
    }

    public void setInfo(HeroInfo heroInfo) {
        colors = heroInfo.getColors();
        imageView.setImageResource(heroInfo.getImage());
        customTextView.setText(heroInfo.getHero(), heroInfo.getActor(), heroInfo.getDescription(), heroInfo.getLanguage());
        b1.setBackgroundColor(heroInfo.getColors()[0]);
        b2.setBackgroundColor(heroInfo.getColors()[1]);
        b3.setBackgroundColor(heroInfo.getColors()[2]);
        b4.setBackgroundColor(heroInfo.getColors()[3]);
        b5.setBackgroundColor(heroInfo.getColors()[4]);

        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_avenger_view.setBackgroundColor(colors[0]);
            }
        });

        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_avenger_view.setBackgroundColor(colors[1]);
            }
        });

        b3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_avenger_view.setBackgroundColor(colors[2]);
            }
        });

        b4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_avenger_view.setBackgroundColor(colors[3]);
            }
        });

        b5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                custom_avenger_view.setBackgroundColor(colors[4]);
            }
        });
    }
}
