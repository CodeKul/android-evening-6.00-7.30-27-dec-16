package com.codekul.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aniruddha on 11/1/17.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<MyItem> dataSet;
    private LayoutInflater inflater;


    public MyAdapter(Context context, List<MyItem> dataSet){
        this.context = context;
        this.dataSet = dataSet;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return dataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflater.inflate(R.layout.list_item,null,false);
        ((ImageView)view.findViewById(R.id.imageIcon)).setImageResource(dataSet.get(position).getImageId());
        ((TextView)view.findViewById(R.id.textInfo)).setText(dataSet.get(position).getText());

        return view;
    }
}
