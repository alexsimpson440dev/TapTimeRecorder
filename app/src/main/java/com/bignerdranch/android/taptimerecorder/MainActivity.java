package com.bignerdranch.android.taptimerecorder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adds button variable
        Button addNewTime = (Button) findViewById(R.id.current_time_button);
        //references ListView
        final ListView listView = (ListView) findViewById(R.id.time_listview);

        //data for list
        final ArrayList<String> currentTime = new ArrayList<String>();

        //Array adapter for context
        final ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, R.layout.time_listview, R.id.time_listview_text, currentTime);

        //Set this ArrayAdapter to be the listview's Adapter
        listView.setAdapter(arrayAdapter);

        addNewTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance(TimeZone.getTimeZone("CST"));
                Date currentLocalTime = c.getTime();
                DateFormat date = new SimpleDateFormat("HH:mm:ss a");
                date.setTimeZone(TimeZone.getTimeZone("CST"));
                String localTime = date.format(currentLocalTime);

                //adds the time to the list
                currentTime.add(localTime);
                //notifies adapter that the data has been changed.
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }
}
