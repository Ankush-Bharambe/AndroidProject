package com.example.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
  private FirebaseAuth firebaseAuth;

   private  Button logout,btn1;
    Button n_1 ;
    Button f_1 ;
    Button n_2 , f_2;
    Button n_3 , f_3;
    Button n_4 , f_4;
    Button n_5 , f_5;

    static int st1;
    static int st2;
    static int st3;
    static int st4;
    static int st5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       /*
       Button btn1 =findViewById(R.id.btn1);
       btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String firebaseAuth1= FirebaseAuth.getInstance().getUid();


                String key = firebaseAuth1;
                System.out.println(key);


                 DatabaseReference reference =FirebaseDatabase.getInstance().getReference(key).child("btn");
                reference.setValue(1);
            }
        });*/

        //start activity
         n_1 =findViewById(R.id.n1);
         f_1 =findViewById(R.id.f1);

         n_2 =findViewById(R.id.n2);
        f_2 =findViewById(R.id.f2);

         n_3 =findViewById(R.id.n3);
        f_3 =findViewById(R.id.f3);

         n_4 =findViewById(R.id.n4);
         f_4 =findViewById(R.id.f4);

         n_5 =findViewById(R.id.n5);
         f_5 =findViewById(R.id.f5);


        //closing color enable
        //setting the buttons
        n_1.setOnClickListener(this);
        f_1.setOnClickListener(this);

        n_2.setOnClickListener(this);
        f_2.setOnClickListener(this);

        n_3.setOnClickListener(this);
        f_3.setOnClickListener(this);

        n_4.setOnClickListener(this);
        f_4.setOnClickListener(this);

        n_5.setOnClickListener(this);
        f_5.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String key = FirebaseAuth.getInstance().getUid();
        System.out.println(key);
        DatabaseReference reference =FirebaseDatabase.getInstance().getReference(key);







       //set st1
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                st1 =Integer.parseInt( snapshot.child("switch1").getValue().toString());
                st2 =Integer.parseInt( snapshot.child("switch2").getValue().toString());
                st3 =Integer.parseInt( snapshot.child("switch3").getValue().toString());
                st4 =Integer.parseInt( snapshot.child("switch4").getValue().toString());
                st5 =Integer.parseInt( snapshot.child("switch5").getValue().toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        

        switch (v.getId()){
            case R.id.n1:

                if(st1==1){
                    n_1.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_1.setBackgroundColor(Color.parseColor("#ff471a"));
                    Toast.makeText(this,"switch 1 is Already On",Toast.LENGTH_SHORT).show();

                }

                if(st1==0){
                    reference.child("switch1").setValue(1);

                    n_1.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_1.setBackgroundColor(Color.parseColor("#ff471a"));

                    Toast.makeText(this,"switch 1 is On",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.f1:


                if(st1==0){
                    n_1.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_1.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this,"switch 1 is Already OFF",Toast.LENGTH_SHORT).show();

                }

                if (st1==1) {
                    reference.child("switch1").setValue(0);
                    n_1.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_1.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this, "switch 1 is Off", Toast.LENGTH_SHORT).show();
                }



                break;
            case R.id.n2:
                if(st2==1){
                    n_2.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_2.setBackgroundColor(Color.parseColor("#ff471a"));
                    Toast.makeText(this,"switch 2 is Already On",Toast.LENGTH_SHORT).show();

                }

                if(st2==0){
                    reference.child("switch2").setValue(1);

                    n_2.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_2.setBackgroundColor(Color.parseColor("#ff471a"));

                    Toast.makeText(this,"switch 2 is On",Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.f2:
                if(st2==0){
                    n_2.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_2.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this,"switch 2 is Already OFF",Toast.LENGTH_SHORT).show();

                }

                if (st2==1) {
                    reference.child("switch2").setValue(0);
                    n_2.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_2.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this, "switch 2 is Off", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.n3:
                if(st3==1){
                    n_3.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_3.setBackgroundColor(Color.parseColor("#ff471a"));
                    Toast.makeText(this,"switch 3 is Already On",Toast.LENGTH_SHORT).show();

                }

                if(st3==0){
                    reference.child("switch3").setValue(1);

                    n_3.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_3.setBackgroundColor(Color.parseColor("#ff471a"));

                    Toast.makeText(this,"switch 3 is On",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.f3:
                if(st3==0){
                    n_3.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_3.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this,"switch 3 is Already OFF",Toast.LENGTH_SHORT).show();

                }

                if (st3==1) {
                    reference.child("switch3").setValue(0);
                    n_3.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_3.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this, "switch 3 is Off", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.n4:
                if(st4==1){
                    n_4.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_4.setBackgroundColor(Color.parseColor("#ff471a"));
                    Toast.makeText(this,"switch 4 is Already On",Toast.LENGTH_SHORT).show();

                }

                if(st4==0){
                    reference.child("switch4").setValue(1);

                    n_4.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_4.setBackgroundColor(Color.parseColor("#ff471a"));

                    Toast.makeText(this,"switch 4 is On",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.f4:
                if(st4==0){
                    n_4.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_4.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this,"switch 4 is Already OFF",Toast.LENGTH_SHORT).show();

                }

                if (st4==1) {
                    reference.child("switch4").setValue(0);
                    n_4.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_4.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this, "switch 4 is Off", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.n5:
                if(st5==1){
                    n_5.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_5.setBackgroundColor(Color.parseColor("#ff471a"));
                    Toast.makeText(this,"switch 5 is Already On",Toast.LENGTH_SHORT).show();

                }

                if(st5==0){
                    reference.child("switch5").setValue(1);

                    n_5.setBackgroundColor(Color.parseColor("#4B73E600"));
                    f_5.setBackgroundColor(Color.parseColor("#ff471a"));

                    Toast.makeText(this,"switch 5 is On",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.f5:
                if(st5==0){
                    n_5.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_5.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this,"switch 5 is Already OFF",Toast.LENGTH_SHORT).show();

                }

                if (st5==1) {
                    reference.child("switch5").setValue(0);
                    n_5.setBackgroundColor(Color.parseColor("#80ff00"));
                    f_5.setBackgroundColor(Color.parseColor("#54FF3300"));
                    Toast.makeText(this, "switch 5 is Off", Toast.LENGTH_SHORT).show();
                }

                break;
        }



    }//oncreate close

    public void logout(View view) {
        firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MainActivity.this,signin.class));
        Toast.makeText(MainActivity.this, "Log Out Successfully", Toast.LENGTH_SHORT).show();

    }
}