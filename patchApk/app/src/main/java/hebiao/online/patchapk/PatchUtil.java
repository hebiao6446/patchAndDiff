package hebiao.online.patchapk;

/**
 * Created by apple on 2018/3/22.
 */

public class PatchUtil {

    static {
        System.loadLibrary("hbpatch");
    }

    public static native void patch(String oldpath,String newpath,String patch);

}
