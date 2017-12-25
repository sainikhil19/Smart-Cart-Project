package com.example.sainikhil.smartcartproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.SearchView;

import java.util.ArrayList;

public class NovelActivity extends AppCompatActivity {
    GridView gv;
    SearchView sv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novel);
        gv = (GridView) findViewById(R.id.gridview);
        sv = (SearchView) findViewById(R.id.searchview);
        ArrayList<ImageClick> getdata = generateSample();
        final NovelGridAdapter novelGridAdapter = new NovelGridAdapter(this, getdata);
        gv.setAdapter(novelGridAdapter);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                novelGridAdapter.getNovelFilter().filter(newText);
                return false;
            }
        });
    }

    private ArrayList<ImageClick> generateSample() {
        ArrayList<ImageClick> imagesView1 = new ArrayList<ImageClick>();
        ImageClick imageClick = new ImageClick();
        imageClick.setImageName("Beneath a Scarlet Sky");
        imageClick.setImageid(R.drawable.novel1);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("The Boy on the Wooden Box");
        imageClick.setImageid(R.drawable.novel2);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("The Life we Bury");
        imageClick.setImageid(R.drawable.novel3);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("Beneath a Scarlet Sky");
        imageClick.setImageid(R.drawable.novel1);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("The Boy on the Wooden Box");
        imageClick.setImageid(R.drawable.novel2);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("The Life we Bury");
        imageClick.setImageid(R.drawable.novel3);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("Beneath a Scarlet Sky");
        imageClick.setImageid(R.drawable.novel1);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("The Boy on the Wooden Box");
        imageClick.setImageid(R.drawable.novel2);
        imagesView1.add(imageClick);
        imageClick = new ImageClick();
        imageClick.setImageName("The Life we Bury");
        imageClick.setImageid(R.drawable.novel3);
        imagesView1.add(imageClick);
        return imagesView1;
    }
}
