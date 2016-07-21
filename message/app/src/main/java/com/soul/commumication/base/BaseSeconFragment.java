package com.soul.commumication.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * * @author Administrator
 *
 * @项目名:wc360_android
 * @包名: com.vtcomm.wangcai360.base
 * @作者：祝明
 * @描述：TODO
 * @创建时间：2015/12/30 10:42
 */
public abstract class BaseSeconFragment extends Fragment {

    protected Activity mActivity;
    protected RelativeLayout mActionBar;
    protected TextView mTitle;
    protected TextView mEnter;
    protected FrameLayout mContentView;
    protected ImageView mBack;//左侧图片
    protected ImageView mAction;//右侧图片
    protected Button bt_search;//搜索图标

    protected static final int REFRESH = 01;//刷新状态
    protected static final int MORE = 02;//加载更多状态

    protected int pageNum = 1;//初始化当前页
    protected int state;
    protected Context mContext;

    /**
     * 刷新或加载时调用的方法
     *
     * @param pageNum
     * @param state
     */
    protected void loadData(int pageNum, int state) {

    }

    ;

	/*@Override
    public void onRefresh() {

		pageNum = 1;
		loadData(1, REFRESH);
	}

	@Override
	public void onLoadMore() {

		loadData(++pageNum, MORE);
	}
*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity = getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext  = getActivity();
        return initView();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initData();
        initEvent();
    }

    // 初始化界面
    protected abstract View initView();

    // 初始化数据
    protected abstract void initData();

    // 初始化事件
    protected void initEvent() {
    }

    ;

    /**
     * 开启fragment
     *
     * @param id       容器的id
     * @param fragment 开启的fragment
     * @param bundle   传递的数据
     * @param tag      开启fragment的标签
     */
    public void startFragment(int id, Fragment fragment, Bundle bundle,
                              String tag) {
        // 开启事务
        FragmentTransaction transaction = getActivity()
                .getSupportFragmentManager().beginTransaction();
        // 设置参数
        fragment.setArguments(bundle);

        transaction.add(id, fragment, tag);
        transaction.addToBackStack(tag);
        transaction.commit();
    }

    /**
     * 有返回结果的开启Fragment,返回的结果在onActivityResult中获取
     *
     * @param id          容器的id
     * @param fragment    开启的fragment
     * @param bundle      传递的数据
     * @param tag         开启fragment的标签
     * @param reuqestCode 请求码
     */
    public void startFragmentForResult(int id, Fragment fragment,
                                       Bundle bundle, String tag, int reuqestCode) {

        fragment.setTargetFragment(this, reuqestCode);
        startFragment(id, fragment, bundle, tag);
    }

    /**
     * 设置返回的结果,
     *
     * @param intent 存储数据的意图,在onActivityResult中获取结果
     */
    public void setResult(Intent intent) {

        getTargetFragment().onActivityResult(getTargetRequestCode(), 0, intent);
    }


    public void finish() {
        getActivity().finish();
    }
}
