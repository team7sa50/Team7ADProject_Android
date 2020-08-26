package sg.edu.nus.team7adproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import sg.edu.nus.team7adproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UI1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui1);
        //
        findViewById(R.id.tv1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UI1Activity.this,UI2Activity.class));
            }
        });
        findViewById(R.id.tv2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UI1Activity.this,UI5Activity.class));
            }
        });
    }
}
