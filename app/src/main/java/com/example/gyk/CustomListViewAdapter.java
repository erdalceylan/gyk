package com.example.gyk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListViewAdapter extends ArrayAdapter<Item> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private ArrayList<Item> items;

    public CustomListViewAdapter(Context context, ArrayList<Item> items) {
        super(context,0, items);
        this.context = context;
        this.items = items;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Item getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.custom_list_view_item, null);

            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.img = (ImageView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }

        Item person = items.get(position);
        if(person != null){
            holder.img.setImageResource(person.getImg());
            holder.text.setText(person.getText());

        }
        return convertView;
    }

    private static class ViewHolder {
        TextView text;
        ImageView img;

    }
}
