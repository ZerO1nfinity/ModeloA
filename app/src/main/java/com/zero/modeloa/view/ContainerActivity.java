package com.zero.modeloa.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.zero.modeloa.R;
import com.zero.modeloa.view.fragment.HomeFragment;
import com.zero.modeloa.view.fragment.ProfileFragment;
import com.zero.modeloa.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomBar);


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.tab_home:
                        addFragment(new HomeFragment());
                        break;
                    case R.id.tab_profile:
                        addFragment(new ProfileFragment());
                        break;
                    case R.id.tab_search:
                        addFragment(new SearchFragment());
                        break;
                }
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.tab_home);
    }

    private void addFragment(Fragment fragment){
        if (fragment != null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    //.addToBackStack(null)
                    .commit();
        }
    }

}
