package android.cjs.com.observerdemo;

import android.app.Activity;
import android.cjs.com.cjsobserver.ObserverController;
import android.os.Bundle;

public class DemoActivity2 extends BaseDemoActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //举个栗子，本来DemoActivity2是已经有销毁页面的指令的，现在调用该方法手动实现取消该页面的该指令
        ObserverController.getInstance().unRegisterObserver(Common.Notification.DESTROY_PAGE,getActivityObserver());
    }

    @Override
    protected Class<? extends Activity> setTargetClass() {
        return DemoActivity3.class;
    }

    @Override
    protected String setText() {
        return "我是demo2";
    }
}
