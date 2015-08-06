package com.example.ajay.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public final static String EXTRA_MESSAGE = "data";

    private AdapterView.OnItemClickListener mClickHandler = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String item = (String) parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(),item+" clicked",Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arr = {"abc","def","ghi","jkl","mno"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arr);
        ListView lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(mClickHandler);

        Button btSend = (Button) findViewById(R.id.bt_send);
        btSend.setOnClickListener(this);

        Button btn = (Button) findViewById(R.id.btn2);
        btn.setOnClickListener(this);
    }

    public void sendMessage(View v) {
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String message = editText.getText().toString();

        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivity(intent);
    }


    public void getResult(View v){
        Intent intent_result = new Intent(this, ResultActivity.class);
        startActivityForResult(intent_result,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.bt_send)
            sendMessage(v);
        else if(v.getId() == R.id.btn2)
            getResult(v);
        else{}
    }

}
