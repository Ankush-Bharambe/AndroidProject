package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class signin extends AppCompatActivity {
   private TextView user_reg;
   private EditText email,pass;
   private Button login;
   private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        // taking instance of FirebaseAuth
        mAuth = FirebaseAuth.getInstance();

        user_reg =(TextView)findViewById(R.id.tvregister);
        email = findViewById(R.id.etemail);
        pass= findViewById(R.id.etpass);
        login = findViewById(R.id.btnlogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(validate())
                loginUserAccount();
            }
        });
        user_reg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(signin.this,Registration.class));
               finish();
           }
       });
    }
//validate
    private Boolean validate(){
        Boolean result = false;
        String pass1;
        String email1;


        pass1 = pass.getText().toString();
        email1 = email.getText().toString();


        if(pass1.isEmpty()  || email1.isEmpty() ){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }
//end validate
    private void loginUserAccount()
    {
        // Take the value of two edit texts in Strings
        String email1, password;
        email1 = email.getText().toString();
        password = pass.getText().toString();

        mAuth.signInWithEmailAndPassword(email1,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Login successful!!", Toast.LENGTH_LONG).show();
                    Intent intent
                            = new Intent(signin.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {

                    // sign-in failed
                    Toast.makeText(getApplicationContext(), "Login failed!!", Toast.LENGTH_LONG).show();


                }

            }
        });
    }
    }