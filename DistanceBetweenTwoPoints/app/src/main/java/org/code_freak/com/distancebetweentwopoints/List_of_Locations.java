package org.code_freak.com.distancebetweentwopoints;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class List_of_Locations extends AppCompatActivity {
    public static String loccode;
     ListView lvLocations;
     ArrayList<String> arrayList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of__locations_layout);
        lvLocations = (ListView) findViewById(R.id.lvLocations);
        MakeAList();
    }
    public void MakeAList(){
        arrayList.add("Marathalli");
        arrayList.add("MG Road");
        arrayList.add("Koramangala");
        arrayList.add("HAL");
    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lvLocations.setAdapter(arrayAdapter);
        lvLocations.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView tvResult = (TextView)view;
                Toast.makeText(getBaseContext()," "+tvResult.getText().toString(),Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(),TwoLocation.class);
                intent.putExtra(loccode,tvResult.getText());
                startActivity(intent);
            }
        });

    }
}
