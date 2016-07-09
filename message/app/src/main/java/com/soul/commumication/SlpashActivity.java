package com.zhuming.commumication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zhuming.commumication.ui.LoginActivity;
import com.zhuming.commumication.ui.RegisterActivity;
import com.zhuming.commumication.utils.basicutils.UIUtils;

public class SlpashActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slpash);
        ImageView isSlpash = (ImageView) findViewById(R.id.iv_slpash);
        LinearLayout linearlayout = (LinearLayout) findViewById(R.id.ll_loginAndRegister);
        Button btLogin = (Button) findViewById(R.id.bt_login);
        Button btRegister = (Button) findViewById(R.id.bt_register);
        btLogin.setOnClickListener(this);
        btRegister.setOnClickListener(this);
        setImageAnimation(isSlpash);
        setLinearLayoutAnimation(linearlayout);
    }

    private void setLinearLayoutAnimation(LinearLayout linearlayout) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 200, 0);
        translateAnimation.setInterpolator(new DecelerateInterpolator());
        translateAnimation.setDuration(1500);
        linearlayout.startAnimation(translateAnimation);
    }

    private void setImageAnimation(ImageView isSlpash) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.2f, 1, 1.2f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        isSlpash.setAnimation(scaleAnimation);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //登入
            case R.id.bt_login:
                startActivity(new Intent(UIUtils.getContext(), LoginActivity.class));
                break;

            //注册
            case R.id.bt_register:
                startActivity(new Intent(UIUtils.getContext(), RegisterActivity.class));
                break;
        }

    }
}
