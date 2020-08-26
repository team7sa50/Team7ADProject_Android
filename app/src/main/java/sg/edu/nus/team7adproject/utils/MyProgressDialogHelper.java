package sg.edu.nus.team7adproject.utils;

import android.app.ProgressDialog;
import android.content.Context;

import sg.edu.nus.team7adproject.R;

public class MyProgressDialogHelper {

    private static ProgressDialog progressDialog;

    /**
     * 显示加载对话框
     */
    public static void show(Context context,String mess){
        progressDialog=new ProgressDialog(context);
        progressDialog.setTitle(context.getString(R.string.app_name));
        progressDialog.setMessage(mess);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    /**
     * 关闭加载对话框
     */
    public static void close(){
        progressDialog.cancel();
    }
}
