package com.example.oliver.order;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=0;
    public void order(View view)
    {
        TextView tv=(TextView)findViewById(R.id.Price_quantity);
        tv.setText("$"+(quantity*5));

    }
    public void increment(View view)
    {
        quantity++;
        TextView tv=(TextView)findViewById(R.id.Text_Quantity);
        tv.setText(""+quantity);
    }
    public void  decrement(View view)
    {
        if(quantity>0)
        quantity--;
        ((TextView)findViewById(R.id.Text_Quantity)).setText(""+quantity);
    }
}
