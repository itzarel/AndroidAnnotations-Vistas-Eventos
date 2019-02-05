package com.example.openwebinar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    final String IRON_MAN = "Hello, this is Iron Man! ;)";
    final String CLICKED = "Clicked!";

    @ViewById(R.id.tv_demo)
    TextView tvDemo;

    @AfterViews
    void initAfterViews() {
        tvDemo.setText(IRON_MAN);
    }

    @Click(R.id.b_demo)
    void bDemoClickEvent() {
        tvDemo.setText(CLICKED);
    }



}