package com.example.domestic_animal_tracking;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.domestic_animal_tracking.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new HomeFragment());
        binding.bottomNavigationView.setBackground(null);
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//            switch (item.getItemId()) {
//                case R.id.home:
//                    replaceFragment(new HomeFragment());
//                    break;
//                case R.id.alarm:
//                    replaceFragment(new AlarmFragment());
//                    break;
//                case R.id.setting:
//                    replaceFragment(new SettingFragment());
//                    break;
//                case R.id.account:
//                    replaceFragment(new AccountFragment());
//                    break;
//            }
            if (item.getItemId()==R.id.home){
                replaceFragment(new HomeFragment());
            } else if (item.getItemId()==R.id.alarm) {
                replaceFragment(new AlarmFragment());
            }
            else if (item.getItemId()==R.id.setting) {
                replaceFragment(new SettingFragment());
            }
            else if (item.getItemId()==R.id.account) {
                replaceFragment(new AccountFragment());
            }

            return true;
        });
    }


    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}