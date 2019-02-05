package com.example.openwebinar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    final String IRON_MAN = "Hello, this is Iron Man! ;)";

    @ViewById(R.id.tv_demo)
    TextView tvDemo;

    @AfterViews
    void initAfterViews() {
        tvDemo.setText(IRON_MAN);
    }

}
