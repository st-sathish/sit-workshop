package com.drawerlayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.drawerlayout.fragments.CalculatorFragment;
import com.drawerlayout.fragments.FragmentDrawer;

public class DrawerActivity extends AppCompatActivity implements FragmentDrawer.OnDrawerItemClickListener {

    FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_drawer);
        Toolbar mToolbar = findViewById(R.id.toolbar);
        drawerFragment = (FragmentDrawer) getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setOnDrawerItemClickListener(this);
    }

    @Override
    public void onDrawerItemClick(String menu, int position) {
        Fragment fragment = null;
        switch(menu) {
            case "Home":
                fragment = CalculatorFragment.newInstance("Calculator");
                break;
            case "AboutUs":
                fragment = CalculatorFragment.newInstance("Calculator");
                break;
            case "ContactUs":
                fragment = CalculatorFragment.newInstance("Calculator");
                break;
        }
        switchFragment(fragment);
    }

    public void switchFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment, fragment.getClass().getSimpleName());
        fragmentTransaction.commit();
    }
}
