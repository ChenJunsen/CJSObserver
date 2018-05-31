package android.cjs.com.cjsobserver;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

/**
 * 描述:继承自{@link FragmentActivity}的观察者模式基类
 * <p>
 * 作者:陈俊森
 * 创建时间:2018年05月31日 16:37
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public abstract class ObserverFragmentObserverableV2 extends FragmentActivity implements ObserverableInterface {
    private ActivityObserver mActivityObserver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityObserver = new ActivityObserver(this);
        mActivityObserver.onCreate();
    }

    @Override
    protected void onDestroy() {
        mActivityObserver.onDestroy();
        super.onDestroy();
    }

    public ActivityObserver getActivityObserver() {
        return mActivityObserver;
    }
}
