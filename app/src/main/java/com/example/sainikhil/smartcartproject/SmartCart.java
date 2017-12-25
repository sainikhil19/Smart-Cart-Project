package com.example.sainikhil.smartcartproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.widget.SearchView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SmartCart extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView gv;

    SearchView sv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_cart);
        String name = getIntent().getStringExtra("username");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gv = (GridView) findViewById(R.id.GV);
        sv = (SearchView) findViewById(R.id.sv);
        ArrayList<ImageClick> data = generateSampleData();
        final GridAdapter gridadapter = new GridAdapter(this, data);
        gv.setAdapter(gridadapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                //Toast.makeText(getApplicationContext(),query,Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                gridadapter.getFilter().filter(newText);
                return false;
            }
        });

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(SmartCart.this);
        builder.setTitle("Exit")
                .setMessage("Are you sure you want to Logout?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SmartCart.super.onBackPressed();
                    }
                }).setNegativeButton("No", null);
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
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
        if (id == R.id.about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        } else if (id == R.id.cart) {
            Intent i = new Intent(this, CartActivity.class);
            i.putExtra("name", "No item is selected");
            i.putExtra("price", "$0");
            startActivity(i);
            return true;
        } else if (id == R.id.logout) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        //Toast.makeText(SmartCart.this, item.getTitle() + " is selected", Toast.LENGTH_SHORT).show();

        if (id == R.id.nav_graduate) {
            Intent i = new Intent(SmartCart.this, CapActivity.class);
            startActivity(i);
            //Toast.makeText(SmartCart.this, "it's selected", Toast.LENGTH_SHORT).show();
            // Handle the camera action
        }
        if (id == R.id.nav_guitar) {
            //Toast.makeText(SmartCart.this, "it's selected", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SmartCart.this, GuitarActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_novel) {
            //Toast.makeText(SmartCart.this, "it's selected", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SmartCart.this, NovelActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_puzzle) {
            Intent i = new Intent(SmartCart.this, PuzzleActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_pens) {
            //Toast.makeText(SmartCart.this, "it's selected", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SmartCart.this, PenActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_shirts) {
            //Toast.makeText(SmartCart.this, "it's selected", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SmartCart.this, ShirtActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_spinner) {
            //Toast.makeText(SmartCart.this, "it's selected", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(SmartCart.this, FidgetActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_stationary) {
            Intent i = new Intent(SmartCart.this, StationaryActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_settings) {


        } else if (id == R.id.nav_cart) {
            Intent i = new Intent(SmartCart.this, CartActivity.class);
            i.putExtra("name", "No item is selected");
            i.putExtra("price", "$0");
            startActivity(i);

        } else if (id == R.id.nav_about) {
            Intent i = new Intent(SmartCart.this, AboutActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_logout) {
            onBackPressed();

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private ArrayList<ImageClick> generateSampleData() {
        ArrayList<ImageClick> images = new ArrayList<ImageClick>();
        ImageClick i = new ImageClick();
        i.setImageName("Graduate cap");
        i.setImageid(R.drawable.graduate);
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.guitar);
        i.setImageName("Guitar");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.novels);
        i.setImageName("Novel");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.shirts);
        i.setImageName("Shirts for men");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.puzzle1);
        i.setImageName("Puzzle");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.spinner);
        i.setImageName("Spinner");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.penset);
        i.setImageName("Pens");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.stationary);
        i.setImageName("Stationary Items");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.puzzle1);
        i.setImageName("Puzzle");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.spinner);
        i.setImageName("Spinner");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.penset);
        i.setImageName("Pens");
        images.add(i);
        i = new ImageClick();
        i.setImageid(R.drawable.stationary);
        i.setImageName("Stationary Items");
        images.add(i);
        return images;
    }

}
