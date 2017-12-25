package com.example.sainikhil.smartcartproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class CartActivity extends AppCompatActivity {
    TextView t1, t2;
    Button placeOrder;
    String name, price;
    //FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        t1 = (TextView) findViewById(R.id.carttext);
        name = getIntent().getExtras().getString("name");
        t1.setText(name);
        t2 = (TextView) findViewById(R.id.cartprice);
        price = getIntent().getExtras().getString("price");
        t2.setText(price);
        placeOrder = (Button) findViewById(R.id.place_order);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = FirebaseAuth.getInstance().getCurrentUser();
                String profile_id;
                if (user != null) {
                    profile_id = user.getUid();
                } else {
                    profile_id = "123";
                }
                databaseReference = FirebaseDatabase.getInstance().getReference().child(profile_id + " order data");
                HashMap<String, String> dataMap = new HashMap<String, String>();
                dataMap.put("Product Name", name);
                dataMap.put("Product Price", price);
                databaseReference.setValue(dataMap);
                Toast.makeText(CartActivity.this, "Order successfully placed", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getApplicationContext(), OrderActivity.class);
                startActivity(i);

            }
        });

    }


}
