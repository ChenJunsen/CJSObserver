package android.cjs.com.cjsobserver;

import android.os.Bundle;

/**
 * 描述:观察者接口
 * <p>
 * 作者:陈俊森
 * 创建时间:2017年12月22日 9:29
 * 邮箱:chenjunsen@outlook.com
 *
 * @version 2.0
 */
public interface Observer {
    /**
     * 分发指令
     * @param command 需要处理的指令
     * @param params 指令附带的参数
     */
    void dispatchChange(String command, Bundle params);
}
