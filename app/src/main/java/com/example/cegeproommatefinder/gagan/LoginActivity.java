package com.example.cegeproommatefinder.gagan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cegeproommatefinder.R;
import com.example.cegeproommatefinder.Schedule;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {
    EditText Email, Password;
    Button Login,Register;
    TextView skip;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.EmailAddressInput);
        Password= findViewById(R.id.PasswordInput);
        Login = findViewById(R.id.LoginButton);
        skip = findViewById(R.id.SkipLabel);
        Register = findViewById(R.id.RegistrationPageButton);

        firebaseAuth = FirebaseAuth.getInstance();
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, AnonymousActivity.class);
                startActivity(intent);
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Email.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"Please enter your Email Address", Toast.LENGTH_SHORT).show();
                }
                else if(Password.getText().toString().isEmpty())
                {
                    Toast.makeText(LoginActivity.this,"Please enter your Password", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    LoginValidation(Email.getText().toString(),Password.getText().toString());
                }
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RegisterFun();
            }
        });
    }
    private void LoginValidation(String email,String pwd)
    {
        firebaseAuth.signInWithEmailAndPassword(email,pwd).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"Please enter correct Email & Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void RegisterFun(){
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

}