package com.example.sainikhil.smartcartproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginPage extends AppCompatActivity implements View.OnClickListener {


    //defining views
    private Button buttonSignIn;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button buttonSignUp;
    String email;

    //firebase auth object
    private FirebaseAuth firebaseAuth;

    //progress dialog
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        //creating an instance of the firebase authentication
        firebaseAuth = FirebaseAuth.getInstance();

        //if the objects getcurrentuser method is not null
        //means user is already logged in
        if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(getApplicationContext(), SignUp.class));
        }

        //initializing views
        editTextEmail = (EditText) findViewById(R.id.uname);
        editTextPassword = (EditText) findViewById(R.id.pass);
        buttonSignIn = (Button) findViewById(R.id.Button1);
        buttonSignUp  = (Button) findViewById(R.id.Button2);

        progressDialog = new ProgressDialog(this);

        //attaching click listener
        buttonSignIn.setOnClickListener(this);
        buttonSignUp.setOnClickListener(this);
    }

    //method for user login
    private void userLogin(){
        email = editTextEmail.getText().toString().trim();
        String password  = editTextPassword.getText().toString().trim();


        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Logging Please Wait...");
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful()){
                            /*if(email.equals("admin@gmail.com"))
                            {
                                startActivity(new Intent(getApplicationContext(),UserDetails.class));
                            }*/
                            startActivity(new Intent(getApplicationContext(), SmartCart.class));
                            finish();
                        }else{
                            Toast.makeText(LoginPage.this,"Wrong Email or password",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignIn){
            userLogin();
        }

        if(view == buttonSignUp){
            finish();
            startActivity(new Intent(this, SignUp.class));
        }
    }
}
