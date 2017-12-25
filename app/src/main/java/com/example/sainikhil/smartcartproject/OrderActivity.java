package com.example.sainikhil.smartcartproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class OrderActivity extends AppCompatActivity {
    String name, price;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    DatabaseReference databaseReference;
    private TextView orderDetail;
    private TextView orderHeading;
    String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        //String id=getIntent().getStringExtra("product id").toString();
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String profile_id = user.getUid();
        mail=user.getEmail();
        orderHeading=(TextView)findViewById(R.id.orderheading);
        orderDetail = (TextView) findViewById(R.id.orderdetail);
        orderHeading.append(mail);
        databaseReference = FirebaseDatabase.getInstance().getReference().child(profile_id + " order data");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String,String> data =(Map<String,String>) dataSnapshot.getValue();
                for(Map.Entry<String,String> e:data.entrySet()){
                    orderDetail.append(e.getKey()+" : "+e.getValue()+ "\n");
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                Toast.makeText(getApplicationContext(), "Cant retrive data", Toast.LENGTH_LONG).show();

            }
        });

    }
}
