package sg.edu.nus.team7adproject.UI;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import sg.edu.nus.team7adproject.Adapter.Inventory;
import sg.edu.nus.team7adproject.Adapter.InventoryAdapter;
import sg.edu.nus.team7adproject.R;
import sg.edu.nus.team7adproject.utils.AsyncToServer;
import sg.edu.nus.team7adproject.utils.Command;
import sg.edu.nus.team7adproject.utils.MyProgressDialogHelper;

public class InventoryDetail extends AppCompatActivity implements AsyncToServer.IServerResponse {
    private ListView listView;
    private InventoryAdapter inventoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inventory_details);

       listView = findViewById(R.id.list_view);

        try {
            Command cmd = new Command(this, "Inventory", "http://10.0.2.2:53299/api/stationerystoreapi/viewInventories", null);
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
            if (context.equals("Inventory")){
                JSONArray array =jsonObj.getJSONArray("result");
                List<Inventory> list=new ArrayList<>();
                for(int i=0;i<array.length();i++){
                    JSONObject json=array.getJSONObject(i);
                    list.add(new Inventory((String)json.get("itemCode"),(String)json.get("description"),(double)json.get("price"),(int)json.get("stock"),(String)json.get("measurementUnit"),(String)json.get("location")));
                }
                inventoryAdapter = new InventoryAdapter(this,list);
                listView.setAdapter(inventoryAdapter);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

