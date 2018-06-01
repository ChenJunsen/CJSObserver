package android.cjs.com.cjsobserver;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import java.lang.ref.WeakReference;

/**
 * 描述:观察者的具体实现
 * <p>
 * 作者:陈俊森
 * 创建时间:2017年12月22日 10:11
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public class ActualObserver implements Observer {
    private Handler mObserverHandler;
    private WeakReference<ObserverableInterface> mActivityV2WeakReference;

    public ActualObserver(ObserverableInterface observerableInterface) {
        mObserverHandler = new Handler(Looper.getMainLooper());
        mActivityV2WeakReference = new WeakReference<ObserverableInterface>(observerableInterface);
    }

    @Override
    public void dispatchChange(String command, Bundle params) {
        mObserverHandler.post(new ObserverRunnable(command, params));
    }

    private class ObserverRunnable implements Runnable {
        private String command;
        private Bundle params;

        public ObserverRunnable(String command, Bundle params) {
            this.command = command;
            this.params = params;
        }

        @Override
        public void run() {
            ObserverableInterface observerableInterface = mActivityV2WeakReference.get();
            if (observerableInterface != null) {
                observerableInterface.onNotifyObserverChanged(command, params);
            }
        }
    }

    /**
     * 观察者模式构建，主要操作为注册指令集
     */
    public void onCreate() {
        ObserverableInterface observerableInterface = mActivityV2WeakReference.get();
        if (observerableInterface != null) {
            String[] setObserverCommands = observerableInterface.setObserverCommands();
            if (setObserverCommands != null) {
                for (String command : setObserverCommands) {
                    ObserverController.getInstance().registerObserver(command, this);
                }
            }
        }
    }

    /**
     * 观察者模式销毁，主要操作为注销指令集
     */
    public void onDestroy() {
        ObserverableInterface observerableInterface = mActivityV2WeakReference.get();
        if (observerableInterface != null) {
            String[] setObserverCommands = observerableInterface.setObserverCommands();
            if (setObserverCommands != null) {
                for (String command : setObserverCommands) {
                    ObserverController.getInstance().unRegisterObserver(command, this);
                }
            }
        }
    }
}
