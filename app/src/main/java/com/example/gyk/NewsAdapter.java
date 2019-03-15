package com.example.gyk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<Newspaper> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder holder;
    private ArrayList<Newspaper> newspapers;

    public NewsAdapter(Context context, ArrayList<Newspaper> newspapers) {
        super(context,0, newspapers);
        this.context = context;
        this.newspapers = newspapers;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return newspapers.size();
    }

    @Override
    public Newspaper getItem(int position) {
        return newspapers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return newspapers.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            convertView = inflater.inflate(R.layout.news_item, null);

            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text);
            holder.img = (SimpleDraweeView) convertView.findViewById(R.id.img);
            convertView.setTag(holder);

        }
        else{
            //Get viewholder we already created
            holder = (ViewHolder)convertView.getTag();
        }

        Newspaper newspaper = newspapers.get(position);
        if(newspaper != null){
            holder.img.setImageURI(newspaper.getImg());
            holder.text.setText(newspaper.getText());

        }
        return convertView;
    }

    private static class ViewHolder {
        TextView text;
        SimpleDraweeView img;

    }
}
