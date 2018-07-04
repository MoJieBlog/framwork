package framworkdemo.lzp.com.net;

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


    public void sendRequest(NetListener listener){

    }

    public void cancel(String tag){

    }
}
