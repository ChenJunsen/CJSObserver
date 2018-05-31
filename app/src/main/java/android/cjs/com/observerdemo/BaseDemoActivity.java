package android.cjs.com.observerdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 描述:测试样本基类
 * <p>
 * 作者:陈俊森
 * 创建时间:2018年05月31日 17:15
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 1.0
 */
public abstract class BaseDemoActivity extends BaseActivity {
    private String text;
    private TextView tv_text;
    private String command;
    private Button btn;
    private Bundle data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo1);
        data = getIntent().getExtras();
        command = data.getString("command");
        tv_text = findViewById(R.id.text);
        btn = findViewById(R.id.btn);
        tv_text.setText(setText());
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setTargetClass() != null) {
                    startActivity(setTargetClass(), data);
                }
            }
        });
    }

    protected abstract Class<? extends Activity> setTargetClass();

    protected abstract String setText();

    /**
     * 重写该方法，设置需要监听的指令集
     *
     * @return 指令集合，（规范写法，建议建一个常量类，用于保存指令）
     */
    @Override
    public String[] setObserverCommands() {
        return new String[]{Common.Notification.DESTROY_PAGE};
    }

    /**
     * 重写该方法，实现对之前{@link #setObserverCommands()}的指令的实现操作
     *
     * @param command 获取到的指令
     * @param params  附带的参数
     */
    @Override
    public void onNotifyObserverChanged(String command, Bundle params) {
        switch (command) {
            case Common.Notification.DESTROY_PAGE:
                Toast.makeText(this, getClass().getSimpleName() + "被销毁", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
    }
}
