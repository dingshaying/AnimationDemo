package com.example.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class TweenAnimationActivity extends AppCompatActivity {
    private ImageView ivInside;
    private ImageView ivOuter;
    private TextView textView;

    private Animation insideCircle;
    private Animation outerCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation);

        textView = findViewById(R.id.tv_view);
        ivInside = findViewById(R.id.iv_inside_circle);
        ivOuter = findViewById(R.id.iv_outer_circle);

        insideCircle = AnimationUtils.loadAnimation(this, R.anim.inside_rotate);
        insideCircle.setInterpolator(new LinearInterpolator()); // 插值器

        outerCircle = AnimationUtils.loadAnimation(this, R.anim.outer_rotate);
        outerCircle.setInterpolator(new LinearInterpolator());

        ivInside.startAnimation(insideCircle);
        ivOuter.startAnimation(outerCircle);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_translation:
                // 根据anim/xml创建
                Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                textView.startAnimation(animation);

                // 动态创建，完成跟xml动画一样的效果
//                Animation animation = new TranslateAnimation(0, 100, 0, 300);
//                animation.setDuration(3000);
//                textView.startAnimation(animation);
                break;
            case R.id.btn_scale:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
                textView.startAnimation(animation);

//                // 动态创建
//                animation = new ScaleAnimation(0, 2, 0, 2,
//                        Animation.RELATIVE_TO_SELF, 0.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f);
//                animation.setDuration(1000);
//                textView.startAnimation(animation);
                break;
            case R.id.btn_rotate:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                textView.startAnimation(animation);

                // 动态创建
//                animation = new RotateAnimation(0, 270,
//                        Animation.RELATIVE_TO_SELF, 0.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f);
//                animation.setDuration(3000);
//                textView.startAnimation(animation);
                break;
            case R.id.btn_alpha:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
                textView.startAnimation(animation);

                // 动态创建
//                animation = new AlphaAnimation(1, 0);
//                animation.setDuration(3000);
//                textView.startAnimation(animation);
                break;
            case R.id.btn_set:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
                textView.startAnimation(animation);

                // 动态创建
                // 1. 创建自定义组合动画对象
//                AnimationSet set = new AnimationSet(true);
//                set.setRepeatMode(Animation.RESTART);
//                set.setRepeatCount(1);

                // 2. 定义子动画
//                // 子动画1: 旋转动画
//                Animation rotate = new RotateAnimation(0, 360,
//                        Animation.RELATIVE_TO_SELF, 0.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f);
//                rotate.setDuration(1000);
//                rotate.setRepeatMode(Animation.RESTART);
//                rotate.setRepeatCount(Animation.INFINITE);

//                // 子动画2: 平移动画
//                Animation translate = new TranslateAnimation(
//                        TranslateAnimation.RELATIVE_TO_PARENT, -0.5f,
//                        TranslateAnimation.RELATIVE_TO_PARENT, 0.5f,
//                        TranslateAnimation.RELATIVE_TO_SELF, 0,
//                        TranslateAnimation.RELATIVE_TO_SELF, 0);
//                translate.setDuration(10000);

//                // 子动画3:透明度动画
//                Animation alpha = new AlphaAnimation(1, 0);
//                alpha.setDuration(3000);
//                alpha.setStartOffset(7000);

//                // 子动画4:缩放动画
//                Animation scale = new ScaleAnimation(1, 0.5f, 1, 0.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f,
//                        Animation.RELATIVE_TO_SELF, 0.5f);
//                scale.setDuration(1000);
//                scale.setStartOffset(4000);

                // 3. 将创建的子动画添加到组合动画里
//                set.addAnimation(alpha);
//                set.addAnimation(rotate);
//                set.addAnimation(translate);
//                set.addAnimation(scale1);
//                set.addAnimation(AnimationUtils.loadAnimation(this, R.anim.view_set));

                // 4. 启动动画，子动画的启动没有先后顺序，按照startOffset进行
//                textView.startAnimation(set);
                break;
            case R.id.btn_compose:
                animation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                textView.startAnimation(animation);

                final Animation second = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                animation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textView.startAnimation(second);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                break;
            case R.id.btn_flash:
                AlphaAnimation alpha = new AlphaAnimation(0.1f, 1.0f);
                alpha.setDuration(100);
                alpha.setRepeatCount(10);
                alpha.setRepeatMode(Animation.REVERSE);
                textView.startAnimation(alpha);
                break;
            case R.id.btn_change:
                Intent intent = new Intent(TweenAnimationActivity.this, SecondActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.zoom_in, R.anim.zoom_out);
                break;
        }
    }
    private void startAnimation() {
        ivInside.startAnimation(insideCircle);
        ivOuter.startAnimation(outerCircle);

    }

    private void stopAnimation() {
        ivInside.clearAnimation();
        ivOuter.clearAnimation();
    }

}