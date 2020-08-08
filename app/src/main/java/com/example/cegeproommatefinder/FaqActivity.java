package com.example.cegeproommatefinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FaqActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faq);

    }
    public void AskMe(View view){
        Intent AskMeIntent=new Intent(this,ComplaintActivity.class);
        startActivity(AskMeIntent);
    }
    public void Cegep(View view){
        Intent CegepIntent=new Intent(this,CegepActivity.class);
        startActivity(CegepIntent);
    }

}