package framworkdemo.lzp.com.net;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by Li Xiaopeng on 18/7/4.
 */
public class NetUtils {

    private static NetUtils netUtils;

    public static NetUtils getInstance(){
        if (netUtils==null){
            synchronized (NetUtils.class){
                netUtils = new NetUtils();
            }
        }
        return netUtils;
    }


    public void sendRequest(@NonNull String name, @NonNull String pwd, @NonNull NetListener listener){
        //根据status,调整界面。这里假设0：登录成功 1:用户名错误  2：密码错误
        if (!name.equals("张三")){
            listener.success(1);
        }else if(!pwd.equals("111111")){
            listener.success(2);
        }else{
            listener.success(0);
        }
    }

    public void cancel(String tag){
        Log.e(tag,"取消网络请求");
    }
}
