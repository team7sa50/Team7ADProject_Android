package sg.edu.nus.team7adproject.UI;

import androidx.appcompat.app.AppCompatActivity;
import sg.edu.nus.team7adproject.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class UI2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui2);
        //
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UI2Activity.this,UI3Activity.class));
            }
        });
    }
}
