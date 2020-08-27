package sg.edu.nus.team7adproject.UI;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.team7adproject.Adapter.DepartmentAdapter;
import sg.edu.nus.team7adproject.Adapter.Departments;
import sg.edu.nus.team7adproject.R;
import sg.edu.nus.team7adproject.utils.AsyncToServer;
import sg.edu.nus.team7adproject.utils.Command;
import sg.edu.nus.team7adproject.utils.MyProgressDialogHelper;

public class DepartmentDetail extends AppCompatActivity implements AsyncToServer.IServerResponse {

    private ListView listView;
    private DepartmentAdapter departmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.departmentdetails);

        listView = findViewById(R.id.list_view);

        try {
            Command cmd = new Command(this, "Departments", "http://10.0.2.2:53299/api/stationerystoreapi/viewDepartments", null);
            MyProgressDialogHelper.show(this,"Loading Data, Please wait...");
            new AsyncToServer().execute(cmd);
        } catch (Exception ex) {
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
            if (context.equals("Departments")){
                JSONArray array =jsonObj.getJSONArray("result");
                List<Departments> list=new ArrayList<>();
                for(int i=0;i<array.length();i++){
                    JSONObject json=array.getJSONObject(i);
                    //list.add(new Departments((String) json.get("Id"), (String) json.get("DeptCode"), (String) json.get("DepartmentName"), (String) json.get("ContactName"), (String) json.get("HeadName"), (String) json.get("RepName"), (String) json.get("CollectionPoint")));
                    list.add(new Departments("ID: "+(String)json.get("Id"),"DeptCode: "+(String)json.get("DeptCode"),"Department Name: "+(String)json.get("DepartmentName"),"Contact Name: "+(String)json.get("ContactName"),(int)json.get("Telephone"),(int)json.get("FaxNo"),"Head Name: "+(String)json.get("HeadName"),"Representative: "+(String)json.get("RepName"),"Collection Point: "+(String)json.get("CollectionPoint")));
                }
                departmentAdapter = new DepartmentAdapter(this,list);
                listView.setAdapter(departmentAdapter);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
