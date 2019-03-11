package com.example.parsaniahardik.kotlindrawerbasic

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.codephillip.app.busticket.Utils.screenNames

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    protected fun onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.setDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        //populate the first default fragment
        val fragment = SelectRouteFragment.newInstance()
        getSupportActionBar().setTitle(screenNames[0])
        val fragmentTransaction = getSupportFragmentManager().beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }

    fun onBackPressed() {
        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu)
        return true
    }

    fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up orderButton, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.getItemId()


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        Log.d("Navigation bar", "onNavigationItemSelected: $id")
        val fragment: Fragment

        //todo change id names
        if (id == R.id.nav_camera) {
            fragment = SelectRouteFragment.newInstance()
            getSupportActionBar().setTitle(screenNames[0])
        } else if (id == R.id.nav_gallery) {
            fragment = OrdersFragment.newInstance()
            getSupportActionBar().setTitle(screenNames[1])
        } else if (id == R.id.nav_slideshow) {
            fragment = HistoryFragment.newInstance()
            getSupportActionBar().setTitle(screenNames[2])
        } else if (id == R.id.nav_manage) {
            fragment = ProfileFragment.newInstance()
            getSupportActionBar().setTitle(screenNames[3])
        } else {
            return true
        }
        val fragmentTransaction = getSupportFragmentManager().beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()

        val drawer = findViewById(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    companion object {

        private val TAG = MainActivity::class.java!!.getSimpleName()
    }
}
