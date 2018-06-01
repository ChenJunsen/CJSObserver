package android.cjs.com.cjsobserver;

import android.os.Bundle;

/**
 * 描述:具体被观察者需要交互的接口。该接口的设计初衷是解决单继承{@link ObserverActivity}的问题，将具体的
 * 注册监听操作与基类分离，可以集成到自己的基类中
 * <p>
 * 作者:陈俊森
 * 创建时间:2018年05月31日 16:06
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public interface ObserverableInterface {
    /**
     * 到获取到指令时，需要做的事
     * @param command 获取到的指令
     * @param params 附带的参数
     */
    void onNotifyObserverChanged(String command, Bundle params);
    /**
     * 设置需要拦截的command
     * @return 如果不设置，返回空，那么所有指令都不会拦截
     */
    String[] setObserverCommands();
}
