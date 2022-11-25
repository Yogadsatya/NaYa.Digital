package com.nayadigital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataPhoto;
    private NayaAdapter adapter;
    private ArrayList<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new NayaAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, items.get(i).getName(), Toast.LENGTH_SHORT).show();
                if (i == 0) {
                    startActivity(new Intent(MainActivity.this, Asus.class));
                }else if (i == 1) {
                    startActivity(new Intent(MainActivity.this, Acer.class));
                }else {
                    startActivity(new Intent(MainActivity.this, Lenovo.class));
                }
            }
        });

    }

    private void prepare() {
        dataName = getResources(). getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        items = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            Item hero = new Item();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            items.add(hero);
        }
        adapter.setHeroes(items);
    }
}