package sg.edu.nus.team7adproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import sg.edu.nus.team7adproject.Adapter.Requisitions;
import sg.edu.nus.team7adproject.Adapter.RequisitionsAdapter;
import sg.edu.nus.team7adproject.HomeActivity;
import sg.edu.nus.team7adproject.R;
import sg.edu.nus.team7adproject.utils.AsyncToServer;
import sg.edu.nus.team7adproject.utils.Command;
import sg.edu.nus.team7adproject.utils.MyProgressDialogHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UI5Activity extends AppCompatActivity implements AsyncToServer.IServerResponse  {

    private ListView lv_list;
    private RequisitionsAdapter requisitionsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui5);
        //
        lv_list=findViewById(R.id.lv_list);
        //获取数据
        try{
            Command cmd = new Command(this, "Requisitions","http://10.0.2.2:44352/api/requisitionapi/getAllRequisitionsByEmpId?empId="+ HomeActivity.loginUser.getId(), null);
            MyProgressDialogHelper.show(this,"加载数据中,请稍后...");
            new AsyncToServer().execute(cmd);
        }catch (Exception ex){

        }
    }


    @Override
    public void onServerResponse(JSONObject jsonObj) {
        if (jsonObj == null)
            return;
        try {
            MyProgressDialogHelper.close();
            //
            String context = (String) jsonObj.get("context");
            if (context.equals("Requisitions")){
                JSONArray array =jsonObj.getJSONArray("result");
                List<Requisitions> list=new ArrayList<>();
                for(int i=0;i<array.length();i++){
                    JSONObject json=array.getJSONObject(i);
                    list.add(new Requisitions((String)json.get("Id"),(String)json.get("DateSubmitted"),(String)json.get("status"),(String)json.get("remarks")));
                }
                requisitionsAdapter=new RequisitionsAdapter(this,list);
                lv_list.setAdapter(requisitionsAdapter);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
