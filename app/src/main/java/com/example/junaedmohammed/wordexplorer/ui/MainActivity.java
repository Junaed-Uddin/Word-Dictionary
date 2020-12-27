package com.example.junaedmohammed.wordexplorer.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.junaedmohammed.wordexplorer.GamesFragment;
import com.example.junaedmohammed.wordexplorer.HistoryFragment;
import com.example.junaedmohammed.wordexplorer.HomeFragment;
import com.example.junaedmohammed.wordexplorer.R;
import com.example.junaedmohammed.wordexplorer.SettingsFragment;
import com.example.junaedmohammed.wordexplorer.FavouriteFragment;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle mToggle;
    NavigationView navigationView;
    android.support.v4.app.FragmentTransaction fragmentTransaction;

    EditText editText;
    Button search, pronunciation, favourite, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.title_activity_open, R.string.title_activity_close);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation_bar); // you didn't even give any id to the navigation view, that's why you couldn't find it
        navigationView.setNavigationItemSelectedListener(this);
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, new HomeFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Home");

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.Home) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new HomeFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Home");
            item.setChecked(true);
            drawerLayout.closeDrawers();

            View view = this.getCurrentFocus();
            if (view != null){

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            return true;

        }

        if (item.getItemId() == R.id.favorite) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new FavouriteFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Favorite");
            item.setChecked(true);
            drawerLayout.closeDrawers();

            View view = this.getCurrentFocus();
            if (view != null){

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }



            return true;

        }

        if (item.getItemId() == R.id.settings) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new SettingsFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Settings");
            item.setChecked(true);
            drawerLayout.closeDrawers();

            View view = this.getCurrentFocus();
            if (view != null){

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            return true;
        }
        if (item.getItemId() == R.id.Games) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new GamesFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Games");
            item.setChecked(true);
            drawerLayout.closeDrawers();

            View view = this.getCurrentFocus();
            if (view != null){

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            return true;
        }
        if (item.getItemId() == R.id.history) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new HistoryFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("History");
            item.setChecked(true);
            drawerLayout.closeDrawers();

            View view = this.getCurrentFocus();
            if (view != null){

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }

            return true;
        }

        if (mToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onResume() {
        super.onResume();

        navigationView.getMenu().getItem(0).setChecked(true);
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Do you want to exit dictionary ?");
        builder.setTitle("Exit");
        builder.setIcon(R.drawable.alerticon);
        builder.setCancelable(true);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        View view = this.getCurrentFocus();
        if (view != null){

            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        if (id == R.id.Home) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new HomeFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Home");
            item.setChecked(true);
            drawerLayout.closeDrawers();


            return true;
        }


        if (id == R.id.favorite) {

            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_layout, new FavouriteFragment());
            fragmentTransaction.commit();
            getSupportActionBar().setTitle("Favorite");
            item.setChecked(true);
            drawerLayout.closeDrawers();


            return true;

        }

        if (id == R.id.settings) {

                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new SettingsFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Settings");
                item.setChecked(true);
                drawerLayout.closeDrawers();

                return true;

            }
            if (id == R.id.Games) {

                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new GamesFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("Games");
                item.setChecked(true);
                drawerLayout.closeDrawers();


                return true;
            }
            if (id == R.id.history) {

                fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new HistoryFragment());
                fragmentTransaction.commit();
                getSupportActionBar().setTitle("History");
                item.setChecked(true);
                drawerLayout.closeDrawers();


                return true;

            }
            return false;
        }

                }
