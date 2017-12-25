package com.example.sainikhil.smartcartproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CapActivity extends AppCompatActivity {
    Button add_cart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap);
        add_cart=(Button)findViewById(R.id.add_cap);
        add_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CapActivity.this,"Added to Cart",Toast.LENGTH_SHORT).show();
                Intent i=new Intent(CapActivity.this,CartActivity.class);
                TextView tv=(TextView)findViewById(R.id.cap_title);
                TextView tv1=(TextView)findViewById(R.id.price);
                i.putExtra("name",tv.getText().toString());
                i.putExtra("price",tv1.getText().toString());
                startActivity(i);
            }
        });
    }
}
