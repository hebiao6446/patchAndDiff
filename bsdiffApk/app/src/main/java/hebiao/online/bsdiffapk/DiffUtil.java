package hebiao.online.bsdiffapk;

/**
 * Created by apple on 2018/3/22.
 */

public class DiffUtil {

    static {
        System.loadLibrary("hbdiff");
    }

    public static native void diff(String oldpath,String newpath,String patch);


}
