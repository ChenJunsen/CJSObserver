package android.cjs.com.observerdemo;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle data = new Bundle();
                data.putString("command", Common.Notification.DESTROY_PAGE);
                startActivity(DemoActivity1.class, data);
            }
        });
    }
}
