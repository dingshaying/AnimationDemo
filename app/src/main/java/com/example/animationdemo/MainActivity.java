package com.example.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnTween;
    private Button btnFrame;
    private Button btnAttr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTween = findViewById(R.id.btn_tween);
        btnTween.setOnClickListener(this);
        btnFrame = findViewById(R.id.btn_frame);
        btnFrame.setOnClickListener(this);
        btnAttr = findViewById(R.id.btn_attr);
        btnAttr.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_tween:
                Intent intent = new Intent(MainActivity.this,TweenAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_frame:
                intent = new Intent(MainActivity.this,FrameAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_attr:
                intent = new Intent(MainActivity.this, ValueAnimationActivity.class);
                startActivity(intent);
                break;
        }


    }
}
