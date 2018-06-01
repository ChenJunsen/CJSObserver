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
public abstract class ObserverActivity extends Activity implements ObserverableInterface {
    public ActualObserver mActualObserver;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActualObserver = new ActualObserver(this);
        mActualObserver.onCreate();
    }

    @Override
    protected void onDestroy() {
        mActualObserver.onDestroy();
        super.onDestroy();
    }

    /**
     * 获取当前页面的观察者，可用于外部直接通过{@link ObserverController#registerObserver(String, Observer)}或者{@link ObserverController#unRegisterObserver(String, Observer)}
     * @return
     */
    public Observer getObserver() {
        return mActualObserver;
    }
}
