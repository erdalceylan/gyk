package com.example.gyk;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {

    private ArrayList<Newspaper> items = new ArrayList<Newspaper>();
    private ListView listView;
    private NewsAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_lis_view);

        items = new ArrayList<Newspaper>();
        listView = (ListView) findViewById(R.id.list);
        listViewAdapter = new NewsAdapter(NewsActivity.this, items);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(NewsActivity.this, WebViewActivity.class);
                intent.putExtra("url", items.get(position).getUrl());
                startActivity(intent);
            }
        });

        for (int i = 0; i < 20; i++) {
            Newspaper newspaper = new Newspaper( "https://isbh.tmgrup.com.tr/sbh/site/v3/i/favicon.png","Sabah ", "https://sabah.com.tr" );
            items.add(newspaper);
        }
    }
}
