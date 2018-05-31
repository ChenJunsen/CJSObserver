package android.cjs.com.observerdemo;

import android.app.Activity;
import android.cjs.com.cjsobserver.ObserverController;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DemoActivity3 extends BaseDemoActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button btn=findViewById(R.id.btn);
        btn.setText("点我销毁之前所有页面并返回MainActivity");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObserverController.getInstance().notifyObserverChanged(Common.Notification.DESTROY_PAGE, null);
            }
        });
    }

    @Override
    protected Class<? extends Activity> setTargetClass() {
        return null;
    }

    @Override
    protected String setText() {
        return "我是demo3";
    }
}
