package sg.edu.nus.team7adproject.UI;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.team7adproject.Adapter.Suppliers;
import sg.edu.nus.team7adproject.Adapter.SuppliersAdapter;
import sg.edu.nus.team7adproject.R;
import sg.edu.nus.team7adproject.utils.AsyncToServer;
import sg.edu.nus.team7adproject.utils.Command;
import sg.edu.nus.team7adproject.utils.MyProgressDialogHelper;

public class SupplierDetail extends AppCompatActivity implements AsyncToServer.IServerResponse {
    private ListView listView;
    private SuppliersAdapter suppliersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplierlist1);

        listView = findViewById(R.id.list_view);

        try {
            Command cmd = new Command(this, "Suppliers", "http://10.0.2.2:53299/api/stationerystoreapi/viewSuppliers", null);
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
            if (context.equals("Suppliers")){
                JSONArray array =jsonObj.getJSONArray("result");
                List<Suppliers> list=new ArrayList<>();
                for(int i=0;i<array.length();i++){
                    JSONObject json=array.getJSONObject(i);
                   // list.add("ID: "+"Id"+"\n"+"Supplier Code: "+"supplierCode"+"\n"+"Supplier Name: "+"name"+"\n"
                           // +"Address: "+"address"+"\n"+"Contact No: "+"contactNo"+"\n"+"Fax No: "+"faxNo"+"\n");
                    list.add(new Suppliers("ID: "+(String)json.get("Id"),"Code: "+(String)json.get("supplierCode"),"Name: "+(String)json.get("name"),"Address: "+(String)json.get("address"),(int)json.get("contactNo"),(int)json.get("faxNo")));
                }
                suppliersAdapter = new SuppliersAdapter(this,list);
                listView.setAdapter(suppliersAdapter);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}