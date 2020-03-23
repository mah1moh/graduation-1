package com.example.graduationproject;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class regestration extends AppCompatActivity {
  FirebaseAuth mAuth=null;
    EditText email,password,confirmpass;
    Button signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regestration2);
        try {
            mAuth = FirebaseAuth.getInstance();
//            if (mAuth.getCurrentUser()==null)
//            {
//                Intent intent=new Intent(getApplicationContext(),login.class);
//                startActivity(intent);
//            }


        email=findViewById(R.id.email);
        password=findViewById(R.id.password1);
        confirmpass=findViewById(R.id.password2);
        signup=findViewById(R.id.Button_SignUp);
            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   String passs=confirmpass.getText().toString();
                    String emaail=email.getText().toString();
                    String pass=password.getText().toString();
                    if (emaail!=null&pass!=null) {


                            mAuth.createUserWithEmailAndPassword(emaail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                 if (task.isSuccessful()){ startActivity(new Intent(getBaseContext(),login.class));}
                                 else {Toast.makeText(getApplicationContext(),task.getException().toString(),Toast.LENGTH_LONG).show();}
                                }
                            });




                    }else {Toast.makeText(getApplicationContext(),"insert email & password",Toast.LENGTH_LONG).show();}


                    }

            });

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

}
