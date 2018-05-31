package android.cjs.com.cjsobserver;

import android.os.Bundle;

/**
 * 描述:被观察者
 * <p>
 * 作者:陈俊森
 * 创建时间:2017年12月22日 9:30
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 2.0
 */
public interface Observerable {
    /**
     * 注册观察者
     * @param command
     * @param observer
     */
    void registerObserver(String command, Observer observer);

    /**
     * 注销观察者
     * @param command
     * @param observer
     */
    void unRegisterObserver(String command, Observer observer);

    /**
     * 通知观察者更新
     * @param command
     * @param params
     */
    void notifyObserverChanged(String command, Bundle params);
}
