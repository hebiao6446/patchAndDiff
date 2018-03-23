package hebiao.online.bsdiffapk;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void diff(View v){

        new Thread(){
            @Override
            public void run() {
                doDiffAction();
            }
        }.start();

    }

    private void doDiffAction(){

        System.out.println("xxxxxxxxxxxxxxxxxx  start");
        String oldFileName = getSdCardPath()+"/aaa/app_old.apk";
        String newFileName = getSdCardPath()+"/aaa/app_new.apk";
        String diffFileName = getSdCardPath()+"/aaa/apk_diff.patch";
        DiffUtil.diff(oldFileName,newFileName,diffFileName);
        System.out.println("===============  end");

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
