package fr.yrisch.astrobay.controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fr.yrisch.astrobay.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    private DrawerLayout drawer;

    private Fragment fragmentmeteo;
    private Fragment fragmentevent;
    private Fragment fragmentmap;
    private Fragment fragmentremote;

    private static final int FRAGMENT_METEO=0;
    private static final int FRAGMENT_EVENT=1;
    private static final int FRAGMENT_MAP=2;
    private static final int FRAGMENT_REMOTE=3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        this.showFirstFragment();
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.Remote) {
            this.showFragment(FRAGMENT_REMOTE);
        } else if (id == R.id.Map) {
            this.showFragment(FRAGMENT_MAP);
        } else if (id == R.id.Nevent) {
            this.showFragment(FRAGMENT_EVENT);
        } else if (id == R.id.weather) {
            this.showFragment(FRAGMENT_METEO);
        }

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showFragment(int fragmentIdentifier){

        switch (fragmentIdentifier){

            case FRAGMENT_EVENT :

                this.showEventFragment();

                break;

            case FRAGMENT_MAP:

                this.showmapFragment();

                break;

            case FRAGMENT_REMOTE:

                this.showremoteFragment();

                break;
            case FRAGMENT_METEO:

                this.showMeteoFragment();

            default:

                break;

        }

    }


    private void showMeteoFragment(){
        if(this.fragmentmeteo==null)this.fragmentmeteo = new AstroMeteo();
        this.startTransactionFragment(this.fragmentmeteo);
    }

    private void showEventFragment(){
        if(this.fragmentevent==null)this.fragmentevent = new NightEvent();
        this.startTransactionFragment(this.fragmentevent);
    }
    private void showremoteFragment(){
        if(this.fragmentremote==null)this.fragmentremote = new Remote();
        this.startTransactionFragment(this.fragmentremote);
    }
    private void showmapFragment(){
        if(this.fragmentmap==null)this.fragmentmap = new StelliMap();
        this.startTransactionFragment(this.fragmentmap);
    }

    private void startTransactionFragment(Fragment fragment){

        if (!fragment.isVisible()){

            getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();

        }

    }

    private void showFirstFragment(){

        Fragment visibleFragment = getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (visibleFragment == null){

            // 1.1 - Show News Fragment

            this.showFragment(FRAGMENT_REMOTE);

            // 1.2 - Mark as selected the menu item corresponding to NewsFragment

            this.navigationView.getMenu().getItem(0).setChecked(true);

        }

    }
}
