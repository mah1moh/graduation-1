package com.example.graduationproject;

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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {
    private FirebaseAuth mAuth=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {

            EditText loginemail,loginpaswoord;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final Button login=findViewById(R.id.btn_login);
        mAuth=FirebaseAuth.getInstance();
        loginemail=findViewById(R.id.usernamelogin);
        loginpaswoord=findViewById(R.id.passwordlogon);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=loginemail.getText().toString();
                String pass=loginpaswoord.getText().toString();
                if (email!=null&pass!=null)
                {
                    mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()){startActivity(new Intent(getApplicationContext(),nave.class));}
                           else{Toast.makeText(getApplicationContext(),  task.getException().toString(),Toast.LENGTH_LONG).show();}
                        }
                    });
                }
            }
        });
        TextView reg=findViewById(R.id.regist_textView);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,regestration.class);
                startActivity(intent);

            }
        });

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }


}
