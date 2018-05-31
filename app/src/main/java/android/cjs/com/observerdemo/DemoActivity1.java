package android.cjs.com.observerdemo;

import android.app.Activity;

public class DemoActivity1 extends BaseDemoActivity {

    @Override
    protected Class<? extends Activity> setTargetClass() {
        return DemoActivity2.class;
    }

    @Override
    protected String setText() {
        return "我是demo1";
    }
}
