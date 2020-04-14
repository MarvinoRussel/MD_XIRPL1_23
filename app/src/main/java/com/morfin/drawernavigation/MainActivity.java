package com.morfin.drawernavigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_for_fragment, new HomeFragment())
                .commit();
        getSupportActionBar().setTitle("Comany Profiler Bar");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if (id == R.id.action_call){
            Intent telepon = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:0895337321545"));
            startActivity(telepon);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout_for_fragment, new HomeFragment())
                    .commit();
            getSupportActionBar().setTitle("Comany Profiler Bar");
        } else if (id == R.id.nav_gallery) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout_for_fragment, new GalleryFragment())
                    .commit();
            getSupportActionBar().setTitle("Galeri");
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_web) {
            Intent move = new Intent(MainActivity.this, WebActivity.class);
            startActivity(move);
        } else if (id == R.id.nav_share) {
            Intent sher = new Intent(Intent.ACTION_SEND);
            sher.setType("text/plain");
            sher.putExtra(Intent.EXTRA_TEXT,"Is this what you wanted for?");
            startActivity(Intent.createChooser(sher, "Send to MOONAFIC"));
        } else if (id == R.id.nav_send) {
            Intent mess = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:0895337321545"));
            mess.putExtra("sms_body", "Is math related to science?");
            startActivity(mess);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
