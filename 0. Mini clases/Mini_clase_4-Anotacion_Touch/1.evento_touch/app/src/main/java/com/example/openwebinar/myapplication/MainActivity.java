package com.example.openwebinar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Touch;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    final String IRON_MAN = "Hello, this is Iron Man! ;)";
    final String DOWN = "Down!";
    final String MOVE = "Moving!";
    final String UP = "Up!";
    final String CANCEL = "Canceled!";

    @ViewById(R.id.tv_demo)
    TextView tvDemo;

    @AfterViews
    void initAfterViews() {
        tvDemo.setText(IRON_MAN);
    }

    @Touch(R.id.b_demo)
    void bDemoTouchEvent(MotionEvent event) {
        if (MotionEvent.ACTION_DOWN == event.getAction()) {
            tvDemo.setText(DOWN);
        } else if (MotionEvent.ACTION_UP == event.getAction()) {
            tvDemo.setText(UP);
        } else if (MotionEvent.ACTION_MOVE == event.getAction()) {
            tvDemo.setText(MOVE);
        }
    }



}