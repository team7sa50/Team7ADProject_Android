package sg.edu.nus.team7adproject.UI;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import sg.edu.nus.team7adproject.R;

public class SupplierList extends AppCompatActivity{
    ListView listView;
    ArrayList<String> arrayList = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supplierlist1);

        listView = findViewById(R.id.list_view);

        String supplier_array = "{\"suppliers\":[\n" +
                "    {\n" +
                "        \"Id\": \"2a8e646f-03af-43bd-a6a2-6fba66f67e1c\",\n" +
                "        \"supplierCode\": \"BANE\",\n" +
                "        \"name\": \"BANES Shop\",\n" +
                "        \"address\": \"Blk 124, Alexandra Road #03-04 Banes Building Singapore 550315\",\n" +
                "        \"contactNo\": 4781234,\n" +
                "        \"faxNo\": 4792434\n" +
                "    },\n" +
                "    {\n" +
                "        \"Id\": \"b24381c3-38cc-468c-981d-f9ee2315492f\",\n" +
                "        \"supplierCode\": \"CHEP\",\n" +
                "        \"name\": \"Cheap Stationer\",\n" +
                "        \"address\": \"Blk 34, Clementi Road #07-02 Ban Ban Soh Building Singapore 110525\",\n" +
                "        \"contactNo\": 3543234,\n" +
                "        \"faxNo\": 4742434\n" +
                "    },\n" +
                "    {\n" +
                "        \"Id\": \"cf1616d5-4616-4eb6-9ef1-f25c90010511\",\n" +
                "        \"supplierCode\": \"ALPA\",\n" +
                "        \"name\": \"ALPHA Office Supplies\",\n" +
                "        \"address\": \"Blk 1128, Ang Mo Kio Industrial Park #02-1108 Ang Mo Kio Street 62 Singapore 622262\",\n" +
                "        \"contactNo\": 4619928,\n" +
                "        \"faxNo\": 4612238\n" +
                "    }]\n" +
                "}";

        try {
            JSONObject jsonObject = new JSONObject(supplier_array);
            JSONArray jsonArray = jsonObject.getJSONArray("suppliers");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject object = jsonArray.getJSONObject(i);
                String supplierId = object.getString("Id");
                String suppliercode = object.getString("supplierCode");
                String suppliername = object.getString("name");
                String address = object.getString("address");
                String contactNo = object.getString("contactNo");
                String FaxNo = object.getString("faxNo");
                arrayList.add("ID: "+supplierId+"\n"+"Supplier Code: "+suppliercode+"\n"+"Supplier Name: "+suppliername+"\n"
                        +"Address: "+address+"\n"+"Contact No: "+contactNo+"\n"+"Fax No: "+FaxNo+"\n");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(),arrayList.get(i),Toast.LENGTH_LONG).show();
            }
        });
    }
}