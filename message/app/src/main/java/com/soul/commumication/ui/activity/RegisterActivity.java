package com.soul.commumication.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.soul.commumication.R;
import com.soul.commumication.ui.fragment.RegisterFragment;
import com.soul.commumication.ui.fragment.RegisterPhoneFragment;
import com.soul.commumication.ui.fragment.RegisterSucceedFragment;
import com.soul.commumication.ui.fragment.RegisterVerificationFragment;
import com.soul.commumication.ui.wight.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

/**
 * 注册
 */
public class RegisterActivity extends AppCompatActivity {

    private List<Fragment> mData;
    private NoScrollViewPager mViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initData();


    }

    private void initData() {
        mData = new ArrayList<>();
        mData.add(new RegisterPhoneFragment());
        mData.add(new RegisterVerificationFragment());
        mData.add(new RegisterFragment());
        mData.add(new RegisterSucceedFragment());
        mViewpager.setAdapter(new RegisterAdapter(getSupportFragmentManager()));

    }

    private void initView() {
        mViewpager = (NoScrollViewPager) findViewById(R.id.vp_register);
    }


    private class RegisterAdapter extends FragmentPagerAdapter {

        public RegisterAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (mData != null) {
                return mData.get(position);
            }
            return null;
        }

        @Override
        public int getCount() {
            if (mData != null) {
                return mData.size();
            }
            return 0;
        }
    }


}
