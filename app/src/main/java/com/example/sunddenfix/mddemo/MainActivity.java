package com.example.sunddenfix.mddemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.sunddenfix.mddemo.fragment.AlbumFragment;
import com.example.sunddenfix.mddemo.fragment.CollectFragment;
import com.example.sunddenfix.mddemo.fragment.FileFragment;
import com.example.sunddenfix.mddemo.fragment.LikeFragment;
import com.example.sunddenfix.mddemo.fragment.MainFragment;
import com.example.sunddenfix.mddemo.fragment.WalletFragment;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private DrawerLayout          mDrawerLayout;
    private NavigationView        mNavigationView;
    private FrameLayout           mMainLayout;
    private ImageView             mIvHeaderIcon;
    private FragmentManager       mFragmentManager;
    private int                   mCurrentTabIndex;
    private MainFragment          mMainFragment;
    private CollectFragment       mCollectFragment;
    private LikeFragment          mLikeFragment;
    private WalletFragment        mWalletFragment;
    private FileFragment          mFileFragment;
    private Toolbar               mToolbar;
    private ActionBarDrawerToggle mDrawerToggle;
    private AlbumFragment         mAlbumFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        initViews();
        setTabSelection(TabHomeIndex.HOME_TAB_MAIN);
    }

    private void initVariables() {
        mFragmentManager = getSupportFragmentManager();
    }

    private void initViews() {
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mMainLayout = (FrameLayout) findViewById(R.id.main_content_frame);

        //设置Toolbar
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("首页");// 标题的文字需在setSupportActionBar之前，不然会无效
        setSupportActionBar(mToolbar);

        //Toolbar开关控制 侧拉菜单
        ActionBar supportActionBar = getSupportActionBar();
        if (null != supportActionBar) {
            supportActionBar.setDisplayHomeAsUpEnabled(true);
        }
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,
                R.string.drawer_close);
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        //获取头部view  可以实例化头部的控件
        View headerView = mNavigationView.getHeaderView(0);
        mIvHeaderIcon = (ImageView) headerView.findViewById(R.id.header);

        //设置item 字体 背景选择器
        //ColorStateList text = getResources().getColorStateList(R.color.text_selector);
        //mNavigationView.setItemTextColor(text);
        //
        //Drawable drawable = getResources().getDrawable(R.drawable.back_selector);
        //mNavigationView.setItemBackground(drawable);

        //设置隐藏滚动条
        disableNavigationViewScrollbars(mNavigationView);

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //Snackbar.make(mMainLayout, item.getTitle() + " pressed", Snackbar.LENGTH_LONG).show();

                //设置可选项  一定要写 不然选中效果有问题
                item.setCheckable(true);
                item.setChecked(true);
                mDrawerLayout.closeDrawers();

                switch (String.valueOf(item.getTitle())) {
                    case "收藏":
                        setTabSelection(TabHomeIndex.HOME_TAB_COLLECT);
                        break;
                    case "喜欢":
                        setTabSelection(TabHomeIndex.HOME_TAB_LIKE);
                        break;
                    case "钱包":
                        setTabSelection(TabHomeIndex.HOME_TAB_WALLET);
                        break;
                    case "文件":
                        setTabSelection(TabHomeIndex.HOME_TAB_FILE);
                        break;
                    case "相册":
                        setTabSelection(TabHomeIndex.HOME_TAB_ALBUM);
                        break;
                }
                return true;
            }
        });
    }

    private void disableNavigationViewScrollbars(NavigationView navigationView) {
        if (navigationView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navigationView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }

    public void setTabSelection(int tabHomeIndex) {
        if (mCurrentTabIndex == tabHomeIndex) {
            return;
        }
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        hideFragments(transaction);// 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        switch (tabHomeIndex) {
            case TabHomeIndex.HOME_TAB_MAIN:
                if (mMainFragment == null) {
                    mMainFragment = MainFragment.newInstance();
                    transaction.add(R.id.main_content_frame, mMainFragment);
                } else {
                    transaction.show(mMainFragment);
                }
                break;
            case TabHomeIndex.HOME_TAB_COLLECT:
                if (mCollectFragment == null) {
                    mCollectFragment = mCollectFragment.newInstance();
                    transaction.add(R.id.main_content_frame, mCollectFragment);
                } else {
                    transaction.show(mCollectFragment);
                }
                break;
            case TabHomeIndex.HOME_TAB_LIKE:
                if (mLikeFragment == null) {
                    mLikeFragment = mLikeFragment.newInstance();
                    transaction.add(R.id.main_content_frame, mLikeFragment);
                } else {
                    transaction.show(mLikeFragment);
                }
                break;
            case TabHomeIndex.HOME_TAB_WALLET:
                if (mWalletFragment == null) {
                    mWalletFragment = mWalletFragment.newInstance();
                    transaction.add(R.id.main_content_frame, mWalletFragment);
                } else {
                    transaction.show(mWalletFragment);
                }
                break;
            case TabHomeIndex.HOME_TAB_FILE:
                if (mFileFragment == null) {
                    mFileFragment = mFileFragment.newInstance();
                    transaction.add(R.id.main_content_frame, mFileFragment);
                } else {
                    transaction.show(mFileFragment);
                }
                break;
            case TabHomeIndex.HOME_TAB_ALBUM:
                if (mAlbumFragment == null) {
                    mAlbumFragment = mAlbumFragment.newInstance();
                    transaction.add(R.id.main_content_frame, mAlbumFragment);
                } else {
                    transaction.show(mAlbumFragment);
                }
                break;
        }
        mCurrentTabIndex = tabHomeIndex;
        transaction.commitAllowingStateLoss();// 当activity再次被恢复时commit之后的状态将丢失,所以这里不能用commit
    }

    private void hideFragments(FragmentTransaction transaction) {
        List<Fragment> list = mFragmentManager.getFragments();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                transaction.hide(list.get(i));
            }
        }
    }

    static class TabHomeIndex {
        public static final int HOME_TAB_MAIN    = 1; // 首页
        public static final int HOME_TAB_COLLECT = 2; // 收藏
        public static final int HOME_TAB_LIKE    = 3; // 喜欢
        public static final int HOME_TAB_WALLET  = 4; // 钱包
        public static final int HOME_TAB_FILE    = 5; // 文件
        public static final int HOME_TAB_ALBUM   = 6; // 相册
    }

}
