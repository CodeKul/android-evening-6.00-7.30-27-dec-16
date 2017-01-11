package com.codekul.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customList();

    }

    private void customList() {
        List<MyItem> dataSet = new ArrayList<>();
        dataSet.add(new MyItem(R.drawable.ic_cycle,"Cycle"));
        dataSet.add(new MyItem(R.drawable.ic_buses,"Bus"));
        dataSet.add(new MyItem(R.drawable.ic_chopper,"Chopper"));
        dataSet.add(new MyItem(R.drawable.ic_suv,"SUV"));

        MyAdapter adapter = new MyAdapter(this,dataSet);

        ((ListView)findViewById(R.id.listMobiles)).setAdapter(adapter);

        /*final ListView listView = ((ListView)findViewById(R.id.listMobiles));
        listView.setAdapter(adapter);*/
    }


    private void simpleList() {
        List<String> dataSet = new ArrayList<>();
        dataSet.add("Android");
        dataSet.add("Apple");
        dataSet.add("Samsung");
        dataSet.add("BB");
        dataSet.add("Windows");
        dataSet.add("HTC");
        dataSet.add("motorola");
        dataSet.add("Lenevo");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,dataSet);

        final ListView listView = ((ListView)findViewById(R.id.listMobiles));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this::listItemClick);

        findViewById(R.id.btnAdd).setOnClickListener(v -> addClick(dataSet, adapter));
    }

    private void addClick(List<String> dataSet, ArrayAdapter<String> adapter) {
        dataSet.add(((EditText)findViewById(R.id.edtCompany)).getText().toString());
        adapter.notifyDataSetChanged();
    }

    private void listItemClick(AdapterView<?> adapterView, View view, int pos, long id) {
        if(adapterView instanceof ListView){
            ((EditText)findViewById(R.id.edtCompany))
                    .setText(((TextView)view).getText().toString());
        }
    }
}
