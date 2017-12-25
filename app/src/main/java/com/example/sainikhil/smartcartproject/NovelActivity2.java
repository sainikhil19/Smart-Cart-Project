package com.example.sainikhil.smartcartproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NovelActivity2 extends AppCompatActivity {
    Button add_fidget;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel2);
        add_fidget=(Button)findViewById(R.id.add_fidget_novel2);
        add_fidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NovelActivity2.this,"Added to cart ...",Toast.LENGTH_LONG).show();
                Intent i=new Intent(NovelActivity2.this,CartActivity.class);
                TextView tv=(TextView)findViewById(R.id.novel_heading2);
                TextView tv1=(TextView)findViewById(R.id.price);
                i.putExtra("name",tv.getText().toString());
                i.putExtra("price",tv1.getText().toString());
                startActivity(i);
            }
        });
    }
}
