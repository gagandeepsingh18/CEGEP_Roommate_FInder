package com.example.cegeproommatefinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class RegisterActivity extends AppCompatActivity {

    EditText Email, Password, ConfirmPassword, Name;
    Button CreateAccount, Login;

    private FirebaseAuth firebaseAuth;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Email = findViewById(R.id.EmailAddressInput);
        Password= findViewById(R.id.PasswordInput);
        ConfirmPassword= findViewById(R.id.ConfirmPasswordInput);
        CreateAccount = findViewById(R.id.RegistrationButton);
        Login = findViewById(R.id.LoginPageButton);
        Name = findViewById(R.id.NameInput);

        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();

        CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = Email.getText().toString();
                String password = Password.getText().toString();
                String confirmpassword = ConfirmPassword.getText().toString();
                String name= Name.getText().toString();
                    if (password.equals(confirmpassword)) {

                        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                /* if (task.isSuccessful()) {
                                    firebaseAuth.getCurrentUser().sendEmailVerification();
                                    firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) { */
                                            if (task.isSuccessful()) {

                                                FirebaseUser user = firebaseAuth.getCurrentUser();
                                                String userEmail= user.getEmail();
                                                String userId= user.getUid();
                                                Log.d("Tag", userId);

                                                HashMap<Object, String> hashMap= new HashMap<>();
                                                hashMap.put("email", userEmail);
                                                hashMap.put("name", " ");
                                                hashMap.put("uid", userId);

                                                FirebaseDatabase database= FirebaseDatabase.getInstance();
                                                DatabaseReference Reference = database.getReference("Users");

                                                Reference.child(userId).setValue(hashMap).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                                        FirebaseAuth.getInstance().signOut();
                                                    }
                                                });
                                            }
                                            else {

                                                Toast.makeText(RegisterActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                                                FirebaseAuth.getInstance().signOut();
                                            }
                                        }
                                    });
                            /*    }
                            }
                        });
*/
                    } else {
                        Toast.makeText(RegisterActivity.this, "Password and Confirm Password fields do not match", Toast.LENGTH_SHORT).show();

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