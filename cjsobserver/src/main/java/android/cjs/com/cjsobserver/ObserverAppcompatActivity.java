package android.cjs.com.cjsobserver;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 描述:继承自{@link AppCompatActivity}的观察者模式基类
 * <p>
 * 作者:陈俊森
 * 创建时间:2018年05月31日 9:40
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public abstract class ObserverAppcompatActivity extends AppCompatActivity implements ObserverableInterface {
    private ActualObserver mActualObserver;

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

    public Observer getObserver() {
        return mActualObserver;
    }
}
