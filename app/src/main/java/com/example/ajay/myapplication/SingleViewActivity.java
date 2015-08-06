package com.example.ajay.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class SingleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view);

        Intent i = getIntent();

        int position = i.getExtras().getInt("id");
        ImageAdapter imageadapter = new ImageAdapter(this);

        ImageView img = (ImageView) findViewById(R.id.img);
        img.setImageResource(imageadapter.mImages[position]);
    }
}
