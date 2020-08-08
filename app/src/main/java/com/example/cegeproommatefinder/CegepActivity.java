package com.example.cegeproommatefinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class CegepActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cegep);
        Intent intent=getIntent();

    }
    public void facebook(View view){
        Intent facebookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/cegep.gaspesie.iles/"));
        startActivity(facebookIntent);
    }
    public void insta(View view) {
        Intent instaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/cegepgim_montreal/?hl=en"));
        startActivity(instaIntent);
    }
    public void twitter(View view) {
        Intent twitterIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/cegepduvieuxmtl?lang=en"));
        startActivity(twitterIntent);
    }
    public void internet(View view) {
        Intent internetIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cegepgim.ca/montreal/home"));
        startActivity(internetIntent);
    }
}