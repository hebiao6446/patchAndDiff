package hebiao.online.patchapk;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void buttonAction(View v){
        new Thread(){
            @Override
            public void run() {
                doPatchAction();
            }
        }.start();
    }


    private void doPatchAction(){
        System.out.println("开始 合成 ");


        String oldFileName = getSdCardPath()+"/bbb/app_old.apk";
        String newFileName = getSdCardPath()+"/bbb/app_new.apk";
        String diffFileName = getSdCardPath()+"/bbb/apk_diff.patch";

        PatchUtil.patch(oldFileName,newFileName,diffFileName);

        System.out.println("合成 结束");

    }


    public static boolean isSdCardExist() {
        return Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED);
    }


    public static String getSdCardPath() {
        boolean exist = isSdCardExist();
        String sdpath = "";
        if (exist) {
            sdpath = Environment.getExternalStorageDirectory()
                    .getAbsolutePath();
        }
        return sdpath;

    }


}
