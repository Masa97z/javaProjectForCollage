package com.masa.minisilm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.masa.minisilm.Ui.AddFragment;
import com.masa.minisilm.Ui.HomeFragment;
import com.masa.minisilm.Ui.ListFragment;
import com.masa.minisilm.Ui.ProfileFragment;
import com.masa.minisilm.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private BottomNavigationView bottomNavigationView;
    Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        bottomNavigationView = binding.navigationView;
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemSelectedListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                new HomeFragment(context)).commit();

    }
    @SuppressLint("NonConstantResourceId")
    private BottomNavigationView.OnNavigationItemSelectedListener navItemSelectedListener =
            item -> {
                Fragment selectedFragment = null;

                // Determine which fragment to show based on the selected menu item
                int itemId = item.getItemId();
                if (itemId == R.id.home_btn_nav) {
                    selectedFragment = new HomeFragment(context);
                } else if (itemId == R.id.list_btn_nav) {
                    selectedFragment = new ListFragment(context);
                } else if (itemId == R.id.add_btn_nav) {
                    selectedFragment = new AddFragment(context);
                } else {
                    selectedFragment = new ProfileFragment();
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, selectedFragment)
                        .commit();

                return true;
            };
}