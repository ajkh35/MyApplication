package com.example.ajay.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setTextSize(40);
        tv.setText(message);

        GridView gv = (GridView) findViewById(R.id.gv);
        gv.setAdapter(new ImageAdapter(this));

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(),SingleViewActivity.class);
                i.putExtra("id",position);
                startActivity(i);
            }
        });
    }
}
