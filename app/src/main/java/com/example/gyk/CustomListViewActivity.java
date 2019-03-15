package com.example.gyk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class CustomListViewActivity extends AppCompatActivity {

    private ArrayList<Item> items = new ArrayList<Item>();
    private ListView listView;
    private CustomListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lis_view);

        items = new ArrayList<Item>();
        listView = (ListView) findViewById(R.id.list);
        listViewAdapter = new CustomListViewAdapter(CustomListViewActivity.this, items);
        listView.setAdapter(listViewAdapter);

        for (int i = 0; i < 20; i++) {
            Item person = new Item( R.drawable.avatar,"Mr. Android " + i);
            items.add(person);
        }
    }
}
