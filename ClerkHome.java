package sg.edu.nus.team7adproject.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import sg.edu.nus.team7adproject.R;
import sg.edu.nus.team7adproject.Store.AddAdjustmentVoucherFragment;

public class ClerkHome extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clerkhome);
        //

        findViewById(R.id.btn_Inventory).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClerkHome.this,InventoryDetail.class));
            }
        });

        findViewById(R.id.btn_adjustmentvoucher).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClerkHome.this,Addadjustmentvoucher.class));
            }
        });

        findViewById(R.id.btn_supplierlist).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClerkHome.this, SupplierDetail.class));
            }
        });

        findViewById(R.id.btn_dept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClerkHome.this, DepartmentDetail.class));
            }
        });
    }
}
