package com.nayadigital;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NayaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Item> items;

    public void setHeroes(ArrayList<Item> heroes) {
        this.items = heroes;
    }

    public NayaAdapter(Context context) {
        this.context = context;
        items = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_naya,
                    viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder (view);
        Item item = (Item) getItem(i);
        viewHolder.bind(item);
        return view;
    }

    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind (Item item) {
            txtName.setText(item.getName());
            txtDescription.setText(item.getDescription());
            imgPhoto.setImageResource(item.getPhoto());
        }
    }
}
