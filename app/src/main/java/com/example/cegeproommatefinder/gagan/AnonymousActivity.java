package com.example.cegeproommatefinder.gagan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.cegeproommatefinder.FaqActivity;
import com.example.cegeproommatefinder.R;
import com.example.cegeproommatefinder.Schedule;
import com.example.cegeproommatefinder.UserChat;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

public class AnonymousActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawerLayout;

    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    Toolbar toolbar = findViewById(R.id.toolBar);
    setSupportActionBar(toolbar);

    drawerLayout= findViewById(R.id.MainDrawerLayout);


    NavigationView navigationView= findViewById(R.id.navigationView);
    navigationView.bringToFront();
    navigationView.setNavigationItemSelectedListener(this);

    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,R.string.navigation_drawer_close);


    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();

    }

        @Override
        public void onBackPressed() {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.closeDrawer(GravityCompat.START);
            }
            else {
                super.onBackPressed();
            }
        }


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

            switch (menuItem.getItemId()){
                case R.id.menu_home:
                    Intent intent4 = new Intent(this, LoginActivity.class);
                    startActivity(intent4);
                    break;
                case R.id.menu_meeting:
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    break;
                case R.id.menu_chat:
                    Intent intent2 = new Intent(this, LoginActivity.class);
                    startActivity(intent2);
                    break;
                case R.id.menu_faq:
                    Intent intent3 = new Intent(this, LoginActivity.class);
                    startActivity(intent3);
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
}