package com.example.domestic_animal_tracking;

import android.annotation.SuppressLint;

import android.os.Bundle;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.domestic_animal_tracking.databinding.ActivityMainBinding;
import com.google.android.material.appbar.MaterialToolbar;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MaterialToolbar materialToolbar;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        materialToolbar = findViewById(R.id.materialToolbar);

        loadFragment(new ManageDeviceFragment());
        binding.materialToolbar.setBackground(null);
        binding.materialToolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId()==R.id.manageDevice){
                loadFragment(new ManageDeviceFragment());
            } else if (item.getItemId()==R.id.userManual) {
                loadFragment(new ManageDeviceFragment());
            }else if (item.getItemId()==R.id.tAndc) {
                loadFragment(new ManageDeviceFragment());
            }
            return true;
        });

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId==R.id.home){
                replaceFragment(new HomeFragment());
            } else if (itemId==R.id.alarm) {
                replaceFragment(new AlarmFragment());
            }
            else if (itemId==R.id.setting) {
                replaceFragment(new SettingFragment());
            }
            else if (itemId==R.id.account) {
                replaceFragment(new AccountFragment());
            }
            return true;
        });
    }

    private void loadFragment(ManageDeviceFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.appBarLayout, fragment);
        fragmentTransaction.commit();
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }


}