package com.example.oliver.intenttest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText ed;
    Button text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         ed=findViewById(R.id.edit);
        text1=findViewById(R.id.shinu);
        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Main2Activity.this, "test", Toast.LENGTH_SHORT).show();
                Intent test=new Intent(Intent.ACTION_SENDTO);
                test.setData(Uri.parse("mailto:"));
                test.putExtra(Intent.EXTRA_SUBJECT,ed.getText().toString());
                test.putExtra(Intent.EXTRA_TEXT,"asdas");
                if (test.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(test);
                }

            }
        });
    }
}
