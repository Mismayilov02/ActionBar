package com.example.sebnem.actionbar;

import static com.example.sebnem.actionbar.R.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Fragment settingFragment  , aboutFragment, privancyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

         settingFragment = new Settings();
         aboutFragment = new AboutMe();
         privancyFragment = new Privancy();
        setFragment(settingFragment);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == id.about){
            setFragment(aboutFragment);
        }else if(item.getItemId() == id.privacy){
            setFragment(privancyFragment);
        }else {
            setFragment(settingFragment);
        }

        return super.onOptionsItemSelected(item);
    }

   private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(id.framelayout, fragment);
        fragmentTransaction.commit();
    }
}