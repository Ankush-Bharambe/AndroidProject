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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity {
    private EditText username,userpassword,useremail;
    private Button regbutton;
    String email, name, password;
    private TextView tw;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        setupUIViews();
        firebaseAuth = FirebaseAuth.getInstance();
        tw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Registration.this,signin.class));
                finish();
            }
        });

        regbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //in this we neeed to create new user
             if (validate()){

                 email = useremail.getText().toString().trim();
                 password = userpassword.getText().toString().trim();
                 firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                     @Override
                     public void onComplete(@NonNull Task<AuthResult> task) {
                         if(task.isSuccessful()) {
                            sendUserData();
                             Toast.makeText(Registration.this, "Registration Succesfull", Toast.LENGTH_SHORT).show();
                            finish();
                             startActivity(new Intent(Registration.this,signin.class));
                         }
                         else {
                             Toast.makeText(Registration.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                         }

                     }

                 });



             }
            }
        });


}


        private void setupUIViews(){
            username = (EditText)findViewById(R.id.etname);
            userpassword = (EditText)findViewById(R.id.etpass);
            useremail = (EditText)findViewById(R.id.etemail);
            regbutton = (Button)findViewById(R.id.btnreg);
            tw=(TextView)findViewById(R.id.tw);

        }
    private Boolean validate(){
        Boolean result = false;

        name = username.getText().toString();
        password = userpassword.getText().toString();
        email = useremail.getText().toString();


        if(name.isEmpty() || password.isEmpty() || email.isEmpty() ){
            Toast.makeText(this, "Please enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            result = true;
        }

        return result;
    }



    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference(firebaseAuth.getUid());


        UserProfile userProfile = new UserProfile(email , name );
        myRef.setValue(userProfile);
        myRef.child("switch1").setValue(0);
        myRef.child("switch2").setValue(0);
        myRef.child("switch3").setValue(0);
        myRef.child("switch4").setValue(0);
        myRef.child("switch5").setValue(0);


    }


}