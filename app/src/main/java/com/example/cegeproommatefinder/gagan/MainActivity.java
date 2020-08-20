
package com.example.cegeproommatefinder.gagan;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.cegeproommatefinder.FaqActivity;
import com.example.cegeproommatefinder.R;
import com.example.cegeproommatefinder.Schedule;
import com.example.cegeproommatefinder.UserChat;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
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

  /*      if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.NavigationMainFragment, new MainFragment()).commit();
            navigationView.setCheckedItem(R.id.menu_home);
        } */
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
        Toast.makeText(this,""+menuItem.getItemId(), Toast.LENGTH_LONG).show();
        switch (menuItem.getItemId()){
            case R.id.menu_home:
                Fragment fragment = new MainFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.NavigationMainFragment, fragment).addToBackStack(null).commit();
                break;
            case R.id.menu_meeting:
                Intent intent = new Intent(this, Schedule.class);
                startActivity(intent);
                break;
            case R.id.menu_chat:
                Intent intent2 = new Intent(this, UserChat.class);
                startActivity(intent2);
                break;
            case R.id.menu_faq:
                Intent intent3 = new Intent(this, FaqActivity.class);
                startActivity(intent3);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}