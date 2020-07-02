package com.example.cegeproommatefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText Email, Password, ConfirmPassword;
    Button CreateAccount, Login;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = findViewById(R.id.EmailAddressInput);
        Password= findViewById(R.id.PasswordInput);
        ConfirmPassword= findViewById(R.id.ConfirmPasswordInput);
        CreateAccount = findViewById(R.id.RegistrationButton);
        Login = findViewById(R.id.LoginPageButton);

        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference = firebaseDatabase.getReference("users");

        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmpassword = ConfirmPassword.getText().toString();
                if (password.equals(confirmpassword)){
                final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                        {
                            firebaseAuth.getCurrentUser().sendEmailVerification();
                            firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful())
                                    {
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                        FirebaseAuth.getInstance().signOut();
                                    }
                                    else
                                    {
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                        Toast.makeText(RegisterActivity.this,"Please complete the Email verification process before trying to Login", Toast.LENGTH_SHORT).show();
                                        FirebaseAuth.getInstance().signOut();
                                    }
                                }
                            });
                        }
                    }
                });

            }
                else
                {
                    Toast.makeText(RegisterActivity.this,"Password and Confirm Password fields do not match", Toast.LENGTH_SHORT).show();

                }
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            LoginFun();
            }
        });
    }
public void LoginFun(){
    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
    startActivity(intent);
}
}