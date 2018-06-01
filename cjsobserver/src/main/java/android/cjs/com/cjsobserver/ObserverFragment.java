package android.cjs.com.cjsobserver;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * 描述:继承自{@link Fragment}的观察者模式基类
 * <p>
 * 作者:陈俊森
 * 创建时间:2018年06月01日 10:07
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public abstract class ObserverFragment extends Fragment implements ObserverableInterface {
    private ActualObserver mActualObserver;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActualObserver=new ActualObserver(this);
        mActualObserver.onCreate();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mActualObserver.onDestroy();
    }

    public Observer getObserver() {
        return mActualObserver;
    }
}
