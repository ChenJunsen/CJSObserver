package android.cjs.com.cjsobserver;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:观察者控制器(全局单例模式)
 * <p>
 * 作者:陈俊森
 * 创建时间:2017年12月22日 9:35
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public class ObserverController implements Observerable {
    private volatile static ObserverController sObserverController;
    private Map<String,List<Observer>> mObserverMap;

    private ObserverController() {
        mObserverMap=new HashMap<>();
    }

    /**
     * 获取一个控制器实例
     * @return
     */
    public static synchronized ObserverController getInstance(){
        if(sObserverController==null){
            sObserverController=new ObserverController();
        }
        return sObserverController;
    }

    /**
     * 注册观察者
     * @param command
     * @param observer
     */
    @Override
    public void registerObserver(String command, Observer observer) {
        if(command==null){
            return;
        }
        synchronized (observer){
            List<Observer> observerList=mObserverMap.get(command);
            if(observerList==null){
                observerList=new ArrayList<>();
            }
            if(!observerList.contains(observer)){
                observerList.add(observer);
            }
            mObserverMap.put(command,observerList);
        }
    }

    /**
     * 注销观察者
     * @param command
     * @param observer
     */
    @Override
    public void unRegisterObserver(String command, Observer observer) {
        if(command==null){
            return;
        }
        synchronized (mObserverMap){
            List<Observer> observerList=mObserverMap.get(command);
            if(observerList!=null && observerList.size()>0 && observerList.contains(observer)){
                observerList.remove(observer);
            }
        }
    }

    @Override
    public void notifyObserverChanged(String command, Bundle params) {
        if(command==null){
            return;
        }
        List<Observer> observerList=mObserverMap.get(command);
        if(observerList!=null && observerList.size()>0){
            for(Observer observer: observerList){
                observer.dispatchChange(command,params);
            }
        }
    }
}
