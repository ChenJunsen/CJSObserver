package android.cjs.com.observerdemo;

import android.app.Activity;
import android.cjs.com.cjsobserver.ObserverActivityV2;
import android.cjs.com.cjsobserver.ObserverFragmentObserverableV2;
import android.cjs.com.cjsobserver.ObserverableInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * 描述:应用基类，库文件提供{@link ObserverActivityV2},{@link android.cjs.com.cjsobserver.ObserverAppcompatActivityV2}和{@link ObserverFragmentObserverableV2}
 * 三种基类的使用，可以根据需要集成这三种中的一种。如果都不满足要求，可以实现{@link ObserverableInterface},仿照那三种类的形式，集成到自己的基类中使用
 * <p>
 * 作者:陈俊森
 * 创建时间:2018年05月31日 9:16
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public abstract class BaseActivity extends ObserverActivityV2 {
    static final String TAG = "CJSObserver";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "创建:" + getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "销毁:" + getClass().getSimpleName());
    }

    @Override
    public void onNotifyObserverChanged(String command, Bundle params) {

    }

    @Override
    public String[] setObserverCommands() {
        return new String[0];
    }


    public void startActivity(Class<? extends Activity> clazz, Bundle data) {
        Intent i = new Intent(this, clazz);
        if (data != null) {
            i.putExtras(data);
        }
        startActivity(i);
    }
}
