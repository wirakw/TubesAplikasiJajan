package com.example.nadhiravirly.tubesaplikasijajan.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.reza.tourdepvjmine.R;
import com.miguelcatalan.materialsearchview.MaterialSearchView;


public class MainActivity extends AppCompatActivity {
    MaterialSearchView searchView;
    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);


        list = new String[]{"Clipcodes", "Android Tutorials", "Youtube Clipcodes Tutorials", "SearchView Clicodes", "Android Clipcodes", "Tutorials Clipcodes"};

        searchView = (MaterialSearchView)findViewById(R.id.search_view);
        searchView.closeSearch();
        searchView.setSuggestions(list);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Here Create your filtering
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //You can make change realtime if you typing here
                //See my tutorials for filtering with ListView
                return false;
            }
        });

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("Tour DePVJ");

        CardView cardAlamClick = (CardView) findViewById(R.id.card_alam_click);
        CardView cardKulinerClick = (CardView) findViewById(R.id.card_kuliner_click);
        CardView cardKolamClick = (CardView) findViewById(R.id.card_kolam_click);
        CardView cardTamanClick = (CardView) findViewById(R.id.card_taman_click);
        CardView cardSeniClick = (CardView) findViewById(R.id.card_seni_click);
        CardView cardSejarahClick = (CardView) findViewById(R.id.card_sejarah_click);

        cardAlamClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", 1);
                startActivity(i);
            }
        });

        cardKulinerClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", 2);
                startActivity(i);
            }
        });

        cardKolamClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", 3);
                startActivity(i);
            }
        });

        cardTamanClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", 4);
                startActivity(i);
            }
        });

        cardSeniClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", 5);
                startActivity(i);
            }
        });

        cardSejarahClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ListWisataActivity.class);
                i.putExtra("kategori", 6);
                startActivity(i);
            }
        });


    }
/*    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    } */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.cari);
        searchView.setMenuItem(item);

        return true;
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.language :
                //Intent i = new Intent(MainActivity.this, com.example.reza.tourdepvjmine.admin.MainActivity.class);
                //startActivity(i);
                return true;
            case R.id.about :

                return true;
            case R.id.exit :

                return true;
        }
        return super.onOptionsItemSelected(item);
    } */
}