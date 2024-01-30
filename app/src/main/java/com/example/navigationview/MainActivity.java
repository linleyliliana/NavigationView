package com.example.navigationview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;


import android.os.Bundle;
import android.view.MenuItem;


import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;
        int itemId = item.getItemId();
        if (itemId == R.id.menu_seccion_1) {
            fragment = new FragmentHistorias();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_2) {
            fragment = new FragmentGrupos();
            fragmentTransaction = true;
        } else if (itemId == R.id.menu_seccion_3) {
            fragment = new FragmentContactos();
            fragmentTransaction = true;
        }
        else if (itemId == R.id.menu_seccion_4) {
            fragment = new fragment_llamadas();
            fragmentTransaction = true;
        }
        else if (itemId == R.id.menu_seccion_5) {
            fragment = new Fragment_Personas();
            fragmentTransaction = true;
        }
        else if (itemId == R.id.menu_seccion_6) {
            fragment = new Fragment_Mensajes();
            fragmentTransaction = true;
        }
        else if (itemId == R.id.menu_seccion_7) {
            fragment = new Fragment_ajustes();
            fragmentTransaction = true;
        }
        else if (itemId == R.id.menu_seccion_8) {
            fragment = new Fragment_invitar();
            fragmentTransaction = true;
        }
        else if (itemId == R.id.menu_seccion_9) {
            fragment = new Fragment_telegram();
            fragmentTransaction = true;
        }

        if(fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();
            item.setChecked(true);
            getSupportActionBar().setTitle(item.getTitle());
        }
        drawerLayout.closeDrawers();
        return true;
    }
}
