package com.example.homeworktask2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Fragment foodRecycle = new FoodRecyclerFragment();
        final Fragment orderRecycle = new OrderFragment();
        swapFragment(foodRecycle);

        bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem){
                if (menuItem.getItemId() == R.id.viewOrders){
                    swapFragment(orderRecycle);
                }
                else if (menuItem.getItemId() == R.id.foodPage){
                    swapFragment(foodRecycle);
                }
                return true;
            }
        });
    }

    private void swapFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentSlot, fragment);
        fragmentTransaction.commit();
    }

}
