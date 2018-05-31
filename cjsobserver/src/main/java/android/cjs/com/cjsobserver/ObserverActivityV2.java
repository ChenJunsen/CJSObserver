package android.cjs.com.cjsobserver;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * 描述:继承自{@link Activity}的观察者模式基类
 * <p>
 * 作者:陈俊森
 * 创建时间:2017年12月22日 10:04
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public abstract class ObserverActivityV2 extends Activity implements ObserverableInterface {
    public ActivityObserver mActivityObserver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
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
