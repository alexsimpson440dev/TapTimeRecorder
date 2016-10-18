package com.bignerdranch.android.taptimerecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //references ListView
        ListView listView = (ListView) findViewById(R.id.time_listview);

        //data for list
        ArrayList<Date> currentTime = new ArrayList<Date>();

        //Array adapter for context
        ArrayAdapter<Date> arrayAdapter =
                new ArrayAdapter<Date>(this, R.layout.time_listview, R.id.time_listview_text, currentTime);

        //Set this ArrayAdapter to be the listview's Adapter
        listView.setAdapter(arrayAdapter);
    }
}
