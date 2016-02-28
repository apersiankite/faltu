package com.zoomcar.prateek.faltu.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.zoomcar.prateek.faltu.R;
import com.zoomcar.prateek.faltu.fragment.ZoomLaterFrgment;
import com.zoomcar.prateek.faltu.fragment.ZoomNowFragment;

/**
 * Created by Prateek on 12/09/15.
 */
public class NavingationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, TabLayout.OnTabSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private  NavigationView navigationView;
    private TabLayout mTabLayout;
    private ZoomNowFragment mFragmentZoomNow;
    private ZoomLaterFrgment mFragmentZoomLater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setOnTabSelectedListener(this);
        mTabLayout.addTab(mTabLayout.newTab().setText("ZOOM NOW"));
        mTabLayout.addTab(mTabLayout.newTab().setText("ZOOM LATER"));
        navigationView = (NavigationView) findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.inflateHeaderView(R.layout.layout_nav_header_logout);
        Menu menu = navigationView.getMenu();
        Log.d("prateek", "Menu size is " + menu.size());
        for(int i = 0;i<menu.size();i++){
            Log.d("prateek","menu item("+i+")"+menu.getItem(i).getTitle());
        }

        MenuItem menuItem = menu.add(0,11,1,"Maps");
        menuItem.setIcon(R.drawable.ic_action_place);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open,
                R.string.close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Log.d("prateek", "[NavigationItemClicked]" + menuItem.getItemId());
        if(menuItem.getItemId() == R.id.navigation_item_1){
            menuItem.setChecked(true);
            mDrawerLayout.closeDrawers();
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_navigation, menu);
        MenuItem filterMenuItem = menu.findItem(R.id.action_filter);
        MenuItemCompat.setOnActionExpandListener(filterMenuItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                Log.d("prateek", "Menu item Expanded");
                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                Log.d("prateek", "Menu item collapsed");
                return true;
            }
        });
        return true;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Log.d("prateek", "Tabl Selected : " + tab.toString() + "at position : " + tab.getPosition());
        switch (tab.getPosition()){
            case 0 :
                showZoomNow();
                break;
            case 1 :
                showZoomLater();
                break;
        }
    }

    private void showZoomNow(){
        if(mFragmentZoomNow == null){
            mFragmentZoomNow = new ZoomNowFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content, mFragmentZoomNow).commit();
    }

    private void showZoomLater(){
        if(mFragmentZoomLater == null){
            mFragmentZoomLater = new ZoomLaterFrgment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.content, mFragmentZoomLater).commit();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
