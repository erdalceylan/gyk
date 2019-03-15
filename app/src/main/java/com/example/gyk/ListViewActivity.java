package com.example.gyk;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ArrayList<String> superHeroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
/*        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        superHeroes.add("Wonder Woman");
        superHeroes.add("Thor");
        superHeroes.add("Captain America");
        superHeroes.add("Super Girl");
        superHeroes.add("Dünyayı Kurtaran Adam");

        ListView myList = (ListView) findViewById(R.id.list);


        final ArrayAdapter<String> listAdapter=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, superHeroes);

        final AlertDialog.Builder builder = new AlertDialog.Builder(ListViewActivity.this);
        builder.setTitle("Süper Kahraman");
        builder.setNegativeButton("Tamam", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                builder.setMessage(superHeroes.get(position));
                builder.show();
            }
        });


        myList.setAdapter(listAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listAdapter.add("Hero : "+ Math.random());
                listAdapter.notifyDataSetChanged();
            }
        });
    }

}
